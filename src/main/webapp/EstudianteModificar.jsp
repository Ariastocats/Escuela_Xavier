<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.RolJB" %>
<%@ page import="Modelo.EstudianteJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agregar estudiante </title>
    </head>


<body>

<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletEstudiante" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>

<jsp:useBean id="profesor" class="Modelo.EstudianteJB" scope="request" />
	
		<%
		EstudianteJB est = (EstudianteJB) request.getAttribute("est");
		%>


    <form action="ServletApdateEstudiante" method="post">
	
		<label for="curp"> Curp </label>
        <input id="curp" type="hidden" name="curp" value="<%=est.getCurp()%>">

        <br>
        <br>


        <label for="nombre"> Nombre de el mutante </label>
        <input id="presentacion" type="text" name="nombre" value="<%=est.getNombre()%>">

        <br>
        <br>

        <label for="appat"> Apellido paterno </label>
        <input id="appat" type="text" name="apellido_pat" value="<%=est.getApellido_Pat()%>">

        <br>
        <br>
        
        <label for="apmat"> Apellido Materno </label>
        <input id="appat" type="text" name="apellido_mat" value="<%=est.getApellido_Mat()%>">

        <br>
        <br>
        
        <label for="poder"> Habilidad </label>
        <input id="poder" type="text" name="poder" value="<%=est.getPoder()%>">

        <br>
        <br>
        
        <label for="alias"> Alias </label>
        <input id="alias" type="text" name="n_alias" value="<%=est.getN_Alias()%>">

        <br>
        <br>
        
        <label for="fecha"> fecha de nacimiento </label>
        <input id="fecha" type="date" name="fecha_nac" value="<%=est.getFecha_nac()%>">

        <br>
        <br>
        
        <label for="cel"> Numero de celular </label>
        <input id="cel" type="text" name="cel" value="<%=est.getCel()%>">

        <br>
        <br>
        
        <label for="direc"> direccion </label>
        <input id="direc" type="text" name="direcc" value="<%=est.getDirecc()%>">

       
		<br>
        <br>
        
        <label for="curp"> Matricula de estudiante </label>
        <input id="curp" type="hidden" name="matricula" value="<%=est.getMatricula()%>">

        <br>
        <br>
        
        
        
        
        <label for="Correo_inst"> Correo Institucional </label>
        <input id="correo_inst" type="text" name="correo_inst" value="<%=est.getCorreo_Inst()%>">
        
         <br>
       <br>
        
        <label for="contraseña"> Contraseña </label>
        <input id="contraseña" type="text" name="contrasena" value="<%=est.getContraseña()%>">
        
        <br>
       <br>
        
<!--         <label for="status"> Estatus </label> -->
      
<!--         <select id="selecst" name="status" > -->
       
<!--         	<option value= "habilitado">habilitado</option> -->
<!--         	<option value= "deshabilitado">deshabilitado</option> -->
        	
<!-- 		</select> -->
        
<!-- 		<br> -->
        <input type="submit" value="modificar estudiante">

    </form>


</body>
</html>