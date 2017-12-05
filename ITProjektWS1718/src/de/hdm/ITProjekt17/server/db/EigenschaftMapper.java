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
	
	/**
	 * Mit der insert Methode können EIgenschaften hinzugefügt werden 
	 * @param eig
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Eigenschaft> insertEigenschaft(ArrayList<Eigenschaft> eig) throws Exception {
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
			for (Eigenschaft c : eig) {

				ResultSet rs = stmt.executeQuery("SELECT MAX(`id`) AS maxid FROM eigenschaft");

				if (rs.next()) {
					/**
					 * c erhält den bisher maximalen, nun um 1 inkrementierten
					 * Primärschlüssel.
					 */
					c.setId(rs.getInt("maxid") + 1);
					/**
					 * Einfügeoperation in die Eigenschafts Tabelle
					 */
					stmt.executeUpdate("INSERT INTO `eigenschaft` (`id`) VALUES (" + c.getId());

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * Rückgabe vom Wert eig
		 */
		return eig;
	}
	/**
	 * Mit dieser Methode können Tabellen geupdated werden
	 * @param eig
	 * @return
	 * @throws Exception
	 */
	public Eigenschaft updateEigenschaft(Eigenschaft eig) throws Exception {
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
			 * Updateoperation in die eigsnchafts Tabelle wird durchgeführt
			 */
			stmt.executeUpdate("UPDATE `eigenschaft` SET `id` = '" + eig.getId() + "' WHERE `eigenschaft`.`id` = " + eig.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eig;
	}
	/**
	 * DIe Delete Methode gewährleistet die Löschung von Eigenschaften 
	 * @param eig
	 * @throws Exception
	 */
	public void deleteEigenschaft(Eigenschaft eig) throws Exception {
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
				 * Durchführung der Löschoperation
				 */
			stmt.executeUpdate("DELETE FROM `eigenschaft` WHERE `id` = " + eig.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

   /**
	* Die Methode findByKey ermöglicht es eine Eigenschaft via Schlüssel zu finden
	* @param id
	* @return
	*/
	public Eigenschaft findByKey(int id) {
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
			 * Auswahl alles (*) aus der Eigenschaftstabelle 
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
			 * Auswahl alles (*) aus der Eigenschaftstabelle
			 */
			ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft`");

			while (rs.next()) {
				/**
				 * Erstellen eines EIgenschafts-Objekts
				 */
				Eigenschaft c = new Eigenschaft();
				/**
				 * Es wird eine ID gesetzt welche zum Ergebnis Vektor ArrayList hinzugefügt wird
				 */
				c.setId(rs.getInt("id"));
			
				
				result.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
