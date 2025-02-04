import command.Command;
import command.CommandParser;
import exception.BlarneyException;
import task.TaskList;

import java.io.IOException;
import java.util.Scanner;

import static params.Constants.SOLIDLINE;

public class Blarney {
    public static void main(String[] args) {
        // Create TaskList for holding tasks
        TaskList tasks = new TaskList();

        String name = "Blarney";
        System.out.print(SOLIDLINE);
        System.out.println("Hello! I'm " + name + "!");
        System.out.println("What can I do for you?");
        System.out.print(SOLIDLINE);

        // Runs as long as user hasn't issued 'bye' command
        boolean isRunning = true;
        while (isRunning) {
            try {
                // Reading user input through CommandParser
                Command command = CommandParser.getCommand(new Scanner(System.in));

                // Execute the command
                command.execute(tasks);

                // End loop if 'bye' command was given
                if (command instanceof command.ByeCommand) {
                    isRunning = false;
                }
            } catch (BlarneyException | IOException e) {
                // Print exception message to the user
                System.out.println(e.getMessage());
            }
        }
    }
}
