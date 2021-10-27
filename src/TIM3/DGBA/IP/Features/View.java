package TIM3.DGBA.IP.Features;

import TIM3.DGBA.IP.App.TodoList;
import TIM3.DGBA.IP.Util.Utility;

/**
 * @project TodoList
 */
public class View extends Actions {

    @Override
    public void info() {
        System.out.println("");
        System.out.println("All To do list: ");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void doAction(String input) {
        TodoList.tasks.forEach((key, task) -> {
            System.out.println("ID: " + key + ", Title: " + task.getTitle() + ", Date: "
                    + Utility.convertDateToString(task.getDate(), "dd-MM-yyyy") + ", Status: "
                    + task.getStatus() + ", Project: " + task.getDesc());
        });
    }
}
