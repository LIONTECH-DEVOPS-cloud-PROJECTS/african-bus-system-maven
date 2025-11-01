package com.liontechacademy.africa.dao;
import com.liontechacademy.africa.model.Route; import com.liontechacademy.africa.util.DB;
import java.sql.*; import java.util.*; public class RouteDao {
public List<Route> findByCountry(long countryId) throws SQLException { String sql="SELECT id,origin,destination,country_id FROM routes WHERE country_id=? ORDER BY origin";
try(Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){ ps.setLong(1,countryId);
try(ResultSet rs=ps.executeQuery()){ List<Route> list=new ArrayList<>(); while(rs.next()){ list.add(new Route(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getLong(4))); } return list; } } } }