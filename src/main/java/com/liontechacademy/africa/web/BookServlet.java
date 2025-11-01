package com.liontechacademy.africa.web;
import com.liontechacademy.africa.dao.*; import com.liontechacademy.africa.model.*;
import javax.servlet.*; import javax.servlet.annotation.*; import javax.servlet.http.*; import java.io.*; import java.sql.*; import java.time.*;
@WebServlet(name="BookServlet", urlPatterns={"/book"}) public class BookServlet extends HttpServlet {
private final CountryDao countryDao=new CountryDao(); private final RouteDao routeDao=new RouteDao(); private final BusDao busDao=new BusDao(); private final BookingDao bookingDao=new BookingDao();
protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{ try{
req.setAttribute("countries", countryDao.findAll()); String countryId=req.getParameter("countryId");
if(countryId!=null && !countryId.isEmpty()){ long cid=Long.parseLong(countryId); req.setAttribute("routes", routeDao.findByCountry(cid)); req.setAttribute("buses", busDao.findByCountry(cid)); }
req.getRequestDispatcher("/WEB-INF/views/book.jsp").forward(req,resp);
} catch(SQLException e){ throw new ServletException(e);} }
protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{ try{
long countryId=Long.parseLong(req.getParameter("countryId")); long routeId=Long.parseLong(req.getParameter("routeId"));
long busId=Long.parseLong(req.getParameter("busId")); String fullName=req.getParameter("fullName"); LocalDate date=LocalDate.parse(req.getParameter("travelDate"));
bookingDao.create(new Booking(null,countryId,routeId,busId,fullName,date)); resp.sendRedirect(req.getContextPath()+"/admin/bookings");
} catch(SQLException e){ throw new ServletException(e);} } }