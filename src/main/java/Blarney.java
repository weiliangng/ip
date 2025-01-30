import java.util.Scanner;

public class Blarney {
    public static void main(String[] args) {
        String name = "Blarney";
        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[100];
        int taskCount = 0;

        System.out.println("________________________________");
        System.out.println("Hello! I'm " + name + "!");
        System.out.println("What can I do for you?");
        System.out.println("________________________________");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("________________________________");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("________________________________");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("________________________________");
            } else {
                if (taskCount < 100) {
                    tasks[taskCount++] = input;
                    System.out.println("________________________________");
                    System.out.println("added: " + input);
                    System.out.println("________________________________");
                }
            }
        }

        scanner.close();
    }
}
