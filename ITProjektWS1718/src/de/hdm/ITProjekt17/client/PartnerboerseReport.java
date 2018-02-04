package de.hdm.ITProjekt17.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.gui.Startseite;
import de.hdm.ITProjekt17.client.gui.report.MenubarReport;
import de.hdm.ITProjekt17.client.gui.report.ReportOfAllAehnlicheProfilesBySuchprofilesSeite;
import de.hdm.ITProjekt17.client.gui.report.ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite;
import de.hdm.ITProjekt17.client.gui.report.StartseiteReport;
import de.hdm.ITProjekt17.shared.LoginService;
import de.hdm.ITProjekt17.shared.LoginServiceAsync;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeAnhandSuchprofilReport;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeOfProfilNichtAngesehenReport;
/**
 *  Die Klasse PartnerboerseReport implementiert das Entry-Pojnt Interface, welches
 *  die Main() Methode von GWT darstellt. Hier steigt das Programm beim START des RG ein.
 *  
 * @author Samina
 *
 */
public class PartnerboerseReport implements EntryPoint{
	
	ReportGeneratorAsync reportGenerator = null;
//	private LoginServiceAsync loginService = ClientsideSettings.getLoginService();
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Please sign in to your Google Account to access the Partnerbörse application.");
	private Anchor signInLink = new Anchor("Sign In");
	private Anchor signOutLink = new Anchor("Sign Out");
	private Anchor partnerlink = new Anchor();
	
	
	private Button zumreportgenerator = new Button("Zum Report Generator");
	private Button zurpartnerboerse = new Button("Zur Partnerbörse");
	
	
	private Profil p1 = new Profil();
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	private static ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();
	
	/**
	 * Wird mit der Entry-Point Implementierung realisiert.
	 */
	public void onModuleLoad() {

		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL()+"ITProjektWS1718Report.html", new AsyncCallback<LoginInfo>() {
			
			
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				if (loginInfo.isLoggedIn()){
					reportverwaltung.checkProfil(loginInfo.getEmailAddress(), new AsyncCallback<Profil>() {

						/**
						 * siehe Client gui report
						 */
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}


						/**
						 * siehe Client gui report
						 */
						public void onSuccess(Profil result) {
							if (result != null){
								RootPanel.get("Details").clear();
								loadreport(result);
							
						}else{
							RootPanel.get("Details").clear();
							Window.alert("Bitte registrieren Sie sich über die Partnerbörse");	
							partnerlink.setHref(GWT.getHostPageBaseURL()+"ITProjektWS1718.html");
							Window.open(partnerlink.getHref(), "_self", "");
						}
					}
					});
				}else{
					loadlogin();
				}
				
				
			}
			
			
			public void onFailure(Throwable caught) {
				Window.alert("Fehler Login: " + caught.toString());
			}
		});
		
		
		
	}
	
	/**
	 * Laden des Reports
	 * @param profil
	 */
	private void loadreport(final Profil profil){
		signOutLink.setHref(loginInfo.getLogoutUrl());
		RootPanel.get("Topbar").add(signOutLink);
		RootPanel.get("Details").add(new StartseiteReport(profil));
		RootPanel.get("Navigator").add(new MenubarReport(profil));
	}
	
	/**
	 * Laden des Logins in den RG
	 */
	private void loadlogin(){
		zumreportgenerator.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {

				signInLink.setHref(loginInfo.getLoginUrl());
				Window.open(signInLink.getHref(), "_self", "");

			}
		});
		
		
		zurpartnerboerse.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				partnerlink.setHref(GWT.getHostPageBaseURL()+"ITProjektWS1718.html");
				Window.open(partnerlink.getHref(), "_self", "");
			}
		});
		loginPanel.add(loginLabel);
		loginPanel.add(zumreportgenerator);
		loginPanel.add(zurpartnerboerse);
		RootPanel.get("Details").add(loginPanel);
	}

}
