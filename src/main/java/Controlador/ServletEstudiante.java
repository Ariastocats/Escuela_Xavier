package Controlador;

import Datos.EstudianteDAO;
import Datos.MutanteDAO;
import Modelo.EstudianteJB;
import Modelo.MutanteJB;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		EstudianteDAO est = new EstudianteDAO();
		List<EstudianteJB>lista = est.joinest();
		 if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("EstudianteList.jsp");
		 dispatcher.forward(request,response);
		
		
		
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
		
		int rol =2;
		String correo_inst = request.getParameter("correo_inst");
		String contraseña = request.getParameter("contrasena");
		
		
		String status = request.getParameter("status");
		MutanteJB mutan =new MutanteJB(nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol);
		MutanteDAO mut=new MutanteDAO();
		
		
		int curp=mut.agregar(mutan);
		EstudianteJB est= new EstudianteJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,correo_inst,contraseña,status);
		EstudianteDAO estdao =new EstudianteDAO();
		estdao.agregar(est);
		response.sendRedirect("ServletEstudiante");
	}

}
