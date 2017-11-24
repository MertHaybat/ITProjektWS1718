package de.hdm.ITProjekt17.shared.bo;

public class Profil extends BusinessObject {

	private static final long serialVersionUID = 1L;
	/**
	 * Variable Nachname im Profil; Gibt den Nachnamen der Person an.
	 */
	private String nachname;
	/**
	 * Variable Raucher im Profil; Gibt an, ob die Person raucht oder nicht.
	 */
	private boolean raucher;
	/**
	 * Auslesen der Variable nachname
	 * @return
	 */
	
	public String getNachname() {
		return nachname;
	}
	/**
	 * Setzen der Variable nachname
	 * @param nachname
	 */
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * Auslesen der Variable Raucher
	 * @return
	 */
	public boolean isRaucher() {
		return raucher;
	}
	/**
	 * Setzen der Variable Raucher
	 * @param raucher
	 */
	public void setRaucher(boolean raucher) {
		this.raucher = raucher;
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Profils
	 */
	public String toString(){
		return super.toString() + "Profil-ID: #" + this.getId()
		+ "Name: #" + this.nachname + "Raucher: #" + this.isRaucher();
	}
}
