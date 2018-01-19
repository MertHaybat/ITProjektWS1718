package de.hdm.ITProjekt17.client.gui;


import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profilseite extends VerticalPanel{

	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	private TextBox tbemail = new TextBox();
	private TextBox tbvorname = new TextBox();
	private TextBox tbnachname = new TextBox();
	private DateBox geburtsdatum = new DateBox();
	private TextBox tbhaarfarbe = new TextBox();
	private TextBox tbreligion = new TextBox();
	private TextBox tbkörpergröße = new TextBox();
	private ListBox lbraucher = new ListBox();
	private ListBox lbgeschlecht = new ListBox();
	
	private ListBox lbinteresse = new ListBox();
	private ListBox lbwohnsituation = new ListBox();	
	private ListBox lbausbildung = new ListBox();
	private ListBox lbsportart = new ListBox();
	private ListBox lbkörperbau = new ListBox();
	
	private Label lb1 = new Label("Vorname: ");
	private Label lb2 = new Label("Nachname: ");
	private Label lb3 = new Label("Geburtsdatum: ");
	private Label lb4 = new Label("Haarfarbe: ");
	private Label lb5 = new Label("Religion: ");
	private Label lb6 = new Label("Körpergröße: ");
	private Label lb7 = new Label("Raucher: ");
	private Label lb8 = new Label("Geschlecht: ");
	DateTimeFormat df = DateTimeFormat.getFormat("DD/MM/YYYY");
	
	private Button ok = new Button("Bestätigen");
	private Button abbrechen = new Button("Abbrechen");
	private Button infoEigenschaftenAnzeigen = new Button ("Weitere Profilinformationen anzeigen");
	
	private FlexTable ft1 = new FlexTable();

	private VerticalPanel vpanel = new VerticalPanel();
	
	
	public Profilseite(){
		Window.alert("Willkommen auf MOFOS. Tragen Sie bitte nachfolgend die Daten zu Ihrer Person ein.");
		
		ft1.setWidget(1, 0, lb1);
		ft1.setWidget(1, 1, tbvorname);
		ft1.setWidget(2, 0, lb2);
		ft1.setWidget(2, 1, tbnachname);
		ft1.setWidget(3, 0, lb8);
		ft1.setWidget(3, 1, lbgeschlecht);
		ft1.setWidget(4, 0, lb3);
		ft1.setWidget(4, 1, geburtsdatum);
		ft1.setWidget(5, 0, lb4);
		ft1.setWidget(5, 1, tbhaarfarbe);
		ft1.setWidget(6, 0, lb5);
		ft1.setWidget(6, 1, tbreligion);
		ft1.setWidget(7, 0, lb6);
		ft1.setWidget(7, 1, tbkörpergröße);
		ft1.setWidget(8, 0, lb7);
		ft1.setWidget(8, 1, lbraucher);
		ft1.setWidget(9, 0, ok);
		ft1.setWidget(9, 1, abbrechen);
		
		vpanel.add(ft1);
		this.add(vpanel);
		
		//ListBox Raucher befüllen.
		
	      lbraucher.addItem("Ja");
	      lbraucher.addItem("Nein");
	      lbraucher.addItem("Gelegentlich");
	      lbraucher.addItem("Partyraucher");
	      lbraucher.addItem("Nur nach dem Sex");	
	  	
	      
		  
		//ListBox Geschlecht befüllen.
			
	      lbgeschlecht.addItem("Männlich");
	      lbgeschlecht.addItem("Weiblich");
	      
		  
		//ListBox Interesse befüllen.
			
	      lbinteresse.addItem("Frauen");
	      lbgeschlecht.addItem("Männer");
	      lbgeschlecht.addItem("Beides");	  
	      
			//ListBox Wohnsituation befüllen.
			
	      lbwohnsituation.addItem("Bei den Eltern");
	      lbwohnsituation.addItem("alleine");
	      lbwohnsituation.addItem("In einer WG");
	      lbwohnsituation.addItem("Im Wohnheim");

			//ListBox Ausbildung befüllen.
			
	      lbausbildung.addItem("Kein Abschluss");
	      lbausbildung.addItem("Schüler");
	      lbausbildung.addItem("Student");
	      lbausbildung.addItem("Absolvent");

			//ListBox Sportart befüllen.
			
	      lbsportart.addItem("Fussball");
	      lbsportart.addItem("Handball");
	      lbsportart.addItem("Tanzsport");
	      lbsportart.addItem("Wassersport");
	      lbsportart.addItem("Motorsport");
	      lbsportart.addItem("Kampfsport");
	      lbsportart.addItem("Denksport");
	      lbsportart.addItem("Leichtathletik");
	      lbsportart.addItem("Kraftsport");
	      lbsportart.addItem("Reitsport");
		
		// Create a date picker
		final DatePicker datepicker_geburtsdatum = new DatePicker();
		final Label text = new Label();

		
		 // Set the value in the text box when the user selects a date
			datepicker_geburtsdatum.addValueChangeHandler(new ValueChangeHandler<Date>(){

				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
//					Date date = event.getValue();
//		            String dateString = df.format(date);
////		                    DateTimeFormat.getFormat("MM/dd/yyyy").format(date);
//		                    text.setText(dateString);
				}
			});
			
		    datepicker_geburtsdatum.setValue(new Date(), true);
		   
		    
		    ok.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					
					pbverwaltung.createProfil(tbemail.getValue(), tbvorname.getValue(), tbnachname.getValue(), geburtsdatum.getValue(), 
							Integer.parseInt(tbkörpergröße.getValue()),
							tbreligion.getValue(), tbhaarfarbe.getValue(), lbraucher.getSelectedValue(), lbgeschlecht.getSelectedValue(), new AsyncCallback<Profil>(){

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
							Window.alert("Fehlerhafte Eingabe");		
								}

								@Override
								public void onSuccess(Profil result) {
									RootPanel.get("Details").clear();
									RootPanel.get("Details").add(new Profilseite(result));
								}

							
						
					});
					
				}
		    	
		    });
		    

		
		RootPanel.get("Details").clear();
		RootPanel.get("Details").add(this);
	}
	
	public Profilseite(final Profil profil){
		ft1.setWidget(1, 0, lb1);
		ft1.setWidget(1, 1, tbvorname);
		ft1.setWidget(2, 0, lb2);
		ft1.setWidget(2, 1, tbnachname);
		ft1.setWidget(3, 0, lb8);
		ft1.setWidget(3, 1, lbgeschlecht);
		ft1.setWidget(4, 0, lb3);
		ft1.setWidget(4, 1, geburtsdatum);
		ft1.setWidget(5, 0, lb4);
		ft1.setWidget(5, 1, tbhaarfarbe);
		ft1.setWidget(6, 0, lb5);
		ft1.setWidget(6, 1, tbreligion);
		ft1.setWidget(7, 0, lb6);
		ft1.setWidget(7, 1, tbkörpergröße);
		ft1.setWidget(8, 0, lb7);
		ft1.setWidget(8, 1, lbraucher);
		ft1.setWidget(9, 0, ok);
		ft1.setWidget(9, 1, abbrechen);
		ft1.setWidget(9, 2, infoEigenschaftenAnzeigen);
		
		//ListBox Raucher befüllen.
		
	      lbraucher.addItem("Ja");
	      lbraucher.addItem("Nein");
	      lbraucher.addItem("Gelegentlich");
	      lbraucher.addItem("Partyraucher");
	      lbraucher.addItem("Nur nach dem Sex");		
		  
		//ListBox Geschlecht befüllen.
			
	      lbgeschlecht.addItem("Männlich");
	      lbgeschlecht.addItem("Weiblich");
	      
			//ListBox Interesse befüllen.
			
	      lbinteresse.addItem("Frauen");
	      lbgeschlecht.addItem("Männer");
	      lbgeschlecht.addItem("Beides");	  
	      
			//ListBox Wohnsituation befüllen.
			
	      lbwohnsituation.addItem("Bei den Eltern");
	      lbwohnsituation.addItem("alleine");
	      lbwohnsituation.addItem("In einer WG");
	      lbwohnsituation.addItem("Im Wohnheim");

			//ListBox Ausbildung befüllen.
			
	      lbausbildung.addItem("Kein Abschluss");
	      lbausbildung.addItem("Schüler");
	      lbausbildung.addItem("Student");
	      lbausbildung.addItem("Absolvent");

			//ListBox Sportart befüllen.
			
	      lbsportart.addItem("Fussball");
	      lbsportart.addItem("Handball");
	      lbsportart.addItem("Tanzsport");
	      lbsportart.addItem("Wassersport");
	      lbsportart.addItem("Motorsport");
	      lbsportart.addItem("Kampfsport");
	      lbsportart.addItem("Denksport");
	      lbsportart.addItem("Leichtathletik");
	      lbsportart.addItem("Kraftsport");
	      lbsportart.addItem("Reitsport");
		
		tbemail.setValue(profil.getEmail());
		tbvorname.setValue(profil.getVorname());
		tbnachname.setValue(profil.getNachname());
		geburtsdatum.setValue(profil.getGeburtsdatum());
		tbhaarfarbe.setValue(Profil.Haarfarbe.values());
		tbreligion.setValue(profil.getReligion());
		tbkörpergröße.setValue(String.valueOf(profil.getKoerpergroesse()));
		lbraucher.setValue(0, profil.getRaucher());
//		lbraucher.setValue(spacing, profil.getRaucher());
//		lbgeschlecht.setValue(profil.getGeschlecht());
	
	    infoEigenschaftenAnzeigen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Infoseite(profil));
			}
		});
	    
		vpanel.add(ft1);
		this.add(vpanel);
	    
	}
}
