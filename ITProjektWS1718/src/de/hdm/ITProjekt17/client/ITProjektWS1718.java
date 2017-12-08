package de.hdm.ITProjekt17.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry-Point-Klasse des Projekts "ITProjektWS1718- Partnerboerse"
 * @author Mert
 *
 */

public class ITProjektWS1718 implements EntryPoint{

	@Override
	public void onModuleLoad() {
		Menubar mb = new Menubar();
		RootPanel.get("Navigator").add(mb);
		Topbar tp = new Topbar();
		RootPanel.get("Topbar").add(tp);
		BeispielSeite b = new BeispielSeite();
		RootPanel.get("Details").add(b);
		
	}

	
}