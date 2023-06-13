<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.PresentacionesJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>PresentacionesJB</title>
	</head>
	
	<body>
	
	<jsp:useBean id="presentacionesjb" class="Modelo.PresentacionesJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
                <th>Id de presentacion </th>
                <th>Presentacion </th>
                <th>Dia </th>
                <th>Horario</th>
               
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<PresentacionesJB> lista = (List<PresentacionesJB>) request.getAttribute("lista");
        if (lista != null){
        	for (PresentacionesJB pres : lista){
        %>
            <tr>
            	<td><%out.print(pres.getN_Presentacion()); %></td>
            	<td><%out.print(pres.getPresentacion());%></td>
            	<td><%out.print(pres.getDia());%></td>
            	<td><%out.print(pres.getHorario());%></td>
            	
            	
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