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
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
/**
 * 
 * @author samina
 *
 */
public class FreitexteigenschaftMapper {

	/**
	 * Die Klasse FreitexteigenschaftMapper wird nur einmal instantiiert. Man
	 * spricht hierbei von einem sogenannten Singleton. Durch static nur einmal
	 * vorhanden.
	 * 
	 * @see freitexteigenschaftMapper()
	 */

	private static FreitexteigenschaftMapper freitexteigenschaftMapper = null;

	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" neue
	 * Instanzen dieser Klasse zu erzeugen.
	 */
	protected FreitexteigenschaftMapper() {
	}

	/**
	 * Kann aufgerufen werden durch
	 * FreitexteigenschaftMapper.freitexteigenschaftMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * Methode soll nur über diese statische Methode aufgerufen werden
	 * @return freitexteigenschaftMapper
	 * @see FreitexteigenschaftMapper
	 */
	public static FreitexteigenschaftMapper freitexteigenschaftMapper() {
		if (freitexteigenschaftMapper == null) {
			freitexteigenschaftMapper = new FreitexteigenschaftMapper();
		}

		return freitexteigenschaftMapper;
	}

	/**
 	 * Es wird nur ein Freitexteigenschaft-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
 	 * ist und nur einmal existiert.
 	 * @param id
 	 * @return aus
 	 */
 	public Freitexteigenschaft findByKey(int id){
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
 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM freitexteigenschaft WHERE id=?");
 			stmt.setInt(1, id);

 			/**
 			 * Statement ausfüllen und an die DB senden
 			 */
 			ResultSet rs = stmt.executeQuery();
	
 			if (rs.next()){
 				Freitexteigenschaft frei = new Freitexteigenschaft();
 				frei.setId(rs.getInt("id"));
 				frei.setWert(rs.getString("wert"));
   
 				return frei;
 			}
 		}
 		catch (SQLException e2){
 			e2.printStackTrace();
 			return null;
 		}
return null;
 	}


 	/**
	 * Die Mehtode getAll erlaubt alles von Freitexteigenschaft anzeigen zu lassen (id, wert und eigenschaftid)
	 * @return
	 * @throws Exception
	 */
	public Vector<Freitexteigenschaft> getAll() {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen eines Freitexteigenschaft-Vektors namens ArrayList
		 */
		Vector<Freitexteigenschaft> result = new Vector<Freitexteigenschaft>();
		
	try {
    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM freitexteigenschaft ");
    	
      
    	ResultSet rs = stmt.executeQuery();
        
        /**
         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
         */
        while (rs.next()) {
          Freitexteigenschaft frei = new Freitexteigenschaft();
          frei.setId(rs.getInt("id"));
          frei.setWert(rs.getString("wert"));
          /**
           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
           */
          result.addElement(frei);
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
	 * Diese Methode fügt eine Freitexteigenschaft ein
	 * @param frei
	 * @return frei
	 */
	public Freitexteigenschaft insertFreitexteigenschaft(Freitexteigenschaft frei) {
		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			Statement stmt = con.createStatement();
			/**
			 * Was ist der momentan höchste Primärschlüssel
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM freitexteigenschaft ");

			if (rs.next()) {
				/**
				 * Varaible merk erhält den höchsten Primärschlüssel
				 * inkrementiert um 1
				 */
				frei.setId(rs.getInt("maxid") + 1);
				/**
				 * Durchführen der Einfüge Operation via Prepared Statement
				 */
				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO freitexteigenschaft (id, wert) " + "VALUES (?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, frei.getId());
				stmt1.setString(2, frei.getWert());

				stmt1.executeUpdate();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return frei;

	}

	/**
	 * Löschen des Objekt Freitexteigenschaft in der Datenbank
	 * 
	 * @param pro
	 */
	public void deleteFreitexteigenschaft(Freitexteigenschaft frei) {
		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Durchführung der Löschoperation
			 */
			PreparedStatement stmt = con.prepareStatement("DELETE FROM freitexteigenschaft " + "WHERE id= ? ");
			stmt.setInt(1, frei.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Erneutes schreiben in die Datenbank um das Freitexteigenschaft Objekt zu
	 * aktualisieren
	 * 
	 * @param frei
	 * @return frei
	 */
	public Freitexteigenschaft updateFreitexteigenschaft(Freitexteigenschaft frei) {
		String sql = "UPDATE freitexteigenschaft SET wert=? WHERE id=?";
		/**
		 * Aufbau der Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, frei.getWert());

			stmt.setInt(2, frei.getId());
			stmt.executeUpdate();

			System.out.println("Updated");

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		/**
		 * Die Freitexteigenschaft wird zurückgegeben
		 */
		return frei;
	}
	/**
	 * liest alle Freitexteigenschaften aus der Info aus
	 * @param info
	 * @return result
	 */
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaftOf(Info info){
		 
	 	/**
	 	 * Aufbau der DB Connection
	 	 */
	    Connection con = DBConnection.connection();
	  
	    Vector<Freitexteigenschaft> result = new Vector<Freitexteigenschaft>();
	    
	    try {
	    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM freitexteigenschaft WHERE infoid=? ");
	    	stmt.setInt(1, info.getId());
	      
	    	ResultSet rs = stmt.executeQuery();
	        
	        /**
	         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
	         */
	        while (rs.next()) {
	          Freitexteigenschaft frei = new Freitexteigenschaft();
	        

	          frei.setInfoid(rs.getInt("infoid"));
	          /**
	           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
	           */
	          
	          System.out.println("Funktioniert");
	          
	          result.addElement(frei);
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


