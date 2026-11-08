
import java.util.*;

public class Solution {
    static void swap(int[] a, int i, int j) {
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

            swap(a, i, high);
            return i;
        }
    }

    static void quickSort(int[] a, int low, int high) {
        if(low >= high) return 0;

        int p = partition(a, low, high);

        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

    static long countComparisons(int[] a, int low, int high) {
        if(low >= high) return 0;

        int p = partition(a, low, high);

        long current = high - low;

        return current + countComparisons(a, low, p - 1) + countComparisons(a, p + 1, high);    
    }

    static int kthSmallest(int[] a, int k) {
        if(k < 1 || k > a.length) throw new IllegalArgumentException();

        int low = 0;
        int high = a.length - 1;
        int target = k - 1;

        while(low <= high) {
            int p = partition(a, low, high);

            if(p == target) return a[p];

            else if (p > target) high = p - 1;

            else low = p + 1;
        }

        throw new IllegalStateException();
    }

    static void quickSort3Way(int[] a, int low, int high) {
        if(low >= high) return;

        int pivot = a[low];
        int lt = low, int i = low, int gt = high;

        while(i <= gt) {
            if(a[i] < pivot) {
                swap(a, lt++, i++);
            } else if(a[i] > pivot) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        
        quickSort3Way(a, low, lt - 1);
        quickSort3Way(a, gt + 1, high);
    }
}
  