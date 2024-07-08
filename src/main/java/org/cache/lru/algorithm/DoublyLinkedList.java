package org.cache.lru.algorithm;

public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> head;
    DoublyLinkedListNode<E> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.next.previous = node.next;
            node.previous.next = node.previous;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode previousTail = this.tail.previous;
        previousTail.next = node;
        node.next = this.tail;
        previousTail.previous = node;
        node.previous = previousTail;
    }

    public DoublyLinkedListNode<E> addElementToLast(E element) {
        if (element == null) {
            throw new RuntimeException("Invalid Element");
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (!isItemPresent()) {
            return null;
        }
        return this.head.next;
    }

    public boolean isItemPresent() {
        return this.head.next != this.tail;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (!isItemPresent()) {
            return null;
        }
        return this.tail.previous;
    }
}
