import java.util.Scanner;

public class K2_LinkedList {
    Node bas;

    K2_LinkedList() {
        bas = null;
    }

    //Ekleme metodu(Sondan ekleme).
    public void ekle(Node newEleman) {
        if (bas == null) bas = newEleman;
        else {
            Node tmp = bas;
            while (tmp.ileri != null) tmp = tmp.ileri;
            tmp.ileri = newEleman;
        }
    }

    //Listeyi siralama metodu(küçükten büyüğe).
    private void sirala() {
        Node tmp1 = bas;
        Node tmp2;
        while (tmp1 != null) {
            tmp2 = tmp1.ileri;
            while (tmp2 != null) {
                if (tmp1.sayi > tmp2.sayi) {
                    int intTmp = tmp1.sayi;
                    tmp1.sayi = tmp2.sayi;
                    tmp2.sayi = intTmp;
                }
                tmp2 = tmp2.ileri;
            }
            tmp1 = tmp1.ileri;
        }
    }

    //Baştan eleman silme metodu.
    private static void bastanSil(K2_LinkedList liste) {
        if (liste.bas == null) {
            System.out.println("Liste boştur!");
            return;
        }
        Node tmp = liste.bas;
        liste.bas = liste.bas.ileri;
        tmp.ileri = null;
    }

    //Sondan eleman silme metodu.
    public void sil() {
        if (bas == null) System.out.println("Liste boş, Silme işlemi başarısız!");
        else {
            Node tmp = bas;
            if (tmp.ileri == null) bas = null;
            while (tmp.ileri.ileri != null) tmp = tmp.ileri;
            tmp.ileri = null;
        }
    }

    //Sondan bir önckinin önüne eleman ekleyen metod.
    public void sondanOnceEkle1(Node yeniEleman) {
        if (bas == null || yeniEleman == null) System.out.println("Geçersiz eleman veya liste bos");
        else {
            Node tmp = bas;
            while (tmp.ileri.ileri != null) tmp = tmp.ileri;
            yeniEleman.ileri = tmp.ileri;
            tmp.ileri = yeniEleman;
        }
    }

    //Listede bulunan bir elmanın içeriği parametre olarak veriliyor bu elemanı geri döndüren metodu yazınız.
    public Node elemanBul(int veri) {
        Node bulunanEleman = null;
        Node tmp = bas;
        while (tmp.ileri != null) {
            if (tmp.sayi == veri) {
                bulunanEleman = tmp;
                return bulunanEleman;
            }
            tmp = tmp.ileri;
        }
        return bulunanEleman;
    }

    //Ortaya eleman ekleme metodu.
    public void ortayaEkle(Node yeniEleman, Node mevcut) {
        if (bas == null || yeniEleman == null) System.out.println("Liste boş, Silme işlemi başarısız!");
        else {
            yeniEleman.ileri = mevcut.ileri;
            mevcut.ileri = yeniEleman;
        }
    }

    //Basa eleman ekleme metodu.
    public void basaEkle(Node yeniEleman) {
        if (bas == null || yeniEleman == null) bas = yeniEleman;
        else {
            yeniEleman.ileri = bas;
            bas = yeniEleman;
        }
    }

    //Listedeki elemanları yazdır.
    public static void listeYaz(K2_LinkedList list) {
        if (list.bas == null) System.out.println("Liste boş!");
        else {
            Node tmp = list.bas;
            System.out.print("[");
            while (tmp != null) {
                System.out.print(tmp.sayi + ", ");
                tmp = tmp.ileri;
            }
            System.out.println("]");
        }
    }

    //soru1 : tam sayılar içeren bir bağlı listedeki en küçük sayıyı bulan fonksiyonyazınız.
    //int enKucukBul()
    public int enKucukBul() {
        if (bas != null) {
            Node tmp = bas;
            Node enKucuk = bas;
            while (tmp != null) {
                if (tmp.sayi < enKucuk.sayi) {
                    enKucuk = tmp;
                }
                tmp = tmp.ileri;
            }
            return enKucuk.sayi;
        } else return Integer.MIN_VALUE;
    }

