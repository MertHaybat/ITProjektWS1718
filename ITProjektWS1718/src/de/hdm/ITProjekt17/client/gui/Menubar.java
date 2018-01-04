package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Menubar extends VerticalPanel{
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1= new Button("Profil");
	private Button btn2= new Button("Platzhalter");
	private FlexTable ft1 = new FlexTable();
	
	public Menubar(final Profil profil){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		
		btn1.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Profilseite(profil));
			}
		});

		vpanel.add(ft1);
		this.add(vpanel);

		
	}

}
