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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String presentacion = request.getParameter("presentacion");
		Date dia=null;
		String sdia = request.getParameter("dia");
		LocalDate dialocal=null;
		try {
			dialocal=LocalDate.parse(sdia);
			dia=Date.valueOf(dialocal);
			
		}catch(DateTimeParseException e) {
			e.printStackTrace();
			
		}
		String shora= request.getParameter("hora");
		Time hora = FuncionHora(shora);
		
		
		
		
		
		PresentacionesJB Presentaciones = new PresentacionesJB(presentacion,dia,hora);
		PresentacionesDAO presen=new PresentacionesDAO();
		presen.agregar(Presentaciones);
		response.sendRedirect("");
			
	}
	
	
	
	
	
	
	private Time FuncionHora(String hora) {

        try {
            SimpleDateFormat dateFormatEntrada = new SimpleDateFormat("HH:mm");
            java.util.Date horaDate =  dateFormatEntrada.parse(hora);

            SimpleDateFormat dateFormatSalida = new SimpleDateFormat("HH:mm:ss");
            String nuevaHora = dateFormatSalida.format(horaDate);

            return Time.valueOf(nuevaHora);

        }
        catch (ParseException e) {
            e.printStackTrace();
            return null; 
        }
    }

}
