package es.tarjetas.modelo;

import es.tarjetas.integracion.TarjetaDAO;

public class Negocio {
	
	private TarjetaDAO tarjetadao= new TarjetaDAO();

	public int darAltaTarjeta(String numero, int cupoMaximo,
			int cupoDisponible, boolean tipo, String numeroComprobacion,
			int contrasenha) {
		
		TarjetaCredito tarjetaCredito= new TarjetaCredito(numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contrasenha);
		int id= tarjetadao.darAltaTarjeta(tarjetaCredito);
		
		return id;
	}

}
