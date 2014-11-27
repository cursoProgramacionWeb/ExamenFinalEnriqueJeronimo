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
			PreparedStatement ps = cx.prepareStatement("INSERT INTO TARJETACREDITO VALUES(?,?,?,?,?,?,?)");
			  // 2.1 setear los interrogantes...
			  ps.setInt(1, 0);
			  ps.setString(2, tarjetaCredito.getNumero());
			  ps.setInt(3, tarjetaCredito.getCupoMaximo());
			  ps.setInt(4, tarjetaCredito.getCupoDisponible());
			  ps.setBoolean(5, tarjetaCredito.isTipo());
			  ps.setString(6, tarjetaCredito.getNumeroComprobacion());
			  ps.setInt(7, tarjetaCredito.getContrasenha());
			  
			  
			
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
		public TarjetaCredito consultarUno(String numero) {
			
			TarjetaCredito tc= new TarjetaCredito();
			
			try {
				
			//1. conectar
			     conectar();
			   //2. preparar la consulta
			     PreparedStatement ps = cx.prepareStatement("SELECT NUMERO, CUPODISPONIBLE FROM TARJETACREDITO WHERE NUMERO=?");
			     // 2.1 setear los ?
			         ps.setString(1, numero);
			         
			   // 3, ejecutar la consulta
			         ResultSet rs =ps.executeQuery();  
			    //4. llenar el objeto pais.. con los datos de respuesta de BBDD..
			         //Nota: La respuesta viene en un objeto ResultSet
			            
			         if(rs.next()) {   
			        	 tc.setNumero(rs.getString("numero"));
			        	 tc.setCupoDisponible(rs.getInt("cupoDisponible"));	                
			         }
						
			    //5.desconectar
			        desconectar();
			        	 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tc;
			}
		public int actualizar(String numero, int cupoDisponible) {
			
			int filasAfectadas=0;
	        try { 
	            //conectar
	              conectar();
	              
	            //preparar la consulta..
	              PreparedStatement ps= cx.prepareStatement("UPDATE TARJETACREDITO SET CUPODISPONIBLE=? WHERE NUMERO=?");
	          
	           // setear los ?   
	              ps.setInt(1, cupoDisponible);
	              ps.setString(2, numero);
	              
	              
	           // ejecutar la consulta
	              filasAfectadas= ps.executeUpdate();
	              
	           // hacer el commit
	              cx.commit();
	          
	           //cerrar la conexion
	              desconectar();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       return filasAfectadas;
		}
		
		
		public int consultarSaldo(String numero, int contrasenha,
				String numeroComprobacion) {
			
			int consultarSaldo=0;
	        try { 
	            //conectar
	              conectar();
	              
	            //preparar la consulta..
	              PreparedStatement ps= cx.prepareStatement("SELECT CUPODISPONIBLE FROM TARJETACREDITO WHERE NUMERO=? AND CONTRASENHA=? AND NUMEROCOMPROBACION=?");
	          
	           // setear los ?   
	              
	              ps.setString(1, numero);
	              ps.setInt(2, contrasenha);
	              ps.setString(3, numeroComprobacion);
	              
	              
	           // ejecutar la consulta
	              ResultSet consulta = ps.executeQuery();
	              
	              if(consulta.next()) {   
			        	 
	            	  consultarSaldo=consulta.getInt("cupoDisponible");
			           		                
			         }
	          
	           //cerrar la conexion
	              desconectar();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       return consultarSaldo;
		}
				

}
