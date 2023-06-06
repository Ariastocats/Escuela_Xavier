package Controlador;

import Datos.LeccionesDAO;
import Modelo.LeccionesJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletLecciones")

public class ServletLecciones extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		LeccionesDAO lec=new LeccionesDAO();
		List<LeccionesJB> lista=lec.lecjoin();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("LeccionesAlumnosList.jsp");
		 dispatcher.forward(request,response);
	}

}
