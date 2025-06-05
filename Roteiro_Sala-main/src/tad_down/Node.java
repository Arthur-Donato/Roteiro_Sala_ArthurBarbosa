package tad_down;

public class Node {
    private Integer data;
    private Node next;
    private Node prev;

    public Node(Integer data){
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
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
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

    public boolean isNull(){
        return this.data == null;
    }
}
