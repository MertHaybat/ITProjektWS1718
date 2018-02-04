package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * Dialogbox die angezeigt wird wenn ein Teilnehmer der Partnerbörse sein Profil löschen will.
 * Dient als Sicherheitsabfrage alls ein Teilnehmer ausversehen auf den Button zum löschen des Profils klickt.
 * @author Giuseppe
 *
 */

public class Profil_loeschen_Dialogbox extends DialogBox{
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();

	public Profil_loeschen_Dialogbox(final Profil profil){
		
		/**
		 * Dialogbox Überschrift
		 */
		setText("Wollen Sie das Profil wirklich löschen?");
		setAnimationEnabled(true);	
		HorizontalPanel hpanel = new HorizontalPanel();
		
		Button ja = new Button("Ja");
		Button nein = new Button("Nein");
		hpanel.add(ja);
		hpanel.add(nein);
		this.add(hpanel);
		
		ja.addClickHandler(new ClickHandler() {

			/**
			 * Interface clickhandler wird als anonyme klasse erstellt und realisert 
			 * die on click methode, die auf einen klick wartet und dann ausgeführt
			 * wird wenn der Button geklickt wird.
			 */
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				pbverwaltung.delete(profil, new AsyncCallback<Void>(){

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
						// TODO Auto-generated method stub
						Window.alert("Profil wurde erfolgreich gelöscht. Starten Sie die Seite neu.");
						RootPanel.get("Navigator").clear();
						RootPanel.get("Details").clear();
						hide();
					}
					
					
				});
			}
			
		});
		
		nein.addClickHandler(new ClickHandler(){

			/**
			 * Interface clickhandler wird als anonyme klasse erstellt und realisert 
			 * die on click methode, die auf einen klick wartet und dann ausgeführt
			 * wird wenn der Button geklickt wird.
			 */
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hide();
			}
			
			
		});
	}

}
