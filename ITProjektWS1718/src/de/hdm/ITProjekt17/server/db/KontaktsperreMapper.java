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
			 * @return Das "KontaktsperreMapper-Objekt".
			 * @see KontaktsperreMapper
			 */
			public static KontaktsperreMapper kontaktsperreMapper(){
				if (kontaktsperreMapper == null){
					kontaktsperreMapper = new KontaktsperreMapper();
				}
				
				return kontaktsperreMapper;
			}
			
			
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
							 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
							 */
				    	  	sperre.setId(rs.getInt("maxid") + 1);	    	  	
				    	  	/**
				    	  	 * Durchführen der Einfüge Operation via Prepared Statement
				    	  	 */
				    	  		PreparedStatement stmt1 = con.prepareStatement(
				    	  				"INSERT INTO kontaktsperre (id, profilId_sperrender, profilId_gesperrter) "
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
			 * Löschen des Objekt Kontaktsperre in der Datenbank
			 * @param pro
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
			     PreparedStatement stmt = con.prepareStatement("DELETE FROM kontaktsperre " + "WHERE id= ? ");
			     stmt.setInt(1, sperre.getId());
			     stmt.executeUpdate();

			  
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }
			
			/**
			 * Erneutes schreiben in die Datenbank um das Kontaktsperre Objekt zu aktualisieren
			 * @param pro
			 * @return pro
			 */
			 public Kontaktsperre updateKontaktsperre(Kontaktsperre sperre){
				 	String sql = "UPDATE kontaktsperre SET  profilId_sperrender=?, profilId_gesperrter=? WHERE id=?";
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

				    	stmt.setInt(8, sperre.getId());
				    	stmt.executeUpdate();
				    	
				    	System.out.println("Updated");
				   
				    }
				    catch (SQLException e2) {
				      e2.printStackTrace();
				    }

				    /**
				     *  Das Profil wird zurückgegeben
				     */
				    return sperre;
				  }
			 
			 public Vector<Kontaktsperre> getAllKontaktsperre() {
					/**
					 * Aufbau der DB Connection
					 */
					 Connection con = DBConnection.connection();
					 	/**
					 	 * Kontaktsperre-Vektor Objekt wird erstellt
					 	 */
						 Vector<Kontaktsperre> result = new Vector<Kontaktsperre>();
						 /**
						  * Try und Catch gehören zum Exception Handling 
						  * Try = Versuch erst dies 
						  * Catch = Wenn Try nicht geht versuch es so ..
						  */
						 try {
							 Statement stmt = con.createStatement();

							 ResultSet rs = stmt.executeQuery("SELECT id, profilId_sperrender, profilId_gesperrter "
							  + "FROM kontaktsperre "  
							  + "' ORDER BY id");

							    /**
							     * Für jeden Eintrag im Suchergebnis wird nun ein Kontaktsperre-Objekt erstellt.
							     */
							    while (rs.next()) {
							    Kontaktsperre kSperre = new Kontaktsperre();
							    kSperre.setId(rs.getInt("id"));
							    kSperre.setProfilId_sperrender(rs.getInt("profilId_sperrender"));
							    kSperre.setProfilId_gesperrter(rs.getInt("profilId_gesperrter"));
							         
							     /**
							      * Hinzufügen des neuen Objekts zum Ergebnisvektor
							      */
							     result.addElement(kSperre);
							    }
							 }
							  catch (SQLException e) {
							   e.printStackTrace();
						 }
					return result;
					} 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 //Nochmals anschaun ob dies so passt....
			 
			 
			 
			 
			 
			 /**
				 * Es wird nur ein Kontaktsperre-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
				 * ist und nur einmal existiert.
				 * @param id
				 * @return p
				 */
				public Kontaktsperre findByKey(int id){
					/**
					 * Db Connection wird aufgebaut
					 */
					Connection con = DBConnection.connection();
					/**
					 * Try und Catch gehören zum Exception Handling 
					 * Try = Versuch erst dies 
					 * Catch = Wenn Try nicht geht versuch es so ..
					 */
					try{
					Statement stmt = con.createStatement();		
					/**
					 * Statement wird ausgefüllt und an die DB gesendet
					 */
					ResultSet rs = stmt.executeQuery("SELECT * FROM kontaktsperre WHERE id = " + id);
					
					if (rs.next()){
						Kontaktsperre p = new Kontaktsperre();
						p.setId(rs.getInt("id"));
						p.setProfilId_sperrender(rs.getInt("profilId_sperrender"));
						p.setProfilId_gesperrter(rs.getInt("profilId_gesperrter"));
						
						return p;
					}
				}
					catch (SQLException e2){
						e2.printStackTrace();
						return null;
					}

					return null;
				}
	}
