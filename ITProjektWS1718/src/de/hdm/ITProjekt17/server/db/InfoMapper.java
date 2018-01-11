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
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil_Info;

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
 	 * Es wird nur ein Info-Objekt zurückgegeben, da ein KEy(Primärschlüssel) eindeutig
 	 * ist und nur einmal existiert.
 	 * @param id
 	 * @return in
 	 */
 	public Info findByKey(int id){
 		/**
 		 * Aufbau der Db Connection
 		 */
 		Connection con = DBConnection.connection();
 		/**
 		 * Try und Catch gehören zum Exception Handling 
 		 * Try = Versuch erst dies 
 		 * Catch = Wenn Try nicht geht versuch es so ..
 		 */

 		try{	
 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM info WHERE id=?");
 			stmt.setInt(1, id);

 			/**
 			 * Statement ausfüllen und an die DB senden
 			 */
 			ResultSet rs = stmt.executeQuery();
	
 			if (rs.next()){
 				Info in = new Info();
 				in.setId(rs.getInt("id"));
 				in.setText(rs.getString("text"));
 		        in.setProfilId(rs.getInt("profilid"));
 		        in.setAuswahleigenschaftid(rs.getInt("auswahleigenschaftid"));
 		        in.setFreitexteigenschaftid(rs.getInt("freitexteigenschaftid"));
 		        
 				return in;
 			}
 		}
 		catch (SQLException e2){
 			e2.printStackTrace();
 			return null;
 		}
return null;
 	}
	
	/**
	 * Die Methode getAll erlaubt alles von Info anzeigen zu lassen (id)
	 * @return
	 * @throws Exception
	 */
	public Vector<Info> getAll() {
		/**
		 * Aufbau einer DB Connection
		 */
		Connection con = DBConnection.connection();
		/**
		 * Erstellen eines Info-Vektors namens Info
		 */
		Vector<Info> result = new Vector<Info>();
		
	try {
    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM info ");
    	
      
    	ResultSet rs = stmt.executeQuery();
        
        /**
         * Für jeden Eintrag im Suchergebnis wird nun ein Info-Objekt erstellt.
         */
        while (rs.next()) {
          Info in = new Info();
          in.setId(rs.getInt("id"));
          in.setText(rs.getString("text"));
          in.setAuswahleigenschaftid(rs.getInt("auswahleigenschaftid"));
          in.setFreitexteigenschaftid(rs.getInt("freitexteigenschaftid"));
          in.setProfilId(rs.getInt("profilid"));
          /**
           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
           */
          result.addElement(in);
        }
      }
      catch (SQLException e) {
        e.printStackTrace();
      }

      /**
       *  Ergebnisvektor zurückgeben
       */
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
				 * Durchführen der Einfügeoperation via Prepared Statement
				 */
				PreparedStatement stmt1 = con.prepareStatement(
						"INSERT INTO info (id, text, profilid, auswahleigenschaftid, freitexteigenschaftid) " + "VALUES (?,?,?,?,?) ",
						Statement.RETURN_GENERATED_KEYS);
						stmt1.setInt(1, in.getId());
						stmt1.setString(2, in.getText());
						stmt1.setInt(3, in.getProfilId());
						stmt1.setInt(4, in.getAuswahleigenschaftid());
						stmt1.setInt(5, in.getFreitexteigenschaftid());
						
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM info " + "WHERE id=? ");
			stmt.setInt(1, in.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Löschen der Referenz zwischen den Objekten Info und Profil in der Datenbank
	 * 
	 * @param pro
	 */
	public void deleteInfoOf(Profil pro) {
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM info " + "WHERE profilid= ? ");
			stmt.setInt(1, pro.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 * Löschen der Referenz zwischen den Objekten Info und Profil in der Datenbank
	 * 
	 * @param pro
	 */
	public void deleteInfoOf(Suchprofil_Info suchinfo) {
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM info " + "WHERE infoid=?, suchprofilid=? ");
			stmt.setInt(1, suchinfo.getInfoId());
			stmt.setInt(2, suchinfo.getSuchprofilId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	
	/**
	 * Löschen der Referenz zwischen den Objekten Info und Auswahleigenschaft in der Datenbank
	 * 
	 * @param aus
	 */
	public void deleteInfoOf(Auswahleigenschaft aus) {
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM info " + "WHERE auswahleigenschaftid= ? ");
			stmt.setInt(1, aus.getId());
			stmt.executeUpdate();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 * Löschen der Referenz zwischen den Objekten Info und Profil in der Datenbank
	 * 
	 * @param frei
	 */
	public void deleteInfoOf(Freitexteigenschaft frei) {
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
			PreparedStatement stmt = con.prepareStatement("DELETE FROM info " + "WHERE freitexteigenschaftid= ? ");
			stmt.setInt(1, frei.getId());
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
		String sql = "UPDATE Info SET text=?, profilid=?, auswahleigenschaftid=?, freitexteigenschaftid=? WHERE id=?";
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

			stmt.setInt(3, in.getAuswahleigenschaftid());
			stmt.setInt(4, in.getFreitexteigenschaftid());
			stmt.setInt(5, in.getId());

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
	
	
	
	
	
	
	public Vector<Info> getInfoIdByProfilId(Profil pro) {
		 
	 	/**
	 	 * Aufbau der DB Connection
	 	 */
	    Connection con = DBConnection.connection();
	  
	    Vector<Info> result = new Vector<Info>();
	    
	    try {
	    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM info WHERE profilid=? ");
	    	stmt.setInt(1, pro.getId());
	      
	    	ResultSet rs = stmt.executeQuery();
	        
	        /**
	         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
	         */
	        while (rs.next()) {
	          Info info = new Info();
	        

	          info.setId(rs.getInt("id"));
	          /**
	           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
	           */
	          
	          System.out.println("Funktioniert");
	          
	          result.addElement(info);
	        }
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	      }

	      /**
	       *  Ergebnisvektor zurückgeben
	       */
	      return result;
 }

	public Vector<Info> getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus){
		 
	 	/**
	 	 * Aufbau der DB Connection
	 	 */
	    Connection con = DBConnection.connection();
	  
	    Vector<Info> result = new Vector<Info>();
	    
	    try {
	    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM info WHERE auswahleigenschaftid=? ");
	    	stmt.setInt(1, aus.getId());
	      
	    	ResultSet rs = stmt.executeQuery();
	        
	        /**
	         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
	         */
	        while (rs.next()) {
	          Info info = new Info();
	        
	          info.setAuswahleigenschaftid(rs.getInt("auswahleigenschaftid"));
	          /**
	           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
	           */
	          
	          System.out.println("Funktioniert");
	          
	          result.addElement(info);
	        }
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	      }

	      /**
	       *  Ergebnisvektor zurückgeben
	       */
		return result;
	}
	
	public Vector<Info> getAllInfosAsAuswahleigenschaftByProfilId(Auswahleigenschaft aus, Profil pro){
		 
	 	/**
	 	 * Aufbau der DB Connection
	 	 */
	    Connection con = DBConnection.connection();
	  
	    Vector<Info> result = new Vector<Info>();
	    
	    try {
	    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM info WHERE auswahleigenschaftid=?, profilid=? ");
	    	stmt.setInt(1, aus.getId());
	    	stmt.setInt(2, pro.getId());
	      
	    	ResultSet rs = stmt.executeQuery();
	        
	        /**
	         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
	         */
	        while (rs.next()) {
	          Info info = new Info();
	        

	          info.setAuswahleigenschaftid(rs.getInt("auswahleigenschaftid"));
	          info.setProfilId(rs.getInt("profilid"));
	          /**
	           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
	           */
	          
	          System.out.println("Funktioniert");
	          
	          result.addElement(info);
	        }
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	      }

	      /**
	       *  Ergebnisvektor zurückgeben
	       */
		return result;
	}
	
	public Vector<Info> getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei){
		 
	 	/**
	 	 * Aufbau der DB Connection
	 	 */
	    Connection con = DBConnection.connection();
	  
	    Vector<Info> result = new Vector<Info>();
	    
	    try {
	    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM info WHERE freitexteigenschaftid=? ");
	    	stmt.setInt(1, frei.getId());
	      
	    	ResultSet rs = stmt.executeQuery();
	        
	        /**
	         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
	         */
	        while (rs.next()) {
	          Info info = new Info();
	        

	          info.setFreitexteigenschaftid(rs.getInt("freitexteigenschaftid"));
	          /**
	           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
	           */
	          
	          System.out.println("Funktioniert");
	          
	          result.addElement(info);
	        }
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	      }

	      /**
	       *  Ergebnisvektor zurückgeben
	       */
		return result;
	}
	
	public Vector<Info> getAllInfosAsFreitexteigenschaftById(Freitexteigenschaft frei, Profil pro){
		 
	 	/**
	 	 * Aufbau der DB Connection
	 	 */
	    Connection con = DBConnection.connection();
	  
	    Vector<Info> result = new Vector<Info>();
	    
	    try {
	    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM info WHERE freitexteigenschaftid=?, profilid=? ");
	    	stmt.setInt(1, frei.getId());
	    	stmt.setInt(2, pro.getId());
	      
	    	ResultSet rs = stmt.executeQuery();
	        
	        /**
	         * Für jeden Eintrag im Suchergebnis wird nun ein Merkzettel-Objekt erstellt.
	         */
	        while (rs.next()) {
	          Info info = new Info();
	        

	          info.setFreitexteigenschaftid(rs.getInt("freitexteigenschaftid"));
	          info.setProfilId(rs.getInt("profilid"));
	          /**
	           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
	           */
	          
	          System.out.println("Funktioniert");
	          
	          result.addElement(info);
	        }
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	      }

	      /**
	       *  Ergebnisvektor zurückgeben
	       */
		return result;
	}
}