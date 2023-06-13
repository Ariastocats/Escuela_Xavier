package Controlador;

import Modelo.ProfesorJB;
import Modelo.T_ProfesoresJB;
import Datos.ProfesorDAO;
import Datos.T_ProfesoresDAO;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@WebServlet("/ServletBuscarProfesor")

public class ServletBuscarProfesor extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
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
		 
		 ProfesorJB prof=new ProfesorJB();
		 ProfesorDAO profdao=new ProfesorDAO();
		 int matricula_p = Integer.parseInt(request.getParameter(("matricula_p")));
		 prof=profdao.buscar(matricula_p);
		 
		 request.setAttribute("prof",prof);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProfesorModificar.jsp");
			 dispatcher.forward(request,response);
		
		
		
	}

}
