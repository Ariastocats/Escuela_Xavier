<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.PresentacionesJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>PresentacionesJB</title>
	</head>
	
	<body>
	
	<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		
	
	<jsp:useBean id="presentacionesjb" class="Modelo.PresentacionesJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
                <th>Id de presentacion </th>
                <th>Presentacion </th>
                <th>Dia </th>
                <th>Horario</th>
                <th>Asistencias </th>
               
                
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
            	<td><%out.print(pres.getAsist()); %></td>
            	
            	
        	</tr>
       	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>
        <form action="ServletParticipantes" method="get">
 		<input id="buscpart" type="text" name="n_presentacion"> 
		  <input id="btbuspart" type="submit" value="ver los participantes">
		</form>
		
		 <form action="ServletAsistPresentaciones" method="get">
		  <input id="btbuscasis" type="submit" value="Agregar nuevo participante">
		</form>
        
		
	</body>
	
</html>