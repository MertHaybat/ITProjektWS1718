package de.hdm.ITProjekt17.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.LoginService;
import de.hdm.ITProjekt17.shared.LoginServiceAsync;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class PartnerboerseReport implements EntryPoint{
	
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Please sign in to your Google Account to access the Partnerbörse application.");
	private Anchor signInLink = new Anchor("Sign In");
	private Anchor signOutLink = new Anchor("Sign Out");
	private Anchor partnerlink = new Anchor();
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	private static ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();
	
	@Override
	public void onModuleLoad() {

		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			
			@Override
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				reportverwaltung.checkProfil(loginInfo.getEmailAddress(), new AsyncCallback<Profil>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Profil result) {
						if(result == null){
							Window.alert("Bitte registrieren Sie sich über den Projektmarktplatz");	
							partnerlink.setHref(GWT.getHostPageBaseURL()+"ITProjektWS1718.html");
							Window.open(partnerlink.getHref(), "_self", "");
						}
						else if (result!= null){
							loadreport(result);
						}
					}
				});
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler Login: " + caught.toString());
			}
		});
	}
	private void loadreport(final Profil profil){
		signOutLink.setHref(loginInfo.getLogoutUrl());
		RootPanel.get("Topbar").add(signOutLink);
		
	}

}
