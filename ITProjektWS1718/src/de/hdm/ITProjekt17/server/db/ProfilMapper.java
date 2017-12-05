package de.hdm.ITProjekt17.server.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class ProfilMapper {

	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Die Klasse ProfilMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see profilMapper()
	 */
	
	private static ProfilMapper profilMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
	 * neue Instanzen dieser Klasse zu erzeugen.
	 */
//	protected ProfilMapper(){	
//	}
	
	/**
	 * Kann aufgerufen werden durch ProfilMapper.profilMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * @return Das "ProfilMapper-Objekt".
	 * @see profilMapper
	 */
	public static ProfilMapper profilMapper(){
		if (profilMapper == null){
			profilMapper = new ProfilMapper();
		}
		
		return profilMapper;
	}
	
    /**
     * Einfuegen eines <code>Account</code>-Objekts in die Datenbank. Dabei wird
     * auch der Primaerschluessel des uebergebenen Objekts geprueft und ggf.
     * berichtigt.
     *
     * @param a das zu speichernde Objekt
     * @return das bereits uebergebene Objekt, jedoch mit ggf. korrigierter
     * <code>id</code>.
     * 
     * @author thies
     */
	
	public Profil insertProfil(Profil pro){
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
		      ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS maxid "
		              + "FROM profil ");
		     	
		      if(rs.next()){
		    	  	/**
					 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
					 */
		    	  	pro.setId(rs.getInt("maxid") + 1);
		    	  	/**
					 * Ein Statement wird erzeugt
					 */
		    	  	stmt = con.createStatement();
		    	  	
		    	  	/**
		    	  	 * Durchführen der Updateoperation
		    	  	 */
		    		stmt.executeUpdate("INSERT INTO profil (id, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher)" 
		    				+"VALUES (" +
	                        pro.getId() + "," + "'" +
	                        pro.getVorname() +"'" + "," +
	                        pro.getNachname() +"'" + "," +
	                        pro.getGeburtsdatum() +"," + 
	                        pro.getKoerpergroesse() + "," + 
	                        pro.getReligion() + "," + "'" +
	                        pro.getHaarfarbe() +"'" + ","+
	                        pro.getRaucher() +
	                         ")");
		    	  
		      }
		}
		catch(SQLException e2){
			e2.printStackTrace();
		}
		return pro;
		
	}
	/**
	 * Löschen des Objekt Profil in der Datenbank
	 * @param pro
	 */
	public void deleteProfil(Profil pro) {
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
	       * Durchführung der Löschoperation
	       */
	      stmt.executeUpdate("DELETE FROM profil " + "WHERE id=" + pro.getId());

	    }
	    catch (SQLException e2) {
	      e2.printStackTrace();
	    }
	  }
	
	/**
	 * Erneutes schreiben in die Datenbank um das Profil Objekt zu aktualisieren
	 * @param pro
	 * @return pro
	 */
	 public Profil updateProfil(Profil pro) {
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
		       * Durchführung der Updateoperation
		       */
		      stmt.executeUpdate("UPDATE profil " 
		    		  			+ "SET vorname=\""+ pro.getVorname() + "\", " 
		    		  			+ "nachname=\"" + pro.getNachname() + "\", "
		    		  			+ "geburtsdatum=\"" + pro.getGeburtsdatum() + "\", "
		    		  			+ "koerpergroesse=\"" + pro.getKoerpergroesse() + "\", "
		    		  			+ "religion=\"" + pro.getReligion() + "\", "
		    		  			+ "haarfarbe=\"" + pro.getHaarfarbe() + "\", "
		    		  			+ "raucher=\"" + pro.getRaucher() + "\", "
		            		    + "WHERE id=" + pro.getId());
	                         
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		    /**
		     *  Um Analogie zu insert(Profil pro) zu wahren, geben wir pro zurück
		     */
		    return pro;
		  }
	/**
	 * Es wird nur ein Profil-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
	 * ist und nur einmal existiert.
	 * @param id
	 * @return pro
	 */
	public Profil findByKey(int id){
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
		Statement stmt = con.createStatement();		
		
		/**
		 * Statement ausfüllen und an die DB senden
		 */
		ResultSet rs = stmt.executeQuery("SELECT * FROM profil " + "WHERE id=" + id);
			
		if (rs.next()){
			Profil pro = new Profil();
			pro.setId(rs.getInt("id"));
			pro.setVorname(rs.getString("vorname"));
			pro.setNachname(rs.getString("nachname"));
			pro.setGeburtsdatum(rs.getDate("geburtsdatum"));
			pro.setKoerpergroesse(rs.getInt("koerpergroesse"));
			pro.setReligion(rs.getString("religion"));
			pro.setHaarfarbe(rs.getString("haarfarbe"));
			pro.setRaucher(rs.getBoolean("raucher"));
			
			return pro;
		}
	}
		catch (SQLException e2){
			e2.printStackTrace();
			return null;
		}

		return null;
	}
	/**
	 * Mit der Methode GetAll werden alle Profil in einem Ergebnis-Vektor namens Profil gespeichert und zurückgegeben
	 * @return
	 */
	 public Vector<Profil> getAll() {
		 
		 	/**
		 	 * Aufbau der DB Connection
		 	 */
		    Connection con = DBConnection.connection();
		    
		    /**
		     * Erstellen des Ergebnis Verktors Profil
		     */
		    Vector<Profil> result = new Vector<Profil>();
		
		    try {
		        Statement stmt = con.createStatement();
		        
		        /**
		         *Statement wird ausgefüllt und an die DB gesendet
		         */
		        ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher "
		            + "FROM profil "  
		            + "' ORDER BY id");

		        /**
		         * Für jeden Eintrag im Suchergebnis wird nun ein Profil-Objekt erstellt.
		         */
		        while (rs.next()) {
		          Profil pro = new Profil();
		          pro.setId(rs.getInt("id"));
		          pro.setVorname(rs.getString("vorname"));
		          pro.setNachname(rs.getString("nachname"));
		          pro.setGeburtsdatum(rs.getDate("geburtsdatum"));
		          pro.setKoerpergroesse(rs.getInt("koerpergroesse"));
		          pro.setReligion(rs.getString("religion"));
		          pro.setHaarfarbe(rs.getString("haarfarbe"));
		          pro.setRaucher(rs.getBoolean("raucher"));
		          
		          /**
		           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
		           */
		          result.addElement(pro);
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
