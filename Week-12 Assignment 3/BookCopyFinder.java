import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        next = null;
    }
}

public class BookCopyFinder {

    static Node addLast(Node head, String id) {
        Node newNode = new Node(id);

        if (head == null)
            return newNode;

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static void find(Node head, String id) {
        int pos = 1, first = -1, count = 0;

        while (head != null) {
            if (head.data.equals(id)) {
                if (first == -1)
                    first = pos;
                count++;
            }

            pos++;
            head = head.next;
        }

        if (count == 0)
            System.out.println(id + " not found");
        else
            System.out.println(id + " first at position "
                + first + ", copies: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++)
            head = addLast(head, sc.next());

        String id = sc.next();

        find(head, id);
    }
}
