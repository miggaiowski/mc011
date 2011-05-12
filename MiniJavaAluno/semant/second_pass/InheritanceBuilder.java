package semant.second_pass;

import graph.Graph;
import graph.Node;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.Program;
import util.List;

public class InheritanceBuilder {
    
    public static void secondPass(Env e, Program p) {
        // Vamos montar um grafo das classes, com arestas direcionadas
        // Os nós são as classes, e as arestas apontam da classe filha para a classe pai.
        // Depois de ter o grafo montado, basta verificar se existem ciclos.
        
        Graph inheritanceGraph = new Graph();
        Hashtable<String, Node> classNodes = new Hashtable<String, Node>();
        ArrayList<String> classNames = new ArrayList<String>();
        
        // cria o grafo com os nós e arestas de filhos para pais
        Node child, father;
        Symbol key;
        Enumeration<Symbol> keys = e.classes.keys();
        while(keys.hasMoreElements()) { // para cada classe de env
            key = keys.nextElement();
            ClassInfo info = e.classes.get(key);
            String className = info.name.toString(); // nome da classe
            if (!classNodes.containsKey(className)) { // se já não foi inserido um nó pra esta classe
                child = inheritanceGraph.newNode(); // cria o nó no grafo
                classNodes.put(className, child); // guarda na hashtable este nó
                classNames.add(className);
                // System.out.println("Nó inserido: " + child.toString() + " Classe: " + className);
            }
            if (info.base != null) { // se a classe extende outra, ela tem uma baseclass
                String baseClassName = info.base.name.toString();
                if (!classNodes.containsKey(baseClassName)) {
                    father = inheritanceGraph.newNode();
                    classNodes.put(baseClassName, father);
                    classNames.add(baseClassName);
                    // System.out.println("Nó pai inserido: " + father.toString() + " Classe: " + baseClassName);
                }
                inheritanceGraph.addEdge(classNodes.get(className), classNodes.get(baseClassName)); // coloca a aresta da classe filha para seu pai
            }
        }
        
        // imprime uma lista de adjacencias do grafo
        // inheritanceGraph.show(System.out);
        
        List<Node> nodes = inheritanceGraph.nodes();
        ArrayList<ArrayList<Node>> cycles = new ArrayList<ArrayList<Node>>();
        while (nodes != null) {
            // vetor que guarda se um nó já foi visitado
            Boolean visited[] = new Boolean[inheritanceGraph.nodes().size()];
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false; // zerando o vetor
            }
            ArrayList<Node> cycle = new ArrayList<Node>(); // a lista dos nós no ciclo
            
            if (findCycle(inheritanceGraph, visited, nodes.head, nodes.head, cycle)) {
                cycles.add(cycle);
            }
            nodes = nodes.tail; // continuar buscando a partir de outro vértice, já que pode ser desconexo
        }
        
        for (int i = 0; i < cycles.size(); i++) {
            for (int j = cycles.size() - 1; j > i; j--) {
                if (sameCycle(cycles.get(i), cycles.get(j))) {
                    cycles.remove(j);
                    // System.out.println(j + " Removido");
                }
            }
            String errString = printCycle(cycles.get(i), classNames); // se encontrou um ciclo, imprimir
            // System.out.println(errString);
            e.err.Error(p, new Object[]{"Herança cíclica de classes.", "Ciclo: " + errString});
        }
        
    }
    
    private static String printCycle(ArrayList<Node> cycle, ArrayList<String> classNames) {
        String erroString = new String();
        // System.out.println("Herança Cíclica das classes:");
        for (int i = 0; i < cycle.size(); i++) {
            // System.out.print(cycle.get(i).toString() + " " );
            erroString = erroString.concat(classNames.get(Integer.decode(cycle.get(i).toString())) + " -> ");
        }
        erroString = erroString.concat(classNames.get(Integer.decode(cycle.get(0).toString())));
        // System.out.println();
        
        return erroString;
    }
    
    private static Boolean sameCycle(ArrayList<Node> c1, ArrayList<Node> c2) {
        if (c1.size() != c2.size())
            return false; // se não tem o mesmo tamanho não pode ser uma permutação.
        
//        // encontra o primeiro nó do ciclo
//        int min = Integer.MAX_VALUE, mini = 0;
//        for (int i = 0; i < c1.size(); i++) {
//            int no = Integer.decode(c1.get(i).toString()); 
//            if (no < min) {
//                min = no;
//                mini = i;
//            }
//        }
        // pega o local do primeiro nó no outro ciclo
        int i = 0;
        int j = c2.indexOf(c1.get(i));

        // percorre os dois ciclos circularmente verificando se são os mesmo nós
        for (int k = 0; k < c1.size(); k++) {
            int no1 = Integer.decode(c1.get(i).toString());
            int no2 = Integer.decode(c2.get(j).toString());            
            if (no1 != no2) {
                return false; // não são iguais!
            }
            i = (i + 1) % c1.size();
            j = (j + 1) % c2.size();
        }
        return true;
    }
    
    private static Boolean findCycle(Graph g, Boolean visited[], Node a, Node b, ArrayList<Node> cycle) {
        
        //        System.out.println(a.toString() + " " + b.toString() + " " + cycle.size() + 
        //                " " + visited[Integer.decode(a.toString())]);
        
        // se já andamos por uma aresta e já voltamos para o início, temos um ciclo!
        if (cycle.size() > 0 && a.toString().equals(b.toString())) {
            //cycle.add(a);
            return true;
        }
        
        cycle.add(b); // este nó possivelmente estará no ciclo, entra por enquanto
        if (!(a.toString().equals(b.toString()))) { // se não estamos na primeira iteração
            visited[Integer.decode(b.toString())] = true; // marca o nó b como visitado
        }
        
        List<Node> adjs = b.succ(); 
        while (adjs != null) {
            Node u = adjs.head;
//            System.out.println(a.toString() + " " + b.toString() + " " + cycle.size() + 
//                    " " + visited[Integer.decode(a.toString())] + " " + u.toString());
            
            if (!visited[Integer.decode(u.toString())]) { // só vai para nós ainda não visitados
                if (!findCycle(g, visited, a, u, cycle)) { 
                    cycle.remove(cycle.size() - 1); // se nao achou ciclo, retira o nó que a chamada acima adicionou na lista.
                }
                else {
                    return true;
                }
            }
            adjs = adjs.tail; // continua a busca por outro nó adjacente
        }
        return false;
    }
}
