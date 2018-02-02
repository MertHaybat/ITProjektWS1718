package de.hdm.ITProjekt17.client.gui;



import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Profil;

import de.hdm.ITProjekt17.shared.bo.Profil.Geschlecht;
import de.hdm.ITProjekt17.shared.bo.Profil.Haarfarbe;
import de.hdm.ITProjekt17.shared.bo.Profil.Raucher;

public class Profilseite extends VerticalPanel{

	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	private TextBox tbemail = new TextBox();
	private TextBox tbvorname = new TextBox();
	private TextBox tbnachname = new TextBox();
	private DateBox geburtsdatum = new DateBox();
	private ListBox lbhaarfarbe = new ListBox();
	private TextBox tbreligion = new TextBox();
	private TextBox tbkörpergröße = new TextBox();
	private ListBox lbraucher = new ListBox();
	private ListBox lbgeschlecht = new ListBox();
//	private TextBox tbfreitext = new TextBox();
	private TextArea tbfreitext = new TextArea();

	
	private ListBox lbinteresse = new ListBox();
	private ListBox lbwohnsituation = new ListBox();	
	private ListBox lbausbildung = new ListBox();
	private ListBox lbkörperbau = new ListBox();
	
	private Label lb1 = new Label("Vorname: ");
	private Label lb2 = new Label("Nachname: ");
	private Label lb3 = new Label("Geburtsdatum: ");
	private Label lb4 = new Label("Haarfarbe: ");
	private Label lb5 = new Label("Religion: ");
	private Label lb6 = new Label("Körpergröße: ");
	private Label lb7 = new Label("Raucher: ");
	private Label lb8 = new Label("Geschlecht: ");
	private Label lb9 = new Label("Was du sonst noch über dich sagen willst:");
	private Label lb10 = new Label("Interessiert an: ");
	private Label lb11 = new Label("Wohnsituation: ");
	private Label lb12 = new Label("Ausbildung: ");
	private Label lb14 = new Label("Körperbau: ");
	

	
	private Button ok = new Button("Bestätigen");
	private Button abbrechen = new Button("Eingaben Rückgängig machen");
	private Button löschen = new Button ("Profil löschen");
	
	private FlexTable ft1 = new FlexTable();
	private FlexTable ft2 = new FlexTable();

	private Profil p1 = new Profil();
	
	private VerticalPanel vpanel = new VerticalPanel();
	private VerticalPanel vpanel2 = new VerticalPanel();
	private HorizontalPanel hpanel = new HorizontalPanel();
	
