public class K15_Graph {
    int[][] komsulukMatrisi;
    int elemanSayisi;

    public K15_Graph(int elemanSayisi) {
        this.elemanSayisi = elemanSayisi;
        komsulukMatrisi = new int[elemanSayisi + 1][elemanSayisi + 1];
        for (int i = 0; i < elemanSayisi + 1; i++) {
            for (int j = 0; j < elemanSayisi + 1; j++) {
                if (i == 0) {
                    this.komsulukMatrisi[i][j] = j;
                } else if (j == 0) {
                    this.komsulukMatrisi[i][j] = i;
                } else komsulukMatrisi[i][j] = 0;
            }
        }
    }

    //Grafın komuşuluk matrisi ekrana yazdıran metod.
    public void komsulukMatrisiEkranaYaz(K15_Graph graf) {
        for (int i = 0; i < graf.elemanSayisi + 1; i++) {
            System.out.print("[");
            for (int j = 0; j < graf.elemanSayisi + 1; j++) {
                System.out.print(graf.komsulukMatrisi[i][j] + ",");
            }
            System.out.println("]");
        }
    }

    //Yönlü veya yönsüz ve Ağırlıksız veya ağırlıksız bir kenar ekleniyorsa
    public void kenarEkle(int baslangicDugumu, int bitisDugumu, boolean yon) {
        if (!yon) {
            komsulukMatrisi[baslangicDugumu][bitisDugumu] = 1;
            komsulukMatrisi[bitisDugumu][baslangicDugumu] = 1;
        } else komsulukMatrisi[baslangicDugumu][bitisDugumu] = 1;

    }

    //Yönlü veya yönsüz ve Ağırlıklı bir kenar ekleme metodu
    public void kenarEkle(int baslangicDugumu, int bitisDugumu, int agirlik, boolean yon) {
        if (!yon) {
            komsulukMatrisi[baslangicDugumu][bitisDugumu] = agirlik;
            komsulukMatrisi[bitisDugumu][baslangicDugumu] = agirlik;
        } else komsulukMatrisi[baslangicDugumu][bitisDugumu] = agirlik;
    }

    public static void main(String[] args) {
        //Test etme işlemleri
        K15_Graph graf = new K15_Graph(5);
        int[][] dizi = {{1, 2, 3, 4, 5},
                        {1, 2 ,3, 4, 5},
                        {1, 2, 3, 4, 5},
                        {1, 2, 3, 4, 5}};
        //0 dugumu kullanılmaz 1 ile 5 araso 5 eleman vardır
        graf.kenarEkle(1, 4, true);
        graf.kenarEkle(1, 5, true);
        graf.kenarEkle(1, 3, true);
        graf.kenarEkle(2, 4, true);
        graf.kenarEkle(2, 3, true);
        graf.kenarEkle(3, 4, true);
        graf.kenarEkle(4, 5, true);
        graf.komsulukMatrisiEkranaYaz(graf);
    }
}
