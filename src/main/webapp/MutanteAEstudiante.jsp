<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.MutanteJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agregar Mutante </title>
    </head>


<body>

<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletMutante" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>

<jsp:useBean id="lecciones" class="Modelo.MutanteJB" scope="request" />
	
		<%
		MutanteJB mutp = (MutanteJB) request.getAttribute("mut");
		%>

    <form action="ServletEstudiante" method="post">


        <label for="nombre"> Nombre de el mutante </label>
        <input id="presentacion" type="text" name="nombre" value="<%=mutp.getNombre()%>">

        <br>
        <br>

        <label for="appat"> Apellido paterno </label>
        <input id="appat" type="text" name="apellido_pat" value="<%=mutp.getApellido_Pat()%>">

        <br>
        <br>
        
        <label for="apmat"> Apellido Materno </label>
        <input id="appat" type="text" name="apellido_mat" value="<%=mutp.getApellido_Mat()%>">

        <br>
        <br>
        
        <label for="poder"> Habilidad </label>
        <input id="poder" type="text" name="poder" value="<%=mutp.getPoder()%>">

        <br>
        <br>
        
        <label for="alias"> Alias </label>
        <input id="alias" type="text" name="n_alias" value="<%=mutp.getN_Alias()%>">

        <br>
        <br>
        
        <label for="fecha"> fecha de nacimiento </label>
        <input id="fecha" type="date" name="fecha_nac" value="<%=mutp.getFecha_nac()%>">

        <br>
        <br>
        
        <label for="cel"> Numero de celular </label>
        <input id="cel" type="text" name="cel" value="<%=mutp.getCel()%>">

        <br>
        <br>
        
        <label for="direc"> direccion </label>
        <input id="direc" type="text" name="direcc" value="<%=mutp.getDirecc()%>">

       
		<br>
        <br>
        
        
        <label for="Correo_inst"> Correo Institucional </label>
        <input id="correo_inst" type="text" name="correo_inst">
        
         <br>
       <br>
        
        <label for="contraseña"> Contraseña </label>
        <input id="contraseña" type="text" name="contrasena">
        
        <br>
       <br>
        
        <label for="status"> Estatus </label>
      
        <select id="selecst" name="status" >
       
        	<option value= "habilitado">habilitado</option>
        	<option value= "deshabilitado">deshabilitado</option>
        	
		</select>
        
		<br>
        <input type="submit" value="Agregar Estudiante">

    </form>


</body>
</html>