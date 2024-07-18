public class K08_LinkedStack {
    Node ust;

    K08_LinkedStack() {
        ust = null;
    }

    public static class Node {
        int icerik;
        char harf;
        Node ileri;

        public Node(int icerik, char harf) {
            this.icerik = icerik;
            this.harf = harf;
            this.ileri = null;
        }
    }

    public void push(Node yeni) {
        yeni.ileri = ust;
        ust = yeni;
    }

    public boolean bosMu() {
        return ust == null;
    }

    public Node peek() {
        return ust;
    }

    public Node pop() {
        if (!bosMu()) {
            Node dondur = ust;
            ust = ust.ileri;
            return dondur;
        }
        return null;
    }

    //verilen bir karakter dizisindeki parantezlerin eşli olup olmadığı çıkın yapısını kullanarak yapınız.
    public static boolean parantezKontrol(String yazi) {
        K08_LinkedStack stack = new K08_LinkedStack();
        for (int i = 0; i < yazi.length(); i++) {
            if (yazi.charAt(i) == '(' || yazi.charAt(i) == '{' || yazi.charAt(i) == '[') {
                stack.push(new Node(0, yazi.charAt(i)));
            } else {
                if (yazi.charAt(i) == ')'&& stack.ust.harf != '(')return false;
                else if (yazi.charAt(i) == ']' && stack.ust.harf != '[') return false;
                else if (yazi.charAt(i) == '}'&& stack.ust.harf != '{') return false;
                stack.pop();
            }
        }
        return true;
    }

    //bir yığıtta tam sayılar tutulmaktadır. bu yığıtı kendisine parametre alan ve yığıttaki tek sayıları ayrı bir
    //yığıta ce çift sayıları ayrı bir yığıta atan metodu yazınız.

    public static K08_LinkedStack[] ciftVeTekAyir(K08_LinkedStack input) {
        K08_LinkedStack tekStack = new K08_LinkedStack();
        K08_LinkedStack ciftStack = new K08_LinkedStack();
        K08_LinkedStack[] stackler = {tekStack, ciftStack};
        while (input.ust != null) {
            Node sayi = input.pop();
            if (sayi.icerik % 2 == 0) {
                ciftStack.push(sayi);
            } else tekStack.push(sayi);
        }
        return stackler;
    }


    //kendisine parametre olarak bir pozitif tam sayı alan ve yığıt kullanarak sayıyı ters çevirerek döndüren
    //int ters_cevir(int sayi){} metodunu yazınız? sayı 6899 olarak verilirse 9986 olarak döndürcek
    public static double ters_cevir(int sayi) {
        K08_LinkedStack tmpStack = new K08_LinkedStack();
        int sayac = 0;
        double sonuc = 0;
        while (sayi != 0) {
            //tmpStack.push(new Node(sayi % 10));
            sayac++;
            sayi /= 10;
        }
        for (int i = 0; i < sayac; i++) {
            Node cikarilan = tmpStack.pop();
            sonuc += cikarilan.icerik * Math.pow(10, i);
        }
        return sonuc;
    }

    //(15p) Bir bağlı yığıt veri yapısında bulunan elemanlardan verilen bir parametrenin değerine eşit
    //olan tüm elemanları silerek yığıtın yeni halini döndüren hepsini_sil() isimli bir metot yazınız.
    //Örneğin { 9, 1, 9, 2, 3, 9, 4, 9, 9} elemanlarını içeren bir yığıt için 9 elemanı parametre olarak
    //verilerek hepsini_sil(9) metodu çağrıldığında {1,2,3,4} elemanlarını içeren bir yığıt geri
    //döndürülecektir. Not: Bu metodu yazarken başka bir veri yapısı tanımlanmayacaktır(başka bir yığıt,
    //bağlı liste veya kuyruk vb.).
    public void hepsiniSil(int deger) {
        while (ust.icerik == deger) ust = ust.ileri;
        Node gezen = ust;
        Node onceki = null;
        while (gezen.ileri != null) {
            onceki = gezen;
            gezen = gezen.ileri;
            if (gezen.icerik == deger) {
                onceki.ileri = gezen.ileri;
                gezen = onceki;
            }
        }
    }

    //5. Bağlı liste ile tanımlanmış bir tamsayı yığıtını parametre
    //olarak alan ve yığıtın elemanlarının yukarıdan aşağıya
    //azalmayan bir sırada olmasını sağlayan bir yöntem yazınız.
    //Bunu yapmak için, yığıtın tepesindeki herhangi bir
    //elemandan daha küçük olan elemanlar yığıttan silinir.
    //alt[4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 0]ust
    public static void kucuktenBuyuge(K08_LinkedStack stack){
        K08_LinkedStack tempStack = new K08_LinkedStack();
        while (stack.ust!=null){
            Node stackeAtEleman = stack.pop();
            if (tempStack.bosMu()) tempStack.push(stackeAtEleman);
            else {
                if (tempStack.ust.icerik<stackeAtEleman.icerik)tempStack.push(stackeAtEleman);
            }
        }
        while (tempStack.ust!=null) stack.push(tempStack.pop());
    }
    public void show() {
        Node tmp = ust;
        System.out.print("[");
        while (tmp != null) {
            System.out.print(tmp.icerik+",");
            tmp = tmp.ileri;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        K08_LinkedStack stack = new K08_LinkedStack();
        stack.push(new Node(4,'a'));
        stack.push(new Node(20,'a'));
        stack.push(new Node(15,'a'));
        stack.push(new Node(15,'a'));
        stack.push(new Node(8,'a'));
        stack.push(new Node(5,'a'));
        stack.push(new Node(7,'a'));
        stack.push(new Node(12,'a'));
        stack.push(new Node(3,'a'));
        stack.push(new Node(10,'a'));
        stack.push(new Node(5,'a'));
        stack.push(new Node(0,'a'));

        System.out.println("Silme işlemi öncesi : ");
        stack.show();

        kucuktenBuyuge(stack);
        System.out.println();
        System.out.println("Silme işlemi sonrası : ");
        stack.show();
    }
}
