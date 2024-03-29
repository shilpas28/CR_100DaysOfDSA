//Leetcode - Brute force method 
//138. Copy List with Random Pointer
//Time complexity:  O(N)+O(N) - Two iterations over the entire list. Once for inserting in the map 
//and other for linking nodes with next and random pointer.
//Space complexity: O(N) - Use of hashmap for storing entire data.

package Leetcode;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;

        System.out.println("Original list:(current node:node pointed by next pointer, node pointed by random pointer)");
        printList(head);
        System.out.println("Copy list:(current node:node pointed by next pointer,node pointed by random pointer)");
        Node newHead = copyRandomList(head);
        printList(newHead);
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node temp = head;
        // first iteration for inserting deep nodes of every node in the hashmap.
        while (temp != null) {
            Node newNode = new Node(temp.val);
            hashMap.put(temp, newNode);
            temp = temp.next;
        }
        Node t = head;
        // second iteration for linking next and random pointer as given question.
        while (t != null) {
            Node node = hashMap.get(t);
            node.next = (t.next != null) ? hashMap.get(t.next) : null;
            node.random = (t.random != null) ? hashMap.get(t.random) : null;
            t = t.next;
        }
        return hashMap.get(head);
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + ":");
            if (head.next != null)
                System.out.print(head.next.val);
            else
                System.out.print("NULL");
            if (head.random != null)
                System.out.print("," + head.random.val);
            else
                System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }
}
