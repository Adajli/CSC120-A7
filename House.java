/* This is the full House class */

import java.util.ArrayList;

/**
 * This is the house clas
 * 
 * @author Ada Li
 * @since October 24, 2024
 */
public class House extends Building {
    // House attributes
    private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
    private boolean hasDiningRoom;

    /**
     * House constructor
     * 
     * @param name
     * @param address
     * @param nFloors
     * @param hasDiningRoom
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors, hasElevator);
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        System.out.println("You have built a house: 🏠");
    }

    /**
     * Overloaded house constructor for a small 1 floor house
     * with option to include dining room
     * 
     * @param name
     * @param address
     * @param hasDiningRoom
     */
    public House(String name, String address, boolean hasDiningRoom) {
        this(name, address, 1, hasDiningRoom, false);
    }

    /**
     * Accessor to check if the house has dining room
     * 
     * @return hasDiningRoom
     */
    public boolean hasDiningRoom() {
        return hasDiningRoom;
    }

    /**
     * Accessor for number of residents of house
     * 
     * @return number of residents
     */
    public int nResidents() {
        return residents.size();
    }

    /**
     * Move in function
     * 
     * @param name
     */
    public void moveIn(String name) {
        if (residents.contains(name)) {
            throw new RuntimeException("Can't add that person");
        } else {
            residents.add(name);
        }
    }

    /**
     * Move out function
     * 
     * @param name
     */
    public void moveOut(String name) {
        if (isResident(name)) {
            residents.remove(name);
        } else {
            throw new RuntimeException("Can't remove that person");
        }
    }

    /**
     * Function to check if the person is the resident of house
     * 
     * @param person
     * @return true or false based on the person's residency
     */
    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    /**
     * Available options for house
     * 
     * @return void
     */
    public void showOptions() {
        super.showOptions();
        System.out.println("\n + isResident(person)\n + moveOut(name)\n + moveOut(name)\n");
    }

    /**
     * Function for going to floor
     * 
     * @param floorNum
     */
    public void goToFloor(int floorNum) {
        if (hasElevator && floorNum >= 1) {
            super.goToFloor(floorNum);
        } else {
            throw new RuntimeException("Can't go to another floor of " + name);
        }

    }

    /**
     * Overloaded enter method for House.
     */
    public House enter() {
        if (nFloors > 1) {
            super.enter();
        } else {
            System.out.println("You entered " + name + ".");
        }
        return this;
    }

    public static void main(String[] args) {
        House myHome = new House("My Home", "10 Meadowview Road Basking Ridge, NJ", 2, true, false);
        myHome.moveIn("Ada Li");
        myHome.moveIn("Hong Li");
        myHome.moveIn("Jin Chen");
        myHome.moveIn("Arthur Li");
        System.out.println(myHome.isResident("Ada Li"));
        myHome.moveOut("Ada Li");
        System.out.println(myHome.hasDiningRoom());
        System.out.println(myHome.nResidents());
        System.out.println(myHome.toString());
        myHome.showOptions();
    }

}