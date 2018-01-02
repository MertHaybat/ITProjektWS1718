package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Besuch;

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

	private static BesuchMapper BesuchMapper = null;

	protected BesuchMapper() {

	}

	/**
	 * Diese statische Methode zum Erzeugen eines <code>BesuchMapper</code> kann
	 * aufgerufen werden durch <code>BesuchMapper.besuchMapper()</code>. Sie
	 * stellt die Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur
	 * eine einzige Instanz von <code>BesuchMapper</code> existiert.
	 * <p>
	 * 
	 * @return Das einzige <code>BesuchMapper</code>-Objekt.
	 * @see BesuchMapper
	 */

	public static BesuchMapper besuchMapper() {
		if (BesuchMapper == null) {
			BesuchMapper = new BesuchMapper();
		}

		return BesuchMapper;
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

			ResultSet rs = stmt.executeQuery("SELECT MAX(besuchid) AS maxid " + "FROM besuch ");

			if (rs.next()) {

				besuch.setId(rs.getInt("maxid") + 1);

				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO besuch (besuchid, besuchendernutzer, besuchternutzer) " + "VALUES (?, ?, ?) ",
						Statement.RETURN_GENERATED_KEYS);

				stmt1.setInt(1, besuch.getId());
				stmt1.setInt(2, besuch.getBesuchenderNutzerID());
				stmt1.setInt(3, besuch.getBesuchenderNutzerID());

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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM besuch " + "WHERE id= ?");

			stmt.setInt(1, besuch.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
		 * Diese Methode ermöglicht es Besuche aus der Datenbank, anhand deren ID auszulesen.
		 * 
		 * @param profilid
		 * @return besuche
		 */
	  
	  public Vector<Besuch> findByKey(int profilid) {

		    Connection con = DBConnection.connection();

		    Vector<Besuch> besuch = new Vector<Besuch>();

		    try {
		    PreparedStatement stmt = con.prepareStatement ("SELECT * FROM besuch "
		          + "WHERE besuchendernutzer=" + profilid +" ORDER BY besuchid");
		     

		      ResultSet rs = stmt.executeQuery();

		      	while (rs.next()) {
		        Besuch besuche = new Besuch();
		        besuche.setId(rs.getInt("besuchid"));
		        besuche.setBesuchenderNutzerID(rs.getInt("besuchendernutzer"));
		        besuche.setBesuchterNutzerID(rs.getInt("besuchternutzer"));

		        
		        besuch.addElement(besuche);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		    return besuch;
		  }

}
