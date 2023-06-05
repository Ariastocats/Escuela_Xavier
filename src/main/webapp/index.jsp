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
    	
    		<form action="/loginAdmin.jsp" method="post">
        		<input type="submit" name="loginEmpleado" value="Soy Administrador">
    		</form>
    	</div>
	</body>
	
</html>