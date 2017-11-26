package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.ITProjekt17.shared.bo.Merkzettel;

public class MerkzettelMapper {

		/**
		 * Die Klasse MerkzettelMapper wird nur einmal instantiiert. Man spricht 
		 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
		 * @see merkzettelMapper()
		 */
		
		private static MerkzettelMapper merkzettelMapper = null;
		
		/**
		 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
		 * neue Instanzen dieser Klasse zu erzeugen.
		 */
		protected MerkzettelMapper(){	
		}
		
		/**
		 * Kann aufgerufen werden durch MerkzettelMapper.merkzettelMapper. Sie stellt die
		 * Singleton-Eigenschaft sicher.
		 * @return Das "MerkzettelMapper-Objekt".
		 * @see MerkzettelMapper
		 */
		public static MerkzettelMapper merkzettelMapper(){
			if (merkzettelMapper == null){
				merkzettelMapper = new MerkzettelMapper();
			}
			
			return merkzettelMapper;
		}
		public Merkzettel findByKey(int id){
			Connection con = DBConnection.connection();
			
			try{
			Statement stmt = con.createStatement();		
			ResultSet rs = stmt.executeQuery("SELECT * FROM `merkzettel` WHERE `id` = " + id);
			
			if (rs.next()){
				Merkzettel p = new Merkzettel();
				p.setId(rs.getInt("id"));
				p.setProfilId(rs.getInt("profilId"));
				
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
