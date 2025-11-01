package com.liontechacademy.africa.model;
public class Bus { private Long id; private String operator; private String plate; private int seats; private Long countryId;
public Bus(){} public Bus(Long id,String operator,String plate,int seats,Long countryId){this.id=id;this.operator=operator;this.plate=plate;this.seats=seats;this.countryId=countryId;}
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public String getOperator(){return operator;} public void setOperator(String operator){this.operator=operator;}
public String getPlate(){return plate;} public void setPlate(String plate){this.plate=plate;}
public int getSeats(){return seats;} public void setSeats(int seats){this.seats=seats;}
public Long getCountryId(){return countryId;} public void setCountryId(Long countryId){this.countryId=countryId;} }