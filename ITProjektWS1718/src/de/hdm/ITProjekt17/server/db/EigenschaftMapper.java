package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	/**
	 * Die Methode findByKey ermöglicht es eine Eigenschaft via Schlüssel zu
	 * finden
	 * 
	 * @param id
	 * @return
	 */

	// nochmal anschauen
	public Eigenschaft findByKey(int id) {
		/**
		 * Aufbau einer DB Connection
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
			 * eigenschaft alles (*) aus der Eigenschaftstabelle
			 */
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

	/**
	 * Durch die GetAll Methode können alle Eigenschaften angezeigt werden
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Eigenschaft> getAll() throws Exception {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen eines Eigenschaft-Vektor-Objekts
		 */
		ArrayList<Eigenschaft> result = new ArrayList<Eigenschaft>();
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
			 * eigenschaft alles (*) aus der Eigenschaftstabelle
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft`");

			while (rs.next()) {
				/**
				 * Erstellen eines EIgenschafts-Objekts
				 */
				Eigenschaft c = new Eigenschaft();
				/**
				 * Es wird eine ID gesetzt welche zum Ergebnis Vektor ArrayList
				 * hinzugefügt wird
				 */
				c.setId(rs.getInt("id"));

				result.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public Eigenschaft insertEigenschaft(Eigenschaft eig) {
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
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM eigenschaft ");

			if (rs.next()) {
				/**
				 * Varaible merk erhält den höchsten Primärschlüssel
				 * inkrementiert um 1
				 */
				eig.setId(rs.getInt("maxid") + 1);
				/**
				 * Durchführen der Einfüge Operation via Prepared Statement
				 */
				PreparedStatement stmt1 = con.prepareStatement("INSERT INTO eigenschaft (id) " + "VALUES (?) ",
						Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, eig.getId());

				stmt1.executeUpdate();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return eig;

	}

	/**
	 * Löschen des Objekt Kontaktsperre in der Datenbank
	 * 
	 * @param pro
	 */
	public void deleteEigenschaft(Eigenschaft eig) {
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM eigenschaft " + "WHERE id= ? ");
			stmt.setInt(1, eig.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Erneutes schreiben in die Datenbank um das eigenschafteigenschaft Objekt zu
	 * aktualisieren
	 * 
	 * @param aus
	 * @return aus
	 */
	public Eigenschaft updateEigenschaft(Eigenschaft eig) {
		String sql = "UPDATE eigenschaft SET  id=? WHERE  id=?";
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

			stmt.setInt(1, eig.getId());
			stmt.setInt(2, eig.getId());

			stmt.executeUpdate();

			System.out.println("Updated");

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		/**
		 * Die eigenschaft wird zurückgegeben
		 */
		return eig;
	}

}
