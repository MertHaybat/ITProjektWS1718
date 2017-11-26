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
	private Auswahleigenschaft auswahlEigenschaft;
	
	
	
	//---------------Get-Methoden----------------------------
	
	/**
	 * Abfragen der Auswahleigenschaft
	 * @return
	 */
	public Auswahleigenschaft getAuswahleigenschaft(){
		return auswahlEigenschaft;
	}
	
	
	//---------------Set-Methoden----------------------------
	
	
	/**
	 * Setzen einer Auswahleigneschaft
	 * @param auswahlEigenschaft
	 */
	public void setAuswahleigenschaft(Auswahleigenschaft auswahlEigenschaft){
		this.auswahlEigenschaft = auswahlEigenschaft;
	}
	

}
