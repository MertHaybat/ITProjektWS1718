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
	
	/**
	 * Variable minAlter gibt mindest Alter des zusuchenden Teilnehmers an.
	 */
	private int minAlter;
	
	/**
	 * Variable maxAlter gibt maximales Alter des zusuchenden Teilnehmers an.
	 */
	private int maxAlter;
	
	/**
	 * Variable geburtsdatum gibt das Geburtsdatum des zusuchenden Teilnehmers.
	 */
	private Date geburtsdatum;
	
	/**
	 * Variable koerpergroesse gibt die Körpergrösse des zusuchenden Teilneherms an.
	 */
	private int koerpergroesse;
	
	/**
	 * Variable religion gibt die Religion des zusuchenden Teilnehmers an.
	 */
	private Auswahleigenschaft religion;
	
	/**
	 * Variable haarfarbe gibt die Haarfarbe des zusuchenden Teilnehmers an.
	 */
	private Auswahleigenschaft haarfarbe;
	
	/**
	 * Variable raucher gibt an ob der zusuchende Teilnehmer raucher ist oder nicht.
	 */
	private Auswahleigenschaft raucher; 
	
	
	
	
	//------------------------------------------------------------------
	//----------------------Set-Methoden--------------------------------
	
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
	public void setReligion(Auswahleigenschaft reli){
		religion = reli;
	}
	
	/**
	 * Setzen der Haarfarbe des zusuchenden Teilnehmers.
	 * @param haarfarbe
	 */
	public void setHaarfarbe(Auswahleigenschaft haarfarbe){
		this.haarfarbe = haarfarbe;
	}
	
	/**
	 * Setzen ob zusuchender Teilenhmer Raucht
	 * @param raucher
	 */
	public void setRaucher(Auswahleigenschaft raucher){
		this.raucher = raucher;
	}
	

	//-------------------------------------------------------------------
	//------------Get-Methoden-------------------------------------------
	
	
	
	
	
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
	public Auswahleigenschaft getReligion(){
		return religion;
	}
	
	/**
	 * Abfragen der Haarfarbe eines Teilnehmers.
	 * @return
	 */
	public Auswahleigenschaft getHaarfarbe(){
		return haarfarbe;
	}
	
	/**
	 * Abfragen ob zu suchendes Profil Raucher ist oder nicht.
	 * @return
	 */
	public Auswahleigenschaft getRaucher(){
		return raucher;
	}
	
	
	
}
