<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.ProfesorJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>ProfesorJB</title>
	</head>
	
	<body>
	
	<jsp:useBean id="profesorjb" class="Modelo.ProfesorJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
            	<th>Matricula de Profesor </th>
                <th>curp </th>
                <th>Nombre </th>
                <th>Apellido Paterno </th>
                <th>Apellido Materno </th>
                <th>Habilidad </th>
                <th>Alias </th>
                <th>Fecha de nacimiento </th>
                <th>celular </th>
                <th>Rol </th>
                
              
                <th>Tipo de Profesor </th>
             
<!--                  <th>Status </th> -->
                
                
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
            	<td><%out.print(prof.getCurp()); %></td>
            	<td><%out.print(prof.getNombre());%></td>
            	<td><%out.print(prof.getApellido_Pat());%></td>
            	<td><%out.print(prof.getApellido_Mat());%></td>
            	<td><%out.print(prof.getPoder()); %></td>
            	<td><%out.print(prof.getN_Alias());%></td>
            	<td><%out.print(prof.getFecha_nac());%></td>
            	<td><%out.print(prof.getCel());%></td>
            	
            	<td><%out.print(prof.getRols());%></td>
            	
            	
            	<td><%out.print(prof.getT_Profesor());%></td>
            
<%--             	<td><%out.print(prof.getStatus());%></td> --%>
            	
            	
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