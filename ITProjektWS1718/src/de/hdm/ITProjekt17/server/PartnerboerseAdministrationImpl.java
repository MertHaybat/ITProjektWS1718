package de.hdm.ITProjekt17.server;

import de.hdm.ITProjekt17.server.db.*;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministration;
import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;
import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Eigenschaft;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Kontaktsperre;
import de.hdm.ITProjekt17.shared.bo.Merkzettel;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil_Info;
import de.hdm.ITProjekt17.shared.bo.Besuch;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * PartnerboerseAdministrationImpl ist die Implementierungsklasse des Interface
 * <code>PartnerboerseAdministration</code>. In dieser Klasse wird die
 * Applikationslogik dargestellt.
 * 
 * @author Mustafi
 *
 */

@SuppressWarnings("serial")
public class PartnerboerseAdministrationImpl extends RemoteServiceServlet implements PartnerboerseAdministration {

	/**
	 * Referenz auf den AuswahleigenschaftMapper, der Auswahleigenschaftsobjekte
	 * mit der Datenbank abgleicht.
	 */
	private AuswahleigenschaftMapper auswahleigenschaftMapper = null;

	/**
	 * Referenz auf den EigenschaftMapper, der Eigenschaftsobjekte mit der
	 * Datenbank abgleicht.
	 */
	private EigenschaftMapper eigenschaftMapper = null;

	/**
	 * Referenz auf den FreitexteigenschaftMapper, der
	 * Freitexteigenschaftsobjekte mit der Datenbank abgleicht.
	 */
	private FreitexteigenschaftMapper freitexteigenschaftMapper = null;

	/**
	 * Referenz auf den InfoMapper, der Infoobjekte mit der Datenbank abgleicht.
	 */
	private InfoMapper infoMapper = null;

	/**
	 * Referenz auf den ProfilMapper, der Profilobjekte mit der Datenbank
	 * abgleicht.
	 */
	private ProfilMapper profilMapper = null;

	/**
	 * Referenz auf den KontaktsperreMapper, der Kontaktsperrobjekte mit der
	 * Datenbank abgleicht.
	 */
	private KontaktsperreMapper kontaktsperreMapper = null;

	/**
	 * Referenz auf den MerkzettelMapper, der Merkzettelobjekte mit der
	 * Datenbank abgleicht.
	 */
	private MerkzettelMapper merkzettelMapper = null;

	/**
	 * Referenz auf den SuchprofilMapper, der Suchprofilobjekte mit der
	 * Datenbank abgleicht.
	 */
	private SuchprofilMapper suchprofilMapper = null;

	/**
	 * Referenz auf den Suchprofil_InfoMapper, der Suchprofil_Infoobjekte mit
	 * der Datenbank abgleicht.
	 */
	private Suchprofil_InfoMapper suchprofil_infoMapper = null;

	/**
	 * Referenz auf den BesuchMapper, der Besuchobjekte mit der Datenbank
	 * abgleicht.
	 */
	private BesuchMapper besuchMapper = null;

	/**
	 * Referenz auf den AehnlichkeitsmassMapper, der ähnliche Objekte mit der
	 * Datenbank abgleicht.
	 */
	private AehnlichkeitsmassMapper aehnlichkeitsmassMapper = null;

	public PartnerboerseAdministrationImpl() throws IllegalArgumentException {

	}

	/**
	 * Hierbei handelt es sich um die Initialisierungsmethode. Diese Methode ist
	 * relevant, damit sie f�r jede Instanz von
	 * <code>PartnerboerseAdministrationImpl</code> aufgerufen werden kann.
	 */

