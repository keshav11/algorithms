package DynamicProgramming;

public class Fibonacci {

    int getNthFib(int n) {
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            c = a+b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.getNthFib(1));
        System.out.println(fib.getNthFib(2));
        System.out.println(fib.getNthFib(3));
        System.out.println(fib.getNthFib(4));
        System.out.println(fib.getNthFib(5));
        System.out.println(fib.getNthFib(6));
        System.out.println(fib.getNthFib(7));
        System.out.println(fib.getNthFib(8));
    }

}
