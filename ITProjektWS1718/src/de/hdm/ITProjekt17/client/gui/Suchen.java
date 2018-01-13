package de.hdm.ITProjekt17.client.gui;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Suchen extends VerticalPanel {
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();

	/*
	 *	Deklarieren und Instanziieren der Widgets 
	 */
	
	private TextBox tbemail = new TextBox();
	private TextBox tbvorname = new TextBox();
	private TextBox tbnachname = new TextBox();
	private DateBox geburtsdatum = new DateBox();
	private TextBox tbhaarfarbe = new TextBox();
	private TextBox tbreligion = new TextBox();
	private TextBox tbkörpergröße = new TextBox();
	private TextBox tbminalter = new TextBox();
	private TextBox tbmaxalter = new TextBox();

	private Label lb10 = new Label("Email: ");
	private Label lb1 = new Label("Vorname: ");
	private Label lb2 = new Label("Nachname: ");
	private Label lb3 = new Label("Geburtsdatum: ");
	private Label lb4 = new Label("Haarfarbe: ");
	private Label lb5 = new Label("Religion: ");
	private Label lb6 = new Label("Körpergröße: ");
	private Label lb7 = new Label("Raucher: ");
	private Label lb8 = new Label("Geschlecht: ");
	private Label lb9 = new Label("Alter von bis:");
	
	DateTimeFormat df = DateTimeFormat.getFormat("DD/MM/YYYY"); 

	private ListBox lbraucher = new ListBox();
	private ListBox lbgeschlecht = new ListBox();


	private Button suchen = new Button("Suchen");
	private Button suchprofilSpeichern = new Button("Suchprofil speichern");
	private Button suchprofilLoeschen = new Button("Suchprofil löschen");
	
	private FlexTable ft1 = new FlexTable();
	
	private VerticalPanel vpanel = new VerticalPanel();
	
	

	
	public Suchen(final Profil profil){

		tbemail.setValue(profil.getEmail());
		tbvorname.setValue(profil.getVorname());
		tbnachname.setValue(profil.getNachname());
		geburtsdatum.setValue(profil.getGeburtsdatum());
		tbhaarfarbe.setValue(profil.getHaarfarbe());
		tbreligion.setValue(profil.getReligion());
		tbkörpergröße.setValue(String.valueOf(profil.getKoerpergroesse()));
//		lbraucher.setValue(profil.getRaucher());
//		lbgeschlecht.setValue(profil.getGeschlecht());

	
	    ft1.setWidget(0, 0, lb10);  
	    ft1.setWidget(0, 1, tbemail);
		ft1.setWidget(1, 0, lb1);
		ft1.setWidget(1, 1, tbvorname);
		ft1.setWidget(2, 0, lb2);
		ft1.setWidget(2, 1, tbnachname);
		ft1.setWidget(3, 0, lb8);
		ft1.setWidget(3, 1, lbgeschlecht);
		ft1.setWidget(4, 0, lb9);
		ft1.setWidget(4, 1, tbminalter);
		ft1.setWidget(4, 2, tbmaxalter);
		ft1.setWidget(5, 0, lb3);
		ft1.setWidget(5, 1, geburtsdatum);
		ft1.setWidget(6, 0, lb4);
		ft1.setWidget(6, 1, tbhaarfarbe);
		ft1.setWidget(7, 0, lb5);
		ft1.setWidget(7, 1, tbreligion);
		ft1.setWidget(8, 0, lb6);
		ft1.setWidget(8, 1, tbkörpergröße);
		ft1.setWidget(9, 0, lb7);
		ft1.setWidget(9, 1, lbraucher);
		ft1.setWidget(10, 1, suchen);
		ft1.setWidget(10, 2, suchprofilSpeichern);
		ft1.setWidget(10, 3, suchprofilLoeschen);

		//ListBox Raucher befüllen.
		
	      lbraucher.addItem("Ja");
	      lbraucher.addItem("Nein");
	      lbraucher.addItem("Gelegentlich");
	      lbraucher.addItem("Partyraucher");
	      lbraucher.addItem("Nur nach dem Sex");		
	      
		//ListBox Geschlecht befüllen.
			
	      lbgeschlecht.addItem("Männlich");
	      lbgeschlecht.addItem("Weiblich");
			

		vpanel.add(ft1);
		this.add(vpanel);
		
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
		    
		    
		    suchen.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) { 
			}
		    	
		    });
		    
		    suchprofilSpeichern.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) { 
			}
		    	
		    });
		    
		    suchprofilLoeschen.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) { 
			}
		    	
		    });
		    

		}
	


}

	
