package de.hdm.ITProjekt17.shared.bo;

import java.util.Date;

/**
 * Realisierung eines exemplarischen Profils der PartnerbÃ¶rse. 
 * @author DennisLehle
 * @author Mert
 *
 */
public class Profil extends BusinessObject {

	private static final long serialVersionUID = 1L;
	
	
	//-----------Variablen-der-Klasse-Profil-----------------------
	
	/**
	 * Variable Geschlecht im Profil; Gibt an, ob die Person weiblich oder mÃ¤nnlich ist
	 * @author samina und dennis
	 *
	 */
	public enum Geschlecht {
	    m, w, s
	  }
	/**
	 * Variable Geschlecht im Profil; Gibt das Geschlecht der Person an.
	 */
	 private String geschlecht ="";
	 
	/**
	 * Variable Email im Profil; Gibt die Email der Person an.
	 */
	
	private String email = "";

	
	/**
	 * Variable Vorname im Profil; Gibt den Vornamen der Person an.
	 */
	private String vorname ="";
	
	/**
	 * Variable Geburtsdatum im Profil; Gibt das Geburtsdatum der Person an.
	 */
	private Date geburtsdatum = null;
	
	/**
	 * Variable KÃ¶rpergrÃ¶sse im Profil; Gibt die GrÃ¶sse der Person an.
	 */
	private int koerpergroesse = 0;
	
	/**
	 * Vraible Religion im Profil; Gibt die Religion der Person an.
	 */
	private String religion = "";
	
	/**
	 * Variable Haarfarbe im Profil; Gibt die Haaarfarbe der Person an.
	 */
	public enum Haarfarbe {
	    A, B, C, D, E, F
	  }
	
	private String haarfarbe ="";
	/**
	 * Variable Nachname im Profil; Gibt den Nachnamen der Person an.
	 */
	private String nachname = "";
	/**
	 * Variable Raucher im Profil; Gibt den Status ob jemand Raucht oder nicht.
	 */
	private String raucher ="";
	/**
	 * Variable Raucher im Profil; Gibt an, ob die Person raucht oder nicht.
	 */
	public enum Raucher {
	    A, B, C, D, E
	  }

	/**
	 * Auslesen der Variable nachname
	 * @return
	 */

	
	//--------------Get-Methoden--------------------
	
	/**
	 * Auslesen der Variable Email
	 * @return email
	 */
	public String getEmail(){
		return this.email;
	}
		
	/**
	 * Auslesen der Variable Vorname.
	 * @return vorname
	 */
	public String getVorname(){
		return this.vorname;
	}
	
	/**
	 * Auslesen der Variable Nachname.
	 * @return nachname
	 */
	public String getNachname(){
		return this.nachname;
	}
	
	/**
	 * Auslesen der Variable Geburtsdatum.
	 * @return geburtsdatum
	 */
	public Date getGeburtsdatum(){
		return this.geburtsdatum;
	}
	
	/**
	 * Auslesen der Variable Körpergröße
	 * @return koerpergroesse
	 */
	public int getKoerpergroesse(){
		return this.koerpergroesse;
	}
	
	
	/**
	 * Auslesen der Variable Religion.
	 * @return religion
	 */
	public String getReligion(){
		return this.religion;
	}


	
	
	//-------------Set-Methoden--------------------
	
	/**
	 * Setzen der Variable Email
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * Setzen der Variable Vorname.
	 * @param vorname
	 */
	public void setVorname(String vorname){
		this.vorname = vorname;
	}
	
	/**
	 * Setzen der Variable nachname
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	/**
	 * Setzen der Variable Geburtsdatum.
	 * @param geburtsdatum
	 */
	public void setGeburtsdatum(Date geburtsdatum){
		this.geburtsdatum = geburtsdatum;
	}
	
	
	/**
	 * Setzen der Variable Körpergröße
	 * @param koerpergroesse
	 */
	public void setKoerpergroesse(int koerpergroesse){
		this.koerpergroesse = koerpergroesse;
	}
	
	/**
	 * Setzen der Variable Religion.
	 * @param religion
	 */
	public void setReligion(String religion){
		this.religion = religion;
	}
	
	// Weitere Methoden 

	/**
	   * Zuweisung von String-Werten für das Enum Raucher.
	   * @param b
	   * @return str
	   */
	  public static String word(Raucher b) {
	    String str ="";
	    switch (b) {
	      case A: str = "Ja";
	            break;
	      case B: str = "Nein";
	            break;
	      case C: str = "Gelegentlich";
	            break;
	      case D: str = "Partyraucher";
	      		break;
	      case E: str = "Nur nach dem Sex";
  			break;	      		

	    }
	    return str;
	  }
	
	  /**
	   * Zuweisung von String-Werten für das Enum Haarfarbe.
	   * @param h
	   * @return str
	   */
	  public static String word(Haarfarbe h) {
	    String str ="";
	    switch (h) {
	      case A: str = "schwarz";
	            break;
	      case B: str = "braun";
	            break;
	      case C: str = "blond";
	            break;
	      case D: str = "rot";
	      		break;
	      case E: str = "hell";
    			break;	  
	      case F: str = "dunkel";
    			break;	   		

	    }
	    return str;
	  }
	
	  /**
	   * Zuweisung von String-Werten für das Enum Geschlecht.
	   * @param c
	   * @return str
	   */
	  public static String word(Geschlecht c) {
	    String str ="";
	    switch (c) {
	      case m: str = "Männlich";
	              break;
	      case w: str = "Weiblich";
	              break;
	      case s: str = "Sonstiges";
	              break;
	     
	    }
	    return str;
	  }
	
	/**
	 * Auslesen der Variable Geschlecht
	 * @return geschlecht
	 */
	public String getGeschlecht() {
		return geschlecht;
	}
	/**
	 * Setzen der Variable Geschlecht
	 * @param geschlecht
	 */
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	/**
	 * Auslesen der Variable Raucher
	 * @return raucher
	 */
	public String getRaucher() {
		return raucher;
	}
	/**
	 * Setzen der Variable Raucher
	 * @param raucher
	 */
	public void setRaucher(String raucher) {
		this.raucher = raucher;
	}
	/**
	 * Auslesen der Variable Haarfarbe
	 * @return haarfarbe
	 */
	public String getHaarfarbe() {
		return haarfarbe;
	}
	/**
	 * Setzen der Variable Haarfarbe
	 * @param haarfarbe
	 */
	public void setHaarfarbe(String haarfarbe) {
		this.haarfarbe = haarfarbe;
	}
	
	/**
	 * Erzeugen einer Textuellen Darstellung.
	 */
	public String toString(){
		return super.toString() + 
					"Profil-ID: #" + this.getId() +
					" Email: #" + this.getEmail() +
					" Vorname: #" + this.getVorname() + 
					" Nachname: #" + this.getNachname() + 
					" Geburtsdatum: #" + this.getGeburtsdatum() + 
					" Haarfarbe: #" + Profil.Haarfarbe.values() + 
					" Körpergröße: #" + this.getKoerpergroesse() + 
					" Religion: #" + this.getReligion() + 
//					" Raucher: #" + Profil.getRaucher().values() +
					" Geschlecht: #" + Profil.Geschlecht.values();
	}	
}
