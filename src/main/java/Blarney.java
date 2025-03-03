import command.Command;
import command.CommandParser;
import exception.BlarneyException;
import task.TaskList;
import save.Store;
import java.io.IOException;
import java.util.Scanner;

import static params.Constants.SOLIDLINE;
import static params.Constants.FILEPATH;

public class Blarney {
    public static void main(String[] args) {
        // Create TaskList for holding tasks
        TaskList tasks = new TaskList();

        // Initialize the Store with file path
        Store store = new Store(FILEPATH, tasks); // Ensure file path is correct

        String name = "Blarney";
        System.out.print(SOLIDLINE);
        System.out.println("Hello! I'm " + name + "!");
        System.out.println("What can I do for you?");
        System.out.print(SOLIDLINE);

        //init filesystem and parse data

        // Runs as long as user hasn't issued 'bye' command
        boolean isRunning = true;
        while (isRunning) {
            try {
                // Reading user input through CommandParser
                System.out.println("Available Commands:\n" + "todo <task-to-be-added>, mark <index>, unmark <index>, list, bye");
                System.out.println("event <task-to-be-added> -from <begin> -to <end> eg event x -from x -to x");
                System.out.println("deadline <task-to-be-added> -by <deadline> eg deadline x -by x");
                System.out.print(SOLIDLINE);

                String input = new Scanner(System.in).nextLine().trim();
                Command command = CommandParser.parseCommand(input);

                // Execute the command
                boolean success = command.execute(tasks);

                // End loop if 'bye' command was given
                if (command instanceof command.ByeCommand) {
                    isRunning = false;
                } else if (success && command instanceof command.DeleteCommand | command instanceof command.TodoCommand | command instanceof command.DeadlineCommand | command instanceof command.EventCommand | command instanceof command.MarkCommand | command instanceof command.UnmarkCommand) {
                    store.saveCommand(input);
                }
            } catch (BlarneyException e) {
                // Print exception message to the user
                System.out.println("Something went wrong");
            }
        }
    }
}
