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
		Negocio negocio= new Negocio();
		int saldo= negocio.consultarSaldo(numero, contrasenha, numeroComprobacion);
	
		
		//VUELTA DE LA BD
		//String negocio.respuestaPago();
		
		String msg="";
		if(saldo<20){
			msg="No se puede hacer el pago. Saldo en cuenta menor a 20 euros";
		}
		else{
			if(cantidadPagar>=saldo){
				msg="No hay suficiente dinero en cuenta para pagar";
			}
			else{
				msg="Pago efectuado";
			}
			
		}
					
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
