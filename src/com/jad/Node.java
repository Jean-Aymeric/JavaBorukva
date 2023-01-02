package com.jad;

public class Node<Value> {
    private final Value value;

    public Node(final Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }
}