    //soru2 : verilen bir bağlı listenin ikinci elemanını silen fonksiyonu yazınız!.
    public void ikinciSil() {
        if (bas == null) System.out.println("Liste boştur, Silme işlemi başarısız!");
        else {
            Node tmp = bas;
            if (bas.ileri == null) System.out.println("Liste bir elemandan oluşuyor silme işlemi başarısız!");
            else {
                Node ikinci = bas.ileri;
                tmp.ileri = tmp.ileri.ileri;
                ikinci.ileri = null;
            }
        }
    }

    //soru3 : verilen bir bağlı listenin tek sıra numaralı elemanlarını ayrı bir bağlı listede.
    //döndüren fonksiyonu yazınız!
    public K2_LinkedList tekNumaraliAyriListe(K2_LinkedList list) {
        if (bas == null) {
            System.out.println("Verilen liste boştur, çıktı bulunmaz");
            return null;
        }
        int sayac = 0;
        Node tmp = bas;
        K2_LinkedList tekListe = new K2_LinkedList();
        while (tmp != null) {
            if (sayac % 2 == 0) {
                Node yeniEleman = new Node(tmp.sayi);
                tekListe.ekle(yeniEleman);
            }
            sayac++;
            tmp = tmp.ileri;
        }
        listeYaz(list);
        return tekListe;
    }

    //soru4 : verilen bir bağlı listenin çift sıra numaralı elemanlarını silen fonksiyonu yazınız!.
    public void ciftSiraNumaraliSil(K2_LinkedList list) {
        if (bas == null || bas.ileri == null) {
            System.out.println("Listede yeterli eleman yok.");
            return;
        }
        Node onceki = null;
        Node simdiki = bas;
        int sayac = 0;
        while (simdiki != null) {
            if (sayac % 2 == 0) {
                if (onceki == null) {
                    bas = simdiki.ileri;
                } else {
                    onceki.ileri = simdiki.ileri;
                }
            } else {
                onceki = simdiki;
            }
            simdiki = simdiki.ileri;
            sayac++;
        }
        listeYaz(list);
    }


    //soru5 : verilen bir bağlı listenin son elemanın önüne yeni bir eleman ekleyen fonksiyonu yazınız!.
    public void sondanOnceEkle(Node newEleman) {
        if (bas == null || newEleman == null) System.out.println("Liste boştur, ekleme işlemi başarısız!");
        else {
            Node once = null;
            Node tmp = bas;
            if (tmp.ileri == null) {
                newEleman.ileri = bas;
                bas = newEleman;
            } else {
                while (tmp.ileri != null) {
                    once = tmp;
                    tmp = tmp.ileri;
                }
                newEleman.ileri = tmp;
                once.ileri = newEleman;
            }
        }
    }

    //soru6 : Verilen sıralanmış bir bağlı listenin içine yeni bir sayıyı
    //sırayı bozmadan ekleyen donksiyonu yazınız!.
    private void ekleSirali(Node eleman) {
        if (bas == null && eleman == null) {
            System.out.println("Liste boş veya girilen eleman geçersiz");
            return;
        }
        if (eleman.sayi < bas.sayi) {
            eleman.ileri = bas;
            bas = eleman;
            return;
        }
        Node tmp = bas;
        while (tmp.ileri != null && tmp.ileri.sayi < eleman.sayi) tmp = tmp.ileri;
        eleman.ileri = tmp.ileri;
        tmp.ileri = eleman;
    }

    //Soru 6 ama parametrede veri verilmiş.
    public void siraliEkle(int yeniSayi) {
        if (bas == null) {
            bas = new Node(yeniSayi);
        } else {
            Node tmp = bas;
            while (tmp.ileri != null) tmp = tmp.ileri;
            Node son = tmp;
            tmp = bas;

            while (tmp.ileri != null) {
                Node eleman = new Node(yeniSayi);
                if (yeniSayi < bas.sayi) {
                    eleman.ileri = bas;
                    bas = eleman;
                    return;
                } else if (tmp.ileri.sayi > yeniSayi) {
                    eleman.ileri = tmp.ileri;
                    tmp.ileri = eleman;
                    return;
                } else if (yeniSayi > son.sayi) {
                    son.ileri = eleman;
                    return;
                }
                tmp = tmp.ileri;
            }
        }
    }

