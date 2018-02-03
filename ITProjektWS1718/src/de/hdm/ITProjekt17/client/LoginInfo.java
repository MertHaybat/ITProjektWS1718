package de.hdm.ITProjekt17.client;


import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Login RPC Dienst - Ergebnis des Login-Dienstes soll ein Objekt der Klasse "LoginInfo" sein, in der alle
 * ben�tigten Elemente eines angemeldeten Nutzers verf�gbar sind
 * @author Mert in Anlehnung an die Folien "GWT Benutzungsschnittstellen"
 *
 */

public class LoginInfo implements IsSerializable{

	private static final long serialVersionUID = 1L;
	private boolean loggedIn = false;
	private String loginUrl;
	private String logoutUrl;
	private String emailAddress;
	private String nickname;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

}
