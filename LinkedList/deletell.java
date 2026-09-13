public class deletell {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class LinkedList {
        Node head;

        void insertAtBegin(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void deleteAtBegin() {
            if(head==null){
                System.out.println("Empty list");
                return;
            }
            head = head.next;
        }
        void deleteAtEnd(){
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if(head.next==null){
                head = null;
                return;
            }
            Node temp = head;
            while(temp.next.next!=null){
                temp = temp.next;
            }
            temp.next = null;
        }
        void deleteAtPos(int pos) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (pos == 1) {
                head = head.next;
                return;
            }
            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) {
                System.out.println("Invalid position");
                return;
            }
            temp.next = temp.next.next;
        }
        void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBegin(10);
        list.insertAtBegin(20);
        list.insertAtBegin(30);
        list.insertAtBegin(40);
        list.insertAtBegin(50);
        list.deleteAtPos(4);
        list.deleteAtBegin();
        list.deleteAtEnd();
        list.print();
    }
}