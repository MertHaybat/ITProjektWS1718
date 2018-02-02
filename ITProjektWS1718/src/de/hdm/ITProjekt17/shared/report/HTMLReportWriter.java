package de.hdm.ITProjekt17.shared.report;

import java.util.Vector;

/**
 * Ein <code>ReportWriter</code>, der Reports mittels HTML formatiert. Das im
 * Zielformat vorliegende Ergebnis wird in der Variable <code>reportText</code>
 * abgelegt und kann nach Aufruf der entsprechenden Prozessierungsmethode mit
 * <code>getReportText()</code> ausgelesen werden.
 * 
 * @author Thies
 */
public class HTMLReportWriter extends ReportWriter {

	public HTMLReportWriter(){
		
	}
  /**
   * Diese Variable wird mit dem Ergebnis einer Umwandlung (vgl.
   * <code>process...</code>-Methoden) belegt. Format: HTML-Text
   */
  private String reportText = "";

  /**
   * Zurücksetzen der Variable <code>reportText</code>.
   */
  public void resetReportText() {
    this.reportText = "";
  }

  /**
   * Umwandeln eines <code>Paragraph</code>-Objekts in HTML.
   * 
   * @param p der Paragraph
   * @return HTML-Text
   */
  public String paragraph2HTML(Paragraph p) {
    if (p instanceof CompositeParagraph) {
      return this.paragraph2HTML((CompositeParagraph) p);
    }
    else {
      return this.paragraph2HTML((SimpleParagraph) p);
    }
  }

  /**
   * Umwandeln eines <code>CompositeParagraph</code>-Objekts in HTML.
   * 
   * @param p der CompositeParagraph
   * @return HTML-Text
   */
  public String paragraph2HTML(CompositeParagraph p) {
    StringBuffer result = new StringBuffer();

    for (int i = 0; i < p.getNumParagraphs(); i++) {
      result.append("<p>" + p.getParagraphAt(i) + "</p>");
    }

    return result.toString();
  }

  /**
   * Umwandeln eines <code>SimpleParagraph</code>-Objekts in HTML.
   * 
   * @param p der SimpleParagraph
   * @return HTML-Text
   */
  public String paragraph2HTML(SimpleParagraph p) {
    return "<p>" + p.toString() + "</p>";
  }

  /**
   * HTML-Header-Text produzieren.
   * 
   * @return HTML-Text
   */
  public String getHeader() {
    StringBuffer result = new StringBuffer();

    result.append("<html><head><title></title></head><body>");
    return result.toString();
  }

  /**
   * HTML-Trailer-Text produzieren.
   * 
   * @return HTML-Text
   */
  public String getTrailer() {
    return "</body></html>";
  }
  public String getReportText(){
	  return this.getHeader() + this.reportText + this.getTrailer();
  }
  

  /**
   * Prozessieren des übergebenen Reports und Ablage im Zielformat. Ein Auslesen
   * des Ergebnisses kann später mittels <code>getReportText()</code> erfolgen.
   * 
   * @param r der zu prozessierende Report
   */
  public void process(PartnervorschlaegeAnhandSuchprofilReport p){
	  System.out.println("Hallo--------------------------------------");
	  this.resetReportText();
	  System.out.println("Hallo2--------------------------------------");
	  StringBuffer result = new StringBuffer();
	  System.out.println("Hallo3--------------------------------------");
	  result.append("<table class=\"ProfileReportTable\"><tr>");
	  System.out.println("Hallo4--------------------------------------");
	  Vector<Row> rows = p.getRows();
	  Row toprow = rows.elementAt(0);
	  System.out.println("Hallo5--------------------------------------");
	  result.append("<th class=\"ProfileReportHeader\" colspan=\"3\">" + toprow.getColumnAt(0) + "</th></tr>");
	  
	  result.append("<tr><t	d> <table class=eigenschaften>");
	  for(int i = 1; i < 9; i++){
		  Row row = rows.elementAt(i);
		  result.append("<tr>");
		  for (int k = 0; k< row.getNumColumns(); k++){
			  result.append("<td class=EigColumn>" + row.getColumnAt(k) + "</td>");
			  }
		  result.append("</tr>");
		  }
	  System.out.println("Hallo6--------------------------------------");
	  result.append("</table></td>");	  
	  result.append("</table>");
	  this.reportText = result.toString();
	  System.out.println("Hallo7--------------------------------------");
  }
  }

