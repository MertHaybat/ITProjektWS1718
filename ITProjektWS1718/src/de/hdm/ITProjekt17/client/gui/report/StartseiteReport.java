package de.hdm.ITProjekt17.client.gui.report;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

public class StartseiteReport extends VerticalPanel{
	
	private VerticalPanel vpanel = new VerticalPanel();
	private FlexTable ft1 = new FlexTable();
	private HTML html1 = new HTML("<article> <h2>Report der Partnerbörse</h2> "
				+ "<section>"
				+ "<h3>Ausgabe der Reports</h3> "
				+ "<p>"
				+ "Herzlich Willkommen auf der Report-Startseite der Partnerbörse </br>"
				+ "Hier kannst du deine Reports für verschiedene Anforderungen ausgeben lassen.</br>"
				+ "Dabei bestehen die Möglichkeiten, drei Reports nach Belieben ausgeben zu lassen.</br>"
				+ "Zu diesen Reports gehören:</br>"
				+ "- die Ausgabe aller Profile.</br>"
				+ "- die Ausgabe aller unbesuchten Profile, die dem eigenen Profil ähnlich sind.</br>"
				+ "- die Ausgabe aller Profile, die den angelegten Suchprofilen ähnlich sind."
				+ "<p>"
				+ "Falls du Fragen zur Funktion hast oder Support benötigst, kannst du unsere Kontaktdaten im Impressum finden. </p>"
				+ "	</section>"
				+ "</article>");

	
	public StartseiteReport(final Profil profil){
		
		ft1.setWidget(0, 1, html1);

		
		vpanel.add(ft1);
		this.add(vpanel);
		
	}

}
