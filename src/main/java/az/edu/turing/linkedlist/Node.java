package az.edu.turing.linkedlist;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node() {}

    public Node(T value) {
        this.value = value;
    }

    public Node(T data, Node<T> next) {
        this.value = data;
        this.next = next;
    }
}
