package TIM3.DGBA.IP.Features;

import TIM3.DGBA.IP.App.Task;
import TIM3.DGBA.IP.App.TodoList;

import java.util.Scanner;

/**
 * @project TodoList
 */
public class Delete extends Actions {

    @Override
    public void info() {
        System.out.println("");
        System.out.println("Enter task ID to remove task");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter ID: ");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    Task task = TodoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("ID doesn't exist, try another ID: ");
                    }
                } else {
                    return userInput;
                }

            } catch (Exception err) {
                System.out.println("Please enter a valid ID or 0 to RETURN");
            }

        }
    }

    @Override
    public void doAction(String input) {
        TodoList.tasks.remove(input);
        System.out.println("Task with ID: " + input + ", was successfully removed...");
    }
}
