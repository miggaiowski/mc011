package mainpkg;                               
import java.io.InputStreamReader;
import java.io.PushbackReader;

import lexer.Lexer;
import node.Start;
import parser.Parser;
import analysis.PrettyPrint;

public class Compiler                                   
{                                                       
	public static void main(String[] arguments)            
	{                                                      
		try                                                   
		{                                                     
			Lexer lexer =                                           
				new Lexer(                                          
						new PushbackReader(                                 
								new InputStreamReader(System.in), 1024));          

			// Create a Parser instance.                         
			Parser p =                                           
				new Parser(lexer);          

			// Parse the input.                                  
			Start tree = p.parse(); 
			PrettyPrint pp = new PrettyPrint();
			tree.apply(pp);                  
		}                                                     
		catch(Exception e)                                    
		{                                                     
			System.out.println(e.getMessage());                  
		}                                                     
	}                                                      
}                                                       


