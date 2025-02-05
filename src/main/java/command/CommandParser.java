package command;

import exception.BlarneyException;
import exception.BlarneyUnknownException;
import java.util.Scanner;

import static params.Constants.SOLIDLINE;

public class CommandParser {
    public static Command getCommand(Scanner scanner) throws BlarneyException {
        System.out.println("Available Commands:\n" +
                "todo <task-to-be-added>, mark <index>, unmark <index>, list, bye");
        System.out.println("event <task-to-be-added> -from <begin> -to <end> eg event x -from x -to x");
        System.out.println("deadline <task-to-be-added> -by <deadline> eg deadline x -by x");
        System.out.print(SOLIDLINE);
        String input = scanner.nextLine().trim();
        String[] commands = input.split(" ", 2); // Split into command and arguments

        String command = commands[0].toLowerCase();
        String args = (commands.length > 1) ? commands[1] : "";

        return switch (command) {
            case "todo" -> new TodoCommand(args);
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(args);
            case "unmark" -> new UnmarkCommand(args);
            case "bye" -> new ByeCommand();
            case "event" -> new EventCommand(args);
            case "deadline" -> new DeadlineCommand(args);
            default -> throw new BlarneyUnknownException();
        };
    }
}
