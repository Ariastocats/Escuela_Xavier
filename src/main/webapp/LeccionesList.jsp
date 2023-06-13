<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.LeccionesJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>LeccionesJB</title>
	</head>
	
	<body>
	<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
	
	<jsp:useBean id="leccionesjb" class="Modelo.LeccionesJB" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
            	<th>ID de Leccion </th>
            	<th>Leccion </th>
            	<th>Hora de inicio </th>
            	<th>Hora de Salida </th>
                <th>Creditos </th>
                <th>Tipo de Leccion </th>
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<LeccionesJB> lista = (List<LeccionesJB>) request.getAttribute("lista");
        if (lista != null){
        	for (LeccionesJB lec : lista){
        %>
            <tr>
            	<td><%out.print(lec.getID_Leccion()); %></td>
            	<td><%out.print(lec.getLeccion()); %></td>
            	<td><%out.print(lec.getHora_Ini());%></td>
            	<td><%out.print(lec.getHora_Fin());%></td>
            	<td><%out.print(lec.getCreditos());%></td>
            	<td><%out.print(lec.getTipoleccion());%></td>
            	
            	
            	
        	</tr>
       	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>
        
        <form action="ServletLeccionesOpcion" method="get">
		 <input id="agregarlec" type="submit" value="Agregar nueva Leccion">
		</form>
		
		<form action="ServletEliminarLecciones" method="get">
		 <input id="elimlec" type="text" name="id_leccion">
		  <input id="btelimlec" type="submit" value="Elimnar leccion">
		</form>
		
		<form action="ServletBuscarLeccion" method="get">
		 <input id="busclec" type="text" name="id_leccion">
		  <input id="btbusclec" type="submit" value="Modificar leccion">
		</form>
		
		<form action="ServletCurso" method="get">
<!-- 		 <input id="busclec" type="text" name="id_leccion"> -->
		  <input id="btbusclec" type="submit" value="Agregar alumno al curso">
		</form>
		
		<form action="ServletCursoProf" method="get">
<!-- 		 <input id="busclec" type="text" name="id_leccion"> -->
		  <input id="btbusclec" type="submit" value="Agregar profesor al curso">
		</form>
		
		
    	
	</body>
	
</html>