package Controlador;

import Datos.MutanteDAO;
import Datos.ProfesorDAO;
import Modelo.MutanteJB;
import Modelo.ProfesorJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletProfesor")

public class ServletProfesor extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		ProfesorDAO prof= new ProfesorDAO();
		List<ProfesorJB>lista=prof.joinprof();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 int rolocult=0;
			try {
				
				rolocult = Integer.parseInt(request.getParameter(("rolocult")));
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		 if(rolocult==3) {
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("ProfesorListMEstudiante.jsp");
		 dispatcher.forward(request,response);
			 
		 }
		 else {
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("ProfesorList.jsp");
		 dispatcher.forward(request,response);
		 }
		 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
		
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
		int remuneracion =Integer.parseInt(request.getParameter("remuneracion"));
		int t_profesores =Integer.parseInt(request.getParameter("profopciones"));
		String correo_inst = request.getParameter("correo_inst");
		String contraseña = request.getParameter("contrasena");
		
		
		String status = request.getParameter("status");
		
		System.out.println("contraseña: "+contraseña);
		System.out.println("status:" +status);
		
		
		MutanteJB mutan =new MutanteJB(nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol);
		MutanteDAO mut=new MutanteDAO();
		
		
		int curp=mut.agregar(mutan);
		
		
		
		
		ProfesorJB prof = new ProfesorJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,remuneracion,t_profesores,correo_inst,contraseña,status);
		ProfesorDAO profDAO=new ProfesorDAO();
		
		profDAO.agregar(prof);
		
		
		response.sendRedirect("ServletProfesor");
		
		
	}

}
