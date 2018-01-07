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
	private boolean geschlecht = false;
	
	
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
	private String haarfarbe = "";
	
	/**
	 * Variable Nachname im Profil; Gibt den Nachnamen der Person an.
	 */
	private String nachname = "";
	/**
	 * Variable Raucher im Profil; Gibt an, ob die Person raucht oder nicht.
	 */
	private String raucher = "";
	/**
	 * Auslesen der Variable nachname
	 * @return
	 */

	
//	public Profil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String haarfarbe, String religion, boolean raucher){
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
	 * Auslesen der Variable Geschlecht
	 * @return geschlecht
	 */
	
	public boolean getGeschlecht(){
		return this.geschlecht;
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
	 * Auslesen der Variable Haarfarbe.
	 * @return
	 */
	public String getHaarfarbe(){
		return this.haarfarbe;
	}
	
	/**
	 * Auslesen der Variable Religion.
	 * @return
	 */
	public String getReligion(){
		return this.religion;
	}
	/**
	 * Auslesen der Variable Raucher.
	 * @return
	 */
	public String getRaucher() {
		return this.raucher;
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
	 * Setzen der Variable Geschlecht
	 * @param geschlecht
	 */
	public void setGeschlecht(boolean geschlecht){
		this.geschlecht = geschlecht;
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
	 * Setzen der Variable Haarfarbe.
	 * @param haarfarbe
	 */
	public void setHaarfarbe(String haarfarbe){
		this.haarfarbe = haarfarbe;
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
	/**
	 * Setzen der Variable Raucher
	 * @param raucher
	 */
	public void setRaucher(String raucher) {
		this.raucher = raucher;
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
					" Haarfarbe: #" + this.getHaarfarbe() + 
					" KÃ¶rpergrÃ¶ÃŸe: #" + this.getKoerpergroesse() + 
					" Religion: #" + this.getReligion() + 
					" Raucher: #" + this.getRaucher() +
					" Geschlecht: #" + this.getGeschlecht();
	}
}
