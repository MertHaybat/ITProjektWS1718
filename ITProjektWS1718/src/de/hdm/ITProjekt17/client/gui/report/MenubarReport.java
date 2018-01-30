package de.hdm.ITProjekt17.client.gui.report;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class MenubarReport extends VerticalPanel { 
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1 = new Button("StartseiteReport");
	private Button btn2 = new Button("Report aller Profile");
	private Button btn3 = new Button("Report aller unbesuchter Profile");
	private Button btn4 = new Button("Report aller Profile ähnlich der Suchprofile");
	
	
	private FlexTable ft1 = new FlexTable();
	public MenubarReport(){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		btn3.setStylePrimaryName("menubarbutton");
		btn4.setStylePrimaryName("menubarbutton");
		
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		ft1.setWidget(2, 0, btn3);
		ft1.setWidget(3, 0, btn4);
		

		vpanel.add(ft1);
		this.add(vpanel);
		
	}
	
	public MenubarReport(final Profil profil){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		btn3.setStylePrimaryName("menubarbutton");
		btn4.setStylePrimaryName("menubarbutton");
		
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		ft1.setWidget(2, 0, btn3);
		ft1.setWidget(3, 0, btn4);

		
		btn1.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new StartseiteReport(profil));
			}
			
		});
		
		btn2.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {

				ReportOfAllProfilesSeite p = new ReportOfAllProfilesSeite();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(p);
			}
		});

		btn3.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite());
			}
			
		});
		
		btn4.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new ReportOfAllAehnlicheProfilesBySuchprofilesSeite());
			}
			
		});
		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}

}
