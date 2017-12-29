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
	
	public Auswahleigenschaft createAuswahleigenschaft(String wert, int eigenschaftid) throws IllegalArgumentException;
	public void save(Auswahleigenschaft aus) throws IllegalArgumentException;
	public void delete(Auswahleigenschaft aus) throws IllegalArgumentException;
	public Auswahleigenschaft findByKeyAuswahleigenschaft(int id) throws IllegalArgumentException;
	public Vector <Auswahleigenschaft> getAllAuswahleigenschaft() throws IllegalArgumentException; 
	
	public Eigenschaft createEigenschaft(int eigenschaftid) throws IllegalArgumentException;
	public void save(Eigenschaft eig) throws IllegalArgumentException;
	public void delete(Eigenschaft eig) throws IllegalArgumentException;
	public Eigenschaft findbyKeyEigenschaft(int id) throws IllegalArgumentException;
	public Vector <Eigenschaft> getAllEigenschaft() throws IllegalArgumentException;
	
	public Freitexteigenschaft createFreitexteigenschaft(String wert, int eigenschaftid) throws IllegalArgumentException;
	public void save(Freitexteigenschaft frei) throws IllegalArgumentException;
	public void delete(Freitexteigenschaft frei) throws IllegalArgumentException;
	public Freitexteigenschaft findByKeyFreitexteigenschaft(int id) throws IllegalArgumentException;
	public Vector <Freitexteigenschaft> getAllFreitexteigenschaft() throws IllegalArgumentException;
	
	public Info createInfo(int profilid, String text, int eigenschaftid) throws IllegalArgumentException;
	public void save(Info in) throws IllegalArgumentException;
	public void delete(Info in) throws IllegalArgumentException;
	public Info findByKeyInfo(int id) throws IllegalArgumentException;
	public Vector <Info> getAllInfo() throws IllegalArgumentException;
	
	public Kontaktsperre createKontaktsperre(Kontaktsperre k) throws IllegalArgumentException;
	public Kontaktsperre save(Kontaktsperre k) throws IllegalArgumentException;
	public Kontaktsperre deleteKontaktsperre(Kontaktsperre k) throws IllegalArgumentException;
	public Kontaktsperre findById (int id) throws IllegalArgumentException;
	public Vector <Kontaktsperre> getAllKontaktsperre()throws IllegalArgumentException;
	
	public Merkzettel createMerkzettel(Merkzettel merk) throws IllegalArgumentException;
	public Merkzettel save(Merkzettel merk) throws IllegalArgumentException;
	public Merkzettel deleteMerkzettel(Merkzettel merk) throws IllegalArgumentException;
	public Merkzettel findByKey (int id) throws IllegalArgumentException; 
	public Vector <Merkzettel> getAllMerkzettel() throws IllegalArgumentException;
	
	Profil createProfil(String vorname, String nachname, Date geburtsdatum, int koerpergroesse, String religion,
			String haarfarbe, boolean raucher) throws IllegalArgumentException;
	public Profil deleteProfil(Profil pro) throws IllegalArgumentException;
	public Profil save(Profil pro) throws IllegalArgumentException;
	public Profil getProfilById (int id) throws IllegalArgumentException;
	public Vector <Profil> getAllProfil() throws IllegalArgumentException;
	
	public Suchprofil createSuchprofil(Suchprofil such) throws IllegalArgumentException;
	public Suchprofil save(Suchprofil such) throws IllegalArgumentException;
	public Suchprofil deleteSuchprofil(Suchprofil such) throws IllegalArgumentException;
	public Suchprofil findByKey1(int id) throws IllegalArgumentException;
	public Vector <Suchprofil> getAllSuchprofil () throws IllegalArgumentException;


}
