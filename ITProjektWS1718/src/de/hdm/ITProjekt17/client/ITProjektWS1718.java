package de.hdm.ITProjekt17.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry-Point-Klasse des Projekts "ITProjektWS1718- Partnerboerse"
 * @author Mert
 *
 */

public class ITProjektWS1718 implements EntryPoint{

	@Override
	public void onModuleLoad() {
		VerticalPanel navPanel = new VerticalPanel();
		
		FlexTable ft1 = new FlexTable();
		
		
		RootPanel.get("Navigator").add(navPanel);
	}
	
}