package az.edu.turing.linkedlist;

public class Application {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addHead("first");
        list.add("second");
        list.add("third");
        list.insert(2,"middle");
        list.delete(1);
        System.out.println(list);
        list.removeHead();
        System.out.println(list);
        list.removeTail();
        System.out.println(list);
        System.out.println(list);
        list.update(2, "kamil");
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        list.delete("kamil");
        System.out.println(list);
        System.out.println(list.size());
        list.deleteAll();
        System.out.println(list);
        list.toArray();
        System.out.println(list);
    }
}
