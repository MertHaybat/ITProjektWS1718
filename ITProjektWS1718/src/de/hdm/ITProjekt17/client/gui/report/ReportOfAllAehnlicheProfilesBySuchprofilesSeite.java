package de.hdm.ITProjekt17.client.gui.report;



import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.report.HTMLReportWriter;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeAnhandSuchprofilReport;



public class ReportOfAllAehnlicheProfilesBySuchprofilesSeite extends VerticalPanel{
	
	private Profil profil = null;
	
	private HTML h = new HTML();
	private VerticalPanel vpanel = new VerticalPanel();
	private HorizontalPanel auswahlPanel = new HorizontalPanel();
	private Label auswahlLabel = new Label("Wählen Sie ein Suchprofil aus, zu welchem Sie Partnervorschläge erhalten möchten.");
	private Label infoLabel = new Label();
	private ListBox auswahlListBox = new ListBox();
	private Button anzeigenButton = new Button("Partnervorschläge anzeigen");
	private FlexTable ft = new FlexTable();
	private static ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();

	public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(Profil profil) {
		this.profil = profil;
		run();
	}
	
	public void run() {
		this.add(vpanel);
		auswahlLabel.addStyleName("partnerboerse-label");
		
		suchprofileAnzeigen();
		
		anzeigenButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ClientsideSettings.getReportGenerator().createPartnervorschlaegeAnhandSuchprofilReport(profil, new AsyncCallback<PartnervorschlaegeAnhandSuchprofilReport>() {

					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(PartnervorschlaegeAnhandSuchprofilReport report) {
						if(report != null) {
							HTMLReportWriter writer = new HTMLReportWriter();
							 writer.process(report);
							 RootPanel.get("Details").clear();
							 RootPanel.get("Details").add(new ReportOfAllAehnlicheProfilesBySuchprofilesSeite(profil));
							 RootPanel.get("Details").add(new HTML(writer.getReportText()));
						}
					}
				});
				
			}
		});
		
		vpanel.add(auswahlLabel);
		auswahlPanel.add(infoLabel);
		auswahlPanel.add(auswahlListBox);
		vpanel.add(auswahlPanel);
	}
	
	public void suchprofileAnzeigen() {
		ClientsideSettings.getBoerseVerwaltung().findSuchprofilByProfilId(profil, new AsyncCallback<Vector<Suchprofil>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Vector<Suchprofil> result) {
				if(result.isEmpty()) {
					auswahlListBox.setVisible(false);
					anzeigenButton.setVisible(false);
					auswahlLabel.setText("Sie haben bisher keine Suchprofile angelegt");
				} else {
					for(Suchprofil suchpro : result) {
						auswahlListBox.addItem(suchpro.toString());
					}
				}
			}
		});
	}
	
//	public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(Profil profil){
//		
//
//		reportverwaltung.createPartnervorschlaegeAnhandSuchprofilReport(profil, new AsyncCallback<PartnervorschlaegeAnhandSuchprofilReport>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(PartnervorschlaegeAnhandSuchprofilReport result) {
//					if(result!= null){
//					HTMLReportWriter writer = new HTMLReportWriter();
//					Window.alert("hallo2");
//					writer.process(result);
//					Window.alert("hallo3");
//					h.setHTML(writer.getReportText());
//					Window.alert("hallo4");
//					vpanel.add(h);
//				}
//				
//			}
//		});
//	}
//	
		
}
	
