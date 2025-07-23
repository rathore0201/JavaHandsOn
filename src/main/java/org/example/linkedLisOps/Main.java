package org.example.linkedLisOps;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList =  new MyLinkedList();
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(8);
        linkedList.add(6);
        linkedList.add(5);

        linkedList.addFirst(1);
        linkedList.delete(8);
        linkedList.printValues();
    }
}
