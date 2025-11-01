package com.liontechacademy.africa.dao;
import com.liontechacademy.africa.model.Booking; import com.liontechacademy.africa.util.DB;
import java.sql.*; import java.time.*; import java.util.*; public class BookingDao {
public void create(Booking b) throws SQLException { String sql="INSERT INTO bookings(country_id,route_id,bus_id,full_name,travel_date) VALUES(?,?,?,?,?)";
try(Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){ ps.setLong(1,b.getCountryId()); ps.setLong(2,b.getRouteId()); ps.setLong(3,b.getBusId());
ps.setString(4,b.getFullName()); ps.setDate(5,Date.valueOf(b.getTravelDate())); ps.executeUpdate(); } }
public List<Booking> findAll() throws SQLException { String sql="SELECT id,country_id,route_id,bus_id,full_name,travel_date FROM bookings ORDER BY id DESC";
try(Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()){
List<Booking> list=new ArrayList<>(); while(rs.next()){ list.add(new Booking(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getDate(6).toLocalDate())); } return list; } } }