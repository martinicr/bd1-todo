package tec.bd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tec.bd.controller.TodoController;

import java.util.Map;

import static spark.Spark.*;

public class Api
{
    private final static Logger LOG = LoggerFactory.getLogger(Api.class);

    public static void main( String[] args )
    {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();

        var appContext = ApplicationContext.init();
        var todoController = new TodoController(appContext.getTodo());

        options("/", (request, response) -> Map.of("message", "TODOS API V1"), gson::toJson);

        path("/api/v1/todos", () -> {
            before("/*", (q, a) -> LOG.info("Received api call"));
            get("", todoController::getAllTodos, gson::toJson);
            get("/", todoController::getAllTodos, gson::toJson);

            get("/:todo-id", todoController::getTodo, gson::toJson);

            post("", "application/json", (request, response) -> todoController.createTodoRecord(request, response), gson::toJson);

//            delete("", "application/json", (request, response) -> todoController.createTodoRecord(request, response), gson::toJson);
//
//            put("", "application/json", (request, response) -> todoController.createTodoRecord(request, response), gson::toJson);

        });


    }



}
