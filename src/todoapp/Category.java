
package todoapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Category {
    private String categoryName;
    
    //create a list of tasks in a cateogory 
    private List <Task> listOfTasks;

    //input name of the category 
    public Category(String name) {
        this.categoryName = name;
        this.listOfTasks = new ArrayList<>();
    }
    
    //add task to the catefory 
    public void addTask(Task task){
        this.listOfTasks.add(task);
    }
    
    //remove task from the category
    public void removeTask(Task task){
        this.listOfTasks.remove(task);
    }
    
    
    //print all the tasks in the category
    public void showAllTasks(){
        if(this.listOfTasks.size() > 0){
            for (int i = 0; i < listOfTasks.size(); i++){ 
                System.out.println((i+1) + ". " + listOfTasks.get(i).getTitle());
            }
        } else System.out.println("There is no task in this category");
    }
    
    //print how many tasks there are in the category 
    public int getTasksSize(){
        return this.listOfTasks.size();
    }

    //enter a task 
    public Task getToTask(int index){
        return listOfTasks.get(index);
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
    
}
