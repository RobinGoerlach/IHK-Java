package aufgabe05;

import java.util.LinkedList;
import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class MitarbeiterVerwaltung {
	
	private final static Logger LOGGER = Logger.getLogger(MitarbeiterVerwaltung.class.getName());
	
	private LinkedList<Mitarbeiter> hr;
	private PersonalNummer personalNummer;
	
	MitarbeiterVerwaltung() {
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");

		personalNummer = new PersonalNummer();
		hr = new LinkedList<Mitarbeiter>();
		/* System.out.println(personalNummer.toString()); */
	}	

	public boolean isEmpty() 
	{
		LOGGER.Debug("isEmpty entered");
		LOGGER.Fine("Mitarbeiter Liste Anzahl: " + hr.size());
		LOGGER.Debug("isEmpty left");
		return (0 == hr.size());
	}
	
	public Arbeiter createArbeiter() 
	{
		LOGGER.Debug("createArbeiter (empty) entered");

		int pno = personalNummer.next();
		LOGGER.Fine("personalNummer: " + pno);
		Arbeiter arbeiter = new Arbeiter(pno);
		LOGGER.Fine("Arbeiter: " + arbeiter.toString());
		hr.add(arbeiter);

		LOGGER.Debug("createArbeiter left");
		return arbeiter;
	}

	public Arbeiter createArbeiter(String vorName, String nachName, double wochenStundenZahl, double stundenLohn) 
	{
		LOGGER.Debug("createArbeiter entered");
		LOGGER.Fine("Arbeiter Vorname (from input): " + vorName);
		LOGGER.Fine("Arbeiter Nachname (from input): " + nachName);
		LOGGER.Fine("Arbeiter WochenStunden (from input): " + wochenStundenZahl);
		LOGGER.Fine("Arbeiter StundenLohn (from input): " + stundenLohn);
		
		int pno = personalNummer.next();
		LOGGER.Fine("personalNummer: " + pno);
		Arbeiter arbeiter = new Arbeiter(pno, vorName, nachName, wochenStundenZahl, stundenLohn);
		LOGGER.Fine("Arbeiter: " + arbeiter.toString());
		hr.add(arbeiter);
		
		LOGGER.Debug("createArbeiter left");
		return arbeiter;
	}
	
	public Angestellter createAngestellter() 
	{
		LOGGER.Debug("createAngestellter (empty) entered");

		int pno = personalNummer.next();
		LOGGER.Fine("personalNummer: " + pno);
		Angestellter angestellter = new Angestellter(pno);
		LOGGER.Fine("Angestellter: " + angestellter.toString());
		hr.add(angestellter);
		
		LOGGER.Debug("createAngestellter left");
		return angestellter;
	}

	public Angestellter createAngestellter(String vorName, String nachName, double monatsGehalt) 
	{
		LOGGER.Debug("createAngestellter entered");
		
		LOGGER.Fine("Angestellter Vorname (from input): " + vorName);
		LOGGER.Fine("Angestellter Nachname (from input): " + nachName);
		LOGGER.Fine("Angestellter MonatsGehalt (from input): " + monatsGehalt);
		int pno = personalNummer.next();
		LOGGER.Fine("personalNummer: " + pno);
		Angestellter angestellter = new Angestellter(pno,vorName, nachName, monatsGehalt);						
		LOGGER.Fine("Angestellter: " + angestellter.toString());
		hr.add(angestellter);

		LOGGER.Debug("createAngestellter left");
		return angestellter;
	}

	public Manager createManager() 
	{
		LOGGER.Debug("createManager entered");

		int pno = personalNummer.next();
		LOGGER.Fine("personalNummer: " + pno);
		Manager manager = new Manager(pno);
		LOGGER.Fine("Manager: " + manager.toString());
		hr.add(manager);

		LOGGER.Debug("createManager left");
		return manager;
	}
	
	public Manager createManager( String vorName, String nachName, double grundGehalt, double umsatz, double provision) 
	{
		LOGGER.Debug("createManager entered");

		LOGGER.Fine("Arbeiter Vorname (from input): " + vorName);
		LOGGER.Fine("Arbeiter Nachname (from input): " + nachName);
		LOGGER.Fine("Arbeiter GrundGehalt (from input): " + grundGehalt);
		LOGGER.Fine("Arbeiter Umsatz (from input): " + umsatz);
		int pno = personalNummer.next();
		LOGGER.Fine("personalNummer: " + pno);
		Manager manager = new Manager(pno,vorName, nachName, grundGehalt, umsatz, provision);
		LOGGER.Fine("Manager: " + manager.toString());
		hr.add(manager);

		LOGGER.Debug("createManager left");
		return manager;
	}

	public void erzeugeTestMitarbeiter() 
	{

		LOGGER.Debug("erzeugeTestMitarbeiter entered");

		Manager Tony = createManager("Tony", "Stark", 10000, .10, 1000000);
		Tony.Set_Bemerkung("Iron Man");
		hr.add(Tony) ;
		Tony = null;
		
		Angestellter Pepper = createAngestellter("Virginia", "Potts", 3000);
		Pepper.Set_Bemerkung("Pepper");
		hr.add (Pepper);
		Pepper = null;
		
		Angestellter Happy  = createAngestellter("Harold Joseph", "Hogan", 3500);
		Happy.Set_Bemerkung("Happy");
		hr.add ( Happy);
		Happy = null;
		
		Arbeiter CaptainAmerica = createArbeiter("Steve", "Rogers", 12.80,40);
		CaptainAmerica.Set_Bemerkung("Captain America");
		hr.add ( CaptainAmerica);
		CaptainAmerica = null;
		
		Arbeiter AntMan = createArbeiter();
		AntMan.Set_VorName("Scott");
		AntMan.Set_NachName("Lang");
		AntMan.Set_Bemerkung("Ant-Man");
		AntMan.Set_StundenLohn(9.80);
		AntMan.Set_WochenStundenZahl(40);
		hr.add(CaptainAmerica);
		AntMan = null;
		
		Arbeiter ScarletWitch = createArbeiter();
		ScarletWitch.Set_VorName("Wanda");
		ScarletWitch.Set_NachName("Maximoff");
		ScarletWitch.Set_Bemerkung("Scarlet Witch");
		ScarletWitch.Set_StundenLohn(10.40);
		ScarletWitch.Set_WochenStundenZahl(40);
		hr.add (ScarletWitch);
		ScarletWitch = null;
		
		Arbeiter BlackWidow = createArbeiter();
		BlackWidow.Set_VorName("Natalia Alianovna");
		BlackWidow.Set_NachName("Romanoff");
		BlackWidow.Set_Bemerkung("Black Widow");
		BlackWidow.Set_StundenLohn(12.80);
		BlackWidow.Set_WochenStundenZahl(40);
		hr.add(BlackWidow);
		BlackWidow =null;
		
		Arbeiter Hulk = createArbeiter();
		Hulk.Set_VorName("Bruce");
		Hulk.Set_NachName("Banner");
		Hulk.Set_Bemerkung("Hulk");
		Hulk.Set_StundenLohn(16.80);
		Hulk.Set_WochenStundenZahl(40);
		hr.add(Hulk);
		Hulk = null;
		
		Arbeiter CaptainMarvel = createArbeiter();
		CaptainMarvel.Set_VorName("Carol");
		CaptainMarvel.Set_NachName("Danvers");
		CaptainMarvel.Set_Bemerkung("Captain Marvel");
		CaptainMarvel.Set_StundenLohn(16.80);
		CaptainMarvel.Set_WochenStundenZahl(40);
		hr.add(CaptainMarvel);
		CaptainMarvel =null;

		Arbeiter Spiderman = createArbeiter();
		Spiderman.Set_VorName("Peter");
		Spiderman.Set_NachName("Parker");
		Spiderman.Set_Bemerkung("Spiderman");
		Spiderman.Set_StundenLohn(8.50);
		Spiderman.Set_WochenStundenZahl(19);
		hr.add(Spiderman) ;
		Spiderman = null;

		LOGGER.Debug("erzeugeTestMitarbeiter left");
	}
	
	public void listeAlleMitarbeiter() 
	{
		LOGGER.Debug("listeAlleMitarbeiter entered");

		int i = 0;
		while(i < hr.size())
		{
			Mitarbeiter next = hr.get(i);
			i++;
			System.out.println(next.toString());
		}	

		LOGGER.Debug("listeAlleNamenMitGehalt left");
	}
	
	public void listeAlleNamenMitGehalt() 
    {
		LOGGER.Debug("listeAlleNamenMitGehalt entered");
		int i = 0;
		while(i < hr.size())
		{
			Mitarbeiter next = hr.get(i);
			i++;
			
			System.out.print(next.Get_NachName() + ", "+ next.Get_VorName() + "\t");
			if (next instanceof Arbeiter) {
				Arbeiter arbeiter = new Arbeiter();
				arbeiter = (Arbeiter)next;			
				System.out.println(" Gehalt: " + arbeiter.BruttoLohn() );
			} else if (next instanceof Angestellter) {
				Angestellter angestellter = new Angestellter();
				angestellter = (Angestellter)next;			
				System.out.println(" Gehalt: " + angestellter.BruttoGehalt() );
			} else {
				Manager manager = new Manager();
				manager = (Manager)next;			
				System.out.println(" Gehalt: " + manager.BruttoGehalt() );
			}			
		}

		LOGGER.Debug("listeAlleNamenMitGehalt left");
	}	
}
