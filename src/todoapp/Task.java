
package todoapp;

public class Task {
    
    private String title;
    private String status;
    private int progress;
    private String date;

    
    //input task title 
    public Task(String title) {
        this.title = title;
    }

    //input title, status, progress, due date of a task
    public Task(String title, String status, int progress, String date) {
        this.title = title;
        this.status = status;
        this.progress = progress;
        this.date = date;
    }
    
    
    //Getters for title,status, progress, due date
    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public int getProgress() {
        return progress;
    }

    public String getDate() {
        return date;
    }
    
    
    //Setters  for title, status, progress, due date
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    //prints out all the properties of a task 
    public void showAllProperties(){
        System.out.println("Title: " + this.title);
        System.out.println("Status: " + this.status);
        System.out.println("Progress: " + this.progress);
        System.out.println("Due Date: " + this.date);
    }
    
}
