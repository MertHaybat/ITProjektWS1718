package de.hdm.ITProjekt17.client.gui.report;



import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.report.HTMLReportWriter;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeOfProfilNichtAngesehenReport;

public class ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite extends VerticalPanel{
	private HTML h = new HTML();
	private VerticalPanel vpanel = new VerticalPanel();
	private FlexTable ft = new FlexTable();
	private static ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();
	
	public ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite(Profil profil) {
		
		reportverwaltung.createPartnervorschlaegeOfProfilNichtAngesehenReport(profil, new AsyncCallback<PartnervorschlaegeOfProfilNichtAngesehenReport>() {
			
			@Override
			public void onSuccess(PartnervorschlaegeOfProfilNichtAngesehenReport result) {
				if(result != null) {
					HTMLReportWriter writer = new HTMLReportWriter();
					Window.alert("test1");
					writer.process(result);
					Window.alert("test2");
					h.setHTML(writer.getReportText());
					Window.alert("test3");
					vpanel.add(h);
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

