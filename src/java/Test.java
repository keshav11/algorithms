package graph;

public class Test {
	public static void main(String[] args) {
		Graph g = new Graph(7, true);		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(5, 0);
		
		g.addEdge(6, 5);	
		Traversal t = new Traversal(g);
		t.doBFS(1);
		t.refresh();
		t.doDFS(1);	
		
	}
}
