package org.example.linkedLisOps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOperations {

    public static ListNode getHead(LinkedList<Integer> linkedList) {
        if (linkedList.isEmpty()) {
            return null; // Return null if the list is empty
        }

        ListNode head = new ListNode(linkedList.get(0)); // Create the head node
        ListNode current = head;

        for (int i = 1; i < linkedList.size(); i++) {
            current.next = new ListNode(linkedList.get(i)); // Create and link the next node
            current = current.next;
        }

        return head; // Return the head of the ListNode chain
    }

    public boolean checkPalindromeList1(ListNode head){
        //Approach 1 : using temp array
        List<Integer> temp = new ArrayList<>();

        while(head != null) {
            temp.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = temp.size() - 1;
        while(i < j) {
            if(!temp.get(i).equals(temp.get(j))) {
                return false; // Not a palindrome
            }
            i++;
            j--;
        }
        return true; // Is a palindrome
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currt = head;

        while (currt != null){
            ListNode temp = currt.next;
            currt.next = prev;
            prev = currt;
            currt = temp;
        }

        return prev;
    }

    public boolean checkPalindromeList2(ListNode head) {
        //Approach 2 : using two pointers

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2
        }

        if(fast != null) {
            slow = slow.next; // If the list has an odd number of nodes, skip the middle node
        }

        ListNode headB = reverseList(slow);

        while(headB.next != null){
            if(head.val != headB.val){
                return false;
            }
            head = head.next;
            headB = headB.next;
        }
        return true;
    }

    public boolean checkPalindromeList3(ListNode head) {
        //Approach 2 : using two pointers without separate reverse call

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer by 2
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp; // Move slow pointer by 1
        }

        if(fast != null) {
            slow = slow.next; // If the list has an odd number of nodes, skip the middle node
        }


        while(slow != null){
            if(prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean checkPalindromeList4(ListNode head) {
        //Approach 2 : using two pointers with recursion

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer by 2
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp; // Move slow pointer by 1
        }

        if(fast != null) {
            slow = slow.next; // If the list has an odd number of nodes, skip the middle node
        }


        while(slow != null){
            if(prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
