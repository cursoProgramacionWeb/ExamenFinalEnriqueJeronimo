package es.tarjetas.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.tarjetas.modelo.Negocio;

/**
 * Servlet implementation class DarAltaTarjetaServlet
 */
@WebServlet("/DarAltaTarjeta")
public class DarAltaTarjetaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaTarjetaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			//recuperamos los datos
			String numero= request.getParameter("numero");
			int cupoMaximo= Integer.parseInt(request.getParameter("cupoMaximo"));
			int cupoDisponible= Integer.parseInt(request.getParameter("cupoDisponible"));
			boolean tipo= Boolean.parseBoolean(request.getParameter("tipo"));
			String numeroComprobacion= request.getParameter("numeroComprobacion");
			int contrasenha= Integer.parseInt(request.getParameter("contrasenha"));
				
			//CAMINO DE IDA A LA BD
			Negocio negocio= new Negocio();
			int id= negocio.darAltaTarjeta(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
				
				
			//CAMINO DE VUELTA DE LA BD
				
			String men;
			if (id>=1){
				men= negocio.altaCorrecta();
					
			request.setAttribute("mensaje",men);
			RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
			rd.forward(request, response);
			
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
