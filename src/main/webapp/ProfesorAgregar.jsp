<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.RolJB" %>
<%@ page import="Modelo.T_ProfesoresJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agregar Mutante </title>
    </head>


<body>
<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletProfesor" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>


    <form action="ServletProfesor" method="post">
	<%
	@SuppressWarnings("unchecked")
	List<RolJB> Roles = (List<RolJB>) request.getAttribute("rolopcion");
	
	@SuppressWarnings("unchecked")
	List<T_ProfesoresJB> tprof = (List<T_ProfesoresJB>) request.getAttribute("profopcion");
	
	 %>



        <label for="nombre"> Nombre de el mutante </label>
        <input id="presentacion" type="text" name="nombre">

        <br>
        <br>

        <label for="appat"> Apellido paterno </label>
        <input id="appat" type="text" name="apellido_pat">

        <br>
        <br>
        
        <label for="apmat"> Apellido Materno </label>
        <input id="appat" type="text" name="apellido_mat">

        <br>
        <br>
        
        <label for="poder"> Habilidad </label>
        <input id="poder" type="text" name="poder">

        <br>
        <br>
        
        <label for="alias"> Alias </label>
        <input id="alias" type="text" name="n_alias">

        <br>
        <br>
        
        <label for="fecha"> fecha de nacimiento </label>
        <input id="fecha" type="date" name="fecha_nac">

        <br>
        <br>
        
        <label for="cel"> Numero de celular </label>
        <input id="cel" type="text" name="cel">

        <br>
        <br>
        
        <label for="direc"> direccion </label>
        <input id="direc" type="text" name="direcc">

       
		<br>
        <br>
        
        
        <label for="Remuneracion"> Remuneracion </label>
        <input id="Remuneracion" type="text" name="remuneracion">
        
         <br>
        <br>

        <label for="id_tprof"> Tipo de profesor </label>
        <select id="selectp" name="profopciones" >
        <% for(T_ProfesoresJB tp: tprof){%>
        	<option value= "<%= tp.getID_TipoP()%>">
        		<%= tp.getTiempo() %>
        	
        	 </option>
        
		
		<%} %>
		</select>
		
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
        
<!--         <label for="status"> Estatus </label> -->
      
<!--         <select id="selecst" name="status" > -->
       
<!--         	<option value= "habilitado">habilitado</option> -->
<!--         	<option value= "deshabilitado">deshabilitado</option> -->
        	
<!-- 		</select> -->
        
<!-- 		<br> -->
        <input type="submit" value="Agregar Profesor">

    </form>


</body>
</html>