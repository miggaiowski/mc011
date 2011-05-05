package semant.second_pass;

import graph.Graph;
import graph.Node;

import java.util.Enumeration;
import java.util.Hashtable;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.Program;

public class InheritanceBuilder {

	public static void secondPass(Env e, Program p) {
		// Vamos montar um grafo das classes, com arestas direcionadas
		// Os nós são as classes, e as arestas apontam da classe filha para a classe pai.
		// Depois de ter o grafo montado, basta verificar se existem ciclos.
		
		Graph inheritanceGraph = new Graph();
		Hashtable<String, Node> classNodes = new Hashtable<String, Node>();
		
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
//				System.out.println("Nó inserido: " + child.toString() + " Classe: " + className);
			}
			if (info.base != null) { // se a classe extende outra, ela tem uma baseclass
				String baseClassName = info.base.name.toString();
				if (!classNodes.containsKey(baseClassName)) {
					father = inheritanceGraph.newNode();
					classNodes.put(baseClassName, father);
//					System.out.println("Nó pai inserido: " + father.toString() + " Classe: " + baseClassName);
				}
				inheritanceGraph.addEdge(classNodes.get(className), classNodes.get(baseClassName)); // coloca a aresta da classe filha para seu pai
			}
		}

		// imprime uma lista de adjacencias do grafo
		inheritanceGraph.show(System.out);
		
		
	}
	
}
