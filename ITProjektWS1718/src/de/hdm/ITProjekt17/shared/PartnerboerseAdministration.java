package de.hdm.ITProjekt17.shared;

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
	public Profil getProfilById(int id) throws IllegalArgumentException;
	
}
