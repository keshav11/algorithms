package UnionFind;

public class UnionFind {

    private int numVerts; // number if vertices
    private int[][] edges; // edges
    private int[] parentNode; // parentNode pointer of each vertex
    private int[] rank; // size of the current tree

    UnionFind(int nv, int[][] edges) {
        this.edges = edges;
        this.numVerts = nv;
        this.parentNode = new int[nv];
        this.rank = new int[nv];

        /*
         * initializing the parentNode pointers as self
         */
        for (int i = 0; i < nv; i++) {
            parentNode[i] = i;
        }
    }

    /**
     * union the sets containing u and v
     * @param u
     * @param v
     */
    public void union(int u, int v) {
        int par1 = find(u);
        int par2 = find(v);
        int uRank = rank[par1];
        int vRank = rank[par2];
        if(par1 == par2)
            return;

        /**
         * assign the smaller set as the child
         * of the root of the larger set
         */
        if(rank[par1] > rank[par2]) {
            parentNode[par2] = par1;
        }
        else if(rank[par1] < rank[par2]) {
            parentNode[par1] = par2;
        }
        else {
            parentNode[par1] = par2;
            rank[par2]++;
        }
    }

    private int find(int currentNode) {
        /**
         * if the parent is the same as the currentNode,
         * currentNode is a rootNode
         */
        if(parentNode[currentNode] == currentNode) {
            return currentNode;
        }

        /**
         *
         * recursively look for the root node
         * and for each of the child nodes assign
         *  parent node as the rootNode
         */
        int rootNode = find(parentNode[currentNode]);
        parentNode[currentNode] = rootNode;

        return rootNode;
    }

    /**
     * APPLICATIONS OF UNION FIND
     */

    /**
     * detect cycle for an undirected graph
     * @return
     */
    private boolean isCyclePresent() {
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
                {0, 1}, {1, 2}, {1, 3}, {3, 0}
        });

        System.out.println(uf.isCyclePresent());

        uf = new UnionFind(7,
                new int[][] {
                        {0, 1}, {1, 2},
                        {2, 3}, {3,4},
                        {4, 5}, {5, 2}
                });

        System.out.println(uf.isCyclePresent());
    }

}
