package Controlador;

import Modelo.Asist_PresentacionJB;
import Datos.Asist_PresentacionDAO;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@WebServlet("/ServletAsistAgregar")

public class ServletAsistAgregar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int n_presentacion = Integer.parseInt(request.getParameter(("n_presentacion")));
		int curp = Integer.parseInt(request.getParameter(("curp")));
		Asist_PresentacionJB asist= new Asist_PresentacionJB(n_presentacion,curp);
		Asist_PresentacionDAO asistdao =new Asist_PresentacionDAO();
		asistdao.agregar(asist);
		response.sendRedirect("ServletPresentaciones");
		
	}

}
