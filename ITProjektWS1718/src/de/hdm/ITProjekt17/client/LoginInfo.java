package de.hdm.ITProjekt17.client;


import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Login RPC Dienst - Ergebnis des Login-Dienstes soll ein Objekt der Klasse "LoginInfo" sein, in der alle
 * ben�tigten Elemente eines angemeldeten Nutzers verf�gbar sind
 * @author Mert in Anlehnung an die Folien "GWT Benutzungsschnittstellen"
 *
 */

public class LoginInfo implements IsSerializable{

	/**
	 * Dient zum Serialisieren von Objekten für eine RPC fähigen austausch zwischen Server und Client.
	 */
	private static final long serialVersionUID = 1L;
	private boolean loggedIn = false;
	private String loginUrl;
	private String logoutUrl;
	private String emailAddress;
	private String nickname;
	
	/**
	 * prüfen ob user eingeloggt ist
	 * @return loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}
	/**
	 * setzen des logins
	 * @param loggedIn
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	/**
	 * auslesen der login url
	 * @return loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}
	
	/**
	 * setzen des loginUrl
	 * @param loginUrl
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	/**
	 * auslesen des logoutsUrl
	 * @return logoutUrl
	 */
	public String getLogoutUrl() {
		return logoutUrl;
	}
	
	/**
	 * setzen der LogoutUrl
	 * @param logoutUrl
	 */
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	
	/**
	 * auslesen der email adresse
	 * @return emailAdresse
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * setzen der emailAdresse
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * auslesen von dem nicknamen
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * setzen von dem nicknamen
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

}
