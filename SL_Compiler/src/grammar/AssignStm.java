package grammar;
public class AssignStm extends Stm {
	public String id; public Exp exp;
    
	public AssignStm(String i, Exp e) { // Constructor
    	id=i; exp=e;
    }
}