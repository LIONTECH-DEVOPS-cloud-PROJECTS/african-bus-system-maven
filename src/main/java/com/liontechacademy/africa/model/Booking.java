package com.liontechacademy.africa.model;
import java.time.LocalDate;
public class Booking { private Long id; private Long countryId; private Long routeId; private Long busId; private String fullName; private LocalDate travelDate;
public Booking(){} public Booking(Long id,Long countryId,Long routeId,Long busId,String fullName,LocalDate travelDate){this.id=id;this.countryId=countryId;this.routeId=routeId;this.busId=busId;this.fullName=fullName;this.travelDate=travelDate;}
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public Long getCountryId(){return countryId;} public void setCountryId(Long countryId){this.countryId=countryId;}
public Long getRouteId(){return routeId;} public void setRouteId(Long routeId){this.routeId=routeId;}
public Long getBusId(){return busId;} public void setBusId(Long busId){this.busId=busId;}
public String getFullName(){return fullName;} public void setFullName(String fullName){this.fullName=fullName;}
public LocalDate getTravelDate(){return travelDate;} public void setTravelDate(LocalDate travelDate){this.travelDate=travelDate;} }