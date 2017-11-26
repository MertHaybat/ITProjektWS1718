package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Merkliste zum auflisten von Teilnehmer der Partnerbörse,
 * welche der Teilnehmern später kontaktieren möchte.
 * 
 * @author dezzyanthony
 *
 */

public class Merkzettel extends BusinessObject{
	
	//---------------Variablen-der-Klasse-Merkzettel---------------
	
	
	/**
	 * Variable Profil-Id als Fremdschlüssel aus Klasse Profil
	 */
	private int profilId = 0;
	
	
	//------------------------Get-Methoden-------------------------
	
	
	/**
	 * Abfragen der Profil-Id. 
	 * @return
	 */
	public int getProfilId(){
		return profilId;
	}
	
	//------------------------Set-Methoden-------------------------
	
	
	/**
	 * Setzen der Profi-ID 
	 * @param profilId
	 */
	public void setProfilId(int profilId){
		this.profilId = profilId;
	}
	

}
