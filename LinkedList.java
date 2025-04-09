public class LinkedList<T> {
    public Node<T> head;

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }
}