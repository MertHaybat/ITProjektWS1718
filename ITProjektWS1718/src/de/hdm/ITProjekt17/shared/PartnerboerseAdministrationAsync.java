package de.hdm.ITProjekt17.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt17.shared.bo.Profil;


public interface PartnerboerseAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void getProfilById(int id, AsyncCallback<Profil> callback);

}
