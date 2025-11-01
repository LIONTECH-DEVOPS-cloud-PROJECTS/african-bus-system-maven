<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Book a Bus</title><style>body{font-family:system-ui,Segoe UI,Roboto,Arial,sans-serif;margin:2rem}.card{max-width:900px;border:1px solid #eee;padding:1rem;border-radius:10px;box-shadow:0 1px 6px rgba(0,0,0,.06)}select,input,button{padding:.5rem;margin:.3rem 0}</style></head>
<body><div class="card"><h1>Book a Bus</h1>
<form method="get" action="${pageContext.request.contextPath}/book">
<label>Country of Residence</label><br/>
<select name="countryId" onchange="this.form.submit()">
<option value="">-- Select your country --</option>
<c:forEach var="c" items="${countries}"><option value="${c.id}" ${param.countryId == c.id ? 'selected' : ''}>${c.name}</option></c:forEach>
</select></form>
<c:if test="${not empty routes}"><form method="post" action="${pageContext.request.contextPath}/book">
<input type="hidden" name="countryId" value="${param.countryId}" />
<label>Route</label><br/><select name="routeId" required><c:forEach var="r" items="${routes}"><option value="${r.id}">${r.origin} → ${r.destination}</option></c:forEach></select><br/>
<label>Bus/Operator</label><br/><select name="busId" required><c:forEach var="b" items="${buses}"><option value="${b.id}">${b.operator} — ${b.plate} (${b.seats} seats)</option></c:forEach></select><br/>
<label>Your Full Name</label><br/><input name="fullName" required placeholder="e.g., Ama Mensah"/><br/>
<label>Travel Date</label><br/><input type="date" name="travelDate" required/><br/><br/>
<button type="submit">Confirm Booking</button></form></c:if></div></body></html>