package tec.bd;

import tec.bd.todo.Todo;
import tec.bd.todo.TodoRecord;
import tec.bd.todo.repository.TodoRepository;
import tec.bd.todo.repository.TodoRepositoryListImpl;
import tec.bd.todo.repository.TodoRepositoryMySqlImpl;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {


    private static List<TodoRecord> todoRecordList = new ArrayList<>();
    private TodoRepository todoRepositoryListImpl;

    private TodoRepository todoRepositoryMySqlImpl;

    private Todo todo;

    private ApplicationContext() {

    }

    public static ApplicationContext init() {

        var appContext = new ApplicationContext();
        appContext.todoRepositoryListImpl = initTodoRepositoryListImpl();
        appContext.todoRepositoryMySqlImpl = initTodoRepositoryMySqlImpl();
        appContext.todo = initTodo(appContext.todoRepositoryListImpl);
        return appContext;
    }

    private static TodoRepository initTodoRepositoryListImpl() {
        return new TodoRepositoryListImpl(todoRecordList);
    }

    private static TodoRepository initTodoRepositoryMySqlImpl() {
        return new TodoRepositoryMySqlImpl();
    }

    private static Todo initTodo(TodoRepository todoRepository) {
        return new Todo(todoRepository);
    }

    public Todo getTodo() {
        return this.todo;
    }
}
