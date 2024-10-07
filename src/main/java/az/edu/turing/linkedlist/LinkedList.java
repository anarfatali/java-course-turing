package az.edu.turing.linkedlist;

import java.util.Objects;
import java.util.Optional;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public T addHead(final T t) {
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            tail = head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
        return head.value;
    }

    public void add(final T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
    }

    public Optional<T> removeHead() {
        if (head == null) {
            return Optional.empty();
        }

        T removed = head.value;
        head = head.next;

        if (size == 0) {
            tail = null;
        }

        size--;
        return Optional.ofNullable(removed);
    }

    public Optional<T> removeTail() {
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

    public void insert(final int index, final T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (index == 0) {
            this.addHead(t);
            return;
        } else if (index == size) {
            this.add(t);
            return;
        }

        Node<T> newNode = new Node<>(t);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public T update(final int index, final T t) {
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

    public Optional<T> delete(final int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (index == 0) {
            return removeHead();
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
        return Optional.ofNullable(previous);
    }

    public boolean delete(final T t) {
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
        int index = 0;
        while (current.next != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkedList<?> that = (LinkedList<?>) obj;
        if (size != that.size) {
            return false;
        }

        Node<T> currentMine = this.head;
        Node<?> currentForTest = that.head;

        while (currentMine != null) {
            if (!Objects.equals(currentMine.value, currentForTest.value)) {
                return false;
            }
            currentMine = currentMine.next;
            currentForTest = currentForTest.next;
        }
        return true;
    }
}
