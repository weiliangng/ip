import java.util.Scanner;

public class Blarney {
    public static void main(String[] args) {
        String name = "Blarney";
        Scanner scanner = new Scanner(System.in);

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
            }

            System.out.println("________________________________");
            System.out.println(" " + input);
            System.out.println("________________________________");
        }

        scanner.close();
    }
}
