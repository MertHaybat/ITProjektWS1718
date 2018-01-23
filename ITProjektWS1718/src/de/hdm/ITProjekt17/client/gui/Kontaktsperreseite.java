package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Kontaktsperreseite extends VerticalPanel{
	private VerticalPanel vpaneleigene_kontaktsperren = new VerticalPanel();
	private VerticalPanel vpanelandere_kontaktsperren = new VerticalPanel();
	private HorizontalPanel hpanel = new HorizontalPanel();
	
	private HTML htmleigene_kontaktsperren = new HTML("<h2>Eigene Kontaktsperren:</h2>");
	private HTML htmlandere_kontaktsperren = new HTML("<h2>Sie wurden gesperrt von:</h2>");
	
	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	public Kontaktsperreseite (final Profil profil){
		final Profil_Tabelle pt1 = new Profil_Tabelle();
		final Profil_Tabelle pt2 = new Profil_Tabelle();
		
		vpaneleigene_kontaktsperren.add(htmleigene_kontaktsperren);
		vpaneleigene_kontaktsperren.add(pt1);
		hpanel.add(vpaneleigene_kontaktsperren);
		vpanelandere_kontaktsperren.add(htmlandere_kontaktsperren);
		vpanelandere_kontaktsperren.add(pt2);
		hpanel.add(vpanelandere_kontaktsperren);
		this.add(hpanel);
		
	}
}
