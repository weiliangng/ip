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
        try {
            Scanner scanner = new Scanner(fileObj);
            while(scanner.hasNext()) {
                String input = scanner.nextLine();//assumes file is nicely formatted
                Command command = CommandParser.parseCommand(input);//makes use of all existing error checking
                command.execute(taskData);
            }
            scanner.close();
            System.out.println("history has been loaded");

        } catch (FileNotFoundException e) {
            System.out.println("Failed to find savefile, progress will not be saved");

        } catch (BlarneyException | IOException e) {
            // Print exception message to the user
            System.out.println(e.getMessage());
        }

    }

    public void saveCommand(String command) {
        try (FileWriter fileWriter = new FileWriter(fileObj, true)) { // 'true' enables append mode
            fileWriter.write(command + System.lineSeparator()); // Write command with a new line
        } catch (IOException e) {
            System.out.println("An error occurred while saving the command, command will not be saved");
        }
    }
}
