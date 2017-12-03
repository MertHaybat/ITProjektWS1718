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

	public ArrayList<Auswahleigenschaft> insertAuswahleigenschaft(ArrayList<Auswahleigenschaft> aus) throws Exception {// c
																														// f�r
																														// character
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			for (Auswahleigenschaft c : aus) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM auswahleigenschaft");

				if (rs.next()) {
					/*
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);

					stmt.executeUpdate("INSERT INTO `auswahleigenschaft` (`id`, `wert`, `eigenschaftid`) VALUES ("
							+ c.getId() + "', '" + c.getWert() + "', '" + c.getEigenschaftid() + "',);");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aus;
	}

	public Auswahleigenschaft updateAuswahleigenschaft(Auswahleigenschaft aus) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `auswahleigenschaft` SET `id` = '" + aus.getId() + "', `wert` = '"
					+ aus.getWert() + "', `eigenschaftid` = '" + aus.getEigenschaftid()
					+ "' WHERE `auswahleigenschaft`.`id` = " + aus.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aus;
	}

	public void deleteAuswahleigenschaft(Auswahleigenschaft aus) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `auswahleigenschaft` WHERE `id` = " + aus.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Auswahleigenschaft findByKey(int id) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `auswahleigenschaft` WHERE `id` = " + id);

			if (rs.next()) {
				Auswahleigenschaft p = new Auswahleigenschaft();
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

	public ArrayList<Auswahleigenschaft> getAll() throws Exception {

		Connection con = DBConnection.connection();

		ArrayList<Auswahleigenschaft> result = new ArrayList<Auswahleigenschaft>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `auswahleigenschaft`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			// if (rs.next()) {
			/*
			 * c erhält den bisher maximalen, nun um 1 inkrementierten
			 * Primärschlüssel.
			 */
			// a.setId(rs.getInt("") + 1);
			while (rs.next()) {
				Auswahleigenschaft c = new Auswahleigenschaft();// default
																// Konstruktor
																// in
																// Eigenscgaft.java
																// einf�gen
																// damit es kein
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
