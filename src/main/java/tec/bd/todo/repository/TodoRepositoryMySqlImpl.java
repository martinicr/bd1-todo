package tec.bd.todo.repository;

import tec.bd.todo.Status;
import tec.bd.todo.TodoRecord;

import java.util.List;

public class TodoRepositoryMySqlImpl implements TodoRepository {

    @Override
    public List<TodoRecord> findAll() {
        return null;
    }

    @Override
    public List<TodoRecord> findAll(Status status) {
        return null;
    }

    @Override
    public TodoRecord findById(String id) {
        return null;
    }

    @Override
    public TodoRecord save(TodoRecord todoRecord) {
        return null;
    }

    @Override
    public void remove(TodoRecord todoRecord) {

    }
}
