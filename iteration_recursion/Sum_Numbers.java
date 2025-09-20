public class Sum_Numbers {
    public static int Sum_Iterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;  
        }
        return sum;
    }

    public static int Sum_Recursive(int n) {
        if (n == 0) {
            return 0;  
        }
        return n + Sum_Recursive(n - 1);  
    }

    public static void main(String[] args) {
        int n = 5; 
        System.out.println("Sum of first " + n + " numbers: " + Sum_Iterative(n));
        System.out.println("Sum of first " + n + " numbers: " + Sum_Recursive(n));
    }
}
