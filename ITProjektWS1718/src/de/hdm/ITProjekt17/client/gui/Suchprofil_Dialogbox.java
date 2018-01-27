package de.hdm.ITProjekt17.client.gui;

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
		
		//Dialogbox Überschrift
		setText("Was wollen Sie tun?");
		setAnimationEnabled(true);
		
		
		Button profileAnzeigen = new Button("Profile anzeigen");
		Button suchprofilLöschen = new Button("Suchprofil löschen");
	
//		profileAnzeigen.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				Profil_Tabelle profil_Tabelle = new Profil_Tabelle();
//				pbverwaltung.getAllProfil(new AsyncCallback<Profil>(){
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onSuccess(Profil result) {
//						// TODO Auto-generated method stub
//						RootPanel.get("Details").clear();
//						RootPanel.get("Details").add(new Profil_Tabelle(result));
//					}
//					
//				});
//				
//			}
//			
//			
//		});  <---- Methode bearbeiten + Auf Profil_Tabelle Konstruktor mit Profil als Übergabeparameter anlegen
		
		suchprofilLöschen.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
//			pbverwaltung.deleteSuchprofil(suchprofil, new AsyncCallback<Suchprofil>(){
//
//				@Override
//				public void onFailure(Throwable caught) {
//					// TODO Auto-generated method stub
//					Window.alert("Löschen nicht möglich");
//				}
//
//				@Override
//				public void onSuccess(Suchprofil result) {
//					// TODO Auto-generated method stub
//					Window.alert("Das Suchprofil wurde erfolgreich gelöscht");
//
//				}
//				
//			});
			}
			
		});
		
		Label label = new Label("Möchten Sie die Suche starten oder das Suchprofil löschen?");

        VerticalPanel panel = new VerticalPanel();
        panel.setHeight("100");
        panel.setWidth("300");
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(label);
        panel.add(profileAnzeigen);
        panel.add(suchprofilLöschen);
        setWidget(panel);
        
        
	}	
}
	//Das muss noch in die DoubleClick Methode
//Window.alert("That's it!");
//Suchprofil_Dialogbox suchprofil_Dialogbox = new Suchprofil_Dialogbox();
//int left = Window.getClientWidth()/ 2;
//int top = Window.getClientHeight()/ 2;
//suchprofil_Dialogbox.setPopupPosition(left, top);
//suchprofil_Dialogbox.show();
