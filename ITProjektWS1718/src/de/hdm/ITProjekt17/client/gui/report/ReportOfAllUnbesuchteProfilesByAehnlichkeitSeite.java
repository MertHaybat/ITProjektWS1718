package de.hdm.ITProjekt17.client.gui.report;



import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.report.HTMLReportWriter;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeOfProfilNichtAngesehenReport;

public class ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite extends VerticalPanel{
	private Profil profil;
	
	private VerticalPanel vpanel = new VerticalPanel();
	
	private Label infoLabel = new Label();
	private Label ueberschriftLabel = new Label();
	
	public ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite(Profil profil) {
		this.profil = profil;
		run();
	}
	
	public void run() {
		this.add(vpanel);
		ueberschriftLabel.setText("Einen Moment bitte...");
		ueberschriftLabel.addStyleName("partnerboerse-label");
		
		reportAuslesen();
		
		vpanel.add(ueberschriftLabel);
		vpanel.add(infoLabel);
		
	}
	
	public void reportAuslesen() {
		ClientsideSettings.getReportGenerator().createPartnervorschlaegeOfProfilNichtAngesehenReport(profil, new AsyncCallback<PartnervorschlaegeOfProfilNichtAngesehenReport>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(PartnervorschlaegeOfProfilNichtAngesehenReport result) {
				if(result != null) {
					HTMLReportWriter writer = new HTMLReportWriter();
					writer.process(result);
					RootPanel.get("Details").clear();
					RootPanel.get("Details").add(new HTML(writer.getReportText()));
					
				}
				
				
				
			}
		});
	}
//	private HTML h = new HTML();
//	private VerticalPanel vpanel = new VerticalPanel();
//	private FlexTable ft = new FlexTable();
//	private static ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();
//	
//	public ReportOfAllUnbesuchteProfilesByAehnlichkeitSeite(Profil profil) {
//		
//		reportverwaltung.createPartnervorschlaegeOfProfilNichtAngesehenReport(profil, new AsyncCallback<PartnervorschlaegeOfProfilNichtAngesehenReport>() {
//			
//			@Override
//			public void onSuccess(PartnervorschlaegeOfProfilNichtAngesehenReport result) {
//				if(result != null) {
//					HTMLReportWriter writer = new HTMLReportWriter();
//					Window.alert("test1");
//					writer.process(result);
//					Window.alert("test2");
//					h.setHTML(writer.getReportText());
//					Window.alert("test3");
//					vpanel.add(h);
//				}
//				
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//	}
}

