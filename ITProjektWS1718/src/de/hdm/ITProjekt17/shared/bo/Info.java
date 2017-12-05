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
	/**
	 * Variable eigenschaftid ist die ID von Eigenschaft als FS
	 */
	private int eigenschaftid;
	
	
	
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
	/**
	 * Auslesen der Eigenschaft id
	 * @return
	 */
	public int getEigenschaftid(){
		return eigenschaftid;
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
	/**
	 * Setzen einer Eigenschaft id
	 * @param eigenschaftid
	 */
	public void setEigenschaftid(int eigenschaftid){
		this.eigenschaftid = eigenschaftid;
	}
}
