<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

      <%@ include file="header.jsp" %>
      
      <c:forEach var="name"  items="${nameList}" >
      
      <a href="resources/imgs/${name}" target="_blank">
         <img alt="" src="resources/imgs/${name}"  width="200px;" height="200px;">
      </a>
      
      
      </c:forEach>

</body>
</html>