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

	public ArrayList<Freitexteigenschaft> insertFreitexteigenschaft(ArrayList<Freitexteigenschaft> frei)
			throws Exception {// c f�r character
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			for (Freitexteigenschaft c : frei) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM freitexteigenschaft");

				if (rs.next()) {
					/*
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);

					stmt.executeUpdate("INSERT INTO `freitexteigenschaft` (`id`, `wert`, `eigenschaftid`) VALUES ("
							+ c.getId() + "', '" + c.getWert() + "', '" + c.getEigenschaftid() + "',);");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frei;
	}

	public Freitexteigenschaft updateFreitexteigenschaft(Freitexteigenschaft frei) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `freitexteigenschaft` SET `id` = '" + frei.getId() + "', `wert` = '"
					+ frei.getWert() + "', `eigenschaftid` = '" + frei.getEigenschaftid()
					+ "' WHERE `freitexteigenschaft`.`id` = " + frei.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return frei;
	}

	public void deleteFreitexteigenschaft(Freitexteigenschaft frei) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `freitexteigenschaft` WHERE `id` = " + frei.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Freitexteigenschaft findByKey(int id) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
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

	public ArrayList<Freitexteigenschaft> getAll() throws Exception {

		Connection con = DBConnection.connection();

		ArrayList<Freitexteigenschaft> result = new ArrayList<Freitexteigenschaft>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `freitexteigenschaft`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// a.setId(rs.getInt("") + 1);
			while (rs.next()) {
				Freitexteigenschaft c = new Freitexteigenschaft();// default
																	// Konstruktor
																	// in
																	// Eigenscgaft.java
																	// einf�gen
																	// damit es
																	// kein
																	// Fehler
																	// anzeigt
				c.setId(rs.getInt("id"));
				c.setWert(rs.getString("wert"));
				Eigenschaft e = new Eigenschaft();
				e.setId(rs.getInt("eigenschaftid"));
				c.setEigenschaft(e);
				// a.setId(rs.getInt("") + 1);
				result.add(c);
			}

			stmt = con.createStatement();

			// Jetzt erst erfolgt die tatsächliche Einfügeoperation
			// stmt.executeUpdate("");
			// return result;
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
