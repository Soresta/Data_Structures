public class K20_BinarySearchAlgorithm {
    // Ikili Arama metodu.
    public static int ikiliArama(int[] dizi, int anahtar) {
        int sol = 0;
        int sag = dizi.length - 1;

        while (sol <= sag) {
            int orta = sol + (sag - sol) / 2;
            // Eğer anahtar orta noktadaysa, indeksi döndür
            if (dizi[orta] == anahtar) return orta;
            // Eğer anahtar orta noktadan küçükse, sol yarıyı ara
            if (dizi[orta] < anahtar) sol = orta + 1;
            // Eğer anahtar orta noktadan büyükse, sağ yarıyı ara
            else sag = orta - 1;
        }
        // Eğer anahtar dizide bulunamazsa -1 döndür
        return -1;
    }


    // Rekürsif Ikili Arama fonksiyonu
    public static int ikiliArama(int[] dizi, int aranan, int sol, int sag) {
        if (sol <= sag) {
            int orta = sol + (sag - sol) / 2;

            // Eğer aranan orta noktadaysa, indeksi döndür
            if (dizi[orta] == aranan) return orta;

            // Eğer aranan orta noktadan küçükse, sol yarıyı ara
            if (dizi[orta] < aranan) return ikiliArama(dizi, aranan, orta + 1, sag);

            // Eğer aranan orta noktadan büyükse, sağ yarıyı ara
            else return ikiliArama(dizi, aranan, sol, orta - 1);
        }
        // Eğer aranan dizide bulunamazsa -1 döndür
        return -1;
    }

    public static void main(String[] args) {
        //Test işlemleri:
        int[] dizi = {12, 23, 34, 45, 56, 78, 91};
        int arananEleman = 56;

        int sonuc = ikiliArama(dizi, arananEleman);

        if (sonuc == -1) {
            System.out.println("Eleman bulunamadı.");
        } else {
            System.out.println("Eleman " + arananEleman + ", indeks " + sonuc + " konumunda bulundu.");
        }
    }
}
