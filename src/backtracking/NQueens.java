package backtracking;

import java.util.Set;
import java.util.HashSet;

public class NQueens {

    public void nQueens(int n) {
        System.out.println("nqueens: " + n);
        backtrack(new int[n], 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private void printRows(int[] rows) {
        for(int r: rows) System.out.print(r + " ");
        System.out.println();
    }

    private void backtrack(int[] rows, int j, Set<Integer> set,
                           Set<Integer> diag1, Set<Integer> diag2) {
        if(j == rows.length) {
            printRows(rows);
            return;
        }

        for(int i = 0; i < rows.length; i++) {
            if(set.contains(i) || diag1.contains(i+j) || diag2.contains(i-j))
                continue;
            int temp = rows[j];
            rows[j] = i;
            set.add(i);
            diag1.add(i+j);
            diag2.add(i-j);

            backtrack(rows, j+1, set, diag1, diag2);
            set.remove(i);
            diag1.remove(i+j);
            diag2.remove(i-j);
            rows[j] = temp;

        }
    }

    public static void main(String[] args) {
        new NQueens().nQueens(1);
        new NQueens().nQueens(2);
        new NQueens().nQueens(3);
        new NQueens().nQueens(4);
        new NQueens().nQueens(5);
    }
}
