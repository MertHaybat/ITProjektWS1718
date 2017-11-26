package de.hdm.ITProjekt17.shared.bo;

/**
 * Realisierung einer exemplarischen Auswahleigenschaft von Profilen
 * Mit diseer Klasse werden exemplarische Auswahleigenschaften vergeben.
 *
 */


public class Auswahleigenschaft extends Eigenschaft {
	
	private static final long serialVersionUID = 1L; 

	
	//--------Variablen-der-Klasse-Auswahleigenschaft----------------
	
	private int auswahleigenschaftId = 0;
	

	private String Auswahleigenschaft;

	public int getAuswahleigenschaftId() {
		return auswahleigenschaftId;
	}

	public void setAuswahleigenschaftId(int auswahleigenschaftId) {
		this.auswahleigenschaftId = auswahleigenschaftId;
	}

	public String getAuswahleigenschaft() {
		return Auswahleigenschaft;
	}

	public void setAuswahleigenschaft(String auswahleigenschaft) {
		Auswahleigenschaft = auswahleigenschaft;
	}
	
}
