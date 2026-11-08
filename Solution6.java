public class Solution6 {
    public static long countPairsAtMost(int[] a, int K) {
        int low = 0;
        int high = a.length - 1;
        quickSort(a, low, high);

        int left = 0;
        int right = a.length - 1;
        long count = 0;

        while(left < right) {
            if((long) a[left] + a[right] <= K) {
                count += (long)(right - left);
                left++;
            } else right --;
        }

        return count;
    }

    static void quickSort(int[] a, int low, int high) {
        if(low >= high) return;

        int p = partition(a, low, high);

        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;

        for(int j = low; j < high; j++) {
            if(a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, high);
        return i;
    }

    static void swap(int[] a, int i, int j) {
        if(i == j) return;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
