<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.LeccionesJB" %>
<%@ page import="Modelo.ProfesorJB" %>
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
	<jsp:useBean id="profesorjb" class="Modelo.ProfesorJB" scope="request"/>
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
           	 	<th>Matricula de Profesor </th>
                <th>curp </th>
                <th>Nombre </th>
                <th>Apellido Paterno </th>
                <th>Apellido Materno </th>
                <th>Habilidad </th>
                <th>Alias </th>
                 <th>Remuneracion </th>
                <th>Tipo de Profesor </th>
             
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<ProfesorJB> listaprof = (List<ProfesorJB>) request.getAttribute("listaprof");
        if (listaprof != null){
        	for (ProfesorJB prof : listaprof){
        %>
            <tr>
            	<td><%out.print(prof.getMatricula_P());%></td>
            	<td><%out.print(prof.getCurp()); %></td>
            	<td><%out.print(prof.getNombre());%></td>
            	<td><%out.print(prof.getApellido_Pat());%></td>
            	<td><%out.print(prof.getApellido_Mat());%></td>
            	<td><%out.print(prof.getPoder()); %></td>
            	<td><%out.print(prof.getN_Alias());%></td>
            	<td><%out.print(prof.getRemuneracion());%></td>
            	<td><%out.print(prof.getT_Profesor());%></td>
      
            	
            	
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
		
		<form action="ServletProfesorOpcion" method="get">
		 <input id="agregarprof" type="submit" value="Agregar nuevo Profesor">
		</form>
		
		
		 <form action="ServletCursoProfAgregar" method="post">
		  <label for="MatriculaP">Matricula de Profesor:</label>
		 <input id="agprof" type="text" name="matricula_p">
		  <label for="idlecion">Id de la leccion:</label>
		 <input id="aglec" type="text" name="id_leccion">
		 <label for="sem">Semestre:</label>
		 <input id="agsem" type="text" name="semestre">
		 <input id="agregarcp" type="submit" value="Agregar curso">
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
            	<th>Matricula de Profesor </th>
                <th>Nombre </th>
                <th>Leccion </th>
                <th>Tipo de Leccion </th>
                <th>Remuneracion </th>
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<ProfesorJB> listaprofe = (List<ProfesorJB>) request.getAttribute("listaprofe");
        if (listaprofe != null){
        	for (ProfesorJB prof : listaprofe){
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
		
    	
	</body>
	
</html>