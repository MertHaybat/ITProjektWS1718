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

public class PartnerboerseAdministrationImpl extends RemoteServiceServlet implements PartnerboerseAdministration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * Konstruktor
	 */
	public PartnerboerseAdministrationImpl() {

	}

	/**
	 * Hierbei handelt es sich um die Initialisierungsmethode. Diese Methode ist
	 * relevant, damit sie f�r jede Instanz von
	 * <code>PartnerboerseAdministrationImpl</code> aufgerufen werden kann.
	 */

	public void init() {
		/**
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

	public Auswahleigenschaft createAuswahleigenschaft(String wert) {

		Auswahleigenschaft aus = new Auswahleigenschaft();
		aus.setWert(wert);
		/**
		 * Setzen einer vorl�ufigen ID.
		 */
		aus.setId(1);

		// Objekt in der DB speichern.
		return this.auswahleigenschaftMapper.insertAuswahleigenschaft(aus);
	}

	/**
	 * Speichern der Auswahleigenschaft.
	 */

	public void save(Auswahleigenschaft aus) {

		try {
			auswahleigenschaftMapper.updateAuswahleigenschaft(aus);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Auswahleigenschaft. Dabei wird die Referenz zu Info auch
	 * gel�scht.
	 */

	public void delete(Auswahleigenschaft aus) {

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

	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) {

		return this.auswahleigenschaftMapper.findByKey(id);
	}

	/**
	 * Auslesen aller Auswahleigenschaften.
	 */
	
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaft() {
		try {
			return this.auswahleigenschaftMapper.getAll();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen aller Auswahleigenschaften eines bestimmten Info-Objekts.
	 */
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaftOf(Info in) {
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

	/**
	 * speichern der Eignschaft
	 */
	public void save(Eigenschaft eig) {

		try {
			eigenschaftMapper.updateEigenschaft(eig);
		} catch (Exception e) {

		}
	}

	/**
	 * Löschen der Eigenschaft
	 */
	public void delete(Eigenschaft eig) {

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

	public Freitexteigenschaft createFreitexteigenschaft(String wert) {
		try {
			Freitexteigenschaft frei = new Freitexteigenschaft();
			frei.setWert(wert);
			frei.setId(1);
			return this.freitexteigenschaftMapper.insertFreitexteigenschaft(frei);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return null;

	}

	/**
	 * Speichern der Freitexteigenschaft.
	 */

	
	public void save(Freitexteigenschaft frei) {

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
	public void delete(Freitexteigenschaft frei) {

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
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaftOf(Info in) {
		return this.freitexteigenschaftMapper.getAllFreitexteigenschaftOf(in);
	}

	/**
	 * Auslesen der Freitexteigenschaft, in dem die ID aufgerufen wird.
	 */
	
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) {

		return this.freitexteigenschaftMapper.findByKey(id);
	}

	/**
	 * Auslesen aller Freitexteigenschaften.
	 */
	
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaft() {

		return this.freitexteigenschaftMapper.getAll();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Auslesen aller Infos des Profils Profils.
	 */
	public Vector<Info> getAllInfobyProfil(Profil pro) {

		return infoMapper.getInfoIdByProfilId(pro);
	}

	/**
	 * <p>
	 * Anlegen einer Info. Dabei wird dies in der Datenbank gespeichert, in dem
	 * die insertInfo des Info-Mapper aufgerufen wird.
	 * </p>
	 */
	
	public Info createInfo(String email, Integer auswahleigenschaftid, String freitexteigenschaftwert,
			String auswahleigenschaftwert) {
		try {
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
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return null;
	}

	/**
	 * Speichern der Info.
	 */
	
	public void save(Info in) {
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
	
	public void delete(Info in) {

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
	public void deleteInfoOf(Profil pro) {
		try {
			this.infoMapper.deleteInfoOf(pro);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info des Suchprofil_Info.
	 */
	public void deleteInfoOf(Suchprofil_Info suchinfo) {
		try {
			this.infoMapper.deleteInfoOf(suchinfo);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info, welche eine Auswahleigenschaft ist.
	 */
	public void deleteInfoAs(Auswahleigenschaft aus) {
		try {
			this.infoMapper.deleteInfoOf(aus);
		} catch (Exception e) {

		}
	}

	/**
	 * L�schen der Info, welche eine Freitexteigenschaft ist.
	 */
	public void deleteInfoAs(Freitexteigenschaft frei) {
		try {
			this.infoMapper.deleteInfoOf(frei);
		} catch (Exception e) {

		}
	}

	/**
	 * Auslesen aller Infos eines Profils.
	 */
	public Vector<Profil> getAllInfosOf(Profil pro) {
		try {
			this.infoMapper.getInfoIdByProfilId(pro);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen der Info, in dem die ID aufgerufen wird.
	 */
	
	public Info findByKeyInfo(int id) {
		try {
			return this.infoMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen aller Infos.
	 */
	
	public Vector<Info> getAllInfo() {
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
	public Kontaktsperre createKontaktsperre(Profil pro, int profilId_gesperrter) {
		Kontaktsperre sperre = new Kontaktsperre();
		sperre.setProfilId_sperrender(pro.getId());
		sperre.setProfilId_gesperrter(profilId_gesperrter);
		kontaktsperreMapper.insertKontaktsperre(sperre);
		return sperre;
	}

	/**
	 * Hier wird eine Kontaktsperre aufgehoben.
	 */
	public void deleteKontaktsperreOf(Profil pro, int profilId_gesperrter) {
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
	 * @param pro
	 * @return vectorprofil
	 */
	public Vector<Profil> showBlockedProfilsOf(Profil pro) {
		Vector<Kontaktsperre> allBlockedProfiles = this.getAllKontaktsperreOf(pro);
		Vector<Profil> vectorprofil = new Vector<Profil>();
		System.out.println(allBlockedProfiles);
		for (int i = 0; i < allBlockedProfiles.size(); i++) {
			vectorprofil.addElement(getProfilById(allBlockedProfiles.elementAt(i).getProfilId_gesperrter()));
		}

		return vectorprofil;

	}
	
	/**
	 * Auslesen aller User eines Profils die den Teilnehmer auf die Kontaktsperre gesetzt wurden
	 * @param pro
	 * @return vectorprofil
	 */
	public Vector<Profil> showAllBlockerOf(Profil pro) {
		Vector<Kontaktsperre> allBlockedProfiles = this.getBlockedBy(pro);
		Vector<Profil> vectorprofil = new Vector<Profil>();
		System.out.println(allBlockedProfiles);
		for (int i = 0; i < allBlockedProfiles.size(); i++) {
			vectorprofil.addElement(getProfilById(allBlockedProfiles.elementAt(i).getProfilId_sperrender()));
		}

		return vectorprofil;
	}

	/**
	 * Auslesen aller Kontaktsperren eines Profils
	 * @param pro
	 * @return kontaktsperreMapper
	 */
	public Vector<Kontaktsperre> getAllKontaktsperreOf(Profil pro) {

		return kontaktsperreMapper.getAllKontaktsperrenDesSperrenden(pro);
	}

	/**
	 * Speichern einer Kontaktsperre
	 * @param sperre
	 * @return null
	 */
	public Kontaktsperre save(Kontaktsperre sperre) {

		try {
			kontaktsperreMapper.updateKontaktsperre(sperre);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Auslesen einer Kontaktsperre anhand der Kontaktsperren-id
	 * @param id
	 * @return null
	 */
	public Kontaktsperre findById(int id) {
		try {
			this.kontaktsperreMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Alle Kontaktsperren aus der Partnerbörse auslesen
	 */
	public Vector<Kontaktsperre> getAllKontaktsperre() {
		try {
			this.kontaktsperreMapper.getAllKontaktsperre();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Löschen einer Kontaktsperre
	 */
	public void delete(Kontaktsperre sperre) {

		this.kontaktsperreMapper.deleteKontaktsperre(sperre);
	}

	//////////////////////////////////////// Merkzettel/////////////////////////////////////////////////////////////////////////////////
	/**
	 * Mit diesere Methode werden alle Merkzettel anhand der Profil Id des
	 * Merkenden angezeigt. DIes ist eine Hilfsmethode fÃ¼r andere Operationen
	 * in dieser Klasse.
	 *@param pro
	 *@return merkzettelMapper
	 * 
	 */
	public Vector<Merkzettel> getAllMerkzettelOf(Profil pro) {

		return merkzettelMapper.getAllMerkezettelDesMerkers(pro);
	}

	/**
	 * Methode um ein einzelnes Profil auf den Merkzettel zu setzen. LoggedIn
	 * steht fÃ¼r den Merkenden User der andere Teilnehmer auf seine
	 * Merkliste(Merkzettel) setzt.
	 * @param pro, profilId_gemerkter
	 * @return merkzettelMapper
	 * 
	 */

	public Merkzettel createMerkzettel(Profil pro, int profilId_gemerkter) {
		Merkzettel merk = new Merkzettel();
		merk.setProfilId_merkender(pro.getId());
		merk.setProfilId_gemerkter(profilId_gemerkter);

		merk.setId(1);
		return this.merkzettelMapper.insertMerkzettel(merk);

	}

	/**
	 * Methode zum Loeschen eines Profils von der Merkliste.
	 */
	public void deleteProfilVonMerkliste(Profil pro, int profilId_gemerkter) {
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
	 * @param pro
	 * @return profiles
	 */
	public Vector<Profil> showMerklisteOf(Profil pro) {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Merkzettel> allGemerkteProfile = this.getAllMerkzettelOf(pro);

		for (int i = 0; i < allGemerkteProfile.size(); i++) {
			profiles.addElement(getProfilById(allGemerkteProfile.elementAt(i).getProfilId_gemerkter()));
		}

		return profiles;

	}
	/**
	 * Auslesen aller User eines Profils die den Teilnehmer auf den Merkzettel
	 * gesetzt haben
	 * 
	 * @param pro
	 * @return profiles
	 */
	public Vector<Profil> showMerkendeOf(Profil pro) {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Merkzettel> merkendeProfiles = merkzettelMapper.merkzettel_showGemerkteProfile(pro.getId());

		for (int i = 0; i < merkendeProfiles.size(); i++) {
			profiles.addElement(getProfilById(merkendeProfiles.elementAt(i).getProfilId_merkender()));
		}

		return profiles;
	}

	/**
	 * Auslesen aller User eines Profils die vom Teilnehmer besucht wurden
	 * @param pro
	 * @return profiles  
	 */
	public Vector<Profil> showBesuchteOf(Profil pro) {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Besuch> besucher = besuchMapper.getAllBesucherOfProfil(pro);

		for (int i = 0; i < besucher.size(); i++) {
			profiles.addElement(getProfilById(besucher.elementAt(i).getBesuchenderNutzerID()));
		}

		return profiles;
	}

	/**
	 * Auslesen aller User eines Profils die den Teilnehmer besucht haben
	 * @param pro
	 * @return profiles  
	 */
	public Vector<Profil> showBesucherOf(Profil pro) {
		Vector<Profil> profiles = new Vector<Profil>();
		Vector<Besuch> besucher = this.getAllBesucheOf(pro);

		for (int i = 0; i < besucher.size(); i++) {
			profiles.addElement(getProfilById(besucher.elementAt(i).getBesuchterNutzerID()));
		}

		return profiles;
	}

	/**
	 * Speichern eines Merkzettels
	 * @param merk
	 */
	public void save(Merkzettel merk) {

		try {
			merkzettelMapper.updateMerkzettel(merk);
		} catch (Exception e) {

		}
	}

	/**
	 * Auslesen eines Merkzettel anhand der MerkzettelId
	 * @param id
	 * @return null
	 */
	public Merkzettel findByKey(int id) {
		try {
			this.merkzettelMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Löschen eines Merkzettels
	 * @param merk
	 */
	public void delete(Merkzettel merk) {
		Merkzettel m = new Merkzettel();
		m.setProfilId_gemerkter(merk.getProfilId_gemerkter());
		m.setProfilId_merkender(merk.getProfilId_merkender());
		this.merkzettelMapper.deleteMerkzettel(m);
	}

	/////////////////////////////////////////// Suchprofil//////////////////////////////////////////////////////////////////////////////

	/**
	 * Diese Methode erzeugt ein neues Suchprofil.
	 * @param haarfarbe, religion, körpergröße, raucher, geschlecht, minalter, maxalter, profilId
	 * @return suchprofilMapper
	 */
	
	public Suchprofil createSuchprofil(String haarfarbe, String religion, int körpergröße, String raucher,
			String geschlecht, int minalter, int maxalter, int profilId) {

		Suchprofil suchpro = new Suchprofil();
		if (haarfarbe != null) {
			suchpro.setHaarfarbe(haarfarbe);
		} else {
			suchpro.setHaarfarbe(null);
		}

		if (körpergröße != 0) {
			suchpro.setKoerpergroesse(körpergröße);
		} else {
			suchpro.setKoerpergroesse(0);
		}

		if (maxalter != 0) {
			suchpro.setMaxAlter(maxalter);
		} else {
			suchpro.setMaxAlter(0);
		}

		if (minalter != 0) {
			suchpro.setMinAlter(minalter);
		} else {
			suchpro.setMinAlter(0);
		}

		if (raucher != null) {
			suchpro.setRaucher(raucher);
		} else {
			suchpro.setRaucher(null);
		}

		if (religion != null) {
			suchpro.setReligion(religion);
		} else {
			suchpro.setReligion(null);
		}

		if (geschlecht != null) {
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
	
	public void deleteSuchprofil(Suchprofil pro) {
		suchprofilMapper.deleteProfil(pro);

	}
	/**
	 * Die Suchprofilinformationen werden gelöscht
	 * @param suchpro
	 */
	public void delete(Suchprofil suchpro) {
		Vector<Info> suchprofilInfo = getAllInfoOf(suchpro);
		for (int i = 0; i < suchprofilInfo.size(); i++) {
			infoMapper.deleteInfo(suchprofilInfo.elementAt(i));
		}
		suchprofilMapper.deleteProfil(suchpro);
	}
	/**
	 * Auslesen aller Profile aus Suchprofil
	 * @param suchpro
	 * @return profilMapper
	 */
	public Vector<Profil> getAllProfilsOf(Suchprofil suchpro) {
		// Profil a = new Profil();
		// a.setId(suchpro.getProfilId());
		// Vector<Profil> foundProfiles =
		// this.profilMapper.getAllProfilBySuchprofil(suchpro);
		// Vector<Profil> blockedProfiles = this.showBlockedProfilsOf(a);
		// Vector<Profil> blockers = this.showAllBlockerOf(a);
		// for(int i = 0; i<foundProfiles.size(); i++){
		// foundProfiles.remove(blockedProfiles.elementAt(i));
		// foundProfiles.remove(blockers.elementAt(i));
		// }
		// int alter = 0;
		//
		//
		// for(int i = suchpro.getMinAlter(); i<suchpro.getMaxAlter(); i++ ){
		// alter = Integer.parseInt(new
		// Date().toString())-Integer.parseInt(foundProfiles.elementAt(i).getGeburtsdatum().toString());
		//
		// }

		return this.profilMapper.getAllProfilBySuchprofil(suchpro);
	}
	/**
	 * Auslesen aller Profile anhand der Info aus Suchprofil
	 * @param suchpro
	 * @reutn profiles
	 */
	public Vector<Profil> getAllProfilesByInfoOf(Suchprofil suchpro) {
		Vector<Profil> profiles = this.getAllProfils();
		Vector<Info> suchprofilInfos = this.getAllInfoOf(suchpro);

		for (int k = 0; k < profiles.size(); k++) {
			profiles.elementAt(k);
			Vector<Info> infosOfProfiles = this.getAllInfobyProfil(profiles.elementAt(k));
			for (int j = 0; j < infosOfProfiles.size(); j++) {
				for (int i = 0; i < suchprofilInfos.size(); i++) {
					if (suchprofilInfos.elementAt(i) == infosOfProfiles.elementAt(j)) {
						profiles.add(profiles.elementAt(k));
					}
				}
			}
		}
		return profiles;
	}
	
	/**
	 * Alle Infos aus Suchprofil auslesen
	 * @param suchpro
	 * @return null
	 */
	public Vector<Info> getAllInfoOf(Suchprofil suchpro) {
		// return this.infoMapper.getAllForSuchprofil();
		return null;
	}
	
	/**
	 * Alle Informationen aus Profil auslesen
	 * @param pro
	 * @return infoMapper
	 */
	public Vector<Info> getAllInfoOf(Profil pro) {
		return this.infoMapper.getAll();
	}

	/**
	 * Mit dieser Hilfsmethode kÃ¶nnen alle Suchprofile des einzelenen
	 * Teilnehmers herausgesucht und angezeigt werden. Dies geschieht Ã¼ber die
	 * Profil Id des Users.
	 * 
	 * @param pro
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
	 * der Db  herausgefiltert.
	 * @param id
	 * @return 
	 */
	public Suchprofil findByKey1(int id) {
		try {
			return this.suchprofilMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Diese Methode zeigt alle Suchprofile der PartnerbÃ¶rse an.
	 * @return
	 */
	public Vector<Suchprofil> getAllSuchprofil() {

		return this.suchprofilMapper.getAllSuchprofil();
	}

	/**
	 * Es ist mÃ¶glich ein Suchprofil des einzelnen Users anhand der Profil ID
	 * heauszusuchen.
	 * @param pro
	 * @return
	 */
	public Vector<Suchprofil> getSuchprofilbyProfilId(Profil pro) {
		try {
			return suchprofilMapper.getSuchprofilIdByProfil(pro);
		} catch (Exception e) {

		}
		return null;
	}
	

	/**
	 * speichern eines Suchprofiles
	 * @param such
	 * @return 
	 */
	public Suchprofil save(Suchprofil such) {

		try {
			suchprofilMapper.updateProfil(such);
		} catch (Exception e) {

		}
		return null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Auslesen aller Suchprofilinfos aus Info und Suchprofil
	 * @param in, such
	 * @return si
	 */
	public Suchprofil_Info getAllSuchprofilInfos(Info in, Suchprofil such) {

		Vector<Suchprofil_Info> suchinfo = suchprofil_infoMapper.getAllSuchprofilInfos(in, such);
		Suchprofil_Info si = new Suchprofil_Info();
		for (int i = 0; i < suchinfo.size(); i++) {
			si.setId(suchinfo.get(i).getId());
		}
		return si;
	}

	/**
	 * Auslesen aller SuchprofilInfos 
	 * @param in
	 * @return null
	 */
	public Vector<Suchprofil_Info> getAllSuchprofilInfoOf(Info in) {
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
	 */
	public Vector<Profil> getAllProfils() {
		try {
			return this.profilMapper.getAllProfil();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Mit dieser Methode wird ein Profil anhand der Gmail in der Datenbank
	 * gesucht.
	 * 
	 * @param email
	 * @return 
	 */
	public Profil getByEmail(String email) {
		try {
			return profilMapper.findByEmail(email);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 *Anlegen eines Profils in der Partnerbörse
	 *@param email, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, geschlecht, raucher
	 *@return
	 */
	public Profil createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse,
			String religion, String haarfarbe, String raucher, String geschlecht) {

		try {
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

		} catch (Exception e) {
			e.getLocalizedMessage();
		}

		return null;

	}

	/**
	 * Mit dieser Methode wird ein Profil aktualisiert.
	 * @param email, vorname, nachname, geburtsdatum, koerpergroesse, religion, haarfarbe, geschlecht, raucher
	 * @return pro
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

	/**
	 * speichern eines Profils
	 * @param pro
	 * 
	 */
	public void save(Profil pro) {
		try {
			this.profilMapper.updateProfil(pro);
		} catch (Exception e) {

		}
	}

	/**
	 * Hier wird ein erstelltes Profil gÃ¤nzlich aus der PartnerbÃ¶rse entfernt
	 * mit all seinen Daten und Informationen.
	 * @param pro
	 */
	public void delete(Profil pro) {

		//Kontaktsperre
		Vector<Kontaktsperre> sperre = this.getAllKontaktsperreOf(pro);

		for (int i = 0; i < sperre.size(); i++) {
			if (pro.getId() == sperre.elementAt(i).getProfilId_gesperrter()
					|| pro.getId() == sperre.elementAt(i).getProfilId_sperrender())
				kontaktsperreMapper.deleteKontaktsperreByProfil(sperre.elementAt(i));

		}

		// Merkzettel

		Vector<Merkzettel> merk = merkzettelMapper.getAllMerkezettel();

		for (int i = 0; i < merk.size(); i++) {
			if (pro.getId() == merk.elementAt(i).getProfilId_gemerkter()
					|| pro.getId() == merk.elementAt(i).getProfilId_merkender()) {
				merkzettelMapper.deleteMerkzettelbyprofil(merk.elementAt(i));
			}

		}

		// Besuch

		Vector<Besuch> besuche = besuchMapper.getAllBesuche();

		for (int i = 0; i < besuche.size(); i++) {
			if (pro.getId() == besuche.elementAt(i).getBesuchenderNutzerID()
					|| pro.getId() == besuche.elementAt(i).getBesuchterNutzerID()) {
				besuchMapper.deleteeinzeln(besuche.elementAt(i));
			}

		}

		// // SuchprofilInfo

		// Suchprofil

		Vector<Suchprofil> suchpro = this.getSuchprofilbyProfilId(pro);

		for (int i = 0; i < suchpro.size(); i++) {
			suchprofilMapper.deleteProfil(suchpro.elementAt(i));

		}

		// Info

		Vector<Info> infos = this.getAllInfo();
		Vector<Freitexteigenschaft> frei = this.getAllFreitexteigenschaft();
		for (int i = 0; i < infos.size(); i++) {
			if (pro.getId() == infos.elementAt(i).getProfilId()) {

				infoMapper.deleteInfo(infos.elementAt(i));
			}
		}

		for (int i = 0; i < frei.size(); i++) {
			if (pro.getId() == frei.elementAt(i).getId()) {
				freitexteigenschaftMapper.deleteFreitexteigenschaft(frei.elementAt(i));
			}
		}

		// AnschlieÃŸend das Profil entfernen

		profilMapper.deleteProfil(getProfilById(pro.getId()));
	}

	/**
	 * Es werden Profile der PartnerbÃ¶rse anhand der Profil Id aus der
	 * Datenbnak gefiltert.
	 * @param id
	 * @return
	 */
	public Profil getProfilById(int id) {
		try {
			return this.profilMapper.findByKey(id);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Hier werden alle Profile der PartnerbÃ¶rse herausgefiltert die sich in
	 * der Datenbank befinden.
	 * @return
	 */
	public Vector<Profil> getAllProfil() {
		try {
			return profilMapper.getAllProfil();
		} catch (Exception e) {

		}
		return null;
	}


	/**
	 * Diese Methode ist fÃ¼r den Login wichtig, da sie prÃ¼ft ob eine Gmal
	 * bereits in der Datenbank vorhanden ist. Gmail ist genau so einzigartig
	 * wie eine ID, denn diese gibt es nur einmal.
	 * 
	 * @param email
	 * @return profil
	 */
	public Profil pruefenAufExistenz(String email) {

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

	/**
	 * Anzeigen aller besuchten Profile
	 * @param pro
	 * @return allBesuche
	 */
	public Vector<Besuch> showVisitedProfiles(Profil pro) {

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
	 * @param pro, besuchterNutzerID
	 */
	public void deleteBesuche(Profil pro, int besuchterNutzerID) {
		// Vector<Besuch> allBesuche = new Vector<Besuch>();
		// allBesuche = this.getAllBesucheOf(pro);
		//
		// if (allBesuche != null) {
		// for (Besuch besuche : allBesuche) {
		// this.besuchMapper.deleteByProfilId(pro,
		// besuche.getBesuchterNutzerID());
		// }
		// }
		Besuch b1 = new Besuch();
		b1.setBesuchenderNutzerID(pro.getId());
		b1.setBesuchterNutzerID(besuchterNutzerID);
		this.besuchMapper.delete(b1);
	}

	/**
	 * Hilfsmethode zu anzeige aller Profile die vom besuchten aus besucht
	 * wurden.
	 * 
	 * @param pro
	 * @return 
	 */
	public Vector<Besuch> getAllBesucheOf(Profil pro) {
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
	 * @param pro
	 * @return allProfiles
	 */
	public Vector<Profil> getUnvisitedProfiles(Profil pro) {
		

		Vector<Profil> allProfiles = this.getAllProfils();
		for (int i = 0; i < allProfiles.size(); i++) {
			if (pro.getId() == allProfiles.elementAt(i).getId()) {
				allProfiles.remove(allProfiles.elementAt(i));
			}
		}
		System.out.println(allProfiles.size());
		Vector<Besuch> visitedProfiles = this.besuchMapper.findByKey(pro.getId());
		for (int o = 0; o < visitedProfiles.size(); o++) {
			allProfiles.remove(visitedProfiles.elementAt(o));
		}
		System.out.println(allProfiles.size());

		return allProfiles;

	}

	/**
	 * Diese Methode wird fÃ¼r die Methode getUnvisitedProfils benÃ¶tigt um zu
	 * prÃ¼fen welche Profile gesperrt sind.
	 * 
	 * @param pro
	 * @return sperrListe
	 */
	public boolean sperrPruefung(Profil pro) {
		Vector<Kontaktsperre> sperrL = getAllKontaktsperreOf(pro);
		boolean sperrListe = false;

		for (int i = 0; i < sperrL.size(); i++) {
			if (sperrL.elementAt(i).getId() == pro.getId())
				;
			{
				sperrListe = true;
			}
		}
		return sperrListe;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Auslesen einer Info anhand der ProfilId
	 * @param pro
	 * @return 
	 */
	public Vector<Info> getInfoIdByProfilId(Profil pro) {
		try {
			return infoMapper.getInfoIdByProfilId(pro);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Setzt besuch wenn ein Profil das andere Besucht
	 * 
	 * @param eigene_id
	 * @param fremde_id
	 * @return
	 */
	public Besuch visit(int eigene_id, int fremde_id) {
		Besuch besuch = new Besuch();
		besuch.setBesuchenderNutzerID(eigene_id);
		besuch.setBesuchterNutzerID(fremde_id);
		return besuchMapper.insert(besuch);
	}
	
	/**
	 * Überprüfen eines Profiles anhand der Email adresse
	 * @param email
	 * @return
	 */
	public Profil checkProfil(String email) {

		// Profil p = new Profil();
		// p.setEmail("hallo");
		// p.setGeburtsdatum(new Date());
		// p.setGeschlecht("hallo");
		// p.setHaarfarbe("Hallo");
		// p.setKoerpergroesse(123);
		// p.setNachname("halo");
		// p.setRaucher("hallo");
		// p.setReligion("hallo");
		// p.setVorname("hallo");
		// return p;
		try {
			if (profilMapper.findByEmail(email) == null) {
				return null;
			} else {
				return profilMapper.findByEmail(email);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;

	}

	/**
	 * Ähnlichkeitsmaß von Profil zu Profil
	 * 
	 * @param p1, p2
	 * @return prozent 
	 */
	public double berechneAhnlichkeitProfilProfil(Profil p1, Profil p2) {
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

	/**
	 * Anlegen eines Ähnlichkeitsmaßes von Profil zu Profil
	 * @param eigenes_profil, fremdes_profil
	 * @return
	 */
	public Aehnlichkeitsmass createAehnlichkeit(int eigenes_profil, int fremdes_profil) {

		Aehnlichkeitsmass a1 = new Aehnlichkeitsmass();
		a1.setEigenes_profilid(eigenes_profil);
		a1.setFremdes_profilid(fremdes_profil);
		int aehnlichkeitstreffer = 0;

		Profil profil1 = profilMapper.findByKey(eigenes_profil);
		Profil profil2 = profilMapper.findByKey(fremdes_profil);

		if (profil1 != null && profil2 != null) {
			if (profil1.getHaarfarbe().equals(profil2.getHaarfarbe())) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getKoerpergroesse() == profil2.getKoerpergroesse()) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getRaucher().equals(profil2.getRaucher())) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getReligion().equals(profil2.getReligion())) {
				aehnlichkeitstreffer++;
			}
			if (profil1.getGeschlecht().equals(profil2.getGeschlecht())) {
				aehnlichkeitstreffer++;
			}
			a1.setAehnlichkeitsindex(aehnlichkeitstreffer * 20);
		}
		// Hier ein Create-Mapper Aufruf

		return this.aehnlichkeitsmassMapper.insertAehnlichkeitsmass(a1);
	}

	/**
	 * Löschen eines Ähnlichkeitsmaßes
	 * @param a
	 * @return
	 */
	public void deleteAehnlichkeit(Aehnlichkeitsmass a) {
		aehnlichkeitsmassMapper.deleteAehnlichkeitsmass(a);
	}

	/**
	 * Finden eines Ähnlichkeitsmaßes anhand der ProfilId
	 * @param id
	 * @return 
	 */
	public Aehnlichkeitsmass findAehnlichkeitByProfilid(int id) {
		// TODO Auto-generated method stub
		return this.aehnlichkeitsmassMapper.findByKey(id);
	}

	/**
	 * Anzeigen aller Profile anhand der Ähnlichkeitsmaßes
	 * @return
	 */
	public Vector<Aehnlichkeitsmass> showAllAehnlichkeitByProfil() {
		// TODO Auto-generated method stub

		return this.aehnlichkeitsmassMapper.getAll();
	}

	/**Anzeigen aller ähnlichen Profile, die der Teilnehmer nicht besucht hat
	 * @param pro
	 * @return allAehnlichkeitsmassVonProfilen
	 * 
	 */
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

	/**
	 * Anzeigen aller ähnlichen Profile anhand der Sucprofile eines Users
	 * @param pro
	 * @return allAehnlichkeitsmassVonProfilenAnhandSuchprofilen
	 */
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

	/**
	 * Berechnen des Alters anhand des Geburtdatum
	 * @param pro
	 * @return alter
	 */
	@SuppressWarnings("deprecation")
	
	public int getAlterOf(Profil pro) {
		// GregorianCalendar now = new GregorianCalendar();
		int alter = 0;
		Date today = new Date();
		// int now = today.getDate();
		Date geburtsdatum = pro.getGeburtsdatum();
		if (geburtsdatum.getYear() < today.getYear()) {
			alter = today.getYear() - geburtsdatum.getYear();
			if (geburtsdatum.getMonth() > today.getMonth()) {
				if (geburtsdatum.getDay() > today.getDay()) {
					alter = alter - 1;
				} else {
					alter = alter + 0;
				}

			}
		}

		return alter;
	}

	/**
	 * Anzeigen aller Profile, die den Teilnehmer gesperrt haben
	 * @param pro
	 * @return 
	 */
	public Vector<Kontaktsperre> getBlockedBy(Profil pro) {
		return kontaktsperreMapper.getAllKontaktsperrenDesGesperrten(pro);
	}

}