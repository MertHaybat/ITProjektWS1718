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
	public Auswahleigenschaft createAuswahleigenschaft(String wert, int eigenschaftid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Auswahleigenschaft aus = new Auswahleigenschaft();
		aus.setEigenschaftid(eigenschaftid);
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
			auswahleigenschaftMapper.deleteAuswahleigenschaft(aus);
		} catch(Exception e){
				
		}
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
	public Freitexteigenschaft createFreitexteigenschaft(String wert, int eigenschaftid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Freitexteigenschaft frei = new Freitexteigenschaft();
		frei.setEigenschaftid(eigenschaftid);
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
			freitexteigenschaftMapper.deleteFreitexteigenschaft(frei);
		} catch(Exception e){
			
		}
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
	
	public Vector<Info> getAllInfobyProfilid (int profilid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return infoMapper.getInfoIdByProfilId(profilid);
	}
	
	@Override
	public Info createInfo(int profilid, String text, int eigenschaftid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Info in = new Info();
		in.setProfilId(profilid);
		in.setText(text);
		in.setEigenschaftid(eigenschaftid);
		
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
			infoMapper.deleteInfo(in);
		} catch(Exception e){
			
		}
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

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Kontaktsperre createKontaktsperre(Kontaktsperre k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{
			kontaktsperreMapper.insertKontaktsperre(k);
		}	catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public Kontaktsperre save(Kontaktsperre k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{
			kontaktsperreMapper.updateKontaktsperre(k);
			}	catch(Exception e){
				
		}
		return null;
	}


	
	@Override
	public Kontaktsperre findById(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Kontaktsperre> getAllKontaktsperre( int profilId_sperrender) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return kontaktsperreMapper.getAllKontaktsperrenDesSperrenden(profilId_sperrender);
	}
	
	
	public void kontaktsperreHinzufügen(int profilId_sperrender, int profilId_gesperrter) throws IllegalArgumentException
	{
		
			Kontaktsperre sperre = new Kontaktsperre();
			
			sperre.setProfilId_sperrender(profilId_sperrender);
			sperre.setProfilId_gesperrter(profilId_gesperrter);
			
			kontaktsperreMapper.insertKontaktsperre(sperre);
	}
	
	@Override
	public void deleteKontaktsperre (Kontaktsperre sperre ) throws IllegalArgumentException {
		
		sperre.setProfilId_gesperrter(0);
		sperre.setProfilId_sperrender(0);
		
		try{
		kontaktsperreMapper.updateKontaktsperre(sperre);
		

		kontaktsperreMapper.deleteKontaktsperre(sperre);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public Vector<Merkzettel> getAllMerkzettel ( int profilId_merkender) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return merkzettelMapper.getAllMerkezettelDesMerkers(profilId_merkender);
	}
	
	
	@Override
	public Merkzettel createMerkzettel(int profilId_gemerkter, int profilId_merkender) throws IllegalArgumentException {
		
		
		Merkzettel merk = new Merkzettel();
		
		
		merk.setProfilId_gemerkter(profilId_gemerkter);
		
		merk.setProfilId_merkender(profilId_merkender);
				
		
		// TODO Auto-generated method stub
//		try { 
//			
//			merkzettelMapper.insertMerkzettel(merk);
//			
//		} 
//		
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		return this.merkzettelMapper.insertMerkzettel(merk);
	}
	

	@Override
	public void save(Merkzettel merk) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ merkzettelMapper.updateMerkzettel(merk);
		} catch (Exception e){
			
		}
	}

	
	
	public void  deleteMerkzettel(Merkzettel merk) throws IllegalArgumentException {
		
		merk.setProfilId_gemerkter(0);
		
		merk.setProfilId_merkender(0);
		
		// TODO Auto-generated method stub
		
		try { 
			merkzettelMapper.updateMerkzettel(merk);
			
			merkzettelMapper.deleteMerkzettel(merk);
			} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
//		return null;
	}
	
	@Override
	public Merkzettel findByKey(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Vector<Merkzettel> getAllMerkzettel() throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	public Suchprofil createSuchprofil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher, boolean geschlecht, int maxAlter, int minAlter, int profilId) throws IllegalArgumentException {

			Suchprofil suchpro = new Suchprofil();
			suchpro.setGeburtsdatum(geburtsdatum);
			suchpro.setHaarfarbe(haarfarbe);
			suchpro.setKoerpergroesse(koerpergroesse);
			suchpro.setMaxAlter(maxAlter);
			suchpro.setMinAlter(minAlter);
			suchpro.setProfilId(profilId);
			suchpro.setRaucher(raucher);
			suchpro.setReligion(religion);
			

			return suchprofilMapper.insertSuchprofil(suchpro);
	}

	
	
	@Override
	public Suchprofil save(Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ suchprofilMapper.updateProfil(such);
		
		} catch (Exception e){
			
		}
		return null;
	}
	
	
	

	// Vergleiche deleteProfil(AP-Schicht)!!!!!!!!!!!!!!!!!
	@Override
	/**
	 * Hier wird das Suchprofil gelöscht
	 * Um das Suchprofil zu löschen, müssen erst die Daten aus der Tabelle Suchprofil_Info gelöscht werden um das Suchprofil löschen zu können
	 */
	public void deleteSuchprofil(int profilid) throws IllegalArgumentException {
		Vector <Suchprofil> suchprofil = getSuchprofilbyProfilId(profilid);
		Vector <Info> info = getInfoIdByProfilId(profilid);
		Suchprofil_Info suchinfo = new Suchprofil_Info();

		for(int s = 0; s < suchprofil.size(); s++)
		{
			for(int i = 0; i < info.size(); i++)
			{ 
				 suchinfo = getAllSuchprofilInfos(suchprofil.get(s).getId(), info.get(i).getId());
				
				 
				}
			
			suchprofil_infoMapper.deleteSuchprofil_Info(suchinfo);
		}		
		
		
		Vector<Suchprofil> suchpro = getSuchprofilbyProfilId(profilid);
		
		for ( int i = 0; i < suchpro.size(); i++) 
		{
			suchprofilMapper.deleteProfil(suchpro.elementAt(i));
			
		}
		
	}
	
	
	

	@Override
	public Suchprofil findByKey1(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.suchprofilMapper.findByKey(id);
	}

	@Override
	public Vector<Suchprofil> getAllSuchprofil() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.suchprofilMapper.getAllSuchprofil();
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Suchprofil_Info getAllSuchprofilInfos (int infoid, int suchprofilid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Vector<Suchprofil_Info> suchinfo = suchprofil_infoMapper.getAllSuchprofilInfos(infoid, suchprofilid);;
		Suchprofil_Info si = new Suchprofil_Info();
		for(int i = 0; i < suchinfo.size(); i++) {
			si.setId(suchinfo.get(i).getId());
		}
		return si;
	}
	
