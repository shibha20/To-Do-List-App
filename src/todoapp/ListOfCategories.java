
package todoapp;

import java.util.List;
import java.util.ArrayList;

public class ListOfCategories {
    
    //create a list of categoires 
    private List<Category> categories;

    public ListOfCategories() {
        this.categories = new ArrayList<>();
        this.initializeDefaultCategories();
    }
    
    //set initial categories 
    private void initializeDefaultCategories(){
        categories.add(new Category("School"));
        categories.add(new Category("Work"));
        categories.add(new Category("Important Tasks"));
    }
    
    //method to add a new cateogory
    public void addCategory(Category category){
        categories.add(category);
    }
    
    //method to remove a category 
    public void removeCategory(Category category){
        categories.remove(category);
    }
    
    //returning how many categories of tasks there are in the app
    public int categoriesSize(){
        return categories.size();
    }
    
    //method to enter a category 
    public Category getToCategory(int index){
        return categories.get(index);
    }
    
    //method to print all existing categories of tasks in the app
    public void showAllCategories(){
        System.out.println("---------To-do List---------");
        System.out.println("");
        System.out.println("---------Categories---------");
        for(int i = 0; i < this.categories.size(); i++){
            System.out.println((i+1) +". " + categories.get(i).getCategoryName());
        }
    }
    
    
    
}
