<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.MutanteJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>MutanteJB</title>
	</head>
	
	<body>
	
	<jsp:useBean id="mutantejb" class="Modelo.MutanteJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
                <th>curp </th>
                <th>Nombre </th>
                <th>Apellido Paterno </th>
                <th>Apellido Materno </th>
                <th>Habilidad </th>
                <th>Alias </th>
                <th>Fecha de nacimiento </th>
                <th>celular </th>
                <th>Direccion </th>
                <th>Rol </th>
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<MutanteJB> lista = (List<MutanteJB>) request.getAttribute("lista");
        if (lista != null){
        	for (MutanteJB mut : lista){
        %>
            <tr>
            	<td><%out.print(mut.getCurp()); %></td>
            	<td><%out.print(mut.getNombre());%></td>
            	<td><%out.print(mut.getApellido_Pat());%></td>
            	<td><%out.print(mut.getApellido_Mat());%></td>
            	<td><%out.print(mut.getPoder()); %></td>
            	<td><%out.print(mut.getN_Alias());%></td>
            	<td><%out.print(mut.getFecha_nac());%></td>
            	<td><%out.print(mut.getCel());%></td>
            	<td><%out.print(mut.getDirecc()); %></td>
            	<td><%out.print(mut.getRols());%></td>
            	
            	
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