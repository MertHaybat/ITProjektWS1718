package de.hdm.ITProjekt17.client.gui;

import java.util.Vector;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil.GeschlechtSuchprofil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil.HaarfarbeSuchprofil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil.RaucherSuchprofil;
/**
 * Hier wird eine Suchen seite erstellt, diese dient zur Suche von anderen Teilnehmern anhand eines definierten Suchprofils.
 * @author Mert
 *
 */
public class Suchen extends VerticalPanel {

	private static PartnerboerseAdministrationAsync pbverwaltung = ClientsideSettings.getBoerseVerwaltung();

	/**
	 * Deklarieren und Instanziieren der Widgets
	 */

	private ListBox lbhaarfarbe = new ListBox();
	private TextBox tbreligion = new TextBox();
	private TextBox tbkörpergröße = new TextBox();
	private ListBox lbraucher = new ListBox();
	private ListBox lbgeschlecht = new ListBox();
	private TextBox tbminalter = new TextBox();
	private TextBox tbmaxalter = new TextBox();

	private Label lb4 = new Label("Haarfarbe: ");
	private Label lb5 = new Label("Religion: ");
	private Label lb6 = new Label("Körpergröße: ");
	private Label lb7 = new Label("Raucher: ");
	private Label lb8 = new Label("Geschlecht: ");
	private Label lb9 = new Label("Alter von bis:");

	private Button suchen = new Button("Suchen");
	private Button suchprofilErstellen = new Button("Suchprofil speichern");
//	private Button suchprofilLoeschen = new Button("Suchprofil löschen");

	private FlexTable ft1 = new FlexTable();
	private CellTable<Suchprofil> ct = new CellTable<Suchprofil>();
	private final SingleSelectionModel<Suchprofil> ssm = new SingleSelectionModel<Suchprofil>();

	private VerticalPanel vpanelSuchprofile = new VerticalPanel();
	private HorizontalPanel hpanel = new HorizontalPanel();

	public Suchen(final Profil profil) {

		ft1.setWidget(3, 0, lb8);
		ft1.setWidget(3, 1, lbgeschlecht);
		ft1.setWidget(4, 0, lb9);
		ft1.setWidget(4, 1, tbminalter);
		ft1.setWidget(4, 2, tbmaxalter);
		;
		ft1.setWidget(5, 0, lb4);
		ft1.setWidget(5, 1, lbhaarfarbe);
		ft1.setWidget(6, 0, lb5);
		ft1.setWidget(6, 1, tbreligion);
		ft1.setWidget(7, 0, lb6);
		ft1.setWidget(7, 1, tbkörpergröße);
		ft1.setWidget(8, 0, lb7);
		ft1.setWidget(8, 1, lbraucher);
		ft1.setWidget(11, 1, suchen);
		ft1.setWidget(10, 1, suchprofilErstellen);
//		ft1.setWidget(9, 3, suchprofilLoeschen);

		// geburtsdatum.setValue(new Date(),true);
		// geburtsdatum.setFormat(new
		// DateBox.DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
		// ListBox Raucher befüllen.

		RaucherSuchprofil b1 = RaucherSuchprofil.A;
		RaucherSuchprofil b2 = RaucherSuchprofil.B;
		RaucherSuchprofil b3 = RaucherSuchprofil.C;
		RaucherSuchprofil b4 = RaucherSuchprofil.D;
		RaucherSuchprofil b5 = RaucherSuchprofil.E;
		lbraucher.addItem(Suchprofil.wordSuchprofil(b1));
		lbraucher.addItem(Suchprofil.wordSuchprofil(b2));
		lbraucher.addItem(Suchprofil.wordSuchprofil(b3));
		lbraucher.addItem(Suchprofil.wordSuchprofil(b4));
		lbraucher.addItem(Suchprofil.wordSuchprofil(b5));

		// ListBox Geschlecht befüllen.
		GeschlechtSuchprofil c1 = GeschlechtSuchprofil.m;
		GeschlechtSuchprofil c2 = GeschlechtSuchprofil.w;
		GeschlechtSuchprofil c3 = GeschlechtSuchprofil.s;
		lbgeschlecht.addItem(Suchprofil.wordSuchprofil(c1));
		lbgeschlecht.addItem(Suchprofil.wordSuchprofil(c2));
		lbgeschlecht.addItem(Suchprofil.wordSuchprofil(c3));

		// ListBox Haarfarbe befüllen.

		HaarfarbeSuchprofil h1 = HaarfarbeSuchprofil.A;
		HaarfarbeSuchprofil h2 = HaarfarbeSuchprofil.B;
		HaarfarbeSuchprofil h3 = HaarfarbeSuchprofil.C;
		HaarfarbeSuchprofil h4 = HaarfarbeSuchprofil.D;
		HaarfarbeSuchprofil h5 = HaarfarbeSuchprofil.E;
		lbhaarfarbe.addItem(Suchprofil.wordSuchprofil(h1));
		lbhaarfarbe.addItem(Suchprofil.wordSuchprofil(h2));
		lbhaarfarbe.addItem(Suchprofil.wordSuchprofil(h3));
		lbhaarfarbe.addItem(Suchprofil.wordSuchprofil(h4));
		lbhaarfarbe.addItem(Suchprofil.wordSuchprofil(h5));

		

		suchen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
			}

		});

		suchprofilErstellen.addClickHandler(new ClickHandler() {

			/**
			 * Interface clickhandler wird als anonyme klasse erstellt und realisert 
			 * die on click methode, die auf einen klick wartet und dann ausgeführt
			 * wird wenn der Button geklickt wird.
			 */
			public void onClick(ClickEvent event) {

				pbverwaltung.createSuchprofil(lbhaarfarbe.getSelectedValue(),
						tbreligion.getValue(), Integer.parseInt(tbkörpergröße.getValue()), lbraucher.getSelectedValue(),
						lbgeschlecht.getSelectedValue(), Integer.parseInt(tbminalter.getValue()),
						Integer.parseInt(tbmaxalter.getValue()), profil.getId(), new AsyncCallback<Suchprofil>() {

							/**
							 * Siehe Client.gui.report
							 */
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Window.alert("Da ist etwas schief gelaufen" + caught.getMessage());
							}

							/**
							 * Siehe Client.gui.report
							 */
							public void onSuccess(Suchprofil result) {
								RootPanel.get("Details").clear();
								RootPanel.get("Details").add(new Suchen(profil));
								;
							}

						});

				RootPanel.get("Details").setWidth("100%");
			}

		});

