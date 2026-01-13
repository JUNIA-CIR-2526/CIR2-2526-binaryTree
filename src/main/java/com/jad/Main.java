package com.jad;

import com.jad.binarytree.BinaryTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree<>(
                List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'));
        System.out.println(binaryTree.toPrettyString());
    }
}