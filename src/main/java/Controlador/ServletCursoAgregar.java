package Controlador;
import Modelo.CursoJB;
import Datos.CursoDAO;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletCursoAgregar")

public class ServletCursoAgregar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int matricula = Integer.parseInt(request.getParameter(("matricula")));
		int id_leccion = Integer.parseInt(request.getParameter(("id_leccion")));
		float calif = Float.parseFloat(request.getParameter(("calificacion")));
		
		CursoJB cur=new CursoJB(matricula,id_leccion,calif);
		CursoDAO curdao=new CursoDAO();
		//curdao.agregar(cur);
		int reg=curdao.agregar(cur);
		String m="Curso agregado correctamente";
		if(reg==0){
			 m="No se encontro el curso";
			System.out.println("No se agregó el curso");
			
			
		}
		
		response.sendRedirect("ServletCurso?mensaje="+ m);
	}

}
