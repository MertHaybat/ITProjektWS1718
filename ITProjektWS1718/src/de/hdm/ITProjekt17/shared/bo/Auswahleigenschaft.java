package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Auswahleigenschaft der Partnerbörse.
 * @author Dennis Lehle
 *
 */

public class Auswahleigenschaft extends Eigenschaft {
	
	
	/**
	 * Dient zum Serialisieren von Objekten für eine RPC fähigen austausch zwischen Server und Client.
	 */
	private static final long serialVersionUID = 1L;
	//-------------Variablen-der-Klasse-Auswahleigenschaft------------------
	
	/**
	 * Variable wert ist der Wert, welcher als Auswahl in der GUI gewählt wird und dort gespeichert wird.
	 */
	private String wert = "";
	/**
	 * Variable Info Id ist ein Fremdschlüssel aus Tabelle Info 
	 */
	private int infoid = 0;
	
	/**
	 * Konstruktor
	 */
	public Auswahleigenschaft(){
		
	}
	
	
	//---------------Get-Methoden----------------------------

	/**
	 * Auslesen vom Wert
	 * @return wert
	 */
	public String getWert(){
		return this.wert;
	}
	/**
	 * Auslesen der Info id
	 * @return infoid
	 */
	public int getInfoid(){
		return this.infoid;
	}
	
	//---------------Set-Methoden----------------------------
	
	
	/**
	 * Setzen eines Werts
	 * @param wert
	 */
	public void setWert(String wert){
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
					" Auswahleigenschaft-ID: #" + this.getId() + 
					" Wert: #" + this.getWert();
			
	}
	
}
