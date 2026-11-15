import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        next = null;
    }
}

public class PlateStack {

    static Node top = null;
    static int size = 0;

    static void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate +
            " -> top " + top.data + ", size " + size);
    }

    static void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }

        System.out.println("pop -> " + top.data +
            ", size " + (size - 1));

        top = top.next;
        size--;
    }

    static void peek() {
        if (isEmpty())
            System.out.println("peek -> stack is empty");
        else
            System.out.println("peek -> " + top.data);
    }

    static boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder input = new StringBuilder();

        while (sc.hasNextLine())
            input.append(sc.nextLine()).append(" ");

        String[] commands = input.toString().split(",");

        for (String command : commands) {
            command = command.trim();

            if (command.startsWith("push")) {
                String plate = command.substring(4)
                    .replace("(", "")
                    .replace(")", "").trim();

                push(plate);
            }

            else if (command.equals("pop")) {
                pop();
            }

            else if (command.equals("peek")) {
                peek();
            }

            else if (command.equals("isEmpty")) {
                System.out.println("isEmpty -> " + isEmpty());
            }
        }
    }
}
