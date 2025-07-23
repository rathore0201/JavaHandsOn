package org.example.linkedLisOps;

public class MyLinkedList {

    ListNode head;

    public void add(int data){
        ListNode node = new ListNode(data);

        ListNode current = head;

        if(head == null){
            head = node;
        }else {
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    public void delete(int data){
        ListNode current = head;
        ListNode prev = new ListNode();
        prev.next = head;

        while(current != null){
            if(current.val == data){
                break;
            }
            current = current.next;
            prev = prev.next;
        }

        prev.next = current.next;
    }

    public void printValues(){
        ListNode current = head;

        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }
}
