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
        Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true);
        myMap.addBuilding(neilsonLibrary);
        House talbot = new House("Talbot House", "25 Prospect St, Northampton, MA 01063", 5, false, true);
        myMap.addBuilding(talbot);
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063"));
        myMap.addBuilding(new House("Lamont House", "17 Prospect St, Northampton, MA 01060", 3, true, true));
        neilsonLibrary.enter();
        myMap.addBuilding(new House("Tyler House", "64 Green St, Northampton, MA 01060", 4, true, true));
        myMap.addBuilding(new House("Northrop House", "49 Elm St, Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Gillett House", "49 Elm St, Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Morris House", "101 Green St, Northampton, MA 01060", 4, true, false));
        talbot.moveIn("Ada Li");
        talbot.enter();
        talbot.exit();
        myMap.buildings.get(4).enter();
        neilsonLibrary.addTitle("The Art of War");
        System.out.println(myMap.buildings.get(2).toString());
        System.out.println(myMap);
    }

}
