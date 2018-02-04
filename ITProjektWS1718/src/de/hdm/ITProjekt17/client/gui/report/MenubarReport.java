package de.hdm.ITProjekt17.client.gui.report;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * 
 * Anzeigen der Buttons um von Menü zu Menü springen zu können
 *
 */
public class MenubarReport extends VerticalPanel { 
	
	private VerticalPanel vpanel = new VerticalPanel();
	private Button btn1 = new Button("StartseiteReport");
	private Button btn2 = new Button("Unbesucht Report");
	private Button btn3 = new Button("Suchprofil Report");
	
	
	private FlexTable ft1 = new FlexTable();

	
	public MenubarReport(final Profil profil){
		btn1.setStylePrimaryName("menubarbutton");
		btn2.setStylePrimaryName("menubarbutton");
		btn3.setStylePrimaryName("menubarbutton");
		
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(1, 0, btn2);
		ft1.setWidget(2, 0, btn3);

		
		btn1.addClickHandler(new ClickHandler(){

			/**
			 * Clickhandeler ist eine anonyme Klasse die die Methode on click realissiert und wird aktiviert wenn ein Usser auf den Button klickt
			 */
			public void onClick(ClickEvent event) {
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(new StartseiteReport(profil));
			btn1.removeStyleName("gwt-Button");
			btn1.getElement().getStyle().setBackgroundColor("#C0C0C0");
		
			btn2.getElement().getStyle().setBackgroundColor("");
			btn3.getElement().getStyle().setBackgroundColor("");
			}
			
		});
		

		btn2.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite(profil));
				btn2.removeStyleName("gwt-Button");
				btn2.getElement().getStyle().setBackgroundColor("#C0C0C0");
			
				btn1.getElement().getStyle().setBackgroundColor("");
				btn3.getElement().getStyle().setBackgroundColor("");
				
			}
			
		});
		
		btn3.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(new ReportOfAllAehnlicheProfilesBySuchprofilesSeite(profil));
				btn3.removeStyleName("gwt-Button");
				btn3.getElement().getStyle().setBackgroundColor("#C0C0C0");
			
				btn1.getElement().getStyle().setBackgroundColor("");
				btn2.getElement().getStyle().setBackgroundColor("");
			}
			
		});
		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}

}
