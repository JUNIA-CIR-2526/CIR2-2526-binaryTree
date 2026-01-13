package com.jad.binarytree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Node<E> {
    private E value;
    private Node<E> left;
    private Node<E> right;

    public Node(final E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String toPrettyString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.value.toString());
        if (this.left != null) stringBuilder.append("(").append(this.left.toPrettyString()).append(")");
        if (this.right != null) stringBuilder.append("[").append(this.right.toPrettyString()).append("]");
        return stringBuilder.toString();
    }
}
