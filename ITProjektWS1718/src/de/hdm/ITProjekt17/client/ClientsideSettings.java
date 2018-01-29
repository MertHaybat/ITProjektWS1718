package de.hdm.ITProjekt17.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt17.shared.*;

public class ClientsideSettings extends CommonSettings{
	
	private static PartnerboerseAdministrationAsync boerseVerwaltung = null;
	
	private static ReportGeneratorAsync reportGenerator = null;
	
	/**
	 * Name des Client-seitigen Loggers.
	 */
	private static final String LOGGER_NAME = "Partnerbörse Web Client";
	/**
	 * Instanz des Client-seitigen Loggers.
	 */
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
	public static Logger getLogger() {
		return log;
	}
	
	public static PartnerboerseAdministrationAsync getBoerseVerwaltung(){
		
		if (boerseVerwaltung == null){
			
			boerseVerwaltung = GWT.create(PartnerboerseAdministration.class);
		}
		return boerseVerwaltung;
	}
	
	 public static ReportGeneratorAsync getReportGenerator(){
			
			//Falls bis jetzt noch keine ReportGenerator Instanz bestand
			if(reportGenerator == null){
				reportGenerator = GWT.create(ReportGenerator.class);
				
				
				reportGenerator.init(new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
					
					}

					@Override
					public void onSuccess(Void result) {				
					}
				});
			}
			return reportGenerator;
	  }
	
}
