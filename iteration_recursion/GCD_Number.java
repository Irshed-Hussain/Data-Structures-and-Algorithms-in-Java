public class GCD_Number {
    
    public static int Gcd_Iterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int Gcd_Recursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Gcd_Recursive(b, a % b);
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        System.out.println("(Iterative) GCD of " + a + " and " + b + " is: " + Gcd_Iterative(a, b));
        System.out.println("(Recursive) GCD of " + a + " and " + b + " is: " + Gcd_Recursive(a, b));
    }
}
