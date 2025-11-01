<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>All Bookings</title><style>body{font-family:system-ui,Segoe UI,Roboto,Arial,sans-serif;margin:2rem}table{border-collapse:collapse;width:100%}td,th{border:1px solid #eee;padding:.5rem}.top a{margin-right:10px}</style></head>
<body><div class="top"><a href="${pageContext.request.contextPath}/">Home</a><a href="${pageContext.request.contextPath}/book">New Booking</a></div>
<h1>All Bookings</h1><table><thead><tr><th>ID</th><th>CountryId</th><th>RouteId</th><th>BusId</th><th>Name</th><th>Date</th></tr></thead>
<tbody><c:forEach var="b" items="${bookings}"><tr><td>${b.id}</td><td>${b.countryId}</td><td>${b.routeId}</td><td>${b.busId}</td><td>${b.fullName}</td><td>${b.travelDate}</td></tr></c:forEach></tbody></table>
</body></html>