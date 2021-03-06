package es.tarjetas.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.tarjetas.modelo.Negocio;
import es.tarjetas.modelo.NegocioWS;

/**
 * Servlet implementation class RealizarPagoServlet
 */
@WebServlet("/RealizarPago")
public class RealizarPagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarPagoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// recuperar datos
		String numero= request.getParameter("numero");
		int contrasenha= Integer.parseInt(request.getParameter("contrasenha"));
		String numeroComprobacion= request.getParameter("numeroComprobacion");
		int cantidadPagar= Integer.parseInt(request.getParameter("cantidadPagar"));
	
        //CAMINO DE IDA HACIA LA BD
		NegocioWS negocio= new Negocio();
		String msg= negocio.consultarSaldo(numero, contrasenha, numeroComprobacion, cantidadPagar);
	
		
		//VUELTA DE LA BD
		
					
		request.setAttribute("mensaje",msg);
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
