public class K03_DoubleLinkedList {
    //Çift yönlü bağlı liste.
    Node bas;
    Node son;
    private K03_DoubleLinkedList() {
        this.bas = null;
        this.son = null;
    }

    //sona eleman ekleyen metodu yazınız.
    private void ekle(Node eleman) {
        if (son == null) {
            bas = eleman;
            son = eleman;
        } else {
            son.ileri = eleman;
            son.ileri.geri = son;
            son = eleman;
        }
    }

    //basa eleman ekleyen metodu yazınız.
    private void basaEkle(Node eleman) {
        if (bas == null) {
            bas = eleman;
            son = eleman;
        } else {
            bas.geri = eleman;
            bas.geri.ileri = bas;
            bas = eleman;
        }
    }

    //parametre olarak 2 eleman veriliyor yeni ve mevcut, mevcut eleman listede bulunuyorsa önüne yeni elemanı ekleyen
    //metodu yazınız
    private void ortayaEkle(Node eleman, Node mevcut) {
        if (bas == null || eleman == null)
            System.out.println("Liste boştur veya girilen eleman geçersizdir");
        else {
            if (mevcut == son) {
                eleman.geri = son;
                son.ileri = eleman;
                son = son.ileri;
                return;
            }
            eleman.ileri = mevcut.ileri;
            eleman.geri = mevcut;
            mevcut.ileri.geri = eleman;
            mevcut.ileri = eleman;
        }
    }

    //paremetre olarak verilen bir indisin önüne yeni eleman ekeleyen metodu yazınız!
    private void ortayaEkle(Node eleman, int indis) {
        if (bas == null) System.out.println("Liste boştur, ortaya ekleme işlemi başarısız!");
        else {
            Node tmp = bas;
            int sayac = 0;
            while (sayac != indis && tmp != son) {
                sayac++;
                tmp = tmp.ileri;
            }
            if (tmp == son && sayac != indis) {
                System.out.println("Girilen indis listede bulunmuyor!");
            } else if (tmp == son && sayac == indis) {
                ekle(eleman);
            } else {
                eleman.ileri = tmp.ileri;
                eleman.ileri.geri = eleman;
                tmp.ileri = eleman;
                tmp.ileri.geri = tmp;
            }
        }
    }

    //sondan eleman silen metodu yazınız.
    private void sil() {
        if (son == null) System.out.println("Liste boştur, sondan silme işlemi başarısız!");
        else {
            //liste 1 elemandan oluşuyorsa onu siler(bas==son 1 eleman veya son.geri == null).
            if (son == bas) {
                bas = null;
                son = null;
                return;
            }
            son = son.geri;
            son.ileri.geri = null;
            son.ileri = null;
        }
    }

    //baştan eleman silen metodu yazınız!
    private void bastanSil() {
        if (bas == null) System.out.println("Liste boştur, baştan silme işlemi başarısız!");
        else {
            //liste 1 elemandan oluşuyorsa onu siler(bas==son 1 eleman veya son.geri == null).
            if (son == bas) {
                bas = null;
                son = null;
                return;
            }
            bas = bas.ileri;
            bas.geri.ileri = null;
            bas.geri = null;
        }
    }

    //parametre olarak verilen bir indisteki elemanı silen(ortadan silme) metodunu yazınız.
    private void ortadanSilme(int indis) {
        if (bas == null) System.out.println("Liste boştur, ortadan silme işlemi başarısız!");
        else {
            int sayac = 0;
            Node tmp = bas;
            while (sayac != indis && tmp != son) {
                sayac++;
                tmp = tmp.ileri;
            }
            if (tmp == son && sayac == indis) {
                sil();
            } else if (tmp == son && sayac != indis) {
                System.out.println("Girilen indis listede bulunmuyor");
            } else if (indis == 0) {
                bastanSil();
            } else {
                tmp.geri.ileri = tmp.ileri;
                tmp.ileri.geri = tmp.geri;
                tmp.geri = null;
                tmp.ileri = null;
            }
        }
    }

