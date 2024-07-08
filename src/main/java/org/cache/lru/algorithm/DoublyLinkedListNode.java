package org.cache.lru.algorithm;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> previous;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }
}
