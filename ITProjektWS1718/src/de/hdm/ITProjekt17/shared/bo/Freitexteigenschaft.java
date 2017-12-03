package de.hdm.ITProjekt17.shared.bo;


/**
 * Realisierung einer exemplarischen Auswahleigenschaft von Profilen
 * Mit diseer Klasse werden exemplarische Auswahleigenschaften vergeben.
 *
 */

public class Freitexteigenschaft extends Eigenschaft{
	
	private static final long serialVersionUID = 1L; 
	
	private String wert;
	
	private int eigenschaftid;

	public int getEigenschaftid() {
		return eigenschaftid;
	}

	public void setEigenschaftid(int eigenschaftid) {
		this.eigenschaftid = eigenschaftid;
	}

	public String getWert() {
		return this.wert;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}

	public void setEigenschaft(Eigenschaft e) {
		this.eigenschaftid = eigenschaftid;
		
	}
}