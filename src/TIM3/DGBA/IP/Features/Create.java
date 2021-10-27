package TIM3.DGBA.IP.Features;

import TIM3.DGBA.IP.App.Task;
import TIM3.DGBA.IP.App.TodoList;
import TIM3.DGBA.IP.Util.Utility;

import java.util.Scanner;

/**
 * @project TodoList
 */
public class Create extends Actions{

    @Override
    public void info() {
        System.out.println("");
        System.out.println("Please follow the instructions below to add new task press ENTER:");
        System.out.println("ID, Title, Date (format: 13-10-2021), Status(To-Do, On Progress, Done), Description");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter Information: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(",");
                if (parts.length == 5) {
                    if (Utility.isDateValid("dd-MM-yyyy", parts[2])) {
                        if (TodoList.tasks.get(parts[0]) == null) {
                            return userInput;
                        } else {
                            System.out.println("task already exists, try again: ");
                        }
                    } else {
                        System.out.println("invalid date, try again: ");
                    }
                } else {
                    System.out.println("Please follow instructions, try again: ");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void doAction(String input) {
        String[] parts = input.split(",");
        Task task = Task.taskBuilder(parts[0], parts[1], Utility.parseDate(parts[2]),
                parts[3], parts[4]);

        TodoList.tasks.put(task.getId(), task);
        System.out.println("Task successfully added!");
    }
}
