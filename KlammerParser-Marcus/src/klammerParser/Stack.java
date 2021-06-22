package klammerParser;


public class Stack {
		
	private String name;
	private String bezeichner;
	private long count;
	
 	public Stack()
	{
 		name = "Stack";
		count = 0;
	}
 	
 	public Stack(String value)
	{
 		bezeichner = value;
 		name = "Stack";
		count = 0;
	}

 	public String getName() 
 	{
 		return name;
 	}
		
	public long push()
	{		
		Logger.log(this.getName() + " " + bezeichner,"push (" + count + ")");
		return ++count;
	}
	
	public long pop()
	{
		Logger.log(this.getName() + " " + bezeichner,"pop  ("+ count +")");
		return --count;
	}
	
	public long length()
	{
		Logger.log(this.getName() + " " + bezeichner,"len:  " + count+"");
		return count;
	}
}
