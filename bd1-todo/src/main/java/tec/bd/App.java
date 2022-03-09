package tec.bd;


import tec.bd.todo.TodoRecord;

public class App
{
    public static void main(String... args )
    {

        var appContext = ApplicationContext.init();
        var todo = appContext.getTodo();

        todo.add(new TodoRecord("Desayuno"));
        todo.add(new TodoRecord("Almuerzo"));
        todo.add(new TodoRecord("Cena"));

        var todos = todo.getAll();

        for (TodoRecord r: todos) {
            System.out.println(r.getId() + " - " + r.getDescription() + " - " + r.getStatus());
        }
    }
}
