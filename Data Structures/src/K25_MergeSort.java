import java.util.Arrays;

public class K25_MergeSort {
    //Merge Sort (Birleştirme Sıralaması)
    public static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return; // durma koşulu
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        for (int i = 0; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[i - middle] = array[i];
            }
        }
        //diziyi bölme işlemleri
        mergeSort(leftArray);
        mergeSort(rightArray);

        //diziyi birleştirme(sıralayarak)
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i++] = leftArray[l++];
            } else {
                array[i++] = rightArray[r++];
            }
        }

        while (l < leftSize) {
            array[i++] = leftArray[l++];
        }

        while (r < rightSize) {
            array[i++] = rightArray[r++];
        }
    }

    public static void main(String[] args) {
        int[] dizi = {3, 8, 5, 4, 1, 9, -2};
        mergeSort(dizi);
        System.out.println(Arrays.toString(dizi));

    }
}
