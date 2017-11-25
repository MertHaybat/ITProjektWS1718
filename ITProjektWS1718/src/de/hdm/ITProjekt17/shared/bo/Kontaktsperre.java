package de.hdm.ITProjekt17.shared.bo;

/**
 * Realisierung einer exemplarischen Kontaktsperre von Profilen
 * Mit diseer Klasse werden exemplarische Kontaktsperren vergeben.
 * Es ist möglich Teilnehmer, welche ungewünscht sind zu sperren.
 * @author dezzyanthony
 *
 */


public class Kontaktsperre extends BusinessObject {
	
	private static final long serialVersionUID = 1L; 

	
	//--------Variablen-der-Klasse-Kontaktsperre----------------
	
	/**
	 * ID, welche vergeben wird wenn ein Teilnehmer gesperrt wurde
	 */
	private int kontaktsperreId = 0;
	
	/**
	 * ID des Profils, welches gesperrt werden soll.
	 */
	private int profilId = 0;
	
	
	//-------------------Get-Methoden----------------------------
	
	/**
	 * Auslesen des Profils, welches gesperrt wurden.
	 * @return
	 */
	public int getKontaktsperreId(){
		return kontaktsperreId;
	}
	
	/**
	 * Auslesen des Profils, welches einen Kontakt gesperrt hat.
	 * @return
	 */
	public int getProfilId(){
		return profilId;
	}
	
	
	//-------------------Set-Methoden----------------------------
	
	/**
	 * Setzen einer ID für das zu sperrende Profil
	 * @param kontaktsperreId
	 */
	public void setKontaktsperreId(int kontaktsperreId){
		this.kontaktsperreId = kontaktsperreId;
	}
	
	/**
	 * Setzen einer ID des Profils, welches die Sperrung durchführt
	 * @param profilId
	 */
	public void setProfilId(int profilId){
		this.profilId = profilId;
	}
	
	//Wirklich nötig eine neue ProfilID zusetzen um ein Sperrendes Profil zu verwalten
	

}