public class Integer_Hex {

    public static String Int_to_Hex(int n) {
        if (n == 0)
            return " ";

        int rem = n % 16;
        char hex;

        if (rem < 10)
            hex = (char) ('0' + rem);
        else
            hex = (char) ('A' + (rem - 10));

        return Int_to_Hex(n / 16) + hex;
    }

    public static void main(String[] args) {
        int dec = 14; 

        if (dec == 0) 
            System.out.println("Hexadecimal: 0");
        else {
            String hex = Int_to_Hex(dec);
            System.out.println("Decimal: " + dec);
            System.out.println("Hexadecimal: " + hex);
        }
    }
}
