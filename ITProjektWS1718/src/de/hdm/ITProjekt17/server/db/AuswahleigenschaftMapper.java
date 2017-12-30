package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;

public class AuswahleigenschaftMapper {

	/**
	 * Die Klasse AuswahleigenschaftMapper wird nur einmal instantiiert. Man
	 * spricht hierbei von einem sogenannten Singleton. Durch static nur einmal
	 * vorhanden.
	 * 
	 * @see auswahleigenschaftMapper()
	 */

	private static AuswahleigenschaftMapper auswahleigenschaftMapper = null;

	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" neue
	 * Instanzen dieser Klasse zu erzeugen.
	 */
	protected AuswahleigenschaftMapper() {
	}

	/**
	 * Kann aufgerufen werden durch
	 * AuswahleigenschaftMapper.auswahleigenschaftMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * 
	 * @return Das "AuswahleigenschaftMapper-Objekt".
	 * @see AuswahleigenschaftMapper
	 */
	public static AuswahleigenschaftMapper auswahleigenschaftMapper() {
		if (auswahleigenschaftMapper == null) {
			auswahleigenschaftMapper = new AuswahleigenschaftMapper();
		}

		return auswahleigenschaftMapper;
	}

	
	/**
	 * Die Mehtode getAll erlaubt alles von Auswahleigenschaft anzeigen zu lassen (id, wert und eigenschaftid)
	 * @return
	 * @throws Exception
	 */
	public Vector<Auswahleigenschaft> getAll() {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen eines Auswahleigenschafts-Vektors namens Vector
		 */
		Vector<Auswahleigenschaft> result = new Vector<Auswahleigenschaft>();
		
	try {
    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM auswahleigenschaft ");
    	
      
    	ResultSet rs = stmt.executeQuery();
        
        /**
         * Für jeden Eintrag im Suchergebnis wird nun ein Auswahleigenschaft-Objekt erstellt.
         */
        while (rs.next()) {
          Auswahleigenschaft aus = new Auswahleigenschaft();
          aus.setId(rs.getInt("id"));
          aus.setWert(rs.getString("wert"));
          aus.setEigenschaftid(rs.getInt("eigenschaftid"));
          /**
           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
           */
          result.addElement(aus);
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
	
	public Auswahleigenschaft insertAuswahleigenschaft(Auswahleigenschaft aus){
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
		              + "FROM auswahleigenschaft ");
		     	
		      if(rs.next()){
		    	  	/**
					 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
					 */
		    	  	aus.setId(rs.getInt("maxid") + 1);	    	  	
		    	  	/**
		    	  	 * Durchführen der Einfüge Operation via Prepared Statement
		    	  	 */
		    	  		PreparedStatement stmt1 = con.prepareStatement(
		    	  				"INSERT INTO auswahleigenschaft (id, wert, eigenschaftid) "
		    	  				+ "VALUES (?,?,?) ",
		    	  				Statement.RETURN_GENERATED_KEYS);
		    	  				stmt1.setInt(1, aus.getId());
		    	  				stmt1.setString(2, aus.getWert());
		    	  				stmt1.setInt(3, aus.getEigenschaftid());
		    	  				
		    	  				
		    	  				
		    	  				stmt1.executeUpdate();
		      }
		}
		catch(SQLException e2){
			e2.printStackTrace();
		}
		return aus;
		
	}
	/**
	 * Löschen des Objekt Auswahleigenschaft in der Datenbank
	 * @param aus
	 */
	public void deleteAuswahleigenschaft (Auswahleigenschaft aus) {
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
	     PreparedStatement stmt = con.prepareStatement("DELETE FROM auswahleigenschaft " + "WHERE id= ? ");
	     stmt.setInt(1, aus.getId());
	     stmt.executeUpdate();

	  
	    }
	    catch (SQLException e2) {
	      e2.printStackTrace();
	    }
	  }
	
	/**
	 * Erneutes schreiben in die Datenbank um das Auswahleigenschaft Objekt zu aktualisieren
	 * @param aus
	 * @return aus
	 */
	 public Auswahleigenschaft updateAuswahleigenschaft(Auswahleigenschaft aus){
		 	String sql = "UPDATE auswahleigenschaft SET  wert=?, eigenschaftid=? WHERE id=?";
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
		    	
		    	
		    	stmt.setString(1, aus.getWert());
		    	stmt.setInt(2, aus.getEigenschaftid());

		    	stmt.setInt(3, aus.getId());
		    	stmt.executeUpdate();
		    	
		    	System.out.println("Updated");
		   
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		    /**
		     *  Die Auswahl wird zurückgegeben
		     */
		    return aus;
		  }

		/**
	 	 * Es wird nur ein Auswahleigenschaft-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
	 	 * ist und nur einmal existiert.
	 	 * @param id
	 	 * @return aus
	 	 */
	 	public Auswahleigenschaft findByKey(int id){
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
	 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM auswahleigenschaft WHERE id=?");
	 			stmt.setInt(1, id);
	
	 			/**
	 			 * Statement ausfüllen und an die DB senden
	 			 */
	 			ResultSet rs = stmt.executeQuery();
		
	 			if (rs.next()){
	 				Auswahleigenschaft aus = new Auswahleigenschaft();
	 				aus.setId(rs.getInt("id"));
	 				aus.setWert(rs.getString("wert"));
	 				aus.setEigenschaftid(rs.getInt("eigenschaftid"));
	 			
       
	 				return aus;
	 			}
	 		}
	 		catch (SQLException e2){
	 			e2.printStackTrace();
	 			return null;
	 		}
	return null;
	 	}
	
}
