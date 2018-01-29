package de.hdm.ITProjekt17.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.ITProjekt17.shared.bo.*;

@RemoteServiceRelativePath("partnerboerseadministration")
public interface PartnerboerseAdministration extends RemoteService {
	public void init() throws IllegalArgumentException;
	
	/**
	 * Suchen eines Profil-Objekts, dessen ID aus der Datenbank bekannt.
	 * Wird nicht implementiert in die GUI!
	 * 
	 * @param id in der Datenbank.
	 * @return Das erste Profil-Objekt, dass den Suchkriterien entspricht.
	 * @throws IllegalArgumentException
	 */
	
	public Aehnlichkeitsmass createAehnlichkeit(int eigenes_profil, int fremdes_profil) throws IllegalArgumentException;
	public void deleteAehnlichkeit(Aehnlichkeitsmass a) throws IllegalArgumentException;
	public Aehnlichkeitsmass findAehnlichkeitByProfilid(int id) throws IllegalArgumentException;
	public Vector<Aehnlichkeitsmass> showAllAehnlichkeitByProfil() throws IllegalArgumentException;
	public Vector<Aehnlichkeitsmass> getAehnlicheUnbesuchteProfileVon(Profil pro) throws IllegalArgumentException;
	public Vector<Aehnlichkeitsmass> getAehnlicheProfileVonSuchprofilen(Profil pro) throws IllegalArgumentException;
	
	public Auswahleigenschaft createAuswahleigenschaft(String wert) throws IllegalArgumentException;
	public void save(Auswahleigenschaft aus) throws IllegalArgumentException;
	public void delete(Auswahleigenschaft aus) throws IllegalArgumentException;
	public Vector<Info> getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus);
	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) throws IllegalArgumentException;
	public Vector <Auswahleigenschaft> getAllAuswahleigenschaft() throws IllegalArgumentException; 
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaftOf(Info in) throws IllegalArgumentException;
	
//	public Eigenschaft createEigenschaft(int eigenschaftid) throws IllegalArgumentException;
	public void save(Eigenschaft eig) throws IllegalArgumentException;
	public void delete(Eigenschaft eig) throws IllegalArgumentException;
