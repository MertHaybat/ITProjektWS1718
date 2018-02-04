package de.hdm.ITProjekt17.shared;

/**
 * Das Async Interface der PartnerboerseAdministration deklariert die selben Methodenköpfe wie 
 * das Synchrone Interface. 
 * Es wird semiautomatisch vom Google Plugin erstellt und verwaltet.
 * Plus ein Callback-Objekt damit RPC Antworten auf der Client-Seite verarbeitet werden können.
 * 
 * @Author Fatjona Mustafi
 */
import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;
import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Besuch;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil_Info;


public interface PartnerboerseAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void createAuswahleigenschaft(String wert, AsyncCallback<Auswahleigenschaft> callback);

	void save(Auswahleigenschaft aus, AsyncCallback<Void> callback);

	void delete(Auswahleigenschaft aus, AsyncCallback<Void> callback);
	
	void getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Vector<Info>> callback);
	
	void getAllAuswahleigenschaftOf(Info in, AsyncCallback<Vector<Auswahleigenschaft>> callback);
	
	void getAllAuswahleigenschaft(AsyncCallback<Vector<Auswahleigenschaft>> callback);

	void findByKeyAuswahleigenschaft(int id, AsyncCallback<Auswahleigenschaft> callback);
//_________________________________________________________________________________________________________________________
	
//	void createEigenschaft(int eigenschaftid, AsyncCallback<Eigenschaft> callback);

	void save(Eigenschaft eig, AsyncCallback<Void> callback);

	void delete(Eigenschaft eig, AsyncCallback<Void> callback);
	
//	void findbyKeyEigenschaft(int id, AsyncCallback<Eigenschaft> callback);
//
//	void getAllEigenschaft(AsyncCallback<Vector<Eigenschaft>> callback);
//_________________________________________________________________________________________________________________________	

	void createFreitexteigenschaft(String wert, AsyncCallback<Freitexteigenschaft> callback);

	void save(Freitexteigenschaft frei, AsyncCallback<Void> callback);

	void delete(Freitexteigenschaft frei, AsyncCallback<Void> callback);
	
	void getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Vector<Info>> callback);
	
	void getAllFreitexteigenschaftOf(Info in, AsyncCallback<Vector<Freitexteigenschaft>> callback);
	
	void findByKeyFreitexteigenschaft(int id, AsyncCallback<Freitexteigenschaft> callback);

	void getAllFreitexteigenschaft(AsyncCallback<Vector<Freitexteigenschaft>> callback);
	
	void createInfo(String email, Integer auswahleigenschaftid, String freitexteigenschaftwert, String auswahleigenschaftwert, AsyncCallback<Info> asyncCallback);

	void save(Info in, AsyncCallback<Void> callback);

	void delete(Info in, AsyncCallback<Void> callback);
	
	void deleteInfoOf(Profil pro, AsyncCallback<Void> callback);
	
	void deleteInfoOf(Suchprofil_Info suchinfo, AsyncCallback<Void> callback);
	
	void deleteInfoAs(Auswahleigenschaft aus, AsyncCallback<Void> callback);
	
	void deleteInfoAs(Freitexteigenschaft frei, AsyncCallback<Void> callback);
	
	void getAllInfosOf(Profil pro, AsyncCallback<Vector<Profil>> callback);
	
	void findByKeyInfo(int id, AsyncCallback<Info> callback);

	void getAllInfo(AsyncCallback<Vector<Info>> callback);
	
	void getAllInfobyProfil(Profil pro, AsyncCallback<Vector<Info>> callback);
	
	void getInfoIdByProfilId(Profil pro, AsyncCallback<Vector<Info>> callback);
