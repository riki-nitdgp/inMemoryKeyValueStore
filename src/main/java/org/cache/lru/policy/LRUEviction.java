package org.cache.lru.policy;

import org.coding.systemDesign.cache.algorithm.DoublyLinkedList;
import org.coding.systemDesign.cache.algorithm.DoublyLinkedListNode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUEviction<KEY> implements EvictionPolicy<KEY>{

    private DoublyLinkedList<KEY> dll;
    private Map<KEY, DoublyLinkedListNode<KEY>> mapper;

    public LRUEviction() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new ConcurrentHashMap<>();
    }
    @Override
    public void accessedKey(KEY key) {
        if (this.mapper.containsKey(key)) {
            dll.detachNode(this.mapper.get(key));
            dll.addNodeAtLast(this.mapper.get(key));
        } else {
            DoublyLinkedListNode<KEY> newNode = new DoublyLinkedListNode<>(key);
            this.mapper.put(key, newNode);
        }
    }

    @Override
    public KEY evict() {
        DoublyLinkedListNode<KEY> nodeToRemove = this.dll.getFirstNode();
        if (nodeToRemove == null) return  null;
        dll.detachNode(nodeToRemove);
        return nodeToRemove.getElement();
    }
}
