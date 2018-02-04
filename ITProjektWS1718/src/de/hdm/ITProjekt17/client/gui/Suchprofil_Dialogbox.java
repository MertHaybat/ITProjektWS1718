package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
/**
 * Dialogbox um Suchprofil anzuzeigen oder zu löschen 
 * @author Giuseppe
 *
 */

public class Suchprofil_Dialogbox extends DialogBox{
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();


	public Suchprofil_Dialogbox(final Profil profil, final Suchprofil suchprofil){
		
		/**
		 * Dialogbox Überschrift
		 */
		setText("Was wollen Sie tun?");
		setAnimationEnabled(true);
		
		
		Button profileAnzeigen = new Button("Profile anzeigen");
		Button suchprofilLöschen = new Button("Suchprofil löschen");
		Button zurück = new Button("Zurück");

		profileAnzeigen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Suchergebnis(profil, suchprofil));
			}
		});
		
		suchprofilLöschen.addClickHandler(new ClickHandler(){

			/**
			 * Interface clickhandler wird als anonyme klasse erstellt und realisert 
			 * die on click methode, die auf einen klick wartet und dann ausgeführt
			 * wird wenn der Button geklickt wird.
			 */
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			pbverwaltung.deleteSuchprofil(suchprofil, new AsyncCallback<Void>() {

				/**
				 * Siehe Client.gui.report
				 */
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				/**
				 * Siehe Client.gui.report
				 */
				public void onSuccess(Void result) {
					Window.alert("Das Suchprofil wurde erfolgreich gelöscht");	
					hide();					
					RootPanel.get("Details").clear();
					RootPanel.get("Details").add(new Suchen(profil));
					 hide();   
				}
			});
			}
			
		});
		
		
			zurück.addClickHandler(new ClickHandler() {
			
				@Override
				public void onClick(ClickEvent event) {
					 hide(); 
					
				}

			});
			/**
			 * Erstellen eines Labels welches fragt ob eine suche durchgeführt werden soll oder nicht.
			 */
		
		Label label = new Label("Möchten Sie die Suche starten oder das Suchprofil löschen?");

        VerticalPanel panel = new VerticalPanel();
        panel.setHeight("150");
        panel.setWidth("300");
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(label);
        panel.add(profileAnzeigen);
        panel.add(suchprofilLöschen);
        panel.add(zurück);
        setWidget(panel);
        
        
	}	
}
