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
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;

/**
 * * Die Mapper-Klasse stellt Methoden zur Verfügung die
 * <code>Auswahleigenschaft</code>-Objekte auf eine relationale Datenbank abbildet. Die
 * Methoden bieten die Möglichkeit Objekte aus der Datenbank zu suchen, sie zu
 * erzeugen und zu löschen. Das Mapping ist bidirektional. D.h., Objekte können
 * in DB-Strukturen und DB-Strukturen in Objekte umgewandelt werden.
 * 
 * Diese Mapper-Klasse besitzt Singleton-Eigenschaften und wird nur einmal
 * mithilfe der Methode <code>auswahleigenschaftMapper()</code> initialisiert. Der
 * Konstruktor ist bewusst durch <code>protected</code> geschützt, damit nur
 * eine einzige Instanz der Klasse exisitert.
 * 
 * @author Thies
 *
 */
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
	 * Geschï¿½tzter Konstruktor - verhindet die Mï¿½glichkeit, mit "new" neue
	 * Instanzen dieser Klasse zu erzeugen.
	 */

	protected AuswahleigenschaftMapper() {
	}

	/**
	 * Kann aufgerufen werden durch
	 * AuswahleigenschaftMapper.auswahleigenschaftMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * Methode soll nur über diese statische Methode aufgerufen werden
	 * @return auswahleigenschaftMapper
	 * @see AuswahleigenschaftMapper
	 */

	public static AuswahleigenschaftMapper auswahleigenschaftMapper() {
		if (auswahleigenschaftMapper == null) {
			auswahleigenschaftMapper = new AuswahleigenschaftMapper();
		}

		return auswahleigenschaftMapper;
	}

	/**
	 * Die Mehtode getAll erlaubt alles von Auswahleigenschaft anzeigen zu
	 * lassen (id, wert und eigenschaftid)
	 * 
	 * @return result
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
			 * FÃ¼r jeden Eintrag im Suchergebnis wird nun ein
			 * Auswahleigenschaft-Objekt erstellt.
			 */
			while (rs.next()) {
				Auswahleigenschaft aus = new Auswahleigenschaft();
				aus.setId(rs.getInt("id"));
				aus.setWert(rs.getString("wert"));
				/**
				 * HinzufÃ¼gen des neuen Objekts zum Ergebnisvektor
				 */
				result.addElement(aus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Ergebnisvektor zurÃ¼ckgeben
		 */
		return result;

	}
	/**
	 * Diese Methode fügt Daten in die Tabelle Auswahleignschaft ein
	 * @param aus
	 * @return aus
	 */
	public Auswahleigenschaft insertAuswahleigenschaft(Auswahleigenschaft aus) {
		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			Statement stmt = con.createStatement();
			/**
			 * Was ist der momentan hÃ¶chste PrimÃ¤rschlÃ¼ssel
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM auswahleigenschaft ");

			if (rs.next()) {
				/**
				 * Varaible merk erhÃ¤lt den hÃ¶chsten PrimÃ¤rschlÃ¼ssel
				 * inkrementiert um 1
				 */
				aus.setId(rs.getInt("maxid") + 1);
				/**
				 * DurchfÃ¼hren der EinfÃ¼ge Operation via Prepared Statement
				 */
				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO auswahleigenschaft (id, wert) " + "VALUES (?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, aus.getId());
				stmt1.setString(2, aus.getWert());

				stmt1.executeUpdate();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return aus;

	}

	/**
	 * Löschen des Objekt Auswahleigenschaft in der Datenbank
	 * @param aus
	 */
	public void deleteAuswahleigenschaft(Auswahleigenschaft aus) {
		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * DurchfÃ¼hrung der LÃ¶schoperation
			 */
			PreparedStatement stmt = con.prepareStatement("DELETE FROM auswahleigenschaft " + "WHERE id= ? ");
			stmt.setInt(1, aus.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Erneutes schreiben in die Datenbank um das Auswahleigenschaft Objekt zu
	 * aktualisieren
	 * 
	 * @param aus
	 * @return aus
	 */
	public Auswahleigenschaft updateAuswahleigenschaft(Auswahleigenschaft aus) {
		String sql = "UPDATE auswahleigenschaft SET  wert=? WHERE id=?";
		/**
		 * Aufbau der Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, aus.getWert());

			stmt.setInt(3, aus.getId());
			stmt.executeUpdate();

			System.out.println("Updated");

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		/**
		 * Die Auswahl wird zurÃ¼ckgegeben
		 */
		return aus;
	}

	/**
	 * Es wird nur ein Auswahleigenschaft-Objekt zurÃ¼ckgegeben, da ein
	 * KEy(PrimÃ¤rschlÃ¼ssel) eindeutig ist und nur einmal existiert.
	 * 
	 * @param id
	 * @return aus
	 */
	public Auswahleigenschaft findByKey(int id) {
		/**
		 * Aufbau der Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */

		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM auswahleigenschaft WHERE id=?");
			stmt.setInt(1, id);

			/**
			 * Statement ausfÃ¼llen und an die DB senden
			 */
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Auswahleigenschaft aus = new Auswahleigenschaft();
				aus.setId(rs.getInt("id"));
				aus.setWert(rs.getString("wert"));

				return aus;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}
	/**
	 * Es werden alle Informationen mit der InfoId in der auswahleigenschaften Tabelle ausgegeben
	 * @param info
	 * @return result
	 */
	//anschauen
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaftOf(Info info) {

		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();

		Vector<Auswahleigenschaft> result = new Vector<Auswahleigenschaft>();

		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM auswahleigenschaft WHERE infoid=? ");
			stmt.setInt(1, info.getId());

			ResultSet rs = stmt.executeQuery();

			/**
			 * FÃ¼r jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt
			 * erstellt.
			 */
			while (rs.next()) {
				Auswahleigenschaft aus = new Auswahleigenschaft();

				aus.setInfoid(rs.getInt("infoid"));
				/**
				 * HinzufÃ¼gen des neuen Objekts zum Ergebnisvektor
				 */

				System.out.println("Funktioniert");

				result.addElement(aus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Ergebnisvektor zurÃ¼ckgeben
		 */
		return result;
	}
}
