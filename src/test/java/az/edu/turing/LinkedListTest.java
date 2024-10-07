package az.edu.turing;

import az.edu.turing.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class LinkedListTest {

    LinkedList<String> list;
    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        list.addHead("afvs");
        list.add("asd");
    }

    @Test
    public void addLinkedListShouldReturnSuccess() {
        LinkedList<String> list1 = new LinkedList();
        list1.addHead("afvs");
        list1.add("asd");
        assertEquals(list, list1);
    }
}
