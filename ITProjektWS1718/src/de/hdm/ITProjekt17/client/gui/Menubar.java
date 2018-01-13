package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Menubar extends VerticalPanel { //StackPanel für auskommentierten Code
	
//	private VerticalPanel vpanel = new VerticalPanel();
//	private Button btn1 = new Button("Profil");
//	private Button btn2 = new Button("Platzhalter");
//	
//	public Menubar(final Profil profil){
//	
//		btn1.setStylePrimaryName("menubarbutton");
//		btn2.setStylePrimaryName("menubarbutton");	
//		
//	vpanel.add(btn1);
//	vpanel.add(btn2);
//	this.setWidth("230px");
//	this.addStyleName("gwt-StackPanel");
//	this.add(vpanel, "Einstellungen");
//	
//	
//	}
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1 = new Button("Profil");
	private Button btn2 = new Button("Aktivitäten");
	private Button btn3 = new Button("Merkzettel");
	private FlexTable ft1 = new FlexTable();
	
	public Menubar(final Profil profil){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		btn3.setStylePrimaryName("menubarbutton");
		
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		ft1.setWidget(2, 0, btn3);
		
		btn1.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Profilseite p = new Profilseite(profil);
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(p);
			}
		});

		btn2.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Aktivitaeten(profil));
			}
			
		});
		
		btn3.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Merkzettelseite(profil));
			}
			
		});
		
		vpanel.add(ft1);
		this.add(vpanel);

		
	}

}
