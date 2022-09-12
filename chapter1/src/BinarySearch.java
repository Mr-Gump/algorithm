public class BinarySearch {

    int [ ] a;

    public static void main(String[] args) {
        int []a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
        }
        BinarySearch binarySearch = new BinarySearch(a);
        int res = binarySearch.search(104);
        System.out.println("res = " + res);
    }

    public BinarySearch(int[] a) {
        this.a = a;
    }

    public int search(int t){
        int low = 0;
        int high = a.length - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (a[mid] > t){
                high = mid - 1 ;
            }else if(a[mid] < t) {
                low = mid + 1;
            }else {
                return mid;
            }
            mid = (high + low) / 2;
        }
        return -1;
    }
}
