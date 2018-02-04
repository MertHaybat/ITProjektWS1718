package de.hdm.ITProjekt17.client;

import java.util.logging.Logger;
import de.hdm.ITProjekt17.shared.LoginService;
import de.hdm.ITProjekt17.shared.LoginServiceAsync;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministration;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.ReportGenerator;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt17.shared.*;

/**
 * Klasse mit Eigenschaften und Diensten, die für alle Client-seitigen Klassen
 * relevant sind.
 * 
 * @author thies
 * @version 1.0
 * @since 28.02.2012
 * 
 */
public class ClientsideSettings extends CommonSettings {

	/**
	 * Remote Service Proxy zur Verbindungsaufnahme mit dem Server-seitgen
	 * Dienst namens <code>PartnerbörseAdministration</code>.
	 */

	private static PartnerboerseAdministrationAsync boerseVerwaltung = null;

	/**
	 * Remote Service Proxy zur Verbindungsaufnahme mit dem Server-seitgen
	 * Dienst namens <code>ReportGenerator</code>.
	 */

	private static ReportGeneratorAsync reportGenerator = null;

	/**
	 * Name des Client-seitigen Loggers.
	 */

	private static LoginServiceAsync loginService = null;

	/**
	 * Name des Client-seitigen Loggers.
	 */
	private static final String LOGGER_NAME = "Partnerbörse Web Client";
	/**
	 * Instanz des Client-seitigen Loggers.
	 */
	private static final Logger log = Logger.getLogger(LOGGER_NAME);

	/**
	 * <p>
	 * Auslesen des applikationsweiten (Client-seitig!) zentralen Loggers.
	 * </p>
	 * 
	 * <h2>Anwendungsbeispiel:</h2> Zugriff auf den Logger herstellen durch:
	 * 
	 * <pre>
	 * Logger logger = ClientSideSettings.getLogger();
	 * </pre>
	 * 
	 * und dann Nachrichten schreiben etwa mittels
	 * 
	 * <pre>
	 * logger.severe(&quot;Sie sind nicht berechtigt, ...&quot;);
	 * </pre>
	 * 
	 * oder
	 * 
	 * <pre>
	 * logger.info(&quot;Lege neuen Kunden an.&quot;);
	 * </pre>
	 * 
	 * <p>
	 * Bitte auf <em>angemessene Log Levels</em> achten! Severe und info sind
	 * nur Beispiele.
	 * </p>
	 * 
	 * <h2>HINWEIS:</h2>
	 * <p>
	 * Beachten Sie, dass Sie den auszugebenden Log nun nicht mehr durch
	 * bedarfsweise Einfügen und Auskommentieren etwa von
	 * <code>System.out.println(...);</code> steuern. Sie belassen künftig
	 * sämtliches Logging im Code und können ohne abermaliges Kompilieren den
	 * Log Level "von außen" durch die Datei <code>logging.properties</code>
	 * steuern. Sie finden diese Datei in Ihrem <code>war/WEB-INF</code>-Ordner.
	 * Der dort standardmäßig vorgegebene Log Level ist <code>WARN</code>. Dies
	 * würde bedeuten, dass Sie keine <code>INFO</code>-Meldungen wohl aber
	 * <code>WARN</code>- und <code>SEVERE</code>-Meldungen erhielten. Wenn Sie
	 * also auch Log des Levels <code>INFO</code> wollten, müssten Sie in dieser
	 * Datei <code>.level = INFO</code> setzen.
	 * </p>
	 * 
	 * Weitere Infos siehe Dokumentation zu Java Logging.
	 * 
	 * @return die Logger-Instanz für die Server-Seite
	 */
	public static Logger getLogger() {
		return log;
	}

	/**
	 * <p>
	 * Anlegen und Auslesen der applikationsweit eindeutigen BankAdministration.
	 * Diese Methode erstellt die BankAdministration, sofern sie noch nicht
	 * existiert. Bei wiederholtem Aufruf dieser Methode wird stets das bereits
	 * zuvor angelegte Objekt zurückgegeben.
	 * </p>
	 * 
	 * <p>
	 * Der Aufruf dieser Methode erfolgt im Client z.B. durch
	 * <code>BankAdministrationAsync bankVerwaltung = ClientSideSettings.getBankVerwaltung()</code>
	 * .
	 * </p>
	 * 
	 * @return eindeutige Instanz des Typs <code>BankAdministrationAsync</code>
	 * @author Peter Thies
	 * @since 28.02.2012
	 */

	public static LoginServiceAsync getLoginService() {
		if (loginService == null) {
			loginService = GWT.create(LoginService.class);
		}
		return loginService;
	}

	public static PartnerboerseAdministrationAsync getBoerseVerwaltung() {

		if (boerseVerwaltung == null) {

			boerseVerwaltung = GWT.create(PartnerboerseAdministration.class);
			boerseVerwaltung.init(new AsyncCallback<Void>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onSuccess(Void result) {
					// TODO Auto-generated method stub

				}
			});
		}
		return boerseVerwaltung;
	}

	/**
	 * <p>
	 * Anlegen und Auslesen des applikationsweit eindeutigen ReportGenerators.
	 * Diese Methode erstellt den ReportGenerator, sofern dieser noch nicht
	 * existiert. Bei wiederholtem Aufruf dieser Methode wird stets das bereits
	 * zuvor angelegte Objekt zurückgegeben.
	 * </p>
	 * 
	 * <p>
	 * Der Aufruf dieser Methode erfolgt im Client z.B. durch
	 * <code>ReportGeneratorAsync reportGenerator = ClientSideSettings.getReportGenerator()</code>
	 * .
	 * </p>
	 * 
	 * @return eindeutige Instanz des Typs <code>BankAdministrationAsync</code>
	 * @author Peter Thies
	 * @since 28.02.2012
	 */
	public static ReportGeneratorAsync getReportGenerator() {

		// Falls bis jetzt noch keine ReportGenerator Instanz bestand
		if (reportGenerator == null) {
			reportGenerator = GWT.create(ReportGenerator.class);

			// reportGenerator.init(new AsyncCallback<Void>() {
			//
			// @Override
			// public void onFailure(Throwable caught) {
			//
			// }
			//
			// @Override
			// public void onSuccess(Void result) {
			// }
			// });
		}
		return reportGenerator;
	}

}
