package com.liontechacademy.africa.dao;
import com.liontechacademy.africa.model.Bus; import com.liontechacademy.africa.util.DB;
import java.sql.*; import java.util.*; public class BusDao {
public List<Bus> findByCountry(long countryId) throws SQLException { String sql="SELECT id,operator,plate,seats,country_id FROM buses WHERE country_id=? ORDER BY operator";
try(Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){ ps.setLong(1,countryId);
try(ResultSet rs=ps.executeQuery()){ List<Bus> list=new ArrayList<>(); while(rs.next()){ list.add(new Bus(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getLong(5))); } return list; } } } }