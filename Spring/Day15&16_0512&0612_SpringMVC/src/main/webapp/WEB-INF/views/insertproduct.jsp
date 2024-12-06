<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertProduct" method="post">
	Product Id : <input type ="text" name = "pid" id = "pid"> <br>
	Product name : <input type ="text" name = "pname" id = "pname"> <br>
	Product qty : <input type ="number" name = "qty" id = "qty"> <br>
	Product price : <input type ="number" name = "price" id = "price"> <br>
	Exp Date : <input type ="date" name = "date" id = "date"> <br>
	Category Id : <input type ="number" name = "cid" id = "cid"> <br>
	
	<button type="submit" name="btn" id="insert">Add new Product</button>
	</form>
</body>
</html>