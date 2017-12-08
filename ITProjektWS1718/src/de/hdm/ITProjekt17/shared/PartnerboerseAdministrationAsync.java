package de.hdm.ITProjekt17.shared;

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

	void getProfilById(int id, AsyncCallback<Profil> callback);

	void insertAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Auswahleigenschaft> callback);

	void updateAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Auswahleigenschaft> callback);

	void deleteAuswahleigenschaft(Auswahleigenschaft aus, AsyncCallback<Auswahleigenschaft> callback);
	
	void insertEigenschaft(Eigenschaft e, AsyncCallback<Eigenschaft> callback);

	void updateEigenschaft(Eigenschaft e, AsyncCallback<Eigenschaft> callback);

	void deleteEigenschaft(Eigenschaft e, AsyncCallback<Eigenschaft> callback);

	void insertFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Freitexteigenschaft> callback);

	void updateFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Freitexteigenschaft> callback);

	void deleteFreitexteigenschaft(Freitexteigenschaft frei, AsyncCallback<Freitexteigenschaft> callback);

	void insertInfo(Info info, AsyncCallback<Info> callback);

	void updateInfo(Info info, AsyncCallback<Info> callback);

	void deleteInfo(Info info, AsyncCallback<Info> callback);

	void insertKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);

	void updateKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);

	void deleteKontaktsperre(Kontaktsperre k, AsyncCallback<Kontaktsperre> callback);

	void insertMerkzettel(Merkzettel merk, AsyncCallback<Merkzettel> callback);

	void updateMerkzettel(Merkzettel merk, AsyncCallback<Merkzettel> callback);

	void deleteMerkzettel(Merkzettel merk, AsyncCallback<Merkzettel> callback);

	void insertProfil(Profil pro, AsyncCallback<Profil> callback);

	void updateProfil(Profil pro, AsyncCallback<Profil> callback);

	void deleteProfil(Profil pro, AsyncCallback<Profil> callback);

	void insertSuchprofil(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void updateSuchprofil(Suchprofil such, AsyncCallback<Suchprofil> callback);

	void deleteSuchprofil(Suchprofil such, AsyncCallback<Suchprofil> callback);

}
