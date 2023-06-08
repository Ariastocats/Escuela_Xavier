package Controlador;

import Datos.PresentacionesDAO;
import Modelo.PresentacionesJB;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;

@WebServlet("/ServletPresentaciones")

public class ServletPresentaciones extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		PresentacionesDAO pres=new PresentacionesDAO();
		List<PresentacionesJB> lista=pres.joinpres();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("PresentacionesList.jsp");
		 dispatcher.forward(request,response);
		 
	}
	
	
	
	
	
	
	
	
	

}