	public void init() throws IllegalArgumentException {
		/*
		 * Die PartnerboerseAdministrationImpl ben�tigt diese Mapper, um mit
		 * deren Hilfe die Datenbank ansprechen zu k�nnen.
		 */
		this.auswahleigenschaftMapper = AuswahleigenschaftMapper.auswahleigenschaftMapper();
		this.eigenschaftMapper = EigenschaftMapper.eigenschaftMapper();
		this.freitexteigenschaftMapper = FreitexteigenschaftMapper.freitexteigenschaftMapper();
		this.infoMapper = InfoMapper.infoMapper();
		this.profilMapper = ProfilMapper.profilMapper();
		this.kontaktsperreMapper = KontaktsperreMapper.kontaktsperreMapper();
		this.merkzettelMapper = MerkzettelMapper.merkzettelMapper();
		this.suchprofilMapper = SuchprofilMapper.suchprofilMapper();
		this.suchprofil_infoMapper = Suchprofil_InfoMapper.suchprofil_InfoMapper();
		this.besuchMapper = BesuchMapper.besuchMapper();
		this.aehnlichkeitsmassMapper = AehnlichkeitsmassMapper.aehnlichkeitsmassMapper();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * <p>
	 * Anlegen einer Auswahleigenschaft. Dabei wird dies in der Datenbank
	 * gespeichert, in dem die insertAuswahleigenschaft des
	 * Auswahleigenschaft-Mapper aufgerufen wird.
	 * </p>
	 */
	@Override
	public Auswahleigenschaft createAuswahleigenschaft(String wert) throws IllegalArgumentException {

		Auswahleigenschaft aus = new Auswahleigenschaft();
		aus.setWert(wert);
		/*
		 * Setzen einer vorl�ufigen ID.
		 */
		aus.setId(1);

		// Objekt in der DB speichern.
		return this.auswahleigenschaftMapper.insertAuswahleigenschaft(aus);
	}

	/**
	 * Speichern der Auswahleigenschaft.
	 */
	@Override
	public void save(Auswahleigenschaft aus) throws IllegalArgumentException {

		try {
			auswahleigenschaftMapper.updateAuswahleigenschaft(aus);
		} catch (Exception e) {

		}
	}

	
	/**
	 * L�schen der Auswahleigenschaft. Dabei wird die Referenz zu Info auch
	 * gel�scht.
	 */
	@Override
	public void delete(Auswahleigenschaft aus) throws IllegalArgumentException {

		try {
			Vector<Info> auswahlinfo = this.getAllInfosAsAuswahleigenschaft(aus);
			if (auswahlinfo != null) {
				for (Info aus1 : auswahlinfo) {
					this.delete(aus1);
				}
				auswahleigenschaftMapper.deleteAuswahleigenschaft(aus);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Auslesen aller Infos, die als Auswahleigenschaft hinterlegt sind.
	 */
	public Vector<Info> getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus) {
		try {
			return this.infoMapper.getAllInfosAsAuswahleigenschaft(aus);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen der Auswahleigenschaft, in dem die ID aufgerufen wird.
	 */
	@Override
	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) throws IllegalArgumentException {

		return this.auswahleigenschaftMapper.findByKey(id);
	}

	/**
	 * Auslesen aller Auswahleigenschaften.
	 */
	@Override
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaft() throws IllegalArgumentException {
		try {
			return this.auswahleigenschaftMapper.getAll();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen aller Auswahleigenschaften eines bestimmten Info-Objekts.
	 */
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaftOf(Info in) throws IllegalArgumentException {
		return this.auswahleigenschaftMapper.getAllAuswahleigenschaftOf(in);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// @Override
	// public Eigenschaft createEigenschaft(int eigenschaftid) throws
	// IllegalArgumentException {
	// // TODO Auto-generated method stub
	// Eigenschaft eig = new Eigenschaft();
	//
	// eig.setId(1);
	// return this.eigenschaftMapper.insertEigenschaft(eig);
	// }

	@Override
	public void save(Eigenschaft eig) throws IllegalArgumentException {

		try {
			eigenschaftMapper.updateEigenschaft(eig);
		} catch (Exception e) {

		}
	}

	@Override
	public void delete(Eigenschaft eig) throws IllegalArgumentException {

		try {
			eigenschaftMapper.deleteEigenschaft(eig);
		} catch (Exception e) {

		}
	}

	// @Override
	// public Eigenschaft findbyKeyEigenschaft(int id) throws
	// IllegalArgumentException {
	//
	// return this.eigenschaftMapper.findByKey(id);
	// }
	//
	// @Override
	// public Vector<Eigenschaft> getAllEigenschaft() throws
	// IllegalArgumentException {
	// try {
	// return this.eigenschaftMapper.getAll();
	// } catch(Exception e){
	//
	// }
	// return null;
	// }

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * <p>
	 * Anlegen einer Freitextauswahleigenschaft. Dabei wird dies in der
	 * Datenbank gespeichert, in dem die insertFreitexteigenschaft des
	 * Freitexteigenschaft-Mapper aufgerufen wird.
	 * </p>
	 */
	@Override
	public Freitexteigenschaft createFreitexteigenschaft(String wert) throws IllegalArgumentException {

		Freitexteigenschaft frei = new Freitexteigenschaft();
		frei.setWert(wert);
		frei.setId(1);
		return this.freitexteigenschaftMapper.insertFreitexteigenschaft(frei);
	}

	/**
	 * Speichern der Freitexteigenschaft.
	 */

	@Override
	public void save(Freitexteigenschaft frei) throws IllegalArgumentException {

		try {
			freitexteigenschaftMapper.updateFreitexteigenschaft(frei);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Freitexteigenschaft. Dabei wird die Referenz zu Info auch
	 * gel�scht.
	 */
	@Override
	public void delete(Freitexteigenschaft frei) throws IllegalArgumentException {

		try {
			Vector<Info> freitextinfo = this.getAllInfosAsFreitexteigenschaft(frei);
			if (freitextinfo != null) {
				for (Info frei1 : freitextinfo) {
					this.delete(frei1);
				}
				freitexteigenschaftMapper.deleteFreitexteigenschaft(frei);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Auslesen aller Infos, die als Freitexteigenschaft hinterlegt sind.
	 */
	public Vector<Info> getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei) {
		try {
			return this.infoMapper.getAllInfosAsFreitexteigenschaft(frei);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen aller Freitexteigenschaften eines bestimmten Info-Objekts.
	 */
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaftOf(Info in) throws IllegalArgumentException {
		return this.freitexteigenschaftMapper.getAllFreitexteigenschaftOf(in);
	}

	/**
	 * Auslesen der Freitexteigenschaft, in dem die ID aufgerufen wird.
	 */
	@Override
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) throws IllegalArgumentException {

		return this.freitexteigenschaftMapper.findByKey(id);
	}

	/**
	 * Auslesen aller Freitexteigenschaften.
	 */
	@Override
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaft() throws IllegalArgumentException {

		return this.freitexteigenschaftMapper.getAll();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Auslesen aller Infos des Profils Profils.
	 */
	public Vector<Info> getAllInfobyProfil(Profil pro) throws IllegalArgumentException {

		return infoMapper.getInfoIdByProfilId(pro);
	}

	/**
	 * <p>
	 * Anlegen einer Info. Dabei wird dies in der Datenbank gespeichert, in dem
	 * die insertInfo des Info-Mapper aufgerufen wird.
	 * </p>
	 */
	@Override
	public Info createInfo(String email, Integer auswahleigenschaftid, String freitexteigenschaftwert,
			String auswahleigenschaftwert) throws IllegalArgumentException {
		Profil p = profilMapper.findByEmail(email);

		Info in = new Info();

		in.setProfilId(p.getId());
		in.setFreitexteigenschaftid(p.getId());
		in.setAuswahleigenschaftid(auswahleigenschaftid);
		in.setAuswahleigenschaftWert(auswahleigenschaftwert);
		in.setFreitexteigenschaftWert(freitexteigenschaftwert);
		in.setId(1);
		if (auswahleigenschaftid == 5) {
			Freitexteigenschaft f = findByKeyFreitexteigenschaft(p.getId());
			f.setWert(freitexteigenschaftwert);
			save(f);

		}
		return this.infoMapper.insertInfo(in);
	}

	/**
	 * Speichern der Info.
	 */
	@Override
	public void save(Info in) throws IllegalArgumentException {
		infoMapper.updateInfo(in);
			if (in.getAuswahleigenschaftid() == 5) {
			Freitexteigenschaft f = findByKeyFreitexteigenschaft(in.getProfilId());
			f.setWert(in.getFreitexteigenschaftWert());
			save(f);
		
		}
			
		
	}

	/**
	 * L�schen der Info. Dabei wird die Referenz zu Auswahleigenschaft,
	 * Freitexteigenschaft und Suchprofil_Info auch gel�scht.
	 */
	@Override
	public void delete(Info in) throws IllegalArgumentException {

		try {
			Vector<Freitexteigenschaft> freitextinfo = new Vector<Freitexteigenschaft>();

			freitextinfo = this.getAllFreitexteigenschaftOf(in);
			if (freitextinfo != null) {
				for (Freitexteigenschaft f : freitextinfo) {
					this.freitexteigenschaftMapper.deleteFreitexteigenschaft(f);
				}
			}

		infoMapper.deleteInfo(in);

		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info eines Profils.
	 */
	public void deleteInfoOf(Profil pro) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(pro);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info des Suchprofil_Info.
	 */
	public void deleteInfoOf(Suchprofil_Info suchinfo) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(suchinfo);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info, welche eine Auswahleigenschaft ist.
	 */
	public void deleteInfoAs(Auswahleigenschaft aus) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(aus);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info, welche eine Freitexteigenschaft ist.
	 */
	public void deleteInfoAs(Freitexteigenschaft frei) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(frei);
		} catch (Exception e) {

		}
	}

	/**
	 * Auslesen aller Infos eines Profils.
	 */
	public Vector<Profil> getAllInfosOf(Profil pro) throws IllegalArgumentException {
		try {
			this.infoMapper.getInfoIdByProfilId(pro);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen der Info, in dem die ID aufgerufen wird.
	 */
	@Override
	public Info findByKeyInfo(int id) throws IllegalArgumentException {
		try {
			return this.infoMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen aller Infos.
	 */
	@Override
	public Vector<Info> getAllInfo() throws IllegalArgumentException {
		try {
			return this.infoMapper.getAll();
		} catch (Exception e) {

		}
		return null;
	}

	////////////////////////////////////////////// Kontaktsperre///////////////////////////////////////////////////////////////////////////

	/**
	 * Methode um ein einzelnes Profil auf die Sperrliste zu setzen. LoggedIn
	 * steht fuer den Sperrenden User der andere Teilnehmer auf die Sperrliste
	 * setzt.
	 */
	public Kontaktsperre createKontaktsperre(Profil pro, int profilId_gesperrter) throws IllegalArgumentException {
		Kontaktsperre sperre = new Kontaktsperre();
		sperre.setProfilId_sperrender(pro.getId());
		sperre.setProfilId_gesperrter(profilId_gesperrter);
		kontaktsperreMapper.insertKontaktsperre(sperre);
		return sperre;
	}

	/**
	 * Hier wird eine Kontaktsperre aufgehoben.
	 */
	public void deleteKontaktsperreOf(Profil pro, int profilId_gesperrter) throws IllegalArgumentException {
		Vector<Kontaktsperre> result = new Vector<Kontaktsperre>();
		result = this.getAllKontaktsperreOf(pro);

		if (result != null) {
			for (Kontaktsperre k : result) {
				this.kontaktsperreMapper.deleteByProfilIds(pro, k.getProfilId_gesperrter());
			}

		}
	}

	/**
	 * Auslesen aller User eines Profils die vom Teilnehmer auf die
	 * Kontaktsperre gesetzt wurden.
	 * 
	 * @param merk
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Profil> showBlockedProfilsOf(Profil pro) throws IllegalArgumentException {
		Vector<Kontaktsperre> allBlockedProfiles = this.getAllKontaktsperreOf(pro);
		Vector<Profil> vectorprofil = new Vector<Profil>();
		System.out.println(allBlockedProfiles);
		for (int i = 0; i<allBlockedProfiles.size(); i++) {
			vectorprofil.addElement(getProfilById(allBlockedProfiles.elementAt(i).getProfilId_gesperrter()));
		}	
		
		return vectorprofil;

	}
	
	public Vector<Profil> showAllBlockerOf(Profil pro) throws IllegalArgumentException {
		Vector<Kontaktsperre> allBlockedProfiles = this.getBlockedBy(pro);
		Vector<Profil> vectorprofil = new Vector<Profil>();
		System.out.println(allBlockedProfiles);
		for (int i = 0; i<allBlockedProfiles.size(); i++) {
			vectorprofil.addElement(getProfilById(allBlockedProfiles.elementAt(i).getProfilId_sperrender()));
		}	
		
		return vectorprofil;
	}

	@Override
	public Vector<Kontaktsperre> getAllKontaktsperreOf(Profil pro) throws IllegalArgumentException {

		return kontaktsperreMapper.getAllKontaktsperrenDesSperrenden(pro);
	}

	@Override
	public Kontaktsperre save(Kontaktsperre sperre) throws IllegalArgumentException {

		try {
			kontaktsperreMapper.updateKontaktsperre(sperre);
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Kontaktsperre findById(int id) throws IllegalArgumentException {
		try {
			this.kontaktsperreMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Vector<Kontaktsperre> getAllKontaktsperre() throws IllegalArgumentException {
		try {
			this.kontaktsperreMapper.getAllKontaktsperre();
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void delete(Kontaktsperre sperre) throws IllegalArgumentException {
		
		this.kontaktsperreMapper.deleteKontaktsperre(sperre);
	}

	//////////////////////////////////////// Merkzettel/////////////////////////////////////////////////////////////////////////////////
	/**
	 * Mit diesere Methode werden alle Merkzettel anhand der Profil Id des
	 * Merkenden angezeigt. DIes ist eine Hilfsmethode fÃ¼r andere Operationen
	 * in dieser Klasse.
	 */
	public Vector<Merkzettel> getAllMerkzettelOf(Profil pro) throws IllegalArgumentException {

		return merkzettelMapper.getAllMerkezettelDesMerkers(pro);
	}

	/**
	 * Methode um ein einzelnes Profil auf den Merkzettel zu setzen. LoggedIn
	 * steht fÃ¼r den Merkenden User der andere Teilnehmer auf seine
	 * Merkliste(Merkzettel) setzt.
	 */

	@Override
	public Merkzettel createMerkzettel(Profil pro, int profilId_gemerkter) throws IllegalArgumentException {
		Merkzettel merk = new Merkzettel();
		merk.setProfilId_merkender(pro.getId());
		merk.setProfilId_gemerkter(profilId_gemerkter);

		merk.setId(1);
		return this.merkzettelMapper.insertMerkzettel(merk);

	}

	/**
	 * Methode zum Loeschen eines Profils von der Merkliste.
	 */
	public void deleteProfilVonMerkliste(Profil pro, int profilId_gemerkter) throws IllegalArgumentException {
		Vector<Merkzettel> result = new Vector<Merkzettel>();

		result = this.getAllMerkzettelOf(pro);

		if (result != null) {
			for (Merkzettel m : result) {
				this.merkzettelMapper.deleteByProfilIds(pro, m.getProfilId_gemerkter());
			}
		}
	}

	/**
	 * Auslesen aller User eines Profils die vom Teilnehmer auf den Merkzettel
	 * gesetzt wurden.
	 * 
	 * @param merk
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Profil> showMerklisteOf(Profil pro) throws IllegalArgumentException {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Merkzettel> allGemerkteProfile = this.getAllMerkzettelOf(pro);
		
		for (int i = 0; i<allGemerkteProfile.size(); i++){
			profiles.addElement(getProfilById(allGemerkteProfile.elementAt(i).getProfilId_gemerkter()));
		}
					
		return profiles;
		
	}
	
	public Vector<Profil> showMerkendeOf(Profil pro) throws IllegalArgumentException {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Merkzettel> merkendeProfiles = merkzettelMapper.merkzettel_showGemerkteProfile(pro.getId());
		
		for (int i = 0; i<merkendeProfiles.size(); i++){
			profiles.addElement(getProfilById(merkendeProfiles.elementAt(i).getProfilId_merkender()));
		}
			
		return profiles;
	}

	@Override
	public Vector<Profil> showBesuchteOf(Profil pro) throws IllegalArgumentException {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Besuch> besucher = besuchMapper.getAllBesucherOfProfil(pro);
		
		
		for (int i = 0; i<besucher.size(); i++){
			profiles.addElement(getProfilById(besucher.elementAt(i).getBesuchenderNutzerID()));
		}

	
		return profiles;
	}
	
	@Override
	public Vector<Profil> showBesucherOf(Profil pro) throws IllegalArgumentException {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Besuch> besucher = this.getAllBesucheOf(pro);
		
		
		for (int i = 0; i<besucher.size(); i++){
			profiles.addElement(getProfilById(besucher.elementAt(i).getBesuchterNutzerID()));
		}

	
		return profiles;
	}
	
	@Override
	public void save(Merkzettel merk) throws IllegalArgumentException {

		try {
			merkzettelMapper.updateMerkzettel(merk);
		} catch (Exception e) {

		}
	}

	@Override
	public Merkzettel findByKey(int id) throws IllegalArgumentException {
		try {
			this.merkzettelMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void delete(Merkzettel merk) throws IllegalArgumentException {
		Merkzettel m = new Merkzettel();
		m.setProfilId_gemerkter(merk.getProfilId_gemerkter());
		m.setProfilId_merkender(merk.getProfilId_merkender());
		this.merkzettelMapper.deleteMerkzettel(m);
	}

	/////////////////////////////////////////// Suchprofil//////////////////////////////////////////////////////////////////////////////

	/**
	 * Diese Methode erzeugt ein neues Suchprofil.
	 */
	@Override
	public Suchprofil createSuchprofil(String haarfarbe, String religion, int körpergröße,
			String raucher, String geschlecht, int minalter, int maxalter, int profilId)
			throws IllegalArgumentException {

		Suchprofil suchpro = new Suchprofil();
		if(haarfarbe != null) {
			suchpro.setHaarfarbe(haarfarbe);
		} else {
			suchpro.setHaarfarbe(null);
		}
		
		if(körpergröße != 0){
			suchpro.setKoerpergroesse(körpergröße);
		} else {
			suchpro.setKoerpergroesse(0);
		}
		
		if(maxalter != 0){
			suchpro.setMaxAlter(maxalter);
		} else {
			suchpro.setMaxAlter(0);
		}
		
		if(minalter != 0){
			suchpro.setMinAlter(minalter);
		} else {
			suchpro.setMinAlter(0);
		}
		
		if(raucher != null){
			suchpro.setRaucher(raucher);
		} else {
			suchpro.setRaucher(null);
		}
		
		if(religion != null){
			suchpro.setReligion(religion);
		} else {
			suchpro.setReligion(null);
		}
		
		if(geschlecht != null){
			suchpro.setGeschlecht(geschlecht);
		} else {
			suchpro.setGeschlecht(null);
		}
		
		suchpro.setProfilId(profilId);

		return suchprofilMapper.insertSuchprofil(suchpro);
	}

	// Vergleiche deleteProfil(AP-Schicht)!!!!!!!!!!!!!!!!!
	
	/**
	 * Hier wird das Suchprofil gelÃ¶scht Um das Suchprofil zu lÃ¶schen, mÃ¼ssen
	 * erst die Daten aus der Tabelle Suchprofil_Info gelÃ¶scht werden um das
	 * Suchprofil lÃ¶schen zu kÃ¶nnen
	 */
	@Override
	public void deleteSuchprofil(Suchprofil pro) throws IllegalArgumentException {
			suchprofilMapper.deleteProfil(pro);

	}
	
	public void delete(Suchprofil suchpro) throws IllegalArgumentException {
		Vector<Info> suchprofilInfo = getAllInfoOf(suchpro);
		for(int i = 0; i < suchprofilInfo.size(); i++){
			infoMapper.deleteInfo(suchprofilInfo.elementAt(i));
		}
		suchprofilMapper.deleteProfil(suchpro);
	}
	
	public Vector<Profil> getAllProfilsOf(Suchprofil suchpro) throws IllegalArgumentException {
		
		return this.profilMapper.getAllProfilBySuchprofil(suchpro);
		
	}
	
	public Vector<Profil> getAllProfilesByInfoOf(Suchprofil suchpro) throws IllegalArgumentException {
		Vector<Profil> profiles = this.getAllProfils();
		Vector<Info> suchprofilInfos = this.getAllInfoOf(suchpro);
	
		for(int k = 0; k < profiles.size(); k++) {
			profiles.elementAt(k);
			Vector<Info> infosOfProfiles = this.getAllInfobyProfil(profiles.elementAt(k));
			for(int j = 0; j < infosOfProfiles.size(); j++) {
				for(int i = 0; i < suchprofilInfos.size(); i++) {
					if(suchprofilInfos.elementAt(i) == infosOfProfiles.elementAt(j)) {
						profiles.add(profiles.elementAt(k)) ;
					}
				}
			}
		}
		return profiles;
	}
	public Vector<Info> getAllInfoOf(Suchprofil suchpro) throws IllegalArgumentException {
//		return this.infoMapper.getAllForSuchprofil();
		return null;
	}
	
	public Vector<Info> getAllInfoOf(Profil pro) throws IllegalArgumentException {
		return this.infoMapper.getAll();
	}
	
	/**
	 * Mit dieser Hilfsmethode kÃ¶nnen alle Suchprofile des einzelenen
	 * Teilnehmers herausgesucht und angezeigt werden. Dies geschieht Ã¼ber die
	 * Profil Id des Users.
	 * 
	 * @param profilId
	 * @return
	 */
	public Vector<Suchprofil> findSuchprofilByProfilId(Profil pro) {
		try {
			return this.suchprofilMapper.getSuchprofilIdByProfil(pro);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Mit dieser Methode werden alle Suchprofile Ã¼ber die Suchprofil Id aus
	 * der Db heraus herausgefiltert.
	 */
	public Suchprofil findByKey1(int id) throws IllegalArgumentException {
		try {
			return this.suchprofilMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Diese Methode zeigt alle Suchprofile der PartnerbÃ¶rse an.
	 */
	public Vector<Suchprofil> getAllSuchprofil() throws IllegalArgumentException {

		return this.suchprofilMapper.getAllSuchprofil();
	}

	/**
	 * Es ist mÃ¶glich ein Suchprofil des einzelnen Users anhand der Profil ID
	 * heauszusuchen.
	 */
	public Vector<Suchprofil> getSuchprofilbyProfilId(Profil pro) throws IllegalArgumentException {
		try {
			return suchprofilMapper.getSuchprofilIdByProfil(pro);
		} catch (Exception e) {

		}
		return null;
	}
	// Doppelt, eines muss entfernt werden!

	@Override
	public Suchprofil save(Suchprofil such) throws IllegalArgumentException {

		try {
			suchprofilMapper.updateProfil(such);
		} catch (Exception e) {

		}
		return null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Suchprofil_Info getAllSuchprofilInfos(Info in, Suchprofil such) throws IllegalArgumentException {

		Vector<Suchprofil_Info> suchinfo = suchprofil_infoMapper.getAllSuchprofilInfos(in, such);
		Suchprofil_Info si = new Suchprofil_Info();
		for (int i = 0; i < suchinfo.size(); i++) {
			si.setId(suchinfo.get(i).getId());
		}
		return si;
	}

	// public void deleteSuchprofilInfo (Profil pro){
	// Vector <Suchprofil> suchp =
	// suchprofilMapper.getSuchprofilIdByProfil(pro);
	// Vector <Info> info = infoMapper.getInfoIdByProfilId(pro);
	// Vector <Suchprofil_Info> suchinfo =
	// suchprofil_infoMapper.getAllSuchprofilInfos(info, such);
	//
	//
	// for(int i=0; i < suchp.size(); i ++){
	//
	// if(suchp)
	// }
	//

	// }

	public Vector<Suchprofil_Info> getAllSuchprofilInfoOf(Info in) throws IllegalArgumentException {
		try {
			return this.suchprofil_infoMapper.getAllSuchprofilInfoOf(in);
		} catch (Exception e) {

		}
		return null;
	}

	//////////////////////////////////////////// Profil/////////////////////////////////////////////////////////////////////////////
	/**
	 * Auslesen aller Profil-Objekte der PartnerbÃ¶rse in der Datenbank.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Profil> getAllProfils() throws IllegalArgumentException {
		try {
			return this.profilMapper.getAllProfil();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Mit diesere Methode wird ein Profil anhand der Gmail in der Datenbank
	 * gesucht.
	 * 
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Profil getByEmail(String email) throws IllegalArgumentException {
		try {
			return profilMapper.findByEmail(email);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Hier wird ein Profil angelegt.
	 */
	public Profil createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse,
			String religion, String haarfarbe, String raucher, String geschlecht) throws IllegalArgumentException {

		Profil pro = new Profil();
		pro.setEmail(email);
		pro.setVorname(vorname);
		pro.setNachname(nachname);
		pro.setGeburtsdatum(geburtsdatum);
		pro.setKoerpergroesse(koerpergroesse);
		pro.setReligion(religion);
		pro.setHaarfarbe(haarfarbe);
		pro.setGeschlecht(geschlecht);
		pro.setRaucher(raucher);
		pro.setId(1);

		createFreitexteigenschaft("Freitexteigenschaft");

		return this.profilMapper.insertProfil(pro);

	}

	/**
	 * Mit dieser Methode wird ein Profil aktualisiert.
	 */
	public Profil saveProfil(String email, String geschlecht, String vorname, String nachname, Date geburtsdatum,
			int koerpergroesse, String religion, String haarfarbe, String raucher) {

		Profil pro = new Profil();
		Profil vorhandenesProfil = getByEmail(email);

		try {
			pro.setId(vorhandenesProfil.getId());
			pro.setEmail(email);
			pro.setGeburtsdatum(geburtsdatum);
			pro.setHaarfarbe(haarfarbe);
			pro.setGeschlecht(geschlecht);
			pro.setKoerpergroesse(koerpergroesse);
			pro.setRaucher(raucher);
			pro.setReligion(religion);
			pro.setVorname(vorname);
			pro.setNachname(nachname);

			profilMapper.updateProfil(pro);

		} catch (Exception e) {

			System.out.println("Die Aktualisierung konnte nicht durchgefÃ¼hrt werden");
		}
		return pro;

	}

	@Override
	public void save(Profil pro) throws IllegalArgumentException {
		try {
			this.profilMapper.updateProfil(pro);
		} catch (Exception e) {

		}
	}

	/**
	 * Hier wird ein erstelltes Profil gÃ¤nzlich aus der PartnerbÃ¶rse entfernt
	 * mit all seinen Daten und Informationen.
	 */
	public void delete(Profil pro) throws IllegalArgumentException {

		// Vector <Profil> profil = this.getAllProfils();
		// Vector <Merkzettel> merk = this.getAllMerkzettel(profilid);

		// Kontaktsperre

		Vector<Kontaktsperre> sperre = this.getAllKontaktsperreOf(pro);

		for (int i = 0; i < sperre.size(); i++) {
			if(pro.getId() == sperre.elementAt(i).getProfilId_gesperrter() || pro.getId() == sperre.elementAt(i).getProfilId_sperrender())
			kontaktsperreMapper.deleteKontaktsperreByProfil(sperre.elementAt(i));

		}

		// Merkzettel

		Vector<Merkzettel> merk = merkzettelMapper.getAllMerkezettel();

		for (int i = 0; i < merk.size(); i++) {
			if(pro.getId() == merk.elementAt(i).getProfilId_gemerkter() || pro.getId() == merk.elementAt(i).getProfilId_merkender()){
				merkzettelMapper.deleteMerkzettelbyprofil(merk.elementAt(i));
			}
			

		}

		// Besuch

		Vector<Besuch> besuche = besuchMapper.getAllBesuche();
		
		

		for (int i = 0; i < besuche.size(); i++) {
			if(pro.getId() == besuche.elementAt(i).getBesuchenderNutzerID() || pro.getId() == besuche.elementAt(i).getBesuchterNutzerID()){
				besuchMapper.deleteeinzeln(besuche.elementAt(i));
			}
		

		}

//		// SuchprofilInfo
//
//		Vector<Suchprofil> suchprofil = this.getSuchprofilbyProfilId(pro);
//		Vector<Info> info = getInfoIdByProfilId(pro);
//		Suchprofil_Info suchinfo = new Suchprofil_Info();
//
//		for (int s = 0; s < suchprofil.size(); s++) {
//			for (int i = 0; i < info.size(); i++) {
//				suchinfo = getAllSuchprofilInfos(info.elementAt(i), suchprofil.elementAt(i));
//
//			}
//
//			suchprofil_infoMapper.deleteSuchprofil_Info(suchinfo);
//		}

		// Suchprofil

		Vector<Suchprofil> suchpro = this.getSuchprofilbyProfilId(pro);

		for (int i = 0; i < suchpro.size(); i++) {
			suchprofilMapper.deleteProfil(suchpro.elementAt(i));

		}

		// Info

		Vector<Info> infos = this.getAllInfo();
		Vector<Freitexteigenschaft> frei = this.getAllFreitexteigenschaft();
		for (int i = 0; i < infos.size(); i++) {
			if(pro.getId() == infos.elementAt(i).getProfilId()){

				infoMapper.deleteInfo(infos.elementAt(i));
			}
		}

		for (int i = 0; i < frei.size(); i++) {
			if(pro.getId() == frei.elementAt(i).getId()){
				freitexteigenschaftMapper.deleteFreitexteigenschaft(frei.elementAt(i));
			}
		}

		// AnschlieÃŸend das Profil entfernen

		profilMapper.deleteProfil(getProfilById(pro.getId()));
	}

	/**
	 * Es werden Profile der PartnerbÃ¶rse anhand der Profil Id aus der
	 * Datenbnak gefiltert.
	 */
	public Profil getProfilById(int id) throws IllegalArgumentException {
		try {
			return this.profilMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Hier werden alle Profile der PartnerbÃ¶rse herausgefiltert die sich in
	 * der Datenbank befinden.
	 */
	public Vector<Profil> getAllProfil() throws IllegalArgumentException {
		try {
			return profilMapper.getAllProfil();
		} catch (Exception e) {

		}
		return null;
	}
	// Doppelt, eines muss entfernt werden

	/**
	 * Diese Methode ist fÃ¼r den Login wichtig, da sie prÃ¼ft ob eine Gmal
	 * bereits in der Datenbank vorhanden ist. Gmail ist genau so einzigartig
	 * wie eine ID, denn diese gibt es nur einmal.
	 * 
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Profil pruefenAufExistenz(String email) throws IllegalArgumentException {

		Profil profil = new Profil();
		Profil existingProfil = getByEmail(email);

		if (existingProfil == null) {
			System.out.println("Bitte mit Ihrem Gmail-Konto anmelden.");
		}

		else

		{

			profil = existingProfil;

		}
		return profil;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Vector<Besuch> showVisitedProfiles(Profil pro) throws IllegalArgumentException {

		Vector<Besuch> allBesuche = new Vector<Besuch>();
		allBesuche = this.getAllBesucheOf(pro);

		if (allBesuche != null) {

			return allBesuche;

		}
		return null;
	}

	///////////////////////////////////// Besuch////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Methode zum Löschen von Besuchen.
	 */
	public void deleteBesuche(Profil pro, int besuchterNutzerID) throws IllegalArgumentException {
//		Vector<Besuch> allBesuche = new Vector<Besuch>();
//		allBesuche = this.getAllBesucheOf(pro);
//
//		if (allBesuche != null) {
//			for (Besuch besuche : allBesuche) {
//				this.besuchMapper.deleteByProfilId(pro, besuche.getBesuchterNutzerID());
//			}
//		}
		Besuch b1 = new Besuch();
		b1.setBesuchenderNutzerID(pro.getId());
		b1.setBesuchterNutzerID(besuchterNutzerID);
		this.besuchMapper.delete(b1);
	}

	/**
	 * Hilfsmethode zu anzeige aller Profile die vom besuchten aus besucht
	 * wurden.
	 * 
	 * @param besuchenderNutzerID
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Besuch> getAllBesucheOf(Profil pro) throws IllegalArgumentException {
		try {
			return besuchMapper.getAllBesucheDesBesuchenden(pro);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Hier werden nicht besuchte Profile angezeigt. Dies geschieht durch
	 * PrÃ¼fung, welche Profile schon besucht wurden, welche nicht besucht
	 * wurden und welche gesperrt sind.
	 * 
	 * @param profilid
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Profil> getUnvisitedProfiles(Profil pro) throws IllegalArgumentException {
		/**
		 * Besuche des Besuchenden werden hier abgerufen und in
		 */
		Vector<Besuch> unvisitedProfiles = this.getAllBesucheOf(pro);
		Vector<Besuch> visitedProfiles = this.besuchMapper.findByKey(pro.getId());
		System.out.println("Size visited Profiles: " + visitedProfiles.size());

		for (int visited = 0; visited < visitedProfiles.size(); visited++) {
			unvisitedProfiles.remove(visitedProfiles.get(visited));
		}
		for (int unVisited = 0; unVisited < unvisitedProfiles.size(); unVisited++) {
			if (sperrPruefung(pro) == true) {
				unvisitedProfiles.remove(unVisited);
			}
		}
		for (int i = 0; i < unvisitedProfiles.size(); i++) {
			return profilMapper.getAllProfilbyKey(unvisitedProfiles.elementAt(i).getBesuchterNutzerID());
		}
		return null;
	}

	/**
	 * Diese Methode wird fÃ¼r die Methode getUnvisitedProfils benÃ¶tigt um zu
	 * prÃ¼fen welche Profile gesperrt sind.
	 * 
	 * @param profilId_sperrender
	 * @param profilId_gesperrter
	 * @return
	 */
	public boolean sperrPruefung(Profil pro) throws IllegalArgumentException {
		Vector<Kontaktsperre> sperrL = getAllKontaktsperreOf(pro);
		boolean sperrListe = false;

		for (int i = 0; i < sperrL.size(); i++) {
			if (sperrL.get(i).getId() == pro.getId())
				;
			{
				sperrListe = true;
			}
		}
		return sperrListe;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Vector<Info> getInfoIdByProfilId(Profil pro) throws IllegalArgumentException {
		try {
			return infoMapper.getInfoIdByProfilId(pro);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Setzt besuch wenn ein Profil das andere Besucht
	 * 
	 * @param pro.getId()
	 * @param besuch.getBesuchterNutzerID
	 * @throws IllegalArgumentException
	 */
	public Besuch visit(int eigene_id, int fremde_id) throws IllegalArgumentException {
		Besuch besuch = new Besuch();
		besuch.setBesuchenderNutzerID(eigene_id);
		besuch.setBesuchterNutzerID(fremde_id);
		return besuchMapper.insert(besuch);
	}

	public Profil checkProfil(String email) throws IllegalArgumentException {

		if (profilMapper.findByEmail(email) == null) {
			return null;
		} else {
			return profilMapper.findByEmail(email);
		}

	}

	/**
	 * Ähnlichkeitsmaß von Profil zu Profil
	 * 
	 * @param p1,
	 *            p2
	 * @return prozent
	 * @throws IllegalArgumentException
	 */
	public double berechneAhnlichkeitProfilProfil(Profil p1, Profil p2) throws IllegalArgumentException {
		double aehnlichkeitstreffer = 0;
		double prozent = 0;
		Profil profil1 = profilMapper.findByKey(p1.getId());
		Profil profil2 = profilMapper.findByKey(p2.getId());

		if (profil1 != null && profil2 != null) {
			if (profil1.getHaarfarbe() == profil2.getHaarfarbe()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getKoerpergroesse() == profil2.getKoerpergroesse()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getRaucher() == profil2.getRaucher()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getReligion() == profil2.getReligion()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getGeschlecht() != profil2.getGeschlecht()) {
				aehnlichkeitstreffer++;
			}
			prozent = aehnlichkeitstreffer * 20;
		}

		return prozent;

	}

	@Override
	public Aehnlichkeitsmass createAehnlichkeit(int eigenes_profil, int fremdes_profil)
			throws IllegalArgumentException {

		Aehnlichkeitsmass a1 = new Aehnlichkeitsmass();
		a1.setEigenes_profilid(eigenes_profil);
		a1.setFremdes_profilid(fremdes_profil);
		int aehnlichkeitstreffer = 0;

		Profil profil1 = profilMapper.findByKey(eigenes_profil);
		Profil profil2 = profilMapper.findByKey(fremdes_profil);

		if (profil1 != null && profil2 != null) {
			if (profil1.getHaarfarbe() == profil2.getHaarfarbe()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getKoerpergroesse() == profil2.getKoerpergroesse()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getRaucher() == profil2.getRaucher()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getReligion() == profil2.getReligion()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getGeschlecht() == profil2.getGeschlecht()) {
				aehnlichkeitstreffer++;
			}
			a1.setAehnlichkeitsindex(aehnlichkeitstreffer * 20);
		}
		// Hier ein Create-Mapper Aufruf

		return this.aehnlichkeitsmassMapper.insertAehnlichkeitsmass(a1);
	}

	@Override
	public void deleteAehnlichkeit(Aehnlichkeitsmass a) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		aehnlichkeitsmassMapper.deleteAehnlichkeitsmass(a);
	}

	@Override
	public Aehnlichkeitsmass findAehnlichkeitByProfilid(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.aehnlichkeitsmassMapper.findByKey(id);
	}

	@Override
	public Vector<Aehnlichkeitsmass> showAllAehnlichkeitByProfil() throws IllegalArgumentException {
		// TODO Auto-generated method stub

		return this.aehnlichkeitsmassMapper.getAll();
	}

	@Override
	public Vector<Aehnlichkeitsmass> getAehnlicheUnbesuchteProfileVon(Profil pro) {
		Vector<Aehnlichkeitsmass> allAehnlichkeitsmassVonProfilen = new Vector<Aehnlichkeitsmass>();
		Vector<Profil> allUnvisitedProfils = this.getUnvisitedProfiles(pro);
		for (int i = 0; i < allUnvisitedProfils.size(); i++) {
			Aehnlichkeitsmass aehnlichkeitsindex = createAehnlichkeit(pro.getId(),
					allUnvisitedProfils.elementAt(i).getId());
			allAehnlichkeitsmassVonProfilen.addElement(aehnlichkeitsindex);
		}
		return allAehnlichkeitsmassVonProfilen;
	}

	@Override
	public Vector<Aehnlichkeitsmass> getAehnlicheProfileVonSuchprofilen(Profil pro) {
		Vector<Aehnlichkeitsmass> allAehnlichkeitsmassVonProfilenAnhandSuchprofilen = new Vector<Aehnlichkeitsmass>();
		Vector<Suchprofil> allSuchprofileVonProfil = this.getSuchprofilbyProfilId(pro);
		Vector<Profil> allProfiles = this.getAllProfils();
		for (int i = 0; i < allSuchprofileVonProfil.size(); i++) {
			for (int j = 0; j < allProfiles.size(); j++) {
				Profil profil = allProfiles.get(j);
				if (profil != pro) {
					Aehnlichkeitsmass aehnlichkeitsindex = createAehnlichkeit(
							allSuchprofileVonProfil.elementAt(i).getId(), allProfiles.elementAt(j).getId());
					allAehnlichkeitsmassVonProfilenAnhandSuchprofilen.addElement(aehnlichkeitsindex);
				}
			}
		}
		return allAehnlichkeitsmassVonProfilenAnhandSuchprofilen;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getAlterOf(Profil pro) throws IllegalArgumentException {
//		GregorianCalendar now = new GregorianCalendar();
		int alter = 0;
		Date today = new Date();
//		int now = today.getDate();
		Date geburtsdatum = pro.getGeburtsdatum();
		if(geburtsdatum.getYear() < today.getYear()) {
			alter = today.getYear() - geburtsdatum.getYear();
			if(geburtsdatum.getMonth() > today.getMonth()){
				if(geburtsdatum.getDay() > today.getDay()){
					alter = alter - 1;
				} else {
					alter = alter + 0;
				}
				
			}
		}
		
		
		
		return alter;
	}

	@Override
	public Vector<Kontaktsperre> getBlockedBy(Profil pro) throws IllegalArgumentException {
		return kontaktsperreMapper.getAllKontaktsperrenDesGesperrten(pro);
	}


}