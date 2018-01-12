package de.hdm.ITProjekt17.shared;


import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

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
	
	void findbyKeyEigenschaft(int id, AsyncCallback<Eigenschaft> callback);

	void getAllEigenschaft(AsyncCallback<Vector<Eigenschaft>> callback);
//_________________________________________________________________________________________________________________________	

	void createFreitexteigenschaft(String wert, AsyncCallback<Freitexteigenschaft> callback);

	void save(Freitexteigenschaft frei, AsyncCallback<Void> callback);

	void delete(Freitexteigenschaft frei, AsyncCallback<Void> callback);
	
	void getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Vector<Info>> callback);
	
	void getAllFreitexteigenschaftOf(Info in, AsyncCallback<Vector<Freitexteigenschaft>> callback);
	
	void findByKeyFreitexteigenschaft(int id, AsyncCallback<Freitexteigenschaft> callback);

	void getAllFreitexteigenschaft(AsyncCallback<Vector<Freitexteigenschaft>> callback);
	
//_________________________________________________________________________________________________________________________
	void createInfo(Profil pro, String text, Auswahleigenschaft aus, Freitexteigenschaft frei, AsyncCallback<Info> callback);

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

	void createKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);
	
	void save(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);

	void deleteKontaktsperreOf(Profil pro, AsyncCallback<Void> callback);
	
	void findById(int id, AsyncCallback<Kontaktsperre> callback);
	
	void getAllKontaktsperreOf(Profil pro, AsyncCallback<Vector<Kontaktsperre>> callback);

	void getAllKontaktsperre(AsyncCallback<Vector<Kontaktsperre>> callback);


	


	void createMerkzettel(int profilId_gemerkter, int profilId_merkender, AsyncCallback<Merkzettel> callback);

	void save(Merkzettel merk, AsyncCallback<Void> callback);

	void deleteMerkzettel(Profil pro, AsyncCallback<Void> callback);

	void findByKey(int id, AsyncCallback<Merkzettel> callback);
	
	void getAllMerkzettelOf(Profil pro, AsyncCallback<Vector<Merkzettel>> callback);
	
	void showMerklisteOf(Profil pro, AsyncCallback<Vector<Merkzettel>> callback);
	
	
	void createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse,
			String religion, String haarfarbe, String raucher, String geschlecht, AsyncCallback<Profil> callback);

	void save(Profil pro, AsyncCallback<Profil> callback);

	void delete(Profil pro, AsyncCallback<Void> callback);

	void getProfilById(int id, AsyncCallback<Profil> callback);

	void getAllProfil(AsyncCallback<Vector<Profil>> callback);
	
	void checkProfil(String email, AsyncCallback<Profil> callback);
	
	void pruefenAufExistenz(String email, AsyncCallback<Profil> callback);
	
	
	void createSuchprofil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, String raucher, boolean geschlecht, int maxAlter, int minAlter, int profilId,
			AsyncCallback<Suchprofil> callback);

	void save(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void deleteSuchprofil(Profil pro, AsyncCallback<Void> callback);
	
	void findByKey1(int id, AsyncCallback<Suchprofil> callback);

	void getAllSuchprofil(AsyncCallback<Vector<Suchprofil>> callback);
	
	void findSuchprofilByProfilId(Profil pro, AsyncCallback<Vector<Suchprofil>> callback);

	
	void getAllSuchprofilInfos(Info in, Suchprofil such, AsyncCallback<Suchprofil_Info> callback);
	
	void getAllSuchprofilInfoOf(Info in, AsyncCallback<Vector<Suchprofil_Info>> callback);

	
	void showVisitedProfiles(Profil pro, AsyncCallback<Vector<Besuch>> callback);
	
	void deleteBesuche(Profil pro, AsyncCallback<Void> callback);
	
	void getAllBesucheOf(Profil pro, AsyncCallback<Vector<Besuch>> callback);
	
	void getUnvisitedProfiles(Profil pro, AsyncCallback<Vector<Besuch>> callback);
	
	void sperrPruefung(Profil pro, AsyncCallback<Boolean> callback);
	
	void visit(Profil pro, AsyncCallback<Void> callback);

	
	void berechneAhnlichkeitProfilProfil(Profil p1, Profil p2, AsyncCallback<Double> callback);

}
