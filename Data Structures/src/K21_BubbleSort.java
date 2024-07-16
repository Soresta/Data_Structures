import java.util.Arrays;

public class K21_BubbleSort {
    //Bubble Sort (Kabarcık Sıralama) :
    public static void bubbleSort(int[] array) {
        System.out.println("Dizinin Sıralanmanda Önce Hali : " + Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println(i + 1 + ".İterasyom : " + Arrays.toString(array));
        }
        System.out.println("Dizinin Sıralanmış Hali : " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] dizi = {3, 8, 5, 4, 1, 9, -2};
        bubbleSort(dizi);
        System.out.println(Arrays.toString(dizi));
    }
}
