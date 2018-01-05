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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Merkzettelseite extends VerticalPanel{
	
	private HorizontalPanel hpanel = new HorizontalPanel();
	private VerticalPanel vpaneleigener_merkzettel = new VerticalPanel();
	private VerticalPanel vpanelandere_merkzettel = new VerticalPanel();
	
	private CellTable<Profil> ct_eigener_merkzettelprofile = new CellTable<Profil>();
	private CellTable<Profil> ct_andere_merkzettelprofile = new CellTable<Profil>();
	
	final NoSelectionModel<Profil> ssm_eigener_merkzettelprofile = new NoSelectionModel<Profil>();
	final NoSelectionModel<Profil> ssm_andere_merkzettelprofile = new NoSelectionModel<Profil>();
		
	private HTML htmleigener_merkzettel = new HTML("<h2>Eigener Merkzettel:</<h2>");
	private HTML htmlandere_merkzettel = new HTML("<h2>Sie sind beliebt bei:</<h2>");
	
	DateTimeFormat df = DateTimeFormat.getFormat("DD/MM/YYYY");
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	public Merkzettelseite(final Profil profil){
		ct_eigener_merkzettelprofile.setWidth("100%");
		ct_andere_merkzettelprofile.setWidth("100%");
		
		vpaneleigener_merkzettel.add(htmleigener_merkzettel);
		vpaneleigener_merkzettel.add(ct_eigener_merkzettelprofile);
		vpanelandere_merkzettel.add(htmlandere_merkzettel);
		vpanelandere_merkzettel.add(ct_andere_merkzettelprofile);
		
		hpanel.add(vpaneleigener_merkzettel);
		hpanel.add(vpanelandere_merkzettel);
		
		this.add(hpanel);
		
		ct_eigener_merkzettelprofile.setSelectionModel(ssm_eigener_merkzettelprofile);
		ct_andere_merkzettelprofile.setSelectionModel(ssm_andere_merkzettelprofile);	

		

		 Column<Profil, String> eigener_merkzettelvorname = 
				    new Column<Profil, String>(new ClickableTextCell())  {
				    	@Override
						public String getValue(Profil object) {
							return object.getVorname();
						}
						    
		 };
		 Column<Profil, String> eigener_merkzettelnachname = 
				    new Column<Profil, String>(new ClickableTextCell())  {
				    	@Override
						public String getValue(Profil object) {
							return object.getNachname();
						}
						    
		 };
		 Column<Profil, String> eigener_merkzettelgeburtsdatum = 
				    new Column<Profil, String>(new ClickableTextCell())  {
				    	@Override
						public String getValue(Profil object) {
							return df.format(object.getGeburtsdatum());
						}
						    
		 };
		 
		ct_eigener_merkzettelprofile.addColumn(eigener_merkzettelvorname, "Vorname");
		ct_eigener_merkzettelprofile.addColumn(eigener_merkzettelnachname, "Nachname");
		ct_eigener_merkzettelprofile.addColumn(eigener_merkzettelgeburtsdatum, "Geburtsdatum");
		
		 Column<Profil, String> andere_merkzettelvorname = 
				    new Column<Profil, String>(new ClickableTextCell())  {
				    	@Override
						public String getValue(Profil object) {
							return object.getVorname();
						}
						    
		 };
		 Column<Profil, String> andere_merkzettelnachname = 
				    new Column<Profil, String>(new ClickableTextCell())  {
				    	@Override
						public String getValue(Profil object) {
							return object.getNachname();
						}
						    
		 };
		 Column<Profil, String> andere_merkzettelgeburtsdatum = 
				    new Column<Profil, String>(new ClickableTextCell())  {
				    	@Override
						public String getValue(Profil object) {
							return df.format(object.getGeburtsdatum());
						}
						    
		 };
		 
		ct_andere_merkzettelprofile.addColumn(andere_merkzettelvorname, "Vorname");
		ct_andere_merkzettelprofile.addColumn(andere_merkzettelnachname, "Nachname");
		ct_andere_merkzettelprofile.addColumn(andere_merkzettelgeburtsdatum, "Geburtsdatum");
	
		ssm_eigener_merkzettelprofile.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				DialogBoxMerkzettelProfil dialogboxmerkzettelprofil = new DialogBoxMerkzettelProfil(profil, ssm_eigener_merkzettelprofile.getLastSelectedObject());
				dialogboxmerkzettelprofil.center();
			}
		});
		ssm_andere_merkzettelprofile.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
				
				@Override
				public void onSelectionChange(SelectionChangeEvent event) {
					DialogBoxMerkzettelProfil dialogboxmerkzettelprofil = new DialogBoxMerkzettelProfil(profil, ssm_andere_merkzettelprofile.getLastSelectedObject());
					dialogboxmerkzettelprofil.center();
				}
			});
		
	/**
	 * Hier kommt ein AsyncCallback mit "GetProfilByMerkzettel"
	 */
			
	}

