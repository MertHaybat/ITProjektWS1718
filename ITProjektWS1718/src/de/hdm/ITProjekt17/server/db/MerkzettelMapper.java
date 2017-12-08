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
			 * @param pro
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
			 * Erneutes schreiben in die Datenbank um das Merkzettel Objekt zu aktualisieren
			 * @param pro
			 * @return pro
			 */
			 public Merkzettel updateMerkzettel(Merkzettel merk) {
				 	String sql = "UPDATE merkzettel SET  profilId_merkender=?, profilId_gemerkter=? WHERE id=?";
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
				    
				    

				    	stmt.setInt(8, merk.getId());
				    	stmt.executeUpdate();
				    	
				    	System.out.println("Updated");
				   
				    }
				    catch (SQLException e2) {
				      e2.printStackTrace();
				    }

				    /**
				     *  Das Profil wird zurückgegeben
				     */
				    return merk;
				  }
			 
				/**
				 * Mit der Methode getAllMerkzettel werden Merkzettel in einem Ergebnis Vektor namens Merkzettel gespeichert und zurückgegeben
				 * @return
				 */
				 public Vector<Merkzettel> getAllMerkzettel() {
					 	/**
						 * Aufbau der DB Connection
						 */
					    Connection con = DBConnection.connection();
					    /**
					     * Erzeugung eines Merkzettel Vektors zur Speicherung von Merkzettel Variblen
					     */
					    Vector<Merkzettel> result = new Vector<Merkzettel>();
					    /**
						 * Try und Catch gehören zum Exception Handling 
						 * Try = Versuch erst dies 
						 * Catch = Wenn Try nicht geht versuch es so ..
						 */
					    try {
					        Statement stmt = con.createStatement();
					        /**
					         * Statement ausfüllen und an die DB senden
					         */
					        ResultSet rs = stmt.executeQuery("SELECT id, profilId_merkender, profilId_gemerkter "
					            + "FROM merkzettel "  
					            + "' ORDER BY id");

					        /**
					         *  Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt
					         */
					        while (rs.next()) {
					          Merkzettel merk = new Merkzettel();
					          merk.setId(rs.getInt("id"));
					          merk.setProfilId_merkender(rs.getInt("profilId_merkender"));
					          merk.setProfilId_gemerkter(rs.getInt("profilId_gemerkter"));
					         
					          /**
					           * Hinzufügen des neuen Objekts zum Ergebnisvektor
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
			 
			 
			 
			 
			 
			 
			 
			 
			 //Nochmals anschauen....
			 
			 
			 
			 
			 
			 
			 /**
				 * Mit der Methode findByKey kann ein Merkzettel via ID abgerufen werden
				 * @param id
				 * @return
				 */
				public Merkzettel findByKey(int id){
					/**
					 * Aufbau einer DB Connection
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
					 * Abfragen alles (*) aus der Tabelle Merkzettel
					 */
					ResultSet rs = stmt.executeQuery("SELECT * FROM `merkzettel` WHERE `id` = " + id);
					
					if (rs.next()){
						/**
						 * Erstellen eines Merkzettel-Objektes um Id, id des gesperrten und sperrenden darin zuspeichern und zurückzugeben
						 */
						Merkzettel p = new Merkzettel();
						p.setId(rs.getInt("id"));
						p.setProfilId_gemerkter(rs.getInt("profilId_gemerkter"));
						p.setProfilId_merkender(rs.getInt("profilId_merkender"));
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