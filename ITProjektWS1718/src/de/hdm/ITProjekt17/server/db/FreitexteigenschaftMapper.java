package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;

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
	 * 
	 * @return Das "FreitexteigenschaftMapper-Objekt".
	 * @see FreitexteigenschaftMapper
	 */
	public static FreitexteigenschaftMapper freitexteigenschaftMapper() {
		if (freitexteigenschaftMapper == null) {
			freitexteigenschaftMapper = new FreitexteigenschaftMapper();
		}

		return freitexteigenschaftMapper;
	}

	// nochmals anschauen
	public Freitexteigenschaft findByKey(int id) {
		/**
		 * Aufbau einer Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Erstellen eines leeren Statements
			 */
			Statement stmt = con.createStatement();
			/**
			 * Freitexteigenschaft alles (*) aus Tabelle freitexteigenschaft und das
			 * Ergebnis wird in rs gespeichert
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `freitexteigenschaft` WHERE `id` = " + id);

			if (rs.next()) {
				Freitexteigenschaft p = new Freitexteigenschaft();
				p.setId(rs.getInt("id"));
				p.setWert(rs.getString("wert"));

				return p;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}

		return null;
	}

	/**
	 * Mit dieser Methode können alle Freitexteigenschaften abgefragt werden
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Freitexteigenschaft> getAll() throws Exception {
		/**
		 * Aufbau einer Db Connection
		 */
		Connection con = DBConnection.connection();

		/**
		 * Erstellen eines Ergebnis Objektes namens result (ArrayList)
		 */
		ArrayList<Freitexteigenschaft> result = new ArrayList<Freitexteigenschaft>();
		/**
		 * Try und Catch gehören zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Erstellen eines leeren Statements
			 */
			Statement stmt = con.createStatement();
			/**
			 * Freitexteigenschaft alles (*) aus Tabelle freitexteigenschaft und das
			 * Ergebnis wird in der Varaible rs gespeichert
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `freitexteigenschaft`");
			/**
			 * Ergebnis von rs durchläuft die while-Schleife und erstellt ein
			 * Freitexteigenschafts-Objekt, welche die id, wert und
			 * eigenschaftid setzt und mit result.add(c) in dem Objekt
			 * Freitexteigenschaft abspeichert
			 */
			while (rs.next()) {
				Freitexteigenschaft c = new Freitexteigenschaft();
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
						"INSERT INTO freitexteigenschaft (id, wert, eigenschaftid) " + "VALUES (?,?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, frei.getId());
				stmt1.setString(2, frei.getWert());
				stmt1.setInt(3, frei.getEigenschaftid());

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
		String sql = "UPDATE freitexteigenschaft SET  wert=?, eigenschaftid=? WHERE id=?";
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
			stmt.setInt(2, frei.getEigenschaftid());

			stmt.setInt(3, frei.getId());
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

}
