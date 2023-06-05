<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.MutanteJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>RolJB</title>
	</head>
	
	<body>
	
	<jsp:useBean id="roljb" class="Modelo.RolJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
                <th>ID </th>
                <th>Rol </th>
                
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<RolJB> lista = (List<RolJB>) request.getAttribute("lista");
        if (lista != null){
        	for (RolJB rol : lista){
        %>
            <tr>
            	<td><%out.print(mut.getID_Rol()); %></td>
            	<td><%out.print(mut.getRol());%></td>
            	
            	
            	
        	</tr>
       	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>

    	
	</body>
	
</html>