<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.PresentacionesJB" %>
<%@ page import="Modelo.MutanteJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>agregarasistentes</title>
	</head>
	
	<body>
	<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletPresentaciones" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>
	
	<jsp:useBean id="presentacionesjb" class="Modelo.PresentacionesJB" scope="request"/>
	<jsp:useBean id="mutantejb" class="Modelo.MutanteJB" scope="request"/>

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
		List<PresentacionesJB> listapres = (List<PresentacionesJB>) request.getAttribute("listapres");
        if (listapres != null){
        	for (PresentacionesJB pres : listapres){
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
		List<MutanteJB> listamut = (List<MutanteJB>) request.getAttribute("listamut");
        if (listamut != null){
        	for (MutanteJB mut : listamut){ //if(mut.getStatus="acitvo"){
        		
        	
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
        	//}
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>
        
        <form action="ServletAsistAgregar" method="post">
        <label for="id presentacion">Id de presentacion:</label>
 		<input id="idpart" type="text" name="n_presentacion"> 
 		<label for="Curp">Curp:</label>
 		<input id="curppart" type="text" name="curp"> 
		  <input id="btagpart" type="submit" value="agregar participantes">
		</form>
		
		
        
		
	</body>
	
</html>