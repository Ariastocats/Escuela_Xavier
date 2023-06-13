<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.RolJB" %>
<%@ page import="Modelo.T_ProfesoresJB" %>
<%@ page import="Modelo.ProfesorJB" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agregar Profesor </title>
    </head>


<body>

<form action="MenuAdmin.jsp">
		 <input id="regmenu" type="submit" value="Regresar al menu">
		</form>
		
		 <form action="ServletProfesor" method="get">
		 <input id="regmenu" type="submit" value="Regresar atras">
		</form>

<jsp:useBean id="profesor" class="Modelo.ProfesorJB" scope="request" />
	
		<%
		ProfesorJB prof = (ProfesorJB) request.getAttribute("prof");
		%>


    <form action="ServletApdateProfesor" method="post">
	<%
	
	@SuppressWarnings("unchecked")
	List<T_ProfesoresJB> tprof = (List<T_ProfesoresJB>) request.getAttribute("profopcion");
	
	 %>
		<label for="curp"> Curp </label>
        <input id="curp" type="hidden" name="curp" value="<%=prof.getCurp()%>">

        <br>
        <br>


        <label for="nombre"> Nombre de el mutante </label>
        <input id="presentacion" type="text" name="nombre" value="<%=prof.getNombre()%>">

        <br>
        <br>

        <label for="appat"> Apellido paterno </label>
        <input id="appat" type="text" name="apellido_pat" value="<%=prof.getApellido_Pat()%>">

        <br>
        <br>
        
        <label for="apmat"> Apellido Materno </label>
        <input id="appat" type="text" name="apellido_mat" value="<%=prof.getApellido_Mat()%>">

        <br>
        <br>
        
        <label for="poder"> Habilidad </label>
        <input id="poder" type="text" name="poder" value="<%=prof.getPoder()%>">

        <br>
        <br>
        
        <label for="alias"> Alias </label>
        <input id="alias" type="text" name="n_alias" value="<%=prof.getN_Alias()%>">

        <br>
        <br>
        
        <label for="fecha"> fecha de nacimiento </label>
        <input id="fecha" type="date" name="fecha_nac" value="<%=prof.getFecha_nac()%>">

        <br>
        <br>
        
        <label for="cel"> Numero de celular </label>
        <input id="cel" type="text" name="cel" value="<%=prof.getCel()%>">

        <br>
        <br>
        
        <label for="direc"> direccion </label>
        <input id="direc" type="text" name="direcc" value="<%=prof.getDirecc()%>">

       
		<br>
        <br>
        
        <label for="curp"> Matricula de profesor </label>
        <input id="curp" type="hidden" name="matricula_p" value="<%=prof.getMatricula_P()%>">

        <br>
        <br>
        
        
        
        <label for="Remuneracion"> Remuneracion </label>
        <input id="Remuneracion" type="text" name="remuneracion" value="<%=prof.getRemuneracion()%>">
        
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
        <input id="correo_inst" type="text" name="correo_inst" value="<%=prof.getCorreo_Inst()%>">
        
         <br>
       <br>
        
        <label for="contraseña"> Contraseña </label>
        <input id="contraseña" type="text" name="contrasena" value="<%=prof.getContraseña()%>">
        
        <br>
       <br>
        
<!--         <label for="status"> Estatus </label> -->
      
<!--         <select id="selecst" name="status" > -->
       
<!--         	<option value= "habilitado">habilitado</option> -->
<!--         	<option value= "deshabilitado">deshabilitado</option> -->
        	
<!-- 		</select> -->
        
        <input type="submit" value="modificar Profesor">

    </form>


</body>
</html>