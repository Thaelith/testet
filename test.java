public class test {
    public static long limitedQuickSort(int[] a, int maxDepth) {
        return quickSort(a, 0, a.length - 1, 0, maxDepth);
    }

    static long quickSort(int[] a, int low, int high,
                          int depth, int maxDepth) {
        if(low >= high || depth >= maxDepth) return 0;
        
        int p = partition(a, low, high);
        
        return 1 + quickSort(a, low, p - 1, depth + 1, maxDepth) + quickSort(a, p + 1, high, depth + 1, maxDepth);
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