    //Parametre olarak verilen bir elemanı, çift bağlı listeden silen fonksiyonu yazınız!
    private void ortadanSil(Node eleman) {
        if (bas == null) System.out.println("Liste boş, Silme işlemi başarısız");
        else if (eleman == bas && bas == son) {
            bas = null;
            son = null;
        } else {
            Node tmp = bas;
            while (tmp != eleman && tmp != son) tmp = tmp.ileri;
            if (tmp == bas) {
                bas = bas.ileri;
                bas.geri.ileri = null;
                bas.geri = null;
            } else if (tmp == son && eleman == son) {
                son = son.geri;
                son.ileri.geri = null;
                son.ileri = null;
            } else if (tmp == son && eleman != son) System.out.println("Giirlen eleman listede bulunmuyor");
            else {
                tmp.geri.ileri = tmp.ileri;
                tmp.ileri.geri = tmp.geri;
                tmp.geri = null;
                tmp.ileri = null;
            }
        }
    }

    //parametre olarak verilen bir sayının listede elemanlarının verileri arasında bulunuyorsa elemanı geri döndüren
    //metodu yazınız!
    private Node elemanBul(int veri) {
        Node eleman = null;
        if (bas == null) return null;
        else {
            Node tmp = bas;
            while (tmp != null && tmp.veri != veri) tmp = tmp.ileri;
            if (tmp != null) eleman = tmp;
        }
        return eleman;
    }

    //soru8: verilen bir X elemanının önündeki elemanı silen fonksiyonu yazınız.  oncekiniSil(Cift eleman x)
    private void oncekiniSil(Node eleman) {
        if (bas == null) System.out.println("Liste boştur, Silme işlemi başarısız!");
        else {
            if (eleman == bas)
                System.out.println("Listenin başını verdiniz öncesinde bir elemena bulunmuyor, silme işlemi başarısız!");
            else {
                Node tmp = bas;
                Node onceki = null;
                while (tmp != eleman && tmp != null) {
                    onceki = tmp;
                    tmp = tmp.ileri;
                }
                if (tmp == null) System.out.println("Girilen eleman bulunmuyor");
                else if (onceki == bas) {
                    bas = bas.ileri;
                    bas.geri.ileri = null;
                    bas.geri = null;
                } else {
                    onceki.geri.ileri = tmp;
                    tmp.geri = onceki.geri;
                    onceki.geri = null;
                    onceki.ileri = null;
                }
            }
        }
    }

    //soru 10 : bir çift bağlı listenin  ortanca elemanını bulan fonksiyonu yazınız.
    private Node ortancaBul() {
        if (bas == null) return null;
        else {
            Node tmp = bas;
            int sayac = 0;
            int i = 0;
            while (tmp != null) {
                sayac++;
                tmp = tmp.ileri;
            }
            tmp = bas;
            while (i != sayac / 2) {
                i++;
                tmp = tmp.ileri;
            }
            return tmp;
        }
    }

    //listenin elemanlarını ekrana yazan metodu yazınız!
    private void listeYaz() {
        if (bas == null) System.out.println("Liste boştur!");
        else {
            Node tmp = bas;
            System.out.print("[");
            while (tmp != null) {
                System.out.print(tmp.veri + ", ");
                tmp = tmp.ileri;
            }
            System.out.print("]");
        }
    }

    //listeyi elemanlarını tersten yazan methodu yazınız!
    private void listeTersYaz() {
        if (son == null) System.out.println("Liste boştur!");
        else {
            Node tmp = son;
            System.out.print("[");
            while (tmp != null) {
                System.out.print(tmp.veri + ", ");
                tmp = tmp.geri;
            }
            System.out.print("]");
        }
    }

    private static class Node {
        int veri;
        Node ileri;
        Node geri;

        Node(int veri) {
            this.veri = veri;
            this.ileri = null;
            this.geri = null;
        }
    }

    public static void main(String[] args) {
        //Test işlemleri
        K03_DoubleLinkedList liste = new K03_DoubleLinkedList();
        Node sayi1 = new Node(1);
        Node sayi2 = new Node(2);
        Node sayi3 = new Node(3);
        Node sayi4 = new Node(4);
        Node sayi5 = new Node(5);

        liste.ekle(sayi1);
        liste.ekle(sayi2);
        liste.ekle(sayi3);
        liste.ekle(sayi4);
        liste.ekle(sayi5);


        liste.listeYaz();
        System.out.println();
        liste.listeTersYaz();
        System.out.println();



        liste.listeYaz();
        System.out.println();
        liste.listeTersYaz();

    }
}
