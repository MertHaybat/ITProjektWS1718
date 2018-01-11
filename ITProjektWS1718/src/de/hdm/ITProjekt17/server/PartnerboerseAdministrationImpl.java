package de.hdm.ITProjekt17.server;

import de.hdm.ITProjekt17.server.db.*;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministration;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;




@SuppressWarnings("serial")
public class PartnerboerseAdministrationImpl extends RemoteServiceServlet 
implements PartnerboerseAdministration {

	private AuswahleigenschaftMapper auswahleigenschaftMapper = null;
	private EigenschaftMapper eigenschaftMapper = null;
	private FreitexteigenschaftMapper freitexteigenschaftMapper = null;
	private InfoMapper infoMapper = null;
	private ProfilMapper profilMapper = null;
	private KontaktsperreMapper kontaktsperreMapper = null;
	private MerkzettelMapper merkzettelMapper = null;
	private SuchprofilMapper suchprofilMapper = null;
	private Suchprofil_InfoMapper suchprofil_infoMapper = null;
	private BesuchMapper besuchMapper = null;
	
	public PartnerboerseAdministrationImpl() throws IllegalArgumentException {
		
	}
	
	public void init() throws IllegalArgumentException{
		
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
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Auswahleigenschaft createAuswahleigenschaft(String wert) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Auswahleigenschaft aus = new Auswahleigenschaft();
		aus.setWert(wert);
		
		aus.setId(1);
		return this.auswahleigenschaftMapper.insertAuswahleigenschaft(aus);
	}

	@Override
	public void save(Auswahleigenschaft aus) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			auswahleigenschaftMapper.updateAuswahleigenschaft(aus);
		} catch(Exception e){
			
		}
	}

	@Override
	public void delete(Auswahleigenschaft aus) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			Vector<Info> auswahlinfo = this.getAllInfosAsAuswahleigenschaft(aus);
			if (auswahlinfo != null){
				for(Info aus1 : auswahlinfo){
					this.delete(aus1);
				} 
				auswahleigenschaftMapper.deleteAuswahleigenschaft(aus);
			}
		} catch(Exception e){
			
		}
	}

	
	public Vector<Info> getAllInfosAsAuswahleigenschaft(Auswahleigenschaft aus){
		try {
			return this.infoMapper.getAllInfosAsAuswahleigenschaft(aus);
		} catch (Exception e){
		
		}
		return null;
	}

	@Override
	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.auswahleigenschaftMapper.findByKey(id);
	}

	@Override
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaft() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		return this.auswahleigenschaftMapper.getAll();
	}

	public Vector<Auswahleigenschaft> getAllAuswahleigenschaftOf(Info in) throws IllegalArgumentException {
		return this.auswahleigenschaftMapper.getAllAuswahleigenschaftOf(in);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	@Override
//	public Eigenschaft createEigenschaft(int eigenschaftid) throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		Eigenschaft eig = new Eigenschaft();
//		
//		eig.setId(1);
//		return this.eigenschaftMapper.insertEigenschaft(eig);
//	}

	@Override
	public void save(Eigenschaft eig) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			eigenschaftMapper.updateEigenschaft(eig);
		} catch(Exception e){
			
		}
	}

	@Override
	public void delete(Eigenschaft eig) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			eigenschaftMapper.deleteEigenschaft(eig);
		} catch(Exception e){
			
		}
	}

	@Override
	public Eigenschaft findbyKeyEigenschaft(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.eigenschaftMapper.findByKey(id);
	}

	@Override
	public Vector<Eigenschaft> getAllEigenschaft() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.eigenschaftMapper.getAll();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Freitexteigenschaft createFreitexteigenschaft(String wert) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Freitexteigenschaft frei = new Freitexteigenschaft();
		frei.setWert(wert);
		
		frei.setId(1);
		return this.freitexteigenschaftMapper.insertFreitexteigenschaft(frei);
	}

	@Override
	public void save(Freitexteigenschaft frei) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			freitexteigenschaftMapper.updateFreitexteigenschaft(frei);
		} catch(Exception e){
			
		}
	}

	@Override
	public void delete(Freitexteigenschaft frei) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			Vector<Info> freitextinfo = this.getAllInfosAsFreitexteigenschaft(frei);
			if (freitextinfo != null){
				for(Info frei1 : freitextinfo){
					this.delete(frei1);
				} 
				freitexteigenschaftMapper.deleteFreitexteigenschaft(frei);
			}
		} catch(Exception e){
			
		}
	}

	
	public Vector<Info> getAllInfosAsFreitexteigenschaft(Freitexteigenschaft frei){
		try {
			return this.infoMapper.getAllInfosAsFreitexteigenschaft(frei);
		} catch (Exception e){
		
		}
		return null;
	}
	
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaftOf(Info in) throws IllegalArgumentException {
		return this.freitexteigenschaftMapper.getAllFreitexteigenschaftOf(in);
	}

	@Override
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.freitexteigenschaftMapper.findByKey(id);
	}

	@Override
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaft() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.freitexteigenschaftMapper.getAll();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Vector<Info> getAllInfobyProfil(Profil pro) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return infoMapper.getInfoIdByProfilId(pro);
	}
	
	@Override
	public Info createInfo(Profil pro, String text, Auswahleigenschaft aus, Freitexteigenschaft frei) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Info in = new Info();
		in.setProfilId(pro.getId());
		in.setText(text);
		in.setAuswahleigenschaftid(aus.getId());
		in.setFreitexteigenschaftid(frei.getId());
		
		in.setId(1);
		return this.infoMapper.insertInfo(in);
	}

	@Override
	public void save(Info in) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			infoMapper.updateInfo(in);
		} catch(Exception e){
			
		}
	}

	@Override
	public void delete(Info in) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			Vector<Auswahleigenschaft> auswahlinfo = new Vector<Auswahleigenschaft>();
			
			auswahlinfo = this.getAllAuswahleigenschaftOf(in);
			if (auswahlinfo != null){
				for (Auswahleigenschaft a : auswahlinfo) {
					this.auswahleigenschaftMapper.deleteAuswahleigenschaft(a);
				}
			}
			
			Vector<Freitexteigenschaft> freitextinfo = new Vector<Freitexteigenschaft>();
			
			freitextinfo = this.getAllFreitexteigenschaftOf(in);
			if (freitextinfo != null){
				for (Freitexteigenschaft f : freitextinfo) {
					this.freitexteigenschaftMapper.deleteFreitexteigenschaft(f);
				}
			}
			
			Vector<Suchprofil_Info> suchproInfo = new Vector<Suchprofil_Info>();
			
			suchproInfo = this.getAllSuchprofilInfoOf(in);
			if (suchproInfo != null){
				for (Suchprofil_Info spi : suchproInfo) {
					this.suchprofil_infoMapper.deleteSuchprofil_Info(spi);
				}
			}
			
			infoMapper.deleteInfo(in);
			
		} catch(Exception e){
			
		}
	}
	
	public void deleteInfoOf(Profil pro) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(pro);
		} catch (Exception e){
			
		}
	}
	
	public void deleteInfoOf(Suchprofil_Info suchinfo) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(suchinfo);
		} catch (Exception e){
			
		}
	}

	public void deleteInfoAs(Auswahleigenschaft aus) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(aus);
		} catch (Exception e){
			
		}
	}	
	
	public void deleteInfoAs(Freitexteigenschaft frei) throws IllegalArgumentException {
		try {
			this.infoMapper.deleteInfoOf(frei);
		} catch (Exception e){
			
		}
	}
	public Vector<Profil> getAllInfosOf(Profil pro) throws IllegalArgumentException {
		try {
			this.infoMapper.getInfoIdByProfilId(pro);
		} catch (Exception e){
			
		}
		return null;
	}
	
	@Override
	public Info findByKeyInfo(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.infoMapper.findByKey(id);
	}

	@Override
	public Vector<Info> getAllInfo() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.infoMapper.getAll();
	}

	//////////////////////////////////////////////Kontaktsperre///////////////////////////////////////////////////////////////////////////
	
	/**
	 * Methode um ein einzelnes Profil auf die Sperrliste zu setzen.
	 * LoggedIn steht fuer den Sperrenden User der andere Teilnehmer auf die Sperrliste setzt.
	 */
	public void createKontaktsperre(int profilId_sperrender, int profilId_gesperrter) throws IllegalArgumentException
	{
			Kontaktsperre sperre = new Kontaktsperre();
			sperre.setProfilId_sperrender(profilId_sperrender);
			sperre.setProfilId_gesperrter(profilId_gesperrter);
			kontaktsperreMapper.insertKontaktsperre(sperre);
	}

	/**
	 * Hier wird eine Kontaktsperre aufgehoben.
	 */
	public void deleteKontaktsperreOf(Profil pro) throws IllegalArgumentException 
	{
		Vector<Kontaktsperre> result = new Vector<Kontaktsperre>();
		result = this.getAllKontaktsperreOf(pro);	
		

		    if (result != null) {
		      for (Kontaktsperre k : result) {
		        this.kontaktsperreMapper.deleteKontaktsperre(k);
		      }
		     
   }
}

	/**
	 * Auslesen aller User eines Profils die vom Teilnehmer auf die Kontaktsperre gesetzt wurden.
	 * @param merk
	 * @return
	 * @throws IllegalArgumentException
	 */
		public Vector<Kontaktsperre> showBlockedProfilsOf(Profil pro) throws IllegalArgumentException
		{
			Vector<Kontaktsperre> allBlockedProfils = new Vector<Kontaktsperre>();
			
			allBlockedProfils = this.getAllKontaktsperreOf(pro);
			
			for(int i = 0; i < allBlockedProfils.size(); i++)
			{
				 if (allBlockedProfils != null) {
					 
					 return allBlockedProfils;
				 }
	 
			}
			return null;
		}
	


	@Override
	public Vector<Kontaktsperre> getAllKontaktsperreOf(Profil pro) throws IllegalArgumentException {

		return kontaktsperreMapper.getAllKontaktsperrenDesSperrenden(pro);
	}
	
	
	@Override
	public Kontaktsperre save(Kontaktsperre sperre) throws IllegalArgumentException {
		
		try{
			kontaktsperreMapper.updateKontaktsperre(sperre);
			}	catch(Exception e){
				
		}
		return null;
	}


	////////////////////////////////////////Merkzettel/////////////////////////////////////////////////////////////////////////////////


	/**
	 * Mit diesere Methode werden alle Merkzettel anhand der Profil Id des Merkenden angezeigt.
	 * DIes ist eine Hilfsmethode fÃ¼r andere Operationen in dieser Klasse.
	 */
	public Vector<Merkzettel> getAllMerkzettelOf(Profil pro) throws IllegalArgumentException {
		
		return merkzettelMapper.getAllMerkezettelDesMerkers(pro);
	}
	
	/**
	 * Methode um ein einzelnes Profil auf den Merkzettel zu setzen.
	 * LoggedIn steht fÃ¼r den Merkenden User der andere Teilnehmer auf seine Merkliste(Merkzettel) setzt.
	 */
	public void createMerzettel(int profilId_merkender, int profilId_gemerkter) throws IllegalArgumentException
	{
			Merkzettel merk = new Merkzettel();
			merk.setProfilId_merkender(profilId_merkender);
			merk.setProfilId_gemerkter(profilId_gemerkter);
			merkzettelMapper.insertMerkzettel(merk);
	}

	/**
	 * Methode zum Loeschen eines Profils von der Merkliste.
	 */
	public void deleteProfilVonMerkliste(Profil pro) throws IllegalArgumentException 
	{
		Vector<Merkzettel> result = new Vector<Merkzettel>();
		
		result = this.getAllMerkzettelOf(pro);	

		    if (result != null) {
		      for (Merkzettel m : result) {
		        this.merkzettelMapper.deleteMerkzettel(m);
		      }
		    }
		}
		
	
	
