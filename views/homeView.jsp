<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Quickxo - Home</title>
		<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	</head>
	<body>
		<h2>Welcome to Quickxo MVC !</h2>
		
		<%@page import="com.quickxo.controllers.commands.classes.DbCheckBean" %>  
		<%  DbCheckBean dBBean = (DbCheckBean)request.getAttribute("dBBean"); %>
		
		<table style="border: none;">
	  		<tr>
	  			<td>Connected to database:</td> 
	    		<td><%= dBBean.getDbName() %></td>    		
	  		</tr>
	  		<tr>
	  			<td>Driver name:</td> 
	    		<td><%= dBBean.getDriverName() %></td>    		
	  		</tr>  		
	  		<tr>
	  			<td>Driver version:</td> 
	  			<td><%= dBBean.getDriverVersion() %></td>   		
	  		</tr>  		  
	  		<tr>
	  			<td>Database URL:</td> 
	    		<td><%= dBBean.getDbUrl() %></td>    		
	  		</tr> 	  		
	  		<tr>
	  			<td>Database tables</td> 
	  		<%
	        for (String tableName:dBBean.getTableNames())
	        {
	            out.print("<td>" + tableName + "</td>");	        		  		
	  			out.print("</tr>");
	  			out.print("<tr>");
	  			out.print("<td></td>");
	        }
	  		%>	  
	  			<td></td>		
	  		</tr>		
		</table>		  
	</body>
</html>