//	public Eigenschaft findbyKeyEigenschaft(int id) throws IllegalArgumentException;
//	public Vector <Eigenschaft> getAllEigenschaft() throws IllegalArgumentException;
	
	public Freitexteigenschaft createFreitexteigenschaft(String wert) throws IllegalArgumentException;
	public void save(Freitexteigenschaft frei) throws IllegalArgumentException;
	public void delete(Freitexteigenschaft frei) throws IllegalArgumentException;
	public Vector<Info> getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei);
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaftOf(Info in) throws IllegalArgumentException;
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) throws IllegalArgumentException;
	public Vector <Freitexteigenschaft> getAllFreitexteigenschaft() throws IllegalArgumentException;
	
	public Info createInfo(String email, Integer auswahleigenschaftid, String freitexteigenschaftwert, String auswahleigenschaftwert) throws IllegalArgumentException;
	public void save(Info in) throws IllegalArgumentException;
	public void delete(Info in) throws IllegalArgumentException;
	public void deleteInfoOf(Profil pro) throws IllegalArgumentException;
	public void deleteInfoOf(Suchprofil_Info suchinfo) throws IllegalArgumentException;
	public void deleteInfoAs(Auswahleigenschaft aus) throws IllegalArgumentException;
	public void deleteInfoAs(Freitexteigenschaft frei) throws IllegalArgumentException;
	public Vector<Profil> getAllInfosOf(Profil pro) throws IllegalArgumentException;
	public Info findByKeyInfo(int id) throws IllegalArgumentException;
	public Vector<Info> getAllInfo() throws IllegalArgumentException;
	public Vector<Info> getAllInfobyProfil(Profil pro) throws IllegalArgumentException; 
	
	public Kontaktsperre createKontaktsperre(Profil pro, int profilId_gesperrter) throws IllegalArgumentException;
	public Kontaktsperre save(Kontaktsperre k) throws IllegalArgumentException;
	public void deleteKontaktsperreOf(Profil pro, int profilId_gesperrter) throws IllegalArgumentException;
	public Vector<Profil> showBlockedProfilsOf(Profil pro) throws IllegalArgumentException;
	public Vector<Profil> showAllBlockerOf(Profil pro) throws IllegalArgumentException;
	public Kontaktsperre findById (int id) throws IllegalArgumentException;
	public Vector <Kontaktsperre> getAllKontaktsperre()throws IllegalArgumentException;
	public Vector<Kontaktsperre> getAllKontaktsperreOf(Profil pro) throws IllegalArgumentException;
	public void delete(Kontaktsperre sperre) throws IllegalArgumentException;

	public Merkzettel createMerkzettel(Profil pro, int profilId_gemerkter) throws IllegalArgumentException;
	public void save(Merkzettel merk) throws IllegalArgumentException;
	public Merkzettel findByKey (int id) throws IllegalArgumentException; 
	public Vector<Merkzettel> getAllMerkzettelOf(Profil pro) throws IllegalArgumentException;
	public void deleteProfilVonMerkliste(Profil pro, int profilId_gemerkter) throws IllegalArgumentException;
	public Vector<Profil> showMerklisteOf(Profil pro) throws IllegalArgumentException;
	public void delete(Merkzettel merk) throws IllegalArgumentException;
	
	Profil createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, String raucher, String geschlecht) throws IllegalArgumentException;
	public void delete(Profil pro) throws IllegalArgumentException;
	public void save(Profil pro) throws IllegalArgumentException;
	public Profil getProfilById (int id) throws IllegalArgumentException;
	public Vector <Profil> getAllProfil() throws IllegalArgumentException;
	public Profil checkProfil(String email) throws IllegalArgumentException;
	public Profil pruefenAufExistenz(String email) throws IllegalArgumentException;
	
	public double berechneAhnlichkeitProfilProfil(Profil p1, Profil p2) throws IllegalArgumentException;
	
	public Suchprofil createSuchprofil(String haarfarbe, String religion, int körpergröße,
			String raucher, String geschlecht, int minalter, int maxalter, int profilId) throws IllegalArgumentException;
	public Suchprofil save(Suchprofil such) throws IllegalArgumentException;
	public Suchprofil findByKey1(int id) throws IllegalArgumentException;
	public Vector <Suchprofil> getAllSuchprofil () throws IllegalArgumentException;
	public Vector <Suchprofil> findSuchprofilByProfilId(Profil pro);

	public Suchprofil_Info getAllSuchprofilInfos (Info in, Suchprofil such) throws IllegalArgumentException;
	public Vector<Suchprofil_Info> getAllSuchprofilInfoOf(Info in) throws IllegalArgumentException;


	public Vector<Besuch> showVisitedProfiles(Profil pro) throws IllegalArgumentException;
	public void deleteBesuche(Profil pro, int besuchterNutzerID) throws IllegalArgumentException;
	public Vector<Besuch> getAllBesucheOf(Profil pro) throws IllegalArgumentException;
	public Vector<Profil> getUnvisitedProfiles(Profil pro) throws IllegalArgumentException;
	public boolean sperrPruefung(Profil pro) throws IllegalArgumentException;
	public void visit(Profil pro) throws IllegalArgumentException;
	public Vector<Profil> showBesuchteOf(Profil pro) throws IllegalArgumentException;
	public Vector<Profil> showBesucherOf(Profil pro) throws IllegalArgumentException;
	
	public Vector<Info> getInfoIdByProfilId(Profil pro) throws IllegalArgumentException;
	
	public Vector<Profil> getAllProfilsOf(Suchprofil suchpro) throws IllegalArgumentException;
	public void delete(Suchprofil suchpro) throws IllegalArgumentException;

	void deleteSuchprofil(Suchprofil pro) throws IllegalArgumentException;
	
	public int getAlterOf(Profil pro) throws IllegalArgumentException;
	public Vector<Profil> getAllProfilesByInfoOf(Suchprofil suchpro) throws IllegalArgumentException;
	
	
}