/**
 * Auslesen aller User eines Profils die vom Teilnehmer auf den Merkzettel gesetzt wurden.
 * @param merk
 * @return
 * @throws IllegalArgumentException
 */
	public Vector<Merkzettel> showMerklisteOf(Profil pro) throws IllegalArgumentException
	{
		Vector<Merkzettel> allGemerkteProfile = new Vector<Merkzettel>();
	
		allGemerkteProfile = this.getAllMerkzettelOf(pro);
		
		for(int i = 0; i < allGemerkteProfile.size(); i++)
		{
			 if (allGemerkteProfile != null) {
				 
				 return allGemerkteProfile;
			 }
 
		}
		return null;
	}
	
	

	@Override
	public void save(Merkzettel merk) throws IllegalArgumentException {
		
		try{ merkzettelMapper.updateMerkzettel(merk);
		} catch (Exception e){
			
		}
	}
	
	
	///////////////////////////////////////////Suchprofil//////////////////////////////////////////////////////////////////////////////


	/**
	 * Diese Methode erzeugt ein neues Suchprofil.
	 */
	public Suchprofil createSuchprofil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, String raucher, boolean geschlecht, int maxAlter, int minAlter, int profilId) throws IllegalArgumentException {

			Suchprofil suchpro = new Suchprofil();
			suchpro.setGeburtsdatum(geburtsdatum);
			suchpro.setHaarfarbe(haarfarbe);
			suchpro.setKoerpergroesse(koerpergroesse);
			suchpro.setMaxAlter(maxAlter);
			suchpro.setMinAlter(minAlter);
			suchpro.setProfilId(profilId);
			suchpro.setRaucher(raucher);
			suchpro.setReligion(religion);
			suchpro.setGeschlecht(geschlecht);
			

			return suchprofilMapper.insertSuchprofil(suchpro);
	}


	// Vergleiche deleteProfil(AP-Schicht)!!!!!!!!!!!!!!!!!
	@Override
	/**
	 * Hier wird das Suchprofil gelÃ¶scht
	 * Um das Suchprofil zu lÃ¶schen, mÃ¼ssen erst die Daten aus der Tabelle Suchprofil_Info gelÃ¶scht werden um das Suchprofil lÃ¶schen zu kÃ¶nnen
	 */
	public void deleteSuchprofil(Profil pro) throws IllegalArgumentException {
		Vector <Suchprofil> suchprofil = getSuchprofilbyProfilId(pro);
		Vector <Info> info = getInfoIdByProfilId(pro);
		Suchprofil_Info suchinfo = new Suchprofil_Info();

		for(int s = 0; s < suchprofil.size(); s++)
		{
			for(int i = 0; i < info.size(); i++)
			{ 
				 suchinfo = getAllSuchprofilInfos(info.elementAt(i), suchprofil.elementAt(i));
				
				 
				}
			
			suchprofil_infoMapper.deleteSuchprofil_Info(suchinfo);
		}		
		
		
		Vector<Suchprofil> suchpro = getSuchprofilbyProfilId(pro);
		
		for ( int i = 0; i < suchpro.size(); i++) 
		{
			suchprofilMapper.deleteProfil(suchpro.elementAt(i));
			
		}
		
	}
	
	/**
	 * Mit dieser Hilfsmethode kÃ¶nnen alle Suchprofile des einzelenen Teilnehmers herausgesucht und angezeigt werden.
	 * Dies geschieht Ã¼ber die Profil Id des Users.
	 * @param profilId
	 * @return
	 */
	public Vector <Suchprofil> findSuchprofilByProfilId(Profil pro){
		
		return this.suchprofilMapper.getSuchprofilIdByProfil(pro);
	}
	

	/**
	 * Mit dieser Methode werden alle Suchprofile Ã¼ber die Suchprofil Id aus der Db heraus herausgefiltert.
	 */
	public Suchprofil findByKey1(int id) throws IllegalArgumentException {
		
		return this.suchprofilMapper.findByKey(id);
	}

	/**
	 * Diese Methode zeigt alle Suchprofile der PartnerbÃ¶rse an.
	 */
	public Vector<Suchprofil> getAllSuchprofil() throws IllegalArgumentException {
		
		return this.suchprofilMapper.getAllSuchprofil();
	}
	
	/**
	 * Es ist mÃ¶glich ein Suchprofil des einzelnen Users anhand der Profil ID heauszusuchen.
	 */
	public Vector<Suchprofil> getSuchprofilbyProfilId(Profil pro) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return suchprofilMapper.getSuchprofilIdByProfil(pro);
	}
