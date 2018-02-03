package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Besuch;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * Die Mapper-Klasse stellt Methoden zur Verfügung die
 * <code>Besuch</code>-Objekte auf eine relationale Datenbank abbildet. Die
 * Methoden bieten die Möglichkeit Objekte aus der Datenbank zu suchen, sie zu
 * erzeugen und zu löschen. Das Mapping ist bidirektional. D.h., Objekte können
 * in DB-Strukturen und DB-Strukturen in Objekte umgewandelt werden.
 * 
 * Diese Mapper-Klasse besitzt Singleton-Eigenschaften und wird nur einmal
 * mithilfe der Methode <code>besuchMapper()</code> initialisiert. Der
 * Konstruktor ist bewusst durch <code>protected</code> geschützt, damit nur
 * eine einzige Instanz der Klasse exisitert.
 * 
 * 
 * @author Samina
 *
 */

public class BesuchMapper {

	private static BesuchMapper besuchMapper = null;
	
	protected BesuchMapper() {

	};

	/**
	 * Diese statische Methode zum Erzeugen eines <code>BesuchMapper</code> kann
	 * aufgerufen werden durch <code>BesuchMapper.besuchMapper()</code>. Sie
	 * stellt die Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur
	 * eine einzige Instanz von <code>BesuchMapper</code> existiert.
	 * <p>
	 * 
	 * @return BesuchMapper
	 * @see BesuchMapper
	 */

	public static BesuchMapper besuchMapper() {
		if (besuchMapper == null) {
			besuchMapper = new BesuchMapper();
		}

		return besuchMapper;
	}

	/**
	 * Diese Methode ermöglicht es einen Besuch in der Datenbank anzulegen.
	 * 
	 * @param besuch
	 * @return besuch
	 */

	public Besuch insert(Besuch besuch) {

		Connection con = DBConnection.connection();

		Vector<Besuch> besuchteProfile = findByKey(besuch.getBesuchenderNutzerID());

		for (int i = 0; i < besuchteProfile.size(); i++) {
			if (besuchteProfile.get(i).getBesuchterNutzerID() == besuch.getBesuchterNutzerID()) {
				return null;
			}
		}
		
		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM besuch ");

			if (rs.next()) {

				besuch.setId(rs.getInt("maxid") + 1);

				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO besuch (id, besuchendernutzerid, besuchternutzerid) " + "VALUES (?, ?, ?) ",
						Statement.RETURN_GENERATED_KEYS);

				stmt1.setInt(1, besuch.getId());
				stmt1.setInt(2, besuch.getBesuchenderNutzerID());
				stmt1.setInt(3, besuch.getBesuchterNutzerID());

				stmt1.executeUpdate();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		return besuch;
	}

	/**
	 * Diese Methode ermöglicht das Löschen eines Besuchs und dessen Referenzen
	 * zu anderen Klassen
	 * 
	 * @param besuch
	 */

	public void delete(Besuch besuch) {
		Connection con = DBConnection.connection();

		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM besuch " + "WHERE besuchendernutzerid= ? AND besuchternutzerid= ?");

			stmt.setInt(1, besuch.getBesuchenderNutzerID());
			stmt.setInt(2, besuch.getBesuchterNutzerID());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public void deleteeinzeln(Besuch besuch) {
		Connection con = DBConnection.connection();

		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM besuch " + "WHERE besuchendernutzerid= ? OR besuchternutzerid= ?");

			stmt.setInt(1, besuch.getBesuchenderNutzerID());
			stmt.setInt(2, besuch.getBesuchenderNutzerID());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	/**
	 * BEsuche werden gelöscht durch beide Profil Ids vom besuchter und besuchender Nutzer.
	 * @param besuchendernutzerid
	 * @param besuchternutzerid
	 */
	public void deleteByProfilId(Profil pro, int besuchternutzerid) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();
	  
	      stmt.executeUpdate("DELETE FROM besuch " + "WHERE besuchendernutzerid=" + pro.getId()+" AND besuchternutzerid="+besuchternutzerid);

	    }
	    catch (SQLException e2) {
	      e2.printStackTrace();
	    }
	  }
	
	

	/**
		 * Diese Methode ermöglicht es Besuche aus der Datenbank, anhand deren ID des besuchender Nutzer auszulesen.
		 * 
		 * @param profilid
		 * @return besuche
		 */
	  
