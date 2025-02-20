package command;

import exception.BlarneyException;
import exception.BlarneyUnknownException;
import java.util.Scanner;

import static params.Constants.SOLIDLINE;

public class CommandParser {
    public static Command parseCommand(String input) throws BlarneyException {
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
