package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen AUswahleigenschaft der Partnerbörse.
 * Sie erlaubt es Auswahlen treffen zu können.
 * @author dezzyanthony
 *
 */

public class Auswahleigenschaft extends Eigenschaft {
	
	
	//-------------Variablen-der-Klasse-Auswahleigenschaft------------------
	
	/**
	 * Variable auswahlEigenschaft ist eine Auswahl, welche der Teilnehmer auswählt
	 */
	private String auswahlEigenschaft;
	
	
	
	//---------------Get-Methoden----------------------------
	
	/**
	 * Abfragen der Auswahleigenschaft
	 * @return
	 */
	public String getAuswahleigenschaft(){
		return auswahlEigenschaft;
	}
	
	
	//---------------Set-Methoden----------------------------
	
	
	/**
	 * Setzen einer Auswahleigneschaft
	 * @param auswahlEigenschaft
	 */
	public void setAuswahleigenschaft(String auswahlEigenschaft){
		this.auswahlEigenschaft = auswahlEigenschaft;
	}
}
