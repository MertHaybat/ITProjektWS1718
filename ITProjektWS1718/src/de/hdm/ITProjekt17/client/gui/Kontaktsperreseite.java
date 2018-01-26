package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;

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
		
		pt1.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				DialogBoxKontaktsperreProfil dialogboxkontaktsperreprofil = new DialogBoxKontaktsperreProfil(profil, pt1.getSsm_profil_anzeige().getSelectedObject());
				dialogboxkontaktsperreprofil.center();
			}
		});
		
		pt2.getSsm_profil_anzeige().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					
					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						DialogBoxKontaktsperreProfil dialogboxkontaktsperreprofil = new DialogBoxKontaktsperreProfil(profil, pt2.getSsm_profil_anzeige().getSelectedObject());
						dialogboxkontaktsperreprofil.center();
					}
				});
		
	}
	private class DialogBoxKontaktsperreProfil extends DialogBox{
		private Button entsperren = new Button("Kontakt entsperren");
		private Button abbrechen = new Button("Abbrechen");
		
		public DialogBoxKontaktsperreProfil(final Profil profil_eigenes, final Profil profil_fremdes){
			final Profil_Dialogbox pdb1 = new Profil_Dialogbox(profil_eigenes, profil_fremdes);
			pdb1.setWidget(8, 0, entsperren);
			pdb1.setWidget(8, 1, abbrechen);
			this.add(pdb1);
		}

	}
}
