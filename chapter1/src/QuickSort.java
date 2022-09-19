public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100 - i;
        }
        int sum = sum(arr, arr.length);
        System.out.println(sum);
        int len = countEleNum(arr, 0);
        System.out.println(len);
        int max = findMax(arr, 0, arr[0]);
        System.out.println(max);
        int targetIndex = searchBinary(arr, 560, 0, arr.length - 1);
        System.out.println(targetIndex);
        int[] res = quickSort(arr, 0, arr.length - 1);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    static int sum(int[] arr, int len) {
        if (len == 1) {
            return arr[0];
        }
        return arr[len - 1] + sum(arr, len - 1);
    }

    static int countEleNum(int[] arr, int start) {
        try {
            int i = arr[start];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return 1 + countEleNum(arr, start + 1);
    }

    static int findMax(int[] arr, int index, int max) {
        if (index == arr.length - 1) {
            return arr[index] > max ? arr[index] : max;
        }
        return findMax(arr, index + 1, max);
    }

    static int searchBinary(int[] arr, int target, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        } else if (arr[mid] == target) {
            return mid;
        }

        return arr[mid] > target ? searchBinary(arr, target, low, mid - 1) : searchBinary(arr, target, mid + 1, high);
    }

    static int [] quickSort(int [] arr, int low, int high){
        if (low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high){
            while (low < high && arr[high] >= pivot){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
