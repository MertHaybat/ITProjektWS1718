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

	void insertAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Auswahleigenschaft> callback);

	void updateAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Auswahleigenschaft> callback);

	void deleteAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Auswahleigenschaft> callback);
//_________________________________________________________________________________________________________________________
	
	void insertEigenschaft(Eigenschaft eig, AsyncCallback<Eigenschaft> callback);

	void updateEigenschaft(Eigenschaft eig, AsyncCallback<Eigenschaft> callback);

	void deleteEigenschaft(Eigenschaft eig, AsyncCallback<Eigenschaft> callback);
//_________________________________________________________________________________________________________________________	

	void insertFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Freitexteigenschaft> callback);

	void updateFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Freitexteigenschaft> callback);

	void deleteFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Freitexteigenschaft> callback);
	
//_________________________________________________________________________________________________________________________
	void insertInfo(Info in, AsyncCallback<Info> callback);

	void updateInfo(Info in, AsyncCallback<Info> callback);

	void deleteInfo(Info in, AsyncCallback<Info> callback);
	
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
