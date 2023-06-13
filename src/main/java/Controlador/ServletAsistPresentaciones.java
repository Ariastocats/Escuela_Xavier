package Controlador;


import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Datos.MutanteDAO;
import Datos.PresentacionesDAO;
import Modelo.MutanteJB;
import Modelo.PresentacionesJB; 

@WebServlet("/ServletAsistPresentaciones")
public class ServletAsistPresentaciones extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		 MutanteDAO mut= new MutanteDAO();
		 List<MutanteJB> listamut=mut.seljoin();
		 if(listamut.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("listamut",listamut);
		 
		 PresentacionesDAO pres=new PresentacionesDAO();
			List<PresentacionesJB> listapres=pres.seleccionar();
			if(listapres.isEmpty()) {
				 System.out.println("vacia la lista");
			 }
			 else {
				 System.out.println("tienes datos");
				 
			 }
			 System.out.println("mosttando");
			 request.setAttribute("listapres",listapres);
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("PresentacionesAsistAgregar.jsp");
			 dispatcher.forward(request,response);
		 
		 
	}

}
