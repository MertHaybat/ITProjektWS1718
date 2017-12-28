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

	void createAuswahleigenschaft(String wert, int eigenschaftid, AsyncCallback<Auswahleigenschaft> callback);

	void save(Auswahleigenschaft aus, AsyncCallback<Void> callback);

	void delete(Auswahleigenschaft aus, AsyncCallback<Void> callback);
	
	void getAllAuswahleigenschaft(AsyncCallback<Vector<Auswahleigenschaft>> callback);

	void findByKeyAuswahleigenschaft(int id, AsyncCallback<Auswahleigenschaft> callback);
//_________________________________________________________________________________________________________________________
	
	void createEigenschaft(int eigenschaftid, AsyncCallback<Eigenschaft> callback);

	void save(Eigenschaft eig, AsyncCallback<Void> callback);

	void delete(Eigenschaft eig, AsyncCallback<Void> callback);
	
	void findbyKeyEigenschaft(int id, AsyncCallback<Eigenschaft> callback);

	void getAllEigenschaft(AsyncCallback<Vector<Eigenschaft>> callback);
//_________________________________________________________________________________________________________________________	

	void createFreitexteigenschaft(String wert, int eigenschaftid, AsyncCallback<Freitexteigenschaft> callback);

	void save(Freitexteigenschaft frei, AsyncCallback<Void> callback);

	void delete(Freitexteigenschaft frei, AsyncCallback<Void> callback);
	
	void findByKeyFreitexteigenschaft(int id, AsyncCallback<Freitexteigenschaft> callback);

	void getAllFreitexteigenschaft(AsyncCallback<Vector<Freitexteigenschaft>> callback);
	
//_________________________________________________________________________________________________________________________
	void createInfo(int profilid, String text, int eigenschaftid, AsyncCallback<Info> callback);

	void save(Info in, AsyncCallback<Void> callback);

	void delete(Info in, AsyncCallback<Void> callback);
	
	void findByKeyInfo(int id, AsyncCallback<Info> callback);

	void getAllInfo(AsyncCallback<Vector<Info>> callback);
	
//_________________________________________________________________________________________________________________________

	void insertKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);
	
	void updateKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);

	void deleteKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);
	
	void findById(int id, AsyncCallback<Kontaktsperre> callback);
	
	void getAllKontaktsperre(AsyncCallback<Vector<Kontaktsperre>> callback);


//_________________________________________________________________________________________________________________________
	void insertMerkzettel(Merkzettel merk, AsyncCallback<Merkzettel> callback);

	void updateMerkzettel(Merkzettel merk, AsyncCallback<Merkzettel> callback);

	void deleteMerkzettel(Merkzettel merk, AsyncCallback<Merkzettel> callback);

	void findByKey(int id, AsyncCallback<Merkzettel> callback);
	
	void getAllMerkzettel(AsyncCallback<Vector<Merkzettel>> callback);
	
//_________________________________________________________________________________________________________________________
	void insertProfil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher, AsyncCallback<Profil> callback);

	void updateProfil(Profil pro, AsyncCallback<Profil> callback);

	void deleteProfil(Profil pro, AsyncCallback<Profil> callback);

	void getProfilById(int id, AsyncCallback<Profil> callback);

	void getAllProfil(AsyncCallback<Vector<Profil>> callback);
	
//_________________________________________________________________________________________________________________________
	void insertSuchprofil(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void updateSuchprofil(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void deleteSuchprofil(Suchprofil such, AsyncCallback<Suchprofil> callback);
	
	void findByKey1(int id, AsyncCallback<Suchprofil> callback);

	void getAllSuchprofil(AsyncCallback<Vector<Suchprofil>> callback);

}
