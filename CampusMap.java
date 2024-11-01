import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * 
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * 
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " ("
                    + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true));
        for (int i = 0; i < myMap.buildings.size(); i++) {
            if (myMap.buildings.get(i) instanceof Library) {
                Library library = (Library) myMap.buildings.get(i);
                library.addTitle("The Art of War");
                library.addTitle("Astronomy");
                System.out.println(library.isAvailable("Astronomy"));
            }
            if (myMap.buildings.get(i) instanceof Cafe) {
                Cafe cafe = (Cafe) myMap.buildings.get(i);
                cafe.sellCoffee(20, 0, 1);
            }
        }
        System.out.println(myMap);
    }

}
