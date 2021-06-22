package klammerParser;

import javax.swing.JOptionPane;

public class Main 
{

	public static void main(String[] args) {
		
		String bla; 
		bla = JOptionPane.showInputDialog("Bitte den Klammerausdruck eingeben");
		// bla = "(";                 // inkorrekt   
		// bla = "(])";                // inkorrekt   
		// bla = "(][)";               // inkorrekt   
		// bla = "({[<>]})";          // korrekt
		// bla = "(({{[[<<>>]]}}))";  // korrekt
		
		Parser parser = new Parser(bla);
		// parser.result() ? System.out.println("Ausdruck korrekt!") : System.out.println("Ausdruck inkorrekt!");
		
		if (parser.result()) 
		{
			System.out.println("Ausdruck korrekt!");
		}
		else 
		{	
			System.out.println("Ausdruck inkorrekt!");
		}
	}
}
