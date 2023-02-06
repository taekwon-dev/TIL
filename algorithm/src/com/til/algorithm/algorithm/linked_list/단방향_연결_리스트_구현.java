package com.til.algorithm.algorithm.linked_list;

public class 단방향_연결_리스트_구현 {

    static class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
        }

        void append(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        void delete(int d) {
            Node n = this;
            while (n.next != null) {
                if (n.next.data == d) {
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
        }

        void retrive() {
            Node n = this;
            while (n.next != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        // 1 -> 2 -> 3 -> 4
        head.retrive();

        head.delete(2);
        // 1 -> 3 -> 4
        head.retrive();
    }
}