package com.jad.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
    private Node<E> root;
    public List<E> prefix() {
        if (this.root == null) return new ArrayList<>();
        return this.root.prefix();
    }

    public List<E> infix() {
        if (this.root == null) return new ArrayList<>();
        return this.root.infix();
    }

    public List<E> suffix() {
        if (this.root == null) return new ArrayList<>();
        return this.root.suffix();
    }

    public List<E> byWidth() {
        if(this.root == null) return new ArrayList<>();
        return this.root.byWidth();
    }

    public BinaryTree(final List<E> values) {
        if (values == null || values.isEmpty()) {
            this.root = null;
        } else {
            this.root = this.buildNodesFromList(values, 0);
        }
    }

    private Node<E> buildNodesFromList(final List<E> values, final int index) {
        if (index >= values.size()) return null;
        Node<E> node = new Node<>(values.get(index));
        node.setLeft(this.buildNodesFromList(values, 2 * index + 1));
        node.setRight(this.buildNodesFromList(values, 2 * index + 2));
        return node;
    }

    public String toPrettyString() {
        if (this.root == null) return "";
        return this.root.toPrettyString();
    }
}
