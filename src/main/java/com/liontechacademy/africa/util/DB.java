package com.liontechacademy.africa.util;
import java.sql.*; public class DB { private static final String URL="jdbc:h2:mem:africabus;DB_CLOSE_DELAY=-1"; 
public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL,"sa",""); } }