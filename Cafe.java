/**
 * Cafe clas
 * 
 * @author Ada Li
 * @since October 24, 2024
 */
public class Cafe extends Building {
    // Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for the Cafe class
     * 
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams,
            int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sell Coffe method
     * 
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || nCoffeeOunces < size) {
            System.out.println("Not enough ingredients.");
            restock(nCoffeeOunces, nSugarPackets, nCreams, this.nCups);
        } else {
            nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }

    /**
     * Restock function to restock ingredients
     * 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public static void main(String[] args) {
        Cafe brewHaven = new Cafe("Brew Haven", "30 Meadwoview Road, Basking Ridge, New Jersey", 2, 100, 100, 20, 50);
        System.out.println(brewHaven);
        brewHaven.sellCoffee(12, 2, 3);
        brewHaven.sellCoffee(30, 2, 3);
        brewHaven.sellCoffee(10, 2, 3);
        brewHaven.sellCoffee(10, 2, 3);
        brewHaven.sellCoffee(20, 2, 3);

    }

}
