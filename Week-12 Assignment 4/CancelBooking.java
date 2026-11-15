import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        next = null;
    }
}

public class CancelBooking {

    static Node addLast(Node head, String booking) {
        Node newNode = new Node(booking);

        if (head == null)
            return newNode;

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        if (head.data.equals(booking))
            return head.next;

        Node temp = head;

        while (temp.next != null &&
               !temp.next.data.equals(booking)) {
            temp = temp.next;
        }

        if (temp.next == null)
            System.out.println(booking + " not found");
        else
            temp.next = temp.next.next;

        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++)
            head = addLast(head, sc.next());

        String booking = sc.next();

        boolean found = false;
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data.equals(booking)) {
                found = true;
                break;
            }
        }

        head = removeFirst(head, booking);

        if (found || n == 0 && !found)
            display(head);
        else
            display(head);
    }
}
