package Controlador;

import Datos.MutanteDAO;
import Datos.ProfesorDAO;
import Modelo.MutanteJB;
import Modelo.ProfesorJB;
import Datos.EstudianteDAO;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletEliminarMutante")

public class ServletEliminarMutante extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		MutanteJB mut =new MutanteJB();
		MutanteDAO mutdao= new MutanteDAO();
		int curp = Integer.parseInt(request.getParameter("curp"));
		mut=mutdao.buscar(curp);
		int rol=mut.getRol();
		if(rol==1) {
			ProfesorDAO profdao= new ProfesorDAO();
			profdao.dardebaja(curp);
			
			
		}
		else if(rol==2){
			EstudianteDAO estdao= new EstudianteDAO();
			estdao.dardebaja(curp);
			
		}
		
		mutdao.borrar(curp);
		response.sendRedirect("ServletMutante");
		
		
	}
	

}
