package com.example.springboot;

import java.util.Date;
import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Courier {
  
  //Properties
  private int id;
  private double lat;
  private double lng;
  private Date dateTimeStamp;


  //This methods can be moved to another class for better design
  //Controller methods
  public List<Courier> getAllCouriers(JdbcTemplate jdbcTemplate){
    String getAllCouriersSQL = "SELECT * FROM couriers";
    List<Courier> couriers = jdbcTemplate.query(getAllCouriersSQL,
            BeanPropertyRowMapper.newInstance(Courier.class));
    return couriers;
  }

  public Courier getCourierById(JdbcTemplate jdbcTemplate, int courierId){
    String getCourierSQL = "SELECT * FROM couriers where Id = " + courierId;
    Courier courier = jdbcTemplate.query(getCourierSQL,
            BeanPropertyRowMapper.newInstance(Courier.class)).get(0);
    return courier;
  }


  //getter and setters
  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public double getLat(){
    return lat;
  }

  public void setLat(double lat){
    this.lat = lat;
  }

  public double getLng(){
    return lng;
  }

  public void setLng(double lng){
    this.lng = lng;
  }

  public Date getDateTimeStamp(){
    return dateTimeStamp;
  }

  public void setDateTimeStamp(Date dateTimeStamp){
    this.dateTimeStamp = dateTimeStamp;
  }

  //To string method for information output
  public String toString(){
    return "Courier info ==> id: " + id + " lat: " + lat + " lng: " + lng + " Time: " + dateTimeStamp;
  }
}
