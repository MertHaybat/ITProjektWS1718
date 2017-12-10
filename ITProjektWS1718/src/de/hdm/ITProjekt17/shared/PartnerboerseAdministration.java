package de.hdm.ITProjekt17.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.ITProjekt17.shared.bo.*;

@RemoteServiceRelativePath("partnerboerseadministration")
public interface PartnerboerseAdministration extends RemoteService {
	//testcommit
	public void init() throws IllegalArgumentException;
	
	/**
	 * Suchen eines Profil-Objekts, dessen ID aus der Datenbank bekannt.
	 * Wird nicht implementiert in die GUI!
	 * 
	 * @param id in der Datenbank.
	 * @return Das erste Profil-Objekt, dass den Suchkriterien entspricht.
	 * @throws IllegalArgumentException
	 */
	public Profil getProfilById(int id) throws IllegalArgumentException;

	//test 
	
	
	public Auswahleigenschaft insertAuswahleigenschaft(Auswahleigenschaft aus) throws IllegalArgumentException;
	public Auswahleigenschaft updateAuswahleigenschaft(Auswahleigenschaft aus) throws IllegalArgumentException;
	public Auswahleigenschaft deleteAuswahleigenschaft(Auswahleigenschaft aus) throws IllegalArgumentException;
	
	public Eigenschaft insertEigenschaft(Eigenschaft e) throws IllegalArgumentException;
	public Eigenschaft updateEigenschaft(Eigenschaft e) throws IllegalArgumentException;
	public Eigenschaft deleteEigenschaft(Eigenschaft e) throws IllegalArgumentException;
	
	public Freitexteigenschaft insertFreitexteigenschaft(Freitexteigenschaft frei) throws IllegalArgumentException;
	public Freitexteigenschaft updateFreitexteigenschaft(Freitexteigenschaft frei) throws IllegalArgumentException;
	public Freitexteigenschaft deleteFreitexteigenschaft(Freitexteigenschaft frei) throws IllegalArgumentException;
	
	public Info insertInfo(Info info) throws IllegalArgumentException;
	public Info updateInfo(Info info) throws IllegalArgumentException;
	public Info deleteInfo(Info info) throws IllegalArgumentException;
	
	public Kontaktsperre insertKontaktsperre(Kontaktsperre k) throws IllegalArgumentException;
	public Kontaktsperre updateKontaktsperre(Kontaktsperre k) throws IllegalArgumentException;
	public Kontaktsperre deleteKontaktsperre(Kontaktsperre k) throws IllegalArgumentException;
	
	public Merkzettel insertMerkzettel(Merkzettel merk) throws IllegalArgumentException;
	public Merkzettel updateMerkzettel(Merkzettel merk) throws IllegalArgumentException;
	public Merkzettel deleteMerkzettel(Merkzettel merk) throws IllegalArgumentException;
	
	public Profil insertProfil(Profil pro) throws IllegalArgumentException;
	public Profil updateProfil(Profil pro) throws IllegalArgumentException;
	public Profil deleteProfil(Profil pro) throws IllegalArgumentException;
	
	public Suchprofil insertSuchprofil(Suchprofil such) throws IllegalArgumentException;
	public Suchprofil updateSuchprofil(Suchprofil such) throws IllegalArgumentException;
	public Suchprofil deleteSuchprofil(Suchprofil such) throws IllegalArgumentException;
	
}
