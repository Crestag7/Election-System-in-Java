// Name: Aadarsha Shrestha 
// Simple linked list to store votes

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class LinkedList<T> {
    public Node<T> head;

    // Add new item to the front of the list
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

    // Remove items that match condition
    public void removeMatching(Predicate<T> check) {
        while (head != null && check.test(head.data)) {
            head = head.next;
        }

        Node<T> current = head;
        while (current != null && current.next != null) {
            if (check.test(current.next.data)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Do something to each item
    public void forEach(Consumer<T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    // Copy all items to a list
    public ArrayList<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.data);
            current = current.next;
        }
        return result;
    }
}
