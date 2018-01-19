package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class AGB extends VerticalPanel{

	private VerticalPanel vpanel = new VerticalPanel();
	private FlexTable ft1 = new FlexTable();
	private HTML agb = new HTML
				("<div class="
				+ "<b>" +"Hinweise zum Datenschutz</b></br></br>"
				+ "<b>" +"1. Allgemeines</b></br></br>"
				+ " Wir erheben und verwenden Ihre personenbezogenen Daten ausschließlich im Rahmen der Bestimmungen des Datenschutzrechts "
				+ "der Bundesrepublik Deutschland. Maßgeblich sind Bestimmungen des Bundesdatenschutzgesetzes (BDSG) sowie zum Teil speziellere Rechtsvorschriften, "
				+ "insb. diejenigen des Telekommunikations- (TKG) und des Telemediengesetzes (TMG)."
				+ "Die genannten Vorschriften betreffen personenbezogene Daten. Personenbezogene Daten sind Einzelangaben über persönliche und sachliche Verhältnisse einer bestimmten oder bestimmbaren natürlichen Person. Dies können bei einer Kontaktaufnahme per Post, E-Mail, oder Web-Formular beispielsweise der Name, die Anschrift oder die E-Mail Adresse sein."
				+ "Hiermit unterrichten wir Sie über Art, Umfang und Zwecke der Erhebung und Verwendung derjenigen Daten, die während Ihres Besuchs auf unserer Homepage erfasst und wie sie genutzt werden. Sie können diese Unterrichtung jederzeit auf unserer Webseite abrufen.</br>"
				+"<br></br>"
				+  "<b>" +"2. Zugriff auf die Homepage</b></br></br>"
				+ " Jeder Zugriff auf unsere Homepage und jeder Abruf einer auf der Homepage hinterlegten Datei wird protokolliert. Die Speicherung dient internen systembezogenen und statistischen Zwecken. Protokolliert werden: Name der abgerufenen Datei, Datum und Uhrzeit des Abrufs, übertragene Datenmenge, Meldung über erfolgreichen Abruf, Browser Version des zugreifenden Hostsystems; Betriebssystem Version des zugreifenden Hostsystems."
				+ "Zusätzlich werden die IP Adressen der anfragenden Rechner protokolliert."
				+ "</div>");
	
	public AGB(final Profil profil){
		ft1.setWidget(0, 1, agb);
		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}
	}
		
		
