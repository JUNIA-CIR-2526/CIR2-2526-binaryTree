package com.jad.bst;

import java.util.List;

public interface IBinaryNode<E> {
    void addData(int index, E data);

    boolean isIndexExist(int index);

    int getIndex();

    List<E> getData();

    IBinaryNode<E> getLeft();

    void setLeft(IBinaryNode<E> left);

    IBinaryNode<E> getRight();

    void setRight(IBinaryNode<E> right);

    IBinaryNode<E> getParent(int index);

    String toMMDString();

    int getHeight();

    int getBalancingFactor();

    boolean isBalanced();
}
