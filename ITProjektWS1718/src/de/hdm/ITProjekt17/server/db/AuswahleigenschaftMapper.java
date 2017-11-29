package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;

public class AuswahleigenschaftMapper {

		/**
		 * Die Klasse AuswahleigenschaftMapper wird nur einmal instantiiert. Man spricht 
		 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
		 * @see auswahleigenschaftMapper()
		 */
		
		private static AuswahleigenschaftMapper auswahleigenschaftMapper = null;
		
		/**
		 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
		 * neue Instanzen dieser Klasse zu erzeugen.
		 */
		protected AuswahleigenschaftMapper(){	
		}
		
		/**
		 * Kann aufgerufen werden durch AuswahleigenschaftMapper.auswahleigenschaftMapper. Sie stellt die
		 * Singleton-Eigenschaft sicher.
		 * @return Das "AuswahleigenschaftMapper-Objekt".
		 * @see AuswahleigenschaftMapper
		 */
		public static AuswahleigenschaftMapper auswahleigenschaftMapper(){
			if (auswahleigenschaftMapper == null){
				auswahleigenschaftMapper = new AuswahleigenschaftMapper();
			}
			
			return auswahleigenschaftMapper;
		}
		public Auswahleigenschaft findByKey(int id){
			Connection con = DBConnection.connection();
			
			try{
			Statement stmt = con.createStatement();		
			ResultSet rs = stmt.executeQuery("SELECT * FROM `auswahleigenschaft` WHERE `id` = " + id);
			
			if (rs.next()){
				Auswahleigenschaft p = new Auswahleigenschaft();
				p.setId(rs.getInt("id"));
				p.setWert(rs.getString("wert"));
				
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


