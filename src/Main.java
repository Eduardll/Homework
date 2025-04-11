public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> gg = new MyHashMap<>();
        gg.put(12,"sd");
        gg.put(13,"dd");
        gg.put(14,"fd");
        gg.put(15,"gd");
        gg.get(14);
        System.out.println(gg.isEmpty());
        gg.display();
        gg.clear();
        gg.display();
    }
}