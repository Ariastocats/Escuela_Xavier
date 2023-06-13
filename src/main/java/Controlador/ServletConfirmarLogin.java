package Controlador;
import Modelo.ProfesorJB;
import Modelo.EstudianteJB;
import Datos.EstudianteDAO;
import Datos.ProfesorDAO;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletConfirmarLogin")
public class ServletConfirmarLogin extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String contraseña = request.getParameter("contrasena").trim();
		int tip = Integer.parseInt(request.getParameter(("tipousuario")));
		String admin="Admin";
			String contra="xavier1234";
			
			
		if(tip==1){
			if(correo.equals (admin) && contraseña.equals(contra) ) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("MenuAdmin.jsp");
				 dispatcher.forward(request,response);
			}
			else {
				String mensaje="Usuario o contraseña incorrectos";
				request.setAttribute("mensaje",mensaje);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				 dispatcher.forward(request,response);
			}
			
			
			
		}
		else if(tip==3) {
			EstudianteJB est= new EstudianteJB();
			EstudianteDAO estdao = new EstudianteDAO();
			est=estdao.buscarcorreo(correo);
			if(correo.equals(est.getCorreo_Inst())) {
				if(contraseña.equals(est.getContraseña())) {
					request.setAttribute("estudiante",est);
				RequestDispatcher dispatcher = request.getRequestDispatcher("MenuEstudiante.jsp");
				 dispatcher.forward(request,response);
				}
				else {
					String mensaje=" contraseña incorrecta";
					request.setAttribute("mensaje",mensaje);
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					 dispatcher.forward(request,response);
					
				}
				
				
				
			}
			else {
				String mensaje=" Estudiante no registrado";
				request.setAttribute("mensaje",mensaje);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				 dispatcher.forward(request,response);
				
			}
			
		}
		else if(tip==2) {
			ProfesorJB prof=new ProfesorJB();
			ProfesorDAO profdao = new ProfesorDAO();
			prof=profdao.buscarcorreo(correo);
			if(correo.equals(prof.getCorreo_Inst())) {
				if(contraseña.equals(prof.getContraseña())) {
					request.setAttribute("profesor",prof);
				RequestDispatcher dispatcher = request.getRequestDispatcher("MenuProfesor.jsp");
				 dispatcher.forward(request,response);
				}
				else {
					String mensaje=" Contraseña incorrecta";
					request.setAttribute("mensaje",mensaje);
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					 dispatcher.forward(request,response);
					
				}
				
				
			}else {
				String mensaje=" Profesor no registrado";
				request.setAttribute("mensaje",mensaje);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				 dispatcher.forward(request,response);
			}
			
		}
		else {
			System.out.println("ocurrio un error");
			
			
		}
		
		
		
		
	}

}
