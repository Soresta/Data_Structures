public class K11_Hash {
    //Hash tables
    int N;
    Pair[] map;
    public K11_Hash(int N){
        map = new Pair[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            map[i] = null;
        }
    }
    public int get(int key) throws HastableException{
        int hash = key%N;
        int count = 0;
        while (map[hash]!=null && map[hash].getKey()!=key){
            hash = (hash+1) % N;
            if (count == N) throw new HastableException("Tablo Dolu");
            count++;
        }
        if (map[hash]==null)
            throw new HastableException("Tabloya yerleştirilemedi");
        return map[hash].getValue();
    }
    public void put(int key,int value) throws HastableException{
        int hash = key%N;
        int count = 0;
        while (map[hash]!=null && map[hash].getKey()!=key){
            hash = (hash+1) % N;
            if (count == N) throw new HastableException("Tablo Dolu");
            count++;
        }
        map[hash] = new Pair(key, value);
    }
    static class Pair{
        private  int key,value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        //Test işlemleri
        K11_Hash hashtable = new K11_Hash(10); // Örnek olarak boyutunu 10 olarak belirledik

        // Değer ekleme örneği
        try {
            hashtable.put(5, 100); // Key: 5, Value: 100 eklendi
            hashtable.put(15, 200); // Key: 15, Value: 200 eklendi
        } catch (HastableException e) {
            System.out.println(e.getMessage());
        }

        // Değer getirme örneği
        try {
            int value1 = hashtable.get(5); // Key: 5 olan değeri getir
            System.out.println("Key 5 için değer: " + value1); // 100 yazdırılacak

            int value2 = hashtable.get(15); // Key: 15 olan değeri getir
            System.out.println("Key 15 için değer: " + value2); // 200 yazdırılacak

            // Bu aşamada olmayan bir key için get işlemi
            int value3 = hashtable.get(7); // Bu key tabloda olmadığı için exception fırlatacak
            System.out.println("Key 7 için değer: " + value3); // Bu satır çalışmayacak

        } catch (HastableException e) {
            System.out.println(e.getMessage());
        }
    }
}

class HastableException extends RuntimeException{
    public HastableException(String message){
        super(message);
    }
}
