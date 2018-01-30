package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
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
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Merkzettelseite extends VerticalPanel{
	
	private VerticalPanel vpaneleigener_merkzettel = new VerticalPanel();
	private VerticalPanel vpanelandere_merkzettel = new VerticalPanel();
	private VerticalPanel hpanel = new VerticalPanel();

	private HTML htmleigener_merkzettel = new HTML("<h2>Eigener Merkzettel:</<h2>");
	private HTML htmlandere_merkzettel = new HTML("<h2>Sie sind beliebt bei:</<h2>");

	private Button zumerkzettel = new Button("Zu Merkzettel");
	private Button merkzettelloeschen = new Button("Merkzettel Löschen");
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	public Merkzettelseite (final Profil profil){
		
		final Profil_Tabelle pt1 = new Profil_Tabelle();
		final Profil_Tabelle pt2 = new Profil_Tabelle();
		
		vpaneleigener_merkzettel.add(htmleigener_merkzettel);
		vpaneleigener_merkzettel.add(pt1);
		hpanel.add(vpaneleigener_merkzettel);
		vpanelandere_merkzettel.add(htmlandere_merkzettel);
		vpanelandere_merkzettel.add(pt2);
		hpanel.add(vpanelandere_merkzettel);
		this.add(hpanel);
		pbverwaltung.showMerkendeOf(profil, new AsyncCallback<Vector<Profil>>(){

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
		pbverwaltung.showMerklisteOf(profil, new AsyncCallback<Vector<Profil>>() {

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
		
		pt1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		
		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
			final DialogBox b1 = new DialogBox();
			Profil_Dialogbox profildialogbox = new Profil_Dialogbox(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
			profildialogbox.setWidget(8, 0, merkzettelloeschen);
			profildialogbox.setWidget(8, 2, zumerkzettel);
			b1.add(profildialogbox);
			b1.setText("Profil");
			b1.center();
			merkzettelloeschen.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					Merkzettel m1 = new Merkzettel();
					m1.setProfilId_gemerkter(pt1.getSsm_profil_anzeige().getSelectedObject().getId());
					m1.setProfilId_merkender(profil.getId());
					pbverwaltung.delete(m1, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Void result) {
							Window.alert("Profil aus Merkzettel gelöscht");
							b1.hide();
							RootPanel.get("Details").clear();
							RootPanel.get("Details").add(new Merkzettelseite(profil));
						}
					});
				}
			});
			zumerkzettel.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
				b1.hide();
				}
			});
		}
	});
		pt2.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
				
				@Override
				public void onSelectionChange(SelectionChangeEvent event) {
					final DialogBox b1 = new DialogBox();
					Profil_Dialogbox profildialogbox = new Profil_Dialogbox(profil, pt2.getSsm_profil_anzeige().getSelectedObject());
					profildialogbox.setWidget(8, 2, zumerkzettel);
					b1.add(profildialogbox);
					b1.setText("Profil");
					b1.center();
					zumerkzettel.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
						b1.hide();
						}
					});
				}
			});
		
	}
	
	

}
