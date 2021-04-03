package com.selenium;

public class LList implements IList {

    int size;
    Node head;

    public static class Node {
        Object data;
        Node next;
    }

    @Override
    public  void clear() {
        Node node = head;
        while (node != null) {
            node.data = null;
            node = node.next;
        }
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public int get(int index){
            if (index > size) {
                System.out.println("No such index in the list");
                return 0;
            }
            Node node = head;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            return (Integer) node.data;
        }


        @Override
    public boolean add (int value) {
        Node node = new Node();
        node.data = value;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int value) {
            if (index > size()) {
                System.out.println("No such index in the list");
                return false;
            }
            Node current = head;
            int position = 0;
            Node node = new Node();
            node.data = value;
            if (index == 0) {
                node.next = head; // ???
                head = node;
                size++;
                return true;
            }
            while (current.next != null) {
                if (position == index - 1) {
                    break;
                }
                position++;
                current = current.next;
            }
            node.next = current.next; // ???
            current.next = node;
            size++;
            return true;
        }

        @Override
    public int remove(int number) {
            Node node = head;
            int temp = 0;
            for (int i = 1; i < size; i++) {
                node = node.next;
                if (number == (int) node.data) {
                    temp = i;
                    break;
                }
            }
            Node nodePrev = head;
            Node nodeNext = head;

            for (int i = 0; i < temp - 1; i++) {
                nodePrev = nodePrev.next;
            }
            for (int i = 0; i < temp; i++) {
                nodeNext = nodeNext.next;
            }
            nodePrev.next = nodeNext.next;
            return size--;
        }

        @Override
    public int removeByIndex(int index) {
            if (index > size) {
                System.out.println("No such index in the list");
            }
            Node nodePrev = head;
            Node nodeNext = head;
            if (index == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    nodePrev = nodePrev.next;
                }
                for (int i = 0; i < index; i++) {
                    nodeNext = nodeNext.next;
                }
                nodePrev.next = nodeNext.next;

            } return size--;
        }


    @Override
    public boolean contains(int value) {
        Node current = head;
        while (current.next != null) {
            if((Integer) current.data == value) {
                return true;
            } current = current.next;
        } return false;
    }

    @Override
    public boolean set(int index, int value){
        if (index > size) {
            System.out.println("No such index in the list");
        }
        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        node.data = value;
        return true;
    }


    @Override
    public void print() {
        Node n = head;
        while (n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.print(n.data);
    }

    @Override
    public int[] toArray() {
        Node current = head;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            if (current.data != null) {
                array[i] = (int) current.data;
                current = current.next;
            } else {
                array = new int []{};
            }
        }
        return array;
    }

    @Override
    public boolean removeAll(int[] ar) {
        Node current = head;
        Node helper = head;
        int temp = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int y = 0; y < size; y++) {
                current = current.next;
                if (ar[i] == (int) current.data) {
                    temp = i;
                    break;
                }
            }
            for (int z = 0; z < size; z++) {
                helper = helper.next;
                if (ar[temp] == (int) helper.data) {
                    Node nodePrev = head;
                    Node nodeNext = head;
                    for (int j = 0; j < temp; j++) {
                        nodePrev = nodePrev.next;
                    }
                    for (int x = 0; x < temp + 1; x++) {
                        nodeNext = nodeNext.next;
                    }
                    nodePrev.next = nodeNext.next;
                    size--;
                }
            }
        }
        return true;
}
    }
