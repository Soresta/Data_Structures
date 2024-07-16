public class K19_LineerSearchAlgorithm {

    // Lineer Arama fonksiyonu
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Aranan eleman bulunduğunda indeksi döndür
            }
        }
        return -1; // Aranan eleman bulunamazsa -1 döndür
    }

    public static void main(String[] args) {
        int[] arr = { 12, 45, 78, 23, 56, 91, 34 };
        int aranan = 56;

        int sonuc = linearSearch(arr, aranan);

        if (sonuc == -1) {
            System.out.println("Eleman bulunamadı.");
        } else {
            System.out.println("Eleman " + aranan + ", indeks " + sonuc + " konumunda bulundu.");
        }
    }
}

