package tec.bd.todo;

import java.util.Date;

public class TodoRecord {

    private String id;

    private String description;

    private Status status;

    public TodoRecord(String description) {
        this.description = description;
        this.status = Status.IN_PROGRESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
