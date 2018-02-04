package de.hdm.ITProjekt17.client.gui.report;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * Anzeige des HTML Ergebnisses
 *
 */
public class HTMLResultPanel extends VerticalPanel{

	public void append(String text) {
	    HTML content = new HTML(text);
	    content.setStylePrimaryName("partnerboerse-simpletext");
	    this.add(content);
	  }
	
	
}