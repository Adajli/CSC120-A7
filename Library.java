import java.util.Hashtable;

/**
 * This is the library clas
 * 
 * @author Ada Li
 * @since October 24, 2024
 */
public class Library extends Building {
    // Attributes
    private Hashtable<String, Boolean> collection;

    /**
     * Library constructor
     * 
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors, hasElevator);
        this.collection = new Hashtable<String, Boolean>();
        System.out.println("You have built a library: 📖");
    }

    /**
     * Overloaded cafe constructor for a small 1 floor cafe
     * 
     * 
     * @param name
     * @param address
     */
    public Library(String name, String address) {
        this(name, address, 1, false);
    }

    /**
     * Function to add title
     * 
     * @param title
     */
    public void addTitle(String title) {
        if (collection.contains(title)) {
            System.out.println(collection);
            System.out.println(title);
            throw new RuntimeException("Can't add that title");
        } else {
            collection.put(title, true);
        }
    }

    /**
     * Function to remove title from library
     * 
     * @param title
     * @return title name
     */
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title, true);
            return title;
        } else {
            throw new RuntimeException("Can't remove that title");
        }
    } // return the title that we removed

    /**
     * Function to checkOut title
     * 
     * @param title
     */
    public void checkOut(String title) {
        if (isAvailable(title)) {
            System.out.println(title + " is available.");
            collection.replace(title, true, false);
            System.out.println(title + " is checked out.");
        } else {
            throw new RuntimeException("Can't check out " + title);
        }
    }

    /**
     * Function to return title
     * 
     * @param title
     */
    public void returnBook(String title) {
        if (collection.get(title).equals(false) && collection.containsKey(title)) {
            collection.replace(title, false, true);
            System.out.println(title + " is returned.");
        } else {
            throw new RuntimeException("Can't return " + title);
        }

    }

    /**
     * Function to check if the title is in the library
     * 
     * @param title
     * @return boolean for containing the title in the library
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Function checks if the title is available
     * 
     * @param title
     * @return true if the title is currently available, false otherwise
     */
    public boolean isAvailable(String title) {
        return collection.containsKey(title) && collection.get(title).equals(true);
    }

    /**
     * Function prints out collection in an easy-to-read way (including checkout
     * status)
     */
    public void printCollection() {
        System.out.println(collection.toString());
    }

    /**
     * Available options for library
     * 
     * @return void
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(
                "\n + removeTitle(title)\n + addTitle(title)\n + checkOut(title)\n + returnBook(title)\n  + containsTitle(title)\n + isAvailable(title)\n + printCollection() ");
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
            throw new RuntimeException("Can't go to another floor of " + name + ".");
        }

    }

    /**
     * Overloaded enter method for library.
     */
    public Library enter() {
        if (nFloors > 1) {
            super.enter();
        } else {
            System.out.println("You entered " + name + ".");
        }
        return this;
    }

    // Main function for testing

    public static void main(String[] args) {
        Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true);
        neilsonLibrary.addTitle("The Art of War");
        neilsonLibrary.addTitle("Astronomy");
        neilsonLibrary.addTitle("Flamer");
        neilsonLibrary.printCollection();
        neilsonLibrary.removeTitle("Flamer");
        System.out.println(neilsonLibrary.isAvailable("Astronomy"));
        System.out.println(neilsonLibrary.containsTitle("Astronomy"));
        neilsonLibrary.checkOut("Astronomy");
        neilsonLibrary.returnBook("Astronomy");
        neilsonLibrary.printCollection();
        neilsonLibrary.enter();
        neilsonLibrary.goToFloor(4);
        System.out.println(neilsonLibrary.toString());
    }

}