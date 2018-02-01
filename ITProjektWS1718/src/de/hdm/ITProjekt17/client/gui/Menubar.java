package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class Menubar extends VerticalPanel { 
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1 = new Button("Startseite");
	private Button btn2 = new Button("Profil");
	private Button btn3 = new Button("Aktivitäten");
	private Button btn4 = new Button("Merkzettel");
	private Button btn5 = new Button("Kontaktsperren");
	private Button btn6 = new Button("Suchen");
	
	
	private FlexTable ft1 = new FlexTable();
	public Menubar(){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		btn3.setStylePrimaryName("menubarbutton");
		btn4.setStylePrimaryName("menubarbutton");
		btn5.setStylePrimaryName("menubarbutton");
		btn6.setStylePrimaryName("menubarbutton");
		
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		ft1.setWidget(2, 0, btn3);
		ft1.setWidget(3, 0, btn4);
		ft1.setWidget(4, 0, btn5);
		ft1.setWidget(5, 0, btn6);
		

		vpanel.add(ft1);
		this.add(vpanel);
		
	}
	
	public Menubar(final Profil profil){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		btn3.setStylePrimaryName("menubarbutton");
		btn4.setStylePrimaryName("menubarbutton");
		btn5.setStylePrimaryName("menubarbutton");
		btn6.setStylePrimaryName("menubarbutton");
		
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		ft1.setWidget(2, 0, btn3);
		ft1.setWidget(3, 0, btn4);
		ft1.setWidget(4, 0, btn5);
		ft1.setWidget(5, 0, btn6);
		
		btn1.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new Startseite(profil));
			btn1.removeStyleName("gwt-Button");
			btn1.getElement().getStyle().setBackgroundColor("#C0C0C0");
		
			/**
			 * Buttons Farben der nicht gedrückten Buttons werden wieder zu Default zurückgesetzt.
			 * Somit sieht man welcher Seite man sich Aktuell befindet.
			 */
			btn2.getElement().getStyle().setBackgroundColor("");
			btn3.getElement().getStyle().setBackgroundColor("");
			btn4.getElement().getStyle().setBackgroundColor("");
			btn5.getElement().getStyle().setBackgroundColor("");
			btn6.getElement().getStyle().setBackgroundColor("");
			}
			
		});
		
		btn2.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {

				Profilseite p = new Profilseite(profil);
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(p);
				btn2.removeStyleName("gwt-Button");
				btn2.getElement().getStyle().setBackgroundColor("#C0C0C0");
			
				
				btn1.getElement().getStyle().setBackgroundColor("");
				btn3.getElement().getStyle().setBackgroundColor("");
				btn4.getElement().getStyle().setBackgroundColor("");
				btn5.getElement().getStyle().setBackgroundColor("");
				btn6.getElement().getStyle().setBackgroundColor("");
			}
		});

		btn3.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Aktivitaeten(profil));
				btn3.removeStyleName("gwt-Button");
				btn3.getElement().getStyle().setBackgroundColor("#C0C0C0");
			
				btn1.getElement().getStyle().setBackgroundColor("");
				btn2.getElement().getStyle().setBackgroundColor("");
				btn4.getElement().getStyle().setBackgroundColor("");
				btn5.getElement().getStyle().setBackgroundColor("");
				btn6.getElement().getStyle().setBackgroundColor("");
			}
			
		});
		
		btn4.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Merkzettelseite(profil));
				btn4.removeStyleName("gwt-Button");
				btn4.getElement().getStyle().setBackgroundColor("#C0C0C0");
			
				
				btn1.getElement().getStyle().setBackgroundColor("");
				btn2.getElement().getStyle().setBackgroundColor("");
				btn3.getElement().getStyle().setBackgroundColor("");
				btn5.getElement().getStyle().setBackgroundColor("");
				btn6.getElement().getStyle().setBackgroundColor("");
			}
			
		});
		
		btn5.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new Kontaktsperreseite(profil));
				btn5.removeStyleName("gwt-Button");
				btn5.getElement().getStyle().setBackgroundColor("#C0C0C0");
		
				
				btn1.getElement().getStyle().setBackgroundColor("");
				btn2.getElement().getStyle().setBackgroundColor("");
				btn3.getElement().getStyle().setBackgroundColor("");
				btn4.getElement().getStyle().setBackgroundColor("");
				btn6.getElement().getStyle().setBackgroundColor("");
				
			}
			
		});
		
		btn6.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new Suchen(profil));
			btn6.removeStyleName("gwt-Button");
			btn6.getElement().getStyle().setBackgroundColor("#C0C0C0");
			
			
			btn1.getElement().getStyle().setBackgroundColor("");
			btn2.getElement().getStyle().setBackgroundColor("");
			btn3.getElement().getStyle().setBackgroundColor("");
			btn4.getElement().getStyle().setBackgroundColor("");
			btn5.getElement().getStyle().setBackgroundColor("");
			}
			
		});
		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}

}
