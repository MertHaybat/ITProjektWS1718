package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profil_Tabelle extends CellTable<Profil>{ 

	private VerticalPanel vpanelprofil_anzeige = new VerticalPanel();
	
	final SingleSelectionModel<Profil> ssm_profil_anzeige = new SingleSelectionModel<Profil>();
	
	DateTimeFormat df = DateTimeFormat.getFormat("DD/MM/YYYY");
	
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
	 
	this.addColumn(profil_vorname, "Vorname");
	this.addColumn(profil_nachname, "Nachname");
	this.addColumn(profil_geburtsdatum, "Geburtsdatum");
	
	}
}
