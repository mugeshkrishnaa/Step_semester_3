import java.util.*;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1;
        int front = 0, rear = -1, size = 0;

        String input = sc.useDelimiter("\\Z").next();
        String[] commands = input.split(",");

        for (String cmd : commands) {
            cmd = cmd.trim();

            if (cmd.startsWith("RETURN")) {
                String book = cmd.substring(6).trim();

                if (top == 2)
                    System.out.println(book + " rejected: pile is full");
                else {
                    stack[++top] = book;
                    System.out.println(book + " placed on pile");
                }
            }

            else if (cmd.equals("SHELVE")) {
                if (top == -1)
                    System.out.println("pile is empty");
                else
                    System.out.println("shelved " + stack[top--]);
            }

            else if (cmd.startsWith("WAIT")) {
                String student = cmd.substring(4).trim();

                if (size == 3)
                    System.out.println(student + " rejected: line is full");
                else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    size++;
                    System.out.println(student + " joined the line");
                }
            }

            else if (cmd.equals("SERVE")) {
                if (size == 0)
                    System.out.println("no one waiting");
                else {
                    System.out.println("served " + queue[front]);
                    front = (front + 1) % 3;
                    size--;
                }
            }
        }
    }
}
