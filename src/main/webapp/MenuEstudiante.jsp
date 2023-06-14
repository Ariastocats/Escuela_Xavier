<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="Modelo.EstudianteJB" %>
<!DOCTYPE html>

<html>

	<head>
		<title>EscuelaXavier</title>
	</head>
	
	<body>
	
		<h2>Bienvenido a las pruebas</h2>
		
		<p> Selecciones su tipo de usuario: </p>
		
		<%
		EstudianteJB est = (EstudianteJB) request.getAttribute("estudiante");
		
		%>
		
		<div>
    		
    		<form action="ServletProfesor" method="get">
    		<input type="hidden" name="rolocult" value="3">
        		<input type="submit" name="profever" value="Ver lista de Profesores">
    		</form>
    		
    		
    		<form action="ServletPresentacionesList" method="get">
    		<input type="hidden" name="rolocult" value="3">
        		<input type="submit" name="presver" value="Ver Presentaciones">
    		</form>
    		
    		<form action="ServletLeccionesList" method="get">
    		<input type="hidden" name="rolocult" value="3">
        		<input type="submit" name="lecver" value="Ver lecciones">
    		</form>
    		
    		
    		<form action="ServletLecciones" method="get">
    		<input type="hidden" name="matriculaocult" value="<%=est.getMatricula()%>">
        		<input type="submit" name="lecalver" value="Ver Calificaciones">
    		</form>
    		
    		
    		
    	
    	</div>
	</body>
	
</html>