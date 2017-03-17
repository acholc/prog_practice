import java.util.*;

public class Graph{

	private final int V;
	private final ArrayList<Integer>[] adj;
	
	public Graph(int V){
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int j =0; j < V; j++){
			adj[j] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V(){
		return V;
	}
}