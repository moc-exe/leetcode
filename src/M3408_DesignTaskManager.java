import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class M3408_DesignTaskManager {


    class TaskManager {

        private class Task{

            private int userID;
            private int priority;
            private int taskID;
            private boolean valid;

            private Task(int taskID, int userID, int priority){
                valid = true; 
                this.userID = userID;
                this.priority = priority;
                this.taskID = taskID;
            }

            private Task(Task other, int newPriority){

                this.userID = other.userID;
                this.priority = newPriority;
                this.taskID = other.taskID;
                this.valid = true;
                other.valid = false;

            }
        }

        private Comparator<Task> taskComparator = new Comparator<Task>() {

        public int compare(Task t1, Task t2){

            if(t1.priority == t2.priority) return Integer.compare(t1.userID, t2.userID);
            return Integer.compare(t1.priority, t2.priority);
        }

        };

        // private HashMap<Integer, Task> userIDToTaskMap;
        private HashMap<Integer, Task> taskIDToTaskMap;
        private PriorityQueue<Task> taskQueue;
        

        public TaskManager(List<List<Integer>> tasks){

            // userIDToTaskMap = new HashMap<>();
            taskIDToTaskMap = new HashMap<>();
            taskQueue = new PriorityQueue<>(taskComparator);

            for(var task : tasks){

                int userID = task.get(0);
                int taskID = task.get(1);
                int priority = task.get(2);
        
                Task currTask = new Task(taskID, userID, priority);
        
                // userIDToTaskMap.put(userID, currTask);
                taskIDToTaskMap.put(taskID, currTask);
                taskQueue.add(currTask);
        
            }
            
        }
        
        public void add(int userId, int taskId, int priority){

            Task currTask = new Task(taskId, userId, priority);
        
            // userIDToTaskMap.put(userId, currTask);
            taskIDToTaskMap.put(taskId, currTask);
            taskQueue.add(currTask);
        }
        
        public void edit(int taskId, int newPriority) {

            Task oldTask = taskIDToTaskMap.remove(taskId);
            Task newTask = new Task(oldTask, newPriority);
            taskIDToTaskMap.put(taskId, newTask);
            taskQueue.add(newTask);

        }
        
        public void rmv(int taskId){

            Task taskToRemove = taskIDToTaskMap.remove(taskId);
            taskToRemove.valid = false;
        
        }
        
        public int execTop() {

            if(taskQueue.size() == 0) return -1;

            Task currTask = taskQueue.peek();

            while(!currTask.valid){
            
                taskQueue.poll(); // reject
                currTask = taskQueue.peek();
            
            }

            return taskQueue.poll().userID;
            
        }
    }
   

    
    
}
