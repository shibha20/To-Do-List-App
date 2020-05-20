
/*
    The app will first print the categories of tasks users can add their tasks to. It will let users to add/delete/enter a category.
    Once the user selects a category, our app will let users add tasks to that category. It will let them delete a pre-existing task
    in that category. Once they create a new task or select a  pre-existing task, the app will let them update/change 
    name/progres/status/due date of the task. The user can return to
    the menu or exit from the app when inside a category or a task. 

    @author Dung T Nguyen
    @author Shilpa Bhandari
*/

package todoapp;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ToDoApp {
    
   
    public static void main(String[] args) {
        ListOfCategories listOfCategories = new ListOfCategories();
             startApplication(listOfCategories);
       
    }
    
    //method called to start the application 
    private static void startApplication(ListOfCategories listOfCategories){
        //printing all the categories after the application starts 
        listOfCategories.showAllCategories();
        Scanner sc = new Scanner(System.in);
        //input whether user wants to remove/add/enter a category 
        int userActions = setUpToDoAppActions(sc);
        
        //call the method that lets user remove/add/enter a category based on their choice 
        choosingActions(userActions, listOfCategories, sc);
    }
    
    
    //method to let user remove/add/enter a category based on their choice
    private static void choosingActions(int userActions, ListOfCategories listOfCategories, Scanner sc){
        switch(userActions){
            case 0: 
                break;
            case 1: //Go to a category
                listOfCategories.showAllCategories();
                System.out.print("Type the index of the category that you want to go to: ");
                int categoryIndex = inputFromUsers(sc) - 1;
                if(categoryIndex < listOfCategories.categoriesSize() && categoryIndex >= 0){
                    //getting into the category user wants to enter 
                    Category category = listOfCategories.getToCategory(categoryIndex);
                    //calling a method that lets  the user input where they wish to add/remove/enter a task in that category 
                    int actionNumber = setUpCategoryActions(category, sc);
                    
                    //calling a method that lets the user add/remove/enter a task in the category 
                    choosingCategoryActions(actionNumber, listOfCategories,category, sc);
                } else {
                    System.out.println("The index does not exist! Try again!");
                    System.out.println("");
                    choosingActions(userActions, listOfCategories, sc);
                }
                break;
            case 2: //Add a Category
                System.out.println("------Create a new Category------");
                
                //inputting name of a new category
                System.out.print("Title of the category: ");
                sc.nextLine();
                String name = sc.nextLine();
                
                //adding the new category to the list of categories
                listOfCategories.addCategory(new Category(name));
                System.out.println("");
                //printing all the categories after addition of the new one 
                listOfCategories.showAllCategories();
                
                //calling method to let user input if they want to add/remove/enter into a category 
                int action = setUpToDoAppActions(sc);
                
                //calling the method to let user remove/add/enter a category based on their choice
                choosingActions(action, listOfCategories, sc);
                break;
            case 3: //Remove a Category
                
                //print all the pre-existing categories
                listOfCategories.showAllCategories();
                
                //input index of the category that the user wants to remove 
                System.out.print("Type the index of the category that you want to Delete: ");
                int categoryIndexForDeletion = inputFromUsers(sc) - 1;
                
                if(categoryIndexForDeletion < listOfCategories.categoriesSize() && categoryIndexForDeletion >= 0){
                    Category category = listOfCategories.getToCategory(categoryIndexForDeletion);
                    String categoryNameForDeletion = category.getCategoryName();
                    //remove the category based on category index inputted the user 
                    listOfCategories.removeCategory(category);
                    //print success messafe 
                    System.out.println(categoryNameForDeletion + " has been removed");
                    System.out.println("");
                    //show the updated list of categories 
                    listOfCategories.showAllCategories();
                    
                    //calling method to let user input if they want to add/remove/enter into a category 
                    int userAction = setUpToDoAppActions(sc);
                    
                    //calling the method to let user remove/add/enter a category based on their choice
                    choosingActions(userAction, listOfCategories, sc);
                } else {
                    System.out.println("The index does not exist! Try again!");
                    System.out.println("");
                    choosingActions(userActions, listOfCategories, sc);
                }
                break;
            case 4: //Go back to main menu
                startApplication(listOfCategories);
                break;
          
            default: 
                System.out.println("You didn't enter the right thing!");
                System.out.println("Try again!");
                int num = inputFromUsers(sc);
                choosingActions(num, listOfCategories, sc);
                break;
        }
    }
    
    //method to let user input if they want to add/remove/enter into a category 
    private static int setUpToDoAppActions(Scanner sc){
        System.out.println("");
        System.out.println("Exit -- Enter 0");
        System.out.println("Get into a category -- Enter 1");
        System.out.println("Add a category -- Enter 2");
        System.out.println("Remove category -- Enter 3");
        System.out.println("Go back to main menu -- Enter 4");
        System.out.println("");
        System.out.print("Your actions: ");
        
        int userActions = inputFromUsers(sc);
        return userActions;
    }
    
    //method to input whether a user wants add/remove/enter a task after entering a  category 
    public static int setUpCategoryActions(Category category, Scanner sc){
        System.out.println("==========" + category.getCategoryName() + "==========");
        category.showAllTasks();
        System.out.println();

        if(category.getTasksSize() != 0){
            System.out.println("Enter 0 to exit");
            System.out.println("Enter 1 to go to a Task");
            System.out.println("Enter 2 to add a Task");
            System.out.println("Enter 3 to remove a Task");
            System.out.println("Enter 4 to go back to main menu");
            System.out.println("");
            System.out.print("Your actions: ");
        }

        int action;
        if(category.getTasksSize() != 0){
            action = inputFromUsers(sc);
        } else action = 2;
        
        return action;
    }
    
    //method to let user add/remove/enter a task based on users choice 
    private static void choosingCategoryActions(int actionNumber, ListOfCategories listOfCategories,Category category, Scanner sc){
        switch(actionNumber){
            case 0: 
                break;
            case 1: //Go to a task
                if(category.getTasksSize() != 0){
                    System.out.print("Type the index of the task that you want to go to: ");
                    int taskIndex = inputFromUsers(sc) - 1;
                    if(taskIndex < category.getTasksSize()  && taskIndex >= 0){
                        Task task = category.getToTask(taskIndex);
                        int actionNum = setUpTaskActions(task, sc);
                        choosingTaskActions(actionNum, listOfCategories,sc,task);
                    }
                }
                break;
            case 2: //Add a task
                System.out.println("------Create a task------");
                
                System.out.print("Title of the task: ");
                sc.nextLine();
                String name = sc.nextLine();
                
                System.out.print("Status of the task: ");
                String status = sc.nextLine();
               
                System.out.print("Progress of the task (%): ");
                int progress = inputFromUsers(sc);
                
                System.out.print("Due date of the task: ");
                sc.nextLine();
                String dueDate = sc.nextLine();
                
                category.addTask(new Task(name, status, progress, dueDate));
                System.out.println("");
                int action = setUpCategoryActions(category, sc);
                choosingCategoryActions(action, listOfCategories,category, sc);
                break;
            case 3: //Remove a task
                System.out.print("Type the index of the task that you want to remove: ");
                    int taskIndex = inputFromUsers(sc) - 1;
                    if(taskIndex < category.getTasksSize()  && taskIndex >= 0){
                        String deleteTaskTitle = category.getToTask(taskIndex).getTitle();
                        category.removeTask(category.getToTask(taskIndex));
                        System.out.println(deleteTaskTitle + " has been removed");
                        System.out.println("");
                        System.out.println("---------" + category.getCategoryName() + "---------");
                        category.showAllTasks();
                        
                    }System.out.println("");
            case 4: //Go back to main menu
                startApplication(listOfCategories);
                break;
            default: 
                System.out.println("You didn't enter the right thing!");
                System.out.println("Try again!");
                int num = inputFromUsers(sc);
                choosingCategoryActions(num, listOfCategories, category, sc);
                break;
        }
    }
    
    //method to let user input which feature of a task they want to update/change 
    private static int setUpTaskActions(Task task, Scanner sc){
        System.out.println("");
        System.out.println("==========" + task.getTitle() + "==========");
        task.showAllProperties();
        System.out.println();

        System.out.println("Enter 0 to exit");
        System.out.println("Enter 1 to change the title");
        System.out.println("Enter 2 to update the status");
        System.out.println("Enter 3 to update the progress");
        System.out.println("Enter 4 to change the due date");
        System.out.println("Enter 5 to go back to main menu");
        System.out.println("");
        System.out.print("Your actions: ");
       
        int action = inputFromUsers(sc);
        
        
        return action;
    }
    
    //methods to change title, status, progress,duedate or a task or return to main menu
    private static void choosingTaskActions(int userAction, ListOfCategories listOfCategories,Scanner sc, Task task){
        int actionNum;
        switch(userAction){
            case 0: 
                break;
            case 1: //Change the title
                System.out.print("Type in the new title: ");
                sc.nextLine();
                String newTitle = sc.nextLine();
                task.setTitle(newTitle);
                actionNum = setUpTaskActions(task, sc);
                choosingTaskActions(actionNum, listOfCategories,sc, task);
                break;
            case 2: //Update the status
                System.out.print("Type in the new status: ");
                sc.nextLine();
                String newStatus = sc.nextLine();
                task.setStatus(newStatus);
                actionNum = setUpTaskActions(task, sc);
                choosingTaskActions(actionNum, listOfCategories, sc, task);
                break;
            case 3: //Update the progress
                System.out.print("Type in the new Progress(%): ");
                int newProgress = inputFromUsers(sc);
                task.setProgress(newProgress);
                actionNum = setUpTaskActions(task, sc);
                choosingTaskActions(actionNum, listOfCategories, sc, task);
                break;
            case 4: //Change the due date
                System.out.print("Type in the new due date: ");
                sc.nextLine();
                String newDueDate = sc.nextLine();
                task.setDate(newDueDate);
                actionNum = setUpTaskActions(task, sc);
                choosingTaskActions(actionNum, listOfCategories, sc, task);
                break;
            case 5: //Go back to main menu
                startApplication(listOfCategories);
                break;
            default: 
                System.out.println("You didn't enter the right number!");
                System.out.println("Try again!");
                int num = inputFromUsers(sc);
                choosingTaskActions(num, listOfCategories, sc, task);
                break;
        }
    }
    
    
   
    private static Integer inputFromUsers(Scanner sc){
        Integer num;
        while (true) {
            try {
                num = sc.nextInt(); // Throw if not a double
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Invalid double, shoot again:");
                sc.nextLine();
            }
        }
        return num;
        
    }

}
