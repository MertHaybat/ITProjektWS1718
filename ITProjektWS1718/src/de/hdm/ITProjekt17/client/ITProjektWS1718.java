package de.hdm.ITProjekt17.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.LoginService;
import de.hdm.ITProjekt17.shared.LoginServiceAsync;


/**
 * Entry-Point-Klasse des Projekts "ITProjektWS1718- Partnerboerse"
 * @author Mert
 *
 */

public class ITProjektWS1718 implements EntryPoint{
	/* 
	 * Panel, Label und Anchor für die Anmeldung
	 */
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Please sign in to your Google Account to access the Partnerbörse application.");
	private Anchor signInLink = new Anchor("Sign In");
	private Anchor signOutLink = new Anchor("Sign Out");
	
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
				loadPartnerboerse();
			}else{
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
	
	private void loadPartnerboerse(){
		signOutLink.setHref(loginInfo.getLogoutUrl());
		Menubar mb = new Menubar();
		RootPanel.get("Navigator").add(mb);
		Topbar tp = new Topbar();
		RootPanel.get("Topbar").add(tp);
		BeispielSeite b = new BeispielSeite();
		b.add(signOutLink);
		RootPanel.get("Details").add(b);
	}
}