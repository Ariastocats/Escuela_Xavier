package Controlador;

import Datos.MutanteDAO;
import Modelo.MutanteJB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletMutante")

public class ServletMutante extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest hsreq, HttpServletResponse hsres)
    		throws ServletException, IOException {
		 List<MutanteJB> Mutantes = new MutanteDAO().seleccionar();
		 System.out.println("Mutantes = " + Mutantes);
		 hsreq.setAttribute("Mutantes", Mutantes);
		 hsreq.getRequestDispatcher("index.jsp").forward(hsreq, hsres);
	}
}
