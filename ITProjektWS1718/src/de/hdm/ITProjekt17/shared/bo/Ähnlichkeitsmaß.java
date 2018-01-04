/**
 * 
 */
package de.hdm.ITProjekt17.shared.bo;

/**
 * @author Mert
 *
 */
public class Ähnlichkeitsmaß extends BusinessObject{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int profilid;
	private int suchprofilid;
	private double index;
	
	public Ähnlichkeitsmaß(){
		
	}
	
	/**
	 * Profil-ID des Nutzers, der "gefunden" wird.
	 * @return profilid
	 */
	public int getProfilid() {
		return profilid;
	}
	/**
	 * 
	 * @param profilid
	 */
	public void setProfilid(int profilid) {
		this.profilid = profilid;
	}
	/**
	 * SuchprofilID des Nutzers der die Suche startet
	 * @return
	 */
	public int getSuchprofilid() {
		return suchprofilid;
	}
	public void setSuchprofilid(int suchprofilid) {
		this.suchprofilid = suchprofilid;
	}
	/**
	 * Der Ähnlichkeitsindex
	 * @return
	 */
	public double getIndex() {
		return index;
	}
	public void setIndex(double index) {
		this.index = index;
	}
	
	

}