//	public void deleteSuchprofilInfo (int profilid){
//		Vector <Suchprofil> suchp = suchprofilMapper.getSuchprofilIdByProfilId(profilid);
//		Vector <Info> info = infoMapper.getInfoIdByProfilId(profilid);
//		Vector <Suchprofil_Info> suchinfo = suchprofil_infoMapper.getAllSuchprofilInfos(infoid, suchprofilid);
//		
//		
//		for(int i=0; i < suchp.size(); i ++){
//			
//			if(suchp.get(i).getId())
//		}
		
		
//	}
	
	
	
	
	
	
	
	
	
	
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Profil getByEmail(String email) throws IllegalArgumentException {
		return profilMapper.findByEmail(email);
	}
	
	
	@Override
	public Profil createProfil(String email, String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher, boolean geschlecht) throws IllegalArgumentException {
		// TODO Auto-generated method stub
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
		    
		    /*
		     * Setzen einer vorläufigen Kundennr. Der insert-Aufruf liefert dann ein
		     * Objekt, dessen Nummer mit der Datenbank konsistent ist.
		     */
		    pro.setId(1);
		    
		    return this.profilMapper.insertProfil(pro);
		    
//		    return null;

	}
	
	public Profil saveProfil(String email, boolean geschlecht, String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher) {
		
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
			
			System.out.println("Die Aktualisierung konnte nicht durchgeführt werden");
		}
		return pro;
