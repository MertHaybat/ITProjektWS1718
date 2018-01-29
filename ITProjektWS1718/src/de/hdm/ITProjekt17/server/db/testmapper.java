package de.hdm.ITProjekt17.server.db;

import java.util.Date;
import java.util.Vector;

import de.hdm.ITProjekt17.server.PartnerboerseAdministrationImpl;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class testmapper {

	public static void main(String[] args) {
		PartnerboerseAdministrationImpl impl = new PartnerboerseAdministrationImpl();
		impl.init();
		ProfilMapper p = new ProfilMapper();
		ProfilMapper.profilMapper();
		// Vector<Info> v = impl.getInfoIdByProfilId(impl.getProfilById(1));
		//
		// for (Info info : v) {
		// int o = info.getAuswahleigenschaftid();
		// System.out.println(o);
		//
		//
		//
		// }
		Profil pro = new Profil();
		pro.setId(1);
		System.out.println(impl.showMerklisteOf(pro));
	}

}
