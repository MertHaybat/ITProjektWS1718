package de.hdm.ITProjekt17.server.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
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
	protected ProfilMapper(){	
	}
	
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
     * Einfuegen eines <code>Profil</code>-Objekts in die Datenbank. Dabei wird
     * auch der Primaerschluessel des uebergebenen Objekts geprueft und ggf.
     * berichtigt.
     *
     * @param pro das zu speichernde Objekt
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
		      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
		              + "FROM profil ");
		     	
		      if(rs.next()){
		    	  	/**
					 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
					 */
		    	  	pro.setId(rs.getInt("maxid") + 1);	    	  	
		    	  	/**
		    	  	 * Durchführen der Einfüge Operation via Prepared Statement
		    	  	 */
		    	  		PreparedStatement stmt1 = con.prepareStatement(
		    	  				"INSERT INTO profil(id, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher) "
		    	  				+ "VALUES (?,?,?,?,?,?,?,?) ",
		    	  				Statement.RETURN_GENERATED_KEYS);
		    	  				stmt1.setInt(1, pro.getId());
		    	  				stmt1.setString(2, pro.getVorname());
		    	  				stmt1.setString(3, pro.getNachname());
		    	  				stmt1.setDate(4, (Date) pro.getGeburtsdatum());
		    	  				stmt1.setInt(5, pro.getKoerpergroesse());
		    	  				stmt1.setString(6, pro.getReligion());
		    	  				stmt1.setString(7, pro.getHaarfarbe());
		    	  				stmt1.setBoolean(8, pro.getRaucher());
		    	  				
		    	  				
		    	  				stmt1.executeUpdate();
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
	    	/**
		      * Durchführung der Löschoperation
		      */
	     PreparedStatement stmt = con.prepareStatement("DELETE FROM profil " + "WHERE id= ? ");
	     stmt.setInt(1, pro.getId());
	     stmt.executeUpdate();

	  
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
		 	String sql = "UPDATE profil SET  vorname=?, nachname=?, geburtsdatum=?, koerpergroesse=?, religion=?, haarfarbe=?, raucher=? WHERE id=?";
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
		    	
		    	
		    	stmt.setString(1, pro.getVorname());
		    	stmt.setString(2, pro.getNachname());
		    	stmt.setDate(3, (Date) pro.getGeburtsdatum());
		    	stmt.setInt(4, pro.getKoerpergroesse());
		    	stmt.setString(5, pro.getReligion());
		    	stmt.setString(6, pro.getHaarfarbe());
		    	stmt.setBoolean(7, pro.getRaucher());

		    	stmt.setInt(8, pro.getId());
		    	stmt.executeUpdate();
		    	
		    	System.out.println("Updated");
		   
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		    /**
		     *  Das Profil wird zurückgegeben
		     */
		    return pro;
		  }
	 
	 	/**
		 * Mit der Methode GetAll werden alle Profil in einem Ergebnis-Vektor namens Profil gespeichert und zurückgegeben
		 * @return
		 */
		 public Vector<Profil> getAllProfil() {
			 
			 	/**
			 	 * Aufbau der DB Connection
			 	 */
			    Connection con = DBConnection.connection();
			  
			    Vector<Profil> result = new Vector<Profil>();
			    try {
			    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM profil ");
			    	
			      
			    	ResultSet rs = stmt.executeQuery();
			        
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
		 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM profil WHERE id=?");
		 			stmt.setInt(1, id);
		
		 			/**
		 			 * Statement ausfüllen und an die DB senden
		 			 */
		 			ResultSet rs = stmt.executeQuery();
			
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
}