private class DialogBoxMerkzettelProfil extends DialogBox{
		
		VerticalPanel vpanel = new VerticalPanel();
		private TextBox tbvorname = new TextBox();
		private TextBox tbnachname = new TextBox();
		private DateBox geburtsdatum = new DateBox();
		private TextBox tbhaarfarbe = new TextBox();
		private TextBox tbreligion = new TextBox();
		private TextBox tbkörpergröße = new TextBox();
		private TextBox tbraucher = new TextBox();
		private TextBox tbgeschlecht = new TextBox();
		
		private Label lb1 = new Label("Vorname: ");
		private Label lb2 = new Label("Nachname: ");
		private Label lb3 = new Label("Geburtsdatum: ");
		private Label lb4 = new Label("Haarfarbe: ");
		private Label lb5 = new Label("Religion: ");
		private Label lb6 = new Label("Körpergröße: ");
		private Label lb7 = new Label("Raucher: ");
		private Label lb8 = new Label("Geschlecht: ");

		private Button sperren = new Button("Besuch Sperren");
		private Button loeschen = new Button("Besuch Löschen");
		private Button merkzettel = new Button("Zu Merkzettel hinzufügen");
		private Button abbrechen = new Button("Abbrechen");
		private Button entsperren = new Button("Besuch Entsperren");
		
		private FlexTable ft1 = new FlexTable();
		
		public DialogBoxMerkzettelProfil(final Profil profil_eigenes, final Profil profil_besucher){
			ft1.setWidget(0, 0, lb1);
			ft1.setWidget(0, 1, tbvorname);
			ft1.setWidget(1, 0, lb2);
			ft1.setWidget(1, 1, tbnachname);
			ft1.setWidget(2, 0, lb3);
			ft1.setWidget(2, 1, geburtsdatum);
			ft1.setWidget(3, 0, lb4);
			ft1.setWidget(3, 1, tbhaarfarbe);
			ft1.setWidget(4, 0, lb5);
			ft1.setWidget(4, 1, tbreligion);
			ft1.setWidget(5, 0, lb6);
			ft1.setWidget(5, 1, tbkörpergröße);
			ft1.setWidget(6, 0, lb7);
			ft1.setWidget(6, 1, tbraucher);
			ft1.setWidget(7, 0, lb8);
			ft1.setWidget(7, 1, tbgeschlecht);
			ft1.setWidget(8, 0, merkzettel);
			ft1.setWidget(8, 1, abbrechen);
			ft1.setWidget(8, 2, loeschen);			
			ft1.setWidget(8, 3, sperren);
			
			vpanel.add(ft1);
			this.add(vpanel);
				
			sperren.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
//					Merkzettel mz = new Merkzettel();
//					mz.setProfilId_merkender(profil_eigenes.getId());
//					mz.setProfilId_gemerkter(profil_besucher.getId());
//					pbverwaltung.deleteMerkzettel(mz, new AsyncCallback<Void>(){
//
//						@Override
//						public void onFailure(Throwable caught) {
//							
//						}
//
//						@Override
//						public void onSuccess(Void result) {
//						
//						}
//						
//					});
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
				}
			});
			
			loeschen.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					Merkzettel mz = new Merkzettel();
					mz.setProfilId_merkender(profil_eigenes.getId());
					mz.setProfilId_gemerkter(profil_besucher.getId());
//					pbverwaltung.deleteMerkzettel(mz, new AsyncCallback<Void>(){
//
//						@Override
//						public void onFailure(Throwable caught) {
//							
//						}
//
//						@Override
//						public void onSuccess(Void result) {
//						
//						}
//						
//					});
				}
				
			});
			
//			pbverwaltung.getProfilById(profil_besucher.getId(), new AsyncCallback<Profil>(){
//
//				@Override
//				public void onFailure(Throwable caught) {
//					Window.alert("Profil wurde nicht gefunden");
//				}
//
//				@Override
//				public void onSuccess(Profil result) {
//					tbvorname.setValue(result.getVorname());
//					tbnachname.setValue(result.getNachname());
//					geburtsdatum.setValue(result.getGeburtsdatum());
//					tbhaarfarbe.setValue(result.getHaarfarbe());
//					tbreligion.setValue(result.getReligion());
//					tbkörpergröße.setValue(String.valueOf(result.getKoerpergroesse()));
//					tbraucher.setValue(String.valueOf(result.getRaucher()));
//					tbgeschlecht.setValue(String.valueOf(result.getGeschlecht()));
//					
//				}
//				
//			});
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
