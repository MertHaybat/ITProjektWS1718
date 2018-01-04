package de.hdm.ITProjekt17.shared;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.report.AllInfosOfProfilReport;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeAnhandSuchprofilReport;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeOfProfilNichtAngesehenReport;

/**
 * Synchrones Interface für RPC fähige Klasse von Reports.
 * Gleiche Realisierungsgrundlage wie PartnerboerseAdministrationImpl, PartnerboerseAdrministrationAsync und PartnerboerseAdrministration.
 * ReportGenerator erstellt berichte für den User / Ähnlichkeitsmaß der Partnerprofile.
 * @author Thies
 *
 */
public interface ReportGenerator extends RemoteService {
	
	/**
	   * Initialisierung des Objekts. Diese Methode ist vor dem Hintergrund von GWT
	   * RPC zusätzlich zum No Argument Constructor der implementierenden Klasse
	   *BankAdministrationImpltungImpl} notwendig. Bitte diese Methode direkt nach der
	   * Instantiierung aufrufen.
	   * 
	   * @throws IllegalArgumentException
	   */
	public void init() throws IllegalArgumentException;
	
	/**
	 * Diese Methode sucht alle Informationen eines Porfils und gibt diese zurück.
	 * @param pro
	 * @return
	 * @throws IllegalArgumentException
	 */
	 public abstract  AllInfosOfProfilReport createAllInfosOfProfilReport(Profil pro, int score) throws IllegalArgumentException;
	 
	 /**
	  * Diese Methode sucht alle vom Profil/Teilnehmer nicht angesehenen Profile und zeigt diese an.
	  * @param pro
	  * @return
	  * @throws IllegalArgumentException
	  */
	 public abstract PartnervorschlaegeOfProfilNichtAngesehenReport createPartnervorschlaegeOfProfilNichtAngesehenReport(Profil pro) throws IllegalArgumentException;
	 
	 /**
	  * Diese Mehtode sucht alle Partnervorschläge anhand des Suchprofils des Teilnehmers der Partnerbörse und gibt diese zurück.
	  * @param pro
	  * @param such
	  * @return
	  * @throws IllegalArgumentException
	  */
	 public abstract PartnervorschlaegeAnhandSuchprofilReport createPartnervorschlaegeAnhandSuchprofilReport(Profil pro, Suchprofil such) throws IllegalArgumentException;

}
