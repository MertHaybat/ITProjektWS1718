package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.icu.text.SimpleDateFormat;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class ProfilMapper {

	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Die Klasse ProfilMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see profilMapper()
	 */
	
	private static ProfilMapper profilMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
	 * neue Instanzen dieser Klasse zu erzeugen.
	 */
	protected ProfilMapper(){	
	}
	
	/**
	 * Kann aufgerufen werden durch ProfilMapper.profilMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * @return Das "ProfilMapper-Objekt".
	 * @see profilMapper
	 */
	public static ProfilMapper profilMapper(){
		if (profilMapper == null){
			profilMapper = new ProfilMapper();
		}
		
		return profilMapper;
	}
	
    /**
     * Einfuegen eines <code>Account</code>-Objekts in die Datenbank. Dabei wird
     * auch der Primaerschluessel des uebergebenen Objekts geprueft und ggf.
     * berichtigt.
     *
     * @param a das zu speichernde Objekt
     * @return das bereits uebergebene Objekt, jedoch mit ggf. korrigierter
     * <code>id</code>.
     * 
     * @author thies
     */
	
	public Profil insertProfil(Profil pro){
		
		Connection con = DBConnection.connection();
		
		try {
		      Statement stmt = con.createStatement();
		      
		      ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS maxid "
		              + "FROM profil ");
		     	
		      if(rs.next()){
		    	  
		    	  	pro.setId(rs.getInt("maxid") + 1);
		    	  
		    	  	stmt = con.createStatement();
		    	  	
		    		stmt.executeUpdate("INSERT INTO profil (id, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher)" 
		    				+"VALUES (" +
	                        pro.getId() + "," + "'" +
	                        pro.getVorname() +"'" + "," +
	                        pro.getNachname() +"'" + "," +
	                        pro.getGeburtsdatum() +"," + 
	                        pro.getKoerpergroesse() + "," + 
	                        pro.getReligion() + "," + "'" +
	                        pro.getHaarfarbe() +"'" + ","+
	                        pro.getRaucher() +
	                         ")");
		    	  
		      }
		}
		catch(SQLException e2){
			e2.printStackTrace();
		}
		return pro;
		
	}

	public Profil findByKey(int id){
		Connection con = DBConnection.connection();
		
		try{
		Statement stmt = con.createStatement();		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `profil` WHERE `id` = " + id);
		
		if (rs.next()){
			Profil p = new Profil();
			p.setId(rs.getInt("id"));
			p.setNachname(rs.getString("nachname"));
			p.setRaucher(rs.getBoolean("raucher"));
			return p;
		}
	}
		catch (SQLException e2){
			e2.printStackTrace();
			return null;
		}

		return null;
	}
	
}
