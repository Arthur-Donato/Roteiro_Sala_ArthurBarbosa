package tad_down;

public class Node {
    private int data;
    private Node next;
    private Node prev;

    public Node(int data){
        this.data = data;
    }

    public Node(Integer data, Node prev) {
        this.data = data;
        this.next = null;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "" + data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {

        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return data;
    }
}
