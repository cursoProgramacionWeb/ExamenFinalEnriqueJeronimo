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
 * Servlet implementation class ActualizarServlet
 */
@WebServlet("/Actualizar")
public class ActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// recuperar datos//
		String numero= request.getParameter("numero");
	    int cupoDisponible= Integer.parseInt(request.getParameter("cupoDisponible"));
		String actualizar=request.getParameter("actualizar");
		
		//CAMINO DE IDA A LA BD
		Negocio negocio= new Negocio();
		
		String act = "";
		if(actualizar!=null) {
	         act= negocio.actualizar(numero, cupoDisponible);
	     }
		
		//CAMINO DE VUELTA DE LA BD
		request.setAttribute("mensaje",act);
	    // redirigir... a  la vista mensaje
	    RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
