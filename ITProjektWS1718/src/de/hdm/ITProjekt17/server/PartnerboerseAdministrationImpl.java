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
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Auswahleigenschaft insertAuswahleigenschaft(Auswahleigenschaft aus) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			auswahleigenschaftMapper.insertAuswahleigenschaft(aus);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Auswahleigenschaft updateAuswahleigenschaft(Auswahleigenschaft aus) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			auswahleigenschaftMapper.updateAuswahleigenschaft(aus);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Auswahleigenschaft deleteAuswahleigenschaft(Auswahleigenschaft aus) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			auswahleigenschaftMapper.deleteAuswahleigenschaft(aus);
		} catch(Exception e){
				
		}
		return null;
	}
	
	@Override
	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Auswahleigenschaft> getAllAuswahleigenschaft() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Eigenschaft insertEigenschaft(Eigenschaft eig) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			eigenschaftMapper.insertEigenschaft(eig);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Eigenschaft updateEigenschaft(Eigenschaft eig) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			eigenschaftMapper.updateEigenschaft(eig);
		} catch(Exception e){
			
		}
		
		return null;
	}

	@Override
	public Eigenschaft deleteEigenschaft(Eigenschaft eig) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			eigenschaftMapper.deleteEigenschaft(eig);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Eigenschaft findbyKeyEigenschaft(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Eigenschaft> getAllEigenschaft() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Freitexteigenschaft insertFreitexteigenschaft(Freitexteigenschaft frei) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			freitexteigenschaftMapper.insertFreitexteigenschaft(frei);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Freitexteigenschaft updateFreitexteigenschaft(Freitexteigenschaft frei) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			freitexteigenschaftMapper.updateFreitexteigenschaft(frei);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Freitexteigenschaft deleteFreitexteigenschaft(Freitexteigenschaft frei) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			freitexteigenschaftMapper.deleteFreitexteigenschaft(frei);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Freitexteigenschaft> getAllFreitexteigenschaft() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Info insertInfo(Info in) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			infoMapper.insertInfo(in);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Info updateInfo(Info in) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			infoMapper.updateInfo(in);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Info deleteInfo(Info in) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			infoMapper.deleteInfo(in);
		} catch(Exception e){
			
		}
		return null;
	}

	@Override
	public Info findByKeyInfo(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Info> getAllInfo() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
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
	public Kontaktsperre deleteKontaktsperre(Kontaktsperre k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ kontaktsperreMapper.deleteKontaktsperre(k);
		} catch (Exception e){
			
		}
		return null;
	}
	
	@Override
	public Kontaktsperre findById(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Kontaktsperre> getAllKontaktsperre() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Merkzettel createMerkzettel(Merkzettel merk) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ merkzettelMapper.insertMerkzettel(merk);
		} catch (Exception e) {
			
		}
		return null;
	}
	

	@Override
	public Merkzettel save(Merkzettel merk) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ merkzettelMapper.updateMerkzettel(merk);
		} catch (Exception e){
			
		}
		return null;
	}

	@Override
	public Merkzettel deleteMerkzettel(Merkzettel merk) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try{ merkzettelMapper.deleteMerkzettel(merk);
		} catch(Exception e){
			
		}
		return null;
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
		return null;
	}

	@Override
	public Vector<Suchprofil> getAllSuchprofil() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
		    pro.setRaucher(raucher);
		    
		    /*
		     * Setzen einer vorläufigen Kundennr. Der insert-Aufruf liefert dann ein
		     * Objekt, dessen Nummer mit der Datenbank konsistent ist.
		     */
		    pro.setId(1);
		    
		    return this.profilMapper.insertProfil(pro);

	}
	
	public Profil save(Profil pro){
		try{ profilMapper.updateProfil(pro);
		
		} catch (Exception e){
			
		}
		return null;
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
		return null;
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Profil insertProfil(Profil pro) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
