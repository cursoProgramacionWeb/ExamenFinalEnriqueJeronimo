package es.tarjetas.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.tarjetas.modelo.TarjetaCredito;

public class TarjetaDAO {
	
	
	private Connection cx;
	
	private void conectar() {
	      try {
	           Class.forName("com.mysql.jdbc.Driver");
	           cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","root");
	           cx.setAutoCommit(false);
	       } catch (SQLException e) {
	          
	           e.printStackTrace();
	       } catch (ClassNotFoundException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
	    }
	    private void desconectar() {
	        try {
	           cx.close();
	       } catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
	    
	    }
		public int darAltaTarjeta(TarjetaCredito tarjetaCredito) {
			
			int idRetornar=0;
			
			try {
			
			//1. conectar
	        conectar();
	        
	        //2.Preparar la sql (query)
			PreparedStatement ps = cx.prepareStatement("INSERT INTO TARJETACREDITO VALUES(?,?,?,?,?,?)");
			  // 2.1 setear los interrogantes...
			  ps.setInt(1, 0);
			  ps.setString(2, tarjetaCredito.getNumero());
			  ps.setInt(3, tarjetaCredito.getCupoMaximo());
			  ps.setInt(4, tarjetaCredito.getCupoDisponible());
			  ps.setBoolean(5, tarjetaCredito.isTipo());
			  ps.setString(6, tarjetaCredito.getNumeroComprobacion());
			  
			
			//3. Ejecutar la consulta
	        int filasAfectadas =ps.executeUpdate();
	        
	        //4.  hacer el commit....
	        cx.commit();
	        
	        if(filasAfectadas>=1) { 
	            idRetornar= ultimoId();
	        }  
	             
	       
	        //.5.cerrar la conexión
	        desconectar();
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			       
	        return idRetornar;
		}
			
		public int ultimoId() {
			int  idM=90;
			try {
				//1. conectar
				conectar();
				//2. preparar la sentencia
				PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM TARJETACREDITO"); 
				//3. ejecutar la consulta
				ResultSet consulta = ps.executeQuery(); 
				//4. bajar el resultado de la consulta y ponerlo en el arrayList
				if(consulta.next()) { 
					idM=consulta.getInt("ULTIMO");
				}
				//5. desconectar
				desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			return idM;					
	
		
		}
	

}
