
public class equals {

    public static long[] quickSortStats(int[] a) {
        long[] stats = new long[]{0, 0, 0};

        quickSort(a, 0, a.length - 1, stats);

        return stats;
    }

    static void swap(int[] a, int i, int j, long[] stats) {
        if(i == j) return;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        stats[1]++;
    }

    static int partition(int[] a, int low, int high, long[] stats) {
        int pivot = a[high];
        int i = low;

        stats[2]++;

        for(int j = low; j < high; j++) {
            stats[0]++;

            if(a[j] <= pivot) {
                swap(a, i, j, stats);
                i++;
            }
        }

        swap(a, i, high, stats);
        return i++;
    }

    static void quickSort(int[] a, int low, int high, long[] stats) {
        if(low >= high) return;

        int p = partition(a, low, high, stats);

        quickSort(a, low, p - 1, stats);
        quickSort(a, p + 1; high, stats);
    }
    
}
