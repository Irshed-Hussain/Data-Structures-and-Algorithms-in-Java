public class Fibonacci_Numbers {

    public static int Fib_Iterative(int n) {
        if (n <= 1) 
            return n; 
        int prev1 = 0, prev2 = 1;
        for (int i=2; i<=n; i++) {
            int next = prev1 + prev2;
            prev1 = prev2;
            prev2 = next; 
        }
        return prev2; 
    }

    public static int Fib_Recursive(int n) {
        if (n <= 1) 
            return n; 
        return Fib_Recursive(n - 1) + Fib_Recursive(n - 2); 
    }

    public static void main(String[] args) {
        int n = 6; 
        System.out.println("(Iterative) Fibonacci number at position " + n + ": " + Fib_Iterative(n));
        System.out.println("(Recursive) Fibonacci number at position " + n + ": " + Fib_Recursive(n));
    }
}
