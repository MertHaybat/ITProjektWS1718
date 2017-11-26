package de.hdm.ITProjekt17.server.db;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;

	public class KontaktsperreMapper {
			/**
			 * Die Klasse KontaktsperreMapper wird nur einmal instantiiert. Man spricht 
			 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
			 * @see kontaktsperreMapper()
			 */
			
			private static KontaktsperreMapper kontaktsperreMapper = null;
			
			/**
			 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
			 * neue Instanzen dieser Klasse zu erzeugen.
			 */
			protected KontaktsperreMapper(){	
			}
			
			/**
			 * Kann aufgerufen werden durch KontaktsperreMapper.kontaktsperreMapper. Sie stellt die
			 * Singleton-Eigenschaft sicher.
			 * @return Das "KontaktsperreMapper-Objekt".
			 * @see KontaktsperreMapper
			 */
			public static KontaktsperreMapper kontaktsperreMapper(){
				if (kontaktsperreMapper == null){
					kontaktsperreMapper = new KontaktsperreMapper();
				}
				
				return kontaktsperreMapper;
			}
			public Kontaktsperre findByKey(int id){
				Connection con = DBConnection.connection();
				
				try{
				Statement stmt = con.createStatement();		
				ResultSet rs = stmt.executeQuery("SELECT * FROM `kontaktsperre` WHERE `id` = " + id);
				
				if (rs.next()){
					Kontaktsperre p = new Kontaktsperre();
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
