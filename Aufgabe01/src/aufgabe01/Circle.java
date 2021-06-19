package aufgabe01;

/** 
 * Project: Aufgabe 01 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose: Some circle calculation methods 
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 * 
 */
public class Circle {

	/**
	 * circle radius
	 */
	private double radius; 
	
	/**
	 * Value of pi include Math. is to big for this 
	 */
	private double pi;     /* 3.14159.. */
	
	/**
	 * Empty constructor
	 */
	Circle() {
 		pi = 4 * Math.atan(1); 
		radius = 1;
	}

	/**
	 * Constructor initialize radius
	 * @param value
	 */
	Circle(double value) {
		pi = 4 * Math.atan(1);
		/* TODO: if (0 <= value) {
		 * throw new IllegalArgumentException("Value too small (" + value + ")");
		 */
		radius = value;
	}
	
	/**
	 * Get circle radius as double
	 * @return
	 */
	public double Get_Radius() { 
		/* Debug message
 		 * System.out.println("Pi: " + pi); */
		return radius;
	}
	
	/**
	 * Set circle Radius
	 * @param value
	 */
	public void Set_Radius(double value) {
		if (value > 0) 
		{
			/* TODO: if (0 <= value) {
			 * throw new IllegalArgumentException("Value too small (" + value + ")");
			 */
			radius = value;
		} 
	}

	/**
	 * Calculate circle diameter as double
	 */ 
	public double diameter() {		
		return 2 * radius;
	}

	/**
	 *  Determine the circumference as double
	 */
	public double circumference() {	
		return pi * diameter();
	}

	/**
	 *  Determine the circular area as double
	 */
	public double area()
	{		
		return pi * radius * radius;
	}
}
