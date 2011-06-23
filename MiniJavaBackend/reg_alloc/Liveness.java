package reg_alloc;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import temp.Temp;
import util.List;
import flow_graph.FlowGraph;
import graph.Node;

public class Liveness extends InterferenceGraph
{
    private FlowGraph graph;
    
    public void addEdge(Node src, Node dst)
    {
        if ( src != dst && !dst.comesFrom(src) && !src.comesFrom(dst))
            super.addEdge(src, dst);
    }
    
    // estruturas usadas para computar a DFA
    private Hashtable<Node, HashSet<Temp>> in;
    private Hashtable<Node, HashSet<Temp>> out;
    private Hashtable<Node, HashSet<Temp>> gen;
    private Hashtable<Node, HashSet<Temp>> kill;
    private Hashtable<Node, HashSet<Temp>> inprime;
    private Hashtable<Node, HashSet<Temp>> outprime;
        
    public void show(PrintStream o)
    {       
        for ( List<Node> aux = this.nodes(); aux != null; aux = aux.tail )
        {
            Temp t = revMap.get(aux.head);
            
            o.print(t + ": [ ");
            for ( List<Node> adjs = aux.head.adj(); adjs != null; adjs = adjs.tail )
                o.print( revMap.get(adjs.head) + " ");
            o.println("]");
        }
    }
    
    // coisas uteis
    private MoveList moveList = null;
    
    private Hashtable<Node, Temp> revMap = new Hashtable<Node, Temp>();
    private Hashtable<Temp, Node> map = new Hashtable<Temp, Node>();
    
    public Liveness(FlowGraph g)
    {
        super();
    
        graph = g;
            
        computeGenKill();
        computeDFA();
        buildInterference();
    }

    public void dump(PrintStream outStream)
    {
        int c=0;
        for(List<Node> aux = graph.nodes(); aux != null; aux = aux.tail, c++)
        {
            HashSet<Temp> i = in.get(aux.head);
            HashSet<Temp> o = out.get(aux.head);
            HashSet<Temp> g = gen.get(aux.head);
            HashSet<Temp> k = kill.get(aux.head);
            
            outStream.println(c+": gen:"+g+" kill:"+k+" in:"+i+" out:"+o);
        }
    }
    
    private void computeGenKill()
    {
        kill = new Hashtable<Node, HashSet<Temp>>();
        gen  = new Hashtable<Node, HashSet<Temp>>();
        
        for(List<Node> nodes = graph.nodes(); nodes != null; nodes = nodes.tail)
        {
            HashSet<Temp> k = new HashSet<Temp>();
            HashSet<Temp> g = new HashSet<Temp>();
            
            // kill
            for ( List<Temp> aux = graph.def(nodes.head); aux != null; aux = aux.tail )
                k.add(aux.head);
            
            // gen
            for ( List<Temp> aux = graph.use(nodes.head); aux != null; aux = aux.tail )
                g.add(aux.head);
            
            kill.put(nodes.head, k);
            gen.put(nodes.head, g);
        }
    }
    
    private void computeDFA()
    {	
        // Inicializa in, out, inprime, outprime
        in = new Hashtable<Node, HashSet<Temp>>();
        out = new Hashtable<Node, HashSet<Temp>>();
        inprime = new Hashtable<Node, HashSet<Temp>>();
        outprime = new Hashtable<Node, HashSet<Temp>>();

        // coloca os nodes em ordem inversa nessa ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        for ( List<Node> aux = graph.nodes(); aux != null; aux = aux.tail )
        {
            nodes.add(0, aux.head);
            //System.out.println(nodes.toString());
            in.put(aux.head, new HashSet<Temp>()); // Começa 
            out.put(aux.head, new HashSet<Temp>());
        }
                
        do {
            for (Node n : nodes) {
                // out'[n] <- out[n];
                HashSet<Temp> outtemp = new HashSet<Temp>();
                outtemp.addAll(out.get(n));
                outprime.put(n, outtemp);
                // in'[n] <- in[n]
                inprime.put(n, in.get(n));
            }

            for (Node n : nodes) {
                // in[n] <- use[n] U (out[n] - def[n]);
                HashSet<Temp> t = new HashSet<Temp>();
                t.addAll(gen.get(n));
                //t.addAll(out_menos_def(n));
                HashSet<Temp> res = new HashSet<Temp>();
                res.addAll(out.get(n));
                res.removeAll(kill.get(n));
                t.addAll(res);
                in.put(n, t);
                
                // out[n] <- U(s in succ[n]) (in[s]) 
                HashSet<Temp> r = new HashSet<Temp>();
                for ( List<Node> succ = n.succ(); succ != null; succ = succ.tail )
                {
                    Node s = succ.head;
                    r.addAll(in.get(s));
                } 
                out.put(n, r);
            }            
 
        } while (compara_ins() == false || compara_outs() == false);
        System.out.println("Saiu");
        //dump(System.err);
        //graph.show(System.out);
    }
    
