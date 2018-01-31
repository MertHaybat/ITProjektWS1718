package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Profil;

public class Profil_Info_Dialogbox extends FlexTable{
	private TextBox tbinteresse = new TextBox();
	private TextBox tbwohnsituation = new TextBox();
	private TextBox tbausbildung = new TextBox();
	private TextBox tbkoerperbau = new TextBox();
	private TextArea tbfreitext = new TextArea();
		
	private Label lb1 = new Label("Interessiert an: ");
	private Label lb2 = new Label("Wohnsituation: ");
	private Label lb3 = new Label("Ausbildung: ");
	private Label lb4 = new Label("Körperbau: ");
	private Label lb5 = new Label("Was hat diese Person sonst noch über sich gesagt: ");

	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();
	
	public Profil_Info_Dialogbox (final Profil profil_eigenes, final Profil profil_fremd){
		this.setWidget(0, 0, lb1);
		this.setWidget(0, 1, tbinteresse);
		this.setWidget(1, 0, lb2);
		this.setWidget(1, 1, tbwohnsituation);
		this.setWidget(2, 0, lb3);
		this.setWidget(2, 1, tbausbildung);
		this.setWidget(3, 0, lb4);
		this.setWidget(3, 1, tbkoerperbau);
		this.setWidget(4, 0, lb5);
		this.setWidget(5, 0, tbfreitext);
		
		tbfreitext.setPixelSize(200, 130);
		
		pbverwaltung.getInfoIdByProfilId(profil_fremd, new AsyncCallback<Vector<Info>>() {
			
			@Override
			public void onSuccess(Vector<Info> result) {
				for (Info info : result) {
					int o = info.getAuswahleigenschaftid();
					
					switch (o) {
					case 1:
						tbinteresse.setValue(info.getAuswahleigenschaftWert());
						break;
					case 2: 
						tbwohnsituation.setValue(info.getAuswahleigenschaftWert());
						break;
					case 3: 
						tbausbildung.setValue(info.getAuswahleigenschaftWert());
						break;
					case 4:
						tbkoerperbau.setValue(info.getAuswahleigenschaftWert());
						break;
					case 5:
						tbfreitext.setValue(info.getFreitexteigenschaftWert());
						
						default:
							break;
					}
					
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
