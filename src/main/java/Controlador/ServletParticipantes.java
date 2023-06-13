package Controlador;

import Datos.PresentacionesDAO;
import Modelo.PresentacionesJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;





@WebServlet("/ServletParticipantes")
public class ServletParticipantes extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int n_presentacion = Integer.parseInt(request.getParameter(("n_presentacion")));
		PresentacionesDAO pres=new PresentacionesDAO();
		List<PresentacionesJB> lista=pres.presasis(n_presentacion);
		if(lista.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("lista",lista);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("ParticipantesList.jsp");
		 dispatcher.forward(request,response);


}
	
}
