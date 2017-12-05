package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
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
	/**
	 * Diese Methode erlaubt das Einfügen in die Tabelle einer Datenbank
	 * @param frei
	 * @return frei
	 * @throws Exception
	 */
	public ArrayList<Freitexteigenschaft> insertFreitexteigenschaft(ArrayList<Freitexteigenschaft> frei)
			throws Exception {
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
			 * Erweiterte for-Schleife, welche die mac Id von freitexteigenschaft durchzählt und in rs speichert
			 */
			for (Freitexteigenschaft c : frei) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM freitexteigenschaft");

				if (rs.next()) {
					/**
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);
					/**
					 * Einfügeoperation in freitexteigenschafts Tabelle
					 */
					stmt.executeUpdate("INSERT INTO `freitexteigenschaft` (`id`, `wert`, `eigenschaftid`) VALUES ("
							+ c.getId() + "', '" + c.getWert() + "', '" + c.getEigenschaftid() + "',);");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frei;
	}
	/**
	 * Diese Methode erlaubt das Updaten der Tabelle Freitexteigenschaft 
	 * @param frei
	 * @return
	 * @throws Exception
	 */
	public Freitexteigenschaft updateFreitexteigenschaft(Freitexteigenschaft frei) throws Exception {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehören zum Exception Handling 
		 * Try = Versuch erst dies 
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Erstellen eines leeren Statements
			 */
			Statement stmt = con.createStatement();
			/**
			 * Durchführung der eigentlichen Updateoperation in die Tabelle freitexteigenschaft
			 */
			stmt.executeUpdate("UPDATE `freitexteigenschaft` SET `id` = '" + frei.getId() + "', `wert` = '"
					+ frei.getWert() + "', `eigenschaftid` = '" + frei.getEigenschaftid()
					+ "' WHERE `freitexteigenschaft`.`id` = " + frei.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return frei;
	}
	/**
	 * Diese Methode erlaubt das Löschen in der Tabelle Freitexteigenschaft
	 * @param frei
	 * @throws Exception
	 */
	public void deleteFreitexteigenschaft(Freitexteigenschaft frei) throws Exception {
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
			 * Erstellen eines leeren Statements 
			 */
			Statement stmt = con.createStatement();
			
			/**
			 * Löschoperation wird durchgeführt, welche die id und die dazugehörigen Dtaen löscht 
			 */
			stmt.executeUpdate("DELETE FROM `freitexteigenschaft` WHERE `id` = " + frei.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Mit dieser Methode können Freitexteigenschaften per Primärschlüssel abgefragt werden
	 * @param id
	 * @return
	 */
	public Freitexteigenschaft findByKey(int id) {
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
			 * Erstellen eines leeren Statements
			 */
			Statement stmt = con.createStatement();
			/**
			 * AUswahl alles (*) aus Tabelle freitexteigenschaft und das Ergebnis wird in rs gespeichert
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
	 *Mit dieser Methode können alle Freitexteigenschaften abgefragt werden
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
		 * Try und Catch gehören zum Exception Handling 
		 * Try = Versuch erst dies 
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * Erstellen eines leeren Statements
			 */
			Statement stmt = con.createStatement();
			/**
			 * Auswahl alles (*) aus Tabelle freitexteigenschaft und das Ergebnis wird in der Varaible rs gespeichert
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `freitexteigenschaft`");
			/**
			 * Ergebnis von rs durchläuft die while-Schleife und erstellt ein Freitexteigenschafts-Objekt,
			 * welche die id, wert und eigenschaftid setzt und mit result.add(c) in dem Objekt Freitexteigenschaft abspeichert
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

}
