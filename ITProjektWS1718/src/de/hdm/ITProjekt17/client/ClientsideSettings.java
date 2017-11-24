package de.hdm.ITProjekt17.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt17.shared.*;

public class ClientsideSettings extends CommonSettings{
	
	private static PartnerboerseAdministrationAsync boerseVerwaltung = null;
	
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
	
}
