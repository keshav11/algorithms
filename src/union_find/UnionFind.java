package union_find;

import java.util.Arrays;

public class UnionFind {

    int num_verts;
    int[][] edges;
    int[] parent;

    UnionFind(int num_verts, int[][] edges) {
        this.edges = edges;
        this.num_verts = num_verts;
        this.parent = new int[num_verts];
        for (int i = 0; i < num_verts; i++) {
            parent[i] = i;
        }
    }

    public void union(int u, int v) {
        int uPar = find(u);
        int vPar = find(v);
        parent[uPar] = vPar;
    }

    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        return find(parent[x]);
    }
    
    public boolean isCyclePresent() {
        for (int[] edge :
                edges) {
            int par1 = find(edge[0]);
            int par2 = find(edge[1]);
            if (par1 == par2) {
                return true;
            }
            union(edge[0], edge[1]);
        }

        return false;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(4,
                new int[][] {
                {0, 1}, {1, 2}, {1, 3}
        });

        System.out.println(uf.isCyclePresent());
        uf = new UnionFind(4,
                new int[][] {
                        {0, 1}, {1, 2}, {1, 0}
                });

        System.out.println(uf.isCyclePresent());
    }

}
