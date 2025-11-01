package com.liontechacademy.africa.web;
import com.liontechacademy.africa.dao.BookingDao; import javax.servlet.*; import javax.servlet.annotation.*; import javax.servlet.http.*; import java.io.*; import java.sql.*;
@WebServlet(name="AdminServlet", urlPatterns={"/admin/bookings"}) public class AdminServlet extends HttpServlet {
private final BookingDao bookingDao=new BookingDao();
protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{ try{
req.setAttribute("bookings", bookingDao.findAll()); req.getRequestDispatcher("/WEB-INF/views/bookings.jsp").forward(req,resp);
} catch(SQLException e){ throw new ServletException(e);} } }