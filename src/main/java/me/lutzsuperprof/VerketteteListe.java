package me.lutzsuperprof;

public class VerketteteListe {//Implement a linked list

    private Node head;
    private Node tail;
    private int size;

    public void listInsertFirst(int value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    //List insert first method

    //List insert last method
    public void listInsertLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public int listFirst() {
        return head.getValue();
    }

    public int listLast() {
        return tail.getValue();
    }

    public int listSize() {
        return size;
    }

    public boolean listDelete(int value) {
        //remove first apperance of value
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.getValue() == value) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public int listSearch(int value) {
        //return the index of the first apperance of value
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getValue() == value) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    private class Node {
        //a node has a value and a pointer to the next node
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}
