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

@WebServlet("/ServletPresentacionesList")
public class ServletPresentacionesList extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
		
		PresentacionesDAO pres=new PresentacionesDAO();
		List<PresentacionesJB> lista=pres.seleccionar();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		
		
		 System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 int rolocult=0;
			try {
				
				rolocult = Integer.parseInt(request.getParameter(("rolocult")));
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(rolocult>0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("PresentacionesListRMEstudiante.jsp");
				 dispatcher.forward(request,response);
				
			}
			else {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("PresentacionesListR.jsp");
		 dispatcher.forward(request,response);
			}
		 
		
		 
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
		response.sendRedirect("ServletPresentacionesList");
			
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
