public class insertll {
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
        void insertAtEnd(int data){
            Node newNode = new Node(data);
            if(head==null){
                head = newNode;
                return;
            }
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        void insertAtPos(int data, int pos){
            Node newNode = new Node(data);
            if(pos==1){
                newNode.next = head;
                head = newNode;
                return;
            }
            Node temp = head;
            for(int i=1;i<pos-1 && temp!=null;i++){
                temp = temp.next;
            }
            if(temp==null){
                System.out.println("Invalid position");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
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
        list.insertAtBegin(40);
        list.insertAtEnd(30);
        list.insertAtPos(60, 7);
        list.print();
    }
}