package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;

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
	 * DIe insert Mehtode erlaubt es Daten in die Tabelle einzufügen, welche von einer Auwahleigenschaft geprägt ist (Dropdown)
	 * @param aus
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Auswahleigenschaft> insertAuswahleigenschaft(ArrayList<Auswahleigenschaft> aus) throws Exception {
		
		/**
		 * Aufbau einer Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling 
		 * Try = Versuch erst dies 
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Leeres Statement wird erstellt
			 */
			Statement stmt = con.createStatement();
			/**
			 * Eine erweiterte for-Schleife wird erstellt mit wert c : aus
			 */
			for (Auswahleigenschaft c : aus) {

				/**
				 * Es wird nach der maximalen Pimärschlüsselwert von auswahleigenschaft gefragt und in rs gespeichert
				 */
				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM auswahleigenschaft");

				if (rs.next()) {
					/**
					 * aus erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);
					
					/**
					 * Hier erfolgt die Einfügeoperation in die auswahleigenschaft Tabelle 
					 */
					stmt.executeUpdate("INSERT INTO `auswahleigenschaft` (`id`, `wert`, `eigenschaftid`) VALUES ("
							+ c.getId() + "', '" + c.getWert() + "', '" + c.getEigenschaftid() + "',);");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aus;
	}
	/**
	 * Die Update Methode erlaubt es nachträgliche updates hinzuzufügen, 
	 * welche schon eingetragen sind aber nochmals geändert werden müssen
	 * @param aus
	 * @return
	 * @throws Exception
	 */
	public Auswahleigenschaft updateAuswahleigenschaft(Auswahleigenschaft aus) throws Exception {
		/**
		 * Aufbau einer Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling 
		 * Try = Versuch erst dies 
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Leeres STatement wird erstellt
			 */
			Statement stmt = con.createStatement();
			
			/**
			 * Updateoperation wird durchgeführt
			 */
			stmt.executeUpdate("UPDATE `auswahleigenschaft` SET `id` = '" + aus.getId() + "', `wert` = '"
					+ aus.getWert() + "', `eigenschaftid` = '" + aus.getEigenschaftid()
					+ "' WHERE `auswahleigenschaft`.`id` = " + aus.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aus;
	}
	/**
	 * Die Delete Methode erlaubt es Auswahleigenschaften, welche ausgewählt wurden zu löschen
	 * @param aus
	 * @throws Exception
	 */
	public void deleteAuswahleigenschaft(Auswahleigenschaft aus) throws Exception {
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
			/**
			 * Erstellen eines Leeren Statements
			 */
			Statement stmt = con.createStatement();
			/**
			 * Durchführen der Löschoperation
			 */
			stmt.executeUpdate("DELETE FROM `auswahleigenschaft` WHERE `id` = " + aus.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Es wird die Auswahleigenschaft nach der Id abgefragt und zurückgegeben
	 * @param id
	 * @return
	 */
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
}
