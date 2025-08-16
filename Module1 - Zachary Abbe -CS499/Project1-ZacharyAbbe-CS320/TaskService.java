/*****************************
 * Name: Zachary Abbe
 * Class: CS320
 * Date: 04/12/2025
 * Desc: This contains the TaskService and maintains the tasks list and can add, update and delete tasks
 ****************************/
import java.util.ArrayList;

public class TaskService {
    public ArrayList<Task> tasklist = new ArrayList<Task>();

    //creates a task object and adds it to the Array
    public boolean addTask(Task task) {
        String id = task.getUniqId();

        // Check if task with the same ID already exists
        for (Task t : tasklist) {
            if (t.getUniqId().equalsIgnoreCase(id)) {
                System.out.println("Task with ID " + id + " already exists.");
                return false;
            }
        }

        // If ID is unique, add task to the list
        tasklist.add(task);
        return true;
    }




    //task finder by id
    public Task findTaskbyId(String id) {
        for (Task t : tasklist) {
            if (t.getUniqId().equalsIgnoreCase(id)) {
                return t;
            }
        }
        return null;
    }
    //delete task from the tasklist
    public void deleteTask(String id){
        tasklist.removeIf(t->t.getUniqId().equalsIgnoreCase(id));
    }

    //updates the Task name if id is found
     public void updateName(String id, String name){
        Task task = findTaskbyId(id);
        if (task != null){
            task.setFullName(name);
        }
        else{
            throw new IllegalArgumentException("Task not found - can't update name");
        }
     }

     //updates the task description if the id is foind
     public void updateDesc(String id, String desc){
        Task task = findTaskbyId(id);
        if (task != null){
            task.setDesc(desc);
        }
        else{
            throw new IllegalArgumentException("Task not found - can't update the description");
        }
     }

    // Getter method for test verification
    public ArrayList<Task> getTaskList() {
        return tasklist;
    }
}
