public class lab1 {
    static long countShifts(int[] a) {
    long shifts = 0;

    for (int i = 1; i < a.length; i++) {
        int key = a[i];
        int j = i - 1;

        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
            shifts++;
        
        }
        a[j + 1] = key;
    }

    return shifts;
}
}
