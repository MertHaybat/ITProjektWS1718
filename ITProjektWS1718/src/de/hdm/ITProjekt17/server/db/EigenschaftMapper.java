package de.hdm.ITProjekt17.server.db;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import de.hdm.ITProjekt17.shared.bo.Eigenschaft;

	public class EigenschaftMapper {
			/**
			 * Die Klasse EigenschaftMapper wird nur einmal instantiiert. Man spricht 
			 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
			 * @see eigenschaftMapper()
			 */
			
			private static EigenschaftMapper eigenschaftMapper = null;
			
			/**
			 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
			 * neue Instanzen dieser Klasse zu erzeugen.
			 */
			protected EigenschaftMapper(){	
			}
			
			/**
			 * Kann aufgerufen werden durch EigenschaftMapper.eigenschaftMapper. Sie stellt die
			 * Singleton-Eigenschaft sicher.
			 * @return Das "EigenschaftMapper-Objekt".
			 * @see EigenschaftMapper
			 */
			public static EigenschaftMapper eigenschaftMapper(){
				if (eigenschaftMapper == null){
					eigenschaftMapper = new EigenschaftMapper();
				}
				
				return eigenschaftMapper;
			}
			public Eigenschaft findByKey(int id){
				Connection con = DBConnection.connection();
				
				try{
				Statement stmt = con.createStatement();		
				ResultSet rs = stmt.executeQuery("SELECT * FROM `eigenschaft` WHERE `id` = " + id);
				
				if (rs.next()){
					Eigenschaft p = new Eigenschaft();
					p.setId(rs.getInt("id"));
					
					
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

