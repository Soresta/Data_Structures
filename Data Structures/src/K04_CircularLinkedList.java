public class K04_CircularLinkedList {
    //Dairesel bağlı listeyi oluşturan yapıcı metot ve değişkenleri.
    Node bas;

    private K04_CircularLinkedList() {
        bas = null;
    }

    //Ekleme metodu
    private void ekle(Node eleman) {
        if (bas == null) {
            bas = eleman;
            eleman.next = eleman;
        } else {
            Node tmp = bas;
            while (tmp.next != bas) tmp = tmp.next;
            tmp.next = eleman;
            eleman.next = bas;
        }
    }

    //Ortaya eleman ekleme metodu.
    private void ortayaEkle(Node eleman, Node mevcut) {
        if (bas == null) {
            bas = eleman;
            eleman.next = eleman;
        } else {
            eleman.next = mevcut.next;
            mevcut.next = eleman;
        }
    }

    //Silme metodu
    private void sil() {
        if (bas == null) System.out.println("Liste boştur");
        else {
            Node tmp = bas;
            while (tmp.next != bas) tmp = tmp.next;
            tmp.next = bas.next;
            bas.next = null;
            bas = tmp.next;
        }
    }

    //Ortadan silme metodu
    private void ortadanSil(Node eleman) {
        if (bas == null || eleman == null) {
            System.out.println("Liste boş veya geçersiz eleman girildi");
            return;
        }
        Node tmp = bas;
        while (tmp.next != eleman && tmp.next != bas) tmp = tmp.next;
        if (tmp.next == eleman) {//önemli satır(elemanın listede olup olmadığını kontrol ediyor).
            tmp.next = eleman.next;
            eleman.next = null;
            if (eleman == bas) bas = tmp.next;
            return;
        }
        System.out.println("istenilen eleman listede bulunamadı");
    }

    //Sirali ekleme(eklenmesi istenilen elemanı büyüklüne göre ekleme yapıyor)
    private void siraliEkle(int data) {
        Node newNode = new Node(data);
        if (bas == null) {
            bas = newNode;
            bas.next = bas;
            return;
        }
        Node tmp = bas;
        while (tmp.next != bas && tmp.next.data < data) tmp = tmp.next;
        newNode.next = tmp.next;
        tmp.next = newNode;
    }

    //Listeyi siralama işlemini gerçekleştiren metod.
    private void sirala() {
        Node tmp1 = bas;
        Node tmp2;

        while (tmp1.next != bas) {
            tmp2 = tmp1.next;
            while (tmp2 != bas) {
                if (tmp1.data > tmp2.data) {
                    int intTmp = tmp1.data;
                    tmp1.data = tmp2.data;
                    tmp2.data = intTmp;
                }
                tmp2 = tmp2.next;
            }
            tmp1 = tmp1.next;
        }
    }

    //Listenin elemanlarını görüntülemeye işlemini gerçekleştiren metod.
    private void listeGoruntule() {
        if (bas == null) System.out.println("[]");
        else {
            Node tmp = bas;
            System.out.print("[");
            do {
                System.out.print(tmp.data + ", ");
                tmp = tmp.next;
            } while (tmp != bas);
            System.out.print("]");
        }
    }

    //Node sınıfımız(İç sınıf kullanımı-Youtube BroCode kanalından bakabilirsiniz)
    private static class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        K04_CircularLinkedList listem = new K04_CircularLinkedList();
        listem.ekle(new Node(1));
        listem.ekle(new Node(5));
        listem.ekle(new Node(-41));
        listem.ekle(new Node(10));
        listem.ekle(new Node(17));
        listem.ekle(new Node(13));
        listem.ekle(new Node(110));
        listem.ekle(new Node(0));
        listem.ekle(new Node(4));
        listem.ekle(new Node(15));
        listem.sirala();
        listem.listeGoruntule();
    }
}
