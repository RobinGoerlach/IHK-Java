package aufgabe05;

import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class Main {
	
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) 
	{
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("App started");

		// Analyze command parameter 		
		if (0 == args.length) {
			LOGGER.Info("No command parameter detected");
			/* TODO: InitComponetsWithDefaults(); */
		} else {
			for (int i = 0; i < args.length; i++) {
				LOGGER.Debug("Command parameter [" + i + "] :" + args[i]);
        	} 			
		}
		
		LOGGER.Debug("Initialising variables");
		String vorName = "";
		String nachName = "";
		int todo = 0;
		
		LOGGER.Debug("Initialising GUI");
		GUI gui = new GUI(); 
		LOGGER.Debug("Initialising MitarbeiterVerwaltung");
		MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();		
		// mv.erzeugeTestMitarbeiter(); /* erzeuge mehrer statische Nutzer */
		// mv.listeAlleMitarbeiter();
		
		do 
		{
			LOGGER.Debug("Calling GUI menu");
			/* Welche Art von Mitarbeiter soll erfasst werden*/
			todo = gui.menu();
			LOGGER.Fine("GUI menu returned: " + todo);
			
			/* Benötigten Daten abgefragt und Objekt wird angelegt */ 
			switch(todo) {
			case -1: /* GUI - keine Eingabe erhalten */ 	
				LOGGER.Debug("Handling Eingabe beenden ");
				break;
			case 0: /* GUI - Eingabe beenden */ 	
				LOGGER.Debug("Handling Eingabe beenden");
				break;
			case 1: /* GUI - Arbeiter anlegen */ 
				LOGGER.Debug("Handling Arbeiter anlegen");
				vorName = gui.Vorname(todo); 
				nachName = gui.Nachname(todo); 
				double wochenStundenZahl = gui.wochenStundenZahl(todo); 
				double stundenLohn = gui.stundenLohn(todo); 
				mv.createArbeiter(vorName, nachName, wochenStundenZahl, stundenLohn);
				break;
			case 2: /* GUI - Angestellter anlegen*/
				LOGGER.Debug("Handling Angestellter anlegen");
				vorName = gui.Vorname(todo); 
				nachName = gui.Nachname(todo); 
				double monatsGehalt = gui.monatsGehalt(todo); 
				mv.createAngestellter(vorName, nachName, monatsGehalt);
				break;
			case 3: /* GUI - Manager anlegen*/ 
				LOGGER.Debug("Handling Manager anlegen");
				vorName = gui.Vorname(todo); 
				nachName = gui.Nachname(todo); 
				double grundGehalt = gui.GrundGehalt(todo); 
				double umsatz = gui.Umsatz(todo); 
				double provision = gui.Provision(todo);
				mv.createManager(vorName, nachName, grundGehalt, umsatz, provision);
				break;
			default: /* GUI - unbekannte Eingabe */
				LOGGER.Debug("Handling unbekannte Eingabe");
				System.out.println("Der Typ des Mitarbeiter kann nicht verarbeitet werden!");
				break;				
			}	
			
		} while (0 != todo);
		LOGGER.Debug("Mitarbeiter Erfassung erledigt");	
		
		/* Mitarbeiterdaten wieder ausgegeben*/
		if (mv.isEmpty()) {
			LOGGER.Warning("Es wurden keine Mitarbeiter erfasst!");	
			System.out.println("Es wurden keine Mitarbeiter erfasst!");			
		} else {
			LOGGER.Debug("Mitarbeiterdaten ausgegeben");
			LOGGER.Debug("Mitarbeiterverwalung listeAlleMitarbeiter rufen");
			mv.listeAlleMitarbeiter();
			 mv.listeAlleNamenMitGehalt();
		}						
	}
}
