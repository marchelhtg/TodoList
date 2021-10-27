package TIM3.DGBA.IP.Features;

import TIM3.DGBA.IP.App.Task;
import TIM3.DGBA.IP.App.TodoList;

import java.util.Scanner;

/**
 * @project TodoList
 */
public class Done extends Actions {

    @Override
    public void info() {
        System.out.println("");
        System.out.println("Enter ID to mark Done task and press ENTER: ");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter task id: ");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    Task task = TodoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("There is no task with this ID, try again: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception err) {
                System.out.println("Enter a valid ID or 0 to RETURN");
            }
        }
    }

    @Override
    public void doAction(String input) {
        TodoList.tasks.get(input).setStatus("Done");
        System.out.println("Status is set as Done for the task with ID: " + input);
    }
}
