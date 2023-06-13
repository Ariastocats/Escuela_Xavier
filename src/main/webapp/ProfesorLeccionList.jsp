<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.ProfesorJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>ProfesorLeccioneslistaJB</title>
	</head>
	
	<body>
	<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 
	
	<jsp:useBean id="profesorleccionesjb" class="Modelo.ProfesorJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
            	<th>Matricula de Profesor </th>
                <th>Nombre </th>
                <th>Leccion </th>
                <th>Tipo de Leccion </th>
                <th>Remuneracion </th>
                
                
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<ProfesorJB> lista = (List<ProfesorJB>) request.getAttribute("lista");
        if (lista != null){
        	for (ProfesorJB prof : lista){
        %>
            <tr>
            	<td><%out.print(prof.getMatricula_P());%></td>
            	<td><%out.print(prof.getNombre());%></td>
            	<td><%out.print(prof.getLeccion());%></td>
            	<td><%out.print(prof.getLecciont());%></td>
            	<td><%out.print(prof.getRemuneracion());%></td>
            	
        	</tr>
       	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>
        
        <form action="ServletCursoProf" method="get">
<!-- 		 <input id="busclec" type="text" name="id_leccion"> -->
		  <input id="btbusclec" type="submit" value="Agregar profesor al curso">
		</form>

    	
	</body>
	
</html>