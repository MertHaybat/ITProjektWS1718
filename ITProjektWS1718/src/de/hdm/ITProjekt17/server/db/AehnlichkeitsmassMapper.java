package de.hdm.ITProjekt17.server.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;


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
	 * 
	 * @return Das "AehnlichkeitsmassMapper-Objekt".
	 * @see aehnlichkeitsmassMapper
	 */

	/**
	 * Diese Methode gibt den aehnlichkeitsmassMapper zurück
	 * 
	 * @return aehnlichkeitsmassMapper
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM aehnlichkeitsmass " + "WHERE id= ? ");
			stmt.setInt(1, a.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
