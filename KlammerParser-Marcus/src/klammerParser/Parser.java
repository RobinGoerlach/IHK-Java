package klammerParser;

public class Parser {

	private String brack;
	private String name;
	private char letzter;
	
	Parser () 
	{
		name = "Parser";
		Logger.log(this.getName(),"");
	}
	
	Parser(String value)
	{
		name = "Parser";
		brack = value;
		Logger.log(this.getName(),brack);
	}
		
 	public String getName() 
 	{
 		return name;
 	}

 	public void Set(String value) 
 	{
 		brack = value;
 	}
 	
 	public String Get() 
 	{
 		return brack;
 	}
 	
	public boolean result()
	{
		long counter = 0L;
		
		Stack bracket = new Stack("()");   /* () */
		Stack brace = new Stack("{}");     /* {} */
		Stack angular = new Stack("[]");   /* [] */
		Stack angle = new Stack("<>");     /* <> */
		
		for (int i = 0; i<brack.length(); i++)
		{
			switch (brack.charAt(i)) {
			case '(':
				// letzter == ')' ? bracket.push() :  ;
				counter = bracket.push();
				break;
			case ')':
				counter = bracket.pop();
				break;
			case '{':
				// letzter == '}' ? bracket.push() :  ;
				counter = brace.push();
				break;
			case '}':
				counter = brace.pop();
				break;
			case '[':
				// letzter == ']' ? bracket.push() :  ;
				counter = angular.push();
				break;
			case ']':
				counter = angular.pop();
				break;
			case '<':
				// letzter == '>' ? bracket.push() :  ;
				counter = angle.push();
				break;
			case '>':
				counter = angle.pop();
				break;
			default:
				return false;
			}	
			letzter = brack.charAt(i);
			if (counter < 0) return false;
		}
		
		long val = bracket.length() + brace.length() + angular.length() + angle.length(); 
		return (val == 0) ?  true :  false;		
	}	
}
