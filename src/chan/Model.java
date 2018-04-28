/*
 * Model.java
 * ============
 * A class to create ArrayList to store URLs the user requested in order
 * [Model] A class for logic part of application
 *  AUTHOR: SEUNG CHAN KIM (kimseu@sheridancollege.ca)
 * CREATED: 2018-03-16
 * UPDATED: 2018-03-30
 */
package chan;

import java.util.ArrayList;

public class Model {
    // create string ArrayList
    private ArrayList<String> list = new ArrayList<>();
    
    // create current index to find out which element to use in the arraylist
    private int currentIndex = -1;
    
    // constructor with no-args
    public Model() {
    }

    // getter of ArrayList
    public ArrayList<String> getList() {
        return list;
    }
    
    // getter of currentIndex
    public int getCurrentIndex() {
        return currentIndex;
    }
    
    // setter of currentIndex
    public void setCurrentIndex(int num) {
        currentIndex = num;
    }
    
    // check if arrayList is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    // add an element at the end of the arrayList and increment currentIndex
    public void push(String o) {
        list.add(o);
        currentIndex++;
    }

    // remove first element of the ArrayList    
    public void subList() {
        list.remove(0);
    }
    
    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}
