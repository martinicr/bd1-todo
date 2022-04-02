package tec.bd.repository.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tec.bd.todo.repository.TodoRepository;
import tec.bd.todo.*;

public class TodoRepositoryMySqlImpl extends BaseRepository<TodoRecord> implements TodoRepository {


    private final static String SELECT_ALL_TODOS = "select tid, title, description, state, startdate, enddate from todorecord";
    private final static String SELECT_BY_STATUS =  "select tid, title, description, state, startdate, enddate from todorecord where state = ?";


    @Override
    public List<TodoRecord> findAll() {

        var todoRecordList = new ArrayList<TodoRecord>();

        try {
            var resultSet = this.query(SELECT_ALL_TODOS);
            while(resultSet.next()) {
                var todoRecord = toEntity(resultSet);
                if(null != todoRecord) {
                    todoRecordList.add(todoRecord);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoRecordList;
    }

    @Override
    public List<TodoRecord> findAll(Status status) {

        var todoRecordList = new ArrayList<TodoRecord>();

        try {
            var connect = this.connect();
            var statement = connect.prepareStatement(SELECT_BY_STATUS);
            statement.setString(1, status.toString().toLowerCase());
            var resultSet = this.query(statement);
            while(resultSet.next()) {
                var todoRecord = toEntity(resultSet);
                if(null != todoRecord) {
                    todoRecordList.add(todoRecord);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoRecordList;
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
    public void remove(String id) {

    }

    @Override
    public TodoRecord update(TodoRecord todoRecord) {
        return null;
    }

    @Override
    public List<TodoRecord> findByPatternInTitle(String textToSearch) {
        return null;
    }

    @Override
    public List<TodoRecord> findByBetweenStartDates(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public TodoRecord toEntity(ResultSet resultSet) {
        try {
            var todoRecord = new TodoRecord(
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    Status.valueOf(resultSet.getString("state").toUpperCase()),
                    resultSet.getDate("startdate"),
                    resultSet.getDate("enddate")
            );
            todoRecord.setId(resultSet.getString("tid"));
            return todoRecord;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
