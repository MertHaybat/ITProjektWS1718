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
	/**
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Info> insertInfo(ArrayList<Info> in) throws Exception {
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
			 * Erstellen eines Leeren Statements
			 */
			Statement stmt = con.createStatement();
			
			for (Info c : in) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM info");

				if (rs.next()) {
					/**
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);
					/**
					 * Eigentliche Einfügeoperation
					 */
					stmt.executeUpdate("INSERT INTO `info` (`id`, `text`, `profilid`) VALUES (" + c.getId() + "', '"+c.getText()+"','"+c.getProfilId()+");");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return in;
	}
	/**
	 * Mit der Updatefunktion wird das Updaten von Daten in der Tabelle Info durchgeführt
	 * @param in
	 * @return in
	 * @throws Exception
	 */
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
	/**
	 * Mit der delete Funktion wird das Löschen von Info Datensätzen ermöglicht
	 * @param in
	 * @throws Exception
	 */
	public void deleteInfo(Info in) throws Exception {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM `info` WHERE `id` = " + in.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * Durch die findByKey Operation kann eine Info nach der Id gesucht und zurückgegeben werden
 * @param id
 * @return
 */
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
	 * Durch die GetAll Methode werden alle Informationen, welche in der Tabelle Info gespeichert sind ausgelesen und zurückgegeben.
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
			 * Abfrage alles (*) aus Tabelle info, welches in rs gespeichert wird
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `info`");
			
			/**
			 * Die while-Schleife erzeugt beim durchlauf ein Info Objekt in dieses wird die (Id, text, eigenschaftid und profilid) gesetzt
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

}