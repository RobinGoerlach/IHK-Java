package aufgabe05;

import javax.swing.JOptionPane;
import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class GUI {

	private final static Logger LOGGER = Logger.getLogger(GUI.class.getName());
	
	GUI(){
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Debug("GUI created");
	}
	
	/**
	 * welche Art von Mitarbeiter soll angelegt werden
	 * @return
	 */
	public int menu()
	{
		LOGGER.Debug("GUI menu entered");
		int ergebnis = -1;
		/*  */
		String MitarbeiterTypen = "Typ des Mitarbeiter der angelegt werden soll eingeben (Arbeiter, Angestellter, Manager oder ENDE)?";
		String userEingabe = JOptionPane.showInputDialog(MitarbeiterTypen);
		if (userEingabe.toUpperCase().equals("ENDE")) ergebnis = 0;
		if (userEingabe.toUpperCase().equals("ARBEITER")) ergebnis = 1;
		if (userEingabe.toUpperCase().equals("ANGESTELLTER")) ergebnis = 2;
		if (userEingabe.toUpperCase().equals("MANAGER")) ergebnis = 3;
		LOGGER.Fine("Mitarbeiter der angelegt werden soll: " + userEingabe);

		
		LOGGER.Debug("GUI menu left");
		return ergebnis;
	}
		
	/**
	 * Vornamen erfassen
	 * @param value Type des Mitarbeiters
	 * @return
	 */
	public String Vorname(int value) 
	{
		LOGGER.Debug("GUI Vorname methode entered");
		String Frage = "Bitte geben Sie den Vornamen ";
		String Mitarbeiter = "unklarer Mitarbeiter"; 
				
		switch (value) {
			case 1: Mitarbeiter = "des ARBEITER ein: "; break;
			case 2: Mitarbeiter = "des ANGESTELLTER ein"; break;
			case 3: Mitarbeiter = "des MANAGER ein"; break;
			default:
				System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("Vorname: " + userEingabe);
		
		LOGGER.Debug("GUI Vorname methode left");
		return userEingabe;
	}
	
	/**
	 * Nachnamen erfassen
	 * @param value Typ des Mitarbeiters
	 * @return
	 */
	public String Nachname(int value) 
	{
		LOGGER.Debug("GUI Nachname methode entered");

		String Frage = "Bitte geben Sie den Nachnamen ";
		String Mitarbeiter = "unklarer Mitarbeiter";  
				
		switch (value) {
			case 1: Mitarbeiter = "des ARBEITER ein: "; break;
			case 2: Mitarbeiter = "des ANGESTELLTER ein"; break;
			case 3: Mitarbeiter = "des MANAGER ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("Nachname: " + userEingabe);

		LOGGER.Debug("GUI Nachname methode left");
		return userEingabe;
	}

	/**
	 * Wochenarbeitszeit eines Arbeiters in Stunden
	 * @param value
	 * @return
	 */
	public double wochenStundenZahl(int value) 
	{
		LOGGER.Debug("GUI wochenStundenZahl methode entered");

		String Frage = "Bitte geben Sie die Anzahl der Wochenstunden ";
		String Mitarbeiter = "unklarer Mitarbeiter"; ; 
				
		switch (value) {
			case 1: Mitarbeiter = "des Arbeiter ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("Wochenstundenzahl: " + userEingabe);

		LOGGER.Debug("GUI wochenStundenZahl methode left");
		return Double.parseDouble(userEingabe);
	}	
	
	/**
	 * stundelohn eines Arbeiters
	 * @param value
	 * @return
	 */
	public double stundenLohn(int value) {
		LOGGER.Debug("GUI stundenLohn methode entered");

		String Frage = "Bitte geben Sie den Stundenlohn ";
		String Mitarbeiter = "unklarer Mitarbeiter"; ; 
				
		switch (value) {
			case 1: Mitarbeiter = "des Arbeiter ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);		
		LOGGER.Fine("Stundenlohn: " + userEingabe);

		LOGGER.Debug("GUI StundenLohn methode left");
		return Double.parseDouble(userEingabe);
	}

	/**
	 * Monats Gehalt eine Angestellten
	 * @param value
	 * @return
	 */
	public double monatsGehalt(int value) 
	{
		LOGGER.Debug("GUI monatsGehalt methode entered");

		String Frage = "Bitte geben Sie das Monatsgehalt ";
		String Mitarbeiter = "unklarer Mitarbeiter"; ; 
				
		switch (value) {
			case 2: Mitarbeiter = "des Angestellten ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("Monatsgehalt: " + userEingabe);

		LOGGER.Debug("GUI monatsGehalt methode entered");
		return Double.parseDouble(userEingabe);
	}

	/**
	 * GrundGehalt eines Managers
	 * @param value
	 * @return
	 */
	public double GrundGehalt(int value) 
	{
		LOGGER.Debug("GUI GrundGahalt methode entered");

		String Frage = "Bitte geben Sie das GrundGehalt ";
		String Mitarbeiter = "unklarer Mitarbeiter"; ; 
				
		switch (value) {
			case 3: Mitarbeiter = "des MANAGER ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("GrundGehalt: " + userEingabe);

		LOGGER.Debug("GUI GrundGehalt methode left");
		return Double.parseDouble(userEingabe);
	}
	
	/**
	 * Umsatz eines Managers
	 * @param value
	 * @return
	 */
	public double Umsatz(int value) 
	{
		LOGGER.Debug("GUI Umsatz methode entered");
		
		String Frage = "Bitte geben Sie den Umsatz ";
		String Mitarbeiter = "unklarer Mitarbeiter"; ; 
				
		switch (value) {
			case 3: Mitarbeiter = "des MANAGER ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("Umsatz: " + userEingabe);

		LOGGER.Debug("GUI Umsatz methode left");
		return Double.parseDouble(userEingabe);
	} 
	
	/**
	 * Provision eines Managers
	 * @param value
	 * @return
	 */
	public double Provision(int value) 
	{
		LOGGER.Debug("GUI Provision methode entered");

		String Frage = "Bitte geben Sie die Provision ";
		String Mitarbeiter = "unklarer Mitarbeiter"; ; 
				
		switch (value) {
			case 3: Mitarbeiter = "des MANAGER ein"; break;
			default: System.err.println ("Falscher Mitarbeitertyp");
		}
		String userEingabe = JOptionPane.showInputDialog(Frage + Mitarbeiter);
		LOGGER.Fine("Provision: " + userEingabe);

		LOGGER.Debug("GUI Provision methode left");
		return Double.parseDouble(userEingabe);
	} 
}
