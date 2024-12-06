<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ='2'>
	<tr>
	 <th>product id</th>
	 <th>name</th>
	 <th>qty</th>
	 <th>price</th>
	 <th>Exp date</th>
	 <th>cid</th>
	 <th>actions</th>
	 </tr>
	 
	 <c:forEach var="prod" items="{plist}">
	 <tr>
	 	<td>${prod.pid}</td>
	 	<td>${prod.pname}</td>
	 	<td>${prod.qty}</td>
	 	<td>${prod.price}</td>
	 	<td>${prod.date}</td>
	 	<td>${prod.cid}</td>
	 	<td>
	 		<a href ="editproduct/${prod.pid}">edit</a>/
	 		<a href ="deleteproduct/${prod.pid}">delete</a>
	 	</td>
	 </tr>
	 </c:forEach>
	</table>
	
	<form action="addproduct">
		<button type="submit" name= "btn" id= "add">Add new product</button>
	</form>
</body>
</html>