package de.hdm.ITProjekt17.shared.bo;

/**
 * Realisierung einer exemplarischen Auswahleigenschaft von Profilen
 * Mit diseer Klasse werden exemplarische Auswahleigenschaften vergeben.
 *
 */

public class Freitexteigenschaft extends Eigenschaft{
	
	private static final long serialVersionUID = 1L; 
	
	private String Freitexteigenschaft;

	private int freitexteigenschaftId = 0;

	public String getFreitexteigenschaft() {
		return Freitexteigenschaft;
	}

	public void setFreitexteigenschaft(String freitexteigenschaft) {
		Freitexteigenschaft = freitexteigenschaft;
	}

	public int getFreitexteigenschaftId() {
		return freitexteigenschaftId;
	}

	public void setFreitexteigenschaftId(int freitexteigenschaftId) {
		this.freitexteigenschaftId = freitexteigenschaftId;
	}


	}


