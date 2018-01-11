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
	
	private int infoid = 0;
	
	public Auswahleigenschaft(){
		
	}
	
	
	//---------------Get-Methoden----------------------------

	/**
	 * Abfragen der Auswahleigenschaft
	 * @return
	 */
	public String getWert(){
		return this.wert;
	}
	
	public int getInfoid(){
		return this.infoid;
	}
	
	//---------------Set-Methoden----------------------------
	
	
	/**
	 * Setzen einer Auswahleigneschaft
	 * @param auswahlEigenschaft
	 */
	public void setWert(String wert){
		this.wert = wert;
	}
	
	public void setInfoid(int infoid){
		this.infoid = infoid;
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					" Auswahleigenschaft-ID: #" + this.getId() + 
					" Wert: #" + this.getWert();
			
	}
	
}
