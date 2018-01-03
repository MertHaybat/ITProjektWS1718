package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profilseite extends VerticalPanel{
	private TextBox tb1 = new TextBox();
	private TextBox tb2 = new TextBox();
	private TextBox tb3 = new TextBox();
	private TextBox tb4 = new TextBox();
	private TextBox tb5 = new TextBox();
	private TextBox tb6 = new TextBox();
	private TextBox tb7 = new TextBox();
	private TextBox tb8 = new TextBox();
	private TextBox tb9 = new TextBox();
	
	
	
	public Profilseite(){
		Window.alert("Willkommen auf MOFOS. Tragen Sie bitte nachfolgend die Daten zu Ihrer Person ein");
		
	}
	
	public Profilseite(Profil profil){
		
	}

}
