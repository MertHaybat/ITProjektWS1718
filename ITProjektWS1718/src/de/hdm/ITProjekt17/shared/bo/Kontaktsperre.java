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
	 * ID des Profils, welches gesperrt und von wem es gesperrt werden soll.
	 */
	private int profilId_sperrender = 0;
	private int profilId_gesperrter = 0;
	
	
	//--------------Get-Methoden-----------------------------
	
	public int getProfilId_sperrender() {
		return profilId_sperrender;
	}
	
	public int getProfilId_gesperrter() {
		return profilId_gesperrter;
	}
	
	//----------------Set-Methoden---------------------------
	
	public void setProfilId_gesperrter(int profilId_gesperrter) {
		this.profilId_gesperrter = profilId_gesperrter;
	}
	
	public void setProfilId_sperrender(int profilId_sperrender) {
		this.profilId_sperrender = profilId_sperrender;
	}

	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Kontaktsperre-ID: #" + this.getId() +
					" Profil-Id-gesperrter: #" + this.getProfilId_gesperrter() + 
					" Profil-Id-sperrender: #" + this.getProfilId_sperrender();
					
	}

}
