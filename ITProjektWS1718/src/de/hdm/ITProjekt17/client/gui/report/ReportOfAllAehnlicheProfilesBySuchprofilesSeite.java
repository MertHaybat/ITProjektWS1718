package de.hdm.ITProjekt17.client.gui.report;



import java.util.Vector;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.report.HTMLReportWriter;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeAnhandSuchprofilReport;



public class ReportOfAllAehnlicheProfilesBySuchprofilesSeite extends VerticalPanel{
	private HTML h = new HTML();
	private VerticalPanel vpanel = new VerticalPanel();
	private FlexTable ft = new FlexTable();
	private static ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();

	public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(Profil profil){
		

		reportverwaltung.createPartnervorschlaegeAnhandSuchprofilReport(profil, new AsyncCallback<PartnervorschlaegeAnhandSuchprofilReport>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(PartnervorschlaegeAnhandSuchprofilReport result) {
					if(result!= null){
					HTMLReportWriter writer = new HTMLReportWriter();
					Window.alert("hallo2");
					writer.process(result);
					Window.alert("hallo3");
					h.setHTML(writer.getReportText());
					Window.alert("hallo4");
					vpanel.add(h);
				}
				
			}
		});
	}
	
		
}
	
