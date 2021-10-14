package com.example.springboot;

import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LocationLog {

  private int courierId;
  private int storeId;
  private int secondTimeStamp;
  private double courierLat;
  private double courierLng;
  private String withinRange;

  //This methods can be moved to another class for better design
  //Controller methods
  public List<LocationLog> getAllLocationLogs(JdbcTemplate jdbcTemplate){
    String getAllLocationLogSQL = "SELECT * FROM locationLog";
    List<LocationLog> locationLogs = jdbcTemplate.query(getAllLocationLogSQL,
            BeanPropertyRowMapper.newInstance(LocationLog.class));
   return locationLogs;
  }

  public void createLocationLog(JdbcTemplate jdbcTemplate, int courierId, int storeId, int secondTimeStamp, double courierLat, double courierLng, String withinRange){
    String createLocationLogSQL = "insert into locationLog(courierId, storeId, secondTimeStamp, courierLat, courierLng, withinRange) "
                                    + "values(" + courierId + "," + storeId + "," + secondTimeStamp + "," + courierLat + "," + courierLng + "," + "'" + withinRange + "')";
    jdbcTemplate.execute(createLocationLogSQL);
  }

  public void deleteAllLocationLogs(JdbcTemplate jdbcTemplate){
    String deleteAllLocationLogsSQL = "delete from locationLog";
    jdbcTemplate.execute(deleteAllLocationLogsSQL);
  }

  public int getCourierId(){
    return courierId;
  }

  public void setCourierId(int courierId){
    this.courierId = courierId;
  }

  public void setStoreId(int storeId){
    this.storeId = storeId;
  }

  public int getStoreId(){
    return storeId;
  }

  public int getSecondTimeStamp(){
    return secondTimeStamp;
  }

  public void setSecondTimeStamp(int secondTimeStamp){
    this.secondTimeStamp = secondTimeStamp;
  }

  public double getCourierLat(){
    return courierLat;
  }

  public void setCourierLat(double courierLat){
    this.courierLat = courierLat;
  }

  public double getCourierLng(){
    return courierLng;
  }

  public void setCourierLng(double courierLng){
    this.courierLng = courierLng;
  }

  public String getWithinRange(){
    return withinRange;
  }

  public void setWithinRange(String withinRange){
    this.withinRange = withinRange;
  }

  public String toString(){
    return "";
  }
}
