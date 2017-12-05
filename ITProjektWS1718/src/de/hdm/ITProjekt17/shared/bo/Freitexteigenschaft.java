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
	private String wert;
	/**
	 * Variable eigenschaftid ist als Fredmschlüssel in dieser Klasse gespeichert
	 */
	private int eigenschaftid;

	
	
	//---------------Get-Methoden---------------------------
	
	public int getEigenschaftid() {
		return eigenschaftid;
	}
	
	public String getWert() {
		return this.wert;
	}

	//---------------Set-Methoden-----------------------------
	
	public void setEigenschaftid(int eigenschaftid) {
		this.eigenschaftid = eigenschaftid;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}
}