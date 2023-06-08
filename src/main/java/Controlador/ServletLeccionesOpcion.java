package Controlador;

import Datos.Tipo_LeccionDAO;
import Modelo.Tipo_LeccionJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet("/ServletLeccionesOpcion")
public class ServletLeccionesOpcion extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		Tipo_LeccionDAO lecop=new Tipo_LeccionDAO();
		List<Tipo_LeccionJB> lista=lecop.seleccionar();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos en opcion");
			 
		 }
		 System.out.println("mosttando");
		 
		 request.setAttribute("tipolecciones",lista);
		request.getRequestDispatcher("LeccionesAgregar.jsp").forward(request, response);
		
	}

}
