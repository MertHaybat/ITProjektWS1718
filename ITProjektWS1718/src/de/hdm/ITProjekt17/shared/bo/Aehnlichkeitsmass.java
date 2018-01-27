package de.hdm.ITProjekt17.shared.bo;

public class Aehnlichkeitsmass extends BusinessObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private int eigenes_profilid = 0;
	private int fremdes_profilid = 0;
	private int aehnlichkeitsindex = 0;
	/**
	 * Auslesen der eigenen Profil id
	 * @return eigenes_profilid
	 */
	public int getEigenes_profilid() {
		return eigenes_profilid;
	}
	/**
	 * Setzen der eigenen Profil id
	 * @param eigenes_profilid
	 */
	public void setEigenes_profilid(int eigenes_profilid) {
		this.eigenes_profilid = eigenes_profilid;
	}
	/**
	 * Auslesen der id eines fremden Profils
	 * @return fremdes_profilid
	 */
	public int getFremdes_profilid() {
		return fremdes_profilid;
	}
	/**
	 * Setzen der id des fremden Profils
	 * @param fremdes_profilid
	 */
	public void setFremdes_profilid(int fremdes_profilid) {
		this.fremdes_profilid = fremdes_profilid;
	}
	/**
	 * Auslesen des Ähnlichkeitsindex
	 * @return aehnlichkeitsindex
	 */
	public int getAehnlichkeitsindex() {
		return aehnlichkeitsindex;
	}
	/**
	 * Setzen des Ähnlichkeitsindex
	 * @param aehnlichkeitsindex
	 */
	public void setAehnlichkeitsindex(int aehnlichkeitsindex) {
		this.aehnlichkeitsindex = aehnlichkeitsindex;
	}
}
