package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Merkliste zum auflisten alle Teilnehmer der Partnerbörse,
 * welche der Teilnehmern später kontaktieren möchte.
 * 
 * @author dezzyanthony
 *
 */

public class Merkzettel extends BusinessObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//---------------Variablen-der-Klasse-Merkzettel---------------
	
	
	/**
	 * Variable von Profil, welche vermerk verhängt
	 */
	private int profilId_merkender;
	private int profilId_gemerkter;
	
	
	//------------------------Get-Methoden-------------------------
	
	
	public int getProfilId_merkender() {
		return profilId_merkender;
	}

	public void setProfilId_merkender(int profilId_merkender) {
		this.profilId_merkender = profilId_merkender;
	}

	public int getProfilId_gemerkter() {
		return profilId_gemerkter;
	}

	public void setProfilId_gemerkter(int profilId_gemerkter) {
		this.profilId_gemerkter = profilId_gemerkter;
	}

}
