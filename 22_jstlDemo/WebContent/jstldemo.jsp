<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="Income" scope="session" value="${4000*4}"/>  
	<c:out value="${Income}"/>  
	
	<c:catch var ="catchtheException">  
   <% int x = 2/0;%>  
</c:catch>  
  
<c:if test = "${catchtheException != null}">  
   <p>The type of exception is : ${catchtheException} <br />  
   There is an exception: ${catchtheException.message}</p>  
</c:if>  

	<c:set var="number" value="4"> </c:set>
	
	<c:if test="${number%2==0 }">
		<c:out value="Even"></c:out>
	</c:if>
	
	<c:choose>
		<c:when test="${number%2==0 }">Even</c:when>
		<c:otherwise>oDD</c:otherwise>
	</c:choose>
	
	<c:forEach var="j" begin="1" end="3">  
   	Item <c:out value="${j}"/><p>  
	</c:forEach>
	
	<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens>   


	<c:url value="/RegisterDao.jsp"/>  
</body>
</html>