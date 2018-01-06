package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class MerkzettelMapper {

		/**
		 * Die Klasse MerkzettelMapper wird nur einmal instantiiert. Man spricht 
		 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
		 * @see merkzettelMapper()
		 */
		
		private static MerkzettelMapper merkzettelMapper = null;
		
		/**
		 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
		 * neue Instanzen dieser Klasse zu erzeugen.
		 */
		protected MerkzettelMapper(){	
		}
		
		/**
		 * Kann aufgerufen werden durch MerkzettelMapper.merkzettelMapper. Sie stellt die
		 * Singleton-Eigenschaft sicher.
		 * @return Das "MerkzettelMapper-Objekt".
		 * @see MerkzettelMapper
		 */
		public static MerkzettelMapper merkzettelMapper(){
			if (merkzettelMapper == null){
				merkzettelMapper = new MerkzettelMapper();
			}
			
			return merkzettelMapper;
		}
		
		
		 /**
		  * Mit der Insert Mehthode kann der Teilnehmer andere Teilnehmer zum Merkzettel hinzufügen
		  * @param merk
		  * @return
		  */
		 public Merkzettel insertMerkzettel(Merkzettel merk){
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
				              + "FROM merkzettel ");
				     	
				      if(rs.next()){
				    	  	/**
							 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
							 */
				    	  	merk.setId(rs.getInt("maxid") + 1);	    	  	
				    	  	/**
				    	  	 * Durchführen der Einfüge Operation via Prepared Statement
				    	  	 */
				    	  		PreparedStatement stmt1 = con.prepareStatement(
				    	  				"INSERT INTO merkzettel (id, profilId_merkender, profilId_gemerkter) "
				    	  				+ "VALUES (?,?,?) ",
				    	  				Statement.RETURN_GENERATED_KEYS);
				    	  				stmt1.setInt(1, merk.getId());
				    	  				stmt1.setInt(2, merk.getProfilId_merkender());
				    	  				stmt1.setInt(3, merk.getProfilId_gemerkter());
				    	  				
				    	  				
				    	  				
				    	  				stmt1.executeUpdate();
				      }
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}
				return merk;
				
			}
			/**
			 * Löschen des Objekt Merkzettel in der Datenbank
			 * @param merk
			 */
			public void deleteMerkzettel(Merkzettel merk) {
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
				      *
				      */
			     PreparedStatement stmt = con.prepareStatement("DELETE FROM merkzettel " + "WHERE id= ? ");
			     stmt.setInt(1, merk.getId());
			     stmt.executeUpdate();

			  
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }
			
			/**
			 * Löschen des Objekt Merkzettel in der Datenbank
			 * @param merk
			 */
			public void deleteGemerkterAusMerkzettel(Merkzettel merk) {
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
				      *
				      */
			     PreparedStatement stmt = con.prepareStatement("DELETE FROM merkzettel " + "WHERE profilid_gemerkter= ? ");
			     stmt.setInt(1, merk.getProfilId_gemerkter());
			     stmt.executeUpdate();
		  
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		  }
			
			/**
			 * Löschen eines Merkzettels bei angabe von merkender und gemerkter Teilnehmer ID's.
			 * @param profilId_merkender
			 * @param profilId_gemerkter
			 */
			public void deleteByProfilIds(int profilId_merkender, int profilId_gemerkter) {
			    Connection con = DBConnection.connection();

			    try {
			      Statement stmt = con.createStatement();
			  
			      stmt.executeUpdate("DELETE FROM merkzettel " + "WHERE profilId_merkender=" + profilId_merkender+" AND profilId_gemerkter="+profilId_gemerkter);

			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }

			
			/**
			 * Mit der Methode GetAll werden alle Merkzettel in einem Ergebnis-Vektor namens Merkzettel gespeichert und zurückgegeben
			 * @return
			 */
			 public Vector<Merkzettel> getAllMerkezettel() {
				 
				 	/**
				 	 * Aufbau der DB Connection
				 	 */
				    Connection con = DBConnection.connection();
				  
				    Vector<Merkzettel> result = new Vector<Merkzettel>();
				    
				    try {
				    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM merkzettel ");
				    	
				      
				    	ResultSet rs = stmt.executeQuery();
				        
				        /**
				         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
				         */
				        while (rs.next()) {
				          Merkzettel merk = new Merkzettel();
				          merk.setId(rs.getInt("id"));
				          merk.setProfilId_merkender(rs.getInt("profilId_merkender"));
				          merk.setProfilId_gemerkter(rs.getInt("profilId_gemerkter"));
				          /**
				           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
				           */
				          result.addElement(merk);
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
			 	 * Es wird nur ein Merkzettel-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
			 	 * ist und nur einmal existiert.
			 	 * @param id
			 	 * @return pro
			 	 */
			 	public Merkzettel findByKey(int id){
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
			 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM merkzettel WHERE id=?");
			 			stmt.setInt(1, id);
			
			 			/**
			 			 * Statement ausfüllen und an die DB senden
			 			 */
			 			ResultSet rs = stmt.executeQuery();
				
			 			if (rs.next()){
			 				Merkzettel merk = new Merkzettel();
			 				merk.setId(rs.getInt("id"));
			 				merk.setProfilId_merkender(rs.getInt("profilId_merkender"));
			 				merk.setProfilId_gemerkter(rs.getInt("profilId_gemerkter"));
			 			
		          
			 				return merk;
			 			}
			 		}
			 		catch (SQLException e2){
			 			e2.printStackTrace();
			 			return null;
			 		}
			return null;
		}
			
			 	/**
				 * Mit der Methode GetAllMerkzettelDesMerkers werden alle Merkzettel eines identifizierbaren merkers in 
				 * einem Ergebnis-Vektor namens Merkzettel gespeichert und zurückgegeben
				 * @return
				 */
				 public Vector<Merkzettel> getAllMerkezettelDesMerkers(int profilId_merkender) {
					 
					 	/**
					 	 * Aufbau der DB Connection
					 	 */
					    Connection con = DBConnection.connection();
					  
					    Vector<Merkzettel> result = new Vector<Merkzettel>();
					    
					    try {
					    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM merkzettel WHERE profilId_merkender=? ");
					    	stmt.setInt(1, profilId_merkender);
					      
					    	ResultSet rs = stmt.executeQuery();
					        
					        /**
					         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
					         */
					        while (rs.next()) {
					          Merkzettel merk = new Merkzettel();
					        
					          merk.setId(rs.getInt("id"));
					          merk.setProfilId_merkender(rs.getInt("profilId_merkender"));
					          merk.setProfilId_gemerkter(rs.getInt("profilId_gemerkter"));
					          /**
					           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
					           */
					          
					          System.out.println("Degga funkt");
					          
					          result.addElement(merk);
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
					 * Mit der Methode GetAllMerkzettelDesMerkers werden alle Merkzettel eines identifizierbaren merkers in 
					 * einem Ergebnis-Vektor namens Merkzettel gespeichert und zurückgegeben
					 * @return
					 */
					 public Vector<Merkzettel> merkzettel_showGemerkteProfile(int profilId_gemerkter) {
						 
						 	/**
						 	 * Aufbau der DB Connection
						 	 */
						    Connection con = DBConnection.connection();
						  
						    Vector<Merkzettel> result = new Vector<Merkzettel>();
						    
						    try {
						    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM merkzettel WHERE profilId_gemerkter=? ");
						    	stmt.setInt(1, profilId_gemerkter);
						      
						    	ResultSet rs = stmt.executeQuery();
						        
						        /**
						         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
						         */
						        while (rs.next()) {
						          Merkzettel merk = new Merkzettel();
						        
						          merk.setId(rs.getInt("id"));
						          merk.setProfilId_merkender(rs.getInt("profilId_merkender"));
						          merk.setProfilId_gemerkter(rs.getInt("profilId_gemerkter"));
						          /**
						           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
						           */
						          
						          System.out.println("Degga funkt");
						          
						          result.addElement(merk);
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
				 	
			 	
			 	
			 	
			 	
			 	
				 
				 
				 
				 
				 
				 

			 	
			 	//Updatefunktion implementiert, ncht sicher ob richtig... Bitte Anschauen
			 	
			 	
			 	
			 	
			 	/**
				 * Erneutes schreiben in die Datenbank um das Merkzettel Objekt zu aktualisieren
				 * VOm User ausgegangen hat dieser eine Usere ID die ihn identifiziert daher auch einen expliziten Fremdschlüssel in
				 * dieser Tabelle somit muss die Merkende ProfilID hier als WHERE angegeben werden...
				 * @param merk
				 * @return merk
				 */
				 public Merkzettel updateMerkzettel(Merkzettel merk) {
					 	String sql = "UPDATE merkzettel SET  profilId_merkender=?, profilId_gemerkter=? WHERE id =?";
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
					    	
					    
					    	stmt.setInt(1, merk.getProfilId_merkender());
					    	stmt.setInt(2, merk.getProfilId_gemerkter());
					    	stmt.setInt(3, merk.getId());
					    	
					    

					    	
					    	stmt.executeUpdate();
					    	
					    
					   
					    }
					    catch (SQLException e2) {
					      e2.printStackTrace();
					    }

					    /**
					     *  Das Profil wird zurückgegeben
					     */
					    return merk;
					  }
				 
		 }