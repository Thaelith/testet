public class Solution2 {
    public static int kthLargest(int[] a, int k) {
        if(k < 1 || k > a.length) return -1;

        int low = 0;
        int high = a.length - 1;
        int target = a.length - k;

        while(low <= high) {
            int p = partition(a, low, high);

            if(p == target) return a[p];

            else if(p > target) high = p - 1;

            else low = p + 1;
        }

        throw new IllegalStateException();
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
}
