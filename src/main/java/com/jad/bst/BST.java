package com.jad.bst;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BST<E> implements IBinaryNode<E> {
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private BinaryNode<E> root;

    public BST() {
        this.root = null;
    }

    public void addData(final int index, final E data) {
        if (this.root == null) this.root = new BinaryNode<>(index);
        this.root.addData(index, data);
    }

    @Override
    public boolean isIndexExist(final int index) {
        return this.root != null && this.root.isIndexExist(index);
    }

    @Override
    public int getIndex() {
        return (this.root != null) ? this.root.getIndex() : 0;
    }

    @Override
    public List<E> getData() {
        return (this.root != null) ? this.root.getData() : null;
    }

    @Override
    public IBinaryNode<E> getLeft() {
        return (this.root != null) ? this.root.getLeft() : null;
    }

    @Override
    public void setLeft(final IBinaryNode<E> left) {
        if (this.root != null) this.root.setLeft(left);
    }

    @Override
    public IBinaryNode<E> getRight() {
        return (this.root != null) ? this.root.getRight() : null;
    }

    @Override
    public void setRight(final IBinaryNode<E> right) {
        if (this.root != null) this.root.setRight(right);
    }

    public IBinaryNode<E> getParent(final int index) {
        if (this.root != null && this.root.getIndex() == index) return this;
        return (this.root != null) ? this.root.getParent(index) : null;
    }

    @Override
    public String toMMDString() {
        return this.root.toMMDString();
    }

    @Override
    public int getHeight() {
        return (this.root == null) ? 0 : this.root.getHeight();
    }

    @Override
    public int getBalancingFactor() {
        return (this.root == null) ? 0 : this.root.getBalancingFactor();
    }

    @Override
    public boolean isBalanced() {
        return this.root == null || this.root.isBalanced();
    }

    public void toMMDFile(final String fileName) {
        if (this.root == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append("graph TD\n");
        String temp = this.root.getData().toString();
        temp = temp.substring(1, temp.length() - 1);
        sb.append("START -->").append(this.root.getIndex()).append("(").append(this.root.getIndex()).append("-").append(
                temp).append(" = ").append(this.getBalancingFactor()).append(")").append("\n");
        sb.append(this.root.toMMDString());
        sb.append("\n");
//        sb.append("classDef red fill:#ff4d4d,stroke:#b30000,color:#fff;");
//        sb.append("class ");
//        sb.append(" rouge;");
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
