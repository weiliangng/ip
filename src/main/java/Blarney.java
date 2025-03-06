
/**
 * The {@code Blarney} class is the main entry point for the task management application.
 * It initializes the task list, loads previous task history, and continuously processes user commands
 * until the user issues the "bye" command to exit.
 */
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

    /**
     * The main method that starts the application.
     * It initializes the task list, loads saved data, and continuously listens for user commands.
     *
     * @param args Command-line arguments (not used in this application).
     */
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
                System.out.println("event <task-to-be-added> -from <begin (in dd-MM-yyyy HH:mm)> -to <end (in dd-MM-yyyy HH:mm)> eg event x -from 01-01-2026 12:29 -to 01-01-2026 13:29");
                System.out.println("deadline <task-to-be-added> -by <deadline in dd-MM-yyyy HH:mm> eg deadline x -by 01-01-2026 12:29");
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
