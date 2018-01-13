package de.hdm.ITProjekt17.server.db;

import java.sql.*;

import com.google.appengine.api.utils.SystemProperty;
/**
 * 
 * @author Mert und Giuse
 *
 */
public class DBConnection{

	private static Connection con = null;
	//private static String googleUrl = "jdbc:google:mysql://itprojektneu:europe-west1:itprojektneu/itprojekt2?user=root&password=1234";
	private static String localUrl = "jdbc:mysql://localhost:3306/itprojektws1718?user=root&password=";
//	private static String localUrl = "jdbc:mysql://localhost:3306/itproj?user=root&password=";

     
     /**
      * Diese Methode gibt die aufgebaute DB-Verbindung zurück
      * @return con
      */
    public static Connection connection(){

    	// Wenn es bisher keine Connection zur DB gab, ...
        if (con == null) {
            String url = null;
            try {
                if 
                (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
                	// Load the class that provides the new
                    // "jdbc:google:mysql://" prefix.
                	Class.forName("com.mysql.jdbc.GoogleDriver");
                   // url = googleUrl;

                } else {

//                     Local MySQL instance to use during development.
                    Class.forName("com.mysql.jdbc.Driver");
                    url = localUrl;
                    
                }
                /*
                 * Dann erst kann uns der DriverManager eine Verbindung mit den
                 * oben in der Variable url angegebenen Verbindungsinformationen
                 * aufbauen.
                 * 
                 * Diese Verbindung wird dann in der statischen Variable con
                 * abgespeichert und fortan verwendet.
                 */
                con = DriverManager.getConnection(url);
              //  con = (Connection) DriverManager.getConnection(googleUrl);
            } catch (Exception e) {
                con = null;
                e.printStackTrace();
            }
        }

        // Zur�ckgegeben der Verbindung
        return con;
    }
}