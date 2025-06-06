import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tad_down.DoublyLinkedList;
import tad_down.Node;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList list;

    @BeforeEach
    public void initializeList() {
        list = new DoublyLinkedList();
    }

    // Testes para insertOrdered
    @Test
    public void test_insertOrdered_emptyList() {
        list.insertOrdered(10);
        assertEquals(10, list.getHead().getData());
        assertEquals(10, list.getTail().getData());
        assertNull(list.getHead().getPrev());
        assertNull(list.getHead().getNext());
    }

    @Test
    public void test_insertOrdered_atBeginning() {
        list.insertOrdered(20);
        list.insertOrdered(10);
        assertEquals(10, list.getHead().getData());
        assertEquals(20, list.getTail().getData());
        assertEquals(20, list.getHead().getNext().getData());
        assertEquals(10, list.getTail().getPrev().getData());
    }

    @Test
    public void test_insertOrdered_atEnd() {
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(30);
        assertEquals(10, list.getHead().getData());
        assertEquals(20, list.getHead().getNext().getData());
        assertEquals(30, list.getTail().getData());
        assertEquals(20, list.getTail().getPrev().getData());
    }

    @Test
    public void test_insertOrdered_inMiddle() {
        list.insertOrdered(10);
        list.insertOrdered(30);
        list.insertOrdered(20);
        assertEquals(10, list.getHead().getData());
        assertEquals(20, list.getHead().getNext().getData());
        assertEquals(30, list.getTail().getData());
        assertEquals(20, list.getTail().getPrev().getData());
    }

    @Test
    public void test_insertOrdered_duplicateValues() {
        list.insertOrdered(10);
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(20);
        assertEquals(10, list.getHead().getData());
        assertEquals(10, list.getHead().getNext().getData());
        assertEquals(20, list.getHead().getNext().getNext().getData());
        assertEquals(20, list.getTail().getData());
    }

    // Testes para printForward
    @Test
    public void test_printForward_emptyList() {
        assertEquals("Lista (frente): \n", list.printForward());
    }

    @Test
    public void test_printForward_singleElement() {
        list.insertOrdered(10);
        assertEquals("Lista (frente): 10 \n", list.printForward());
    }

    @Test
    public void test_printForward_multipleElements() {
        list.insertOrdered(10);
        list.insertOrdered(30);
        list.insertOrdered(20);
        assertEquals("Lista (frente): 10 20 30 \n", list.printForward());
    }

    // Testes para printBackward
    @Test
    public void test_printBackward_emptyList() {
        assertEquals("Lista (trás): \n", list.printBackward());
    }

    @Test
    public void test_printBackward_singleElement() {
        list.insertOrdered(10);
        assertEquals("Lista (trás): 10 \n", list.printBackward());
    }

    @Test
    public void test_printBackward_multipleElements() {
        list.insertOrdered(10);
        list.insertOrdered(30);
        list.insertOrdered(20);
        assertEquals("Lista (trás): 30 20 10 \n", list.printBackward());
    }

    // Testes para remove
    @Test
    public void test_remove_emptyList() {
        list.remove(10);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void test_remove_nonExistentElement() {
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.remove(15);
        assertEquals(10, list.getHead().getData());
        assertEquals(20, list.getTail().getData());
    }

    @Test
    public void test_remove_head() {
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(30);
        list.remove(10);
        assertEquals(20, list.getHead().getData());
        assertEquals(30, list.getTail().getData());
        assertNull(list.getHead().getPrev());
        assertEquals(30, list.getHead().getNext().getData());
    }

    @Test
    public void test_remove_tail() {
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(30);
        list.remove(30);
        assertEquals(10, list.getHead().getData());
        assertEquals(20, list.getTail().getData());
        assertNull(list.getTail().getNext());
        assertEquals(10, list.getTail().getPrev().getData());
    }

    @Test
    public void test_remove_middle() {
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(30);
        list.remove(20);
        assertEquals(10, list.getHead().getData());
        assertEquals(30, list.getTail().getData());
        assertEquals(30, list.getHead().getNext().getData());
        assertEquals(10, list.getTail().getPrev().getData());
    }

    @Test
    public void test_remove_singleElement() {
        list.insertOrdered(10);
        list.remove(10);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void test_remove_duplicateValues() {
        list.insertOrdered(10);
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.remove(10);
        assertEquals(10, list.getHead().getData());
        assertEquals(20, list.getTail().getData());
    }

    // Testes para getters e setters
    @Test
    public void test_gettersAndSetters() {
        Node head = new Node(10);
        Node tail = new Node(20);

        list.setHead(head);
        list.setTail(tail);

        assertEquals(head, list.getHead());
        assertEquals(tail, list.getTail());
    }

    // Testes para Node
    @Test
    public void test_nodeToString() {
        Node node = new Node(42);
        assertEquals("42", node.toString());
    }

    @Test
    public void test_nodeEquals() {
        Node node1 = new Node(10);
        Node node2 = new Node(10);
        Node node3 = new Node(20);

        assertEquals(node1, node2);
        assertNotEquals(node1, node3);
        assertNotEquals(node1, null);
        assertNotEquals(node1, new Object());
    }

    @Test
    public void test_nodeHashCode() {
        Node node = new Node(15);
        assertEquals(15, node.hashCode());
    }

}