import java.util.*;

public class ShortestPathFewestEdges{
    
    private double[] distTo;
    private int[] edgesTo;
    private int[] edgeCt;
    private boolean[] marked;
    
    
    public ShortestPathFewestEdges(Graph G, int s, int t){
        this.distTo = new double[G.V()];
        this.edgesTo = new int[G.V()];
        this.edgeCt = new int[G.V()];
        this.marked = new boolean[G.V()];
        
        bfs(G, s);
        
        Deque<Integer> shortestPath = new ArrayDeque<>();
        for(int to = t; to != s; to = edgesTo[to] ){
            shortestPath.addFirst(to);
        }
        shortestPath.addFirst(s);
    }
    
    public void bfs(Graph G, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        distTo[s] = 0;
        edgeCt[s] = 0;
        
        while(q.size() > 0){
            int n = q.poll();
            for(Edge e: G.adj(n)){
                int v = e.other(n);
                if(!marked[v]){
                    q.add(v);
                    marked[v] = true;
                    update(v,n);
                    distTo[v] = distTo[n]+ e.wt();
                }else if(distTo[v] > distTo[n] + e.wt()){
                    update(v,n);
                    distTo[v] = distTo[n] + e.wt();
                }else if(distTo[v] == distTo[n] + e.wt()){
                    if(edgeCt[n]+1 < edgeCt[v]){
                        update(v, n);
                    }
                }
            }
        }
    }
    
    public void update(int u, int v){
        edgesTo[u] = v;
        edgeCt[u] = edgeCt[v] + 1;
    }
    
    public static void main(String[] args){
    }
}