package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

import de.hdm.ITProjekt17.shared.bo.Profil;
/**
 * Dialogbox um das andere Profil anzuzeigen. 
 * @author Mert
 *
 */
public class Profil_Dialogbox extends FlexTable{
	private TextBox tbvorname = new TextBox();
	private TextBox tbnachname = new TextBox();
	private DateBox geburtsdatum = new DateBox();
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
			
			
			
			this.setWidget(0, 2, new Button("Hierkommtähnlichkeit"));
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
				
		}

		public TextBox getTbvorname() {
			return tbvorname;
		}

		public void setTbvorname(TextBox tbvorname) {
			this.tbvorname = tbvorname;
		}

		public TextBox getTbnachname() {
			return tbnachname;
		}

		public void setTbnachname(TextBox tbnachname) {
			this.tbnachname = tbnachname;
		}

		public DateBox getGeburtsdatum() {
			return geburtsdatum;
		}

		public void setGeburtsdatum(DateBox geburtsdatum) {
			this.geburtsdatum = geburtsdatum;
		}

		public TextBox getTbhaarfarbe() {
			return tbhaarfarbe;
		}

		public void setTbhaarfarbe(TextBox tbhaarfarbe) {
			this.tbhaarfarbe = tbhaarfarbe;
		}

		public TextBox getTbreligion() {
			return tbreligion;
		}

		public void setTbreligion(TextBox tbreligion) {
			this.tbreligion = tbreligion;
		}

		public TextBox getTbkörpergröße() {
			return tbkörpergröße;
		}

		public void setTbkörpergröße(TextBox tbkörpergröße) {
			this.tbkörpergröße = tbkörpergröße;
		}

		public TextBox getTbraucher() {
			return tbraucher;
		}

		public void setTbraucher(TextBox tbraucher) {
			this.tbraucher = tbraucher;
		}

		public TextBox getTbgeschlecht() {
			return tbgeschlecht;
		}

		public void setTbgeschlecht(TextBox tbgeschlecht) {
			this.tbgeschlecht = tbgeschlecht;
		}
}

