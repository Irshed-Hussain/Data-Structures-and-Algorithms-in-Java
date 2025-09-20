public class Binary_Search_Recursive {
    public static int search_algo(int[] A, int key, int p, int r) {
        if (p > r)
            return -1;
        int mid = (p+r) / 2;
        if (A[mid] == key)
            return mid;
        else if (A[mid] < key)
            return search_algo(A, key, mid+1, r);
        else
            return search_algo(A, key, p, mid-1);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int key = 4, p = 0, r = A.length-1;
        int idx = search_algo(A, key, p, r);
        if (idx == -1)
            System.out.println("Element " + key + " not found in the array!");
        else
            System.out.println("Element " + key + " found at index: " + idx);
    }
}
