package bfsDfs;

// https://algs4.cs.princeton.edu/41graph/BreadthFirstPaths.java.html
import graphAPI.Graph;

class BFS{
	
	private Boolean visited[];
	QueueOverridden<Integer> queue;
	Graph g;
	int V;
	
	BFS(Graph g,int V){
		this.g=g;
		this.V=V;
		queue = new QueueOverridden<Integer>();
		visited = new Boolean[V];
		for(int i = 0; i< V;i++){
			visited[i]=false;
		}
		for(int i = 0; i< V;i++){
			if(visited[i]==false){
				bfsUtil(i,visited,queue);
			}
		}
	}

	private void bfsUtil(Integer i, Boolean[] visited, QueueOverridden<Integer> queue) {
		visited[i]=true;
		queue.enqueue(i);
		System.out.print(i+ " ");
		while(!queue.isEmpty()){
			Integer v = queue.dequeue();
			for(Integer w : g.adjList[v]){
				if(!visited[w]){
					queue.enqueue(w);
					visited[w]=true;
					System.out.print(w+ " ");
				}
			}
		}
	}
}

public class BFSImpl {

	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.addEdge(g, 1, 3);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 2, 4);
		g.addEdge(g, 4, 1);
		
		BFS traverse = new BFS(g,g.getV());
	}

}

