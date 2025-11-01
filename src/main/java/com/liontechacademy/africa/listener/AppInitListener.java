package com.liontechacademy.africa.listener;
import javax.servlet.*; import javax.servlet.annotation.*; import java.sql.*; import com.liontechacademy.africa.util.DB;
@WebListener public class AppInitListener implements ServletContextListener {
public void contextInitialized(ServletContextEvent sce){ try(Connection c=DB.getConnection(); Statement st=c.createStatement()){
st.execute("CREATE TABLE IF NOT EXISTS countries (id IDENTITY PRIMARY KEY, code VARCHAR(3) UNIQUE, name VARCHAR(80))");
st.execute("CREATE TABLE IF NOT EXISTS routes (id IDENTITY PRIMARY KEY, origin VARCHAR(80), destination VARCHAR(80), country_id BIGINT)");
st.execute("CREATE TABLE IF NOT EXISTS buses (id IDENTITY PRIMARY KEY, operator VARCHAR(80), plate VARCHAR(40), seats INT, country_id BIGINT)");
st.execute("CREATE TABLE IF NOT EXISTS bookings (id IDENTITY PRIMARY KEY, country_id BIGINT, route_id BIGINT, bus_id BIGINT, full_name VARCHAR(120), travel_date DATE)");
st.execute("MERGE INTO countries KEY(code) VALUES ('NG','Nigeria'),('GH','Ghana'),('KE','Kenya'),('ZA','South Africa'),('EG','Egypt')");
st.execute("INSERT INTO routes(origin,destination,country_id) SELECT 'Lagos','Abuja',id FROM countries WHERE code='NG'");
st.execute("INSERT INTO routes(origin,destination,country_id) SELECT 'Accra','Kumasi',id FROM countries WHERE code='GH'");
st.execute("INSERT INTO routes(origin,destination,country_id) SELECT 'Nairobi','Mombasa',id FROM countries WHERE code='KE'");
st.execute("INSERT INTO routes(origin,destination,country_id) SELECT 'Johannesburg','Pretoria',id FROM countries WHERE code='ZA'");
st.execute("INSERT INTO routes(origin,destination,country_id) SELECT 'Cairo','Alexandria',id FROM countries WHERE code='EG'");
st.execute("INSERT INTO buses(operator,plate,seats,country_id) SELECT 'TransNG','NG-ABC-123',50,id FROM countries WHERE code='NG'");
st.execute("INSERT INTO buses(operator,plate,seats,country_id) SELECT 'GhanaWays','GH-XYZ-321',48,id FROM countries WHERE code='GH'");
st.execute("INSERT INTO buses(operator,plate,seats,country_id) SELECT 'KenyaRide','KAA-111A',52,id FROM countries WHERE code='KE'");
st.execute("INSERT INTO buses(operator,plate,seats,country_id) SELECT 'MzansiBus','GP-567-AB',55,id FROM countries WHERE code='ZA'");
st.execute("INSERT INTO buses(operator,plate,seats,country_id) SELECT 'NileCoach','EG-7777',50,id FROM countries WHERE code='EG'");
} catch(Exception e){ e.printStackTrace(); } }
}