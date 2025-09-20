public class Binary_Search {
    public static int Search_Iterative(int[] A, int key, int p, int r) {
        while (p <= r) {
            int mid = (p+r) / 2; 
            if (A[mid] == key)
                return mid; 
            if (A[mid] < key)
                p = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static int Search_Recursive(int[] A, int key, int p, int r) {
        if (p > r)
            return -1;
        int mid = (p+r) / 2;
        if (A[mid] == key)
            return mid;
        else if (A[mid] < key)
            return Search_Recursive(A, key, mid+1, r);
        else
            return Search_Recursive(A, key, p, mid-1);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int key = 4, p = 0, r = A.length-1;
        
        int id = Search_Iterative(A, key, p, r);
        if (id == -1)
            System.out.println("(Iterative) Element " + key + " not found in the array!");
        else
            System.out.println("(Iterative) Element " + key + " found at index: " + id);
        
        int idx = Search_Recursive(A, key, p, r);
        if (idx == -1)
            System.out.println("(Recursive) Element " + key + " not found in the array!");
        else
            System.out.println("(Recursive) Element " + key + " found at index: " + idx);
    }
}
