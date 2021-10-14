package com.example.springboot;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {


	@Autowired
  private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		double maxStoreLat = 41.055783;
		double minStoreLat = 40.9632463;
		double maxStoreLng = 29.1244229;
		double minStoreLng = 28.6552262;

		//Construction objects for controller methods
		Courier courierObject = new Courier();
		Store storeObject = new Store();
		LocationLog locationLogObject = new LocationLog();
	
		List<Courier> couriers = courierObject.getAllCouriers(jdbcTemplate);

		List<Store> stores = storeObject.getAllStores(jdbcTemplate);

		System.out.println("Number of couriers available:" + couriers.size());
		couriers.forEach(System.out :: println);
		stores.forEach(System.out :: println);
		

		for(Store store : stores){
			for(Courier courier : couriers){
				System.out.println("Distance of " + courier.toString() + " to " + store.toString());
				System.out.println("\t" + distance(store.getLat(), courier.getLat(), store.getLng(), courier.getLng()) + " km");
			}
		}

		//=====================================================
		//########  Courier movement simulation ###############

		List<LocationLog> allLocationLogs = null;

		//This for loop simulates 300 seconds 
		for(int i = 0; i < 300; i++){
			changeLocationOfCouriers(couriers, maxStoreLat, minStoreLat, maxStoreLng, minStoreLng);

			for(Store store : stores){
				for(Courier courier : couriers){

					allLocationLogs = locationLogObject.getAllLocationLogs(jdbcTemplate);
					
					String withinRange = "false";
					//Check whether courier is in 10km range of the store
					if(distance(store.getLat(), courier.getLat(), store.getLng(), courier.getLng()) <= 10){
						withinRange = "true";
						int[] log = {courier.getId(), store.getId(), i};
						
						boolean newEntry = true;

						for (LocationLog locationLog2 : allLocationLogs) {
							if(locationLog2.getCourierId() == log[0] && locationLog2.getStoreId() == log[1] && (log[2] - locationLog2.getSecondTimeStamp()) < 60 && locationLog2.getWithinRange() == "true"){
								newEntry = false;
								break;
							}
						}

						//if this visit is not new, don't log 
						if(newEntry){
							System.out.println("Courier " + courier.getId() + " entered within 10km of Store" + store.getStoreName() + " at time " + i);		
						}	
					}
					locationLogObject.createLocationLog(jdbcTemplate, courier.getId(), store.getId(), i, courier.getLat(), courier.getLng(), withinRange);
				}
			}
			System.out.println("====================================================");
		}
		System.out.println("All travels finished");
		System.out.println(getTotalTravelDistance(2, allLocationLogs, courierObject, jdbcTemplate));

		//Cleaning the database for the next run
		locationLogObject.deleteAllLocationLogs(jdbcTemplate);
	}

	/**
	 * This method calculates total distance traveled by looking records in the database
	 * @param courierId 
	 * @param allLocationLogs All location logs from databse
	 * @param courierObject 
	 * @param jdbcTemplate 
	 * @return
	 */
	public static double getTotalTravelDistance(int courierId, List<LocationLog> allLocationLogs, Courier courierObject, JdbcTemplate jdbcTemplate){
		double totalTravelDistance = 0;
		
		//Use this for adding first travel distance
		Courier thisCourier = courierObject.getCourierById(jdbcTemplate, courierId);

		totalTravelDistance = distance(thisCourier.getLat(), allLocationLogs.get(0).getCourierLat(), thisCourier.getLng(), allLocationLogs.get(0).getCourierLng());

		LocationLog tempCourierLog1 = allLocationLogs.get(0);
		LocationLog tempCourierLog2;

		for (LocationLog locationLog : allLocationLogs) {
			tempCourierLog2 = locationLog;
			if(locationLog.getCourierId() == courierId){
				totalTravelDistance += distance(tempCourierLog1.getCourierLat(), tempCourierLog2.getCourierLat(), tempCourierLog1.getCourierLng(), tempCourierLog2.getCourierLng());
			}
			tempCourierLog1 = locationLog;
		}
		return totalTravelDistance;
	}

	/**
	 * This method gives a sense of time stream by changing locations of couriers
	 * @param couriers Couriers which their locations to be changed
	 * @param maxLat 
	 * @param minLat
	 * @param maxLng
	 * @param minLng
	 */
	public static void changeLocationOfCouriers(List<Courier> couriers, double maxLat, double minLat, double maxLng, double minLng){
		for(Courier courier : couriers){
			double randomLatChange = Math.random() * (maxLat - minLat + 1) + minLat;//0.01 - 0.005;
			double randomLngChange = Math.random() * (maxLng - minLng + 1) + minLng;
			courier.setLat(randomLatChange);
			courier.setLng(randomLngChange);
		}
	}

	/**
	 * This method calculates distance between two points given as latitude and longtitude
	 * @param lat1 double
	 * @param lat2 double
	 * @param lon1 double
	 * @param lon2 double
	 * @return Distance between two points provided with parameters
	 */
	public static double distance(double lat1, double lat2, double lon1, double lon2)
	{
		// Degrees to radians
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2)
							+ Math.cos(lat1) * Math.cos(lat2)
							* Math.pow(Math.sin(dlon / 2),2);
					
		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers
		double r = 6371;

		// calculate the distance
		return(c * r);
	}

}