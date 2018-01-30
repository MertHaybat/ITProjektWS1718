package de.hdm.ITProjekt17.server.db;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;
	/**
	 * 
	 * @author dennis
	 *
	 */
	public class KontaktsperreMapper {
			/**
			 * Die Klasse KontaktsperreMapper wird nur einmal instantiiert. Man spricht 
			 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
			 * @see kontaktsperreMapper()
			 */
			
			private static KontaktsperreMapper kontaktsperreMapper = null;
			
			/**
			 * Geschützter Konstruktor - verhindet die Möglichkeit, mit "new" 
			 * neue Instanzen dieser Klasse zu erzeugen.
			 */
			protected KontaktsperreMapper(){	
			}
			
			/**
			 * Kann aufgerufen werden durch KontaktsperreMapper.kontaktsperreMapper. Sie stellt die
			 * Singleton-Eigenschaft sicher.
			 *  Methode soll nur über diese statische Methode aufgerufen werden
			 * @return kontaktsperreMapper
			 * @see KontaktsperreMapper
			 */
			public static KontaktsperreMapper kontaktsperreMapper(){
				if (kontaktsperreMapper == null){
					kontaktsperreMapper = new KontaktsperreMapper();
				}
				
				return kontaktsperreMapper;
			}
			
		/**
		 * Mit der Insert Methode wird es ermöglicht Kontakte zu sperren.
		 * @param sperre
		 * @return
		 */
		 public Kontaktsperre insertKontaktsperre(Kontaktsperre sperre){
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
				              + "FROM kontaktsperre ");
				     	
				      if(rs.next()){
				    	  	/**
							 * Varaible sperre erhält den höchsten Primärschlüssel inkrementiert um 1
							 */
				    	  	sperre.setId(rs.getInt("maxid") + 1);	    	  	
				    	  	/**
				    	  	 * Durchführen der Einfüge Operation via Prepared Statement
				    	  	 */
				    	  		PreparedStatement stmt1 = con.prepareStatement(
				    	  				"INSERT INTO kontaktsperre (id, profilid_sperrender, profilid_gesperrter) "
				    	  				+ "VALUES (?,?,?) ",
				    	  				Statement.RETURN_GENERATED_KEYS);
				    	  				stmt1.setInt(1, sperre.getId());
				    	  				stmt1.setInt(2, sperre.getProfilId_sperrender());
				    	  				stmt1.setInt(3, sperre.getProfilId_gesperrter());
				    	  				
				    	  				
				    	  				
				    	  				stmt1.executeUpdate();
				      }
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}
				return sperre;
				
			}
			/**
			 * Löschen des Objekt Kontaktsperre in der Datenbank.
			 * 
			 *Hier wird eine Kontaktsperre nach der vergebenen Kontaktsperre-Id in der Tabelle Kontaktsperre gelöscht
			 * @param sperre
			 */
			public void deleteKontaktsperre (Kontaktsperre sperre) {
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
			     PreparedStatement stmt = con.prepareStatement("DELETE FROM kontaktsperre WHERE profilid_sperrender=? AND profilid_gesperrter=? ");
			     stmt.setInt(1, sperre.getProfilId_sperrender());
			     stmt.setInt(2, sperre.getProfilId_gesperrter());
			     stmt.executeUpdate();

			  
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }
			
			
			/**
			 * Es wird eine Löschung durchgeführt bei dem beide ID angegeben werden.
			 * Somit löscht sich auch die Sperre heraus.
			 * @param profilid_sperrender
			 * @param profilid_gesperrter
			 */
			public void deleteByProfilIds(Profil pro, int profilid_gesperrter) {
			    Connection con = DBConnection.connection();

			    try {
			      Statement stmt = con.createStatement();
			  
			      stmt.executeUpdate("DELETE FROM kontaktsperre " + "WHERE profilid_sperrender=" + pro.getId() +" AND profilid_gesperrter="+profilid_gesperrter);

			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }

			/**
			 * Mit der Methode GetAll werden alle Kontaktsperre in einem Ergebnis-Vektor namens Kontaktsperre gespeichert und zurückgegeben
			 * @return
			 */
			 public Vector<Kontaktsperre> getAllKontaktsperre() {
				 
				 	/**
				 	 * Aufbau der DB Connection
				 	 */
				    Connection con = DBConnection.connection();
				  
				    Vector<Kontaktsperre> result = new Vector<Kontaktsperre>();
				    
				    try {
				    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM kontaktsperre ");
				    	
				      
				    	ResultSet rs = stmt.executeQuery();
				        
				        /**
				         * Für jeden Eintrag im Suchergebnis wird nun ein Kontaktsperre-Objekt erstellt.
				         */
				        while (rs.next()) {
				          Kontaktsperre sperre = new Kontaktsperre();
				          sperre.setId(rs.getInt("id"));
				          sperre.setProfilId_sperrender(rs.getInt("profilid_sperrender"));
				          sperre.setProfilId_gesperrter(rs.getInt("profilid_gesperrter"));
				          /**
				           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
				           */
				          result.addElement(sperre);
				        }
				      }
				      catch (SQLException e) {
				        e.printStackTrace();
				      }

				      /**
				       *  Ergebnisvektor zurückgeben
				       */
				      return result;
			 }
			 	/**
				 * Mit der Methode GetAllKontaktsperreDesSperrenden Profils werden alle Kontaktsperren eines identifizierbaren sperrers in 
				 * einem Ergebnis-Vektor namens Kontaktsperre gespeichert und zurückgegeben
				 * @return
				 */
				 public Vector<Kontaktsperre> getAllKontaktsperrenDesSperrenden(Profil pro) {
					 
					 	/**
					 	 * Aufbau der DB Connection
					 	 */
					    Connection con = DBConnection.connection();
					  
					    Vector<Kontaktsperre> result = new Vector<Kontaktsperre>();
					    
					    try {
					    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM kontaktsperre WHERE profilid_sperrender=? ");
					    	stmt.setInt(1, pro.getId());
					      
					    	ResultSet rs = stmt.executeQuery();
					        
					        /**
					         * Für jeden Eintrag im Suchergebnis wird nun ein Kontaktsperre-Objekt erstellt.
					         */
					        while (rs.next()) {
					          Kontaktsperre spe = new Kontaktsperre();
					        
					          spe.setId(rs.getInt("id"));
					          spe.setProfilId_sperrender(rs.getInt("profilid_sperrender"));
					          spe.setProfilId_gesperrter(rs.getInt("profilid_gesperrter"));
					          /**
					           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
					           */
					          
					         
					          
					          result.addElement(spe);
					        }
					      }
					      catch (SQLException e) {
					        e.printStackTrace();
					      }

					      /**
					       *  Ergebnisvektor zurückgeben
					       */
					      return result;
				 }
				/**
			 	 * Es wird nur ein Kontaktsperre-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
			 	 * ist und nur einmal existiert.
			 	 * @param id
			 	 * @return sperre
			 	 */
			 	public Kontaktsperre findByKey(int id){
			 		/**
			 		 * Aufbau der Db Connection
			 		 */
			 		Connection con = DBConnection.connection();
			 		/**
			 		 * Try und Catch gehören zum Exception Handling 
			 		 * Try = Versuch erst dies 
			 		 * Catch = Wenn Try nicht geht versuch es so ..
			 		 */
			 		try{	
			 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM kontaktsperre WHERE id=?");
			 			stmt.setInt(1, id);
			
			 			/**
			 			 * Statement ausfüllen und an die DB senden
			 			 */
			 			ResultSet rs = stmt.executeQuery();
				
			 			if (rs.next()){
			 				Kontaktsperre sperre = new Kontaktsperre();
			 				sperre.setId(rs.getInt("id"));
			 				sperre.setProfilId_sperrender(rs.getInt("profilid_sperrender"));
			 				sperre.setProfilId_gesperrter(rs.getInt("profilid_gesperrter"));
			 			
		          
			 				return sperre;
			 			}
			 		}
			 		catch (SQLException e2){
			 			e2.printStackTrace();
			 			return null;
			 		}
			return null;
		}
				
				/**
				 * Erneutes schreiben in die Datenbank um das Kontaktsperre Objekt zu aktualisieren
				 * @param sperre
				 * @return sperre
				 */
				 public Kontaktsperre updateKontaktsperre(Kontaktsperre sperre){
					int i = sperre.getProfilId_gesperrter();
					int o = sperre.getProfilId_sperrender();
					
					String sql = null;
					
					 if(i == 0){
						 sql = "UPDATE kontaktsperre SET  profilid_sperrender=?, profilid_gesperrter=NULL WHERE id=?";
						 
					 } else if(o == 0){
						 sql = "UPDATE kontaktsperre SET  profilid_sperrender=NULL, profilid_gesperrter=? WHERE id=?";
					 }
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
					    	
					    	
					    	stmt.setInt(1, sperre.getProfilId_sperrender());
					    	stmt.setInt(2, sperre.getProfilId_gesperrter());

					    	stmt.setInt(3, sperre.getId());
					    	stmt.executeUpdate();
					    	
					    
					   
					    }
					    catch (SQLException e2) {
					      e2.printStackTrace();
					    }

					    /**
					     *  Das Profil wird zurückgegeben
					     */
					    return sperre;
					  }	
				 public Vector<Kontaktsperre> getAllKontaktsperrenDesGesperrten(Profil pro) {
					 
					 	/**
					 	 * Aufbau der DB Connection
					 	 */
					    Connection con = DBConnection.connection();
					  
					    Vector<Kontaktsperre> result = new Vector<Kontaktsperre>();
					    
					    try {
					    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM kontaktsperre WHERE profilid_gesperrter=? ");
					    	stmt.setInt(1, pro.getId());
					      
					    	ResultSet rs = stmt.executeQuery();
					        
					        /**
					         * Für jeden Eintrag im Suchergebnis wird nun ein Kontaktsperre-Objekt erstellt.
					         */
					        while (rs.next()) {
					          Kontaktsperre spe = new Kontaktsperre();
					        
					          spe.setId(rs.getInt("id"));
					          spe.setProfilId_sperrender(rs.getInt("profilid_sperrender"));
					          spe.setProfilId_gesperrter(rs.getInt("profilid_gesperrter"));
					          /**
					           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
					           */
					          
					         
					          
					          result.addElement(spe);
					        }
					      }
					      catch (SQLException e) {
					        e.printStackTrace();
					      }

					      /**
					       *  Ergebnisvektor zurückgeben
					       */
					      return result;
				 }
					public void deleteKontaktsperreByProfil (Kontaktsperre sperre) {
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
					     PreparedStatement stmt = con.prepareStatement("DELETE FROM kontaktsperre WHERE profilid_sperrender=? or profilid_gesperrter=? ");
					     stmt.setInt(1, sperre.getProfilId_sperrender());
					     stmt.setInt(2, sperre.getProfilId_sperrender());
					     stmt.executeUpdate();

					  
					    }
					    catch (SQLException e2) {
					      e2.printStackTrace();
					    }
					  }
				 
	}
