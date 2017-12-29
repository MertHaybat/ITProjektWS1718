package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Startseite extends VerticalPanel{
	
	private VerticalPanel vpanel = new VerticalPanel();
	private FlexTable ft1 = new FlexTable();
	private Anchor an1 =new Anchor("Text"); 
	private HTML html1 = new HTML("hallo");
	
	public Startseite(){
		ft1.setWidget(0,0,an1);
		ft1.setWidget(0, 1, html1);
		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}

}
