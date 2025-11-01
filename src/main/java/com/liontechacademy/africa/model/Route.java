package com.liontechacademy.africa.model;
public class Route { private Long id; private String origin; private String destination; private Long countryId;
public Route(){} public Route(Long id,String origin,String destination,Long countryId){this.id=id;this.origin=origin;this.destination=destination;this.countryId=countryId;}
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public String getOrigin(){return origin;} public void setOrigin(String origin){this.origin=origin;}
public String getDestination(){return destination;} public void setDestination(String destination){this.destination=destination;}
public Long getCountryId(){return countryId;} public void setCountryId(Long countryId){this.countryId=countryId;} }