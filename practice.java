
import java.util.*;

public class Solution {

    // Only this method is timed in the race. The array is ready, do not read input here.
    static long countInversions(int[] a) {
        long inversions = 0;

        int[] temp = new int[a.length];
        inversions = mergeSort(a, temp, 0, a.length);

        return inversions;
    }

    static long mergeSort(int[] a, int[] temp, int left, int right) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = (left + right) / 2;

        long count = 0;

        count += mergeSort(a, temp, left, mid);
        count += mergeSort(a, temp, mid, right);

        int i = left;
        int j = mid;
        int k = left;

        while (i < mid && j < right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += mid - i;
            }
        }

        while (i < mid) {
            temp[k++] = a[i++];
        }

        while (j < right) {
            temp[k++] = a[j++];
        }

        for (int x = left; x < right; x++) {
            a[x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {
        // Used by the tests and your own runs. Not part of the timing.
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        System.out.println(countInversions(a));
    }
}
