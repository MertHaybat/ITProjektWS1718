package de.hdm.ITProjekt17.shared;


import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.ITProjekt17.shared.bo.*;

/**
 * Das Interface PartnerboerseAdministration wird in der Impl(Server-Seitige) Klasse realisiert.
 * Da es ein Interface ist werden lediglich Methoden Köpfe angelegt.
 * @author Dennis Lehle
 *
 */
@RemoteServiceRelativePath("partnerboerseadministration")
public interface PartnerboerseAdministration extends RemoteService {
	
	
	public void init() ;
	public Aehnlichkeitsmass createAehnlichkeit(int eigenes_profil, int fremdes_profil) ;
	public void deleteAehnlichkeit(Aehnlichkeitsmass a) ;
	public Aehnlichkeitsmass findAehnlichkeitByProfilid(int id) ;
	public Vector<Aehnlichkeitsmass> showAllAehnlichkeitByProfil() ;
	public Vector<Aehnlichkeitsmass> getAehnlicheUnbesuchteProfileVon(Profil pro) ;
	public Vector<Aehnlichkeitsmass> getAehnlicheProfileVonSuchprofilen(Profil pro) ;
	
	public Auswahleigenschaft createAuswahleigenschaft(String wert) ;
	public void save(Auswahleigenschaft aus) ;
	public void delete(Auswahleigenschaft aus) ;
	public Vector<Info> getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus);
	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) ;
	public Vector <Auswahleigenschaft> getAllAuswahleigenschaft() ; 
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaftOf(Info in) ;
	
//	public Eigenschaft createEigenschaft(int eigenschaftid) ;
	public void save(Eigenschaft eig) ;
	public void delete(Eigenschaft eig) ;
//	public Eigenschaft findbyKeyEigenschaft(int id) ;
//	public Vector <Eigenschaft> getAllEigenschaft() ;
	
	public Freitexteigenschaft createFreitexteigenschaft(String wert);
	public void save(Freitexteigenschaft frei) ;
	public void delete(Freitexteigenschaft frei) ;
	public Vector<Info> getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei);
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaftOf(Info in) ;
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) ;
	public Vector <Freitexteigenschaft> getAllFreitexteigenschaft() ;
	
	public Info createInfo(String email, Integer auswahleigenschaftid, String freitexteigenschaftwert, String auswahleigenschaftwert);
	public void save(Info in) ;
	public void delete(Info in) ;
	public void deleteInfoOf(Profil pro) ;
	public void deleteInfoOf(Suchprofil_Info suchinfo) ;
	public void deleteInfoAs(Auswahleigenschaft aus) ;
	public void deleteInfoAs(Freitexteigenschaft frei) ;
	public Vector<Profil> getAllInfosOf(Profil pro) ;
	public Info findByKeyInfo(int id) ;
	public Vector<Info> getAllInfo() ;
	public Vector<Info> getAllInfobyProfil(Profil pro) ; 
	
	public Kontaktsperre createKontaktsperre(Profil pro, int profilId_gesperrter) ;
	public Kontaktsperre save(Kontaktsperre k) ;
	public void deleteKontaktsperreOf(Profil pro, int profilId_gesperrter) ;
	public Vector<Profil> showBlockedProfilsOf(Profil pro) ;
	public Vector<Profil> showAllBlockerOf(Profil pro) ;
	public Kontaktsperre findById (int id) ;
	public Vector <Kontaktsperre> getAllKontaktsperre();
	public Vector<Kontaktsperre> getAllKontaktsperreOf(Profil pro) ;
	public void delete(Kontaktsperre sperre) ;

	public Merkzettel createMerkzettel(Profil pro, int profilId_gemerkter) ;
	public void save(Merkzettel merk) ;
	public Merkzettel findByKey (int id) ; 
	Vector<Merkzettel> getAllMerkzettelOf(Profil pro);
	public void deleteProfilVonMerkliste(Profil pro, int profilId_gemerkter) ;

	public Vector<Profil> showMerklisteOf(Profil pro) ;
	public void delete(Merkzettel merk) ;
	
	Profil createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, String raucher, String geschlecht);
	
	public void delete(Profil pro) ;
	public void save(Profil pro) ;
	public Profil getProfilById (int id) ;
	public Vector <Profil> getAllProfil() ;
	public Profil checkProfil(String email) ;
	public Profil pruefenAufExistenz(String email) ;
	
	public double berechneAhnlichkeitProfilProfil(Profil p1, Profil p2) ;
	
	public Suchprofil createSuchprofil(String haarfarbe, String religion, int körpergröße,
			String raucher, String geschlecht, int minalter, int maxalter, int profilId) ;
	public Suchprofil save(Suchprofil such) ;
	public Suchprofil findByKey1(int id) ;
	public Vector <Suchprofil> getAllSuchprofil () ;
	public Vector <Suchprofil> findSuchprofilByProfilId(Profil pro);



	public Vector<Besuch> showVisitedProfiles(Profil pro) ;
	public void deleteBesuche(Profil pro, int besuchterNutzerID) ;
	public Vector<Besuch> getAllBesucheOf(Profil pro) ;
	public Vector<Profil> getUnvisitedProfiles(Profil pro) ;
	public boolean sperrPruefung(Profil pro) ;
	public Vector<Profil> showBesuchteOf(Profil pro) ;

	public Vector<Profil> showBesucherOf(Profil pro) ;
	public Besuch visit(int eigene_id, int fremde_id) ;
	
	public Vector<Info> getInfoIdByProfilId(Profil pro) ;
	
	public Vector<Profil> getAllProfilsOf(Profil pro, Suchprofil suchpro) ;
	public void delete(Suchprofil suchpro) ;

	public void deleteSuchprofil(Suchprofil pro) ;
	
	public Vector<Profil> getAllProfilesByInfoOf(Suchprofil suchpro) ;
	public Vector<Profil> showMerkendeOf(Profil pro) ;
	
	public Vector<Kontaktsperre> getBlockedBy(Profil pro) ;
	
}
