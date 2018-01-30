package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * DialogBox welches geöffnet wird, wenn man auf ein Besucher klickt.
 * @author Mert
 *
 */

public class DialogBoxBesuchProfil extends DialogBox{
//	
////	VerticalPanel vpanel = new VerticalPanel();
////	private TextBox tbvorname = new TextBox();
////	private TextBox tbnachname = new TextBox();
////	private DateBox geburtsdatum = new DateBox();
////	private TextBox tbhaarfarbe = new TextBox();
////	private TextBox tbreligion = new TextBox();
////	private TextBox tbkörpergröße = new TextBox();
////	private TextBox tbraucher = new TextBox();
////	private TextBox tbgeschlecht = new TextBox();
////	
////	private Label lb1 = new Label("Vorname: ");
////	private Label lb2 = new Label("Nachname: ");
////	private Label lb3 = new Label("Geburtsdatum: ");
////	private Label lb4 = new Label("Haarfarbe: ");
////	private Label lb5 = new Label("Religion: ");
////	private Label lb6 = new Label("Körpergröße: ");
////	private Label lb7 = new Label("Raucher: ");
////	private Label lb8 = new Label("Geschlecht: ");
//
//	private Button sperren = new Button("Besuch Sperren");
//	private Button loeschen = new Button("Besuch Löschen");
//	private Button merkzettel = new Button("Zu Merkzettel hinzufügen");
//	private Button abbrechen = new Button("Abbrechen");
//	private Button entsperren = new Button("Besuch Entsperren");
//	
////	private FlexTable ft1 = new FlexTable();
//	
//	public DialogBoxBesuchProfil(final Profil profil_eigenes, final Profil profil_besucher){
//
//		final Profil_Dialogbox pdb1 = new Profil_Dialogbox(profil_eigenes, profil_besucher);
//		pdb1.setWidget(8, 0, merkzettel);
//		pdb1.setWidget(8, 1, abbrechen);
//		pdb1.setWidget(8, 2, loeschen);			
//		pdb1.setWidget(8, 3, sperren);
//		pdb1.setWidget(8, 3, entsperren);
//		this.add(pdb1);
//
//		
//		loeschen.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//				/**
//				 * Hier kommt ein Asynccallback mit Delete Besuch!!!
//				 */
//			}
//			
//		});
//		
//		pbverwaltung.getProfilById(profil_besucher.getId(), new AsyncCallback<Profil>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Profil wurde nicht gefunden");
//			}
//
//			@Override
//			public void onSuccess(Profil result) {
////		pdb1.getTbvorname().setValue(result.getVorname());
////		pdb1.getTbnachname().setValue(result.getNachname());
////		pdb1.getGeburtsdatum().setValue(result.getGeburtsdatum());
////		pdb1.getTbhaarfarbe().setValue(result.getHaarfarbe());
////		pdb1.getTbreligion().setValue(result.getReligion());
////		pdb1.getTbkörpergröße().setValue(String.valueOf(result.getKoerpergroesse()));
////		pdb1.getTbraucher().setValue(String.valueOf(result.getRaucher()));
////		pdb1.getTbgeschlecht().setValue(String.valueOf(result.getGeschlecht()));
//		
//				
//			}
//			
//		});
//
//		abbrechen.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//				hide();
//			}
//			
//		});
//}

}
