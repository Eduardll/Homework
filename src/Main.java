public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> gg = new MyHashMap<>();
        gg.put(12,"sd");
        gg.put(13,"dd");
        gg.put(14,"fd");
        gg.put(15,"gd");
        gg.put(1,"gd");
        gg.put(2,"gd");
        gg.put(3,"gd");
        gg.put(4,"gd");
        gg.put(5,"gd");
        gg.put(6,"gd");
        gg.put(7,"gd");
        gg.put(8,"gd");
        gg.put(10,"gd");
        gg.put(11,"gd");
        gg.put(9,"gd");
        gg.get(2);
        System.out.println(gg.isEmpty());
        gg.display();
        gg.clear();
        gg.display();
    }
}