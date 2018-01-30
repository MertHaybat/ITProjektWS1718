package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profil_Tabelle extends CellTable<Profil>{ 

	private VerticalPanel vpanelprofil_anzeige = new VerticalPanel();
	
	private final SingleSelectionModel<Profil> ssm_profil_anzeige = new SingleSelectionModel<Profil>();
	
	DateTimeFormat df = DateTimeFormat.getFormat("dd/MM/yyyy");
	public SingleSelectionModel<Profil> getSsm_profil_anzeige() {
		return ssm_profil_anzeige;
	}
	public Profil_Tabelle(){
		
		
		this.setSelectionModel(ssm_profil_anzeige);
		this.setWidth("100%");
		this.setSelectionModel(ssm_profil_anzeige);
		vpanelprofil_anzeige.add(this);
		Column<Profil, String> profil_vorname = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return object.getVorname();
					}
					    
	 };
	 Column<Profil, String> profil_nachname = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return object.getNachname();
					}
					    
	 };
	 Column<Profil, String> profil_geburtsdatum = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return df.format(object.getGeburtsdatum());
					}
					    
	 };
	 Column<Profil, String> profil_koerpergroesse = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return String.valueOf(object.getKoerpergroesse());
					}
					    
	 };
	 Column<Profil, String> profil_religion = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return object.getReligion();
					}
					    
	 };
	 Column<Profil, String> profil_haarfarbe = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return object.getHaarfarbe();
					}
					    
	 };
	 Column<Profil, String> profil_raucher = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return object.getRaucher();
					}
					    
	 };
	 Column<Profil, String> profil_geschlecht = 
			    new Column<Profil, String>(new ClickableTextCell())  {
			    	@Override
					public String getValue(Profil object) {
						return object.getGeschlecht();
					}
					    
	 };
	this.addColumn(profil_vorname, "Vorname");
	this.addColumn(profil_nachname, "Nachname");
	this.addColumn(profil_geburtsdatum, "Geburtsdatum");
	this.addColumn(profil_koerpergroesse, "Körpergröße");
	this.addColumn(profil_religion, "Religion");
	this.addColumn(profil_haarfarbe, "Haarfarbe");
	this.addColumn(profil_raucher, "Raucher");
	this.addColumn(profil_geschlecht, "Geschlecht");
	
	}

	
}
