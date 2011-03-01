package interp;
import grammar.AssignStm;
import grammar.CompoundStm;
import grammar.EseqExp;
import grammar.IdExp;
import grammar.LastExpList;
import grammar.NumExp;
import grammar.OpExp;
import grammar.PairExpList;
import grammar.PrintStm;
import grammar.Stm;

public class prog {
    public static Stm prog =
		new CompoundStm(
			new AssignStm(
				"a", 
				new OpExp(new NumExp(5), OpExp.Plus, new NumExp(3))),
			new CompoundStm(
		        new AssignStm(
					"b", 
					new EseqExp(
						new PrintStm(
							new PairExpList(new IdExp("a"),
								new LastExpList(
								    new OpExp(new IdExp("a"), OpExp.Minus,new NumExp(1))))),
						new OpExp(
							new NumExp(10), 
							OpExp.Times,
							new IdExp("a")))),
				new PrintStm(
					new LastExpList(new IdExp("b")))));
    
    public static Stm prog2 =
        new CompoundStm(
            new AssignStm(
                "a", 
                new OpExp(new NumExp(5), OpExp.Plus, new NumExp(3))),
            new CompoundStm(
                new AssignStm(
                    "b", 
                    new EseqExp(
                        new PrintStm(
                            new PairExpList(new IdExp("a"),
                                new PairExpList(new IdExp("d"),
                                    new LastExpList(
                                        new OpExp(new IdExp("a"), OpExp.Minus,new NumExp(1)))))),
                        new OpExp(
                            new NumExp(10), 
                            OpExp.Times,
                            new IdExp("a")))),
                new PrintStm(
                    new LastExpList(new IdExp("b")))));
    
    public static Stm small = new PrintStm(new LastExpList(new IdExp("x")));
    
    public static Stm big = new CompoundStm(
        new AssignStm(
                "a", 
                new OpExp(new NumExp(5), OpExp.Plus, new NumExp(3))),        
        new PrintStm(
            new PairExpList(new IdExp("a"),
                    new PairExpList(new IdExp("a"),
                            new PairExpList(new IdExp("a"),
                                    new PairExpList(new IdExp("a"),
                                            new PairExpList(new IdExp("a"),
                                                    new PairExpList(new IdExp("a"),
                                                            new PairExpList(new IdExp("e"),
                                                                    new PairExpList(new IdExp("a"),
                                                                            new PairExpList(new IdExp("a"),
                                                                                    new PairExpList(new IdExp("a"),
                                                                                            new LastExpList(new IdExp("a"))
                                                                                    )
                                                                            )
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
        )
    );      

    public static Stm tricky = new PrintStm(
            new PairExpList(
                    new EseqExp(
                            new PrintStm(
                                    new PairExpList(new IdExp("a"),
                                            new PairExpList(new IdExp("a"),
                                                    new PairExpList(new IdExp("a"),
                                                            new PairExpList(new IdExp("a"),
                                                                    new PairExpList(new IdExp("a"),
                                                                            new PairExpList(new IdExp("a"),
                                                                                    new PairExpList(new IdExp("a"),
                                                                                            new LastExpList(new IdExp("end"))
                                                                                    )
                                                                            )
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            ), new IdExp("x")
                    ), 
                    new LastExpList(new IdExp("x"))));
    
    public static Stm easy = new CompoundStm(
            new AssignStm(
                    "a", 
                    new OpExp(new NumExp(5), OpExp.Plus, new NumExp(3))),
            new AssignStm(
                    "b", 
                    new OpExp(new NumExp(6), OpExp.Div, new NumExp(3))));
    
    public static Stm squares = new CompoundStm(
                                        new AssignStm(
                                                "a",
                                                new OpExp(new NumExp(1),OpExp.Times,new NumExp(1)) ),
                                        new CompoundStm(
                                        		new AssignStm(
                                                        "b",
                                                        new OpExp(new NumExp(2),OpExp.Times,new NumExp(2)) ), 
                                        		new CompoundStm(
                                        				new AssignStm(
                                                                "c",
                                                                new OpExp(new NumExp(3),OpExp.Times,new NumExp(3)) ), 
                                        				new CompoundStm(
                                        						new AssignStm(
                                                                        "d",
                                                                        new OpExp(new NumExp(4),OpExp.Times,new NumExp(4)) ), 
                                        						new CompoundStm(
                                        								new AssignStm(
                                                                                "e",
                                                                                new OpExp(new NumExp(5),OpExp.Times,new NumExp(5)) ), 
                                        								new PrintStm(
                                        										new PairExpList(
                                        												new IdExp("a"),
                                        												new PairExpList(
                                        														new IdExp("b"),
                                        														new PairExpList(
                                        																new IdExp("c"),
                                        																new PairExpList(
                                        																		new IdExp("d"),
                                        																		new LastExpList(
                                        																				new IdExp("e")
                                        																				)
                                        																		)
                                        																)
                                        														)
                                        												)
                                        										)
                                        								)
                                        						)
                                        				)
                                        		)
                                        );
}

    