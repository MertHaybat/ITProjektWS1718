package de.hdm.ITProjekt17.client.gui;

import java.util.Date;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.NoSelectionModel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Profil.Geschlecht;
import de.hdm.ITProjekt17.shared.bo.Profil.Haarfarbe;
import de.hdm.ITProjekt17.shared.bo.Profil.Raucher;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;

public class Suchen extends VerticalPanel {
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();

	/*
	 *	Deklarieren und Instanziieren der Widgets 
	 */
	

	private DateBox geburtsdatum = new DateBox();
	private ListBox lbhaarfarbe = new ListBox();
	private TextBox tbreligion = new TextBox();
	private TextBox tbkörpergröße = new TextBox();
	private ListBox lbraucher = new ListBox();
	private ListBox lbgeschlecht = new ListBox();
	private TextBox tbminalter = new TextBox();
	private TextBox tbmaxalter = new TextBox();

	private Label lb3 = new Label("Geburtsdatum: ");
	private Label lb4 = new Label("Haarfarbe: ");
	private Label lb5 = new Label("Religion: ");
	private Label lb6 = new Label("Körpergröße: ");
	private Label lb7 = new Label("Raucher: ");
	private Label lb8 = new Label("Geschlecht: ");
	private Label lb9 = new Label("Alter von bis:");
	
	DateTimeFormat df = DateTimeFormat.getFormat("DD/MM/YYYY"); 

	private Button suchen = new Button("Suchen");
	private Button suchprofilSpeichern = new Button("Suchprofil speichern");
	private Button suchprofilLoeschen = new Button("Suchprofil löschen");
	
	private FlexTable ft1 = new FlexTable();
	private CellTable<Suchen> ct = new CellTable<Suchen>();	
	final NoSelectionModel<Suchen> ssm = new NoSelectionModel<Suchen>();

	private VerticalPanel vpanelSuchprofile = new VerticalPanel();
	private VerticalPanel vpanelEigenschaften = new VerticalPanel();
	private HorizontalPanel hpanel = new HorizontalPanel();
	
	
	
