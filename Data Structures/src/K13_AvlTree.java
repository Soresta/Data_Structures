public class K13_AvlTree {
    Node kok;

    K13_AvlTree() {
        this.kok = null;
    }

    //Parametre olarak verilen elemanın hangi derinlikte olduğunu döndüren metod.
    int derinlik(Node eleman) {
        if (eleman == null) {
            return 0;
        }
        return eleman.derinlik;
    }

    //verilen 2 elemandan büyük olanı döndüren metod.
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //Sağ rotasyon metodu.
    Node sagRotasyon(Node y) {
        Node x = y.sol;
        Node T2 = x.sag;
        x.sag = y;
        y.sol = T2;
        y.derinlik = max(derinlik(y.sol), derinlik(y.sag)) + 1;
        x.derinlik = max(derinlik(x.sol), derinlik(x.sag)) + 1;
        return x;
    }

    //sol rotasyon metodu.
    Node solRotasyon(Node x) {
        Node y = x.sag;
        Node T2 = y.sol;
        y.sol = x;
        x.sag = T2;
        y.derinlik = max(derinlik(y.sol), derinlik(y.sag)) + 1;
        x.derinlik = max(derinlik(x.sol), derinlik(x.sag)) + 1;
        return y;
    }

    //Dengeleme metodu.
    int getBalance(Node N) {
        if (kok == null) {
            return 0;
        }
        return derinlik(N.sol) - derinlik(N.sag);
    }

    //Ağaca eleman ekleme metodu.(Dengeli ekleme)
    Node ekle(Node kok, int icerik) {
        if (kok == null) return new Node(icerik);
        if (icerik < kok.icerik) {
            kok.sol = ekle(kok.sol, icerik);
        } else if (icerik > kok.icerik) {
            kok.sag = ekle(kok.sag, icerik);
        } else return kok;
        kok.derinlik = max(derinlik(kok.sol), derinlik(kok.sag));
        int denge = getBalance(kok);
        // Sol Sol Durumu
        if (denge > 1 && icerik < kok.sol.icerik) {
            return sagRotasyon(kok);
        }

        // Sağ Sağ Durumu
        if (denge < -1 && icerik > kok.sag.icerik) {
            return solRotasyon(kok);
        }

        // Sol Sağ Durumu
        if (denge > 1 && icerik > kok.sol.icerik) {
            kok.sol = solRotasyon(kok.sol);
            return sagRotasyon(kok);
        }

        // Sağ Sol Durumu
        if (denge < -1 && icerik < kok.sag.icerik) {
            kok.sag = sagRotasyon(kok.sag);
            return solRotasyon(kok);
        }
        return kok;
    }

    //Avl ağacını gösteren metod.
    void preOrder(Node kok) {
        if (kok != null) {
            System.out.print(kok.icerik + ", ");
            preOrder(kok.sol);
            preOrder(kok.sag);
        }
    }

    //Dahili node sınıfı.
    private static class Node {
        int icerik, derinlik;
        Node sol, sag;

        Node(int icerik) {
            this.icerik = icerik;
            this.derinlik = 1;
            this.sag = this.sol = null;
        }
    }

    public static void main(String[] args) {
        //Test işlemleri
        K13_AvlTree agac = new K13_AvlTree();
        Node kok = new Node(10);
        agac.kok = kok;
        agac.ekle(agac.kok, 20);
        agac.ekle(agac.kok, 30);
        agac.preOrder(agac.kok);
        agac.ekle(agac.kok, 15);
        System.out.println();
        agac.preOrder(agac.kok);
    }
}
