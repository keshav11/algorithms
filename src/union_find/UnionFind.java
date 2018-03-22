package union_find;

import java.util.Arrays;

public class UnionFind {

    int num_verts;
    int[][] edges;
    int[] parent;
    int[] rank;

    UnionFind(int num_verts, int[][] edges) {
        this.edges = edges;
        this.num_verts = num_verts;
        this.parent = new int[num_verts];
        this.rank = new int[num_verts];
        for (int i = 0; i < num_verts; i++) {
            parent[i] = i;
        }
    }

    public void union(int u, int v) {
        int uPar = find(u);
        int vPar = find(v);
        int uRank = rank[uPar];
        int vRank = rank[vPar];
        if(uRank > vRank) {
            parent[vPar] = uPar;
        }
        else if(uRank < vRank) {
            parent[uPar] = vPar;
        }
        else {
            parent[uPar] = vPar;
            rank[vPar]++;
        }

    }

    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        int r = find(parent[x]); // path compression
        parent[x] = r;
        return r;
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
        uf = new UnionFind(7,
                new int[][] {
                        {0, 1}, {1, 2}, {2, 3}, {3,4}, {4, 5}, {5, 2}
                });

        System.out.println(uf.isCyclePresent());
    }

}
