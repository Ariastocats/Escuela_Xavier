package Controlador;
import Datos.CursoProfDAO;
import Modelo.CursoProfJB;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletCursoProfAgregar")
public class ServletCursoProfAgregar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int matricula_p = Integer.parseInt(request.getParameter(("matricula_p")));
		int id_leccion = Integer.parseInt(request.getParameter(("id_leccion")));
		String semestre = request.getParameter(("semestren"));
		CursoProfJB cur= new CursoProfJB(matricula_p,id_leccion,semestre);
		CursoProfDAO curdao= new CursoProfDAO();
		int reg=curdao.agregar(cur);
		String m="Curso agregado correctamente";
		if(reg==0){
			 m="No se encontró el curso o el profesor, verifique e intente de nuevo";
			System.out.println("No se agregó el curso");
			
			
		}
		
		response.sendRedirect("ServletCursoProf?mensaje="+ m);
		
	}

}
