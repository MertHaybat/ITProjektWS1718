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
import de.hdm.ITProjekt17.client.gui.Startseite;
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
				profil.setGeschlecht("Männlich");
				profil.setHaarfarbe("schwarz");
				profil.setId(1);
				profil.setKoerpergroesse(196);
				profil.setNachname("nachname");
				profil.setRaucher("nein");
				profil.setReligion("katholisch");
				profil.setVorname("vorname");
				loadPartnerboerse(profil);
				
//				pbverwaltung.checkProfil(loginInfo.getEmailAddress(), new AsyncCallback<Profil>(){
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onSuccess(Profil result) {
//						// Überprüfung, ob Profil bereits registriert.
//						if (result!= null){
//							RootPanel.get("Details").clear();
//							loadPartnerboerse(result);
//						} else {
//							RootPanel.get("Details").clear();
//							/**
//							 * Falls User noch nicht registriert ist wird der User zur Profilseite weitergeleitet, 
//							 * indem er aufgefordert wird, seine Daten einzutragen.
//							 */
//							RootPanel.get("Details").add(new Profilseite());
//						}
//						
//					}
//					
//				});
				
				
				
			}
			else {
				loadLogin();
			}
			
		
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
		RootPanel.get("Details").add(new Startseite());
		RootPanel.get("Navigator").add(new Menubar(profil));
		RootPanel.get("Topbar").add(new Topbar(profil));
	}
}