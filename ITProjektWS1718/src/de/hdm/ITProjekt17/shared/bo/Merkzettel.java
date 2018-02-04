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
	 * Dient zum Serialisieren von Objekten für eine RPC fähigen austausch zwischen Server und Client.
	 */
	private static final long serialVersionUID = 1L;
	//---------------Variablen-der-Klasse-Merkzettel---------------

	/**
	 * Variable von Profil, welche vermerk verhängt
	 */
	private int profilId_merkender= 0;
	private int profilId_gemerkter = 0;
	/**
	 * Konstruktor
	 */
	public Merkzettel(){
		
	}
	
	//---------------Get-Methoden--------------------------
	/**
	 * Auslesen der id vom Profil des merkenden
	 * @return profilId_merkender
	 */
	public int getProfilId_merkender() {
		return profilId_merkender;
	}
	/**
	 * Auslesen der id vom Profil des gemerkten
	 * @return profilId_gemerkter
	 */
	public int getProfilId_gemerkter() {
		return profilId_gemerkter;
	}
	
	//--------------Set-Methoden---------------------------
	/**
	 * Setzen der id vom Profil des merkenden
	 * @param profilId_merkender
	 */
	public void setProfilId_merkender(int profilId_merkender) {
		this.profilId_merkender = profilId_merkender;
	}
	/**
	 * Setzen der id vom Profil des gemerkten
	 * @param profilId_gemerkter
	 */
	public void setProfilId_gemerkter(int profilId_gemerkter) {
		this.profilId_gemerkter = profilId_gemerkter;
	}

	
	/**
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Merkzettel-ID: #" + this.getId() +
					" Profil-Id-merkender: #" + this.getProfilId_merkender() + 
					" Profil-Id-gemerkter: #" + this.getProfilId_gemerkter(); 
					
	}
	
}
