public class K10_LinkedQueue {
    //Linked list mantığı kullanılarak oluşturulan kuyruk yapısı(Dizi yapısı kullanılmamıştır).
    Node bas, son;
    K10_LinkedQueue() {
        bas = null;
        son = null;
    }

    //Kuyruğun boş olma durumunu kontrol eden metod.
    boolean bosmu() {
        return bas == null;
    }

    //Kuryuğa eleman ekleyen metod.
    void enQueue(Node yeni) {
        if (!bosmu()) {
            son.ileri = yeni;
            son = yeni;
        } else {
            bas = yeni;
            son = yeni;
        }
    }

    //Kuryuktan eleman silen metod.
    Node deQueue() {
        Node eleman = bas;
        if (!bosmu()) {
            bas = bas.ileri;
            if (bas == null) son = null;
        }
        return eleman;
    }

    //Soru: Kuyruğu ters çevir(yığın kullanarak) :
    public static K10_LinkedQueue kuyrukTersCevir(K10_LinkedQueue kuyruk) {
        K8_LinkedStack stack = new K8_LinkedStack();
        while (!kuyruk.bosmu()) {
            //stack.push(new K8_LinkedStack.Node(kuyruk.deQueue().icerik));
        }
        while (!stack.bosMu()) {
            kuyruk.enQueue(new Node(stack.pop().icerik));
        }
        return kuyruk;
    }

    //Kuyruğu gösteren metod.
    private void kuyrukYaz() {
        Node tmp = bas;
        while (tmp != null) {
            System.out.print("<-" + tmp.icerik);
            tmp = tmp.ileri;
        }
    }

    //Dahili node sınıfı.
    private static class Node {
        int icerik;
        Node ileri;

        Node(int icerik) {
            this.icerik = icerik;
            ileri = null;
        }
    }

    public static void main(String[] args) {
        //Test işlemleri
        K10_LinkedQueue lkuyruk = new K10_LinkedQueue();
        lkuyruk.enQueue(new Node(1));
        lkuyruk.enQueue(new Node(2));
        lkuyruk.enQueue(new Node(3));
        lkuyruk.enQueue(new Node(4));
        lkuyruk.enQueue(new Node(5));

        kuyrukTersCevir(lkuyruk);
        lkuyruk.kuyrukYaz();
    }
}
