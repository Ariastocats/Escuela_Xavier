<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>

	<head>
		<title>Login</title>
	</head>
	
	<body>
	
	<form action="ServletConfirmarLogin" method="post">
	
	<label for="contra">Tipo de Usuario:</label>
	<select id="selectp" name="tipousuario" >
        	<option value= "1">Admin</option>
        	<option value= "2">Profesor</option>
        	<option value= "3">Alumno</option>
        	
		</select>

                
                    <label for="Usuario">Correo:</label>
                    <input id="Nomusuario" type="text" name="correo"> 
                

                
                    <label for="contra">Contraseña:</label>
                    <input id="contra" type="password" name="contrasena"> 
                    
                    
               
                <%
               String mensaje = (String) request.getAttribute("mensaje"); 
                 if (mensaje != null && !mensaje.isEmpty()) { 
                %> 
                    <p><%= mensaje %></p>
                <% } %>

                <input type="submit" name="Boton" value="Iniciar Sesion">

              

            </form>

		
		
	</body>
	
</html>