    //soru7 : verilen bir bağlı listedeki i'ninci elemanı silen bir fonksiyon yazınız. indisSil(int i).
    public void indisSil(int indis) {
        if (bas == null) System.out.println("Liste boş, Silme işlemi başarısız!");
        else {
            Node tmp = bas;
            int sayac = 0;
            while (tmp != null) {
                if (indis == 0) {
                    Node basTut = bas;
                    bas = bas.ileri;
                    basTut.ileri = null;
                    return;
                } else if (tmp.ileri == null && sayac == indis - 1) {
                    Node tmp2 = bas;
                    while (tmp2 != tmp) tmp2 = tmp2.ileri;
                    tmp2.ileri = null;
                    return;
                } else {
                    if (sayac == indis - 1) {
                        Node sonraki = tmp.ileri;
                        tmp.ileri = tmp.ileri.ileri;
                        sonraki.ileri = null;
                        return;
                    }
                    sayac++;
                    tmp = tmp.ileri;
                }
            }
        }
    }

    //soru9 : bir bağlı listedeki verilen bir elemanı n eleman ileriye taşıyan fonksiyonu yazınız. tasi(Eleman eleman,int n).
    public void elemanTasi(Node eleman, int sayac) {
        if (bas == null) System.out.println("Liste boştur, kaydırma işlemi yapılamaz!");
        else {
            Node onceki = null;
            Node tmp = bas;
            while (tmp.ileri != null && tmp != eleman) {
                onceki = tmp;
                tmp = tmp.ileri;
            }
            if (tmp == null) {
                System.out.println("Eleman bulunamadı");
            } else {
                for (int i = 0; i < sayac; i++) {
                    if (onceki == null) {
                        bas = tmp.ileri;
                        tmp.ileri = bas.ileri;
                        bas.ileri = tmp;
                        onceki = bas;
                    } else if (tmp.ileri == null) {
                        System.out.println("Kaydırma işlemi yapılamaz (son elemana ulaştınız)");
                        return;
                    } else {
                        onceki.ileri = tmp.ileri;
                        tmp.ileri = onceki.ileri.ileri;
                        onceki.ileri.ileri = tmp;
                        onceki = onceki.ileri;
                    }
                }
            }
        }
    }

    //Verilen bir listeyi ters çeviren metot.
    public void listeTersCevir() {
        Node tmp = bas;
        int sayac = -1;
        while (tmp != null) {
            sayac++;
            tmp = tmp.ileri;
        }
        tmp = bas;
        while (sayac >= 0) {
            elemanTasi(tmp, sayac);
            tmp = bas;
            sayac--;
        }
    }

