package aufgabe05;

import logging.Logger;
import logging.Logger.Destination;
import logging.Logger.Level;

public class Mitarbeiter {

	private final static Logger LOGGER = Logger.getLogger(Mitarbeiter.class.getName());

	private int persNo;
	private String vorName;
	private String nachName;
	private String bemerkung;
	
	/* Konstruktoren werden nicht mit vreerbt */
	Mitarbeiter()
	{
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("Mitarbeiter created");

		persNo = 0;
		nachName = "";
		vorName = ""; 
		bemerkung = "";
		/* throw new java.lang.UnsupportedOperationException("Mitarbeiter benötigt mindestens eine Personalnummer"); */ 
	}	
	Mitarbeiter(int persNo)
	{
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("Mitarbeiter created");
		LOGGER.Fine("personalNummer from input: " + persNo);
		
		this.persNo = persNo;
		nachName = "";
		vorName = "";
		bemerkung = "";
	}
	Mitarbeiter(int persNo, String vorName, String nachName)
	{
		LOGGER.setLevel(Level.OFF);
		LOGGER.setDestination(Destination.SYSOUT);		
		LOGGER.Info("Mitarbeiter created");
		LOGGER.Fine("personalNummer from input: " + persNo);
		LOGGER.Fine("vorName from input: " + vorName);
		LOGGER.Fine("Nachname from input: " + nachName);
		
		this.persNo = persNo;
		this.vorName = vorName;
		this.nachName = nachName;
	}

	public void Set_persNo(int value)
	{
		LOGGER.Info("Mitarbeiter Set_persNo");
		persNo = value;
	}

	public int Get_persNo()
	{
		LOGGER.Info("Mitarbeiter Get_persNo");
		return persNo;
	}

	public void Set_NachName(String value)
	{
		LOGGER.Info("Mitarbeiter Set_NachName");
		nachName = value;
	}
	public String Get_NachName()
	{
		LOGGER.Info("Mitarbeiter Get_NachName");
		return nachName;
	}

	public void Set_VorName(String value)
	{
		LOGGER.Info("Mitarbeiter Set_VorName");
		vorName = value;
	}
	public String Get_VorName()
	{
		LOGGER.Info("Mitarbeiter Get_VorName");
		return vorName;
	}

	public void Set_Bemerkung(String value)
	{
		LOGGER.Info("Mitarbeiter Set_Bemerkung");
		bemerkung = value;
	}
	public String Get_Bemerkung()
	{
		LOGGER.Info("Mitarbeiter Get_Bemerkung");
		return bemerkung;
	}

	public String toString(){
		LOGGER.Info("Mitarbeiter toString entered");
		String ausgabe = "Personalnummer: " + Integer.toString(persNo) + " Name: " + nachName + ", " + vorName + " (" + bemerkung + ")\t\t";

		LOGGER.Info("Mitarbeiter toString left");
        return ausgabe;
    }

}
