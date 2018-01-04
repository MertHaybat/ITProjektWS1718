package de.hdm.ITProjekt17.client;

import java.text.SimpleDateFormat;
import java.util.Vector;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.gui.Menubar;
import de.hdm.ITProjekt17.client.gui.Profilseite;
import de.hdm.ITProjekt17.client.gui.Topbar;
import de.hdm.ITProjekt17.shared.LoginService;
import de.hdm.ITProjekt17.shared.LoginServiceAsync;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;


/**
 * Entry-Point-Klasse des Projekts "ITProjektWS1718- Partnerboerse"
 * @author Mert
 *
 */

public class ITProjektWS1718 implements EntryPoint{
	/* 
	 * Panel, Label und Anchor f�r die Anmeldung
	 */
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Please sign in to your Google Account to access the Partnerbörse application.");
	private Anchor signInLink = new Anchor("Sign In");
	private Anchor signOutLink = new Anchor("Sign Out");
	private Profil profil = new Profil();
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	@Override
	public void onModuleLoad() {
		// Check login status using login service.
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		//Start-URL der Anwendung GWT.getHostPageBaseURL() !!!
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(LoginInfo result) {
			loginInfo = result;
			if (loginInfo.isLoggedIn()) {
				profil.setEmail("blabla@web.de");
				profil.setGeschlecht(true);
				profil.setHaarfarbe("schwarz");
				profil.setId(1);
				profil.setKoerpergroesse(196);
				profil.setNachname("nachname");
				profil.setRaucher(true);
				profil.setReligion("katholisch");
				profil.setVorname("vorname");
				loadPartnerboerse(profil);
			}
			else {
				loadLogin();
			}
			/**
			 * Ausgeklammert da die Applikationsschicht noch fehler beinhaltet und wir deshalb die GUI nicht starten k�nnen..
			 */
//				pbverwaltung.getAllProfil(new AsyncCallback<Vector<Profil>>(){
//
//					@Override
//					public void onFailure(Throwable caught) {
//						Window.alert("Login fehlgeschlagen");
//					}
//
//					@Override
//					public void onSuccess(Vector<Profil> result) {
//						boolean isUserRegistered = false;
//						for (Profil profil : result){
//							//Überprüfung ob User bereits registriert ist
//							if(profil.getEmail() == loginInfo.getEmailAddress()){
//								isUserRegistered = true;
//								/**
//								 * Falls User registriert ist wird die Partnerbörse geladen
//								 * @param id des jeweiligen Person-Objekts
//								 */
//								loadPartnerboerse(profil);
//								break;
//							}
//						}
//						if (isUserRegistered == false){
//							RootPanel.get("Details").clear();
//							/**
//							 * Falls User noch nicht registriert ist wird der User zur Profilseite weitergeleitet, 
//							 * indem er aufgefordert wird, seine Daten einzutragen.
//							 */
//							RootPanel.get("Details").add(new Profilseite());
//						}
//					}
//
//				});
//				
//			}else{
//				loadLogin();
//			}
			}
			
		});			
	}
	
	
	//Zusammenstellung des Anmeldeabschnitts
	private void loadLogin(){
		signInLink.setHref(loginInfo.getLoginUrl());
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		RootPanel.get("Details").add(loginPanel);
	}
	
	private void loadPartnerboerse(Profil profil){
		signOutLink.setHref(loginInfo.getLogoutUrl());
		Menubar mb = new Menubar(profil);
		RootPanel.get("Navigator").add(mb);
		Topbar tp = new Topbar(profil);
		RootPanel.get("Topbar").add(tp);
//		BeispielSeite b = new BeispielSeite();
//		b.add(signOutLink);
//		RootPanel.get("Details").add(b);
	}
}