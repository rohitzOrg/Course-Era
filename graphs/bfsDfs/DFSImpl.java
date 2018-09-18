package bfsDfs;
import java.util.Stack;

import graphAPI.Graph;

class DFS{
	private Boolean visited[];
	Stack<Integer> stack;
	Graph g;
	int V;
	
	DFS(Graph g,int V){
		this.g=g;
		this.V=V;
		stack = new Stack<Integer>();
		visited = new Boolean[V];
		for(int i = 0; i< V;i++){
			visited[i]=false;
		}
		for(int i = 0; i< V;i++){
			if(visited[i]==false){
				dfsUtil(i,visited,stack);
			}
		}
	}

	private void dfsUtil(int i, Boolean[] visited, Stack<Integer> stack) {
		visited[i]=true;
		/*Integer vertex;
		Iterator<Integer> itr = g.adjList[i].iterator();
		while(itr.hasNext()){
			vertex = itr.next();
			if(!visited[vertex]){
				dfsUtil(vertex,visited,stack);
			}
		}
		stack.push(new Integer(i));*/
		for(Integer x : g.adjList[i]){
			if(!visited[x]){
				dfsUtil(x,visited,stack);
			}
		}
		stack.push(new Integer(i));
	}
	
	public void print(){
		while(stack.empty()==false){
			System.out.print(stack.pop()+" ");
		}
	}
}

public class DFSImpl {

	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.addEdge(g, 1, 3);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 2, 4);
		g.addEdge(g, 4, 1);
		
		DFS traverse = new DFS(g,g.getV());
		traverse.print();
		//g.print(g);
	}

}
