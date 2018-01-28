package de.hdm.ITProjekt17.shared.bo;



/**
 * Realisierung eines exemplarischen Info-Objektes für das Profil
 * 
 * @author dezzyanthony
 *
 */

public class Info extends BusinessObject{

	private static final long serialVersionUID = 1L;
	
	
	
	//-------------------Variablen-der-Info-Klasse--------------------
	
	/**
	 * Variable profilId ist dei Id des Profil's (Fremdschl�ssel!!!)
	 */
	private int profilId = 0;
	
	/**
	 * Variable suchprofilId ist dei Id des Suchprofil's (Fremdschl�ssel!!!)
	 */
	private int suchprofilId = 0;
	
	/**
	 * Variable text steht für die Eigenschaft, die für das Profil eingegeben werden kann.
	 */
	private String text ="";
	
	/**
	 * Variable auswahltextwert enthält den Wert der Eigenschaft.
	 */
	private String auswahlwert ="";
	
	/**
	 * Variable freitextwert enthält den Wert der Eigenschaft.
	 */
	private String freitextwert ="";
	
	/**
	 * Variable freitexteigenschaftid ist die ID von Freitexteigenschaft als FS
	 */
	private int freitexteigenschaftid = 0;
	
	/**
	 * Variable auswahleigenschaftid ist die ID von Auswahleigenschaft als FS
	 */
	private int auswahleigenschaftid = 0;
	
	/**
	 * Variable suchprofilid ist die ID von suchprofil als FS
	 */
	private int suchprofilid = 0;
	
	/**
	 * Konstruktor
	 */
	public Info(){
		
	}
	/**
	 * Info als String 
	 * @param text
	 */
	public Info(String text){
		this.text = text;
	}
	
	//-----------------------Get-Methoden-----------------------------
	
	/**
	 * Auslesen der ProfilId
	 * @return profilId
	 */
	public int getProfilId(){
		return profilId;
	}
	
	
	
	/**
	 * Auslesen des Textes
	 * @return text
	 */
	public String getText(){
		return text;
	}
	/**
	 * Auslesen der Freitexteigenschaft id
	 * @return freitexteigenschaftid
	 */
	public int getFreitexteigenschaftid(){
		return freitexteigenschaftid;
	}
	/**
	 * Auslesen der Auswahleigenschaft id
	 * @return auswahleigenschaftid
	 */
	public int getAuswahleigenschaftid(){
		return auswahleigenschaftid;
	}
	
	/**
	 * Auslesen des Auswahleigenschaftwertes
	 * @return auswahlwert
	 */
	public String getAuswahleigenschaftWert(){
		return auswahlwert;
	}	
	
	/**
	 * Auslesen des Freitextwertes
	 * @return freitextwert
	 */
	public String getFreitexteigenschaftWert(){
		return freitextwert;
	}	
	
	/**
	 * Auslesen der Suchprofil Id
	 * @return profilId
	 */
	public int getSuchprofilId(){
		return suchprofilid;
	}
	//------------------------Set-Methoden---------------------------
	
	/**
	 * Setzen einer ProfilId
	 * @param profilId
	 */
	public void setProfilId(int profilId){
		this.profilId = profilId;
	}
	
	
	/**
	 * Setzen eines Texte's
	 * @param text
	 */
	public void setText(String text){
		this.text = text;
	}
	/**
	 * Setzen einer Freitexteigenschaft id
	 * @param freitexteigenschaftid
	 */
	public void setFreitexteigenschaftid(int freitexteigenschaftid){
		this.freitexteigenschaftid = freitexteigenschaftid;
	}
	/**
	 * Setzen einer Auswahleigenschaft id
	 * @param auswahleigenschaftid
	 */
	public void setAuswahleigenschaftid(int auswahleigenschaftid){
		this.auswahleigenschaftid = auswahleigenschaftid;
	}
	
	/**
	 * Setzen eines Auswahlwertes
	 * @param auswahlwert
	 */
	public void setAuswahleigenschaftWert(String auswahlwert){
		this.auswahlwert = auswahlwert;
	}
	
	/**
	 * Setzen eines Freitextwertes
	 * @param freitextwert
	 */
	public void setFreitexteigenschaftWert(String freitextwert){
		this.freitextwert = freitextwert;
	}
	
	/**
	 * Setzen einer Suchprofil Id
	 * @param suchprofilid
	 */
	public void setSuchprofilId(int suchprofilid){
		this.suchprofilid = suchprofilid;
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Info-ID: #" + this.getId() +
					" Profil-Id: #" + this.getProfilId() + 
					" Text: #" + this.getText() +
					" Auswahlwert: #" + this.getAuswahleigenschaftWert() +
					" Freitextwert: #" + this.getFreitexteigenschaftWert() +
					" Freitexteigenschaft-Id: #" + this.getFreitexteigenschaftid() +
					" Auswahleigenschaft-Id: #" + this.getAuswahleigenschaftid() +
					" Suchprofil-Id: #" + this.getSuchprofilId();
	}
	
	
}
