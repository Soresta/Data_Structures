public class K07_Stack_2 {
    //Dizi yapısı ile stack farklı yaklaşım (this.ust=-1)olarak başlandı.
    int[] dizi;
    int kapasite;
    int ust;
    K07_Stack_2(int kapasite){
        this.kapasite = kapasite;
        this.dizi = new int[kapasite];
        this.ust = -1;
    }

    boolean bosMu(){
        return this.ust == -1;
    }
    boolean doluMu(){
        return this.ust == this.kapasite-1;
    }

    public void push(int sayi){
        if (!doluMu()){
            this.ust++;
            this.dizi[ust] = sayi;
        }
        else System.out.println("yığın dolu");
    }

    public int pop(){
        if (!bosMu()){
            this.ust--;
            return this.dizi[ust+1];
        }
        else System.out.println("yığın boş");
        return -1;
    }

    public int peek(){
        if (!bosMu()){
            return this.dizi[ust];
        }
        System.out.println("Dizi boş");
        return -1;
    }

    public static void main(String[] args) {
        K07_Stack_2 stack = new K07_Stack_2(3);
    }
}
