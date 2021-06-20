package aufgabe04;

import java.util.Random;

/**
 * Project: Aufgabe 04 (IHK Schwaben Software Developer IHK - JAVA) 
 *          Objektorientierte Grundlagen  
 * Purpose: 
 * Dependence: 
 * @author  Robin Goerlach <robin.goerlach@sasd.de>
 * @version 1.00.00 - 2021.06.02
 */
public class Coordinates {

	/** 
	 * Amount of entries in coordinates array/field
	 */
	private static final int ENTITIES = 10;
	
	/**
	 * coordinates array/field
	 */
	private	Coordinate[] p;
	
	/**
	 * Origin distance
	 */
	private double[] metrik;

	/**
	 * Empty Constructor
	 */
	Coordinates() 
	{
		/* Initialize Random generator */
		Random random = new Random();
		
		/* Initialize coordinates array */
		p = new Coordinate[ENTITIES];
		for (int i = 0; i < p.length; i++){
			p[i] = new Coordinate();
			p[i].Set_x(random.nextDouble() * 1000);
			p[i].Set_y(random.nextDouble() * 1000);
		}
	}

	/**
	 * Display all Array Elements 
	 */ 
	public void DisplayEntries() 
	{
		for (int i = 0; i < p.length; i++)
		{
			/* TODO: you can do this more efficient  */
			if (i<10) {System.out.print("[  " + i +"] (");} else
			if (i<100) {System.out.print("[ " + i +"] (");} else {
				System.out.print("[" + i +"] (");
			}
			System.out.println(p[i].Get_x() +"," + p[i].Get_y() + ")");
		}
	}

	/**
	 *  Calculate Origin distance 
	 */ 
    public void CalculateOriginDistance() 
    {
    	metrik = new double[ENTITIES];
    	Coordinate pkt = new Coordinate();
		for (int i = 0; i < p.length; i++)
		{
			pkt = p[i];
			metrik[i] = pkt.Pythagoras();
		}    	
    }

    /** 
     * sort entry's by Origin distance      * 
     */
    public void sortByOriginDistanceAndDisplay()
    {
    	double temp;
		for(int i=1; i<metrik.length; i++) 
		{
			for(int j=0; j<metrik.length-i; j++) 
			{
				if(metrik[j]>metrik[j+1]) 
				{
					temp=metrik[j];
					metrik[j]=metrik[j+1];
					metrik[j+1]=temp;
				}				
			}
		}
		
		/* TODO this could be separated */
		for(int i=1; i<metrik.length; i++) 
		{
			/* TODO beautify output */
			System.out.println(	"[" + i +"] (" + p[i].Get_x() +"," + p[i].Get_y() + "): " + metrik[i]);
		}
    }
}
