package Controlador;
import Datos.MutanteDAO;
import Datos.ProfesorDAO;
import Modelo.MutanteJB;
import Modelo.ProfesorJB;
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

@WebServlet("/ServletApdateProfesor")
public class ServletApdateProfesor extends HttpServlet{
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
		
		int rol =1;
		MutanteJB mutan =new MutanteJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol);
		MutanteDAO mut=new MutanteDAO();
		
		mut.modificar(mutan);
		
		int matricula_p = Integer.parseInt(request.getParameter(("matricula_p")));
		int remuneracion =Integer.parseInt(request.getParameter("remuneracion"));
		int t_profesores =Integer.parseInt(request.getParameter("profopciones"));
		String correo_inst = request.getParameter("correo_inst");
		String contraseña = request.getParameter("contrasena");
		
		
		String status = request.getParameter("status");
		ProfesorJB prof =new ProfesorJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,matricula_p,remuneracion,t_profesores,correo_inst,contraseña,status);
		ProfesorDAO profdao=new ProfesorDAO();
		profdao.modificar(prof);
		response.sendRedirect("ServletProfesor");
		
	}
	

}
