package graph;

import java.util.*;

public class MotherVertex {

    Graph g;
    boolean[]  processed;

    MotherVertex(Graph g) {
        this.g = g;
        processed = new boolean[g.numVertices];
    }

    Map<Integer, Set<Integer>> reachable = new HashMap<>();

    Set<Integer> getReachable(int u) {
        this.processed[u] = true;
        if(reachable.containsKey(u))
            return reachable.get(u);

        List<Integer> adjacent = g.adj.get(u);
        Set<Integer> set = new HashSet<>();

        for(int currNode: adjacent) {
            set.add(currNode);
            if(!this.processed[currNode]) {
                Set<Integer> currSet = getReachable(currNode);
                set.addAll(currSet);
            }
        }

        reachable.put(u, set);
        return  set;
    }

    public void motherVertexExists() {

        for(int i = 0; i < g.adj.size(); i++) {
            Set<Integer> set = getReachable(i);
            set.add(i);
            reachable.put(i, set);
            if(set.size() == g.adj.size()) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}
