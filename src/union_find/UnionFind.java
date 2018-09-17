package union_find;

public class UnionFind {

    private int numVerts; // number if vertices
    private int[][] edges; // edges
    private int[] parentNode; // parentNode pointer of each vertex
    private int[] setSize; // size of the current tree

    UnionFind(int nv, int[][] edges) {
        this.edges = edges;
        this.numVerts = nv;
        this.parentNode = new int[nv];
        this.setSize = new int[nv];

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

        int uPar = find(u);
        int vPar = find(v);
        int uRank = setSize[uPar];
        int vRank = setSize[vPar];

        /**
         * assign the smaller set as the child
         * of the root of the larger set
         */
        if(uRank > vRank) {
            parentNode[vPar] = uPar;
        }
        else if(uRank < vRank) {
            parentNode[uPar] = vPar;
        }
        else {
            parentNode[uPar] = vPar;
            setSize[vPar]++;
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
