public class Solution4 {
    public static long[] quickSortDepth(int[] a) {
        long[] stats = new long[]{0, 0};
        int depth = 1; 
        int low = 0;
        int high = a.length - 1;

        quickSort(a, low, high, depth, stats);

        return stats;
    }

    static void swap(int[] a, int i, int j) {
        if(i == j) return;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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

    static void quickSort(int[] a, int low, int high, int depth, long[] stats) {
        stats[1] = Math.max(stats[1], depth);
        if(low >= high) return;

        stats[0]++;

        int p = partition(a, low, high);

        quickSort(a, low, p - 1, depth + 1, stats);
        quickSort(a, p + 1, high, depth + 1, stats);
    }
}
