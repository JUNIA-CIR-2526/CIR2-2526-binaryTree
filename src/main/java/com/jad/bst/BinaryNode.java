package com.jad.bst;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PUBLIC)
public class BinaryNode<E> implements IBinaryNode<E> {
    private final int index;
    private final List<E> data = new ArrayList<>();
    @Setter(AccessLevel.PUBLIC)
    private IBinaryNode<E> left;
    @Setter(AccessLevel.PUBLIC)
    private IBinaryNode<E> right;

    public BinaryNode(final int index) {
        this.index = index;
        this.left = null;
        this.right = null;
    }

    @Override
    public void addData(final int index, final E data) {
        if (this.index == index) {
            this.data.add(data);
        } else if (index < this.index) {
            if (this.left == null) this.left = new BinaryNode<>(index);
            this.left.addData(index, data);
        } else {
            if (this.right == null) this.right = new BinaryNode<>(index);
            this.right.addData(index, data);
        }
    }

    @Override
    public boolean isIndexExist(final int index) {
        if (this.index == index) return true;
        if (index < this.index) {
            if (this.left == null) return false;
            return (this.left.isIndexExist(index));
        }
        if (this.right == null) return false;
        return (this.right.isIndexExist(index));
    }

    @Override
    public IBinaryNode<E> getParent(final int index) {
        if ((this.left != null && this.left.getIndex() == index) || (this.right != null && this.right.getIndex() == index)) {
            return this;
        }
        if (index < this.index) {
            if (this.left == null) return null;
            return (this.left.getParent(index));
        }
        if (this.right == null) return null;
        return (this.right.getParent(index));
    }

    @Override
    public String toMMDString() {
        if (this.left == null && this.right == null) return "";
        StringBuilder sb = new StringBuilder();
        if (this.left != null) {
            String temp = this.left.getData().toString();
            temp = temp.substring(1, temp.length() - 1);
            sb.append(this.index).append(" --> ").append(this.left.getIndex()).append("(").append(
                    this.left.getIndex()).append(
                    "-").append(
                    temp).append(" = ").append(this.left.getBalancingFactor()).append(")").append("\n");
            sb.append(this.left.toMMDString());
        }
        if (this.right != null) {
            String temp = this.right.getData().toString();
            temp = temp.substring(1, temp.length() - 1);
            sb.append(this.index).append(" --> ").append(this.right.getIndex()).append("(").append(
                    this.right.getIndex()).append(
                    "-").append(
                    temp).append(" = ").append(this.right.getBalancingFactor()).append(")").append("\n");
            sb.append(this.right.toMMDString());
        }
        return sb.toString();
    }

    @Override
    public int getHeight() {
        return Math.max((this.left != null) ? this.left.getHeight() : 0,
                        (this.right != null) ? this.right.getHeight() : 0) + 1;
    }

    @Override
    public int getBalancingFactor() {
        return ((this.right != null) ? this.right.getHeight() : 0) - ((this.left != null) ? this.left.getHeight() : 0);
    }

    @Override
    public boolean isBalanced() {
        final int balancingFactor = this.getBalancingFactor();
        return (balancingFactor >= -1 && balancingFactor <= 1)
                && (this.left == null || this.left.isBalanced())
                && (this.right == null || this.right.isBalanced());
    }

    public List<E> getDataListByIndex(final int index) {
        if (this.index == index) return new ArrayList<>(this.data);
        return null;
    }
}
