public class Tower_Hanoi {
  
    public static void TOH(int n, char src, char aux, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + src + " to " + dest);
            return;
        }
        TOH(n-1, src, dest, aux);
        System.out.println("Move disk " + n + " from peg " + src + " to " + dest);
        TOH(n-1, aux, src, dest);
    }
    
	  public static void main(String[] args) {
		    int n = 3; 
		    System.out.println("---------------------------");
		    System.out.println("Tower of Hanoi for " + n + " disks!");
		    System.out.println("---------------------------");
        TOH(n, 'A', 'B', 'C'); 
	  }
}
