package Controlador;

import Datos.MutanteDAO;
import Modelo.MutanteJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
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
}
