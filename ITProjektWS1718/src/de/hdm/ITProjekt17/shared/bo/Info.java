package de.hdm.ITProjekt17.shared.bo;



/**
 * Realisierung eines exemplarischen Info-Objektes für das Profil
 * 
 * @author dezzyanthony
 *
 */

public class Info extends BusinessObject{

	private static final long serialVersionUID = 1L;
	
	
	
	//-------------------Variablen-der-Info-Klasse--------------------
	
	/**
	 * Variable text enthält informationen des Profils
	 */
	private String text;
	
	
	
	//-----------------------Get-Methoden-----------------------------
	

	
	/**
	 * Auslesen der Information eines Profils
	 * @return
	 */
	public String getText(){
		return text;
	}
	
	
	
	//------------------------Set-Methoden---------------------------
	

	/**
	 * Setzen eines Texte's
	 * @param text
	 */
	public void setText(String text){
		this.text = text;
	}
	
	
}
