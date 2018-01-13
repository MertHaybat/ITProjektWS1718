package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Profil;
/**
 * 
 * @author samina
 *
 */
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
 	 * Es wird nur ein Eigenschaft-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
 	 * ist und nur einmal existiert.
 	 * @param id
 	 * @return eig
 	 */
// 	public Eigenschaft findByKey(int id){
// 		/**
// 		 * Aufbau der Db Connection
// 		 */
// 		Connection con = DBConnection.connection();
// 		/**
// 		 * Try und Catch gehören zum Exception Handling 
// 		 * Try = Versuch erst dies 
// 		 * Catch = Wenn Try nicht geht versuch es so ..
// 		 */
//
// 		try{	
// 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM eigenschaft WHERE id=?");
// 			stmt.setInt(1, id);
//
// 			/**
// 			 * Statement ausfüllen und an die DB senden
// 			 */
// 			ResultSet rs = stmt.executeQuery();
//	
// 			if (rs.next()){
// 				Eigenschaft eig = new Eigenschaft();
// 				eig.setId(rs.getInt("id"));
// 				
// 			
//   
// 				return eig;
// 			}
// 		}
// 		catch (SQLException e2){
// 			e2.printStackTrace();
// 			return null;
// 		}
//return null;
// 	}

 	/**
	 * Die Mehtode getAll erlaubt alles von Eigenschaft anzeigen zu lassen (id)
	 * @return
	 * @throws Exception
	 */
//	public Vector<Eigenschaft> getAll() {
//		/**
//		 * Aufbau einer DB Connection
//		 */
//		Connection con = DBConnection.connection();
//		/**
//		 * Erstellen eines Eigenschaft-Vektors namens Vector
//		 */
//		Vector<Eigenschaft> result = new Vector<Eigenschaft>();
//		
//	try {
//    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM eigenschaft ");
//    	
//      
//    	ResultSet rs = stmt.executeQuery();
//        
//        /**
//         * Für jeden Eintrag im Suchergebnis wird nun ein Eigenschaft-Objekt erstellt.
//         */
//        while (rs.next()) {
//          Eigenschaft eig = new Eigenschaft();
//          eig.setId(rs.getInt("id"));
//         
//          /**
//           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
//           */
//          result.addElement(eig);
//        }
//      }
//      catch (SQLException e) {
//        e.printStackTrace();
//      }
//
//      /**
//       *  Ergebnisvektor zurückgeben
//       */
//      return result;
//	
//	}
	/**
	 * 
	 * @param eig
	 * @return eig 
	 */
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
	 * Löschen des Objekt Eigenschaft in der Datenbank
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
	 * Erneutes schreiben in die Datenbank um das Eigenschaft-Objekt zu
	 * aktualisieren
	 * 
	 * @param eig
	 * @return eig
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
