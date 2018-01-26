package de.hdm.ITProjekt17.client.gui;

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
	
	private HorizontalPanel hpanel = new HorizontalPanel();
	private VerticalPanel vpanelbesucher = new VerticalPanel();
	private VerticalPanel vpanelbesuchte = new VerticalPanel();
//	
//	private CellTable<Profil> ct_besucherprofile = new CellTable<Profil>();
//	private CellTable<Profil> ct_besuchteprofile = new CellTable<Profil>();
//	
//	final NoSelectionModel<Profil> ssm_besucherprofile = new NoSelectionModel<Profil>();
//	final NoSelectionModel<Profil> ssm_besuchteprofile = new NoSelectionModel<Profil>();
//		
	private HTML htmlbesucher = new HTML("<h2>Besucher</<h2>");
	private HTML htmlbesuchte = new HTML("<h2>Besuchte</<h2>");
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	DateTimeFormat df = DateTimeFormat.getFormat("DD/MM/YYYY");
	
	public Aktivitaeten(final Profil profil){
		final Profil_Tabelle pt1 = new Profil_Tabelle();
		final Profil_Tabelle pt2 = new Profil_Tabelle();
		
		vpanelbesucher.add(htmlbesucher);
		vpanelbesucher.add(pt1);
		hpanel.add(vpanelbesucher);
		vpanelbesuchte.add(htmlbesuchte);
		vpanelbesuchte.add(pt2);
		hpanel.add(vpanelbesuchte);
		this.add(hpanel);
		pt1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		
		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
			DialogBoxBesuchProfil dialogboxbesuchprofil = new DialogBoxBesuchProfil(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
			dialogboxbesuchprofil.center();
		}
	});
		pt2.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				DialogBoxBesuchProfil dialogboxbesuchprofil = new DialogBoxBesuchProfil(profil,  pt2.getSsm_profil_anzeige().getSelectedObject());
				dialogboxbesuchprofil.center();
			}
		});
	}
	
	/**
	 * Kontruktor für die Aktivitäten
	 * @param profil
//	 */
//	public Aktivitaeten(final Profil profil) {
//	
//	RootPanel.get("Details").setWidth("100%");
//	ct_besucherprofile.setWidth("100%", true);	
//	ct_besuchteprofile.setWidth("100%", true);
//	
//	vpanelbesucher.add(htmlbesucher);
//	vpanelbesucher.add(ct_besucherprofile);
//	vpanelbesuchte.add(htmlbesuchte);
//	vpanelbesuchte.add(ct_besuchteprofile);
//	
//	hpanel.add(vpanelbesucher);
//	hpanel.add(vpanelbesuchte);
//	
//	this.add(hpanel);
//	
//	ct_besucherprofile.setSelectionModel(ssm_besucherprofile);
//	ct_besuchteprofile.setSelectionModel(ssm_besuchteprofile);	
//
//	 Column<Profil, String> besucherprofilvorname = 
//			    new Column<Profil, String>(new ClickableTextCell())  {
//			    	@Override
//					public String getValue(Profil object) {
//						return object.getVorname();
//					}
//					    
//	 };
//	 Column<Profil, String> besucherprofilnachname = 
//			    new Column<Profil, String>(new ClickableTextCell())  {
//			    	@Override
//					public String getValue(Profil object) {
//						return object.getNachname();
//					}
//					    
//	 };
//	 Column<Profil, String> besucherprofilgeburtsdatum = 
//			    new Column<Profil, String>(new ClickableTextCell())  {
//			    	@Override
//					public String getValue(Profil object) {
//						return df.format(object.getGeburtsdatum());
//					}
//					    
//	 };
//	 
//	ct_besucherprofile.addColumn(besucherprofilvorname, "Vorname");
//	ct_besucherprofile.addColumn(besucherprofilnachname, "Nachname");
//	ct_besucherprofile.addColumn(besucherprofilgeburtsdatum, "Geburtsdatum");
//	
//	 Column<Profil, String> besuchteprofilvorname = 
//			    new Column<Profil, String>(new ClickableTextCell())  {
//			    	@Override
//					public String getValue(Profil object) {
//						return object.getVorname();
//					}
//					    
//	 };
//	 Column<Profil, String> besuchteprofilnachname = 
//			    new Column<Profil, String>(new ClickableTextCell())  {
//			    	@Override
//					public String getValue(Profil object) {
//						return object.getNachname();
//					}
//					    
//	 };
//	 Column<Profil, String> besuchteprofilgeburtsdatum = 
//			    new Column<Profil, String>(new ClickableTextCell())  {
//			    	@Override
//					public String getValue(Profil object) {
//						return df.format(object.getGeburtsdatum());
//					}
//					    
//	 };
//	 
//	ct_besuchteprofile.addColumn(besuchteprofilvorname, "Vorname");
//	ct_besuchteprofile.addColumn(besuchteprofilnachname, "Nachname");
//	ct_besuchteprofile.addColumn(besuchteprofilgeburtsdatum, "Geburtsdatum");
//	
//	ssm_besucherprofile.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//		
//		@Override
//		public void onSelectionChange(SelectionChangeEvent event) {
//			DialogBoxBesuchProfil dialogboxbesuchprofil = new DialogBoxBesuchProfil(profil, ssm_besucherprofile.getLastSelectedObject());
//			dialogboxbesuchprofil.center();
//		}
//	});
//	ssm_besuchteprofile.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//			
//			@Override
//			public void onSelectionChange(SelectionChangeEvent event) {
//				DialogBoxBesuchProfil dialogboxbesuchprofil = new DialogBoxBesuchProfil(profil, ssm_besuchteprofile.getLastSelectedObject());
//				dialogboxbesuchprofil.center();
//			}
//		});
//	
//	/**
//	 * HIER MUSS EIN ASYNCCALLBACK NOCH MIT BESUCH!!! WELCHES DIE DATEN DANN IN DIE TABELLE LÄDT!!!
//	 */
//	
//	
//	}
//	
	/**
	 * DialogBox welches geöffnet wird, wenn man auf ein Besucher klickt.
	 * @author Mert
	 *
	 */
	
	private class DialogBoxBesuchProfil extends DialogBox{
		
//		VerticalPanel vpanel = new VerticalPanel();
//		private TextBox tbvorname = new TextBox();
//		private TextBox tbnachname = new TextBox();
//		private DateBox geburtsdatum = new DateBox();
//		private TextBox tbhaarfarbe = new TextBox();
//		private TextBox tbreligion = new TextBox();
//		private TextBox tbkörpergröße = new TextBox();
//		private TextBox tbraucher = new TextBox();
//		private TextBox tbgeschlecht = new TextBox();
//		
//		private Label lb1 = new Label("Vorname: ");
//		private Label lb2 = new Label("Nachname: ");
//		private Label lb3 = new Label("Geburtsdatum: ");
//		private Label lb4 = new Label("Haarfarbe: ");
//		private Label lb5 = new Label("Religion: ");
//		private Label lb6 = new Label("Körpergröße: ");
//		private Label lb7 = new Label("Raucher: ");
//		private Label lb8 = new Label("Geschlecht: ");

		private Button sperren = new Button("Besuch Sperren");
		private Button loeschen = new Button("Besuch Löschen");
		private Button merkzettel = new Button("Zu Merkzettel hinzufügen");
		private Button abbrechen = new Button("Abbrechen");
		private Button entsperren = new Button("Besuch Entsperren");
		
//		private FlexTable ft1 = new FlexTable();
		
		public DialogBoxBesuchProfil(final Profil profil_eigenes, final Profil profil_besucher){
//			ft1.setWidget(0, 0, lb1);
//			ft1.setWidget(0, 1, tbvorname);
//			ft1.setWidget(1, 0, lb2);
//			ft1.setWidget(1, 1, tbnachname);
//			ft1.setWidget(2, 0, lb3);
//			ft1.setWidget(2, 1, geburtsdatum);
//			ft1.setWidget(3, 0, lb4);
//			ft1.setWidget(3, 1, tbhaarfarbe);
//			ft1.setWidget(4, 0, lb5);
//			ft1.setWidget(4, 1, tbreligion);
//			ft1.setWidget(5, 0, lb6);
//			ft1.setWidget(5, 1, tbkörpergröße);
//			ft1.setWidget(6, 0, lb7);
//			ft1.setWidget(6, 1, tbraucher);
//			ft1.setWidget(7, 0, lb8);
//			ft1.setWidget(7, 1, tbgeschlecht);
			final Profil_Dialogbox pdb1 = new Profil_Dialogbox(profil_eigenes, profil_besucher);
			pdb1.setWidget(8, 0, merkzettel);
			pdb1.setWidget(8, 1, abbrechen);
			pdb1.setWidget(8, 2, loeschen);			
			pdb1.setWidget(8, 3, sperren);
			pdb1.setWidget(8, 3, entsperren);
			this.add(pdb1);
//			vpanel.add(ft1);
//			this.add(vpanel);
			
//			entsperren.addClickHandler(new ClickHandler(){
//
//				@Override
//				public void onClick(ClickEvent event) {
//					Kontaktsperre ks = new Kontaktsperre();
//					ks.setProfilId_sperrender(profil_eigenes.getId());
//					ks.setProfilId_gesperrter(profil_besucher.getId());
//					pbverwaltung.deleteKontaktsperre(ks, new AsyncCallback<Void>(){
//
//						@Override
//						public void onFailure(Throwable caught) {
//							
//						}
//
//						@Override
//						public void onSuccess(Void result) {
//							Window.alert("Kontakt wurde entsperrt");
//						}
//						
//					});
//				}
//			});
			
//			sperren.addClickHandler(new ClickHandler(){
//
//				@Override
//				public void onClick(ClickEvent event) {
//					Kontaktsperre ks = new Kontaktsperre();
//					ks.setProfilId_sperrender(profil_eigenes.getId());
//					ks.setProfilId_gesperrter(profil_besucher.getId());
//					pbverwaltung.createKontaktsperre(ks, new AsyncCallback<Kontaktsperre>(){
//
//						@Override
//						public void onFailure(Throwable caught) {							
//						}
//
//						@Override
//						public void onSuccess(Kontaktsperre result) {
//							Window.alert("Sie haben die Person erfolgreich gesperrt");
//						}
//						
//					});
//				}
//			});
			
			loeschen.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					/**
					 * Hier kommt ein Asynccallback mit Delete Besuch!!!
					 */
				}
				
			});
			
			pbverwaltung.getProfilById(profil_besucher.getId(), new AsyncCallback<Profil>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Profil wurde nicht gefunden");
				}

				@Override
				public void onSuccess(Profil result) {
			pdb1.getTbvorname().setValue(result.getVorname());
			pdb1.getTbnachname().setValue(result.getNachname());
			pdb1.getGeburtsdatum().setValue(result.getGeburtsdatum());
			pdb1.getTbhaarfarbe().setValue(result.getHaarfarbe());
			pdb1.getTbreligion().setValue(result.getReligion());
			pdb1.getTbkörpergröße().setValue(String.valueOf(result.getKoerpergroesse()));
			pdb1.getTbraucher().setValue(String.valueOf(result.getRaucher()));
			pdb1.getTbgeschlecht().setValue(String.valueOf(result.getGeschlecht()));
			
					
				}
				
			});
//			merkzettel.addClickHandler(new ClickHandler(){
//
//				@Override
//				public void onClick(ClickEvent event) {
//				pbverwaltung.createMerkzettel(profil_besucher.getId(), profil_eigenes.getId(), new AsyncCallback<Merkzettel>(){
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onSuccess(Merkzettel result) {
//						hide();
//						Window.alert("Profil wurde ihrem Merkzettel hinzugefügt");
//					}
//					
//				});
//				}
//				
//			});
			abbrechen.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					hide();
				}
				
			});
	}
	
}
}
