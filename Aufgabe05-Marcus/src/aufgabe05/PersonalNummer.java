package aufgabe05;

public class PersonalNummer {

	private int personalnummer;
	
	PersonalNummer() {
		personalnummer = 5000;
	}
	
	public int counter()
	{
		return personalnummer;
	}

	public int next()
	{
		personalnummer++;
		return personalnummer;
	}

	public String toString(){
        return Integer.toString(personalnummer);
    }
}
