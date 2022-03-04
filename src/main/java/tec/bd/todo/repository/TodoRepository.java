package tec.bd.todo.repository;

import tec.bd.todo.Status;
import tec.bd.todo.TodoRecord;

import java.util.List;

public interface TodoRepository {

    List<TodoRecord> findAll();

    List<TodoRecord> findAll(Status status);

    TodoRecord findById(String id);

    TodoRecord save(TodoRecord todoRecord);

    void remove(TodoRecord todoRecord);

}
