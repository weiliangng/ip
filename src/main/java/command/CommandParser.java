/**
 * The {@code CommandParser} class is responsible for parsing user input into specific command objects.
 * It takes a string input, extracts the command and arguments, and returns the appropriate command instance.
 */

package command;

import exception.BlarneyException;
import exception.BlarneyUnknownException;




public class CommandParser {
    /**
     * Parses a given input string and converts it into a corresponding {@code Command} object.
     *
     * @param input The user's input string containing the command and optional arguments.
     * @return A {@code Command} object corresponding to the parsed input.
     * @throws BlarneyException If the input does not match any known commands.
     */

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
            case "delete" -> new DeleteCommand(args);
            case "find" -> new FindCommand(args);
            default -> throw new BlarneyUnknownException();
        };
    }
}
