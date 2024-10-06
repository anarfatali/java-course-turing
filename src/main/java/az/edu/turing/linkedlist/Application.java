package az.edu.turing.linkedlist;

public class Application {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addHead("anar");
        System.out.println(list);
        list.addTail("adil");
        System.out.println(list);
        list.removeHead();
        System.out.println(list);
        list.removeTail();
        System.out.println(list);
        list.insert(1, "amin");
        System.out.println(list);
        list.update(2, "kamil");
        System.out.println(list);
        list.delete(2);
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
