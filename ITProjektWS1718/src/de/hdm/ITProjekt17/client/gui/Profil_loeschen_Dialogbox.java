package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profil_loeschen_Dialogbox extends DialogBox{
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();

	public Profil_loeschen_Dialogbox(final Profil profil){
		
		//Dialogbox Überschrift
		setText("Wollen Sie das Profil wirklich löschen?");
		setAnimationEnabled(true);	
		
		
		Button ja = new Button("Ja");
		Button nein = new Button("Nein");
		
		ja.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				pbverwaltung.delete(profil, new AsyncCallback<Void>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						Window.alert("Profil wurde erfolgreich gelöscht. Starten Sie die Seite neu.");
						RootPanel.get("Navigator").clear();
						RootPanel.get("Details").clear();
					}
					
					
				});
			}
			
		});
		
		nein.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hide();
			}
			
			
		});
	}

}
