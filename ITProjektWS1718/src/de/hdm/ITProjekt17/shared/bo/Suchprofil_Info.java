package de.hdm.ITProjekt17.shared.bo;

public class Suchprofil_Info extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variablen aus der Tabelle Suchprofil als Fremdschlüssel deklaration
	 */
	private int suchprofilid;
	/**
	 * Varaible aus der Tabelle Info als Fremdschlüssel deklaration
	 */
	private int infoid;
	/**
	 * no-argument-Konstrktor
	 */
	public Suchprofil_Info(){
		
	}
	
	//------------------------Get-Methoden--------------------------------
	/**
	 * Methode zum auslesen der Suchprofil Id
	 * @return suchprofilid
	 */
	public int getSuchprofilId(){
		return this.suchprofilid;
	}
	/**
	 * Methode zum auslesen der Info Id
	 * @return infoid
	 */
	public int getInfoId(){
		return this.infoid;
	}
	
	
	//------------------------Set-Methoden--------------------------------
	/**
	 * Methode zum setzten der Suchprofil Id
	 * @param suchprofilid
	 */
	public void setSuchprofilId(int suchprofilid){
		this.suchprofilid = suchprofilid;
	}
	/**
	 * Methode zum setzen der Info Id
	 * @param infoid
	 */
	public void setInfoId(int infoid){
		this.infoid = infoid;
	}
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					"Suchprofil_Info-ID: #" + this.getId() +
					" Suchprofil-Id: #" + this.getSuchprofilId() + 
					" Info-Id: #" + this.getInfoId();
					
					
					
	}
}
