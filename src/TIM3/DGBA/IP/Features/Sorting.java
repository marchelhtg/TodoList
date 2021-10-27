package TIM3.DGBA.IP.Features;

import TIM3.DGBA.IP.App.Task;
import TIM3.DGBA.IP.App.TodoList;

import java.util.*;

/**
 * @project TodoList
 */
public class Sorting extends Actions {

    @Override
    public void info() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void doAction(String input) {
        List<Map.Entry<String, Task>> entries = new ArrayList<>(TodoList.tasks.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Task>>() {
            @Override
            public int compare(Map.Entry<String, Task> firstTask, Map.Entry<String, Task> secondTask) {
                String s1 = firstTask.getValue().getStatus();
                String s2 = secondTask.getValue().getStatus();

                return s2.compareTo(s1);
            }
        });

        TodoList.tasks.clear();
        entries.forEach(entry -> {
            TodoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Tasks successfully sorted");
    }
}
