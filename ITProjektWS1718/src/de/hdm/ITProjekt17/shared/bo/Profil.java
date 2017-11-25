package de.hdm.ITProjekt17.shared.bo;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Realisierung eines exemplarischen Profils der Partnerbörse. 
 * @author DennisLehle
 * @author Mert
 *
 */
public class Profil extends BusinessObject {

	private static final long serialVersionUID = 1L;
	
	
	//-----------Variablen-der-Klasse-Profil-----------------------
	
	/**
	 * Variable Vorname im Profil; Gibt den Vornamen der Person an.
	 */
	private String vorname = "";
	
	/**
	 * Variable Geburtsdatum im Profil; Gibt das Geburtsdatum der Person an.
	 */
	private Date geburtsdatum;
	
	/**
	 * Variable Körpergrösse im Profil; Gibt die Grösse der Person an.
	 */
	private int koerpergroesse;
	
	/**
	 * Vraible Religion im Profil; Gibt die Religion der Person an.
	 */
	private Auswahleigenschaft religion;
	
	/**
	 * Variable Haarfarbe im Profil; Gibt die Haaarfarbe der Person an.
	 */
	private Auswahleigenschaft haarfarbe;
	
	/**
	 * Variable Nachname im Profil; Gibt den Nachnamen der Person an.
	 */
	private String nachname;
	/**
	 * Variable Raucher im Profil; Gibt an, ob die Person raucht oder nicht.
	 */
	private Auswahleigenschaft raucher;
	/**
	 * Auslesen der Variable nachname
	 * @return
	 */

	
	public Profil(){
		
	}

	public Profil(String nachname, Auswahleigenschaft raucher){
		this.nachname = nachname;
		this.raucher= raucher;
	}
	
	//--------------Get-Methoden--------------------
	
	/**
	 * Auslesen der Variable Vorname.
	 * @return
	 */
	public String getVorname(){
		return vorname;
	}
	
	/**
	 * Auslesen der Variable Nachname.
	 * @return
	 */
	public String getNachname(){
		return nachname;
	}
	
	/**
	 * Auslesen der Variable Geburtsdatum.
	 * @return
	 */
	public Date getGeburtsdatum(){
		return geburtsdatum;
	}
	
	/**
	 * Auslesen der Variable Körpergrösse.
	 * @return
	 */
	public int getKoerpergroesse(){
		return koerpergroesse;
	}
	
	/**
	 * Auslesen der Variable Haarfarbe.
	 * @return
	 */
	public Auswahleigenschaft gethaarfarbe(){
		return haarfarbe;
	}
	
	/**
	 * Auslesen der Variable Religion.
	 * @return
	 */
	public Auswahleigenschaft getReligion(){
		return religion;
	}
	/**
	 * Auslesen der Variable Raucher.
	 * @return
	 */
	public Auswahleigenschaft getRaucher() {
		return raucher;
	}
	
	
	//-------------Set-Methoden--------------------
	
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
	public void setHaarfarbe(Auswahleigenschaft haarfarbe){
		this.haarfarbe = haarfarbe;
	}
	
	/**
	 * Setzen der Variable Körpergrösse.
	 * @param koerpergroesse
	 */
	public void setKoerpergroesse(int koerpergroesse){
		this.koerpergroesse = koerpergroesse;
	}
	
	/**
	 * Setzen der Variable Religion.
	 * @param religion
	 */
	public void setReligion(Auswahleigenschaft religion){
		this.religion = religion;
	}
	/**
	 * Setzen der Variable Raucher
	 * @param raucher
	 */
	public void setRaucher(Auswahleigenschaft raucher) {
		this.raucher = raucher;
	}
	
	
	
	
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Profils
	 */
	public String toString(){
		return super.toString() + "Profil-ID: #" + this.getId()
		+ "Name: #" + this.nachname + "Raucher: #" + this.getRaucher();
	}
}
