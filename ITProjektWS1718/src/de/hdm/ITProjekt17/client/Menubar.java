package de.hdm.ITProjekt17.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menubar extends StackPanel{
	
	private VerticalPanel vpanel = new VerticalPanel();
	
	private Button btn1= new Button("Hallo");
	
	public Menubar(){
		btn1.setWidth("299px");
		vpanel.add(btn1);
				
	}

}
