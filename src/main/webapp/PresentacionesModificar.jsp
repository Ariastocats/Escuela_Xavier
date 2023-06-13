<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.PresentacionesJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> modificar Presentaciones </title>
    </head>


<body>

<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletPresentacionesList" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>

	<jsp:useBean id="lecciones" class="Modelo.PresentacionesJB" scope="request" />
	
		<%
		PresentacionesJB pres = (PresentacionesJB) request.getAttribute("pres");
		%>

    <form action="ServletApdatePresentacion" method="post">
	
		<label for="idPresentacion"> Id de presentacion </label>
        <input id="idpresentacion" type="hidden" name="n_presentacion" value="<%=pres.getN_Presentacion()%>">

        <br>
        <br>

        <label for="Presentacion"> Nombre de la presentacion </label>
        <input id="presentacion" type="text" name="presentacion" value="<%=pres.getPresentacion()%>">

        <br>
        <br>

        <label for="dia"> Dia de la presentacion </label>
        <input id="dia" type="date" name="dia" value="<%=pres.getDia()%>">

        <br>
        <br>
        
        <label for="hora"> Hora de la presentacion </label>
        <input id="hora" type="time" name="horario" value="<%=pres.getHorario()%>">

        <br>
        <br>

        
        <input type="submit" value="Modificar Presentacion">

    </form>


</body>
</html>