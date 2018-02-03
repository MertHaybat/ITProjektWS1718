package de.hdm.ITProjekt17.server.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;
import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;


public class AehnlichkeitsmassMapper {


	/**
	 * Die Klasse AehnlichkeitsmassMapper wird nur einmal instantiiert. Man
	 * spricht hierbei von einem sogenannten Singleton. Durch static nur einmal
	 * vorhanden.
	 * 
	 * @see aehnlichkeitsmassMapper()
	 */

	private static AehnlichkeitsmassMapper aehnlichkeitsmassMapper = null;

	/**
	 * Geschï¿½tzter Konstruktor - verhindet die Mï¿½glichkeit, mit "new" neue
	 * Instanzen dieser Klasse zu erzeugen.
	 */

	protected AehnlichkeitsmassMapper() {
	}

	/**
	 * Kann aufgerufen werden durch
	 * AehnlichkeitsmassMapper.aehnlichkeitsmassMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * Methode soll nur über diese statische Methode aufgerufen werden
	 * @return aehnlichkeitsmassMapper
	 * @see AehnlichkeitsmassMapper
	 */

	public static AehnlichkeitsmassMapper aehnlichkeitsmassMapper() {
		if (aehnlichkeitsmassMapper == null) {
			aehnlichkeitsmassMapper = new AehnlichkeitsmassMapper();
		}

		return aehnlichkeitsmassMapper;
	}
	
	/**
	 * Die Mehtode getAll erlaubt alles von Aehnlichkeitsmass anzeigen zu
	 * lassen 
	 * 
	 * @return result
	 * @throws Exception
	 */

	public Vector<Aehnlichkeitsmass> getAll() {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen eines Aehnlichkeitsmass-Vektors namens Vector
		 */
		Vector<Aehnlichkeitsmass> result = new Vector<Aehnlichkeitsmass>();

		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM aehnlichkeitsmass");
			
			ResultSet rs = stmt.executeQuery();

			/**
			 * FÃ¼r jeden Eintrag im Suchergebnis wird nun ein
			 * Aehnlichkeitsmass-Objekt erstellt.
			 */
			while (rs.next()) {
				Aehnlichkeitsmass a = new Aehnlichkeitsmass();
				a.setId(rs.getInt("id"));
				a.setAehnlichkeitsindex(rs.getInt("aehnlichkeitsindex"));
				a.setEigenes_profilid(rs.getInt("eigenes_profilid"));
				a.setFremdes_profilid(rs.getInt("fremdes_profilid"));
				/**
				 * HinzufÃ¼gen des neuen Objekts zum Ergebnisvektor
				 */
				result.addElement(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Ergebnisvektor zurÃ¼ckgeben
		 */
		return result;

	}
	
	/**
	 * Diese Methode fügt Daten in die Tabelle Aehnlichkeitsmass ein
	 * @param a
	 * @return a
	 */
	public Aehnlichkeitsmass insertAehnlichkeitsmass(Aehnlichkeitsmass a) {
		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			Statement stmt = con.createStatement();
			/**
			 * Was ist der momentan hÃ¶chste PrimÃ¤rschlÃ¼ssel
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM aehnlichkeitsmass ");

			if (rs.next()) {
				/**
				 * Varaible merk erhÃ¤lt den hÃ¶chsten PrimÃ¤rschlÃ¼ssel
				 * inkrementiert um 1
				 */
				a.setId(rs.getInt("maxid") + 1);
				/**
				 * DurchfÃ¼hren der EinfÃ¼ge Operation via Prepared Statement
				 */
				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO aehnlichkeitsmass (eigenes_profilid, fremdes_profilid, aehnlichkeitsindex) " + "VALUES (?,?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, a.getEigenes_profilid());
				stmt1.setInt(2, a.getFremdes_profilid());
				stmt1.setInt(3, a.getAehnlichkeitsindex());

				stmt1.executeUpdate();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return a;

	}
	/**
	 * Es wird nur ein Aehnlichkeitsmass-Objekt zurÃ¼ckgegeben, da ein
	 * KEy(PrimÃ¤rschlÃ¼ssel) eindeutig ist und nur einmal existiert.
	 * 
	 * @param id
	 * @return a
	 */
	public Aehnlichkeitsmass findByKey(int id) {
		/**
		 * Aufbau der Db Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */

		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM aehnlichkeitsmass WHERE id=?");
			stmt.setInt(1, id);

			/**
			 * Statement ausfÃ¼llen und an die DB senden
			 */
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Aehnlichkeitsmass a = new Aehnlichkeitsmass();
				a.setId(rs.getInt("id"));
				a.setAehnlichkeitsindex(rs.getInt("aehnlichkeitsindex"));
				a.setEigenes_profilid(rs.getInt("eigenes_profilid"));
				a.setFremdes_profilid(rs.getInt("fremdes_profilid"));

				return a;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}
	
	/**
	 * Löschen des Objekt Aehnlichkeitsmass in der Datenbank
	 * @param a
	 */
	public void deleteAehnlichkeitsmass(Aehnlichkeitsmass a) {
		/**
		 * Aufbau der DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Try und Catch gehÃ¶ren zum Exception Handling Try = Versuch erst dies
		 * Catch = Wenn Try nicht geht versuch es so ..
		 */
		try {
			/**
			 * DurchfÃ¼hrung der LÃ¶schoperation
			 */
			PreparedStatement stmt = con.prepareStatement("DELETE FROM aehnlichkeitsmass " + "WHERE eigenes_profilid= ? ");
			stmt.setInt(1, a.getEigenes_profilid());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
