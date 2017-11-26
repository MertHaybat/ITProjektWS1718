package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.ITProjekt17.shared.bo.Suchprofil;

public class SuchprofilMapper {

	/**
	 * Die Klasse SuchprofilMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see suchprofilMapper()
	 */
	
	private static SuchprofilMapper suchprofilMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
	 * neue Instanzen dieser Klasse zu erzeugen.
	 */
	protected SuchprofilMapper(){	
	}
	
	/**
	 * Kann aufgerufen werden durch SuchprofilMapper.suchprofilMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * @return Das "SuchprofilMapper-Objekt".
	 * @see SuchprofilMapper
	 */
	public static SuchprofilMapper suchprofilMapper(){
		if (suchprofilMapper == null){
			suchprofilMapper = new SuchprofilMapper();
		}
		
		return suchprofilMapper;
	}
	public Suchprofil findByKey(int id){
		Connection con = DBConnection.connection();
		
		try{
		Statement stmt = con.createStatement();		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `suchprofil` WHERE `id` = " + id);
		
		if (rs.next()){
			Suchprofil p = new Suchprofil();
			p.setId(rs.getInt("id"));
			p.setMinAlter(rs.getInt("minAlter"));
			p.setMaxAlter(rs.getInt("maxAlter"));
			p.setGeburtsdatum(rs.getDate("geburtsdatum"));
			p.setKoerpergroesse(rs.getInt("koerpergroesse"));
			p.setReligion(rs.getString("religion"));
			p.setHaarfarbe(rs.getString("haarfarbe"));
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
