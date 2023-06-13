package Controlador;

import Datos.MutanteDAO;
import Datos.T_ProfesoresDAO;
import Modelo.MutanteJB;
import Modelo.T_ProfesoresJB;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletMutante")

public class ServletMutante extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		 MutanteDAO mut= new MutanteDAO();
		 List<MutanteJB> lista=mut.seljoin();
		 if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("MutanteList.jsp");
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
		
		int rol =Integer.parseInt(request.getParameter("rolopciones"));
		MutanteJB mutan =new MutanteJB(nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol);
		MutanteDAO mut=new MutanteDAO();
		
		
		if(rol ==1) {
			T_ProfesoresDAO tp=new T_ProfesoresDAO();
			List<T_ProfesoresJB> lista= tp.seleccionar();
			if(lista.isEmpty()) {
				 System.out.println("vacia la lista");
			 }
			 else {
				 System.out.println("tienes datos en opcion");
				 
			 }
			 System.out.println("mosttando");
			 
			 request.setAttribute("profopcion",lista);
			
			request.setAttribute("mut",mutan);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MutanteAProfesor.jsp");
			 dispatcher.forward(request,response);
			
			
		}
		else if(rol ==2){
			request.setAttribute("mut",mutan);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MutanteAEstudiante.jsp");
			 dispatcher.forward(request,response);
			
			
		}
		else if(rol ==3) {
			mut.agregar(mutan);
		response.sendRedirect("ServletMutante");
		}
		else {
			System.out.println("no se pudo");
		}
		 
		
		
		
		
		
	}
	
	
}
