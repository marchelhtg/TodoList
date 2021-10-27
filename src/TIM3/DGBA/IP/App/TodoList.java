package TIM3.DGBA.IP.App;

import TIM3.DGBA.IP.Features.*;

import java.util.*;

/**
 * @project TodoList
 */
public class TodoList {
    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean applicationRunning = true;

    public void init() {
        while (applicationRunning) {
            showAvailableActions();
            int actionNumber = readAction();
            executeActionMenu(actionNumber);
        }

    }


    public void executeActionMenu(int chosenAction) {
        Actions action;
        switch (chosenAction) {
            case Actions.CREATE -> {
                action = new Create();
                action.info();
                String command = action.readInput();
                if (!command.equals("0"))
                    action.doAction(command);
            }
            case Actions.UPDATE -> {
                if (tasks.size() > 0) {
                    action = new Update();
                    action.info();
                    String updateInput = action.readInput();
                    if (!updateInput.equals("0"))
                        action.doAction(updateInput);
                } else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
            }
            case Actions.MARK_DONE -> {
                if (tasks.size() > 0) {
                    action = new Done();
                    action.info();
                    String id = action.readInput();
                    if (!id.equals("0"))
                        action.doAction(id);

                } else {
                    System.out.println("Your List is empty, add tasks first! ");

                }
            }
            case Actions.DELETE -> {
                if (tasks.size() > 0) {
                    action = new Delete();
                    action.info();
                    String id = action.readInput();
                    if (!id.equals("0"))
                        action.doAction(id);
                } else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
            }
            case Actions.VIEW -> {
                if (tasks.size() > 0) {
                    action = new View();
                    action.info();
                    action.doAction(null);
                } else {
                    System.out.println("Empty task");
                }
            }

            case Actions.SORT_TASK -> {
                action = new Sorting();
                action.doAction(null);
            }

            case Actions.EXIT -> {
                applicationRunning = false;
            }
        }
    }


    // show available action for user
    public void showAvailableActions() {
        System.out.println("");
        System.out.println("1. Add a task");
        System.out.println("2. Edit task");
        System.out.println("3. Mark task as done");
        System.out.println("4. Remove task");
        System.out.println("5. Display all tasks");
        System.out.println("6. Sort tasks by status");
        System.out.println("0. Exit");
        System.out.println("");
    }

    // read user action
    public int readAction() {
        List<Integer> availableActions = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        while (true) {
            try {
                System.out.print("Enter action: ");
                Scanner scan = new Scanner(System.in);
                int action = scan.nextInt();
                if (availableActions.contains(action)) {
                    return action;
                } else {
                    System.out.println("Please enter a valid action from list ");
                }
            } catch (Exception e) {
                System.out.println("Action must be a number...");

            }
        }
    }

}
