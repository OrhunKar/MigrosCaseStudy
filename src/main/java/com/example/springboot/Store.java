package com.example.springboot;

import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Store {

  private int id;
  private String storeName;
  private double lat;
  private double lng;


  //This methods can be moved to another class for better design
  //Controller methods
  public List<Store> getAllStores(JdbcTemplate jdbcTemplate){
    String getAllStoreSQL = "SELECT * FROM stores";
    List<Store> stores = jdbcTemplate.query(getAllStoreSQL,
            BeanPropertyRowMapper.newInstance(Store.class));
   return stores;
  }


  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public void setStoreName(String storeName){
    this.storeName = storeName;
  }

  public String getStoreName(){
    return storeName;
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

  public String toString(){
    return "Store info ==> name: " + storeName + " id: " + id + " lat: " + lat + " lng: " + lng;
  }
}
