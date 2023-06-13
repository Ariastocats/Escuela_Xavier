package Controlador;

import Datos.PresentacionesDAO;
import Modelo.PresentacionesJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletBuscarPresentacion")

public class ServletBuscarPresentacion extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
		PresentacionesJB pres =new PresentacionesJB();
		PresentacionesDAO presdao= new PresentacionesDAO();
		int n_presentacion = Integer.parseInt(request.getParameter(("n_presentacion")));
		pres=presdao.buscar(n_presentacion);
		request.setAttribute("pres", pres);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PresentacionesModificar.jsp");
		 dispatcher.forward(request,response);
		
	}

}
