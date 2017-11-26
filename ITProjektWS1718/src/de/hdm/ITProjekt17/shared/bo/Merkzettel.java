package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Merkliste zum auflisten alle Teilnehmer der Partnerbörse,
 * welche der Teilnehmern später kontaktieren möchte.
 * 
 * @author dezzyanthony
 *
 */

public class Merkzettel extends BusinessObject{
	
	//---------------Variablen-der-Klasse-Merkzettel---------------
	
	/**
	 * Variable von Profil, welche vermerk verhängt
	 */
	private int profilId = 0;
	
	
	//------------------------Get-Methoden-------------------------
	
	
	public int getProfilId(){
		return profilId;
	}
	
	//------------------------Set-Methoden-------------------------
	
	/**
	 * Wird hier die ProfilID neu vergeben oder vergeben für das Profil, welches die Merkung durchführt??
	 * Wenn es eine MerkzettelId pro Profil gibt wird die ProfilId der Klasse Profil hier übertragen oder neu angelegt?
	 * @param profilId
	 */
	public void setProfilId(int profilId){
		this.profilId = profilId;
	}
	

}
