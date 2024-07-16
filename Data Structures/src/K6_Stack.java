public class K6_Stack {
    //Dizi yapısı ile stack oluşturmak (ust=0)yaklaşımı.
    int[] array;
    int size;
    int top;

    K6_Stack(int size) {
        this.array = new int[size];
        this.size = size;
        this.top = 0;
    }

    //Yığına eleman ekleme işlemi.
    private void push(int data) {
        if (!doluMu()) {
            this.array[top] = data;
            this.top++;
        } else System.out.println("K6_Stack Doludur.");
    }

    //Yığından eleman silme işlemi.
    private int pop() {
        if (!bosMu()) {
            this.top--;
            return this.array[top];
        } else {
            System.out.println("K6_Stack Boştur, Çıkarma işlemi başarısız.");
            return -1;
        }
    }

    //Yığının en üstteki elemanını gösteren(döndüren) metod.
    private int peek(){
        if (!bosMu()){
            System.out.println(array[top-1]);
            return array[top-1];
        }
        else {
            System.out.println("Liste boştur");
            return -1;
        }
    }

    //Yığının boşluk durumunu kontrol eden metod.
    private boolean bosMu() {
        return this.top == 0;
    }

    //Yığının doluluk durumunu kontrol eden metod.
    private boolean doluMu() {
        return this.top == size;
    }

    //Yığını gösteren metod.
    private void show() {
        int sayac = top - 1;
        while (sayac > -1) {
            System.out.println("[" + this.array[sayac] + "]");
            sayac--;
        }
    }

    public static void main(String[] args) {
        K6_Stack stack = new K6_Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        stack.pop();

        stack.show();
    }
}
