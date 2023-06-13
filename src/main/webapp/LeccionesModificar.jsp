<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Tipo_LeccionJB" %>
<%@ page import="Modelo.LeccionesJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> modificar leccion </title>
    </head>


<body>

<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletLeccionesList" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>

	<jsp:useBean id="lecciones" class="Modelo.LeccionesJB" scope="request" />
	
		<%
		LeccionesJB lec = (LeccionesJB) request.getAttribute("lec");
		%>

    <form action="ServletApdateLeccion" method="post">
	<%
	@SuppressWarnings("unchecked")
	List<Tipo_LeccionJB> Lecciones = (List<Tipo_LeccionJB>) request.getAttribute("tipolecciones");
	
	
	
	 %>

		<label for="idlec"> Id de la leccion </label>
        <input id="idlec" type="hidden" name="id_leccion" value="<%=lec.getID_Leccion()%>">

        <br>
        <br>

        <label for="lec"> Nombre de la leccion </label>
        <input id="lec" type="text" name="leccion" value="<%=lec.getLeccion()%>">

        <br>
        <br>

        <label for="horai"> Hora de inicio de la leccion </label>
        <input id="horai" type="time" name="horario_ini" value="<%=lec.getHora_Ini()%>">

        <br>
        <br>
        
        <label for="horaf"> Hora en que acaba la leccion </label>
        <input id="horaf" type="time" name="horario_fin" value="<%=lec.getHora_Fin()%>">

        <br>
        <br>
        
        <label for="cred"> Creditos de la leccion </label>
        <input id="cred" type="text" name="creditos" value="<%=lec.getCreditos()%>">

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
        <input type="submit" value="Modificar Leccion">

    </form>


</body>
</html>