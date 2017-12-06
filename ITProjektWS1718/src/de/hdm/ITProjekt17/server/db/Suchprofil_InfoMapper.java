package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


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
			ResultSet rs = stmt.executeQuery("SELECT * FROM `suchprofil_info` WHERE `id` = " + id);
			
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
		
		
		public Suchprofil_Info insertSuchprofil_Info(Suchprofil_Info suinfo){
		/**
		 * DB Connection wird aufgebaut
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
		      ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS maxid "
		              + "FROM suchprofil_info ");
		     	
		      if(rs.next()){
		    	  
		    	  	/**
					 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
					 */
		    	  suinfo.setId(rs.getInt("maxid") + 1);
		    	  	/**
		    	  	 * Leeres-Statement wird angelegt 
		    	  	 */
		    	  	stmt = con.createStatement();
		    	  	/**
		    	  	 * Ausfüllen des Statements und an die DB senden
		    	  	 */
		    		stmt.executeUpdate("INSERT INTO suchprofil_info (id, suchprofilid, infoid)" 
		    				+"VALUES (" +
	                        suinfo.getId() + "," + "'" +
	                        suinfo.getSuchprofilId() +"'" + "," +
	                        suinfo.getInfoId() +"'" + "," +
	                         ")");
		    	  
		      }
		}
		catch(SQLException e2){
			e2.printStackTrace();
		}
		return suinfo;
		}
		
		/**
		 * Löschen des Suchprofil-Objektes in der Datenbank
		 * @param such
		 */
		public void deleteSuchprofil_Info(Suchprofil_Info suchinfo) {
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
		    	
		      Statement stmt = con.createStatement();
		      /**
		       * Durchführung der Löschung / Ausfüllen des Statements und senden an die DB
		       */
		      stmt.executeUpdate("DELETE FROM suchprofil_info " + "WHERE id=" + suchinfo.getId());

		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		  }
		
		/**
		 * Erneutes schreiben in die Datenbank um das Suchprofil_Info-Objekt zu aktualisieren
		 * @param such
		 * @return
		 */
		 public Suchprofil_Info updateSuchprofil_Info(Suchprofil_Info suchinfo) {
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
			      Statement stmt = con.createStatement();
			      /**
			       * Updaten der Informationen des Suchprofils 
			       */
			      stmt.executeUpdate("UPDATE profil " 
			    		  			+ "SET suchprofilid=\""+ suchinfo.getSuchprofilId() + "\", " 
			    		  			+ "infoid=\"" + suchinfo.getInfoId()+ "\", "
			            		    + "WHERE id=" + suchinfo.getId());
		                         
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }

			    /**
			     * Um Analogie zu insertSuchprofil(Suchprofil such) zu wahren, geben wir such zurück
			     */
			    return suchinfo;
			  }
		 
		 /**
		  * Rückgabe der Suchprofil-Vektor Objekte
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
}
