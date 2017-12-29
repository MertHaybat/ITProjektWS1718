package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menubar extends VerticalPanel{
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1= new Button("Profil");
	private Button btn2= new Button("Platzhalter");
	private FlexTable ft1 = new FlexTable();
	
	public Menubar(){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		

		vpanel.add(ft1);
		this.add(vpanel);

	}

}
