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
		
		Connection con = DBConnection.connection();
		
		try {
		      Statement stmt = con.createStatement();
		      
		      ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS maxid "
		              + "FROM profil ");
		     	
		      if(rs.next()){
		    	  
		    	  	pro.setId(rs.getInt("maxid") + 1);
		    	  
		    	  	stmt = con.createStatement();
		    	  	
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
	 * @param p
	 */
	public void deleteProfil(Profil pro) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM profil " + "WHERE id=" + pro.getId());

	    }
	    catch (SQLException e2) {
	      e2.printStackTrace();
	    }
	  }
	
	/**
	 * Erneutes schreiben in die Datenbank um das Profil Objekt zu aktualisieren
	 * @param p
	 * @return
	 */
	 public Profil updateProfil(Profil pro) {
		    Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

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

		    // Um Analogie zu insert(Profil pro) zu wahren, geben wir pro zurück
		    return pro;
		  }
	

	public Profil findByKey(int id){
		Connection con = DBConnection.connection();
		
		try{
		Statement stmt = con.createStatement();		
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
	 public Vector<Profil> getAll() {
		 
		    Connection con = DBConnection.connection();
		    
		    Vector<Profil> result = new Vector<Profil>();
		
		    try {
		        Statement stmt = con.createStatement();

		        ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher "
		            + "FROM profil "  
		            + "' ORDER BY id");

		        // Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
		        // erstellt.
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
		          
		          // Hinzufügen des neuen Objekts zum Ergebnisvektor
		          result.addElement(pro);
		        }
		      }
		      catch (SQLException e) {
		        e.printStackTrace();
		      }

		      // Ergebnisvektor zurückgeben
		      return result;
	 }
}
