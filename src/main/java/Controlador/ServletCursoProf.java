package Controlador;


import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Datos.LeccionesDAO;
import Datos.ProfesorDAO;
import Modelo.LeccionesJB;
import Modelo.ProfesorJB;

@WebServlet("/ServletCursoProf")
public class ServletCursoProf extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String mensaje= request.getParameter("mensaje");
		request.setAttribute("mensaje",mensaje);
		
		LeccionesDAO lec=new LeccionesDAO();
		List<LeccionesJB> listalec=lec.select();
		if(listalec.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("listalec",listalec);
		 
		 ProfesorDAO prof= new ProfesorDAO();
			List<ProfesorJB>listaprof=prof.joinprof();
			if(listaprof.isEmpty()) {
				 System.out.println("vacia la lista");
			 }
			 else {
				 System.out.println("tienes datos");
				 
			 }
			System.out.println("mosttando");
			 request.setAttribute("listaprof",listaprof);
			 //////////////////////////7
			 ProfesorDAO profe= new ProfesorDAO();
				List<ProfesorJB>listaprofe=profe.joinprle();
				if(listaprofe.isEmpty()) {
					 System.out.println("vacia la lista");
				 }
				 else {
					 System.out.println("tienes datos");
					 
				 }
				System.out.println("mosttando");
				 request.setAttribute("listaprofe",listaprofe);
			 
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("CursoProfList.jsp");
			 dispatcher.forward(request,response);
		 
		 
	}

}
