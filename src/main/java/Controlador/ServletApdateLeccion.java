package Controlador;

import Datos.LeccionesDAO;
import Modelo.LeccionesJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

@WebServlet("/ServletApdateLeccion")
public class ServletApdateLeccion extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
		int id_leccion = Integer.parseInt(request.getParameter("id_leccion"));
		
		String leccion = request.getParameter("leccion");
		String horai= request.getParameter("horario_ini");
		Time horario_ini = FuncionHora(horai);
		
		String horaf= request.getParameter("horario_fin");
		Time horario_fin = FuncionHora(horaf);
		
		int creditos = Integer.parseInt(request.getParameter("creditos"));
		int tipo_leccion =Integer.parseInt(request.getParameter("tipoleccion"));
		
		LeccionesJB Lecciones = new LeccionesJB(id_leccion,leccion,horario_ini,horario_fin,creditos,tipo_leccion);
		LeccionesDAO lecc= new LeccionesDAO();
		lecc.modificar(Lecciones);
		response.sendRedirect("ServletLeccionesList");
		
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
