package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	//nochmal anschauen
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

	/**
	 * Durch die GetAll Methode werden alle Informationen, welche in der Tabelle
	 * Info gespeichert sind ausgelesen und zurückgegeben.
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Info> getAll() throws Exception {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen einer ArrayList Info
		 */
		ArrayList<Info> result = new ArrayList<Info>();

		try {
			/**
			 * Erstellen eines leeren Statements
			 */
			Statement stmt = con.createStatement();

			/**
			 * Abfrage alles (*) aus Tabelle info, welches in rs gespeichert
			 * wird
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `info`");

			/**
			 * Die while-Schleife erzeugt beim durchlauf ein Info Objekt in
			 * dieses wird die (Id, text, eigenschaftid und profilid) gesetzt
			 * und in das Info Objekt als Ergebnis abgespeichert
			 */
			while (rs.next()) {
				Info c = new Info();
				c.setId(rs.getInt("id"));
				c.setText(rs.getString("text"));
				c.setEigenschaftid(rs.getInt("eigenschaftid"));
				c.setProfilId(rs.getInt("profilid"));

				result.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	
	
	
	
	public Info insertInfo(Info in) {
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
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM info");

			if (rs.next()) {
				/**
				 * Varaible merk erhält den höchsten Primärschlüssel
				 * inkrementiert um 1
				 */
				in.setId(rs.getInt("maxid") + 1);
				/**
				 * Durchführen der Einfüge Operation via Prepared Statement
				 */
				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO info (id, text, profilid) " + "VALUES (?,?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, in.getId());
				stmt1.setString(2, in.getText());
				stmt1.setInt(3, in.getProfilId());

				stmt1.executeUpdate();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return in;

	}

	/**
	 * Löschen des Objekt Info in der Datenbank
	 * 
	 * @param in
	 */
	public void deleteInfo(Info in) {
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM info " + "WHERE id= ? ");
			stmt.setInt(1, in.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Erneutes schreiben in die Datenbank um das Info Objekt zu
	 * aktualisieren
	 * 
	 * @param in
	 * @return in
	 */
	public Info updateInfo(Info in) {
		String sql = "UPDATE Info SET text=?, profilid=?  WHERE id=?";
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

			stmt.setString(1, in.getText());
			stmt.setInt(2, in.getProfilId());

			stmt.setInt(3, in.getId());
			stmt.executeUpdate();

			System.out.println("Updated");

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		/**
		 * Die Info wird zurückgegeben
		 */
		return in;
	}

}