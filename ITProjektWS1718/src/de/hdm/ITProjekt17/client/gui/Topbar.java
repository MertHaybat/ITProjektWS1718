package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * Anlegen einer Topbar
 * @author Giuseppe
 *
 */
public class Topbar extends VerticalPanel{
//	
//	private VerticalPanel vpanel = new VerticalPanel();
//	private Button btn1 = new Button("Startseite");
//	private Button btn2 = new Button("Platzhalterbutton");
//	private Button btn3 = new Button("Suchen");
//	private Button btn4 = new Button("Impressum");
//	
//	private FlexTable ft1 = new FlexTable();
//	
//	public Topbar(final Profil profil){
//		btn1.setStylePrimaryName("topbarbutton");
//		btn2.setStylePrimaryName("topbarbutton");
//		btn3.setStylePrimaryName("topbarbutton");
//		btn4.setStylePrimaryName("topbarbutton");
//		ft1.setWidget(0, 0, btn1);
//		ft1.setWidget(0, 1, btn2);
//		ft1.setWidget(0, 2, btn3);
//		ft1.setWidget(0, 3, btn4);
//		
//		btn1.addClickHandler(new ClickHandler(){
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1 = new Button("Startseite");
	private Button btn2 = new Button("Platzhalterbutton");
	private Button btn3 = new Button("Suchen");
	private Button btn4 = new Button("Impressum");
	
	private FlexTable ft1 = new FlexTable();
	
	public Topbar(final Profil profil){
		btn1.setStylePrimaryName("topbarbutton");
		btn2.setStylePrimaryName("topbarbutton");
		btn3.setStylePrimaryName("topbarbutton");
		btn4.setStylePrimaryName("topbarbutton");
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(0, 1, btn2);
		ft1.setWidget(0, 2, btn3);
		ft1.setWidget(0, 3, btn4);
		
		btn1.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new Startseite(profil));
			}
			
		});
		
//		btn2.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//			RootPanel.get("Details").clear();
//			RootPanel.get("Details").add(new Startseite(profil));
//			}
//			
//		});
//		
////		btn2.addClickHandler(new ClickHandler(){
////
////			@Override
////			public void onClick(ClickEvent event) {
////			RootPanel.get("Details").clear();
////			RootPanel.get("Details").add(platzhalter);
////			}
////			
////		});	
//		
//		btn3.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//			RootPanel.get("Details").clear();
//			RootPanel.get("Details").add(new Suchen(profil));
//			}
//			
//		});
//		
//		btn4.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//			RootPanel.get("Details").clear();
//			RootPanel.get("Details").add(new Impressum(profil));
//			}
//			
//		});
//		
//		
//		vpanel.add(ft1);
//		this.add(vpanel);
//	}
//	
//		});	
		
		btn3.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new Suchen(profil));
			}
			
		});
		
		btn4.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new Impressum(profil));
			}
			
		});
		
		
		vpanel.add(ft1);
		this.add(vpanel);
	}
	

}
