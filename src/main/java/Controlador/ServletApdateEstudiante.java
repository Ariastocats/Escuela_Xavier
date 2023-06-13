package Controlador;
import Datos.MutanteDAO;
import Datos.EstudianteDAO;
import Modelo.MutanteJB;
import Modelo.EstudianteJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/ServletApdateEstudiante")

public class ServletApdateEstudiante extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int curp = Integer.parseInt(request.getParameter(("curp")));
		String nombre = request.getParameter("nombre");
		String apellido_pat = request.getParameter("apellido_pat");
		String apellido_mat = request.getParameter("apellido_mat");
		String poder = request.getParameter("poder");
		String n_alias = request.getParameter("n_alias");
		Date fecha_nac=null;
		String sfecha = request.getParameter("fecha_nac");
		LocalDate fechalocal=null;
		try {
			fechalocal=LocalDate.parse(sfecha);
			fecha_nac=Date.valueOf(fechalocal);
			
		}catch(DateTimeParseException e) {
			e.printStackTrace();
			
		}
		String cel =request.getParameter("cel");
		String direcc =request.getParameter("direcc");
		
		int rol =2;
		MutanteJB mutan =new MutanteJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol);
		MutanteDAO mut=new MutanteDAO();
		
		mut.modificar(mutan);
		
		int matricula = Integer.parseInt(request.getParameter(("matricula")));
		String correo_inst = request.getParameter("correo_inst");
		String contraseña = request.getParameter("contrasena");
		String status = request.getParameter("status");
		EstudianteJB est= new EstudianteJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,matricula,correo_inst,contraseña,status);
		EstudianteDAO estdao=new EstudianteDAO();
		estdao.modificar(est);
		response.sendRedirect("ServletEstudiante");
		
	}
	

}
