package TIM3.DGBA.IP.Features;

import TIM3.DGBA.IP.App.TodoList;
import TIM3.DGBA.IP.Util.Utility;

import java.util.Scanner;

/**
 * @project TodoList
 */
public class Update extends Actions {

    @Override
    public void info() {
        System.out.println("");
        System.out.println("Follow the instructions and press ENTER: ");
        System.out.println("ID, Title, Date (format: 13-10-2021), Status(To-Do, On Progress, Done), Description");
        System.out.println("ID here represent the ID of the task where an update will occur");
        System.out.println("insert a (-) when an update is not needed to that specific parameter");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter information : ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(",");
                if (parts.length == 5) {
                    boolean dateValidationRequired = true;
                    if (parts[2].equals("-")) {
                        dateValidationRequired = false;
                    }

                    boolean isDateValid = true;
                    if (dateValidationRequired) {
                        System.out.println(parts[2]);
                        isDateValid = Utility.isDateValid("dd-MM-yyyy", parts[2]);
                    }

                    if (isDateValid) {
                        if (TodoList.tasks.get(parts[0]) != null) {
                            return userInput;
                        } else {
                            System.out.println("ID doesn't exist, try again: ");
                        }
                    } else {
                        System.out.println("Please follow instructions or enter 0 to RETURN");
                    }
                } else {
                    return userInput;
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void doAction(String input) {
        String[] parts = input.split(",");

        boolean isTaskEdited = false;
        if (!parts[1].equals("-")) {
            TodoList.tasks.get(parts[0]).setTitle(parts[1]);
            isTaskEdited = true;
        }

        if (!parts[2].equals("-")) {
            TodoList.tasks.get(parts[0]).setDate(Utility.parseDate(parts[2]));
            isTaskEdited = true;
        }

        if (!parts[3].equals("-")) {
            TodoList.tasks.get(parts[0]).setStatus(parts[3]);
            isTaskEdited = true;
        }

        if (!parts[4].equals("-")) {
            TodoList.tasks.get(parts[0]).setDesc(parts[4]);
            isTaskEdited = true;
        }

        if (isTaskEdited) {
            System.out.println("Tasks successfully updated!!");
        } else {
            System.out.println("No change was applied...");
        }
    }
}
