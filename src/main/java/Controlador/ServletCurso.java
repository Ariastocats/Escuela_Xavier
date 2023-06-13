package Controlador;
import Datos.EstudianteDAO;
import Datos.LeccionesDAO;
import Modelo.EstudianteJB;
import Modelo.LeccionesJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String mensaje= request.getParameter("mensaje");
		request.setAttribute("mensaje",mensaje);
		
		LeccionesDAO lec=new LeccionesDAO();
		List<LeccionesJB> listalec=lec.select();
		if(listalec.isEmpty()) {
			 System.out.println("vacia la lista");
		 }
		 else {
			 System.out.println("tienes datos");
			 
		 }
		 System.out.println("mosttando");
		 request.setAttribute("listalec",listalec);
		 
		 EstudianteDAO est = new EstudianteDAO();
			List<EstudianteJB>listaest = est.joinest();
			 if(listaest.isEmpty()) {
				 System.out.println("vacia la lista");
			 }
			 else {
				 System.out.println("tienes datos");
				 
			 }
			 System.out.println("mosttando");
			 request.setAttribute("listaest",listaest);
			 
			 ///////////////////////////////////////
				LeccionesDAO leccur=new LeccionesDAO();
				List<LeccionesJB> listacur=leccur.lecjoin();
				if(listacur.isEmpty()) {
					 System.out.println("vacia la lista");
				 }
				 else {
					 System.out.println("tienes datos");
					 
				 }
				System.out.println("mosttando");
				
				 request.setAttribute("listacur",listacur);
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("CursoList.jsp");
			 dispatcher.forward(request,response);
	}

}
