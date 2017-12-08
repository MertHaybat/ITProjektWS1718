package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Suchprofil_Info;

public class Suchprofil_InfoMapper {

		/**
		 * Die Klasse Suchprofil_InfoMapper wird nur einmal instantiiert. Man spricht 
		 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
		 * @see suchprofilMapper()
		 */
		
		private static Suchprofil_InfoMapper suchprofil_InfoMapper = null;
		
		/**
		 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
		 * neue Instanzen dieser Klasse zu erzeugen.
		 */
		protected Suchprofil_InfoMapper(){	
		}
		
		/**
		 * Kann aufgerufen werden durch SuchprofilMapper.suchprofilMapper. Sie stellt die
		 * Singleton-Eigenschaft sicher.
		 * @return Das "SuchprofilMapper-Objekt".
		 * @see SuchprofilMapper
		 */
		public static Suchprofil_InfoMapper suchprofil_InfoMapper(){
			if (suchprofil_InfoMapper == null){
				suchprofil_InfoMapper = new Suchprofil_InfoMapper();
			}
			
			return suchprofil_InfoMapper;
		}
		
	
		 public Suchprofil_Info insertSuchprofil_Info(Suchprofil_Info suchinfo){
				/**
				 * Aufbau der DB Connection
				 */
				Connection con = DBConnection.connection();
				/**
				 * Try und Catch gehören zum Exception Handling 
				 * Try = Versuch erst dies 
				 * Catch = Wenn Try nicht geht versuch es so ..
				 */
				try {
				      Statement stmt = con.createStatement();
				      	/**
						 * Was ist der momentan höchste Primärschlüssel
						 */
				      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
				              + "FROM suchprofil_info ");
				     	
				      if(rs.next()){
				    	  	/**
							 * Varaible suchinfo erhält den höchsten Primärschlüssel inkrementiert um 1
							 */
				    	  	suchinfo.setId(rs.getInt("maxid") + 1);	    	  	
				    	  	/**
				    	  	 * Durchführen der Einfüge Operation via Prepared Statement
				    	  	 */
				    	  		PreparedStatement stmt1 = con.prepareStatement(
				    	  				"INSERT INTO suchprofil_info (id, profilId_merkender, profilId_gemerkter) "
				    	  				+ "VALUES (?,?,?) ",
				    	  				Statement.RETURN_GENERATED_KEYS);
				    	  				stmt1.setInt(1, suchinfo.getId());
				    	  				stmt1.setInt(2, suchinfo.getSuchprofilId());
				    	  				stmt1.setInt(3, suchinfo.getInfoId());
				    	  				
				    	  				
				    	  				
				    	  				stmt1.executeUpdate();
				      }
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}
				return suchinfo;
				
			}
		 
		 
			/**
			 * Löschen des Objekt Suchprofil_info in der Datenbank
			 * @param pro
			 */
			public void deleteSuchprofil_Info(Suchprofil_Info suchinfo) {
				/**
				 * Aufbau der DB Connection
				 */
			    Connection con = DBConnection.connection();
			    /**
				 * Try und Catch gehören zum Exception Handling 
				 * Try = Versuch erst dies 
				 * Catch = Wenn Try nicht geht versuch es so ..
				 */
			    try {
			    	/**
				      * Durchführung der Löschoperation
				      */
			     PreparedStatement stmt = con.prepareStatement("DELETE FROM suchprofil_info " + "WHERE id= ? ");
			     stmt.setInt(1, suchinfo.getId());
			     stmt.executeUpdate();

			  
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }
			
			
			
			/**
			 * Erneutes schreiben in die Datenbank um das Suchprofil_Info Objekt zu aktualisieren
			 * @param suchinfo
			 * @return suchinfo
			 */
			 public Suchprofil_Info updateSuchprofil_Iinfo(Suchprofil_Info suchinfo) {
				 	String sql = "UPDATE suchprofil_info SET  suchprofilid=?, infoid=? WHERE id=?";
				 /**
				 	 * Aufbau der Db Connection
				 	 */
				    Connection con = DBConnection.connection();
				    /**
					 * Try und Catch gehören zum Exception Handling 
					 * Try = Versuch erst dies 
					 * Catch = Wenn Try nicht geht versuch es so ..
					 */
				    try {
				    
				    	PreparedStatement stmt = con.prepareStatement(sql);
				    	
				    	
				    	stmt.setInt(1, suchinfo.getSuchprofilId());
				    	stmt.setInt(2, suchinfo.getInfoId());
				    
				    

				    	stmt.setInt(8, suchinfo.getId());
				    	stmt.executeUpdate();
				    	
				    	System.out.println("Updated");
				   
				    }
				    catch (SQLException e2) {
				      e2.printStackTrace();
				    }

				    /**
				     *  Das suchinfo wird zurückgegeben
				     */
				    return suchinfo;
				  }
			 
			 /**
			  * Rückgabe der Suchprofil_Info-Vektor Objekte
			  * @return result
			  */
			 public Vector<Suchprofil_Info> getAll() {
				 /**
				  * Aufbau Db Connection
				  */
				    Connection con = DBConnection.connection();
				    
				    /**
				     * Verktor-Objekt wird erzeugt
				     */
				    Vector<Suchprofil_Info> result = new Vector<Suchprofil_Info>();
				    /**
					 * Try und Catch gehören zum Exception Handling 
					 * Try = Versuch erst dies 
					 * Catch = Wenn Try nicht geht versuch es so ..
					 */
				    try {
				        Statement stmt = con.createStatement();

				        /**
				         * Auswahl der Daten von SUchprofil in der Datenbank und Rückgabe erfolgt geordnet nach der Id.
				         */
				        ResultSet rs = stmt.executeQuery("SELECT id, suchprofilid, infoid "
				            + "FROM suchprofil_info "  
				            + "' ORDER BY id");

				        /**
				         * Für jeden Eintrag im Suchergebnis wird nun ein Suchprofil_Info-Objekt erstellt.
				         */
				        while (rs.next()) {
				          Suchprofil_Info suchinfo = new Suchprofil_Info();
				          suchinfo.setId(rs.getInt("id"));
				          suchinfo.setSuchprofilId(rs.getInt("suchprofilid"));
				          suchinfo.setInfoId(rs.getInt("infoid"));
				          
				          
				          /**
				           * Hinzufügen des neuen Objekts zum Ergebnisvektor
				           */
				          result.addElement(suchinfo);
				        }
				      }
				      catch (SQLException e) {
				        e.printStackTrace();
				      }
				      return result;
			 }		 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 //Nochmals anschaun....
			 
			 
			 
			 
			 
			 
			 
				public Suchprofil_Info findByKey(int id){
					/**
					 * Aufbau einer Db Connection
					 */
					Connection con = DBConnection.connection();
					/**
					 * Try und Catch gehören zum Exception Handling 
					 * Try = Versuch erst dies 
					 * Catch = Wenn Try nicht geht versuch es so ..
					 */
					try{
						/**
						 * Erstellen eines leeren Statements
						 */
					Statement stmt = con.createStatement();		
					/**
					 * Auswahl alles (*) aus der Tabelle Suchprofil_Info und das Ergebnis wird in der Variablen result gespeichert
					 */
					ResultSet rs = stmt.executeQuery("SELECT * FROM suchprofil_info WHERE id = " + id);
					
					if (rs.next()){
						/**
						 * Erstellen eines Suchprofil_Info-Objektes und setzten der Werte 
						 */
						Suchprofil_Info suchinfo = new Suchprofil_Info();
						suchinfo.setId(rs.getInt("id"));
						suchinfo.setSuchprofilId(rs.getInt("suchprofilid"));
						suchinfo.setInfoId(rs.getInt("info"));
				
						/**
						 * Rückgabe des Suchprofils p 
						 */
						return suchinfo;
					}
				}
					catch (SQLException e2){
						e2.printStackTrace();
						return null;
					}

					return null;
				}		        
}
