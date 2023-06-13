package Controlador;

import Datos.MutanteDAO;
import Datos.RolDAO;
import Modelo.MutanteJB;
import Modelo.RolJB;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@WebServlet("/ServletBuscarMutante")

public class ServletBuscarMutante extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		RolDAO rop=new RolDAO();
		List<RolJB> lista=rop.seleccionar();
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos en opcion");
			 
		 }
		 System.out.println("mosttando");
		 
		 request.setAttribute("rolopcion",lista);
		
		MutanteJB mut =new MutanteJB();
		MutanteDAO mutdao= new MutanteDAO();
		int curp = Integer.parseInt(request.getParameter(("curp")));
		mut=mutdao.buscar(curp);
		request.setAttribute("mut",mut);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MutanteModificar.jsp");
		 dispatcher.forward(request,response);
	}

}
