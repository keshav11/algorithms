package graph;

public class Test {
	public static void main(String[] args) {
		Graph g = new Graph(7, true);		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(2, 5);
		g.addEdge(2, 4);
		g.addEdge(4, 1);
		g.addEdge(0, 1);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		g.addEdge(2, 1);

		Traversal t = new Traversal(g);
//		t.doBFS(1);
//		t.refresh();
//		t.doDFS(1);
		t.refresh();
		MotherVertex mv = new MotherVertex(g);
		mv.motherVertexExists();
		
	}
}
