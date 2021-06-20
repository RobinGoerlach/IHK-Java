package aufgabe04;

/**
 * Project: Aufgabe 04 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose: 
 * Dependence: 
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 */
public class Main {

	/**
	 * Application Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Coordinates p = new Coordinates();
		/* p.DisplayEntries(); */
		p.CalculateOriginDistance();
		p.sortByOriginDistanceAndDisplay();
	}
}
