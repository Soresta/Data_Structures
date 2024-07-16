public class K09_Queue {
    //Dizi yapısı kullanılarak oluşturulan kuyruk yapısı(Linkedlist mantığı kullanılmamıştır).
    Node[] arr;
    int boyut;
    int bas,son,elemanSayisi;

    K09_Queue(int boyut){
        arr = new Node[boyut];
        this.boyut = boyut;
        bas = 0;
        son = 0;
        elemanSayisi = 0;
    }

    boolean doluMu(){
        return bas == (son + 1) % boyut;
    }

    boolean bosMu(){
        return bas == son;
    }

    //Kuyrukağa eleman ekleyen metod.
    public void enQueue(Node yeni){
        if (!doluMu()) {
            arr[son] = yeni;
            son = (son+1)%boyut;
        }
        else {
            System.out.println("Kuyruk doludur");
        }
    }

    //Kuyruktan eleman silen metod.
    private Node deQueue(){
        Node sonuc;
        if (!bosMu()){
            sonuc = arr[bas];
            bas = (bas +1)%boyut;
            return sonuc;
        }
        return null;
    }

    //Dahili Node Sınıfı.
    private static class Node{
        int icerik;
        Node(int icerik){
            this.icerik = icerik;
        }
    }

    public static void main(String[] args) {
        K09_Queue kuyruk = new K09_Queue(5);
        kuyruk.enQueue(new Node(1));
        kuyruk.enQueue(new Node(2));
        kuyruk.enQueue(new Node(3));
        kuyruk.enQueue(new Node(4));
        kuyruk.enQueue(new Node(5));
        while (!kuyruk.bosMu()){
            System.out.println(kuyruk.deQueue().icerik);
        }
    }
}