    private Boolean compara_ins() {
        Hashtable<Node, HashSet<Temp>> a = in;
        Hashtable<Node, HashSet<Temp>> b = inprime;
        // Primeiro testa se ambas hashtables tem as mesmas chaves.
            if (b.keySet().containsAll(a.keySet()) == false) {
 //               System.out.println("Chaves de in e inprime estão diferentes.");
                return false;
            }
            if (a.keySet().containsAll(b.keySet()) == false) {
//                System.out.println("Chaves de in e inprime estão diferentes.");
                return false;
            }

        // Testa se a[n] C b[n] e se b[n] C a[n].
        // Se sim, é porque n mapeia para o mesmo conjunto
        for (Node n : a.keySet()) {
            if (a.get(n).containsAll(b.get(n)) == false) {
//                System.out.println("Conjuntos de in[" + n + "] e inprime[" + n + "] diferem.");
                return false;
            }
            if (b.get(n).containsAll(a.get(n)) == false) {
                //System.out.println("Conjuntos de in[" + n + "] e inprime[" + n + "] diferem.");
                return false;
            }
        }
        return true;
    }
    
    private Boolean compara_outs() {
        Hashtable<Node, HashSet<Temp>> a = out;
        Hashtable<Node, HashSet<Temp>> b = outprime;
        // Primeiro testa se ambas hashtables tem as mesmas chaves.
            if (b.keySet().containsAll(a.keySet()) == false) {
                //System.out.println("Chaves de out e outprime estão diferentes.");
                return false;
            }
            if (a.keySet().containsAll(b.keySet()) == false) {
                //System.out.println("Chaves de out e outprime estão diferentes.");
                return false;
            }

        // Testa se a[n] C b[n] e se b[n] C a[n].
        // Se sim, é porque n mapeia para o mesmo conjunto
        for (Node n : a.keySet()) {
            if (a.get(n).containsAll(b.get(n)) == false) {
                //System.out.println("Conjuntos de out[" + n + "] e outprime[" + n + "] diferem.");
                return false;
            }
            if (b.get(n).containsAll(a.get(n)) == false) {
                //System.out.println("Conjuntos de out[" + n + "] e outprime[" + n + "] diferem.");
                return false;
            }
        }
        return true;
    }
    
    private HashSet<Temp> out_menos_def(Node n) {
        HashSet<Temp> res = new HashSet<Temp>();
        res.addAll(out.get(n));
        res.removeAll(kill.get(n));
        return res;
    }
    
    private Node getNode(Temp t)
    {
        Node n = map.get(t);
        
        if ( n == null )
        {
            n = this.newNode();
            
            map.put(t, n);
            revMap.put(n, t);
        }
        
        return n;
    }
    
    private void handle(Node instr)
    {
        for( List<Temp> defs = graph.def(instr); defs != null; defs = defs.tail )
        {
            Node currentTemp = this.getNode(defs.head);
            
            for( Temp liveOut : out.get(instr) )
            {                
                Node currentLiveOut = this.getNode(liveOut);
                this.addEdge(currentTemp, currentLiveOut);
            }
        }
    }
    
    private void handleMove(Node instr)
    {
        Node dst = this.getNode(graph.def(instr).head);
        Node src = this.getNode(graph.use(instr).head);
        
        moveList = new MoveList(src, dst, moveList);
        
        for( Temp t : out.get(instr) )
        {
            Node currentOut = this.getNode(t);
            
            if ( currentOut != src )
            {
                //this.addEdge(currentOut, dst);
                this.addEdge(dst, currentOut);
            }
        }
    }
    
    private void buildInterference()
    {
        // Estamos sentados sobre ombros de um gigante...
        // Aqui, nos temos uma lista sobre todos os temporarios
        // vivos no fim de cada no. Desta forma, eh relativamente
        // facil construir a lista de adjacencia.
        
        for ( List<Node> instrs = graph.nodes(); instrs != null; instrs = instrs.tail )
        {
            Node current = instrs.head;
            
            if ( graph.isMove(current))
                handleMove(current);
            else
                handle(current);
        }
    }
    
    public Node tnode(Temp temp)
    {
        Node n = map.get(temp);
        
        if ( n == null )
        {
            map.put(temp, n = newNode() );
            revMap.put(n, temp);
        }
        
        return n;
    }

    public Temp gtemp(Node node)
    {
        return revMap.get(node);
    }

    public MoveList moves()
    {
        return moveList;
    }

    public HashSet<Temp> Out(Node node)
    {
        return out.get(node);
    }    
}
