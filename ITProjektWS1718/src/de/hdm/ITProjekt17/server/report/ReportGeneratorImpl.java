package de.hdm.ITProjekt17.server.report;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.ITProjekt17.server.PartnerboerseAdministrationImpl;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministration;
import de.hdm.ITProjekt17.shared.ReportGenerator;
import de.hdm.ITProjekt17.shared.bo.*;
import de.hdm.ITProjekt17.shared.report.*;

/**
 * Implementierung des ReportGenerator Interfaces.
 * Technische Relaisierung wie bei PartnerboerseAdministrationImpl (RPC-Fähigkeit für Übermittlung zwischen CLient und Server)
 * @author Dennis Lehle
 *
 */
public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator{
	
	/**
	 * Der ReportGenerator benötigt Zugriff auf die PartnerboerseAdministrations Klasse,
	 * weil diese den Zugriff auf die BusinesObjekte hat.
	 */
	private PartnerboerseAdministration partnerboerseadministration = null;
	
	/**
	 * Da ein RemoteServiceServlet durch GWT GWT.create(Klassenname.class) CLient-Seitig erstellt wird.
	 * Dazu wird ein No Argument Constructor erstellt und nach hinein eine extra Instanz die Client-Seitig nach 
	 * GWT.create(Klassenname.class) aufgerufen wird.
	 * 
	 * @throws IllegalArgumentException
	 */
	public ReportGeneratorImpl() throws IllegalArgumentException {
	  }
	
	/**
	 * Initialisierungemethode -> Schau Erklärung ReportGeneratorImpl.
	 */
	public void init() throws IllegalArgumentException {
	    /*
	     * Ein ReportGeneratorImpl-Objekt instantiiert für seinen Eigenbedarf eine
	     * PartnerboerseAdministrationImpl-Instanz.
	     */
	    PartnerboerseAdministrationImpl a = new PartnerboerseAdministrationImpl();
	    a.init();
	    this.partnerboerseadministration = a;
	  }
	
	
	
	
	
	//---------Nicht-implementierte-Mehtoden-des-ReportGenerator-Interfaces-auf-der-Client-Seite----------

	@Override
	public AllInfosOfProfilReport createAllInfosOfProfilReport(Profil pro) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartnervorschlaegeOfProfilNichtAngesehenReport createPartnervorschlaegeOfProfilNichtAngesehenReport(
			Profil pro) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartnervorschlaegeAnhandSuchprofilReport createPartnervorschlaegeAnhandSuchprofilReport(Profil pro,
			Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}


}
