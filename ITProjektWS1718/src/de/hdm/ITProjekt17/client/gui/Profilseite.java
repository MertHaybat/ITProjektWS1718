package de.hdm.ITProjekt17.client.gui;


import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profilseite extends VerticalPanel{
	private TextBox tb1 = new TextBox();
	private TextBox tb2 = new TextBox();
	private DateBox geburtsdatum = new DateBox();
	private TextBox tb4 = new TextBox();
	private TextBox tb5 = new TextBox();
	private TextBox tb6 = new TextBox();
	private TextBox tb7 = new TextBox();
	private TextBox tb8 = new TextBox();
	private TextBox tb9 = new TextBox();
	
	private Button ok = new Button("Ok");
	private Button abbrechen = new Button("Abbrechen");


	
	public Profilseite(){
		Window.alert("Willkommen auf MOFOS. Tragen Sie bitte nachfolgend die Daten zu Ihrer Person ein");
		
	}
	
	public Profilseite(Profil profil){
		tb1.setValue(profil.getVorname());
		tb2.setValue(profil.getNachname());
		geburtsdatum.setValue(profil.getGeburtsdatum());
		tb4.setValue(profil.getHaarfarbe());
		tb5.setValue(profil.getReligion());
//		tb6.setValue(profil.getKoerpergroesse());
//		tb7.setValue(profil.getRaucher());
//		tb8.setValue(profil.getGeschlecht());
		
		// Create a date picker
				final DatePicker datepicker_geburtsdatum = new DatePicker();
				
				
			 // Set the value in the text box when the user selects a date
				datepicker_geburtsdatum.addValueChangeHandler(new ValueChangeHandler<Date>(){

					final Label text = new Label();
					@Override
					public void onValueChange(ValueChangeEvent<Date> event) {
						Date date = event.getValue();
						String dateString = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM).format(new Date());
						text.setText(dateString);
					}
				});
				
			    datepicker_geburtsdatum.setValue(new Date(), true);
	}
}
