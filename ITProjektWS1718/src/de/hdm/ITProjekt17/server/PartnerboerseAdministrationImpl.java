package de.hdm.ITProjekt17.server;

import de.hdm.ITProjekt17.server.db.*;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministration;
import de.hdm.ITProjekt17.shared.bo.Profil;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class PartnerboerseAdministrationImpl extends RemoteServiceServlet 
implements PartnerboerseAdministration {

	
	private ProfilMapper profilMapper = null;
	
	public PartnerboerseAdministrationImpl() throws IllegalArgumentException {
		
	}
	
	public void init() throws IllegalArgumentException{
		
		this.profilMapper = ProfilMapper.profilMapper();
	}
	
	@Override
	public Profil getProfilById(int id) throws IllegalArgumentException {
		return this.profilMapper.findByKey(id);
	}
	

}
