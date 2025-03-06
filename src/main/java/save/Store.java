package save;

import command.Command;
import command.CommandParser;
import exception.BlarneyException;
import task.Task;
import task.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Store {
    protected String filePath; // Relative path
    protected File fileObj;
    protected TaskList taskData;


    public Store(String filePath, TaskList taskData) {
        this.filePath = filePath;
        File fileObj = new File(filePath);
        this.fileObj = fileObj;
        this.taskData = taskData;

        // Create file if it does not exist
        if (!fileObj.exists()) {
            try {
                fileObj.getParentFile().mkdirs(); // Create parent directories if needed
                if (fileObj.createNewFile()) {
                    System.out.println("File created: " + filePath);
                } else {
                    System.out.println("Failed to create savefile, progress will not be saved");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file, progress will not be saved");
            }
        }

        //assert file should be created by now
        //read the document and call
        Scanner scanner = null;

        try {
            scanner = new Scanner(fileObj);
        } catch (FileNotFoundException e) {
            throw new BlarneyException("Failed to find savefile, progress will not be saved");
        }

        while (scanner.hasNext()) {
            String input = scanner.nextLine(); // Assumes file is nicely formatted
            try {
                Command command = CommandParser.parseCommand(input); // Makes use of all existing error checking
                command.execute(taskData);
            } catch (BlarneyException e) {
                // Print exception message to the user but continue processing the next lines
                System.out.println("Error processing line: " + input + ", " + e.getMessage() + " \nSkipping to the next line.");

            }
        }

        scanner.close();
        System.out.println("History has been loaded");


    }

    public void saveCommand(String command) {
        try (FileWriter fileWriter = new FileWriter(fileObj, true)) { // 'true' enables append mode
            fileWriter.write(command + System.lineSeparator()); // Write command with a new line
        } catch (IOException e) {
            throw new BlarneyException("An error occurred while saving the command, command will not be saved");
        }
    }
}
