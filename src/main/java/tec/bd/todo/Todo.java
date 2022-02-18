package tec.bd.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Todo {

    private List<TodoRecord> todoRepository;

    public Todo() {
        this.todoRepository = new ArrayList<>();
    }

    public List<TodoRecord> getAll() {
        return this.todoRepository;
    }

    public TodoRecord add(TodoRecord record) {
        record.setId(UUID.randomUUID().toString());
        this.todoRepository.add(record);
        return record;
    }

}
