package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Freitexteigenschaft von Profilen
 * Mit diser Klasse werden exemplarische Freitexteigenschaften erzeugt.
 *Diese Dient dazu, dass Teilnehmer der Partnerbörse Infos in Form eines
 *Freitextes in Ihr Profil schreiben können. Dient zur nähren Beschreibung 
 *eines Profils.
 */

public class Freitexteigenschaft extends Eigenschaft{
	
	/**
	 * Dient zum Serialisieren von Objekten für eine RPC fähigen austausch zwischen Server und Client.
	 */
	private static final long serialVersionUID = 1L; 

	/**
	 * Variablen wert, welche den Wert später speichert der als freitext geschrieben wird
	 */
	private String wert = "";
	
	/**
	 * Variable Infoid ist ein Fremdschlüssel in der Tabelle Freitexteigenschaft
	 */
	private int infoid = 0;
	/**
	 * Konstruktor
	 */
	public Freitexteigenschaft(){
		
	}
	
	//---------------Get-Methoden---------------------------
	
	/**
	 * Auslesen des Werts
	 * @return wert
	 */
	public String getWert() {
		return this.wert;
	}
	/**
	 * Auslesen der Infoid
	 * @return infoid
	 */
	
	public int getInfoid(){
		return this.infoid;
	}
	

	//---------------Set-Methoden-----------------------------
	
	/**
	 * Setzen eines Werts
	 * @param wert
	 */
	public void setWert(String wert) {
		this.wert = wert;
	}
	/**
	 * Setzen der Info id
	 * @param infoid
	 */
	public void setInfoid(int infoid){
		this.infoid = infoid;
	}
	
	/**
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Freitexteigenschaft-ID: #" + this.getId() +
					" Wert: #" + this.getWert();
				
					
	}
}