package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Freitext Eigenschaft.
 * Sie erlaubt es Texte in Form von String-Literale zu schreiben.
 * @author dezzyanthony
 *
 */

public class Freitexteigenschaft extends Eigenschaft{
	
	//-----------Variablen-der-Klasse-FreiTexteigenschaft-----------
	
	/**
	 * Freie Information des Teilnehmers
	 */
	private String freiTexteigenschaft = "";
	
	
	//------------------Get-Methoden-----------------------------
	
	/**
	 * Abfragen der freiTexteigenschaft
	 * @return
	 */
	public String freiTexteigenschaft(){
		return freiTexteigenschaft;
	}
	
	
	//------------------Set-Methoden----------------------------
	
	/**
	 * Setzen der Frei Text Eigenschaft
	 * @param freiText
	 */
	public void setFreiTexteigenschaft(String freiText){
		freiTexteigenschaft = freiText;
	}
}
