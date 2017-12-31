package de.hdm.ITProjekt17.shared.bo;

/**
 * Realisierung der Klasse <code>Besuch</code> mit alle benötigten Attribute,
 * die einen Besuch beschreiben. Die Klasse stellt die Getter und Setter
 * Methoden der Attribute bereit. <code>Besuch</code> erbt von
 * <code>BusinessObject</code> und ist dadurch Serializable.
 * 
 * @author Samina
 * 
 */

public class Besuch extends BusinessObject {

	private static final long serialVersionUID = 1L;

	// -----------Variablen-der-Klasse-Besuch----------------------

	/**
	 * Die ID des besuchenden Users.
	 */
	private int besuchenderNutzerID;

	/**
	 * Die ID des besuchten Users.
	 */
	private int besuchterNutzerID;

	// --------------Set-Methoden-----------------------------

	/**
	 * Setzen der ID des besuchten User.
	 */
	public void setBesuchterNutzerID(int besuchterNutzerID) {
		this.besuchterNutzerID = besuchterNutzerID;
	}

	/**
	 * Setzen der ID des besuchenden User.
	 */
	public void setBesuchenderNutzerID(int besuchenderNutzerID) {
		this.besuchenderNutzerID = besuchenderNutzerID;
	}

	// -------------------Get-Methoden-----------------------------

	/**
	 * Auslesen der ID des besuchenden User.
	 */
	public int getBesuchenderNutzerID() {
		return besuchenderNutzerID;
	}

	/**
	 * Auslesen der ID des besuchten User.
	 */
	public int getBesuchterNutzerID() {
		return besuchterNutzerID;
	}

}
