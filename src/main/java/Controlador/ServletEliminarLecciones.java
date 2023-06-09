package Controlador;

import Datos.LeccionesDAO;
import Modelo.LeccionesJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletEliminarLecciones")
public class ServletEliminarLecciones extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int id_leccion = Integer.parseInt(request.getParameter("id_leccion"));
		LeccionesDAO lece= new LeccionesDAO();
		lece.borrar(id_leccion);
		// redirigir servlet response.sendRedirect("ServletLeccionesList?id="+id_leccion);
        response.sendRedirect("ServletLeccionesList");
	}

}
