public class K05_DoubleCircularLinkedList {
    //Çift yönlü dairesel bağlı liste.
    Node bas;
    Node son;

    K05_DoubleCircularLinkedList() {
        bas = null;
        son = null;
    }

    //Bir dairesel listede ogrencilere ait veri yapıları notu tutuluyor ogrenci notu 100 olan kişi
    //bu dairesel listeden çıakran programı yazınız.
    private void yuksekNotBul(int not) {
        Node tmp = bas;
        Node tmp2 = null;
        while (tmp.ileri != null && tmp.not != 100) {
            tmp2 = tmp;
            tmp = tmp.ileri;
        }
        tmp2.ileri = tmp.ileri;
        tmp.ileri.geri = tmp2;
        tmp.ileri = null;
        tmp.geri = null;
    }

    //Ekleme metodu.
    private void ekle(Node eleman) {
        if (bas == null) {
            bas = eleman;
            son = eleman;
            bas.ileri = bas;
            bas.geri = bas;
        } else {
            eleman.ileri = bas;
            eleman.geri = bas.geri;
            son.ileri = eleman;
            bas.geri = eleman;
            son = son.ileri;
        }
    }

    //Yazdirma metodu.
    private void yaz() {
        Node tmp = bas;
        System.out.print("[");
        do {
            System.out.print(tmp.not + ", ");
            tmp = tmp.ileri;
        } while (tmp != bas);
        System.out.println("]");
    }

    //Tersten yazdirma metodu.
    private void tersYaz() {
        Node tmp = son;
        System.out.print("[");
        do {
            System.out.print(tmp.not + ", ");
            tmp = tmp.geri;
        } while (tmp != son);
        System.out.println("]");
    }

    //Dahili node sınıfı.
    private static class Node {
        Node ileri, geri;
        int not;

        Node(int not) {
            this.not = not;
            ileri = null;
            geri = null;
        }
    }

    public static void main(String[] args) {
        //Test işlemleri:
        K05_DoubleCircularLinkedList liste = new K05_DoubleCircularLinkedList();
        liste.ekle(new Node(1));
        liste.ekle(new Node(2));
        liste.ekle(new Node(3));
        liste.ekle(new Node(4));
        liste.ekle(new Node(100));
        liste.ekle(new Node(5));
        liste.ekle(new Node(6));
        liste.ekle(new Node(7));
        liste.ekle(new Node(8));

        liste.yaz();
        liste.tersYaz();

        liste.yuksekNotBul(100);

        liste.yaz();
        liste.tersYaz();
    }
}
