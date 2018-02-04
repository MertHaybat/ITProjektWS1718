package de.hdm.ITProjekt17.client;

import java.util.Date;

import com.google.gwt.core.client.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.gui.Menubar;
import de.hdm.ITProjekt17.client.gui.Profilseite;
import de.hdm.ITProjekt17.client.gui.Startseite;
import de.hdm.ITProjekt17.shared.LoginService;
import de.hdm.ITProjekt17.shared.LoginServiceAsync;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * Entry-Point-Klasse des Projekts "ITProjektWS1718- Partnerboerse"
 * 
 * @author Mert
 *
 */

public class ITProjektWS1718 implements EntryPoint {
	/**
	 * Panel, Label und Anchor f�r die Anmeldung
	 */
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label(
			"Please sign in to your Google Account to access the Partnerbörse application.");
	private Anchor signInLink = new Anchor("Sign In");
	private Anchor signOutLink = new Anchor("Sign Out");
	// private Profil profil = new Profil();
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	/**
	 * Anlegen vom report und anchor
	 */
	private Button zumreportgenerator = new Button("Zum Report Generator");
	private Anchor reportLink = new Anchor();
	private Button zurpartnerborse = new Button("Zur Partnerbörse");

	/**
	 * Hier steigt das Programm beim Start ein
	 */
	public void onModuleLoad() {

		// Check login status using login service.
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		// Start-URL der Anwendung GWT.getHostPageBaseURL() !!!
		loginService.login(GWT.getHostPageBaseURL() + "ITProjektWS1718.html", new AsyncCallback<LoginInfo>() {

			/**
			 * siehe client google report
			 */
			public void onFailure(Throwable caught) {
				Window.alert("Fehler Login: " + caught.toString());
			}

			/**
			 * siehe client google report
			 */
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				if (loginInfo.isLoggedIn()) {

					pbverwaltung.checkProfil(loginInfo.getEmailAddress(), new AsyncCallback<Profil>() {

						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert("Fehler beim Laden: " + caught.getLocalizedMessage());
						}

						public void onSuccess(Profil result) {
							// Überprüfung, ob Profil bereits registriert.
							if (result != null) {
								RootPanel.get("Details").clear();
								loadPartnerboerse(result);
							} else {
								RootPanel.get("Details").clear();
								/**
								 * Falls User noch nicht registriert ist wird
								 * der User zur Profilseite weitergeleitet,
								 * indem er aufgefordert wird, seine Daten
								 * einzutragen.
								 */
								signOutLink.setHref(loginInfo.getLogoutUrl());
								RootPanel.get("Navigator").add(new Menubar());
								RootPanel.get("Details").add(new Profilseite(loginInfo.getEmailAddress(), signOutLink));
							}

						}

					});

				} else {
					loadLogin();
				}

			}

		});
	}

	/**
	 * Zusammenstellung des Anmeldeabschnitts
	 */
	private void loadLogin() {
		zurpartnerborse.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				signInLink.setHref(loginInfo.getLoginUrl());
				Window.open(signInLink.getHref(), "_self", "");

			}
		});
		zumreportgenerator.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				reportLink.setHref(GWT.getHostPageBaseURL() + "ITProjektWS1718Report.html");
				Window.open(reportLink.getHref(), "_self", "");
			}
		});
		loginPanel.add(loginLabel);
		loginPanel.add(zurpartnerborse);
		loginPanel.add(zumreportgenerator);
		RootPanel.get("Details").add(loginPanel);

	}

	/**
	 * laden der partnerbörse. (Startseite Menübar)
	 * 
	 * @param profil
	 */
	private void loadPartnerboerse(final Profil profil) {
		signOutLink.setHref(loginInfo.getLogoutUrl());
		RootPanel.get("Topbar").add(signOutLink);
		RootPanel.get("Details").add(new Startseite(profil));
		RootPanel.get("Navigator").add(new Menubar(profil));

	}

}
