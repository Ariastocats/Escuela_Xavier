package Controlador;

import Datos.RolDAO;
import Modelo.RolJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletRolOpcion")
public class ServletRolOpcion extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		RolDAO rop=new RolDAO();
		List<RolJB> lista=rop.seleccionar();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos en opcion");
			 
		 }
		 System.out.println("mosttando");
		 
		 request.setAttribute("rolopcion",lista);
		request.getRequestDispatcher("MutanteAgregar.jsp").forward(request, response);
	}

}
