package es.tarjetas.modelo;

public class TarjetaCredito {
	
	private int id;
	private String numero;
	private int cupoMaximo;
	private int cupoDisponible;
	private boolean tipo;
	private String numeroComprobacion;
	private int contrasenha;
	
	
	
	// metodos constructores
	
	public TarjetaCredito(int id, String numero, int cupoMaximo,
			int cupoDisponible, boolean tipo, String numeroComprobacion,
			int contrasenha) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrasenha = contrasenha;
	}


	public TarjetaCredito(String numero, int cupoMaximo, int cupoDisponible,
			boolean tipo, String numeroComprobacion, int contrasenha) {
		super();
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrasenha = contrasenha;
	}

	
	// getters and setters

	public TarjetaCredito() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCupoMaximo() {
		return cupoMaximo;
	}


	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}


	public int getCupoDisponible() {
		return cupoDisponible;
	}


	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}


	public boolean isTipo() {
		return tipo;
	}


	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}


	public String getNumeroComprobacion() {
		return numeroComprobacion;
	}


	public void setNumeroComprobacion(String numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}


	public int getContrasenha() {
		return contrasenha;
	}


	public void setContrasenha(int contrasenha) {
		this.contrasenha = contrasenha;
	}
	
	
	
	
	
	
	
	

}
