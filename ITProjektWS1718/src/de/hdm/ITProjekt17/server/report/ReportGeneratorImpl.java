package de.hdm.ITProjekt17.server.report;

import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.ITProjekt17.server.PartnerboerseAdministrationImpl;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministration;
import de.hdm.ITProjekt17.shared.ReportGenerator;
import de.hdm.ITProjekt17.shared.bo.*;
import de.hdm.ITProjekt17.shared.report.*;

/**
 * Implementierung des ReportGenerator Interfaces.
 * Technische Relaisierung wie bei PartnerboerseAdministrationImpl (RPC-FÃ¤higkeit fÃ¼r Ãœbermittlung zwischen CLient und Server)
 * @author Dennis Lehle
 *
 */
@SuppressWarnings("serial")
public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator{
	
	/**
	 * Der ReportGenerator benÃ¶tigt Zugriff auf die PartnerboerseAdministrations Klasse,
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
	 * Initialisierungemethode -> Schau ErklÃ¤rung ReportGeneratorImpl.
	 */
	public void init() throws IllegalArgumentException {
	    /*
	     * Ein ReportGeneratorImpl-Objekt instantiiert fÃ¼r seinen Eigenbedarf eine
	     * PartnerboerseAdministrationImpl-Instanz.
	     */
	    PartnerboerseAdministrationImpl a = new PartnerboerseAdministrationImpl();
	    a.init();
	    this.partnerboerseadministration = a;
	  }
	
	/**
	 * Auslesen zugehöriger PartnerAdministration (interner Gebrauch)
	 * @return partnerboerseadministration
	 */
	protected PartnerboerseAdministration getPartnerboerse(){
		return this.partnerboerseadministration;
	}
	
	
	
	//---------Nicht-implementierte-Mehtoden-des-ReportGenerator-Interfaces-auf-der-Client-Seite----------

	@Override
	public AllInfosOfProfilReport createAllInfosOfProfilReport(Profil pro, int score) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (this.getPartnerboerse() == null){
			return null;
		}
		
		AllInfosOfProfilReport result = new AllInfosOfProfilReport();
		
		String scoreString = Integer.toString(score);
		
		Row topRow = new Row();
		topRow.addColumn(new Column(pro.getVorname() + " " + pro.getNachname()));
		topRow.addColumn(new Column(scoreString));
		
//		Auslesen sämtlicher Pflichattribute
		Row emailRow = new Row();
		emailRow.addColumn(new Column("Email"));
		emailRow.addColumn(new Column(pro.getEmail()));
		Row geburtsdatumRow = new Row();
		geburtsdatumRow.addColumn(new Column("Geburtsdatum"));
		geburtsdatumRow.addColumn(new Column(String.valueOf(pro.getGeburtsdatum())));
		Row koerpergroesseRow = new Row();
		koerpergroesseRow.addColumn(new Column("Körpergröße"));
		koerpergroesseRow.addColumn(new Column(String.valueOf(pro.getKoerpergroesse())));
		Row geschlechtRow = new Row();
		geschlechtRow.addColumn(new Column("Geschlecht"));
		geschlechtRow.addColumn(new Column(String.valueOf(pro.getGeschlecht())));
		Row haarfarbeRow = new Row();
		haarfarbeRow.addColumn(new Column("Haarfarbe"));
		haarfarbeRow.addColumn(new Column(pro.getHaarfarbe()));
		Row religionRow = new Row();
		religionRow.addColumn(new Column("Religion"));
		religionRow.addColumn(new Column(pro.getReligion()));
		Row raucherRow = new Row();
		raucherRow.addColumn(new Column("Raucher"));
		raucherRow.addColumn(new Column(pro.getRaucher()));
		
		result.addRow(emailRow);
		result.addRow(geburtsdatumRow);
		result.addRow(koerpergroesseRow);
		result.addRow(geschlechtRow);
		result.addRow(haarfarbeRow);
		result.addRow(religionRow);
		result.addRow(raucherRow);
		return null;
		
		/** Auslesen aller Infos des Profils
		 * 
		 */
		
//		Vector <Info> allInfos = partnerboerseadministration.getAllInfobyProfilid(pro);
		
//		Vector<Info> infos = partnerboerseadministration.;
	}

	@Override
	public PartnervorschlaegeOfProfilNichtAngesehenReport createPartnervorschlaegeOfProfilNichtAngesehenReport(Profil pro) throws IllegalArgumentException {
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
