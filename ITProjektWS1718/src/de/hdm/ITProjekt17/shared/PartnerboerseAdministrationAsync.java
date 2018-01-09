package de.hdm.ITProjekt17.shared;


import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;


public interface PartnerboerseAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void createAuswahleigenschaft(String wert, AsyncCallback<Auswahleigenschaft> callback);

	void save(Auswahleigenschaft aus, AsyncCallback<Void> callback);

	void delete(Auswahleigenschaft aus, AsyncCallback<Void> callback);
	
	void getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Vector<Info>> callback);
	
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
	
	void findByKeyFreitexteigenschaft(int id, AsyncCallback<Freitexteigenschaft> callback);

	void getAllFreitexteigenschaft(AsyncCallback<Vector<Freitexteigenschaft>> callback);
	
//_________________________________________________________________________________________________________________________
	void createInfo(int profilid, String text, int eigenschaftid, AsyncCallback<Info> callback);

	void save(Info in, AsyncCallback<Void> callback);

	void delete(Info in, AsyncCallback<Void> callback);
	
	void findByKeyInfo(int id, AsyncCallback<Info> callback);

	void getAllInfo(AsyncCallback<Vector<Info>> callback);
	
	void getAllInfobyProfil(Profil pro, AsyncCallback<Vector<Info>> callback);
	
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
	
void createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse,
			String religion, String haarfarbe, boolean raucher, boolean geschlecht, AsyncCallback<Profil> callback);

	
	/////
//	void save(Profil pro, AsyncCallback<Profil> callback);

	void deleteProfil(int profilid, AsyncCallback<Void> callback);

	void getProfilById(int id, AsyncCallback<Profil> callback);

	void getAllProfil(AsyncCallback<Vector<Profil>> callback);
	
void createSuchprofil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher, boolean geschlecht, int maxAlter, int minAlter, int profilId,
			AsyncCallback<Suchprofil> callback);

	void save(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void deleteSuchprofil(int profilid, AsyncCallback<Void> callback);
	
	void findByKey1(int id, AsyncCallback<Suchprofil> callback);

	void getAllSuchprofil(AsyncCallback<Vector<Suchprofil>> callback);

	
	void getSuchprofilbyProfilId(int profilid, AsyncCallback<Vector<Suchprofil>> callback);

	void getInfoIdByProfilId(int profilid, AsyncCallback<Vector<Info>> callback);

	void saveProfil(String email, boolean geschlecht, String vorname, String nachname, Date geburtsdatum, int koerpergroesse,
			String religion, String haarfarbe, boolean raucher, AsyncCallback<Profil> callback);

	
	
	
	
	

	

	void checkProfil(String email, AsyncCallback<Profil> callback);

	void berechneAhnlichkeitProfilProfil(Profil p1, Profil p2, AsyncCallback<Double> callback);

	

	




}
