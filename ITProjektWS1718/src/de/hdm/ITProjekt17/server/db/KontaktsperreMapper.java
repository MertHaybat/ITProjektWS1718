package de.hdm.ITProjekt17.server.db;

	import java.sql.Connection;
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
			/**
			 * Es wird nur ein Merkezttel-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
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
				ResultSet rs = stmt.executeQuery("SELECT * FROM `kontaktsperre` WHERE `id` = " + id);
				
				if (rs.next()){
					Kontaktsperre p = new Kontaktsperre();
					p.setId(rs.getInt("id"));
					p.setProfilId_gesperrter(rs.getInt("profilId_gesperrter"));
					p.setProfilId_sperrender(rs.getInt("profilId_sperrender"));
					
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
			 * Insert Methode ist für die Einfügeoperation in die Datenbank zuständig
			 * @param sperre
			 * @return sperre
			 */
			public Kontaktsperre insertKontaktsperre(Kontaktsperre sperre) {
				/**
				 * Aufbau Db Connection
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
					 * Zunächst schauen wir nach, welches der momentan höchste
					 * Primärschlüsselwert ist.
					 */
					ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
					+ "FROM kontaktsperre ");

					/**
					 * Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
					 */
					if (rs.next()) {
						/**
						 * merk erhält den bisher maximalen, nun um 1 inkrementierten
						 * Primärschlüssel.
						 */
						sperre.setId(rs.getInt("maxid") + 1);

						stmt = con.createStatement();

						/**
						 * Jetzt erst erfolgt die tatsächliche Einfügeoperation
						 */
						stmt.executeUpdate("INSERT INTO merkzettel (id, profilId_sperrender, profilId_gesperrter)"
								+ "VALUES " + sperre.getId() + "','" + sperre.getProfilId_sperrender() + "','" + sperre.getProfilId_gesperrter() + "')");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return sperre;
			}
				/**
				 * Löschen des Objekt Merkzettel in der Datenbank
				 * @param merk
				 */
				public void deleteKontaktsperre(Kontaktsperre sperre) {
					/**
					 * Db Connection wird aufgebaut
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
				       * Durchführung der Löschoperation
				       */
				      stmt.executeUpdate("DELETE FROM kontaktsperre " + "WHERE id=" + sperre.getId());

				    }
				    catch (SQLException e2) {
				      e2.printStackTrace();
				    }
				  }
				
				/**
				 * Erneutes schreiben in die Datenbank um das Profil Objekt zu aktualisieren
				 * @param sperre
				 * @return sperre
				 */
				 public Kontaktsperre updateKontaktsperre(Kontaktsperre sperre) {
					 /**
					  * Db Connection wird aufgebaut
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
					       * Durchüfhung der Updateoperation
					       */
					      stmt.executeUpdate("UPDATE kontaktpserre " + "SET profilId_sperrender=\"" + sperre.getProfilId_sperrender()
					          + "profilId_gesperrter=\" " + sperre.getProfilId_gesperrter() + "\"" + "WHERE id=" + sperre.getId());

					    }
					    catch (SQLException e2) {
					      e2.printStackTrace();
					    }

					    /**
					     * Um Analogie zu insertKontaktsperre(Kontaktsperre sperre) zu wahren, geben wir merk zurück
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
					            + "FROM merkzettel "  
					            + "' ORDER BY id");

					        /**
					         * Für jeden Eintrag im Suchergebnis wird nun ein Kontaktsperre-Objekt erstellt.
					         */
					        while (rs.next()) {
					          Kontaktsperre kSperre = new Kontaktsperre();
					          kSperre.setId(rs.getInt("id"));
					          Profil pro = new Profil();
					          pro.setId(rs.getInt("id"));
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
		}
