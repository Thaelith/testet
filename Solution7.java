public class Solution7 {
    
public static long countDistinctTriplets(int[] a, int target) {
    quickSort(a, 0, a.length - 1);

    long count = 0;

    for(int i = 0; i < a.length - 2; i++) {
        if(i > 0 && a[i] == a[i - 1]) continue;

        int left = i + 1;
        int right = a.length - 1;

        while(left < right) {
            long sum = (long) a[i] + a[left] + a[right];

            if(sum == target) {
                count++;
                left++;
                right--;

                while(left < right && a[left] == a[left - 1]) left++;

                while(left < right && a[right] == a[right + 1]) right--;
            }

            else if(sum > target) right--;

            else left++;
        }
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
