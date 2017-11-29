package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;

public class FreitexteigenschaftMapper {

		/**
		 * Die Klasse FreitexteigenschaftMapper wird nur einmal instantiiert. Man spricht 
		 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
		 * @see freitexteigenschaftMapper()
		 */
		
		private static FreitexteigenschaftMapper freitexteigenschaftMapper = null;
		
		/**
		 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
		 * neue Instanzen dieser Klasse zu erzeugen.
		 */
		protected FreitexteigenschaftMapper(){	
		}
		
		/**
		 * Kann aufgerufen werden durch FreitexteigenschaftMapper.freitexteigenschaftMapper. Sie stellt die
		 * Singleton-Eigenschaft sicher.
		 * @return Das "FreitexteigenschaftMapper-Objekt".
		 * @see FreitexteigenschaftMapper
		 */
		public static FreitexteigenschaftMapper freitexteigenschaftMapper(){
			if (freitexteigenschaftMapper == null){
				freitexteigenschaftMapper = new FreitexteigenschaftMapper();
			}
			
			return freitexteigenschaftMapper;
		}
		public Freitexteigenschaft findByKey(int id){
			Connection con = DBConnection.connection();
			
			try{
			Statement stmt = con.createStatement();		
			ResultSet rs = stmt.executeQuery("SELECT * FROM `freitexteigenschaft` WHERE `id` = " + id);
			
			if (rs.next()){
				Freitexteigenschaft p = new Freitexteigenschaft();
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
