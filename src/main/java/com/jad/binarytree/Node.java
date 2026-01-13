package com.jad.binarytree;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

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

    public List<E> prefix() {
        List<E> result = new ArrayList<>();
        result.add(this.value);
        if (this.left != null) result.addAll(this.left.prefix());
        if (this.right != null) result.addAll(this.right.prefix());

        return result;
    }

    public List<E> infix() {
        List<E> result = new ArrayList<>();

        if (this.left != null) result.addAll(this.left.infix());
        result.add(this.value);
        if (this.right != null) result.addAll(this.right.infix());

        return result;
    }

    public List<E> suffix() {
        List<E> result = new ArrayList<>();

        if (this.left != null) result.addAll(this.left.suffix());
        if (this.right != null) result.addAll(this.right.suffix());
        result.add(this.value);

        return result;
    }

    public List<E> byWidth() {
        List<E> result = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()) {
            Node<E> current = queue.remove();
            result.add(current.value);
            if(current.getLeft()!= null) queue.add(current.getLeft());
            if(current.getRight() != null) queue.add(current.getRight());
        }
        return result;
    }
}
