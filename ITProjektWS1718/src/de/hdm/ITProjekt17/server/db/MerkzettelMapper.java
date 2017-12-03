package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
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
		public Merkzettel findByKey(int id){
			Connection con = DBConnection.connection();
			
			try{
			Statement stmt = con.createStatement();		
			ResultSet rs = stmt.executeQuery("SELECT * FROM `merkzettel` WHERE `id` = " + id);
			
			if (rs.next()){
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
		/**
		 * Insert Methode ist für die EInfügeoperation in die Datenbank zuständig
		 * @param merk
		 * @return
		 */
		public Merkzettel insertInfo(Merkzettel merk) {
			
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

				/**
				 *  Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
				 */
				if (rs.next()) {
					/**
					 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
					 */
					merk.setId(rs.getInt("maxid") + 1);
					/**
					 * Ein Statement wird erzeugt
					 */
					stmt = con.createStatement();

					/**
					 * Hier erfolgt die Einfügeoperation
					 */
					stmt.executeUpdate("INSERT INTO merkzettel (id, profilId_merkender, profilId_gemerkter)"
							+ "VALUES " + merk.getId() + "','" + merk.getProfilId_merkender() + "','" + merk.getProfilId_gemerkter() + "')");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return merk;
		}
		/**
		 * Löschen des Objektes Merkzettel in der Datenbank
		 * @param merk
		 */
		public void deleteInfo(Merkzettel merk) {
			
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
		       * Hier erfolgt die Löschoperation
		       */
		      stmt.executeUpdate("DELETE FROM merkzettel " + "WHERE id=" + merk.getId());

		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		  }
		
		/**
		 * Erneutes schreiben in die Datenbank um das Profil Objekt zu aktualisieren
		 * @param merk
		 * @return merk
		 */
		 public Merkzettel updateInfo(Merkzettel merk) {
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
			       * Eigentliche Updateoperation 
			       */
			      stmt.executeUpdate("UPDATE merkzettel " + "SET profilId_merkender=\"" + merk.getProfilId_merkender()
			          + "profilId_gemerkter=\" " + merk.getProfilId_gemerkter() + "\"" + "WHERE id=" + merk.getId());

			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }

			    /**
			     * Um Analogie zu insert(Merkzettel merk) zu wahren, geben wir merk zurück
			     */
			    return merk;
			  }
		
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
			          Profil pro = new Profil();
			          pro.setId(rs.getInt("id"));
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

		 }
	
