public class Edge{
	
	private final int v,w;
	private int pathLen;
	private double weight;
	
	public Edge(int v, int w, double wt){
		this.v = v;
		this.w = w;
		this.weight = wt;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int k){
		assert (k==w || k==v);
		return k==w? v: w;
	}
	
	public double wt(){
		return weight;
	}

	public void setPathLen(int newPathLen){
		pathLen = newPathLen;
	}
	
	public int pathLen(){
		return pathLen;
	}
	
	public static void main(String[] args){
	}
}