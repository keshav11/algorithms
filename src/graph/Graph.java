package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	int numVertices;
	boolean isDirected;
	List<List<Integer>> adj;
	
	Graph(int n, boolean isDir) {
		this.numVertices = n;
		adj = new ArrayList<List<Integer>>();		
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}		
		this.isDirected = isDir;		
	}
	
	/**
	 * Add edge for u to v
	 * @param u
	 * @param v
	 */
	void addEdge(int u, int v) {
		adj.get(u).add(v);
		if(!isDirected) {
			adj.get(v).add(u);
		}
	}
}
