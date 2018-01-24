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
	 */
	public enum Geschlecht {
	    m, w, s
	  }
	  
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
	
	private String haarfarbe ="";
	/**
	 * Variable Nachname im Profil; Gibt den Nachnamen der Person an.
	 */
	private String nachname = "";
	/**
	 * Variable Raucher im Profil; Gibt an, ob die Person raucht oder nicht.
	 */
	public enum Raucher {
	    A, B, C, D, E
	  }
	  
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

	private String raucher ="";
	/**
	 * Auslesen der Variable nachname
	 * @return
	 */

	
//	public Profil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String haarfarbe, String religion, String raucher){
//		this.vorname = vorname;
//		this.nachname = nachname;
//		this.geburtsdatum = geburtsdatum;
//		this.koerpergroesse = koerpergroesse;
//		this.haarfarbe = haarfarbe;
//		this.religion = religion;
//		this.raucher = raucher;
//	}

	
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
	 * @return
	 */
	public String getVorname(){
		return this.vorname;
	}
	
	/**
	 * Auslesen der Variable Nachname.
	 * @return
	 */
	public String getNachname(){
		return this.nachname;
	}
	
	/**
	 * Auslesen der Variable Geburtsdatum.
	 * @return
	 */
	public Date getGeburtsdatum(){
		return this.geburtsdatum;
	}
	
	/**
	 * Auslesen der Variable KÃ¶rpergrÃ¶sse.
	 * @return
	 */
	public int getKoerpergroesse(){
		return this.koerpergroesse;
	}
	
	
	/**
	 * Auslesen der Variable Religion.
	 * @return
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
	 * Setzen der Variable KÃ¶rpergrÃ¶sse.
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

	
	
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
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

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getRaucher() {
		return raucher;
	}

	public void setRaucher(String raucher) {
		raucher = raucher;
	}

	public String getHaarfarbe() {
		return haarfarbe;
	}

	public void setHaarfarbe(String haarfarbe) {
		this.haarfarbe = haarfarbe;
	}
}
