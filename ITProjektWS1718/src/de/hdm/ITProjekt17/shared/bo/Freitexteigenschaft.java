package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Auswahleigenschaft von Profilen
 * Mit diseer Klasse werden exemplarische Auswahleigenschaften vergeben.
 *
 */

public class Freitexteigenschaft extends Eigenschaft{
	
	private static final long serialVersionUID = 1L; 
	
	
	
	/**
	 * Variablen wert, welche den Wert später speichert der als freitext geschreiben wird
	 */
	private String wert = "";

	public Freitexteigenschaft(){
		
	}
	
	//---------------Get-Methoden---------------------------
	
	public String getWert() {
		return this.wert;
	}

	//---------------Set-Methoden-----------------------------
	
	public void setWert(String wert) {
		this.wert = wert;
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Freitexteigenschaft-ID: #" + this.getId() +
					" Wert: #" + this.getWert();
				
					
	}
}