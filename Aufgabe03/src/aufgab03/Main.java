package aufgab03;

import java.util.Random;

/** 
 * Project: Aufgabe 03 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose: 
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 * 
 */
public class Main {

	/**
	 * Entry's Amount  
	 */
	private static final int ENTITIES = 100;
	
	/**
	 *  Application Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Coordinate[] punkte;
		punkte = new Coordinate[ENTITIES];

		initializeCoordinateField(punkte);
		Coordinate p = CalculateOriginDistance(punkte);
		 
		DisplayMaxDistanceCoordinate(p); 
	}

	/**
	 * Initialize Coordinate Array (Field)
	 */
	private static void initializeCoordinateField(Coordinate[] punkte) {
		/* Initialize random generator */
		Random random = new Random();

		/*  */ 
		for (int i = 0; i < punkte.length; i++){
			punkte[i] = new Coordinate();
			punkte[i].Set_x(random.nextDouble() * 1000);
			punkte[i].Set_y(random.nextDouble() * 1000);
		}
		
	}

	/**
	 * Calculate coordinate distance to origin
	 * @param punkte
	 * @return max distance Coordinate 
	 */
	private static Coordinate CalculateOriginDistance(Coordinate[] punkte) {
		// TODO Auto-generated method stub
		Coordinate p = new Coordinate();
		double maxDistance = -2000.0;
		int maxPos = 0;
		for (int i = 0; i < punkte.length; i++){
			p = punkte[i];
			// System.out.println("[" + i +"]\tDie Koordinate " + p.toString() +" hat den Abstand \t" + p.Pythagoras() + " zum Ursprung");
			if (maxDistance < p.Pythagoras()) 
			{
				maxDistance = p.Pythagoras();
				maxPos = i;
			    /* System.out.println("[" + i +"] \t: " + maxPos); */
			}
		}
		
		return punkte[maxPos];
	}

	/**
	 * Display Coordinate with max distance
	 * @param p
	 */
	private static void DisplayMaxDistanceCoordinate(Coordinate p) {		
		System.out.println("Die Koordinate " + p.toString() +" hat den maximalen Abstand \t" + p.Pythagoras() + " zum Ursprung");		
	}
}