	  public Vector<Besuch> findByKey(int besuchendernutzerid) {

		    Connection con = DBConnection.connection();

		    Vector<Besuch> besuch = new Vector<Besuch>();

		    try {
		    PreparedStatement stmt = con.prepareStatement ("SELECT * FROM besuch "
		          + "WHERE besuchendernutzerid=" + besuchendernutzerid +" ORDER BY id");
		     

		      ResultSet rs = stmt.executeQuery();

		      	while (rs.next()) {
		        Besuch besuche = new Besuch();
		        besuche.setId(rs.getInt("id"));
		        besuche.setBesuchenderNutzerID(rs.getInt("besuchendernutzerid"));
		        besuche.setBesuchterNutzerID(rs.getInt("besuchternutzerid"));

		        
		        besuch.addElement(besuche);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		    return besuch;
		  }

	  
	  
	  /**
	   * Diese Methode liest alle besuchten Profile aus, die der Nutzer besucht hat
	   * @param pro
	   * @return result
	   */
	  public Vector<Besuch> getAllBesucheDesBesuchenden(Profil pro) {
			 
		 	/**
		 	 * Aufbau der DB Connection
		 	 */
		    Connection con = DBConnection.connection();
		  
		    Vector<Besuch> result = new Vector<Besuch>();
		    
		    try {
		    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM besuch WHERE besuchendernutzerid=? ");
		    	stmt.setInt(1, pro.getId());
		      
		    	ResultSet rs = stmt.executeQuery();
		        
		        /**
		         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
		         */
		        while (rs.next()) {
		          Besuch besuche = new Besuch();
		        
		          besuche.setId(rs.getInt("id"));
		          besuche.setBesuchenderNutzerID(rs.getInt("besuchendernutzerid"));
		          besuche.setBesuchterNutzerID(rs.getInt("besuchternutzerid"));
		          /**
		           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
		           */
		          
		      
		          result.addElement(besuche);
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
	   * Diese Methode updatet alle Besuche
	   * @param besuche
	   * @return besuche
	   */
	 
	  public Besuch update(Besuch besuche) {
		 	String sql = "UPDATE besuch SET  besuchendernutzerid=?, besuchternutzerid=? WHERE id =?";
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
		    	
		    
		    	stmt.setInt(1, besuche.getBesuchenderNutzerID());
		    	stmt.setInt(2, besuche.getBesuchterNutzerID());
		    	stmt.setInt(3, besuche.getId());
		    	
		    

		    	
		    	stmt.executeUpdate();
		    	
		    
		   
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		    /**
		     *  Das Profil wird zurückgegeben
		     */
		    return besuche;
		  }
	  public Vector<Besuch> getAllBesucherOfProfil(Profil pro) {
			 
		 	/**
		 	 * Aufbau der DB Connection
		 	 */
		    Connection con = DBConnection.connection();
		  
		    Vector<Besuch> result = new Vector<Besuch>();
		    
		    try {
		    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM besuch WHERE  besuchternutzerid=? ");
		    	stmt.setInt(1, pro.getId());
		      
		    	ResultSet rs = stmt.executeQuery();
		        
		        /**
		         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
		         */
		        while (rs.next()) {
		          Besuch besuche = new Besuch();
		        
		          besuche.setId(rs.getInt("id"));
		          besuche.setBesuchenderNutzerID(rs.getInt("besuchendernutzerid"));
		          besuche.setBesuchterNutzerID(rs.getInt("besuchternutzerid"));
		          /**
		           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
		           */
		          
		      
		          result.addElement(besuche);
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
	  public Vector<Besuch> getAllBesuche() {
			 
		 	/**
		 	 * Aufbau der DB Connection
		 	 */
		    Connection con = DBConnection.connection();
		  
		    Vector<Besuch> result = new Vector<Besuch>();
		    
		    try {
		    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM besuch ");
		      
		    	ResultSet rs = stmt.executeQuery();
		        
		        /**
		         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
		         */
		        while (rs.next()) {
		          Besuch besuche = new Besuch();
		        
		          besuche.setId(rs.getInt("id"));
		          besuche.setBesuchenderNutzerID(rs.getInt("besuchendernutzerid"));
		          besuche.setBesuchterNutzerID(rs.getInt("besuchternutzerid"));
		          /**
		           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
		           */
		          
		      
		          result.addElement(besuche);
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
