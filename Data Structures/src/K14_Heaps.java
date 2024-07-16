public class K14_Heaps {
    private int[] Heap;
    private int size;
    private int maxSize;
    K14_Heaps(int maxSize) {
        this.Heap = new int[maxSize + 1];
        this.size = 0;
        this.maxSize = maxSize;
        this.Heap[0] = Integer.MAX_VALUE;
    }

    private int ebeveyn(int pos) {
        return pos / 2;
    }

    private int solCocuk(int pos) {
        return (pos * 2) + 1;
    }

    private int sagCocuk(int pos) {
        return (pos * 2) + 2;
    }

    private boolean yaprakMi(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    //Heap ağçındaki 2 tane elmanın(indisleri verilmiş) yerini değiştiren metod.
    private void takas(int ilkindis, int ikinciindis) {
        int gecici = Heap[ilkindis];
        Heap[ilkindis] = Heap[ikinciindis];
        Heap[ikinciindis] = gecici;
    }

    //Parametre olarak verilen indisten sonraki elemanlar arası en büyük elemanı bulan metod.(rekürsif)
    private void maksimumMu(int pos) {
        if (yaprakMi(pos))
            return;
        if (Heap[pos] < Heap[solCocuk(pos)] || Heap[pos] < Heap[sagCocuk(pos)]) {
            if (Heap[solCocuk(pos)] > Heap[sagCocuk(pos)]) {
                takas(pos, solCocuk(pos));
                maksimumMu(solCocuk(pos));
            } else {
                takas(pos, sagCocuk(pos));
                maksimumMu(solCocuk(pos));
            }
        }

    }

    //ağaca(dizi halinde) eleman ekleyen metod.
    public void ekle(int eleman) {
        Heap[++size] = eleman;
        int mevcut = size;
        while (Heap[mevcut] > Heap[ebeveyn(mevcut)]) {
            takas(mevcut, ebeveyn(mevcut));
            mevcut = ebeveyn(mevcut);
        }
    }

    //diziyi (heap ağcını) yazdıran metod.
    public void yazdir() {
        System.out.print("[");
        for (int i = 0; i <= size; i++) {
            System.out.print(Heap[i]+",");
        }
        System.out.print("]");

    }

    //Heap ağcının, max heap ağcı mı olduğunu kontrol eden metod.
    public static boolean maxHeapMi(int[] dizi) {
        boolean max = true;
        for (int i = 0; i < dizi.length/2; i++) {
            if ((dizi[i] > dizi[2 * i + 1]) && (dizi[i] > dizi[2*i+2])) continue;
            else return  false;
        }
        return max;
    }

    public int cikarMaks() {
        int cikarilan = Heap[1];
        Heap[1] = Heap[size--];
        maksimumMu(1);
        return cikarilan;
    }

    public static void main(String[] args) {
        //Test işlemleri.
        K14_Heaps maxheap = new K14_Heaps(15);
        int[] dizi = {84,22,19,17,10,5,6,3,9};
        maxheap.ekle(5);
        maxheap.ekle(3);
        maxheap.ekle(17);
        maxheap.ekle(10);
        maxheap.ekle(84);
        maxheap.ekle(19);
        maxheap.ekle(6);
        maxheap.ekle(22);
        maxheap.ekle(9);
        maxheap.yazdir();

        System.out.println(maxHeapMi(dizi));
    }
}
