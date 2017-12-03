package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class EigenschaftMapper {
	/**
	 * Die Klasse EigenschaftMapper wird nur einmal instantiiert. Man spricht
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal
	 * vorhanden.
	 * 
	 * @see eigenschaftMapper()
	 */

	private static EigenschaftMapper eigenschaftMapper = null;

	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" neue
	 * Instanzen dieser Klasse zu erzeugen.
	 */
	protected EigenschaftMapper() {
	}

	/**
	 * Kann aufgerufen werden durch EigenschaftMapper.eigenschaftMapper. Sie
	 * stellt die Singleton-Eigenschaft sicher.
	 * 
	 * @return Das "EigenschaftMapper-Objekt".
	 * @see EigenschaftMapper
	 */
	public static EigenschaftMapper eigenschaftMapper() {
		if (eigenschaftMapper == null) {
			eigenschaftMapper = new EigenschaftMapper();
		}

		return eigenschaftMapper;
	}

	public ArrayList<Eigenschaft> insertEigenschaft(ArrayList<Eigenschaft> eig) throws Exception {// c
																									// fuer
																									// character
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			for (Eigenschaft c : eig) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM eigenschaft");

				if (rs.next()) {
					/*
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);

					stmt.executeUpdate("INSERT INTO `eigenschaft` (`id`, `profilid`) VALUES (" + c.getId() + "', '"
							+ c.getProfilid() + "',);");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eig;
	}

	public Eigenschaft updateEigenschaft(Eigenschaft eig) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `eigenschaft` SET `id` = '" + eig.getId() + "', `profilid` = '"
					+ eig.getProfilid() + "' WHERE `eigenschaft`.`id` = " + eig.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eig;
	}

	public void deleteEigenschaft(Eigenschaft eig) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `eigenschaft` WHERE `id` = " + eig.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Eigenschaft findByKey(int id) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft` WHERE `id` = " + id);

			if (rs.next()) {
				Eigenschaft p = new Eigenschaft();
				p.setId(rs.getInt("id"));

				return p;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}

		return null;
	}

	public ArrayList<Eigenschaft> getAll() throws Exception {

		Connection con = DBConnection.connection();

		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein

			while (rs.next()) {
				Eigenschaft c = new Eigenschaft();// default Konstruktor in
													// Eigenscgaft.java
													// einf�gen damit es kein
													// Fehler anzeigt
				c.setId(rs.getInt("id"));
				Profil p = new Profil();
				p.setId(rs.getInt("profilid"));
				c.setProfil(p);
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
