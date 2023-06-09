<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.RolJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agregar Mutante </title>
    </head>


<body>



    <form action="ServletMutante" method="post">
	<%
	@SuppressWarnings("unchecked")
	List<RolJB> Roles = (List<RolJB>) request.getAttribute("rolopcion");
	
	
	
	 %>



        <label for="nombre"> Nombre de el mutante </label>
        <input id="presentacion" type="text" name="leccion">

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

        <label for="id_rol"> Rol </label>
        <select id="select" name="rolopciones" >
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