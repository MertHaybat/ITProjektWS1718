package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.google.gwt.user.client.Window;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class ProfilMapper {

	/**
	 * Die Klasse ProfilMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see profilMapper()
	 */
	
	private static ProfilMapper profilMapper = null;
	
	/**
	 * Geschützter Konstruktor - verhindet die Möglichkeit, mit "new" 
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
