public class mergell {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node merge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node temp = dummy;
        while (head1 != null && head2 != null){
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        return dummy.next;
    }
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        System.out.println("List 1:");
        print(head1);
        System.out.println("List 2:");
        print(head2);
        Node result = merge(head1, head2);
        System.out.println("Merged List:");
        print(result);
    }
}