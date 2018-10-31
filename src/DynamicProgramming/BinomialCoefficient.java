package DynamicProgramming;

public class BinomialCoefficient {

    int getBinomial(int n, int k) {
        int[] coeff = new int[k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 0; j--) { /* because previous value is needed to calculate so going in reverse order */
                if(j == 0 || (i == j)) {
                    coeff[j] = 1;
                } else {
                    coeff[j] = coeff[j-1] + coeff[j];
                }
            }
        }

        return coeff[k];
    }

    public static void main(String[] args) {
        System.out.println(new BinomialCoefficient().getBinomial(10, 5));
        System.out.println(new BinomialCoefficient().getBinomial(5, 2));
    }

}
