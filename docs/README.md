# To-Do List App - Blarney

Welcome to **Blarney**, your friendly to-do list assistant! This app helps you manage your tasks, deadlines, and events efficiently. Below is a user guide to help you navigate through the available commands.

## Features
- Add, mark, unmark, and delete tasks.
- Schedule events with start and end times.
- Set deadlines for tasks.
- List all current tasks and events.
- Find tasks

## Available Commands

### Add a To-Do Task
To add a new task to your to-do list:
```
todo <task-to-be-added>
```
Example:
```
todo Buy groceries
```
Output:
```
Added: [T][ ] Buy groceries
```

### Mark a Task as Done
To mark a task as completed:
```
mark <index>
```
Example:
```
mark 1
```
Output:
```
I have marked task 1 as done:
[T][X] Buy groceries
```

### Unmark a Task as Not Done
To undo a completed task:
```
unmark <index>
```
Example:
```
unmark 1
```
Output:
```
I have marked task 1 as not done yet:
[T][ ] Buy groceries
```

### Delete a Task
To remove a task from the list:
```
delete <index>
```
Example:
```
delete 1
```
Output:
```
I have deleted task 1: [T][ ] Buy groceries
```

### Add an Event
To schedule an event with a start and end time:
```
event <task-to-be-added> -from <begin (dd-MM-yyyy HH:mm)> -to <end (dd-MM-yyyy HH:mm)>
```
Example:
```
event Dinner -from 01-01-2026 12:29 -to 01-01-2026 13:29
```
Output:
```
Added: [E][ ] Dinner (begins: 01-01-2026 12:29, ends: 01-01-2026 13:29), 1 hour(s) long
```

### Add a Deadline
To add a task with a deadline:
```
deadline <task-to-be-added> -by <deadline in dd-MM-yyyy HH:mm>
```
Example:
```
deadline Homework -by 01-01-2026 12:29
```
Output:
```
Added: [D][ ] Homework (due by: 01-01-2026 12:29), 300 days and 7 hours remaining
```

### List All Tasks and Events
To view all current tasks and events:
```
list
```
Example Output:
```
1. [E][ ] Dinner (begins: 01-01-2026 12:29, ends: 01-01-2026 13:29), 1 hour(s) long
2. [D][ ] Homework (due by: 01-01-2026 12:29), 300 days and 7 hours remaining
```

### Find a Task
To search for tasks or events that contain a specific keyword:
```
find <keyword>
```
Example:
```
find homework
```
Output: 
```
1. [D][ ] homework (due by: 01-01-2026 12:29), 289 days and 14 hours remaining
```

### Exit the App
To exit the application:
```
bye
```
Output:
```
Blarney blunders away
```

## Notes
- **[T]** represents a to-do task.
- **[E]** represents an event.
- **[D]** represents a deadline.
- **[X]** inside brackets means the task is completed.
- **[ ]** inside brackets means the task is pending.

## Enjoy Using Blarney!
Blarney is here to make your life easier by keeping track of your tasks and schedule. Have fun staying organized!

