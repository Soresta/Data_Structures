public class K12_BinarySearchTree {
    //İkili agacı oluşturan yapıcı metot ve değişkenleri.
    Dugum kok;

    K12_BinarySearchTree() {
        kok = null;
    }

    /*Ağaçta arama işlemi.
    Aşşağıdaki metot bir parametre ve bir dönüş tipine sahiptir, aranacak elemanın içeriğini parametre
    olarak alır ve aramaya başlar eğer ki bulursa o elemanın dönüş tipi Dugum olarak döndürür bulmassa
    null olarak dönüş verir.
    */
    public Dugum elemanAra(int icerik) {
        if (kok == null) {
            System.out.println("Bu içeriğe sahip eleman bulunmadı");
            return null;
        } else {
            Dugum tmp = kok;
            while (tmp != null) {
                if (tmp.value == icerik) return tmp;
                else if (icerik > tmp.value) tmp = tmp.sag;
                else tmp = tmp.sol;
            }
        }
        return null;
    }

    //Rekürsif arama işlemini gerçekleştiren metod.
    public Dugum rekursifAra(int value, Dugum temp) {
        if (temp.value == value) return temp;
        else {
            if (temp.value > value) {
                if (temp.sol != null) return rekursifAra(value, temp.sol);
                else return null;
            } else {
                if (temp.sag != null) return rekursifAra(value, temp.sag);
                else return null;
            }
        }
    }

    //Ağaçtaki düğümlerin değerlerinin(Integer-Tamsayı) toplamını hesaplayan metod.
    public int agacinToplami(Dugum kok) {
        if (kok == null) return 0;
        else return kok.value + agacinToplami(kok.sag) + agacinToplami(kok.sol);
    }

    //En küçük elemanı bulan metod.
    public Dugum enKucukBul() {
        Dugum temp = kok;
        if (temp != null) {
            while (temp.sol != null) temp = temp.sol;
        }
        return temp;
    }

    //En küçük elemanı bulan metod(Rekürsif).
    public Dugum enKucukBulRekursif(Dugum temp) {
        if (temp != null) {
            if (temp.sol == null) return temp;
            else return enKucukBulRekursif(temp.sol);
        } else return null;
    }

    //En buyuk eleman bulma metodu
    public Dugum enBuyukBul() {
        Dugum temp = kok;
        if (temp != null) {
            while (temp.sag != null) temp = temp.sag;
        }
        return temp;
    }

    //En buyuk elemanı bulan metod (Rekürsif)
    public Dugum enBuyukBulRekursif(Dugum temp) {
        if (temp != null) {
            if (temp.sag == null) return temp;
            else return enBuyukBulRekursif(temp.sag);
        } else return null;
    }

    //Ekleme işlemi.
    int elemanSayisi = 0;

    public int elemanEkleveHesapla(int value) {
        Dugum eklenecekDugum = new Dugum(value);
        Dugum temp = kok;//eklencek elemanın yerini bulmak için gezen dugum.
        Dugum ebeveyn = null; //eklencek elemanın yeri bulununca onun ebeveynin sag veya sol koluna eklencek
        while (temp != null) {
            ebeveyn = temp;
            if (eklenecekDugum.value > temp.value) temp = temp.sag;
            else temp = temp.sol;
        }
        if (ebeveyn == null) {
            kok = eklenecekDugum;
            elemanSayisi++;
        } else {
            if (eklenecekDugum.value > ebeveyn.value) ebeveyn.sag = eklenecekDugum;
            else ebeveyn.sol = eklenecekDugum;
            elemanSayisi++;
        }
        return elemanSayisi;
    }

    //Ağacın elemanlarını gösterme işlemleri (Rekürsif):
    //ön gösterim metodu (kök ilk gösteirlir)(Preorder)
    public static void preOrder(Dugum temp) {
        if (temp == null) return;
        System.out.print(temp.value + ", ");
        preOrder(temp.sol);
        preOrder(temp.sag);
    }

    //orta gösterim (kök ortada olcak)(Inorder)
    public static void inOrder(Dugum temp) {
        if (temp == null) return;
        inOrder(temp.sol);
        System.out.print(temp.value + ", ");
        inOrder(temp.sag);
    }

    //arka(son) gösterim (kök sonda olcak)(Postorder)
    public static void postOrder(Dugum temp) {
        if (temp == null) return;
        postOrder(temp.sol);
        postOrder(temp.sag);
        System.out.print(temp.value + ", ");
    }

    //eleman ekleme ve eleman sayısını bulam işlemi:

    //Node Claası Oluşturma
    private static class Dugum {
        int value;
        Dugum sag, sol;

        Dugum(int value) {
            this.value = value;
            this.sag = null;
            this.sol = null;
        }
    }

    public static void main(String[] args) {
        //Test işlemleri
        K12_BinarySearchTree ikiliAgac = new K12_BinarySearchTree();
        ikiliAgac.elemanEkleveHesapla(11);
        ikiliAgac.elemanEkleveHesapla(6);
        ikiliAgac.elemanEkleveHesapla(8);
        ikiliAgac.elemanEkleveHesapla(19);
        ikiliAgac.elemanEkleveHesapla(4);
        ikiliAgac.elemanEkleveHesapla(13);
        ikiliAgac.elemanEkleveHesapla(5);
        ikiliAgac.elemanEkleveHesapla(17);
        ikiliAgac.elemanEkleveHesapla(43);
        ikiliAgac.elemanEkleveHesapla(49);
        System.out.println(ikiliAgac.elemanEkleveHesapla(32));
        inOrder(ikiliAgac.kok);
    }
}
