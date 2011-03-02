package postfix;                                            
import postfix.analysis.*;                                  
import postfix.node.*;                                      
                                                            
class Translation extends DepthFirstAdapter                 
{                                                           
 public void caseTNumber(TNumber node)                      
 {// When we see a number, we print it.                     
  System.out.print(node);                                   
 }                                                          
                                                            
 public void outAPlusExpr(APlusExpr node)                   
 {// out of alternative {plus} in Expr, we print the plus.  
  System.out.print(node.getPlus());                         
 }                                                          
                                                            
 public void outAMinusExpr(AMinusExpr node)                 
 {// out of alternative {minus} in Expr, we print the minus.
  System.out.print(node.getMinus());                        
 }                                                          
                                                            
 public void outAMultFactor(AMultFactor node)               
 {// out of alternative {mult} in Factor, we print the mult.
  System.out.print(node.getMult());                         
 }                                                          
                                                            
 public void outADivFactor(ADivFactor node)                 
 {// out of alternative {div} in Factor, we print the div.  
  System.out.print(node.getDiv());                          
 }                                                          
                                                            
 public void outAModFactor(AModFactor node)                 
 {// out of alternative {mod} in Factor, we print the mod.  
  System.out.print(node.getMod());                          
 }                                                          
}                                                           

