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
import com.google.gwt.user.client.ui.HorizontalPanel;
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

/**
 * Deese Seite wird erstellt wenn man auf der Suchenseite eine Suche anhand des erstellten Suchrprofils startet.
 * Hier werden die Ergebnisse der suche sichtbar.
 * @author Mert
 *
 */
public class Suchergebnis extends VerticalPanel{
	
	/**
	 * Erstellen aller Buttons und anderen wichtigen Objekte für die Realisierung der Seite.
	 */
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
					
					/**
					 * Siehe Client.gui.report
					 */
					public void onSuccess(Vector<Profil> result) {
						p1.setRowData(0, result);
						p1.setRowCount(result.size(), true);
					
					}
					
					/**
					 * Siehe Client.gui.report
					 */
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
		vpanel.add(zurückzusuchen);
		vpanel.add(suchergebnisse);
		vpanel.add(p1);
		this.add(vpanel);
		
		p1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			/**
			 * Wird ausgeführt wenn ein Profil besucht wird und erstellt eine Dialogbox des Profils das Besucht wird.
			 */
			public void onSelectionChange(SelectionChangeEvent event) {
				pbverwaltung.visit(profil.getId(), p1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Besuch>() {

					
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					
					public void onSuccess(Besuch result) {
						// TODO Auto-generated method stub
						
					}
				});
				HorizontalPanel hpanel = new HorizontalPanel();
				HorizontalPanel hpanel2 = new HorizontalPanel();
				VerticalPanel vpanel = new VerticalPanel();	
				final DialogBox b1 = new DialogBox();
				Profil_Dialogbox profildialogbox = new Profil_Dialogbox(profil, p1.getSsm_profil_anzeige().getSelectedObject());
				Profil_Info_Dialogbox profilinfo = new Profil_Info_Dialogbox(profil, p1.getSsm_profil_anzeige().getSelectedObject());
				hpanel.add(profildialogbox);
				hpanel.add(profilinfo);
				hpanel2.add(kontaktmerken);
				hpanel2.add(kontaktsperren);
				hpanel2.add(zursuche);
				vpanel.add(hpanel);
				vpanel.add(hpanel2);
				b1.add(vpanel);
				b1.setText("Profil");
				b1.center();
				zursuche.addClickHandler(new ClickHandler() {
					
					
					public void onClick(ClickEvent event) {
					b1.hide();
					}
				});
				kontaktmerken.addClickHandler(new ClickHandler() {
					
					/**
					 * Interface clickhandler wird als anonyme klasse erstellt und realisert 
					 * die on click methode, die auf einen klick wartet und dann ausgeführt
					 * wird wenn der Button geklickt wird.
					 */
					public void onClick(ClickEvent event) {
						pbverwaltung.createMerkzettel(profil, p1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Merkzettel>() {

							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							
							public void onSuccess(Merkzettel result) {
								Window.alert("Profil wurde in die Merkliste gesetzt");
								b1.hide();
							}
						});
						
					}
				});
				kontaktsperren.addClickHandler(new ClickHandler() {
					
					/**
					 * Interface clickhandler wird als anonyme klasse erstellt und realisert 
					 * die on click methode, die auf einen klick wartet und dann ausgeführt
					 * wird wenn der Button geklickt wird.
					 */
					public void onClick(ClickEvent event) {
						pbverwaltung.createKontaktsperre(profil, p1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Kontaktsperre>() {

							
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							
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
