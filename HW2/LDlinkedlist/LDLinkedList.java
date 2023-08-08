import java.util.AbstractList;
import java.util.List;

public class LDLinkedList<E> extends AbstractList<E> implements List<E> {
    /** A node is the building block for a LDLinkedlist extend from AbstractList */
    private static class Node<E> {
        /**The element is value of Node */
        E element;
        /** If the elemenet is delete, isDeleted set true */
        boolean isDeleted;
        /** The link to next element */
        Node<E> next;

        /**
         * Construct a node with given element value
         * @param element
         */
        Node(E element) {
            this.element = element;
            this.isDeleted = false;
            this.next = null;
        }
    }
    /** head of linked list  */
    private Node<E> head;
    /** 
     * lengt of LDLinkedList 
     */
    private int size;

    public LDLinkedList() {
        head = new Node<>(null);
        size = 0;
    }
    /** 
     * return size of LDLinkedlist */
    @Override
    public int size() {
        return size;
    }
    /**
     * it returns data which is in the spesific position at LL. It requires an integer. 
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head.next;
        int i = 0;
        while (current != null) {
            if (!current.isDeleted && i == index) {
                return current.element;
            }
            if (!current.isDeleted) {
                i++;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }
    /**
     * as a designer it adds to the tail if size greater than zero. otherwise it adds on head then makes head and tail to the same position.
     */
    @Override
    public boolean add(E e) {
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(e);
        size++;
        return true;
    }
    /**
     * first part marks the given object.
     * second part checks what is number if is even then it is going to delete the marked ones.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head.next;
        Node<E> previous = head;
        int i = 0;
        while (current != null) {
            if (!current.isDeleted && i == index) {
                current.isDeleted = true;
                size--;
                if (size > 1 && previous.isDeleted && current.next != null && current.next.isDeleted) {
                    removeLazilyDeletedNodes(previous);
                }
                return current.element;
            }
            if (!current.isDeleted) {
                i++;
            }
            previous = current;
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }
    /**
     * The function deleted nodes physically from the list
     * @param previous represent the node which deleted first
     */
    private void removeLazilyDeletedNodes(Node<E> previous) {
        Node<E> firstLazilyDeletedNode = previous.next;
        Node<E> secondLazilyDeletedNode = firstLazilyDeletedNode.next;
        while (secondLazilyDeletedNode != null && secondLazilyDeletedNode.isDeleted) {
            firstLazilyDeletedNode = secondLazilyDeletedNode;
            secondLazilyDeletedNode = secondLazilyDeletedNode.next;
        }
        previous.next = secondLazilyDeletedNode;
    }
}