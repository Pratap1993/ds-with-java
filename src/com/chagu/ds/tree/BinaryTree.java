package com.chagu.ds.tree;

import com.chagu.ds.nodes.TreeNode;

import java.util.Stack;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public static BinaryTree<Integer> getSampleTree() {
        TreeNode<Integer> first = new TreeNode<>(1);
        TreeNode<Integer> second = new TreeNode<>(2);
        TreeNode<Integer> third = new TreeNode<>(3);
        TreeNode<Integer> fourth = new TreeNode<>(4);
        TreeNode<Integer> fifth = new TreeNode<>(5);
        TreeNode<Integer> sixth = new TreeNode<>(6);
        TreeNode<Integer> seventh = new TreeNode<>(7);

        first.setLeftNode(second);
        first.setRightNode(third);
        second.setLeftNode(fourth);
        second.setRightNode(fifth);
        third.setLeftNode(sixth);
        third.setRightNode(seventh);
        BinaryTree<Integer> bTree = new BinaryTree<>();
        bTree.setRoot(first);
        return bTree;
    }

    public static void main(String[] args) {
        int a = BinaryTree.getSampleTree().getRoot().getLeftNode().getRightNode().getData();
        System.out.println("Data : " + a);
        BinaryTree<Integer> i = new BinaryTree<>();
        i.preOrderRecursive(BinaryTree.getSampleTree().getRoot());
        System.out.println("=====================================");
        i.postOrderRecursive(BinaryTree.getSampleTree().getRoot());

    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public void preOrderRecursive(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println("Data in Pre_Order : " + root.getData());
        preOrderRecursive(root.getLeftNode());
        preOrderRecursive(root.getRightNode());
    }

    public void preOrderIterative(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>(); // Can be changed to custom stack
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> temp = stack.pop();
            System.out.println("Data in Pre_Order : " + temp.getData());
            if (temp.getRightNode() != null) {
                stack.push(temp.getRightNode());
            }
            if (temp.getLeftNode() != null) {
                stack.push(temp.getLeftNode());
            }
        }
    }

    public void inOrderRecursive(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.getLeftNode());
        System.out.println("Data in In_Order : " + root.getData());
        inOrderRecursive(root.getRightNode());
    }

    public void inOrderIterative(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.getLeftNode();
            } else {
                temp = stack.pop();
                System.out.println("Data in In_Order : " + temp.getData());
                temp = temp.getRightNode();
            }
        }
    }

    public void postOrderRecursive(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.getLeftNode());
        postOrderRecursive(root.getRightNode());
        System.out.println("Data in In_Order : " + root.getData());
    }

}
