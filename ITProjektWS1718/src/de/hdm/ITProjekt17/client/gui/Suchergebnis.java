package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import javax.swing.text.AsyncBoxView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;
import de.hdm.ITProjekt17.shared.bo.Besuch;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;

public class Suchergebnis extends VerticalPanel{
	
	private Button kontaktsperren = new Button("Kontakt sperren");
	private Button kontaktmerken = new Button("Kontakt merken");
	private Button zursuche = new Button("Zurück");
		
	private Profil_Tabelle p1 = new Profil_Tabelle();
	private VerticalPanel vpanel = new VerticalPanel();
	private Anchor zurückzusuchen = new Anchor("Zurück zu Suchen");
	private HTML suchergebnisse = new HTML("Ihre Suchergebnisse: ");
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	public Suchergebnis (final Profil profil, final Suchprofil suchprofil){
		zurückzusuchen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Suchen(profil));
			}
		});
		pbverwaltung.getAllProfilsOf(suchprofil, new AsyncCallback<Vector<Profil>>() {
					
					@Override
					public void onSuccess(Vector<Profil> result) {
						p1.setRowData(0, result);
						p1.setRowCount(result.size(), true);
					
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
		vpanel.add(zurückzusuchen);
		vpanel.add(suchergebnisse);
		vpanel.add(p1);
		this.add(vpanel);
		
		p1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				pbverwaltung.visit(profil.getId(), p1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Besuch>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Besuch result) {
						// TODO Auto-generated method stub
						
					}
				});
				final DialogBox b1 = new DialogBox();
				Profil_Dialogbox profildialogbox = new Profil_Dialogbox(profil, p1.getSsm_profil_anzeige().getSelectedObject());
				profildialogbox.setWidget(8, 0, kontaktmerken);
				profildialogbox.setWidget(8, 1, kontaktsperren);
				profildialogbox.setWidget(8, 2, zursuche);
				b1.add(profildialogbox);
				b1.center();
				zursuche.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
					b1.hide();
					}
				});
				kontaktmerken.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						pbverwaltung.createMerkzettel(profil, p1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Merkzettel>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Merkzettel result) {
								Window.alert("Profil wurde in die Merkliste gesetzt");
								b1.hide();
							}
						});
						
					}
				});
				kontaktsperren.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						pbverwaltung.createKontaktsperre(profil, p1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Kontaktsperre>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Kontaktsperre result) {
								Window.alert("Profil wurde gesperrt");
								b1.hide();
							}
						});
					}
				});
				
			}
		});
	}
	

}
