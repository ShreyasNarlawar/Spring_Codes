<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Day15_0512_SpringMVC/product/updateProduct" method="post">
	Product Id : <input type ="text" name = "pid" id = "pid" value="${prod.pid }"readonly> <br>
	Product name : <input type ="text" name = "pname" id = "pname" value="${prod.pname}"> <br>
	Product qty : <input type ="text" name = "qty" id = "qty"value="${prod.qty}"> <br>
	Product price : <input type ="text" name = "price" id = "price"value="${prod.price}"> <br>
	Exp Date : <input type ="text" name = "date" id = "date"value="${prod.date}"> <br>
	Category Id : <input type ="text" name = "cid" id = "cid"value="${prod.cid}"> <br>
	
	<button type="submit" name="btn" id="insert">update Product</button>
	</form>
</body>
</html>