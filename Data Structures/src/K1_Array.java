class K1_Array {
    int boyut;
    String[] elemanlar;
    int indis;

    public K1_Array(int boyut) {
        this.elemanlar = new String[boyut];
        this.indis = 0;
        this.boyut = boyut;
    }

    //Araya ekleme metodu
    public void arayaEkle(int newElementIndex, String newElement) {
        if (this.indis == this.boyut)
            System.out.println("Dizi doludur, '" + newElement + "' elemanını diziye ekleme işlemi başarısız!");
        else {
            for (int i = this.indis; i > newElementIndex; i--)
                elemanlar[i] = elemanlar[i - 1];
            this.indis++;
            elemanlar[newElementIndex] = newElement;
        }
    }

    //Sona ekleme metodu.
    public void ekle(String eleman) {
        if (this.indis < boyut) {
            this.elemanlar[indis] = eleman;
            this.indis++;
        } else System.out.println("Dizi doludur ekleme yapılamaz!");
    }

    //İstenilen stringi arama metodu.(indis çevir)
    public int ara(String arananEleman) {
        for (int i = 0; i < this.indis; i++) {
            if (elemanlar[i].equals(arananEleman)) return i;
        }
        return -1;
    }

    //Değiştirme işlemi.
    public void guncelle(String silincek, String eklencek) {
        int silincek_i = ara(silincek);
        if (silincek_i != -1)
            elemanlar[silincek_i] = eklencek;
        else System.out.println("Dizide öyle bir eleman yok");
    }

    //Diziyi yazdirma.
    public void diziYazdir() {
        if (this.indis <= 0) System.out.println("dizi boştur");
        else {
            System.out.print("[");
            for (int i = 0; i < this.boyut; i++) {
                if (i == this.boyut - 1) System.out.print(elemanlar[i] + "]");
                else System.out.print(elemanlar[i] + ", ");
            }
        }
    }
    //Test işlemleri
    public static void main(String[] args) {
        K1_Array dizim = new K1_Array(6);
        dizim.ekle("Sorest");
        dizim.ekle("Furkan");
        dizim.ekle("Ahmet");
        dizim.arayaEkle(2, "Yavuz");
        dizim.arayaEkle(2, "Sefokrat");
        dizim.arayaEkle(2, "Luna");
        dizim.diziYazdir();
    }
}
