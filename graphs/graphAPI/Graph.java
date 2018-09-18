package graphAPI;

//   https://algs4.cs.princeton.edu/41graph/Graph.java.html
import java.util.Iterator;

import BagAPI.Bag;

public class Graph{
	
	private final int V;
	private int E;
	public Bag<Integer>[] adjList;
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public Graph(int V){
		this.V=V;
		this.E=0;
		adjList = (Bag<Integer>[])new Bag[V];
		for(int i=0;i<V;i++){
			adjList[i] = new Bag<Integer>();
		}
	}
	
	
	/*******************************************************Helper Methods***********************************************/
	

	private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}
	
	 public int degree(int v) {
		 validateVertex(v);
	        return adjList[v].size();
	    }
	
	public Iterator<Integer> adj(int v) {
		validateVertex(v);
        return adjList[v].iterator();
    }

	public void getAdjacentVertices(int vertex){
		validateVertex(vertex);
		Iterator<Integer> itr = adjList[vertex].iterator();
		while(itr.hasNext()){
			Integer i = itr.next();
			System.out.print(i+",");
		}
	}
	
	/*********************************************************************************************************************/
	
	public void addEdge(Graph g, int src,int dest){
		validateVertex(src);
		validateVertex(dest);
		g.adjList[src].add(dest);
		g.adjList[dest].add(src);
		E++;
	}	
	
	public void print(Graph g){
		for(int i=0;i<g.getV();i++){
			System.out.print(i+"->");
			for(Integer j : adjList[i]){
				System.out.print(j+",");
			}
			System.out.println();
		}
	}
	
	/*public String toString(grph g){
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for(int i=0;i<g.getV();i++){
			s.append(i + ": ");
			for(Integer j : adjList[i]){
				s.append(j + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
		
	}*/

}


/*public class Graph {

	public static void main(String[] args) {
		
		grph g = new grph(5);
		g.addEdge(g, 1, 3);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 2, 4);
		g.addEdge(g, 4, 1);
		//g.getAdjacentVertices(1);
		System.out.println(g.adj(1).toString());
		//g.print(g);
	}

}
*/