	public Suchen(final Profil profil){

		ft1.setWidget(3, 0, lb8);
		ft1.setWidget(3, 1, lbgeschlecht);
		ft1.setWidget(4, 0, lb9);
		ft1.setWidget(4, 1, tbminalter);
		ft1.setWidget(4, 2, tbmaxalter);
		ft1.setWidget(5, 0, lb3);
		ft1.setWidget(5, 1, geburtsdatum);
		ft1.setWidget(6, 0, lb4);
		ft1.setWidget(6, 1, lbhaarfarbe);
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
		      
		      
				//Raucher
				if(profil.getRaucher()==Profil.word(c1)){
					lbraucher.setSelectedIndex(0);
				}
				else if(profil.getGeschlecht()==Profil.word(c2)){
					lbgeschlecht.setSelectedIndex(1);
				}
				else if(profil.getGeschlecht()==Profil.word(c3)){
					lbgeschlecht.setSelectedIndex(2);
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
					
					Suchprofil such = new Suchprofil();
					
					// Geschlecht
					if(lbgeschlecht.getSelectedIndex()==0){
						such.setGeschlecht(Suchprofil.GeschlechtSuchprofil.m.toString());
					}
					else if(lbgeschlecht.getSelectedIndex()==1){
						such.setGeschlecht(Suchprofil.GeschlechtSuchprofil.w.toString());
					}
					else if(lbgeschlecht.getSelectedIndex()==2){
						such.setGeschlecht(Suchprofil.GeschlechtSuchprofil.s.toString());
					}
					
					//Haarfarbe
					if(lbhaarfarbe.getSelectedIndex()==0){
						such.setHaarfarbe(Suchprofil.HaarfarbeSuchprofil.A.toString());	
					}
					else if(lbhaarfarbe.getSelectedIndex()==1){
						such.setHaarfarbe(Suchprofil.HaarfarbeSuchprofil.B.toString());
					}
					else if(lbhaarfarbe.getSelectedIndex()==2){
						such.setHaarfarbe(Suchprofil.HaarfarbeSuchprofil.C.toString());
		    		}
					else if(lbhaarfarbe.getSelectedIndex()==3){
						such.setHaarfarbe(Suchprofil.HaarfarbeSuchprofil.D.toString());
		    		}		
					else if(lbhaarfarbe.getSelectedIndex()==4){
						such.setHaarfarbe(Suchprofil.HaarfarbeSuchprofil.E.toString());
					}
					else if(lbhaarfarbe.getSelectedIndex()==5){
						such.setHaarfarbe(Suchprofil.HaarfarbeSuchprofil.F.toString());
					}
						
					
					//Raucher
					if(lbraucher.getSelectedIndex()==0){
						such.setRaucher(Suchprofil.RaucherSuchprofil.A.toString());
					}
					else if(lbraucher.getSelectedIndex()==1){
						such.setRaucher(Suchprofil.RaucherSuchprofil.B.toString());
					}
					else if(lbraucher.getSelectedIndex()==2){
						such.setRaucher(Suchprofil.RaucherSuchprofil.C.toString());
					}
					else if(lbraucher.getSelectedIndex()==3){
						such.setRaucher(Suchprofil.RaucherSuchprofil.D.toString());
					}
					else if(lbraucher.getSelectedIndex()==4){
						such.setRaucher(Suchprofil.RaucherSuchprofil.E.toString());
					}
					
					//Restliche Attribute 
					such.setMinAlter(Integer.parseInt(tbminalter.getValue()));
					such.setMaxAlter(Integer.parseInt(tbmaxalter.getValue()));
					such.setGeburtsdatum(geburtsdatum.getValue());
					such.setKoerpergroesse(Integer.parseInt(tbkörpergröße.getValue()));
					such.setReligion(tbreligion.getValue());
					
					
					pbverwaltung.save(such, new AsyncCallback<Suchprofil>() {
						
						@Override
						public void onSuccess(Suchprofil result) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}
					});
			}
		    	
		    });
		    
		    suchprofilLoeschen.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) { 
			}
		    	
		    });
		    
			RootPanel.get("Details").setWidth("100%");
		    
			ct.setWidth("100%", true);
			vpanelSuchprofile.add(ct);
			vpanelEigenschaften.add(ft1);
			hpanel.add(vpanelSuchprofile);
			hpanel.add(vpanelEigenschaften);

			this.add(hpanel);
			
			ct.setSelectionModel(ssm);
			
			
			Column<Suchprofil, String> suchprofileGeschlecht = 
				    new Column<Suchprofil, String>(new ClickableTextCell())  {

						@Override
						public String getValue(Suchprofil object) {
							// TODO Auto-generated method stub
							return object.getGeschlecht();
						}
					    
			 };
			Column<Suchprofil, String> suchprofileHaarfarbe =
					new Column <Suchprofil,String> (new ClickableTextCell()){

						@Override
						public String getValue(Suchprofil object) {
							// TODO Auto-generated method stub
							return object.getHaarfarbe();
						}
					    
			 };
			 Column<Suchprofil, String> suchprofileRaucher =
					 new Column<Suchprofil, String> (new ClickableTextCell()){

						@Override
						public String getValue(Suchprofil object) {
							// TODO Auto-generated method stub
							return object.getRaucher();
						}
				 
			 };
			 Column<Suchprofil, String> suchprofileReligion =
					 new Column<Suchprofil, String> (new ClickableTextCell()){

						@Override
						public String getValue(Suchprofil object) {
							// TODO Auto-generated method stub
							return object.getReligion();
						}
			};
			Column<Suchprofil, String> suchprofileGeburtsdatum =
					 new Column<Suchprofil, String> (new ClickableTextCell()){

						@Override
						public String getValue(Suchprofil object) {
							// TODO Auto-generated method stub
							return object.getGeburtsdatum().toString();
						}
			};
//			Column<Suchprofil, String> suchprofileMinAlter =
//					 new Column<Suchprofil, String> (new ClickableTextCell()){
//
//						@Override
//						public String getValue(Suchprofil object) {
//							// TODO Auto-generated method stub
//							
//							return object.getMinAlter();
//						}
//			};
//			Column<Suchprofil, String> suchprofileMaxAlter =
//					 new Column<Suchprofil, String> (new ClickableTextCell()){
//
//						@Override
//						public String getValue(Suchprofil object) {
//							// TODO Auto-generated method stub
//							return object.getMaxAlter();
//						}
//			};
//			Column<Suchprofil, String> suchprofileKörpergröße =
//					 new Column<Suchprofil, String> (new ClickableTextCell()){
//
//						@Override
//						public String getValue(Suchprofil object) {
//							// TODO Auto-generated method stub
//							return object.getKoerpergroesse();
//						}
//			};

	
	}

}

	
