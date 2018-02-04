package de.hdm.ITProjekt17.shared.bo;


/**
 * Diese Abstrakte Klasse wird in den Subklassen Freitext- und Auswahleigenschaft realisiert.
 * @author Dennis Lehle
 *
 */
public abstract class Eigenschaft extends BusinessObject {

	/**
	 * Dient zum Serialisieren von Objekten für eine RPC fähigen austausch zwischen Server und Client.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 */
	public Eigenschaft(){
		
	}
	
	
	
	public abstract String getWert();
	public abstract void setWert(String wert);
			
}
	
