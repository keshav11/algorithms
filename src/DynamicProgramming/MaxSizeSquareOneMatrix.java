package DynamicProgramming;

import Helper.MathHelper;

public class MaxSizeSquareOneMatrix {
    int maxSizeSquareOneMatrix(int[][] mat) {
        int maxSize = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] sq = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    sq[i][j] = mat[i][j];
                }
                else {
                    if(mat[i][j] == 1) {
                        sq[i][j] = MathHelper.min(sq[i-1][j],
                                                  sq[i][j-1],
                                                  sq[i-1][j-1]) + 1;
                        maxSize = Math.max(maxSize, sq[i][j]);
                    }
                    else {
                        sq[i][j] = 0;
                    }
                }
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
            {1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1}
        };

        System.out.println(new MaxSizeSquareOneMatrix().maxSizeSquareOneMatrix(mat));
    }
}
