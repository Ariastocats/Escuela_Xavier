<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>EscuelaXavier</title>
	</head>
	
	<body>
	
		<h2>Bienvenido a las pruebas</h2>
		
		<p> Selecciones su tipo de usuario: </p>
		
		<div>
			<form action="ServletMutante" method="get">
        		<input type="submit" name="mutantever" value="Ver lista de mutantes">
    		</form>
    		
    		<form action="ServletProfesor" method="get">
        		<input type="submit" name="profever" value="Ver lista de Profesores">
    		</form>
    		
    		<form action="ServletEstudiante" method="get">
        		<input type="submit" name="estudever" value="Ver lista de Estudiantes">
    		</form>
    		
    		<form action="ServletPresentaciones" method="get">
        		<input type="submit" name="presasisver" value="Ver Presentaciones y asistencias">
    		</form>
    		
    		<form action="ServletPresentacionesList" method="get">
        		<input type="submit" name="presver" value="Ver Presentaciones">
    		</form>
    		
    		<form action="ServletLeccionesList" method="get">
        		<input type="submit" name="lecver" value="Ver lecciones">
    		</form>
    		
    		<form action="ServletLecciones" method="get">
        		<input type="submit" name="lecalver" value="Ver alumnos y lecciones">
    		</form>
    		<form action="ServletProfesorLeccion" method="get">
        		<input type="submit" name="prlecver" value="Ver profesores y lecciones">
    		</form>
    	
    		<form action="/loginAdmin.jsp" method="post">
        		<input type="submit" name="loginEmpleado" value="Soy Administrador">
    		</form>
    	</div>
	</body>
	
</html>