package Controlador;

import Modelo.EstudianteJB;
import Datos.EstudianteDAO;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@WebServlet("/ServletBuscarEstudiante")

public class ServletBuscarEstudiante extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
		EstudianteJB est= new EstudianteJB();
		EstudianteDAO estdao= new EstudianteDAO();
		int matricula = Integer.parseInt(request.getParameter(("matricula")));
		est=estdao.buscar(matricula);
		request.setAttribute("est",est);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EstudianteModificar.jsp");
		 dispatcher.forward(request,response);
		
	}

}
