package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class InfoMapper {

	/**
	 * Die Klasse InfoMapper wird nur einmal instantiiert. Man spricht hierbei
	 * von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * 
	 * @see infoMapper()
	 */

	private static InfoMapper infoMapper = null;

	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" neue
	 * Instanzen dieser Klasse zu erzeugen.
	 */
	protected InfoMapper() {
	}

	/**
	 * Kann aufgerufen werden durch InfoMapper.infoMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * 
	 * @return Das "InfoMapper-Objekt".
	 * @see InfoMapper
	 */
	public static InfoMapper infoMapper() {
		if (infoMapper == null) {
			infoMapper = new InfoMapper();
		}

		return infoMapper;
	}

	public ArrayList<Info> insertInfo(ArrayList<Info> in) throws Exception {// c
		// fuer
		// character
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			for (Info c : in) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM info");

				if (rs.next()) {
					/*
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);

					stmt.executeUpdate("INSERT INTO `info` (`id`, `text`, `profilid`) VALUES (" + c.getId() + "', '"+c.getText()+"','"+c.getProfilId()+");");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return in;
	}

	public Info updateInfo(Info in) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE `info` SET `id` = '" + in.getId() + "', `text` = '"
					+ in.getText() + "', `profilid` = '" + in.getProfilId()
					+ "' WHERE `id` = " + in.getId());
 
					
					
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return in;
	}

	public void deleteInfo(Info in) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `info` WHERE `id` = " + in.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Info findByKey(int id) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `info` WHERE `id` = " + id);

			if (rs.next()) {
				Info p = new Info();
				p.setId(rs.getInt("id"));
				p.setText(rs.getString("text"));

				return p;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}

		return null;
	}
	
	public ArrayList<Info> getAll() throws Exception {

		Connection con = DBConnection.connection();

		ArrayList<Info> result = new ArrayList<Info>();
		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `info`");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein

			while (rs.next()) {
				Info c = new Info();// default Konstruktor in
													// Eigenscgaft.java
													// einf�gen damit es kein
													// Fehler anzeigt
				c.setId(rs.getInt("id"));
				c.setText(rs.getString("text"));
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