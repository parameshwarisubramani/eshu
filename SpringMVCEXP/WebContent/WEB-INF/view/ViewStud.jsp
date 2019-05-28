<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewStud</title>
</head>
<body>


${b}
<c:if test="${not empty a}">
		<table border="1">
			<tr>
			<th> <h4 >StudId</h4></th>
				<th><h4 >StudName</h4></th>
				<th><h4 >StudAddress</h4></th>
				<th><h4 >StudEmail</h4></th>
				
			
				<c:forEach var="listValue" items="${a}">
<tr>
					<td><h4 > <c:out value="${listValue.id}" /> <br></h4></td>
					<td><h4 ><c:out value="${listValue.studName}" /><br></h4></td>
					<td><h4 ><c:out value="${listValue.studAdd}" /><br></h4></td>
					<td><h4 ><c:out value="${listValue.studMail}" /><br></h4></td>
					<td><h4 ><a href="edit/${listValue.id}">Edit</a> <br></h4></td>
		<td><h4 ><a href="delete/${listValue.id}">Delete</a> <br></h4></td>	
									
					</tr>
			</c:forEach>
			
		</table>
	</c:if>
</body>
</html>