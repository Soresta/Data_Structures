import java.util.Arrays;

public class K23_InsertionSort {
    //Insertion Sort (Eklemeli Sıralama) :
    public static void insertionSort(int[] array) {
        System.out.println("Dizinin ilk Hali " + Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            System.out.println(i + ".iterasyon: " + Arrays.toString(array));
        }
        System.out.println("Dizinin Son Hali : " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] dizi = {3, 8, 5, 4, 1, 9, -2};
        insertionSort(dizi);
        System.out.println(Arrays.toString(dizi));
    }
}
