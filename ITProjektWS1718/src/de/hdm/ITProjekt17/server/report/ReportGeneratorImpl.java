package de.hdm.ITProjekt17.server.report;

import java.util.Date;
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
	    PartnerboerseAdministrationImpl p = new PartnerboerseAdministrationImpl();
	    p.init();
	    this.partnerboerseadministration = p;
	  }
	
	/**
	 * Auslesen zugehöriger PartnerAdministration (interner Gebrauch)
	 * @return partnerboerseadministration
	 */
	protected PartnerboerseAdministration getPartnerboerse(){
		return this.partnerboerseadministration;
	}

	@Override
	public PartnervorschlaegeOfProfilNichtAngesehenReport createPartnervorschlaegeOfProfilNichtAngesehenReport(Profil pro) throws IllegalArgumentException {
		if(this.getPartnerboerse() == null){
			return null;
		}
		Aehnlichkeitsmass score = new Aehnlichkeitsmass();
		PartnervorschlaegeOfProfilNichtAngesehenReport result = new PartnervorschlaegeOfProfilNichtAngesehenReport();
		
		result.setTitle("Alle unbesuchten Profile mit Aehnlichkeitsmass");
		
		result.setCreated(new Date());
		
		Row headline = new Row();
		headline.addColumn(new Column("Vorname"));
		headline.addColumn(new Column("Nachname"));
		headline.addColumn(new Column("Haarfarbe"));
		headline.addColumn(new Column("Religion"));
		headline.addColumn(new Column("Geschlecht"));
		headline.addColumn(new Column("Körpergröße"));
		headline.addColumn(new Column("Raucher"));
		headline.addColumn(new Column("Ähnlichkeitsmaß"));
		
		result.addRow(headline);
		Vector<Profil> unVisitedProfiles = this.partnerboerseadministration.getUnvisitedProfiles(pro);
		System.out.println(unVisitedProfiles.size());
		for(int i = 0; i<unVisitedProfiles.size(); i++){
			System.out.println(unVisitedProfiles.size() + "hadshidijasdk");
			score = this.partnerboerseadministration.createAehnlichkeit(pro.getId(), unVisitedProfiles.elementAt(i).getId());
			Row profile = new Row();
			  profile.addColumn(new Column(unVisitedProfiles.elementAt(i).getVorname()));
			  profile.addColumn(new Column(unVisitedProfiles.elementAt(i).getNachname()));
			  profile.addColumn(new Column(unVisitedProfiles.elementAt(i).getHaarfarbe()));
			  profile.addColumn(new Column(unVisitedProfiles.elementAt(i).getReligion()));
			  profile.addColumn(new Column(unVisitedProfiles.elementAt(i).getGeschlecht()));
			  profile.addColumn(new Column(String.valueOf(unVisitedProfiles.elementAt(i).getKoerpergroesse())));
			  profile.addColumn(new Column(unVisitedProfiles.elementAt(i).getRaucher()));
			  profile.addColumn(new Column(String.valueOf(score.getAehnlichkeitsindex())));
			  result.addRow(profile);
		}
		return result;

	}

	@Override
	public PartnervorschlaegeAnhandSuchprofilReport createPartnervorschlaegeAnhandSuchprofilReport(Profil pro) throws IllegalArgumentException {
		if(this.getPartnerboerse() == null){
			return null;
		}
		
		PartnervorschlaegeAnhandSuchprofilReport result = new PartnervorschlaegeAnhandSuchprofilReport();
		
		result.setTitle("Alle Profile ähnlich dem Suchprofil mit Ähnlichkeitsmaß");
		
		result.setCreated(new Date());
		Row headline = new Row();
		headline.addColumn(new Column("Vorname"));
		headline.addColumn(new Column("Nachname"));
		headline.addColumn(new Column("Haarfarbe"));
		headline.addColumn(new Column("Religion"));
		headline.addColumn(new Column("Geschlecht"));
		headline.addColumn(new Column("Körpergröße"));
		headline.addColumn(new Column("Raucher"));
		headline.addColumn(new Column("Ähnlichkeitsmaß"));
		
		result.addRow(headline);
		
		Vector<Suchprofil> allSuchProfilByProfil = this.partnerboerseadministration.findSuchprofilByProfilId(pro);
		Vector<Profil> allSimilarProfilesFromSuchprofiles = new Vector<Profil>();
		
		
		for(int i = 0; i< allSuchProfilByProfil.size(); i++){

			
			allSimilarProfilesFromSuchprofiles = 
					this.partnerboerseadministration.getAllProfilsOf(allSuchProfilByProfil.elementAt(i));
				
			for(int o = 0; o<allSimilarProfilesFromSuchprofiles.size(); o++){
				Aehnlichkeitsmass score = this.partnerboerseadministration.createAehnlichkeit(pro.getId(), allSimilarProfilesFromSuchprofiles.elementAt(o).getId());
				
				Row profile = new Row();
				  profile.addColumn(new Column(allSimilarProfilesFromSuchprofiles.elementAt(o).getVorname()));
				  profile.addColumn(new Column(allSimilarProfilesFromSuchprofiles.elementAt(o).getNachname()));
				  profile.addColumn(new Column(allSimilarProfilesFromSuchprofiles.elementAt(o).getHaarfarbe()));
				  profile.addColumn(new Column(allSimilarProfilesFromSuchprofiles.elementAt(o).getReligion()));
				  profile.addColumn(new Column(allSimilarProfilesFromSuchprofiles.elementAt(o).getGeschlecht()));
				  profile.addColumn(new Column(String.valueOf(allSimilarProfilesFromSuchprofiles.elementAt(o).getKoerpergroesse())));
				  profile.addColumn(new Column(allSimilarProfilesFromSuchprofiles.elementAt(o).getRaucher()));
				  profile.addColumn(new Column(String.valueOf(score.getAehnlichkeitsindex())));
				  result.addRow(profile);
			}
		}
		
		return result;
	}

	@Override
	public Profil checkProfil(String email) throws IllegalArgumentException {
		return partnerboerseadministration.checkProfil(email);
	}

	@Override
	public void deleteAehnlichkeitsmass(Aehnlichkeitsmass a) throws IllegalArgumentException {
		partnerboerseadministration.deleteAehnlichkeit(a);
	}

}
