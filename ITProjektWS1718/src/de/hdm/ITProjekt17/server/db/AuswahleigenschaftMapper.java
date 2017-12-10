package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;

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
	public ArrayList<Auswahleigenschaft> getAll() throws Exception {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen eines Auswahleigenschafts-Vektors namens ArrayList
		 */
		ArrayList<Auswahleigenschaft> result = new ArrayList<Auswahleigenschaft>();
		try {
			/**
			 * Erstellen eines Leeren Statements
			 */
			Statement stmt = con.createStatement();

			/**
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `auswahleigenschaft`");

			while (rs.next()) {
				Auswahleigenschaft c = new Auswahleigenschaft();
				c.setId(rs.getInt("id"));
				c.setWert(rs.getString("wert"));
				c.setEigenschaftid(rs.getInt("eigenschaftid"));
				
				result.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	 * Löschen des Objekt Kontaktsperre in der Datenbank
	 * @param pro
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
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //nochmal anschauen
	 
	 public Auswahleigenschaft findByKey(int id) {
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
				 * Erstellen eines Leeren Statements
				 */
				Statement stmt = con.createStatement();
				/**
				 * Das Ergebnis der Abfrage wird in rs gespeichert
				 */
				ResultSet rs = stmt.executeQuery("SELECT * FROM `auswahleigenschaft` WHERE `id` = " + id);

				if (rs.next()) {
					/**
					 * Erstellen eines Auswahleigenschafts-Objekts namens p
					 */
					Auswahleigenschaft p = new Auswahleigenschaft();
					p.setId(rs.getInt("id"));
					p.setWert(rs.getString("wert"));
					
					/**
					 * Werte die aus der Db zurückgegeben werden, werden gesetzt und zurückgegeben (id, wert)
					 */
					return p;
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				return null;
			}

			return null;
		}
	
	
}
