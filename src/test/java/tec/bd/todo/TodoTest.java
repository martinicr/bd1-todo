package tec.bd.todo;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TodoTest {

    @Test
    public void addTodoRecord() throws Exception {

        Todo todo = new Todo();
        TodoRecord todoRecord = new TodoRecord("Tomar desayuno");
        var actual = todo.add(todoRecord);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getDescription()).isEqualTo("Tomar desayuno");
    }

    @Test
    public void listTodos() throws Exception {

        Todo todo = new Todo();
        TodoRecord desayuno = new TodoRecord("Tomar desayuno");
        TodoRecord almuerzo = new TodoRecord("Hacer almuerzo");
        todo.add(desayuno);
        todo.add(almuerzo);

        var actual = todo.getAll();

        assertThat(actual.size()).isEqualTo(2);

    }

}