//	doppelt?
//_________________________________________________________________________________________________________________________

	void createKontaktsperre(Profil pro, int profilId_gesperrter, AsyncCallback<Kontaktsperre> callback);
	
	void save(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);

	void deleteKontaktsperreOf(Profil pro, int profilId_gesperrter, AsyncCallback<Void> callback);
	
	void showBlockedProfilsOf(Profil pro, AsyncCallback<Vector<Profil>> callback);

	void showAllBlockerOf(Profil pro, AsyncCallback<Vector<Profil>> callback);
	
	void findById(int id, AsyncCallback<Kontaktsperre> callback);
	
	void getAllKontaktsperreOf(Profil pro, AsyncCallback<Vector<Kontaktsperre>> callback);

	void getAllKontaktsperre(AsyncCallback<Vector<Kontaktsperre>> callback);
	
	void delete(Kontaktsperre sperre, AsyncCallback<Void> callback);

	//_________________________________________________________________________________________________________________________
	
	void createMerkzettel(Profil pro, int profilId_gemerkter, AsyncCallback<Merkzettel> callback);

	void save(Merkzettel merk, AsyncCallback<Void> callback);

	void deleteProfilVonMerkliste(Profil pro, int profilId_gemerkter, AsyncCallback<Void> callback);

	void findByKey(int id, AsyncCallback<Merkzettel> callback);
	
	void getAllMerkzettelOf(Profil pro, AsyncCallback<Vector<Merkzettel>> callback);
	
	void showMerklisteOf(Profil pro, AsyncCallback<Vector<Profil>> callback);
	
	void delete(Merkzettel merk, AsyncCallback<Void> callback);
	
	//_________________________________________________________________________________________________________________________
	
	void createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse,
			String religion, String haarfarbe, String raucher, String geschlecht, AsyncCallback<Profil> callback);

	void save(Profil pro, AsyncCallback<Void> callback);

	void delete(Profil pro, AsyncCallback<Void> callback);

	void getProfilById(int id, AsyncCallback<Profil> callback);

	void getAllProfil(AsyncCallback<Vector<Profil>> callback);
	
	void checkProfil(String email, AsyncCallback<Profil> callback);
	
	void pruefenAufExistenz(String email, AsyncCallback<Profil> callback);
	
		
	void createSuchprofil(String haarfarbe, String religion, int körpergröße,
			String raucher, String geschlecht, int minalter, int maxalter, int profilId, AsyncCallback<Suchprofil> callback);

	void save(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void deleteSuchprofil(Suchprofil pro, AsyncCallback<Void> callback);
	
	void findByKey1(int id, AsyncCallback<Suchprofil> callback);

	void getAllSuchprofil(AsyncCallback<Vector<Suchprofil>> callback);
	
	void findSuchprofilByProfilId(Profil pro, AsyncCallback<Vector<Suchprofil>> callback);


	//_________________________________________________________________________________________________________________________
	
	void showVisitedProfiles(Profil pro, AsyncCallback<Vector<Besuch>> callback);
	
	void deleteBesuche(Profil pro, int besuchterNutzerID, AsyncCallback<Void> callback);
	
	void getAllBesucheOf(Profil pro, AsyncCallback<Vector<Besuch>> callback);
	
	void getUnvisitedProfiles(Profil pro, AsyncCallback<Vector<Profil>> callback);
	
	void sperrPruefung(Profil pro, AsyncCallback<Boolean> callback);

	//_________________________________________________________________________________________________________________________
	
	void berechneAhnlichkeitProfilProfil(Profil p1, Profil p2, AsyncCallback<Double> callback);

	void createAehnlichkeit(int eigenes_profil, int fremdes_profil, AsyncCallback<Aehnlichkeitsmass> callback);

	void findAehnlichkeitByProfilid(int id, AsyncCallback<Aehnlichkeitsmass> callback);

	void showAllAehnlichkeitByProfil(AsyncCallback<Vector<Aehnlichkeitsmass>> callback);

	void deleteAehnlichkeit(Aehnlichkeitsmass a, AsyncCallback<Void> callback);
	
	void getAehnlicheUnbesuchteProfileVon(Profil pro, AsyncCallback<Vector<Aehnlichkeitsmass>> callback);

	void getAehnlicheProfileVonSuchprofilen(Profil pro, AsyncCallback<Vector<Aehnlichkeitsmass>> callback);

	void getAllProfilsOf(Profil pro, Suchprofil suchpro, AsyncCallback<Vector<Profil>> callback);

	void delete(Suchprofil suchpro, AsyncCallback<Void> callback);

	void getAllProfilesByInfoOf(Suchprofil suchpro, AsyncCallback<Vector<Profil>> callback);

	void showBesuchteOf(Profil pro, AsyncCallback<Vector<Profil>> callback);

	void visit(int eigene_id, int fremde_id, AsyncCallback<Besuch> callback);

	void showBesucherOf(Profil pro, AsyncCallback<Vector<Profil>> callback);

	void showMerkendeOf(Profil pro, AsyncCallback<Vector<Profil>> callback);

	void getBlockedBy(Profil pro, AsyncCallback<Vector<Kontaktsperre>> callback);



}
