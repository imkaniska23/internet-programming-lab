<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="empcore"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="empsql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database JSP Insert</title>
</head>
<body>
 
 <empsql:setDataSource var="emp" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/Emp"
     user="user"  password="password"/>
     
     <empsql:update dataSource="${emp}" var="empvar">
INSERT INTO Emp VALUES (3, 'emp emp3');
</empsql:update>
 
 
 
</body>
</html>