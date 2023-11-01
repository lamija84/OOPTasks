package week3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

enum Status {
    TO_DO, IN_PROGRESS, COMPLETED, CANCELLED

}
public class Lab3 {
    public static void main(String[] args) {
        DataStructures taskManager = new DataStructures();

        // Example usage of methods
        System.out.println("All Tasks:");
        taskManager.getAllTasks().forEach(task -> System.out.println(task.getTaskDescription()));

        System.out.println("\nTasks In Progress:");
        taskManager.getByStatus(Status.IN_PROGRESS).forEach(task -> System.out.println(task.getTaskDescription()));

        System.out.println("\nTasks with ID >= 2:");
        taskManager.getTasksByIdGreaterThanOrEqual(2).forEach(task -> System.out.println(task.getTaskDescription()));

        System.out.println("\nTask Descriptions:");
        taskManager.printTaskDescriptions();
    }
}
    class DataStructures {
        private List<TaskItem> tasks = new ArrayList<>();

        public DataStructures() {
            tasks = Arrays.asList(
                    new TaskItem(1, "Push lab code to the github", Status.TO_DO),
                    new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                    new TaskItem(3, "Go over tasks from lab2", Status.COMPLETED));
        }

        public List<TaskItem> getAllTasks() {
            return tasks;
        }

        public List<TaskItem> getByStatus(Status taskStatus) {
            return tasks.stream()
                    .filter(task -> task.getTaskStatus() == taskStatus)
                    .collect(Collectors.toList());
        }

        public List<TaskItem> getTasksByIdGreaterThanOrEqual(int id) {
            return tasks.stream()
                    .filter(task -> task.getTaskId() >= id)
                    .collect(Collectors.toList());
        }

        public void printTaskDescriptions() {
            tasks.forEach(tasks -> System.out.println(tasks.getTaskDescription()));
        }
    }

    class TaskItem {
        private int taskId;
        private String taskDescription;
        private Status taskStatus;

        public TaskItem(int taskId, String taskDescription, Status taskStatus) {
            this.taskId = taskId;
            this.taskDescription = taskDescription;
            this.taskStatus = taskStatus;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public Status getTaskStatus() {
            return taskStatus;
        }


}
class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private Connection connection = null;


    public DbConnect() throws RuntimeException {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<TaskItem> printTasksFromDatabase(){
        List<TaskItem> tasks= new ArrayList<>();
        String query = "SELECT id, task_description, task_status FROM tasks";
        try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()) {
                int taskId = resultSet.getInt("id");
                String taskDescription = resultSet.getString("task_description");
                Status taskStatus = Status.valueOf((resultSet.getString("task_status")));
                TaskItem task= new TaskItem(taskId,taskDescription,taskStatus);
                tasks.add(task);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return tasks;
    }
    public TaskItem getTaskByIdFromDatabase(int taskId) {
        String query = "SELECT id, task_description, task_status FROM tasks WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, taskId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String taskDescription = resultSet.getString("task_description");
                Status taskStatus = Status.valueOf(resultSet.getString("task_status"));
                return new TaskItem(taskId, taskDescription, taskStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();

        // Fetch all task entities from the database.
        List<TaskItem> allTasks = dbConnect.printTasksFromDatabase();
        System.out.println("All tasks:");
        allTasks.forEach(task -> System.out.println(task.getTaskDescription()));

        // Fetch a specific task entity by its ID.
        int taskIdToFetch = 2;
        TaskItem specificTask = dbConnect.getTaskByIdFromDatabase(taskIdToFetch);
        if (specificTask != null) {
            System.out.println("\nTask with ID " + taskIdToFetch + ": " + specificTask.getTaskDescription());
        } else {
            System.out.println("\nTask with ID " + taskIdToFetch + " not found.");
        }
    }
}


