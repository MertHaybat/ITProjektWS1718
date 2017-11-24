package de.hdm.ITProjekt17.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.shared.bo.Profil;

/**
 * Entry-Point-Klasse des Projekts "ITProjektWS1718- Partnerboerse"
 * @author Mert
 *
 */

public class ITProjektWS1718 implements EntryPoint{

	private FlexTable ft1 = new FlexTable();
	private Button bt1 = new Button();
	private TextBox tb1 = new TextBox();
	@Override
	public void onModuleLoad() {
		VerticalPanel navPanel = new VerticalPanel();
		ft1.setWidget(0, 0, bt1);
		ft1.setWidget(1, 1, bt1);
		ft1.setWidget(2, 1, tb1);
	
		ClientsideSettings.getBoerseVerwaltung().getProfilById(1, new AsyncCallback<Profil>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void onSuccess(Profil result) {
				Window.alert("war richtig");
				tb1.setValue(result.getNachname());
				Window.alert(result.getNachname());
				
				}
			
		});
		navPanel.add(ft1);
		
		RootPanel.get("Details").add(navPanel);
	}
	
}