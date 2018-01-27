package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Auswahleigenschaft von Profilen
 * Mit diseer Klasse werden exemplarische Auswahleigenschaften vergeben.
 *
 */

public class Freitexteigenschaft extends Eigenschaft{
	
	private static final long serialVersionUID = 1L; 
	
	
	
	/**
	 * Variablen wert, welche den Wert später speichert der als freitext geschrieben wird
	 */
	private String wert = "";
	
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
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Freitexteigenschaft-ID: #" + this.getId() +
					" Wert: #" + this.getWert();
				
					
	}
}