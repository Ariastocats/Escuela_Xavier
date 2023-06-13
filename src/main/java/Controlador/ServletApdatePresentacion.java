package Controlador;

import Modelo.PresentacionesJB;
import Datos.PresentacionesDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
@WebServlet("/ServletApdatePresentacion")


public class ServletApdatePresentacion extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int n_presentacion= Integer.parseInt(request.getParameter("n_presentacion"));
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
		String shora= request.getParameter("horario");
		Time hora = FuncionHora(shora);
		
		PresentacionesJB pres= new PresentacionesJB(n_presentacion,presentacion,dia,hora);
		PresentacionesDAO presdao = new PresentacionesDAO();
		presdao.modificar(pres);
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
