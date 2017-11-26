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
	 * Variable profilId ist die Id des Profil's als Fremdschlüssel.
	 */
	private int profilId = 0;
	
	/**
	 * Variable eigenschaftsID ist die Id der Klasse Eigenschaft als Fremdschlüssel.
	 */
	private int eigenschaftsId = 0;
	
	/**
	 * Variable text enthält informationen des Profils.
	 */
	private String text = "";
	
	
	
	//-----------------------Get-Methoden-----------------------------
	
	/**
	 * Auslesen der PrfilId
	 * @return
	 */
	public int getProfilId(){
		return profilId;
	}
	
	/**
	 * Auslesen der EigenschaftsId
	 * @return
	 */
	public int getEigenschaftsId(){
		return eigenschaftsId;
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
	 * Setzen der EischaftsId.
	 * @param eigenschaftsId
	 */
	public void setEigenschaftsId(int eigenschaftsId){
		this.eigenschaftsId = eigenschaftsId;
	}
	
	/**
	 * Setzen eines Texte's
	 * @param text
	 */
	public void setText(String text){
		this.text = text;
	}
	
	
}
