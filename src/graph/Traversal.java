package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

	Graph graph;
	boolean[] processed;

	public Traversal(Graph g) {
		this.graph = g;
		processed = new boolean[g.numVertices];
	}
	
	public void refresh() {
		processed = new boolean[graph.numVertices];
	}
	
	void processNode(int curr) {
		System.out.print(curr + " ");
	}
	
	void doBFS(int u) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(u);
		processed[u] = true;
		while (!queue.isEmpty()) {
			Integer curr = queue.poll();
			processNode(curr);
			List<Integer> adjacent = graph.adj.get(curr);
			for (int i = 0; i < adjacent.size(); i++) {
				int toAdd = adjacent.get(i);
				if (!processed[toAdd])
					queue.offer(toAdd);
					processed[toAdd] = true;
			}
		}
		System.out.println();
	}
	
	void doDFS(int u) {
		processed[u] = true;
		processNode(u);
		List<Integer> adjacent = graph.adj.get(u);		
		for(int curr: adjacent) {
			if(!processed[curr]) {
				doDFS(curr);
			}
		}	
	}
}
