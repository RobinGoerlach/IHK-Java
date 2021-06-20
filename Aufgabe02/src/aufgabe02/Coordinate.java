package aufgabe02;

/** 
* Project: Aufgabe 02 (IHK Schwaben Software Developer IHK - JAVA) 
*          Objektorientierte Grundlagen  
* Purpose: 
* @author  Robin Goerlach <robin.goerlach@sasd.de>
* @version 1.00.00 - 2021.06.02
* 
*/
public class Coordinate {
    
	/*
	 * x-Part of Cartesian coordinate 
	 */
	private double x;
	
	/**
	 * y-Part of Cartesian coordinate 
	 */
	private double y;
	
	/**
	 * Empty Constructor
	 */
	Coordinate()
	{
		x = 1;
		y = 1;
	}
	
	/**
	 * Constructor feeding Cartesian coordinate
	 * @param x
	 * @param y
	 */
	Coordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/** 
	 * Get x-Part of Cartesian coordinate 
	 * @return
	 */
	public double Get_x() 
	{
		return x;
	}

	/**
	 * Set x-Part of Cartesian coordinate 
	 * @param value
	 */
	public void Set_x(double value) 
	{
		x = value;
	}
	
	/**
	 * Get x-Part of Cartesian coordinate 
	 * @return
	 */
	public double Get_y() 
	{
		return y;
	}
	
	/**
	 * Set y-Part of Cartesian coordinate 
	 * @param value
	 */
	public void Set_y(double value) 
	{
		y = value;
	}
	
	/** 
	 * Calculate the distance to the origin 
	 * @return
	 */
	public double Pythagoras()
	{
		return Math.sqrt(x*x + y*y);
	}
}