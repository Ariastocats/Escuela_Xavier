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

@WebServlet("/ServletLeccionesList")

public class ServletLeccionesList extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		LeccionesDAO lec=new LeccionesDAO();
		List<LeccionesJB> lista=lec.select();
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
			 RequestDispatcher dispatcher = request.getRequestDispatcher("LeccionesListMEstudiante.jsp");
			 dispatcher.forward(request,response);
			 
		 }
		 else {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("LeccionesList.jsp");
		 dispatcher.forward(request,response);
		 }
		 
		 
		 
		 
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String leccion = request.getParameter("leccion");
		
		String horai= request.getParameter("horario_ini");
		Time horario_ini = FuncionHora(horai);
		
		String horaf= request.getParameter("horario_fin");
		Time horario_fin = FuncionHora(horaf);
		
		
		int creditos = Integer.parseInt(request.getParameter("creditos"));
		
		
		int tipo_leccion =Integer.parseInt(request.getParameter("tipoleccion"));
		
		LeccionesJB Lecciones = new LeccionesJB(leccion,horario_ini,horario_fin,creditos,tipo_leccion);
		LeccionesDAO lecc= new LeccionesDAO();
		lecc.agregar(Lecciones);
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