//		return null;
	}
	
	@Override
	public void deleteProfil(int profilid) throws IllegalArgumentException {
		
		// TODO Auto-generated method stub
			
		
		//Kontaktsperre
		
		Vector<Kontaktsperre> sperre= getAllKontaktsperre(profilid);
		
		for ( int i = 0; i < sperre.size(); i++) 
		{
			kontaktsperreMapper.deleteKontaktsperre(sperre.elementAt(i));
			
		}
		
		
		//Merkzettel
	
		Vector<Merkzettel> merk= getAllMerkzettel(profilid);
		
		for ( int i = 0; i < merk.size(); i++) 
		{
			merkzettelMapper.deleteMerkzettel(merk.elementAt(i));
			
		}
								
		//Besuch
		
		Vector<Besuch> besuche= getAllBesuche(profilid);
		
		for ( int i = 0; i < besuche.size(); i++) 
		{
			besuchMapper.delete(besuche.elementAt(i));
			
		}
	
		//SuchprofilInfo
		
		Vector <Suchprofil> suchprofil = getSuchprofilbyProfilId(profilid);
		Vector <Info> info = getInfoIdByProfilId(profilid);
		Suchprofil_Info suchinfo = new Suchprofil_Info();

		for(int s = 0; s < suchprofil.size(); s++)
		{
			for(int i = 0; i < info.size(); i++)
			{ 
				 suchinfo = getAllSuchprofilInfos(suchprofil.get(s).getId(), info.get(i).getId());
				
				 
				}
			
			suchprofil_infoMapper.deleteSuchprofil_Info(suchinfo);
		}		
		
		
		//Suchprofil

		Vector<Suchprofil> suchpro = getSuchprofilbyProfilId(profilid);
		
		for ( int i = 0; i < suchpro.size(); i++) 
		{
			suchprofilMapper.deleteProfil(suchpro.elementAt(i));
			
		}
	
		
		//Info
		
		
		//Aushwaleigenschaft
		
		
				
		//Freitexteigenschaft
		
		
		
		
		//Eigenschaft
		
		
	    

		// Anschließend das Profil entfernen
		  
		profilMapper.deleteProfil(getProfilById(profilid));
	}
	
	
	
	@Override
	public Profil getProfilById(int id) throws IllegalArgumentException {
		return this.profilMapper.findByKey(id);
	}
	
	@Override
	public Vector<Profil> getAllProfil() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return profilMapper.getAllProfil();
		
	}
	
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

	public Vector<Profil> showVisitedProfiles(int profilid) 
	{
		Vector<Besuch> allBesuche = new Vector<Besuch>();
		Vector<Profil> allBesuchtenProfile = new Vector<Profil>();
		
		allBesuche = besuchMapper.findByKey(profilid);
		for(int i = 0; i < allBesuche.size(); i++)
		{
			allBesuchtenProfile.add(getProfilById(allBesuche.get(i).getBesuchterNutzerID()));
		}
		
		return allBesuchtenProfile;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public void  deleteBesuche(Besuch besuche) throws IllegalArgumentException {
			
			besuche.setBesuchenderNutzerID(0);
			
			besuche.setBesuchterNutzerID(0);
			
			// TODO Auto-generated method stub
			
			try { 
				besuchMapper.update(besuche);
				
				besuchMapper.delete(besuche);
				} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	
	public Vector<Besuch> getAllBesuche (int besuchenderNutzerID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return besuchMapper.getAllBesucheDesBesuchenden(besuchenderNutzerID);
	}

	public Vector<Profil> getUnvisitedProfiles(int profilid) throws IllegalArgumentException
	{
		Vector<Profil> unvisitedProfiles = profilMapper.getAllProfil();
		Vector<Profil> visitedProfiles = showVisitedProfiles(profilid);
		System.out.println("Size visited Profiles: " + visitedProfiles.size() );
		
		for(int e = 0; e < visitedProfiles.size(); e++)
		{
			unvisitedProfiles.remove(visitedProfiles.get(e));
		}
		for(int i = 0; i < unvisitedProfiles.size(); i++)
		{
			if(sperrPrüfung(profilid, unvisitedProfiles.get(i).getId()) == true)
			{
				unvisitedProfiles.remove(i);
			}
		}
		
		return unvisitedProfiles;
	}
	
	public boolean sperrPrüfung(int profilId_sperrender, int profilId_gesperrter)
	{
	Vector<Kontaktsperre> sperrL = getAllKontaktsperre(profilId_sperrender);
	boolean sperrListe = false;
	for(int i = 0; i < sperrL.size(); i++)
	{
	if(sperrL.get(i).getId() == profilId_gesperrter)
	{
	sperrListe = true;
	}
	}
	return sperrListe;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Vector<Suchprofil> getSuchprofilbyProfilId(int profilid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return suchprofilMapper.getSuchprofilIdByProfilId(profilid);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Vector<Info> getInfoIdByProfilId( int profilid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return infoMapper.getInfoIdByProfilId(profilid);
	}

	@Override
	public Vector<Kontaktsperre> getAllKontaktsperre() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

//public Vector<Profil> getUnvisitedProfiles(int profilid) throws IllegalArgumentException
//{
//	Vector<Profil> unvisitedProfiles = profilMapper.getAllProfil();
//	Vector<Profil> visitedProfiles = showVisitedProfiles(profilid);
//	System.out.println("Size visited Profiles: " + visitedProfiles.size() );
//	
//	for(int e = 0; e < visitedProfiles.size(); e++)
//	{
//		unvisitedProfiles.remove(visitedProfiles.get(e));
//	}
//	for(int i = 0; i < unvisitedProfiles.size(); i++)
//	{
//		if(sperrPrüfung(profilid, unvisitedProfiles.get(i).getId()) == true)
//		{
//			unvisitedProfiles.remove(i);
//		}
//	}
//	
//	return unvisitedProfiles;
//}
//
//public boolean sperrPrüfung(int profilId_sperrender, int profilId_gesperrter)
//{
//Vector<Kontaktsperre> sperrL = getAllKontaktsperre(profilId_sperrender);
//boolean sperrListe = false;
//for(int i = 0; i < sperrL.size(); i++)
//{
//if(sperrL.get(i).getId() == profilId_gesperrter)
//{
//sperrListe = true;
//}
//}
//return sperrListe;
//}
//
//}

//public Vector<Profil> showVisitedProfiles(int profilid) 
//{
//	Vector<Besuch> allBesuche = new Vector<Besuch>();
//	Vector<Profil> allBesuchtenProfile = new Vector<Profil>();
//	
//	allBesuche = besuchMapper.findByKey(profilid);
//	for(int i = 0; i < allBesuche.size(); i++)
//	{
//		allBesuchtenProfile.add(getProfilById(allBesuche.get(i).getBesuchterNutzerID()));
//	}
//	
//	return allBesuchtenProfile;
//}