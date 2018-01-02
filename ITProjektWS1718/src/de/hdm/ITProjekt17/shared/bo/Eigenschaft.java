package de.hdm.ITProjekt17.shared.bo;


/**
 * Diese Klasse besitzt nur die eigene ID, welche von der Superklasse Business Object abgeleitet (geerbt) wurde.
 * In der Datenbank befindet sich in der Tabelle Eigenschaft auch nur der Primärschlüssel ID.
 * Dieser Schlüssel verbindet die Tabellen Info, Freitext- und Auswahleigenschaft mit dem Fremdschlüssel (Eigenschaftid) miteinander.
 * @author dezzyanthony
 *
 */
public abstract class Eigenschaft extends BusinessObject {


	private static final long serialVersionUID = 1L;

	
	public Eigenschaft(){
		
	}
	
	public abstract int getEigenschaftid();
	public abstract String getWert();
	public abstract void setEigenschaftid(int eigenschaftid);
	public abstract void setWert(String wert);
	
	
	/*
	 * Erzeugung einer textuellen Darstellung des jeweiligen Objektes einer Klasse
	 */
	public String toString(){
		return super.toString() + 
					" Eigenschaft-ID: #" + this.getId();
			
	}
	
}
