package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;

public class SuchprofilMapper {

	/**
	 * Die Klasse SuchprofilMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see suchprofilMapper()
	 */
	
	private static SuchprofilMapper suchprofilMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
	 * neue Instanzen dieser Klasse zu erzeugen.
	 */
	protected SuchprofilMapper(){	
	}
	
	/**
	 * Kann aufgerufen werden durch SuchprofilMapper.suchprofilMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * @return Das "SuchprofilMapper-Objekt".
	 * @see SuchprofilMapper
	 */
	public static SuchprofilMapper suchprofilMapper(){
		if (suchprofilMapper == null){
			suchprofilMapper = new SuchprofilMapper();
		}
		
		return suchprofilMapper;
	}
	/**
	 * Durch die Methode findByKey kann ein Suchprofil anhand seines Primärschlüssels zurückgegeben werden
	 * @param id
	 * @return
	 */
	public Suchprofil findByKey(int id){
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
		 * Auswahl alles (*) aus der Tabelle Suchprofil und das Ergebnis wird in der Variablen result gespeichert
		 */
		ResultSet rs = stmt.executeQuery("SELECT * FROM `suchprofil` WHERE `id` = " + id);
		
		if (rs.next()){
			/**
			 * Erstellen eines Suchprofil-Objektes und setzten der Werte 
			 */
			Suchprofil p = new Suchprofil();
			p.setId(rs.getInt("id"));
			p.setMinAlter(rs.getInt("minAlter"));
			p.setMaxAlter(rs.getInt("maxAlter"));
			p.setGeburtsdatum(rs.getDate("geburtsdatum"));
			p.setKoerpergroesse(rs.getInt("koerpergroesse"));
			p.setReligion(rs.getString("religion"));
			p.setHaarfarbe(rs.getString("haarfarbe"));
			p.setRaucher(rs.getBoolean("raucher"));
			
			/**
			 * Rückgabe des Suchprofils p 
			 */
			return p;
		}
	}
		catch (SQLException e2){
			e2.printStackTrace();
			return null;
		}

		return null;
	}
	
		public Suchprofil insertSuchprofil(Suchprofil such){
		/**
		 * DB COnnection wird aufgebaut
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
		              + "FROM suchprofil ");
		     	
		      if(rs.next()){
		    	  
		    	  	/**
					 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
					 */
		    	  	such.setId(rs.getInt("maxid") + 1);
		    	  	/**
		    	  	 * Leeres-Statement wird angelegt 
		    	  	 */
		    	  	stmt = con.createStatement();
		    	  	/**
		    	  	 * Ausfüllen des Statements und an die DB senden
		    	  	 */
		    		stmt.executeUpdate("INSERT INTO suchprofil (id, minalter, maxalter, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher)" 
		    				+"VALUES (" +
	                        such.getId() + "," + "'" +
	                        such.getMinAlter() +"'" + "," +
	                        such.getMaxAlter() +"'" + "," +
	                        such.getGeburtsdatum() +"," + 
	                        such.getKoerpergroesse() + "," + 
	                        such.getReligion() + "," + "'" +
	                        such.getHaarfarbe() +"'" + ","+
	                        such.getRaucher() +
	                         ")");
		    	  
		      }
		}
		catch(SQLException e2){
			e2.printStackTrace();
		}
		return such;
		}
		
		/**
		 * Löschen des Suchprofil-Objektes in der Datenbank
		 * @param such
		 */
		public void deleteSuchprofil(Suchprofil such) {
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
		      stmt.executeUpdate("DELETE FROM suchprofil " + "WHERE id=" + such.getId());

		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		  }
		
		/**
		 * Erneutes schreiben in die Datenbank um das Suchprofil-Objekt zu aktualisieren
		 * @param such
		 * @return
		 */
		 public Suchprofil updateSuchprofil(Suchprofil such) {
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
			    		  			+ "SET vorname=\""+ such.getMinAlter() + "\", " 
			    		  			+ "nachname=\"" + such.getMaxAlter() + "\", "
			    		  			+ "geburtsdatum=\"" + such.getGeburtsdatum() + "\", "
			    		  			+ "koerpergroesse=\"" + such.getKoerpergroesse() + "\", "
			    		  			+ "religion=\"" + such.getReligion() + "\", "
			    		  			+ "haarfarbe=\"" + such.getHaarfarbe() + "\", "
			    		  			+ "raucher=\"" + such.getRaucher() + "\", "
			            		    + "WHERE id=" + such.getId());
		                         
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }

			    /**
			     * Um Analogie zu insertSuchprofil(Suchprofil such) zu wahren, geben wir such zurück
			     */
			    return such;
			  }
		 
		 /**
		  * Rückgabe der Suchprofil-Vektor Objekte
		  * @return result
		  */
		 public Vector<Suchprofil> getAll() {
			 /**
			  * Aufbau Db Connection
			  */
			    Connection con = DBConnection.connection();
			    
			    /**
			     * Verktor-Objekt wird erzeugt
			     */
			    Vector<Suchprofil> result = new Vector<Suchprofil>();
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
			        ResultSet rs = stmt.executeQuery("SELECT id, minalter, maxalter, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher "
			            + "FROM suchprofil "  
			            + "' ORDER BY id");

			        /**
			         * Für jeden Eintrag im Suchergebnis wird nun ein Suchprofil-Objekt erstellt.
			         */
			        while (rs.next()) {
			          Suchprofil suchp = new Suchprofil();
			          suchp.setId(rs.getInt("id"));
			          suchp.setMinAlter(rs.getInt("minalter"));
			          suchp.setMaxAlter(rs.getInt("maxalter"));
			          suchp.setGeburtsdatum(rs.getDate("geburtsdatum"));
			          suchp.setKoerpergroesse(rs.getInt("koerpergroesse"));
			          suchp.setReligion(rs.getString("religion"));
			          suchp.setHaarfarbe(rs.getString("haarfarbe"));
			          suchp.setRaucher(rs.getBoolean("raucher"));
			          
			          /**
			           * Hinzufügen des neuen Objekts zum Ergebnisvektor
			           */
			          result.addElement(suchp);
			        }
			      }
			      catch (SQLException e) {
			        e.printStackTrace();
			      }
			      return result;
		 }
}
