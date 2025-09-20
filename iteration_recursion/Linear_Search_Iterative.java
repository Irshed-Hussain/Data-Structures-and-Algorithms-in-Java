public class Linear_Search_Iterative {
    public static int search_algo(int[] A, int key, int idx) {
       for(int i=0; i<A.length-1; i++) {
            if(A[i] == key)
                return i;
       }
       return -1;
   }

   public static void main(String[] args) {
       int[] A = {6, 2, 4, 5, 1, 3};
       int key = 5;
       int idx = search_algo(A, key, 0);
       if (idx == -1)
           System.out.println("Element " + key + " not found in the array!");
       else
           System.out.println("Element " + key + " found at index: " + idx);
   }
}
