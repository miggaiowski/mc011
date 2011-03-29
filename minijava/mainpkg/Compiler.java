package mainpkg;                               
import java.io.InputStreamReader;
import java.io.PushbackReader;

import analysis.DepthFirstAdapter;
import analysis.Printer;

import lexer.Lexer;
import node.Start;
import parser.Parser;

public class Compiler                                   
{                                                       
	public static void main(String[] arguments)            
	{                                                      
		try                                                   
		{                                                     
			//System.out.println("Type an arithmetic expression:");

			Lexer lexer =                                           
				new Lexer(                                          
						new PushbackReader(                                 
								new InputStreamReader(System.in), 1024));          




			// Create a Parser instance.                         
			Parser p =                                           
			 new Parser(lexer);          

			// Parse the input.                                  
			Start tree = p.parse(); 
			Printer printer = new Printer();
			tree.apply(printer);
			
//			String className[];     
//			Token token;
//			token = lexer.next();
//			while (token != null) {
//				if (! (token instanceof TBlank)) {
//					className = token.getClass().toString().split("\\.");
//					System.out.print(className[className.length - 1] + " "); // this prints the name of the token
//				}
//				token = lexer.next(); 
//			}
			


			//  Apply the translation.                            
			//tree.apply(new Translation());                       
		}                                                     
		catch(Exception e)                                    
		{                                                     
			System.out.println(e.getMessage());                  
		}                                                     
	}                                                      
}                                                       


