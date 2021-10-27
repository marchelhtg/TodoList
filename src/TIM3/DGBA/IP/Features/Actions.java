package TIM3.DGBA.IP.Features;

/**
 * @project TodoList
 */
public abstract class Actions {

    // constant for action menu
    public static final int CREATE = 1;
    public static final int UPDATE = 2;
    public static final int MARK_DONE = 3;
    public static final int DELETE = 4;
    public static final int VIEW = 5;
    public static final int SORT_TASK = 6;
    public static final int EXIT = 0;


    // print action info
    public abstract void info();

    // read user input return string
    public abstract String readInput();

    // do action base on user action menu
    public abstract void doAction(String input);
}
