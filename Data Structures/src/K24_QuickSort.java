import java.util.Arrays;

public class K24_QuickSort {

    //Çok önemli not: Ne yalan söyleyim arkadaşlar en sevdiğim algoritma budur.Buda böyle gereksiz bir bilgiydi amaç zamanınızı çalmaktı :D.
    //Quick Sort (Hızlı Sıralama) :
    public static void quickSortGostermek(int[] array, int low, int high) {
        System.out.println("Dizi'nin sıralanmadan önceki hali : " + Arrays.toString(array));
        quickSort(array, low, high);
        System.out.println("Dizi'nin sıralı hali : " + Arrays.toString(array));
    }

    //rekürsif olarak kendini tekrarlayan quick sortun ana yapısı
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            //her rekürsif çağırmada pivotun indisini bulmak için özel method oluşturulmuştur aşşağıda
            int pivotIndex = siralamaIslemi(array, low, high);
            //pivotun diziyi 2ye bölünce : sol ve sağ bölümlerini reküsrif olarak tekrar
            //quick sort işlemine dahil ediyoruz
            quickSort(array, 0, pivotIndex - 1);//sol kısım : 0dan başlar pivotun indexi -1 e kadar
            quickSort(array, pivotIndex + 1, high);//sol kısım : pivotun bir sonraki indisinden  başlar dizinin sonuna kadar.
        }
    }

    //sıralama ve pivotun indisi döndüren metot
    public static int siralamaIslemi(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[high];
        array[high] = array[i + 1];
        array[i + 1] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] dizi = {3, 8, 5, 4, 1, 9, -2};
        quickSort(dizi,0, dizi.length-1);
        System.out.println(Arrays.toString(dizi));
    }
}