//	Doppelt, eines muss entfernt werden!
	
	
	@Override
	public Suchprofil save(Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ suchprofilMapper.updateProfil(such);
		
		} catch (Exception e){
			
		}
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Suchprofil_Info getAllSuchprofilInfos (Info in, Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Vector<Suchprofil_Info> suchinfo = suchprofil_infoMapper.getAllSuchprofilInfos(in, such);
		Suchprofil_Info si = new Suchprofil_Info();
		for(int i = 0; i < suchinfo.size(); i++) {
			si.setId(suchinfo.get(i).getId());
		}
		return si;
	}
	
//	public void deleteSuchprofilInfo (Profil pro){
//		Vector <Suchprofil> suchp = suchprofilMapper.getSuchprofilIdByProfil(pro);
//		Vector <Info> info = infoMapper.getInfoIdByProfilId(pro);
//		Vector <Suchprofil_Info> suchinfo = suchprofil_infoMapper.getAllSuchprofilInfos(info, such);
//		
//		
//		for(int i=0; i < suchp.size(); i ++){
//			
//			if(suchp)
//		}
//		
		
//	}
	
	
	
	public Vector<Suchprofil_Info> getAllSuchprofilInfoOf(Info in) throws IllegalArgumentException {
		return this.suchprofil_infoMapper.getAllSuchprofilInfoOf(in);
	}
	
	
	
	
	
	
	

	////////////////////////////////////////////Profil/////////////////////////////////////////////////////////////////////////////
	/**
	 * Auslesen aller Profil-Objekte der PartnerbÃ¶rse in der Datenbank.
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector <Profil> getAllProfils() throws IllegalArgumentException{
		return this.profilMapper.getAllProfil();
	}
	
	
	/**
	 * Mit diesere Methode wird ein Profil anhand der Gmail in der Datenbank gesucht.
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Profil getByEmail(String email) throws IllegalArgumentException {
		return profilMapper.findByEmail(email);
	}
	
	
	/**
	 * Hier wird ein Profil angelegt.
	 */
	public Profil createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, String raucher, boolean geschlecht) throws IllegalArgumentException {
		
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
		    
		    return this.profilMapper.insertProfil(pro);
		    

	}
	
	
	/**
	 * Mit dieser Methode wird ein Profil aktualisiert.
	 */
	public Profil saveProfil(String email, boolean geschlecht, String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, String raucher) {
		
		Profil pro = new Profil();
		Profil vorhandenesProfil = getByEmail(email);
		
		
		try{ 
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
		
		} catch (Exception e){
			
			System.out.println("Die Aktualisierung konnte nicht durchgefÃ¼hrt werden");
		}
		return pro;

	}
	
	/**
	 * Hier wird ein erstelltes Profil gÃ¤nzlich aus der PartnerbÃ¶rse entfernt mit all seinen Daten und Informationen.
	 */
	public void delete(Profil pro) throws IllegalArgumentException {

	//	Vector <Profil> profil = this.getAllProfils();
		//Vector <Merkzettel> merk = this.getAllMerkzettel(profilid);
		
		//Kontaktsperre
		
		Vector<Kontaktsperre> sperre= this.getAllKontaktsperreOf(pro);
		
		for ( int i = 0; i < sperre.size(); i++) 
		{
			kontaktsperreMapper.deleteKontaktsperre(sperre.elementAt(i));
			
		}
		
		
		//Merkzettel
	
		Vector<Merkzettel> merk = this.getAllMerkzettelOf(pro);
		
		for ( int i = 0; i < merk.size(); i++) 
		{
			merkzettelMapper.deleteMerkzettel(merk.elementAt(i));
			
		}
								
		//Besuch
		
		Vector<Besuch> besuche= getAllBesucheOf(pro);
		
		for ( int i = 0; i < besuche.size(); i++) 
		{
			besuchMapper.delete(besuche.elementAt(i));
			
		}
	
		//SuchprofilInfo
		
		Vector <Suchprofil> suchprofil = this.getSuchprofilbyProfilId(pro);
		Vector <Info> info = getInfoIdByProfilId(pro);
		Suchprofil_Info suchinfo = new Suchprofil_Info();

		for(int s = 0; s < suchprofil.size(); s++)
		{
			for(int i = 0; i < info.size(); i++)
			{ 
				 suchinfo = getAllSuchprofilInfos(info.elementAt(i), suchprofil.elementAt(i));
				
				 
				}
			
			suchprofil_infoMapper.deleteSuchprofil_Info(suchinfo);
		}		
		
		
		//Suchprofil

		Vector<Suchprofil> suchpro = this.getSuchprofilbyProfilId(pro);
		
		for ( int i = 0; i < suchpro.size(); i++) 
		{
			suchprofilMapper.deleteProfil(suchpro.elementAt(i));
			
		}
	
		
		//Info
		
		Vector<Info> infos = this.getAllInfo();
		Vector<Auswahleigenschaft> aus = this.getAllAuswahleigenschaft();
		Vector<Freitexteigenschaft> frei = this.getAllFreitexteigenschaft();
		for (int i = 0; i < infos.size(); i++){
			infoMapper.deleteInfo(infos.elementAt(i));
		}
		
		for (int i = 0; i < aus.size(); i++) {
			auswahleigenschaftMapper.deleteAuswahleigenschaft(aus.elementAt(i));
		}

		for (int i = 0; i < frei.size(); i++) {
			freitexteigenschaftMapper.deleteFreitexteigenschaft(frei.elementAt(i));
		}
		
		
	    

		// AnschlieÃŸend das Profil entfernen
		  
		profilMapper.deleteProfil(getProfilById(pro.getId()));
	}
	
	
	
	/**
	 * Es werden Profile der PartnerbÃ¶rse anhand der Profil Id aus der Datenbnak gefiltert.
	 */
	public Profil getProfilById(int id) throws IllegalArgumentException {
		return this.profilMapper.findByKey(id);
	}
	
	/**
	 * Hier werden alle Profile der PartnerbÃ¶rse herausgefiltert die sich in der Datenbank befinden.
	 */
	public Vector<Profil> getAllProfil() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return profilMapper.getAllProfil();
		
	}
	// Doppelt, eines muss entfernt werden
	
	/**
	 * Diese Methode ist fÃ¼r den Login wichtig, da sie prÃ¼ft ob eine Gmal bereits in der Datenbank vorhanden ist.
	 * Gmail ist genau so einzigartig wie eine ID, denn diese gibt es nur einmal.
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Profil pruefenAufExistenz(String email) throws IllegalArgumentException {
		
		Profil profil = new Profil();
		Profil existingProfil = getByEmail(email);
		
		if(existingProfil == null)
		{
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
	
	
	/////////////////////////////////////Besuch////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Methode zum Löschen von Besuchen.
	 */
	public void deleteBesuche(Profil pro) throws IllegalArgumentException 
	{
		Vector<Besuch> allBesuche = new Vector<Besuch>();
		allBesuche = this.getAllBesucheOf(pro);
			

		    if (allBesuche != null) {
		      for (Besuch besuche : allBesuche) {
		        this.besuchMapper.delete(besuche);
		}
	}
}
	/**
	 * Hilfsmethode zu anzeige aller Profile die vom besuchten aus besucht wurden.
	 * @param besuchenderNutzerID
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Besuch> getAllBesucheOf(Profil pro) throws IllegalArgumentException {
		
		return besuchMapper.getAllBesucheDesBesuchenden(pro);
	}

	/**
	 * Hier werden nicht besuchte Profile angezeigt.
	 * Dies geschieht durch PrÃ¼fung, welche Profile schon besucht wurden, welche nicht besucht wurden und welche gesperrt sind.
	 * @param profilid
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Besuch> getUnvisitedProfiles(Profil pro) throws IllegalArgumentException
	{
		/**
		 * Besuche des Besuchenden werden hier abgerufen und in 
		 */
		Vector<Besuch> unvisitedProfiles = this.getAllBesucheOf(pro);
		Vector<Besuch> visitedProfiles = this.besuchMapper.findByKey(pro.getId());
		System.out.println("Size visited Profiles: " + visitedProfiles.size() );
		
		for(int visited = 0; visited < visitedProfiles.size(); visited++)
		{
			unvisitedProfiles.remove(visitedProfiles.get(visited));
		}
		for(int unVisited = 0; unVisited < unvisitedProfiles.size(); unVisited++)
		{
			if(sperrPruefung(pro) == true)
			{
				unvisitedProfiles.remove(unVisited);
			}
		}
		
		return unvisitedProfiles;
	}
	
	/**
	 * Diese Methode wird fÃ¼r die Methode getUnvisitedProfils benÃ¶tigt um zu prÃ¼fen welche Profile gesperrt sind.
	 * @param profilId_sperrender
	 * @param profilId_gesperrter
	 * @return
	 */
	public boolean sperrPruefung(Profil pro) throws IllegalArgumentException
	{
	Vector<Kontaktsperre> sperrL = getAllKontaktsperreOf(pro);
	boolean sperrListe = false;
	
	for(int i = 0; i < sperrL.size(); i++)
	{
		if(sperrL.get(i).getId() == pro.getId());
		{
			sperrListe = true;
		}
	}
	return sperrListe;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Vector<Info> getInfoIdByProfilId(Profil pro) throws IllegalArgumentException {
		
		return infoMapper.getInfoIdByProfilId(pro);
	}

	/**
	 * Setzt besuch wenn ein Profil das andere Besucht
	 * @param pro.getId()
	 * @param besuch.getBesuchterNutzerID
	 * @throws IllegalArgumentException
	 */
	public void visit(Profil pro) throws IllegalArgumentException
	{
			Besuch besuch = new Besuch();
			besuch.setBesuchenderNutzerID(pro.getId());
			besuch.setBesuchterNutzerID(besuch.getBesuchterNutzerID());
			besuchMapper.insert(besuch);	
	}
	
	public Profil checkProfil(String email) throws IllegalArgumentException {
				
		if(profilMapper.findByEmail(email) == null)
		{
			return null;
		}
		else
		{
			return profilMapper.findByEmail(email);
		}
		
	}
	/**
	 * Ähnlichkeitsmaß von Profil zu Profil
	 * @param p1, p2
	 * @return prozent
	 * @throws IllegalArgumentException
	 */
	public double berechneAhnlichkeitProfilProfil(Profil p1, Profil p2) throws IllegalArgumentException
	{
		double aehnlichkeitstreffer = 0;
		double prozent = 0;
		Profil profil1 = profilMapper.findByKey(p1.getId());
		Profil profil2 = profilMapper.findByKey(p2.getId());
		
		
		if (profil1 != null && profil2 != null){
			if (profil1.getHaarfarbe() == profil2.getHaarfarbe()){
				aehnlichkeitstreffer++;	
			}
			if (profil1.getKoerpergroesse() == profil2.getKoerpergroesse()){
				aehnlichkeitstreffer++;	
			}
			if (profil1.getRaucher() == profil2.getRaucher()){
				aehnlichkeitstreffer++;	
			}
			if (profil1.getReligion() == profil2.getReligion()){
				aehnlichkeitstreffer++;	
			}
			if (profil1.getGeschlecht() != profil2.getGeschlecht()){
				aehnlichkeitstreffer++;
			}
			prozent = aehnlichkeitstreffer*20;
		}
		
			return prozent;
		
			
	}

	
}
