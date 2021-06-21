package aufgabe05;

import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class Angestellter extends Mitarbeiter {

	private final static Logger LOGGER = Logger.getLogger(Angestellter.class.getName());
	
	private double monatsGehalt;
	
	Angestellter()
	{
		super();
		monatsGehalt = 0.0;
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("App started");
	}
	Angestellter(int persNo)
	{
		super(persNo);
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("App started");
	}
	Angestellter(int persNo, String vorName, String nachName, double monatsGehalt)
	{
		super(persNo, vorName, nachName);
		this.monatsGehalt = monatsGehalt;
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("App started");
	}

	public void Set_VorName(String value)
	{
		super.Set_VorName(value);
		LOGGER.Info("Angestellter Set_VorName");
	}
	public String Get_VorName()
	{
		String helper = super.Get_VorName();
		LOGGER.Info("Angestellter Get_VorName");
		return helper;
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

	public void Set_MonatsGehalt(double value)
	{
		monatsGehalt=value;
	}
	public double Get_MonatsGehalt()
	{
		return monatsGehalt;
	}

	public double BruttoGehalt()
	{
		return Get_MonatsGehalt();
	}

	public String toString(){
		String ausgabe = "ANGESTELLTER \t" + super.toString();
		String zusatz = " Monatsgehalt: " + Double.toString(monatsGehalt) + " " ;
        return ausgabe + zusatz;
    }

}
