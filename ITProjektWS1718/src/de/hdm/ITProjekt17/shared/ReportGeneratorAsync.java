package de.hdm.ITProjekt17.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.report.AllInfosOfProfilReport;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeAnhandSuchprofilReport;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeOfProfilNichtAngesehenReport;

/**
 * Das Gegenstück zu Synchronen Interface ReportGenerator.
 * Wird vom Google Plugin semiautomatisch erstellt und verwalter/gepflegt.
 * 
 * @author Dennis Lehle
 *
 */
public interface ReportGeneratorAsync {

	void init(AsyncCallback<Void> callback);

//	void createAllInfosOfProfilReport(Profil pro, int score, AsyncCallback<AllInfosOfProfilReport> callback);

	void createPartnervorschlaegeOfProfilNichtAngesehenReport(Profil pro,
			AsyncCallback<PartnervorschlaegeOfProfilNichtAngesehenReport> callback);

	void createPartnervorschlaegeAnhandSuchprofilReport(Profil pro,
			AsyncCallback<PartnervorschlaegeAnhandSuchprofilReport> callback);

	void checkProfil(String email, AsyncCallback<Profil> callback);

	void deleteAehnlichkeitsmass(Aehnlichkeitsmass a, AsyncCallback<Void> callback);

}
