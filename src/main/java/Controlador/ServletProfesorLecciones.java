package Controlador;

import Datos.ProfesorDAO;
import Modelo.ProfesorJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletProfesorLeccion")

public class ServletProfesorLecciones extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int matricula_p=0;
		try {
			matricula_p=Integer.parseInt(request.getParameter("matriculapocult"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(matricula_p==0) {
			ProfesorDAO prof= new ProfesorDAO();
		List<ProfesorJB>lista=prof.joinprle();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		System.out.println("mosttando");
		 request.setAttribute("lista",lista);
			
		}
		
		else {
			ProfesorDAO profdao= new ProfesorDAO();
			List<ProfesorJB> lista=profdao.joinprlebuscar(matricula_p);
			request.setAttribute("lista",lista);
			
		}
		
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("ProfesorLeccionList.jsp");
		 dispatcher.forward(request,response);
		
	}

}
