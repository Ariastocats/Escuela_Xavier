package Controlador;

import Datos.EstudianteDAO;
import Modelo.EstudianteJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
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
		List<EstudianteJB>lista = est.seleccionar();
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

}
