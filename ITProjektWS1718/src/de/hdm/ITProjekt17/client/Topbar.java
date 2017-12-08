package de.hdm.ITProjekt17.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Topbar extends VerticalPanel{
	
	private VerticalPanel vtoppanel = new VerticalPanel();
	private Button btn1 = new Button("Hallo1");
	private Button btn2 = new Button("Hallo2");
	private Button btn3 = new Button("Hallo3");
	private Button btn4 = new Button("Hallo4");
	
	public Topbar(){
		vtoppanel.add(btn1);
		vtoppanel.add(btn2);
		vtoppanel.add(btn3);
		vtoppanel.add(btn4);
	}
	

}
