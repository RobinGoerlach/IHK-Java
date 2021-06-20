package aufgab03;


public class Coordinate {

	private double x;
	private double y;
	
	Coordinate()
	{
		x = 1;
		y = 1;
	}
	
	Coordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double Get_x() 
	{
		return x;
	}
	
	public void Set_x(double value) 
	{
		x = value;
	}
	
	public double Get_y() 
	{
		return y;
	}
	
	public void Set_y(double value) 
	{
		y = value;
	}
	
	public double Pythagoras()
	{
		return Math.sqrt(x*x + y*y);
	}
	
	public String toString(){
        return "(" + x + "\t , " + y + " ) ";
    }

}
