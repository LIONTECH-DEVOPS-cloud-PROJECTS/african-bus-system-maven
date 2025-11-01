package com.liontechacademy.africa.dao;
import com.liontechacademy.africa.model.Country; import com.liontechacademy.africa.util.DB;
import java.sql.*; import java.util.*; public class CountryDao {
public List<Country> findAll() throws SQLException { String sql="SELECT id,code,name FROM countries ORDER BY name";
try(Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){
List<Country> list=new ArrayList<>(); while(rs.next()){ list.add(new Country(rs.getLong(1),rs.getString(2),rs.getString(3))); } return list; } } }