package aufgabe01;

import javax.swing.JOptionPane;

/** 
 * Project: Aufgabe 01 (IHK Schwaben Software Developer IHK - JAVA) 
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
		/* Ask user circle radius */ 
		String userInput = JOptionPane.showInputDialog("Radius des Kreis eingebne?");		
		double radius = Double.parseDouble(userInput);
		
		/* Kreis erzeugen */
		Circle k = new Circle(radius);
		
		/* Determine technical circle data */
		System.out.println("Radius des Kreis     : " + k.Get_Radius());
		System.out.println("Durchmesser des Kreis: " + k.diameter());
		System.out.println("Umfang des Kreis     : " + k.circumference());
		System.out.println("Fl�che des Kreis     : " + k.area());		
	}

}
