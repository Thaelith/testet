public class Solution3 {
    public static long sumKSmallest(int[] a, int k) {
        if(k < 0 || k > a.length) return -1;

        if(k == 0) return 0;

        int low = 0;
        int high = a.length - 1;
        int target = k - 1;
        long sum = 0;

        while(low <= high) {
            int p = partition(a, low, high);

            if(p == target) {
                for(int l = 0; l <= p; l++) {
                    sum += a[l];
                }
                return sum;
            }
            else if(p > target) high = p - 1;

            else low = p + 1;
        }

        throw new IllegalStateException();
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
