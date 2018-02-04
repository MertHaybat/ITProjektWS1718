package de.hdm.ITProjekt17.client.gui;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * Erstellen einer Startseite wenn der Teilnehmer die Partnerbörse besucht.
 * @author Mert
 *
 */
public class Startseite extends VerticalPanel{
	
	private VerticalPanel vpanel = new VerticalPanel();
	private FlexTable ft1 = new FlexTable();
	private HTML html1 = new HTML("<article> <h2>Die kostenlose Partnerbörse</h2> "
				+ "<section>"
				+ "<h3>Finde die Liebe deines Lebens</h3> "
				+ "<p>"
				+ "Herzlich Willkommen auf der Partnerbörse </br>"
				+ "Hier kannst du nach Herzenslust mit anderen Mitgliedern flirten ,dich zum Dating und Ausgehen verabreden oder andere Singles mit den gleichen Interessen kennen lernen.</br>"
				+ "Es warten viele spannende und neue Bekanntschaften auf dich.</br>"
				+ "Viel Spaß und viel Glück.</br> "
				+ "<p>"
				+ " </p>"
				+ "	</section>"
				+ "</article>");

	
	public Startseite(final Profil profil){
		
		ft1.setWidget(0, 1, html1);

		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}

}
