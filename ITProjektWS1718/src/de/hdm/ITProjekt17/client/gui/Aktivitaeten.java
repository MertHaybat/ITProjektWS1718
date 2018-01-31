package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * In dieser Klasse werden die Profil Aktivitäten angezeigt. Hierzu gehört: Besuchte Profile, Besucher auf dem eigenen Profil 
 * @author Mert
 */
public class Aktivitaeten extends VerticalPanel {
	
	private VerticalPanel hpanel = new VerticalPanel();
	private VerticalPanel vpanelbesucher = new VerticalPanel();
	private VerticalPanel vpanelbesuchte = new VerticalPanel();
	
	private HTML htmlbesucher = new HTML("<h2>Besucher</<h2>");
	private HTML htmlbesuchte = new HTML("<h2>Besuchte</<h2>");
	
	private Button kontaktsperren = new Button("Kontakt Sperren");
	private Button kontaktmerken = new Button("Kontakt Merken");
	private Button besuchloeschen = new Button("Besuch Löschen");
	private Button besuchzurueck = new Button("Zurück zur Aktivitätenseite");
	
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	
	public Aktivitaeten(final Profil profil){
		final Profil_Tabelle pt1 = new Profil_Tabelle();
		final Profil_Tabelle pt2 = new Profil_Tabelle();
		vpanelbesuchte.add(htmlbesuchte);
		vpanelbesuchte.add(pt2);
		hpanel.add(vpanelbesuchte);
		vpanelbesucher.add(htmlbesucher);
		vpanelbesucher.add(pt1);
		hpanel.add(vpanelbesucher);
		
		this.add(hpanel);
		pbverwaltung.showBesucherOf(profil, new AsyncCallback<Vector<Profil>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Vector<Profil> result) {
				pt2.setRowData(0, result);
				pt2.setRowCount(result.size(), true);
			}
		});
		pbverwaltung.showBesuchteOf(profil, new AsyncCallback<Vector<Profil>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Vector<Profil> result) {
				pt1.setRowData(0, result);
				pt1.setRowCount(result.size(), true);
			}
		});
		
		pt2.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		
		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
			final DialogBox b1 = new DialogBox();
			Profil_Dialogbox profildialogbox = new Profil_Dialogbox(profil, pt2.getSsm_profil_anzeige().getSelectedObject());
			Profil_Info_Dialogbox profilinfo = new Profil_Info_Dialogbox(profil, pt2.getSsm_profil_anzeige().getSelectedObject());
			profildialogbox.setWidget(8, 0, kontaktmerken);
			profildialogbox.setWidget(8, 1, kontaktsperren);
			profildialogbox.setWidget(8, 2, besuchloeschen);
			profildialogbox.setWidget(8, 3, besuchzurueck);
			b1.add(profildialogbox);
//			b1.add(profilinfo);
			b1.setText("Profil");
			b1.center();
			kontaktmerken.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					pbverwaltung.createMerkzettel(profil, pt2.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Merkzettel>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Merkzettel result) {
							Window.alert("Profil wurde erfolgreich gemerkt");
							b1.hide();
						}
					});
				}
			});
			kontaktsperren.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					pbverwaltung.createKontaktsperre(profil, pt2.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Kontaktsperre>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Kontaktsperre result) {
							Window.alert("Profil wurde erfolgreich gesperrt");
							b1.hide();
						}
					});
				}
			});
			besuchloeschen.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					pbverwaltung.deleteBesuche(profil, pt2.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Void result) {
							Window.alert("Besuch wurde erfolgreich gelöscht");
							b1.hide();
							RootPanel.get("Details").clear();
							RootPanel.get("Details").add(new Aktivitaeten(profil	));
						}
					});
				}
			});
			besuchzurueck.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					b1.hide();
				}
			});
		}
	});
		pt1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				final DialogBox b2 = new DialogBox();
				Profil_Dialogbox profildialogbox2 = new Profil_Dialogbox(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
				Profil_Info_Dialogbox profilinfo2 = new Profil_Info_Dialogbox(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
				profildialogbox2.setWidget(8, 0, kontaktmerken);
				profildialogbox2.setWidget(8, 1, kontaktsperren);
				profildialogbox2.setWidget(8, 3, besuchzurueck);
				b2.add(profildialogbox2);
//				b2.add(profilinfo2);
				b2.setText("Profil");
				b2.center();
				kontaktmerken.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						Window.alert("Profil wurde gemerkt");
						b2.hide();
					}
				});
				kontaktsperren.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						pbverwaltung.createKontaktsperre(profil,  pt1.getSsm_profil_anzeige().getSelectedObject().getId(), new AsyncCallback<Kontaktsperre>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Kontaktsperre result) {
								Window.alert("Profil wurde gesperrt");
								b2.hide();
							}
						});
					}
				});
				besuchzurueck.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						b2.hide();
					}
				});
				
				
			}
		});
	}


}
