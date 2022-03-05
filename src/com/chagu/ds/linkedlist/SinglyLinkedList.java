package com.chagu.ds.linkedlist;

public class SinglyLinkedList<T> {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(0);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        Node<Integer> fifth = new Node<>(5);
        Node<Integer> sixth = new Node<>(6);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        SinglyLinkedList<Integer> sl = new SinglyLinkedList<>();
        System.out.println("================= Before Insertion =================");
        sl.display(head);
        System.out.println("================= After Insertion =================");
        sl.insertDataAtGivenPosition(head, 5555, 4);
        sl.display(head);
//		sixth.next = third; // To check loop in the linkedlist
//		System.out.println(sl.length(head));
//		System.out.println("=======================================");
//		Node<Integer> newHead = sl.insertDataAtBegining(head, 15);
//		Node<Integer> newHead = sl.insertDataAtEnd(head, 15);
//		sl.display(newHead);
//		System.out.println(sl.containsLoop(head));
    }

    public void display(Node<T> head) {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.println("Element is : " + current.data);
            current = current.next;
        }
    }

    public int length(Node<T> head) {
        int returnValue = 0;
        Node<T> current = head;
        while (current != null) {
            returnValue++;
            current = current.next;
        }
        return returnValue;
    }

    public Node<T> insertDataAtBegining(Node<T> head, T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public Node<T> insertDataAtEnd(Node<T> head, T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            return newNode;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public Node<T> insertDataAtGivenPosition(Node<T> head, T data, int position) {
        // Handle length error
        Node<T> newNode = new Node<T>(data);
        Node<T> previousNode = head;
        int counter = 1;
        while (counter < position - 1) {
            previousNode = previousNode.next;
            counter++;
        }
        Node<T> current = previousNode.next;
        previousNode.next = newNode;
        newNode.next = current;
        return head;
    }

    // Implemented floyd cyclic finding algorithm
    public boolean containsLoop(Node<T> head) {
        if (head == null) {
            return false;
        }
        Node<T> faster = head;
        Node<T> slower = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                return true;
            }
        }
        return false;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
