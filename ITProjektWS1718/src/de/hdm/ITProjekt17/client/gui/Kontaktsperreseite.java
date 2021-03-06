package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Profil;
/**
 * 
 * Erstellung der Kontaktsperreseite
 *
 */
public class Kontaktsperreseite extends VerticalPanel{
	private VerticalPanel vpaneleigene_kontaktsperren = new VerticalPanel();
	private VerticalPanel vpanelandere_kontaktsperren = new VerticalPanel();
	private VerticalPanel hpanel = new VerticalPanel();
	
	private HTML htmleigene_kontaktsperren = new HTML("<h2>Eigene Kontaktsperren:</h2>");
	private HTML htmlandere_kontaktsperren = new HTML("<h2>Sie wurden gesperrt von:</h2>");
	
	private Button zusperre = new Button("Zu Kontaktsperren");
	private Button sperreloeschen = new Button("Sperre Löschen");
	private Button zurück = new Button("Zurück");
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	public Kontaktsperreseite (final Profil profil){
		final Profil_Tabelle pt1 = new Profil_Tabelle();
		final Profil_Tabelle pt2 = new Profil_Tabelle();
		
		vpaneleigene_kontaktsperren.add(htmleigene_kontaktsperren);
		vpaneleigene_kontaktsperren.add(pt1);
		hpanel.add(vpaneleigene_kontaktsperren);
		vpanelandere_kontaktsperren.add(htmlandere_kontaktsperren);
		vpanelandere_kontaktsperren.add(pt2);
		hpanel.add(vpanelandere_kontaktsperren);
		this.add(hpanel);
		pbverwaltung.showBlockedProfilsOf(profil, new AsyncCallback<Vector<Profil>>() {
			
			/**
			 * siehe Client gui report
			 */
			public void onSuccess(Vector<Profil> result) {
				pt1.setRowData(0, result);
				pt1.setRowCount(result.size(), true);
			}
			
			/**
			 * siehe Client gui report
			 */
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		pbverwaltung.showAllBlockerOf(profil, new AsyncCallback<Vector<Profil>>() {

			
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			public void onSuccess(Vector<Profil> result) {
				pt2.setRowData(0, result);
				pt2.setRowCount(result.size(), true);
			}
		});
		pt1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			/**
			 * Wenn man auf Profil klickt, wird ein DialogFenster von der Klasse Profil_Dialogbox und Profil_info_Dialogbox erstellt und angezeigt.
			 */
			public void onSelectionChange(SelectionChangeEvent event) {
				HorizontalPanel hpanel = new HorizontalPanel();
				HorizontalPanel hpanel2 = new HorizontalPanel();
				VerticalPanel vpanel = new VerticalPanel();
				final DialogBox b1 = new DialogBox();
				Profil_Dialogbox profildialogbox = new Profil_Dialogbox(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
				Profil_Info_Dialogbox profilinfo = new Profil_Info_Dialogbox(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
				hpanel.add(profildialogbox);
				hpanel.add(profilinfo);
				hpanel2.add(sperreloeschen);
				hpanel2.add(zusperre);
				hpanel2.add(zurück);
				vpanel.add(hpanel);
				vpanel.add(hpanel2);
				b1.add(vpanel);
				b1.setText("Profil");
				b1.center();
				zusperre.addClickHandler(new ClickHandler() {
					
					
					public void onClick(ClickEvent event) {
						b1.hide();
					}
				});
				zurück.addClickHandler(new ClickHandler() {
					
					
					public void onClick(ClickEvent event) {
					b1.hide(); 
				
			}

		});		
				sperreloeschen.addClickHandler(new ClickHandler() {
					
					/**
					 * Interface clickhandler wird als anonyme klasse erstellt und realisert die on click methode, die auf einen klick (button) wartet und dann ausgeführt wird
					 */
					public void onClick(ClickEvent event) {
						Kontaktsperre k = new Kontaktsperre();
						k.setProfilId_gesperrter(pt1.getSsm_profil_anzeige().getSelectedObject().getId());
						k.setProfilId_sperrender(profil.getId());
						pbverwaltung.delete(k, new AsyncCallback<Void>() {

							
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							
							public void onSuccess(Void result) {
								Window.alert("Profilsperre wurde erfolgreich aufgehoben");
								b1.hide();
								RootPanel.get("Details").clear();
								RootPanel.get("Details").add(new Kontaktsperreseite(profil));
							}
						});
					}
				});
				
				
			}
		});
		/**
		 * wird angezeigt, wenn das Profil nicht angezeigt werden kann bspw. durch blockierung oder löschung des profils
		 */
		pt2.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					
					
					public void onSelectionChange(SelectionChangeEvent event) {
						Window.alert("Sie können dieses Profil nicht anschauen");
					}
				});
		
	}
	
}