    //Liste sonuna birden fazla eleman ekleme.
    public void sonaBirdenFazlaEkle1() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç eleman giriceğiniz: ");
        int sayac = input.nextInt();
        for (int i = 0; i < sayac; i++) {
            System.out.print(i + 1 + ".Elemanın içeriğini giriniz: ");
            int icerik = input.nextInt();
            //sona ekleme metohdu aynısı burdan sornası
            if (bas == null) bas = new Node(icerik);
            else {
                Node tmp = bas;
                while (tmp.ileri != null) tmp = tmp.ileri;
                tmp.ileri = new Node(icerik);
            }
        }
    }

    //soru11 : parametre olarak verilen 2 tane elemanın konumlarını(node) olarak değiştirien methodu yazınız!.
    //zorluk: 9/10
    public void elemanKonumlariDegis(Node eleman1, Node eleman2) {
        if (eleman1 == eleman2) {
            System.out.println("Aynı elemanları değişim yapılmaz");
            return;
        }
        Node tmp1 = bas;
        Node onceki1 = null;
        while (tmp1 != eleman1 && tmp1 != null) {
            onceki1 = tmp1;
            tmp1 = tmp1.ileri;
        }
        Node tmp2 = bas;
        Node onceki2 = null;
        while (tmp2 != eleman2 && tmp2 != null) {
            onceki2 = tmp2;
            tmp2 = tmp2.ileri;
        }
        if (tmp1 == null || tmp2 == null) {
            System.out.println("Verilen elemanlardan 1'i veya 2'side listede bulunmuyor!");
            return;
        }
        if (onceki1 != null) onceki1.ileri = tmp2;
        else bas = tmp2;
        if (onceki2 != null) onceki2.ileri = tmp1;
        else bas = tmp1;
        Node temp = tmp2.ileri;
        tmp1.ileri = tmp2.ileri;
        tmp2.ileri = temp;
    }

    //soru 12 : bir tek yönlü bağlı listenin belirli bir parçasını kopyalayıp diğer bir listeye yapıştırmak istiyoruz.
    //kopyalamanın başladığı ve bittiği yer ile kopyalancak yerin adreslerinin verildiğini varsayarsak bu
    //işlemi gerçekşleştiren kodu yazınız!.
    private void kopyalaYapistir(Node bas, Node son, Node kopya) {
        if (bas == null || son == null || kopya == null) System.out.println("Elemanlar boştur veya yanlış verilmiştir");
        else {
            Node basKopya = bas, sonKopya = son;
            sonKopya.ileri = kopya.ileri;
            kopya.ileri = basKopya;
        }
    }

    //soru14 : verilen bir listenin içinden N'ye bölünen tüm elemanları silen ve yeni bir listeye ekleyip
    //o listeyi döndüren fonksiyonu yazınız.
    public K2_LinkedList bolunenSilFarkliDondur(int n) {
        if (bas == null) {
            System.out.println("Liste boş");
            return null;
        } else {
            K2_LinkedList list1 = new K2_LinkedList();
            Node tmp, tmp2;
            tmp = bas;
            tmp2 = null;
            while (tmp != null) {
                if (bas.sayi % n == 0) {
                    list1.ekle(bas);
                    bas = bas.ileri;
                    tmp = tmp.ileri;
                } else {
                    if (tmp.sayi % n == 0) {
                        tmp2.ileri = tmp.ileri;
                        list1.ekle(tmp);
                        tmp.ileri = null;
                        tmp = bas;
                    } else {
                        tmp2 = tmp;
                        tmp = tmp.ileri;
                    }
                }
            }
            return list1;
        }
    }

    //soru17 : Verilen iki sıralanmış bağlı listenin ortak elemanlarını bulan fonksiyonu yazınız.
    public static void ortakBul(K2_LinkedList l1, K2_LinkedList l2) {
        if (l1.bas == null || l2.bas == null) System.out.println("Listelerden biri boştur");
        else {
            Node tmp1, tmp2;
            tmp1 = l1.bas;
            while (tmp1 != null) {
                tmp2 = l2.bas;
                while (tmp2 != null) {
                    if (tmp1.sayi == tmp2.sayi) {
                        System.out.println(tmp1.sayi);
                        break;
                    } else {
                        tmp2 = tmp2.ileri;
                    }
                }
                tmp1 = tmp1.ileri;
            }
        }
    }

    //Elinizde tam sayıları tutan iki adet sıralı baplı liste olduğu varsayılmaktadır. bu iki bağlı
    // listeyi sıralı birleştirip listeyi döndüren bir public liste birleştir(l1,l2) metodu yazınız.
    //l1 = 1->3->4->6
    //l2 = 0->2->5->7
    //l3 = 0->1->2->3->4->5->6->7->null
    public static K2_LinkedList birlestir(K2_LinkedList L1, K2_LinkedList L2) {
        K2_LinkedList yeni = new K2_LinkedList();
        Node tmp1 = L1.bas;
        Node tmp2 = L2.bas;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.sayi > tmp2.sayi) {
                yeni.ekle(new Node(tmp2.sayi));
                tmp2 = tmp2.ileri;
            } else {
                yeni.ekle(new Node(tmp1.sayi));
                tmp1 = tmp1.ileri;
            }
        }
        while (tmp1 != null) {
            yeni.ekle(new Node(tmp1.sayi));
            tmp1 = tmp1.ileri;
        }
        while (tmp2 != null) {
            yeni.ekle(new Node(tmp2.sayi));
            tmp2 = tmp2.ileri;
        }
        return yeni;
    }

    //1 ile 100 arasında rastgele üretilen 20 adet sayıyı bir bağlı listeye ekleyen ve ekleme yaparken
    //rastgele üreilen sayı eğer listede var ise bu sayıyı bağlı listeye eklemeyerek yeni bir sayı üretilmesini
    //sağlayan programı yazınız.
    private static int rastgeleSayUret() {
        int sayi = (int) (Math.random() * 11) + 1;
        return sayi;
    }

    private static K2_LinkedList bagliListeye20sayiEkle() {
        K2_LinkedList liste = new K2_LinkedList();
        int sayac = 0;
        Node tmp = liste.bas;
        while (sayac < 10) {
            int sayi = rastgeleSayUret();
            while (tmp != null) {
                if (sayi == tmp.sayi) {
                    System.out.println("Listede olan sayı = " + sayi);
                    break;
                }
                tmp = tmp.ileri;
            }
            if (tmp == null) {
                sayac++;
                liste.ekle(new Node(sayi));
            }
            tmp = liste.bas;
        }
        return liste;
    }

    //Rastgele üretilen sayı listede varmı metodu.
    private boolean listedeVarmi(int sayi) {
        Node tmp = this.bas;
        while (tmp != null) {
            if (sayi == tmp.sayi) {
                System.out.println(sayi + ". Sayısı listede bulunuyor");
                return true;
            }
            tmp = tmp.ileri;
        }
        return false;
    }

    //Rastgele üretilen sayı listeye ekleme.
    private void listeye20ekle() {
        int sayac = 0;
        while (sayac < 20) {
            int sayi = (int) (Math.random() * 100) + 1;
            ;
            while (listedeVarmi(sayi)) {
                sayi = (int) (Math.random() * 100) + 1;
                ;
            }
            this.ekle(new Node(sayi));
            sayac++;
        }
    }

    // 4. Tam sayıları tutan bir bağlı listede en büyük elemanı listenin sonuna atan void listeSonuMax(BListe L) {}
    // metodunu yazınız? Örneğin; 1🡪5🡪6🡪2🡪4 olarak verilen bağlı liste 1🡪5🡪2🡪4🡪6 olmalıdır.Bağlı listedeki
    // elemanların pozitif tamsayılar olup ve birbirinden farklı olduğu varsayılacaktır.(10p).
    private static void listeSonuMax(K2_LinkedList liste) {
        if (liste.bas == null) System.out.println("Liste boştur");
        else {
            Node tmp = liste.bas;
            Node max = liste.bas;
            while (tmp != null) {
                if (max.sayi < tmp.sayi) max = tmp;
                tmp = tmp.ileri;
            }
            Node maxOncesi = null;
            tmp = liste.bas;
            while (tmp.ileri != null) {
                if (tmp.ileri == max) maxOncesi = tmp;
                tmp = tmp.ileri;
            }
            maxOncesi.ileri = max.ileri;
            max.ileri = null;
            tmp.ileri = max;
        }
    }

    //Listenin elemanlarını ekrana yazan metod.
    public static void yaz(Node eleman) {
        while (eleman != null) {
            System.out.println(eleman.sayi);
            eleman = eleman.ileri;
        }
    }

    private static class Node {
        int sayi;
        Node ileri;

        Node(int sayi) {
            this.sayi = sayi;
            this.ileri = null;
        }
    }

    public static void main(String[] args) {
        //Test etme işlemleri
        K2_LinkedList listem1 = new K2_LinkedList();
        K2_LinkedList listem2 = new K2_LinkedList();
        //liste 1 eelman ekle
        listem1.ekle(new Node(1));
        listem1.ekle(new Node(3));
        listem1.ekle(new Node(4));
        listem1.ekle(new Node(6));

        //liste 2 ye eleman ekle
        listem2.ekle(new Node(0));
        listem2.ekle(new Node(2));
        listem2.ekle(new Node(5));
        listem2.ekle(new Node(7));

        listeYaz(listem1);
        listeYaz(listem2);

        //sonuç listeye metodu ata
        K2_LinkedList sonucListe = birlestir(listem1, listem2);
        //yazdır
        listeYaz(sonucListe);
    }
}
