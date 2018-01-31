package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import de.hdm.ITProjekt17.shared.bo.Profil;
/**
 * Dialogbox um das andere Profil anzuzeigen. 
 * @author Mert
 *
 */
public class Profil_Dialogbox extends FlexTable{
	private TextBox tbvorname = new TextBox();
	private TextBox tbnachname = new TextBox();
	private TextBox geburtsdatum = new TextBox();
	private TextBox tbhaarfarbe = new TextBox();
	private TextBox tbreligion = new TextBox();
	private TextBox tbkörpergröße = new TextBox();
	private TextBox tbraucher = new TextBox();
	private TextBox tbgeschlecht = new TextBox();
	
	private Label lb1 = new Label("Vorname: ");
	private Label lb2 = new Label("Nachname: ");
	private Label lb3 = new Label("Geburtsdatum: ");
	private Label lb4 = new Label("Haarfarbe: ");
	private Label lb5 = new Label("Religion: ");
	private Label lb6 = new Label("Körpergröße: ");
	private Label lb7 = new Label("Raucher: ");
	private Label lb8 = new Label("Geschlecht: ");
	
		public Profil_Dialogbox(final Profil profil_eigenes, final Profil profil_fremd){
			this.setWidget(0, 0, lb1);
			this.setWidget(0, 1, tbvorname);
			this.setWidget(1, 0, lb2);
			this.setWidget(1, 1, tbnachname);
			this.setWidget(2, 0, lb3);
			this.setWidget(2, 1, geburtsdatum);
			this.setWidget(3, 0, lb4);
			this.setWidget(3, 1, tbhaarfarbe);
			this.setWidget(4, 0, lb5);
			this.setWidget(4, 1, tbreligion);
			this.setWidget(5, 0, lb6);
			this.setWidget(5, 1, tbkörpergröße);
			this.setWidget(6, 0, lb7);
			this.setWidget(6, 1, tbraucher);
			this.setWidget(7, 0, lb8);
			this.setWidget(7, 1, tbgeschlecht);
			tbvorname.setValue(profil_fremd.getVorname());
			tbnachname.setValue(profil_fremd.getNachname());
			geburtsdatum.setValue(String.valueOf(profil_fremd.getGeburtsdatum()));
			tbhaarfarbe.setValue(profil_fremd.getHaarfarbe());
			tbreligion.setValue(profil_fremd.getReligion());
			tbkörpergröße.setValue(String.valueOf(profil_fremd.getKoerpergroesse()));
			tbraucher.setValue(profil_fremd.getRaucher());
			tbgeschlecht.setValue(profil_fremd.getGeschlecht());
			tbvorname.setEnabled(false);
			tbnachname.setEnabled(false);
			geburtsdatum.setEnabled(false);
			tbhaarfarbe.setEnabled(false);
			tbreligion.setEnabled(false);
			tbkörpergröße.setEnabled(false);
			tbraucher.setEnabled(false);
			tbgeschlecht.setEnabled(false);
		}

}

