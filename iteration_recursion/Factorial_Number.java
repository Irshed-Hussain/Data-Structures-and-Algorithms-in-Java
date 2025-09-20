public class Factorial_Number {
    
    public static int Fact_Iterative(int n) {
        int fact = 1;
        for (int i=1; i<=n; i++)
            fact *= i;  
        return fact;
    }

    public static int Fact_Recursive(int n) {
        if (n == 0) 
            return 1; 
        return n * Fact_Recursive(n - 1); 
    }

    public static void main(String[] args) {
        int n = 4; 
        System.out.println("(Iterative) Factorial of " + n + " is: " + Fact_Iterative(n));
        System.out.println("(Recursive) Factorial of " + n + " is: " + Fact_Recursive(n));
    }
}
