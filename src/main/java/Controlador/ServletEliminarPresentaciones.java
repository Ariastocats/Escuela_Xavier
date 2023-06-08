package Controlador;

import Datos.PresentacionesDAO;
import Modelo.PresentacionesJB;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;

@WebServlet("/ServletEliminarPresentaciones")

public class ServletEliminarPresentaciones extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {
		 int id_presentacion = Integer.parseInt(request.getParameter("id_presentacion"));
		 PresentacionesDAO presentdao = new PresentacionesDAO();
	        presentdao.borrar(id_presentacion);
	        response.sendRedirect("ServletPresentacionesList");
		 
	 }
	

}
