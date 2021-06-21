package aufgabe05;

import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class Arbeiter extends Mitarbeiter {

	private final static Logger LOGGER = Logger.getLogger(Arbeiter.class.getName());

	private double wochenStundenZahl;
	private double stundenLohn;
	
	Arbeiter()
	{
		super();
		wochenStundenZahl = 0.0;
		stundenLohn = 0.0;
		
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");
	}

	
	Arbeiter(int persNo)
	{
		super(persNo);
		wochenStundenZahl = 0.0;
		stundenLohn = 0.0;
		
		LOGGER.setLevel(Level.OFF);	
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");
	}

	Arbeiter(int persNo, String vorName, String nachName, double wochenStundenZahl, double stundenLohn)
	{
		super(persNo, vorName, nachName);
		this.wochenStundenZahl = wochenStundenZahl;
		this.stundenLohn = stundenLohn;

		LOGGER.setLevel(Level.OFF);	
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");
	}

	public void Set_NachName(String value)
	{
		super.Set_NachName(value);
		LOGGER.Info("Arbeiter Get_NachName");
	}
	public String Get_NachName()
	{
		String helper = super.Get_NachName();
		LOGGER.Info("Arbeiter Get_NachName");
		return helper;
	}

	public void Set_VorName(String value)
	{
		super.Set_VorName(value);
		LOGGER.Info("Arbeiter Set_VorName");
	}
	public String Get_VorName()
	{
		String helper = super.Get_VorName();
		LOGGER.Info("Arbeiter Get_VorName");
		return helper;
	}

	public void Set_WochenStundenZahl(double value)
	{
		wochenStundenZahl=value;
	}
	public double Get_WochenStundenZahl()
	{
		return wochenStundenZahl;
	}

	public void Set_StundenLohn(double value)
	{
		stundenLohn=value;
	}
	public double Get_StundenLohn()
	{
		return stundenLohn;
	}
		
	public double BruttoLohn()
	{
		return 4 * wochenStundenZahl * stundenLohn;
	}

	public String toString(){
		String ausgabe = "ARBEITER \t" + super.toString();
		String zusatz = " WochenStundenZahl: " + Double.toString(wochenStundenZahl) + " StundenLohn: " + Double.toString(stundenLohn) + " " ;
        return ausgabe + zusatz;
    }

}
