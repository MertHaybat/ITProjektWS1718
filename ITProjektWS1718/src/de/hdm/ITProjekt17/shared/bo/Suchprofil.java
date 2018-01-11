package de.hdm.ITProjekt17.shared.bo;

import java.util.Date;

/**
 * Realisieren eines exemplarischen Suchprofils der Partnerbörse 
 * zur suche von anderen Teilnehmern der Partnerbörse.
 * Es können Auswahlen getroffen werden zu Selektierung von Teilenhmern.
 * 
 * @author DennisLehle
 * 
 *
 */

public class Suchprofil extends BusinessObject {

	private static final long serialVersionUID = 1L; 
	
	/**
	 * Deklarieren der Variablen des Suchprofils.
	 * Variablen sind alle zur Suche eines Teilnehmers der Partnerbörse gedacht.
	 * Es sind Angaben, welche angegeben werden können aber nicht müssen.
	 */
	
	//----------------Variablen-der-Klasse-Suchprofil------------------------------
	
	/*
	 * Variable profilId ist der Fremdschl�ssel von Profil kommend, um das Suchprofil einordnen zu k�nnen
	 */
	private int profilId = 0;
	
	/**
	 * Variable minAlter gibt mindest Alter des zusuchenden Teilnehmers an.
	 */
	private int minAlter = 0;
	
	/**
	 * Variable maxAlter gibt maximales Alter des zusuchenden Teilnehmers an.
	 */
	private int maxAlter = 0;
	
	/**
	 * Variable geburtsdatum gibt das Geburtsdatum des zusuchenden Teilnehmers.
	 */
	private Date geburtsdatum  ;
	
	/**
	 * Variable koerpergroesse gibt die Körpergrösse des zusuchenden Teilneherms an.
	 */
	private int koerpergroesse = 0;
	
	/**
	 * Variable religion gibt die Religion des zusuchenden Teilnehmers an.
	 */
	private String religion = "";
	
	/**
	 * Variable haarfarbe gibt die Haarfarbe des zusuchenden Teilnehmers an.
	 */
	private String haarfarbe = "";
	
	/**
	 * Variable raucher gibt an ob der zusuchende Teilnehmer raucher ist oder nicht.
	 */
	private String raucher = ""; 
	
	/**
	 * Variable geschlecht gibt an welches Geschlecht der zusuchende Teilnehmer ist.
	 */
	private boolean geschlecht = false; 
	
	public Suchprofil(){
		
	}
	
	//------------------------------------------------------------------
	//----------------------Set-Methoden--------------------------------
	
	/**
	 * Setzen des Fremdschl�ssels
	 * @param profilId
	 */
	public void setProfilId(int profilId) {
		this.profilId = profilId;
	}
	
	
	/**
	 * Setzen des mindest Alters eines zusuchenden Teilnehmers.
	 * @param minA
	 */
	public void setMinAlter(int minA){
		minAlter = minA;
	}
	
	/**
	 * Setzen des maximalen Alters eines zusuchenden Teilnehmers.
	 * @param maxA
	 */
	public void setMaxAlter(int maxA){
		maxAlter = maxA;
	}
	
	/**
	 * Setzen des Geburtsdatums eines Teilenhmers.
	 * @param geburtsd
	 */
	public void setGeburtsdatum(Date geburtsd){
		geburtsdatum = geburtsd;
	}
	
	/**
	 * Setzen der Körpergrösse eines zusuchenden Teilenhmers.
	 * @param koerperG
	 */
	public void setKoerpergroesse(int koerperG){
		koerpergroesse = koerperG;
	}
	
	/**
	 * Setzen der Religion eines Teilnehmers.
	 * @param reli
	 */
	public void setReligion(String reli){
		religion = reli;
	}
	
	/**
	 * Setzen der Haarfarbe des zusuchenden Teilnehmers.
	 * @param haarfarbe
	 */
	public void setHaarfarbe(String haarfarbe){
		this.haarfarbe = haarfarbe;
	}
	
	/**
	 * Setzen ob zusuchender Teilnehmer Raucht
	 * @param raucher
	 */
	public void setRaucher(String raucher){
		this.raucher = raucher;
	}
	
	/**
	 * Setzen welches Geschlecht der Teilnehmer hat
	 * @param raucher
	 */
	public void setGeschlecht(boolean geschlecht){
		this.geschlecht = geschlecht;
	}
	

	//-------------------------------------------------------------------
	//------------Get-Methoden-------------------------------------------
	
	/**
	 * Abfragen des Fremdschl�ssels ProfilID
	 * @return profilId
	 */
	public int getProfilId() {
		return profilId;
	}
	
	/**
	 * Abfragen des mindest Alters eines Teilnehmers.
	 *Komplementär zum max. Alter
	 * @return
	 */
	public int getMinAlter(){
		return minAlter;
	}
	
	/**
	 * Abfragen des maximalen Alters eines Teilnehmers.
	 * Komplementär zum min. Alter
	 * @return
	 */
	public int getMaxAlter(){
		return maxAlter;
	}
	
	/**
	 * Abfragen des Geburtsdatums eines Teilnehmers.
	 * @return
	 */
	public Date getGeburtsdatum(){
		return geburtsdatum;
	}
	
	/**
	 * Abfragen der Körpergrösse eines Teilnehmers.
	 * @return
	 */
	public int getKoerpergroesse(){
		return koerpergroesse;
	}
	
	/**
	 * Abfragen der Religion eines Teilnehmers.
	 * @return
	 */
	public String getReligion(){
		return religion;
	}
	
	/**
	 * Abfragen der Haarfarbe eines Teilnehmers.
	 * @return
	 */
	public String getHaarfarbe(){
		return haarfarbe;
	}
	
	/**
	 * Abfragen ob zu suchendes Profil Raucher ist oder nicht.
	 * @return
	 */
	public String getRaucher(){
		return raucher;
	}
	
	/**
	 * Abfragen ob zu suchendes Profil Raucher ist oder nicht.
	 * @return
	 */
	public boolean getGeschlecht(){
		return geschlecht;
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Profil-ID: #" + this.getId() +
					" Min Alter: #" + this.getMinAlter() + 
					" Max Alter: #" + this.getMaxAlter() + 
					" Geburtsdatum: #" + this.getGeburtsdatum() + 
					" Haarfarbe: #" + this.getHaarfarbe() + 
					" Körpergröße: #" + this.getKoerpergroesse() + 
					" Religion: #" + this.getReligion() + 
					" Raucher: #" + this.getRaucher() +
					" Geschlecht: #" + this.getGeschlecht();
	}
}