	private Auswahleigenschaft a = new Auswahleigenschaft();
	private Auswahleigenschaft b = new Auswahleigenschaft();
	private Auswahleigenschaft c = new Auswahleigenschaft();
	private Auswahleigenschaft d = new Auswahleigenschaft();

	
	public Profilseite(final String email, final Anchor logout){
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
		ft1.setWidget(5, 1, lbhaarfarbe);
		ft1.setWidget(6, 0, lb5);
		ft1.setWidget(6, 1, tbreligion);
		ft1.setWidget(7, 0, lb6);
		ft1.setWidget(7, 1, tbkörpergröße);
		ft1.setWidget(8, 0, lb7);
		ft1.setWidget(8, 1, lbraucher);
		ft1.setWidget(9, 0, ok);
		ft1.setWidget(11, 0, abbrechen); // Eingaben Rückgängig machen
		
		ft2.setWidget(0, 0, lb10);
		ft2.setWidget(0, 1, lbinteresse);
		ft2.setWidget(1, 0, lb11);
		ft2.setWidget(1, 1, lbwohnsituation);
		ft2.setWidget(2, 0, lb12);
		ft2.setWidget(2, 1, lbausbildung);
		ft2.setWidget(4, 0, lb14);
		ft2.setWidget(4, 1, lbkörperbau);
		ft2.setWidget(5, 0, lb9);
		ft2.setWidget(6, 0, tbfreitext);
			
		tbfreitext.setPixelSize(250, 150);

		vpanel.add(ft1);
		vpanel2.add(ft2);
		hpanel.add(vpanel);
		hpanel.add(vpanel2);

		this.add(hpanel);
		
		//Interesse
				if(lbinteresse.getSelectedIndex()==0){
					a.setWert("Frauen");
				}
				else if(lbinteresse.getSelectedIndex()==1){
					a.setWert("Männer");
				}
				else if(lbinteresse.getSelectedIndex()==2){
					a.setWert("Beides");
				}
				
				//Wohnsituation
				if(lbwohnsituation.getSelectedIndex()==0){
					b.setWert("Bei den Eltern");
				}
				else if(lbwohnsituation.getSelectedIndex()==1){
					b.setWert("Alleine");
				}
				else if(lbwohnsituation.getSelectedIndex()==2){
					b.setWert("In einer WG");
				}
				else if(lbwohnsituation.getSelectedIndex()==3){
					b.setWert("Im Wohnheim");
				}
				
				//Ausbildung
				if(lbausbildung.getSelectedIndex()==0){
					c.setWert("Kein Abschluss");
				}
				else if(lbausbildung.getSelectedIndex()==1){
					c.setWert("Schüler");
				}
				else if(lbausbildung.getSelectedIndex()==2){
					c.setWert("Student");
				}
				else if(lbausbildung.getSelectedIndex()==3){
					c.setWert("Absolvent");
				}
						
				//Körperbau
				if(lbkörperbau.getSelectedIndex()==0){
					d.setWert("dünn");
				}
				else if(lbkörperbau.getSelectedIndex()==1){
					d.setWert("durchschnittlich");
				}
				else if(lbkörperbau.getSelectedIndex()==2){
					d.setWert("sportlich");
				}
				else if(lbkörperbau.getSelectedIndex()==3){
					d.setWert("muskulös");
				}
				else if(lbkörperbau.getSelectedIndex()==4){
					d.setWert("mollig");
				}
				else if(lbkörperbau.getSelectedIndex()==5){
					d.setWert("dick");
				}
			
		//ListBox Raucher befüllen.
		
		Raucher b1 = Raucher.A;
		Raucher b2 = Raucher.B;
		Raucher b3 = Raucher.C;
		Raucher b4 = Raucher.D;
		Raucher b5 = Raucher.E;
	      lbraucher.addItem(Profil.word(b1));
	      lbraucher.addItem(Profil.word(b2));
	      lbraucher.addItem(Profil.word(b3));
	      lbraucher.addItem(Profil.word(b4));
	      lbraucher.addItem(Profil.word(b5));
		  
		//ListBox Geschlecht befüllen.
		Geschlecht c1 = Geschlecht.m;
		Geschlecht c2 = Geschlecht.w;
		Geschlecht c3 = Geschlecht.s;
	      lbgeschlecht.addItem(Profil.word(c1));
	      lbgeschlecht.addItem(Profil.word(c2));
	      lbgeschlecht.addItem(Profil.word(c3));
	      
			//ListBox Haarfarbe befüllen.

			Haarfarbe h1 = Haarfarbe.A;
			Haarfarbe h2 = Haarfarbe.B;
			Haarfarbe h3 = Haarfarbe.C;
			Haarfarbe h4 = Haarfarbe.D;
			Haarfarbe h5 = Haarfarbe.E;
			  lbhaarfarbe.addItem(Profil.word(h1));
			  lbhaarfarbe.addItem(Profil.word(h2));
			  lbhaarfarbe.addItem(Profil.word(h3));
			  lbhaarfarbe.addItem(Profil.word(h4));
			  lbhaarfarbe.addItem(Profil.word(h5));

		  
		//ListBox Interesse befüllen.
			
	      lbinteresse.addItem("Frauen");
	      lbinteresse.addItem("Männer");
	      lbinteresse.addItem("Beides");	  
	      
			//ListBox Wohnsituation befüllen.
			
	      lbwohnsituation.addItem("Bei den Eltern");
	      lbwohnsituation.addItem("Alleine");
	      lbwohnsituation.addItem("In einer WG");
	      lbwohnsituation.addItem("Im Wohnheim");

			//ListBox Ausbildung befüllen.
			
	      lbausbildung.addItem("Kein Abschluss");
	      lbausbildung.addItem("Schüler");
	      lbausbildung.addItem("Student");
	      lbausbildung.addItem("Absolvent");
	      
	      //ListBox Körperbau befüllen.
	      
	      lbkörperbau.addItem("dünn");     
	      lbkörperbau.addItem("durchschnittlich");
	      lbkörperbau.addItem("sportlich");
	      lbkörperbau.addItem("muskulös");
	      lbkörperbau.addItem("mollig");
	      lbkörperbau.addItem("dick");
		
	
			geburtsdatum.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
			geburtsdatum.getDatePicker().setYearArrowsVisible(true);
			geburtsdatum.getDatePicker().setYearAndMonthDropdownVisible(true);
			geburtsdatum.getDatePicker().setVisibleYearCount(100);


		   
		    abbrechen.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					Window.open(logout.getHref(), "_self", "");
				}
			});
		    ok.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					pbverwaltung.createProfil(email, tbvorname.getValue(), tbnachname.getValue(), geburtsdatum.getValue(), 
							Integer.parseInt(tbkörpergröße.getValue()),
							tbreligion.getValue(), lbhaarfarbe.getSelectedValue(), lbraucher.getSelectedValue(), lbgeschlecht.getSelectedValue(), new AsyncCallback<Profil>(){
					
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
							Window.alert("Fehlerhafte Eingabe");		
								}

								@Override
								public void onSuccess(Profil result) {
									p1 = result;
									pbverwaltung.checkProfil(email, new AsyncCallback<Profil>() {

										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub
											
										}

										@Override
										public void onSuccess(Profil result) {
											RootPanel.get("Topbar").add(logout);
											RootPanel.get("Navigator").clear();
											RootPanel.get("Navigator").add(new Menubar(result));
																					}
									});
									
								}
					});
					
					Window.alert("Sie haben sich erfolgreich mit folgender E-Mail angemeldet: " + email);
					pbverwaltung.createInfo(email, 1, "", lbinteresse.getSelectedValue(), new AsyncCallback<Info>(){

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Info result) {
							pbverwaltung.createInfo(email, 2, "", lbwohnsituation.getSelectedValue(), new AsyncCallback<Info>(){

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Info result) {
									pbverwaltung.createInfo(email, 3, "", lbausbildung.getSelectedValue(), new AsyncCallback<Info>(){

										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub
											
										}

										@Override
										public void onSuccess(Info result) {
											pbverwaltung.createInfo(email, 4, "", lbkörperbau.getSelectedValue(), new AsyncCallback<Info>(){

												@Override
												public void onFailure(Throwable caught) {
													// TODO Auto-generated method stub
													
												}

												@Override
												public void onSuccess(Info result) {
													pbverwaltung.createInfo(email, 5, tbfreitext.getValue(), "", new AsyncCallback<Info>(){

														@Override
														public void onFailure(Throwable caught) {
															// TODO Auto-generated method stub
															
														}

														@Override
														public void onSuccess(Info result) {
															RootPanel.get("Details").clear();
															RootPanel.get("Details").add(new Profilseite(p1));
															RootPanel.get("Navigator").clear();
															RootPanel.get("Navigator").add(new Menubar(p1));
														}
														
													});
													
												}
												
											});
										}
										
									});
								}
								
							});
							
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
		ft1.setWidget(5, 1, lbhaarfarbe);
		ft1.setWidget(6, 0, lb5);
		ft1.setWidget(6, 1, tbreligion);
		ft1.setWidget(7, 0, lb6);
		ft1.setWidget(7, 1, tbkörpergröße);
		ft1.setWidget(8, 0, lb7);
		ft1.setWidget(8, 1, lbraucher);
		ft1.setWidget(9, 0, ok);
		ft1.setWidget(9, 1, abbrechen);
		ft1.setWidget(12, 0, löschen);

		ft2.setWidget(0, 0, lb10);
		ft2.setWidget(0, 1, lbinteresse);
		ft2.setWidget(1, 0, lb11);
		ft2.setWidget(1, 1, lbwohnsituation);
		ft2.setWidget(2, 0, lb12);
		ft2.setWidget(2, 1, lbausbildung);
		ft2.setWidget(4, 0, lb14);
		ft2.setWidget(4, 1, lbkörperbau);
		ft2.setWidget(5, 0, lb9);
		ft2.setWidget(6, 0, tbfreitext);

		tbfreitext.setPixelSize(250, 150);
		
		geburtsdatum.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
        geburtsdatum.getDatePicker().setYearArrowsVisible(true);
		geburtsdatum.getDatePicker().setYearAndMonthDropdownVisible(true);
		geburtsdatum.getDatePicker().setVisibleYearCount(100);
		
		
		//ListBox Raucher befüllen.
		
		Raucher b1 = Raucher.A;
		Raucher b2 = Raucher.B;
		Raucher b3 = Raucher.C;
		Raucher b4 = Raucher.D;
		Raucher b5 = Raucher.E;
	      lbraucher.addItem(Profil.word(b1));
	      lbraucher.addItem(Profil.word(b2));
	      lbraucher.addItem(Profil.word(b3));
	      lbraucher.addItem(Profil.word(b4));
	      lbraucher.addItem(Profil.word(b5));
		  
		//ListBox Geschlecht befüllen.

			Geschlecht c1 = Geschlecht.m;
			Geschlecht c2 = Geschlecht.w;
			Geschlecht c3 = Geschlecht.s;
		      lbgeschlecht.addItem(Profil.word(c1));
		      lbgeschlecht.addItem(Profil.word(c2));
		      lbgeschlecht.addItem(Profil.word(c3));
		      
		//ListBox Haarfarbe befüllen.

			Haarfarbe h1 = Haarfarbe.A;
			Haarfarbe h2 = Haarfarbe.B;
			Haarfarbe h3 = Haarfarbe.C;
			Haarfarbe h4 = Haarfarbe.D;
			Haarfarbe h5 = Haarfarbe.E;
			  lbhaarfarbe.addItem(Profil.word(h1));
			  lbhaarfarbe.addItem(Profil.word(h2));
			  lbhaarfarbe.addItem(Profil.word(h3));
			  lbhaarfarbe.addItem(Profil.word(h4));
			  lbhaarfarbe.addItem(Profil.word(h5));

	      
			//ListBox Interesse befüllen.
			
	      lbinteresse.addItem("Frauen");
	      lbinteresse.addItem("Männer");
	      lbinteresse.addItem("Beides");	  
	      
			//ListBox Wohnsituation befüllen.
			
	      lbwohnsituation.addItem("Bei den Eltern");
	      lbwohnsituation.addItem("Alleine");
	      lbwohnsituation.addItem("In einer WG");
	      lbwohnsituation.addItem("Im Wohnheim");

			//ListBox Ausbildung befüllen.
			
	      lbausbildung.addItem("Kein Abschluss");
	      lbausbildung.addItem("Schüler");
	      lbausbildung.addItem("Student");
	      lbausbildung.addItem("Absolvent");
				      
	      //ListBox Körperbau befüllen.
	      
	      lbkörperbau.addItem("dünn");     
	      lbkörperbau.addItem("durchschnittlich");
	      lbkörperbau.addItem("sportlich");
	      lbkörperbau.addItem("muskulös");
	      lbkörperbau.addItem("mollig");
	      lbkörperbau.addItem("dick");
		
		tbemail.setValue(profil.getEmail());
		tbvorname.setValue(profil.getVorname());
		tbnachname.setValue(profil.getNachname());
		geburtsdatum.setValue(profil.getGeburtsdatum());
		tbreligion.setValue(profil.getReligion());
		tbkörpergröße.setValue(String.valueOf(profil.getKoerpergroesse()));
		

		
		//Raucher
		if(profil.getRaucher()==Profil.word(b1)){
			lbraucher.setSelectedIndex(0);
		}
		else if(profil.getRaucher()==Profil.word(b2)){
			lbraucher.setSelectedIndex(1);
		}
		else if(profil.getRaucher()==Profil.word(b3)){
			lbraucher.setSelectedIndex(2);
		}else if(profil.getRaucher()==Profil.word(b4)){
			lbraucher.setSelectedIndex(3);
		}else if(profil.getRaucher()==Profil.word(b5)){
			lbraucher.setSelectedIndex(4);
		}
		
		
		//Geschlecht
		if(profil.getGeschlecht()==Profil.word(c1)){
			lbgeschlecht.setSelectedIndex(0);
		}
		else if(profil.getGeschlecht()==Profil.word(c2)){
			lbgeschlecht.setSelectedIndex(1);
		}
		else if(profil.getGeschlecht()==Profil.word(c3)){
			lbgeschlecht.setSelectedIndex(2);
		}
		
		//Haarfarbe
		if(profil.getHaarfarbe()==Profil.word(h1)){
			lbhaarfarbe.setSelectedIndex(0);
		}
		else if(profil.getHaarfarbe()==Profil.word(h2)){
			lbhaarfarbe.setSelectedIndex(1);
		}
		else if(profil.getHaarfarbe()==Profil.word(h3)){
			lbhaarfarbe.setSelectedIndex(2);
		}
		else if(profil.getHaarfarbe()==Profil.word(h4)){
			lbhaarfarbe.setSelectedIndex(3);
		}
		else if(profil.getHaarfarbe()==Profil.word(h5)){
			lbhaarfarbe.setSelectedIndex(4);
		}
		
		//Interesse
		if(lbinteresse.getSelectedIndex()==0){
			a.setWert("Frauen");
		}
		else if(lbinteresse.getSelectedIndex()==1){
			a.setWert("Männer");
		}
		else if(lbinteresse.getSelectedIndex()==2){
			a.setWert("Beides");
		}
		
		//Wohnsituation
		if(lbwohnsituation.getSelectedIndex()==0){
			b.setWert("Bei den Eltern");
		}
		else if(lbwohnsituation.getSelectedIndex()==1){
			b.setWert("Alleine");
		}
		else if(lbwohnsituation.getSelectedIndex()==2){
			b.setWert("In einer WG");
		}
		else if(lbwohnsituation.getSelectedIndex()==3){
			b.setWert("Im Wohnheim");
		}
		
		//Ausbildung
		if(lbausbildung.getSelectedIndex()==0){
			c.setWert("Kein Abschluss");
		}
		else if(lbausbildung.getSelectedIndex()==1){
			c.setWert("Schüler");
		}
		else if(lbausbildung.getSelectedIndex()==2){
			c.setWert("Student");
		}
		else if(lbausbildung.getSelectedIndex()==3){
			c.setWert("Absolvent");
		}
				
		//Körperbau
		if(lbkörperbau.getSelectedIndex()==0){
			d.setWert("dünn");
		}
		else if(lbkörperbau.getSelectedIndex()==1){
			d.setWert("durchschnittlich");
		}
		else if(lbkörperbau.getSelectedIndex()==2){
			d.setWert("sportlich");
		}
		else if(lbkörperbau.getSelectedIndex()==3){
			d.setWert("muskulös");
		}
		else if(lbkörperbau.getSelectedIndex()==4){
			d.setWert("mollig");
		}
		else if(lbkörperbau.getSelectedIndex()==5){
			d.setWert("dick");
		}
		
		löschen.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {

				Profil_loeschen_Dialogbox b1 = new Profil_loeschen_Dialogbox(profil);
				b1.center();				
			}
			
		});
		abbrechen.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new Profilseite(profil));
				
			}
			
		});
		ok.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				profil.setGeburtsdatum(geburtsdatum.getValue());
				profil.setGeschlecht(lbgeschlecht.getSelectedValue());
				profil.setHaarfarbe(lbhaarfarbe.getSelectedValue());
				profil.setKoerpergroesse(Integer.parseInt(tbkörpergröße.getValue()));
				profil.setNachname(tbnachname.getValue());
				profil.setRaucher(lbraucher.getSelectedValue());
				profil.setReligion(tbreligion.getValue());
				profil.setVorname(tbvorname.getValue());
				pbverwaltung.save(profil, new AsyncCallback<Void>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("Ihre Veränderungen wurden erfolgreich abgespeichert");
						}
					
				});	
				pbverwaltung.getAllInfobyProfil(profil, new AsyncCallback<Vector<Info>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Vector<Info> result) {
						for (Info info : result) {
							switch (info.getAuswahleigenschaftid()) {
							case 1: info.setAuswahleigenschaftWert(lbinteresse.getSelectedValue());
							pbverwaltung.save(info, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Void result) {
								
								}
							});
							break;
							case 2: info.setAuswahleigenschaftWert(lbwohnsituation.getSelectedValue());
							pbverwaltung.save(info, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Void result) {
									
								}
							});
							break;
							case 3: info.setAuswahleigenschaftWert(lbausbildung.getSelectedValue());
							pbverwaltung.save(info, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Void result) {
									
								}
							});
							break;
							case 4: info.setAuswahleigenschaftWert(lbkörperbau.getSelectedValue());
							pbverwaltung.save(info, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Void result) {
									
								}
							});
								break;
							case 5: info.setFreitexteigenschaftWert(tbfreitext.getValue());
							pbverwaltung.save(info, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Ihre Veränderungen wurden erfolgreich abgespeichert");
								}

								@Override
								public void onSuccess(Void result) {
									RootPanel.get("Details").clear();
									RootPanel.get("Details").add(new Profilseite(profil));
								}
							});
							break;
							default:
								break;
							}
							
						}
						
					}
					
				});
				
			}
			
		});
		
	    pbverwaltung.getInfoIdByProfilId(profil, new AsyncCallback<Vector<Info>>() {
			
			@Override
			public void onSuccess(Vector<Info> result) {
				
				for (Info info : result) {
					
					int o = info.getAuswahleigenschaftid();
					
					
					switch (o) {
					case 1: 
						String wert = info.getAuswahleigenschaftWert();
						switch (wert) {
						case "Frauen":
							lbinteresse.setSelectedIndex(0);
							break;
						case "Männer": lbinteresse.setSelectedIndex(1);
							
							break;

						case "Beides": lbinteresse.setSelectedIndex(2);
						break;
						default:
							break;
						}
						break;

					case 2: 
						String wert2 = info.getAuswahleigenschaftWert();
						switch (wert2) {
						
						case "Bei den Eltern": lbwohnsituation.setSelectedIndex(0);
							
							break;
							
						case "Alleine": lbwohnsituation.setSelectedIndex(1);
							break;
						case "In einer WG": lbwohnsituation.setSelectedIndex(2);
							break;
						case "Im Wohnheim": lbwohnsituation.setSelectedIndex(3);
						default:
							break;
						}
						
					case 3: 
						String wert3 = info.getAuswahleigenschaftWert();
						switch (wert3) {
						case "Kein Abschluss": lbausbildung.setSelectedIndex(0);
						break;
						case "Schüler": lbausbildung.setSelectedIndex(1); break;
						case "Student": lbausbildung.setSelectedIndex(2);
						break;
						case "Absolvent": lbausbildung.setSelectedIndex(3);
							
							break;

						default:
							break;
						}
						
					case 4: 
						String wert4 = info.getAuswahleigenschaftWert();
						switch (wert4) {
						case "dünn":
							lbkörperbau.setSelectedIndex(0);
							break;
						case "durchschnittlich": 
							lbkörperbau.setSelectedIndex(1);
							break;
						case "sportlich": lbkörperbau.setSelectedIndex(2);
						break;
						case "muskulös": lbkörperbau.setSelectedIndex(3);
						break;
						case "mollig": lbkörperbau.setSelectedIndex(4);
						break;
						case "dick": lbkörperbau.setSelectedIndex(5);
						default:
							break;
						}
					case 5:
						tbfreitext.setValue(info.getFreitexteigenschaftWert());
						
					default:
						break;
					}
					
					
					
					
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		vpanel.add(ft1);
		vpanel2.add(ft2);
		hpanel.add(vpanel);
		hpanel.add(vpanel2);

		this.add(hpanel);
	}
}
