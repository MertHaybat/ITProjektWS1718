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
	 * Variable profilId ist dei Id des Profil's (Fremdschl�ssel!!!)
	 */
	private int profilId;
	
	/**
	 * Variable text enthält informationen des Profils
	 */
	private String text;
	
	
	
	//-----------------------Get-Methoden-----------------------------
	
	/**
	 * Auslesen der PrfilId
	 * @return
	 */
	public int getProfilId(){
		return profilId;
	}
	
	/**
	 * Auslesen der Information eines Profils
	 * @return
	 */
	public String getText(){
		return text;
	}
	
	
	
	//------------------------Set-Methoden---------------------------
	
	/**
	 * Setzen einer ProfilId
	 * @param profilId
	 */
	public void setProfilId(int profilId){
		this.profilId = profilId;
	}
	
	/**
	 * Setzen eines Texte's
	 * @param text
	 */
	public void setText(String text){
		this.text = text;
	}

	public void setProfil(Profil p) {
		// TODO Auto-generated method stub
		
	}
	
	
}
