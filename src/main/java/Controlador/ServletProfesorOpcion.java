package Controlador;

import Datos.RolDAO;
import Datos.T_ProfesoresDAO;
import Modelo.RolJB;
import Modelo.T_ProfesoresJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletProfesorOpcion")

public class ServletProfesorOpcion extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		RolDAO rop=new RolDAO();
		List<RolJB> list=rop.seleccionar();
		if(list.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos en opcion");
			 
		 }
		 System.out.println("mosttando");
		 
		 request.setAttribute("rolopcion",list);
		
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
		 
		 
		 
		request.getRequestDispatcher("ProfesorAgregar.jsp").forward(request, response);
	}

}
