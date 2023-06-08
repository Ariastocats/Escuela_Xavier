<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Tipo_LeccionJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agregar leccion </title>
    </head>


<body>



    <form action="ServletLeccionesList" method="post">
	<%
	@SuppressWarnings("unchecked")
	List<Tipo_LeccionJB> Lecciones = (List<Tipo_LeccionJB>) request.getAttribute("tipolecciones");
	
	
	
	 %>



        <label for="Presentacion"> Nombre de la leccion </label>
        <input id="presentacion" type="text" name="leccion">

        <br>
        <br>

        <label for="nombre"> Hora de inicio de la leccion </label>
        <input id="nom_her" type="time" name="horario_ini">

        <br>
        <br>
        
        <label for="nombre"> Hora en que acaba la leccion </label>
        <input id="nom_her" type="time" name="horario_fin">

        <br>
        <br>
        
        <label for="nombre"> Creditos de la leccion </label>
        <input id="nom_her" type="text" name="creditos">

        <br>
        <br>

        <label for="id_int"> Tipo de leccion </label>
        <select id="select" name="tipoleccion" >
        <% for(Tipo_LeccionJB leccion: Lecciones){%>
        	<option value="<%= leccion.getID_TipoL()%>">
        		<%= leccion.getTipo_Leccion() %>
        	
        	 </option>
        
		
		<%} %>
		</select>
        <input type="submit" value="Agregar Leccion">

    </form>


</body>
</html>