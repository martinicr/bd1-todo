package tec.bd.todo;

import tec.bd.todo.repository.TodoRepository;

import java.util.List;

public class Todo {

    private TodoRepository todoRepository;

    public Todo(TodoRepository todoRepo) {
        this.todoRepository = todoRepo;
    }

    public List<TodoRecord> getAll() {
        return this.todoRepository.findAll();
    }

    public List<TodoRecord> getAll(Status status) {
        return this.todoRepository.findAll(status);
    }

    public TodoRecord getById(String id) {
        // TODO: validar que el id no sea nulo y si es nulo lanzar una excepcion
        return this.todoRepository.findById(id);
    }

    public TodoRecord add(TodoRecord record) {
        // TODO: validar si el TodoRecord es valido
        return this.todoRepository.save(record);
    }

    public void delete(TodoRecord record) {
//        var elementToDelete = this.getById(record.getId());
//        if (null != elementToDelete) {
//            this.todoRepository.remove(elementToDelete);
//        }
        // TODO: buscar si el record existe, y si existe borrarlo
        this.todoRepository.remove(record);
    }

}