//		suchprofilLoeschen.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//			}
//
//		});

		RootPanel.get("Details").setWidth("100%");

		ct.setWidth("100%", true);
		vpanelSuchprofile.add(ft1);
		vpanelSuchprofile.add(ct);

		hpanel.add(vpanelSuchprofile);

		this.add(hpanel);

		ct.setSelectionModel(ssm);
		ct.setWidth("100%");
		ssm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			/**
			 * Es wird eine Suchprofil_Dialogbox erzeugt wenn man auf das erstellte Suchprofil klickt um eine 
			 * suche starten zu können oder um wieder zurück zur Suchenseite zu gelangen.
			 */
			public void onSelectionChange(SelectionChangeEvent event) {
				Suchprofil_Dialogbox b1 = new Suchprofil_Dialogbox(profil, ssm.getSelectedObject());
				b1.center();
			}
		});

		Column<Suchprofil, String> suchprofileGeschlecht = new Column<Suchprofil, String>(new ClickableTextCell()) {

			@Override
			public String getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getGeschlecht();
			}

		};
		Column<Suchprofil, String> suchprofileHaarfarbe = new Column<Suchprofil, String>(new ClickableTextCell()) {

			@Override
			public String getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getHaarfarbe();
			}

		};
		Column<Suchprofil, String> suchprofileRaucher = new Column<Suchprofil, String>(new ClickableTextCell()) {

			@Override
			public String getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getRaucher();
			}

		};
		Column<Suchprofil, String> suchprofileReligion = new Column<Suchprofil, String>(new ClickableTextCell()) {

			@Override
			public String getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getReligion();
			}
		};
		
		Column<Suchprofil, Number> suchprofileMinAlter = new Column<Suchprofil, Number>(
				new NumberCell(NumberFormat.getFormat("##"))) {

			@Override
			public Integer getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getMinAlter();
			}

		};

		Column<Suchprofil, Number> suchprofileMaxAlter = new Column<Suchprofil, Number>(
				new NumberCell(NumberFormat.getFormat("##"))) {

			@Override
			public Integer getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getMaxAlter();
			}

		};

		Column<Suchprofil, Number> suchprofileKörpergröße = new Column<Suchprofil, Number>(
				new NumberCell(NumberFormat.getFormat("##"))) {

			@Override
			public Integer getValue(Suchprofil object) {
				// TODO Auto-generated method stub
				return object.getKoerpergroesse();
			}

		};

		ct.addColumn(suchprofileGeschlecht, "Geschlecht");
		ct.addColumn(suchprofileHaarfarbe, "Haarfarbe");
		ct.addColumn(suchprofileRaucher, "Raucher");
		ct.addColumn(suchprofileReligion, "Religion");
		ct.addColumn(suchprofileMinAlter, "Mindestalter");
		ct.addColumn(suchprofileMaxAlter, "Höchstalter");
		ct.addColumn(suchprofileKörpergröße, "Körpergröße");
		pbverwaltung.findSuchprofilByProfilId(profil, new AsyncCallback<Vector<Suchprofil>>() {

			
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			
			public void onSuccess(Vector<Suchprofil> result) {
				ct.setRowData(0, result);
				ct.setRowCount(result.size(), true);

			}
		});

	}

}
