package az.edu.turing.linkedlist;

import java.util.Arrays;
import java.util.Optional;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public T addHead(T t) {
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
        return head.value;
    }

    public T addTail(T t) {
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = tail;
            tail = newNode;
        }

        size++;
        return tail.value;
    }

    public Optional<Object> removeHead() {
        if (head == null) {
            return Optional.empty();
        }

        T removed = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return Optional.ofNullable(removed);
    }

    public Optional<Object> removeTail() {
        if (tail == null) {
            return Optional.empty();
        }

        T removed = tail.value;
        tail = tail.next;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }

        size--;
        return Optional.ofNullable(removed);
    }

    public T insert(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (index == 0) {
            addHead(t);
        } else if (index == size) {
            addTail(t);
        }

        Node<T> newNode = new Node<>(t);
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
        return t;
    }

    public T update(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T oldValue = current.value;
        current.value = t;
        return oldValue;
    }

    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T previous = current.next.value;
        current.next = current.next.next;

        if (current.next == null) {
            tail = current;
        }

        size--;
        return previous;
    }

    public boolean delete(T t) {
        if (head == null) {
            return false;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.value == t) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void deleteAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
