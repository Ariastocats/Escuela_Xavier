<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.LeccionesJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>LeccionesJB</title>
	</head>
	
	<body>
	
	<jsp:useBean id="leccionesjb" class="Modelo.LeccionesJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
                <th>Estudiante </th>
                <th>Leccion </th>
                <th>Creditos </th>
                <th>Calificacion </th>
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<LeccionesJB> lista = (List<LeccionesJB>) request.getAttribute("lista");
        if (lista != null){
        	for (LeccionesJB lec : lista){
        %>
            <tr>
            	<td><%out.print(lec.getNombre()); %></td>
            	<td><%out.print(lec.getLeccion());%></td>
            	<td><%out.print(lec.getCreditos());%></td>
            	<td><%out.print(lec.getCalif());%></td>
            	
            	
            	
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