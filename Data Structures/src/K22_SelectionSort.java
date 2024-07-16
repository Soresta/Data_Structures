import java.util.Arrays;

public class K22_SelectionSort {
    //Selection Sort (Seçmeli Sıralama) :
    public static void selectionSort(int[] array) {
        System.out.println("Dizinin Sıralanmadan Önceki Hali : " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            System.out.println(i + 1 + ".İterasyon : " + Arrays.toString(array));
        }
        System.out.println("Dizinin Sıralanmış Hali : " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] dizi = {3, 8, 5, 4, 1, 9, -2};
        selectionSort(dizi);
        System.out.println(Arrays.toString(dizi));
    }
}
