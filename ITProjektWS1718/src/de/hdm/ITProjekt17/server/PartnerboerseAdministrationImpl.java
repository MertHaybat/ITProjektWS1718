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
import de.hdm.ITProjekt17.shared.bo.Besuch;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import ClickandLove_Gruppe09_source_code.ClickandLove_Gruppe09.ClickandLove_Gruppe09.src.de.hdm.gruppe09.clickandlove.shared.bo.Sperre;



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
	@Override
	public Eigenschaft createEigenschaft(int eigenschaftid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Eigenschaft eig = new Eigenschaft();
		
		eig.setId(1);
		return this.eigenschaftMapper.insertEigenschaft(eig);
	}

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
//	@Override
//	public Kontaktsperre createKontaktsperre(Kontaktsperre k) throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		try{
//			kontaktsperreMapper.insertKontaktsperre(k);
//		}	catch(Exception e) {
//			
//		}
//		return null;
//	}

//	@Override
//	public Kontaktsperre save(Kontaktsperre k) throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		try{
//			kontaktsperreMapper.updateKontaktsperre(k);
//			}	catch(Exception e){
//				
//		}
//		return null;
//	}


	
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

	@Override
	public Vector<Merkzettel> getAllMerkzettel() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	@Override
	public Suchprofil createSuchprofil(Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ suchprofilMapper.insertSuchprofil(such);
		} catch (Exception e){
			
		}
		return null;
	}

	@Override
	public Suchprofil save(Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ suchprofilMapper.updateProfil(such);
		
		} catch (Exception e){
			
		}
		return null;
	}

	@Override
	public Suchprofil deleteSuchprofil(Suchprofil such) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ suchprofilMapper.deleteProfil(such);
		
		} catch (Exception e){
			
		}
		return null;
	}

	@Override
	public Suchprofil findByKey1(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.suchprofilMapper.findByKey(id);
	}

	@Override
	public Vector<Suchprofil> getAllSuchprofil() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Profil getByEmail(String email) throws IllegalArgumentException {
		return profilMapper.findByEmail(email);
	}
	
	
	@Override
	public Profil createProfil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		   Profil pro = new Profil();
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

	}
	
	public Profil save(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
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
	}
	
	@Override
	public Profil deleteProfil(Profil pro) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ profilMapper.deleteProfil(pro);
		} 
		catch (Exception e){
			
		}
		return null;
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
			if(isGesperrt(profilid, unvisitedProfiles.get(i).getId()))
			{
				unvisitedProfiles.remove(i);
			}
		}
		
		return unvisitedProfiles;
	}
}