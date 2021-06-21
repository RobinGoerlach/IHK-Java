package aufgabe05;

import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class Manager extends Mitarbeiter{
	
	private final static Logger LOGGER = Logger.getLogger(Manager.class.getName());

	
	private double grundGehalt;
	private double umsatz;
	private double provision;
	
	Manager()
	{
		super();
		grundGehalt = 0.0;
		umsatz = 0.0;
		provision = 0.0;

		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");
	}
	
	Manager(int persNo)
	{
		super(persNo);
		grundGehalt = 0.0;
		umsatz = 0.0;
		provision = 0.0;

		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");
	}

	
	Manager(int persNo, String vorName, String nachName, double grundGehalt, double umsatz, double provision)
	{
		super(persNo, vorName, nachName);
		this.grundGehalt = grundGehalt;
		this.umsatz = umsatz;
		this.provision = provision;
	
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("MitarbeiterVerwaltung created");
	}


	public void Set_NachName(String value)
	{
		super.Set_NachName(value);
		LOGGER.Info("Manager Get_NachName");
	}
	public String Get_NachName()
	{
		String helper = super.Get_NachName();
		LOGGER.Info("Manager Get_NachName");
		return helper;
	}

	public void Set_VorName(String value)
	{
		super.Set_VorName(value);
		LOGGER.Info("Manager Set_VorName");
	}
	public String Get_VorName()
	{
		String helper = super.Get_VorName();
		LOGGER.Info("Manager Get_VorName");
		return helper;
	}

	public void Set_GrundGehalt(double value)
	{
		grundGehalt=value;
	}
	public double Get_GrundGehalt()
	{
		return grundGehalt;
	}

	public void Set_Umsatz(double value)
	{
		umsatz=value;
	}
	public double Get_Umsatz()
	{
		return umsatz;
	}

	public void Set_Provision(double value)
	{
		provision=value;
	}
	public double Get_Provision()
	{
		return provision;
	}
			
	public double BruttoGehalt()
	{
		return umsatz * provision + grundGehalt;
	}

	public String toString(){
		String ausgabe = "MANAGER \t" + super.toString();
		String zusatz = " Grundgehalt: " + Double.toString(grundGehalt) + ", Provision: " + Double.toString(provision) + ", Umsatz: " + Double.toString(umsatz) + " " ;
        return ausgabe + zusatz;
    }
}
