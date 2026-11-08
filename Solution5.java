public class Solution5 {
    public static void quickSort3Way(int[] a) {
        int low = 0;
        int high = a.length - 1;

        quickSort(a, low, high);
    }

    static void quickSort(int[] a, int low, int high) {
        if(low >= high) return;

        int pivot = a[low];
        int lt = low;
        int i = low;
        int gt = high;

        while(i <= gt) {
            if(a[i] < pivot) swap(a, lt++, i++);

            else if(a[i] > pivot) swap(a, i, gt--);

            else i++;
        }

        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }

    static void swap(int[] a, int i, int j) {
        if(i == j) return;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}   
