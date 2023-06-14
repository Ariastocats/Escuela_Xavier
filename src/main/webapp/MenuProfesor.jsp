<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="Modelo.ProfesorJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>EscuelaXavier</title>
	</head>
	
	<body>
	
		<h2>Bienvenido a las pruebas</h2>
		
		<p> Selecciones su tipo de usuario: </p>
		
		<%
		ProfesorJB est = (ProfesorJB) request.getAttribute("profesor");
		
		%>
		
		<div>
    		
    		
    		
    		
    		
    		<form action="ServletPresentacionesList" method="get">
    		<input type="hidden" name="rolocult" value="2">
        		<input type="submit" name="presver" value="Ver Presentaciones">
    		</form>
    		
    		<form action="ServletLeccionesList" method="get">
    		<input type="hidden" name="rolocult" value="2">
        		<input type="submit" name="lecver" value="Ver lecciones">
    		</form>
    		
    		<form action="ServletProfesorLeccion" method="get">
    		<input type="hidden" name="matriculapocult" value="<%=est.getMatricula_P()%>">
        		<input type="submit" name="prlecver" value="Ver Lecciones Asignadas">
    		</form>
    	
    	</div>
	</body>
	
</html>