<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.RolJB" %>
<%@ page import="Modelo.MutanteJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> modificar Mutante </title>
    </head>


<body>
<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletMutante" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>

<jsp:useBean id="mutante" class="Modelo.MutanteJB" scope="request" />
	
		<%
		MutanteJB mut = (MutanteJB) request.getAttribute("mut");
		%>


    <form action="ServletApdateMutante" method="post">
	<%
	@SuppressWarnings("unchecked")
	List<RolJB> Roles = (List<RolJB>) request.getAttribute("rolopcion");
	
	
	
	 %>
		
		<label for="curp"> Curp </label>
        <input id="curp" type="hidden" name="curp" value="<%=mut.getCurp()%>">

        <br>
        <br>


        <label for="nombre"> Nombre de el mutante </label>
        <input id="nombre" type="text" name="nombre" value="<%=mut.getNombre()%>">

        <br>
        <br>

        <label for="appat"> Apellido paterno </label>
        <input id="appat" type="text" name="apellido_pat" value="<%=mut.getApellido_Pat()%>">

        <br>
        <br>
        
        <label for="apmat"> Apellido Materno </label>
        <input id="appat" type="text" name="apellido_mat" value="<%=mut.getApellido_Mat()%>">

        <br>
        <br>
        
        <label for="poder"> Habilidad </label>
        <input id="poder" type="text" name="poder" value="<%=mut.getPoder()%>">

        <br>
        <br>
        
        <label for="alias"> Alias </label>
        <input id="alias" type="text" name="n_alias" value="<%=mut.getN_Alias()%>">

        <br>
        <br>
        
        <label for="fecha"> fecha de nacimiento </label>
        <input id="fecha" type="date" name="fecha_nac" value="<%=mut.getFecha_nac()%>">

        <br>
        <br>
        
        <label for="cel"> Numero de celular </label>
        <input id="cel" type="text" name="cel" value="<%=mut.getCel()%>">

        <br>
        <br>
        
        <label for="direc"> direccion </label>
        <input id="direc" type="text" name="direcc" value="<%=mut.getDirecc()%>">

        <br>
        <br>
        
         <label for="id_rol"> Rol </label>
        <select id="select" name="rolopciones">
        <% for(RolJB rol: Roles){%>
        	<option value= "<%= rol.getID_Rol()%>">
        		<%= rol.getRol() %>
        		
       
        	
        	 </option>
        
		
		<%} %>
		</select>
        

        <input type="submit" value="Agregar Mutante">

    </form>


</body>
</html>