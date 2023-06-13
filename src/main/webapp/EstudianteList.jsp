<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.EstudianteJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>EstudianteJB</title>
	</head>
	
	<body>
	<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
	
	<jsp:useBean id="estudiantejb" class="Modelo.EstudianteJB" scope="request"/>

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
                <th>Fecha de nacimiento </th>
                <th>celular </th>
                <th>Direccion </th>
                <th>Rol </th>
                
                <th>Correo institucional </th>
                <th>Contraseña </th>
<!--                  <th>Status </th> -->
                
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<EstudianteJB> lista = (List<EstudianteJB>) request.getAttribute("lista");
        if (lista != null){
        	for (EstudianteJB est : lista){
        %>
            <tr>
            	<td><%out.print(est.getMatricula());%></td>
            	<td><%out.print(est.getCurp()); %></td>
            	<td><%out.print(est.getNombre());%></td>
            	<td><%out.print(est.getApellido_Pat());%></td>
            	<td><%out.print(est.getApellido_Mat());%></td>
            	<td><%out.print(est.getPoder()); %></td>
            	<td><%out.print(est.getN_Alias());%></td>
            	<td><%out.print(est.getFecha_nac());%></td>
            	<td><%out.print(est.getCel());%></td>
            	<td><%out.print(est.getDirecc()); %></td>
            	<td><%out.print(est.getRols());%></td>
            	<td><%out.print(est.getCorreo_Inst());%></td>
            	<td><%out.print(est.getContraseña()); %></td>
<%--             	<td><%out.print(est.getStatus());%></td> --%>
            	
            	
        	</tr>
       	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>
        
        <form action="EstudiantesAgregar.jsp">
		 <input id="agregarest" type="submit" value="Agregar nuevo Estudiante">
		</form>
		
		<form action="ServletBuscarEstudiante" method="get">
		 <input id="buscest" type="text" name="matricula">
		  <input id="btbuscest" type="submit" value="Modificar Estudiante">
		</form>
		
		<form action="ServletEliminarMutante" method="get">
		 <input id="elimest" type="text" name="curp">
		  <input id="btelimest" type="submit" value="Elimnar Estudiante">
		</form>
    	
	</body>
	
</html>