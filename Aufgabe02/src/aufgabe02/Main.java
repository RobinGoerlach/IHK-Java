package aufgabe02;

import javax.swing.JOptionPane;

/** 
 * Project: Aufgabe 02 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose: 
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 * 
 */
public class Main {

	/**
	 * Application Main method
	 * @param args
	 */
	public static void main(String[] args) {
		/* Get Coordinate from User */ 
		String userEingabe = JOptionPane.showInputDialog("X Koordinate eingebne?");		
		double x = Double.parseDouble(userEingabe);
		userEingabe = JOptionPane.showInputDialog("Y Koordinate eingebne?");		
		double y = Double.parseDouble(userEingabe);

		Coordinate p = new Coordinate(x,y);
		System.out.println("Der Abstand der Koordinate (" + x + "," + y + ") zum Ursprung ist: " +p.Pythagoras());
	}

}
