package klammerParser;

public class Logger {

	private String name;
	
	Logger() 
	{
		name = "Logger";
	}
	
 	public String getName() 
 	{
 		return name;
 	}

	public static void log(String methode, String message)
	{
		System.out.println(methode.toUpperCase() + ": " + message);
	}
}
