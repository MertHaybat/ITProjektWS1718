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
	 * ID des Profils, welches gesperrt werden soll.
	 */
	private int profilId_sperrender = 0;
	private int profilId_gesperrter = 0;
	
	public int getProfilId_sperrender() {
		return profilId_sperrender;
	}
	public void setProfilId_sperrender(int profilId_sperrender) {
		this.profilId_sperrender = profilId_sperrender;
	}
	public int getProfilId_gesperrter() {
		return profilId_gesperrter;
	}
	public void setProfilId_gesperrter(int profilId_gesperrter) {
		this.profilId_gesperrter = profilId_gesperrter;
	}
	


}
