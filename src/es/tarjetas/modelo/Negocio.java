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

	public String altaCorrecta() {
		String msg;
		
		msg= "Alta de nueva tarjeta de Crédito realizada correctamente";
		
		return msg;
	}

	public TarjetaCredito consultarUno(String numero) {
		
		TarjetaCredito tarjetaCredito= tarjetadao.consultarUno(numero);
				
		return tarjetaCredito;
	}

	public String actualizar(String numero, int cupoDisponible) {
		
		String msg;
		int filas= tarjetadao.actualizar(numero, cupoDisponible);
        if(filas>=1) {
            msg="Se ha actualizado " + filas +" Tarjeta de Crédito";
        }
        else {
              msg="Imposible actualizar";
        }
       return msg;
       
	}

	public int consultarSaldo(String numero, int contrasenha,
			String numeroComprobacion) {
		
		int saldo= tarjetadao.consultarSaldo(numero, contrasenha, numeroComprobacion);
		
		String msg;
		if(saldo<20){
			msg="No se puede hacer el pago. Saldo menor o igual a 20";
						
		}
		return saldo;
	}

}
