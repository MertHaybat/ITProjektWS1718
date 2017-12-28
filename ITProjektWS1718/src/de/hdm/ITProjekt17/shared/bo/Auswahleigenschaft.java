package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen AUswahleigenschaft der Partnerbörse.
 * Sie erlaubt es Auswahlen treffen zu können.
 * @author dezzyanthony
 *
 */

public class Auswahleigenschaft extends Eigenschaft {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//-------------Variablen-der-Klasse-Auswahleigenschaft------------------
	
	/**
	 * Variable auswahlEigenschaft ist eine Auswahl, welche der Teilnehmer auswählt
	 */
	private String wert = "";
	private int eigenschaftid = 0;
	
	public Auswahleigenschaft(){
		
	}
	
	
	//---------------Get-Methoden----------------------------
	
	

	public int getEigenschaftid() {
		return eigenschaftid;
	}



	/**
	 * Abfragen der Auswahleigenschaft
	 * @return
	 */
	public String getWert(){
		return this.wert;
	}
	
	
	//---------------Set-Methoden----------------------------
	
	
	/**
	 * Setzen einer Auswahleigneschaft
	 * @param auswahlEigenschaft
	 */
	public void setWert(String wert){
		this.wert = wert;
	}

	public void setEigenschaftid(int eigenschaftid) {
		this.eigenschaftid = eigenschaftid;
		
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					" Auswahleigenschaft-ID: #" + this.getId() + 
					" Wert: #" + this.getWert() +
					" Eigenschaft-Id: #" + this.getEigenschaftid();
				
					
	}
	
}
