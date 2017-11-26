package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.ITProjekt17.shared.bo.Info;

public class InfoMapper {

	/**
	 * Die Klasse InfoMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see infoMapper()
	 */
	
	private static InfoMapper infoMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
	 * neue Instanzen dieser Klasse zu erzeugen.
	 */
	protected InfoMapper(){	
	}
	
	/**
	 * Kann aufgerufen werden durch InfoMapper.infoMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * @return Das "InfoMapper-Objekt".
	 * @see InfoMapper
	 */
	public static InfoMapper infoMapper(){
		if (infoMapper == null){
			infoMapper = new InfoMapper();
		}
		
		return infoMapper;
	}
	public Info findByKey(int id){
		Connection con = DBConnection.connection();
		
		try{
		Statement stmt = con.createStatement();		
		ResultSet rs = stmt.executeQuery("SELECT * FROM `info` WHERE `id` = " + id);
		
		if (rs.next()){
			Info p = new Info();
			p.setId(rs.getInt("id"));
			p.setText(rs.getString("text"));
			
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