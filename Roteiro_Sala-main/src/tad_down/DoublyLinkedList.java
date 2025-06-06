package tad_down;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Inserção em ordem crescente
    public void insertOrdered(int data) {
        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        if(data < this.head.getData()){
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
            return;
        }

        if(data >= this.tail.getData()){
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
            return;

        }

        Node current = this.head;
        while(current.getNext() != null && current.getNext().getData() < data){
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        newNode.setPrev(current);
    }

    public String printForward() {
        StringBuilder output = new StringBuilder("Lista (frente): ");
        Node current = this.head;
        while (current != null) {
            output.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return output.append("\n").toString();
    }

    public String printBackward() {
        StringBuilder output = new StringBuilder("Lista (trás): ");
        Node current = this.tail;
        while (current != null) {
            output.append(current.getData()).append(" ");
            current = current.getPrev();
        }
        return output.append("\n").toString();
    }

    public void remove(int data) {

        if(this.head == null){
            return;
        }

        Node current = this.head;
        while (current != null && current.getData() < data) {
            current = current.getNext();
        }

        if(current == null || current.getData() != data){
            return;
        }

        if (current.getPrev() == null) {
            this.head = current.getNext();
        } else {
            current.getPrev().setNext(current.getNext());
        }

        if (current.getNext() == null) {
            this.tail = current.getPrev();
        }
        else{
            current.getNext().setPrev(current.getPrev());
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}