package TIM3.DGBA.IP.App;

import TIM3.DGBA.IP.Util.Utility;

import java.time.LocalDate;

/**
 * @project TodoList
 */
public class Task {
    private String id;
    private String title;
    private LocalDate date;
    private String status;
    private String Desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }


    public static Task taskBuilder(String id, String title, LocalDate date, String status, String desc) {
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDate(date);
        task.setStatus(status);
        task.setDesc(desc);

        return task;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + Utility.convertDateToString(date, "dd-MM-yyyy") + "," + status + "," + Desc;
    }
}
