<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.LeccionesJB" %>
<%@ page import="Modelo.EstudianteJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>curso</title>
	</head>
	
	<body>
	
	<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletLeccionesList" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>
	
	<jsp:useBean id="leccionesjb" class="Modelo.LeccionesJB" scope="request"/>
	<jsp:useBean id="estudiantejb" class="Modelo.EstudianteJB" scope="request"/>
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
		List<LeccionesJB> listalec = (List<LeccionesJB>) request.getAttribute("listalec");
        if (listalec != null){
        	for (LeccionesJB lec : listalec){
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
        
        <table width="100%">
		
		<thead>
            <tr>
           	 	<th>Matricula de Estudiante </th>
                <th>curp </th>
                <th>Nombre </th>
                <th>Apellido Paterno </th>
                <th>Apellido Materno </th>
                <th>Habilidad </th>
                <th>Alias </th>
             
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<EstudianteJB> listaest = (List<EstudianteJB>) request.getAttribute("listaest");
        if (listaest != null){
        	for (EstudianteJB est : listaest){
        %>
            <tr>
            	<td><%out.print(est.getMatricula());%></td>
            	<td><%out.print(est.getCurp()); %></td>
            	<td><%out.print(est.getNombre());%></td>
            	<td><%out.print(est.getApellido_Pat());%></td>
            	<td><%out.print(est.getApellido_Mat());%></td>
            	<td><%out.print(est.getPoder()); %></td>
            	<td><%out.print(est.getN_Alias());%></td>
      
            	
            	
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
		
		<form action="EstudiantesAgregar.jsp">
		 <input id="agregarest" type="submit" value="Agregar nuevo Estudiante">
		</form>
		
		
		 <form action="ServletCursoAgregar" method="post">
		  <label for="Matricula">Matricula:</label>
		 <input id="agest" type="text" name="matricula">
		  <label for="idlecion">Id de la leccion:</label>
		 <input id="aglec" type="text" name="id_leccion">
		 <label for="cal">Calificacion:</label>
		 <input id="agcal" type="text" name="calificacion">
		 <input id="agregarlec" type="submit" value="Agregar curso">
		</form>
		
		<br>
		  <%
               String mensaje = (String) request.getAttribute("mensaje"); 
                 if (mensaje != null && !mensaje.isEmpty()) { 
                %> 
                    <p><%= mensaje %></p>
                <% } %>
                <br>
		
		<table width="100%">
		
		<thead>
            <tr>
            	<th>Matricula de estudiante </th>
                <th>Estudiante </th>
                <th>Leccion </th>
                <th>Creditos </th>
                <th>Calificacion </th>
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<LeccionesJB> listacur = (List<LeccionesJB>) request.getAttribute("listacur");
        if (listacur != null){
        	for (LeccionesJB lec : listacur){
        %>
            <tr>
            	<td><%out.print(lec.getMatri()); %></td>
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