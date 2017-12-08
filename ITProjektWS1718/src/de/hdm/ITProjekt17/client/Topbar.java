package de.hdm.ITProjekt17.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Topbar extends VerticalPanel{
	
	private VerticalPanel vtoppanel = new VerticalPanel();
	private Button btn1 = new Button("Hallo1");
	private Button btn2 = new Button("Hallo2");
	private Button btn3 = new Button("Hallo3");
	private Button btn4 = new Button("Hallo4");
	
	private FlexTable ft1 = new FlexTable();
	
	public Topbar(){
		btn1.setStylePrimaryName("topbarbutton");
		btn2.setStylePrimaryName("topbarbutton");
		btn3.setStylePrimaryName("topbarbutton");
		btn4.setStylePrimaryName("topbarbutton");
		ft1.setWidget(0, 0, btn1);
		ft1.setWidget(0, 1, btn2);
		ft1.setWidget(0, 2, btn3);
		ft1.setWidget(0, 3, btn4);
		
		
		vtoppanel.add(ft1);
		this.add(vtoppanel);
	}
	

}
