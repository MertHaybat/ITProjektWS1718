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
	public enum Geschlecht
	{MÄNNLICH (1), 
		WEIBLICH (2), 
		SONSTIGES (3);
	
		private int gs;
		private Geschlecht (int gs)
		{
			this.gs=gs;
		}
		public int getGs(){
			return gs;
		}
	}
	
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
	public enum Haarfarbe
	{SCHWARZ (1), 
		BLOND (2), 
		BRAUN (3), 
		ROT (4), 
		HELL (5), 
		DUNKEL (6);
		
		private int hf;
		private Haarfarbe (int hf)
		{
			this.hf=hf;
		}
		public int getHf(){
			return hf;
		}
	}
	
	/**
	 * Variable Nachname im Profil; Gibt den Nachnamen der Person an.
	 */
	private String nachname = "";
	/**
	 * Variable Raucher im Profil; Gibt an, ob die Person raucht oder nicht.
	 */
	public enum Raucher
	{JA (1),
		NEIN (2), 
		GELEGENTLICH (3), 
		PARTYRAUCHER (4), 
		SEX (5);

		private int rau;
		private Raucher (int rau)
		{
			this.rau=rau;
		}
		public int getRau(){
			return rau;
		}
	}

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
					" Raucher: #" + Profil.Raucher.values() +
					" Geschlecht: #" + Profil.Geschlecht.values();
	}
}
