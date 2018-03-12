package bbli.tracker.minion.A1.cmpt213;

/**
 * A class for holding minion information: name (String), height (double), and number of evil deeds completed (int).
 * @author Bei Bei Li
 */
public class Minion {

    //fields
    private String name;
    private int deeds;
    private double height;

    /**
     * Constructor to instantiate the minion object.
     * @param name The name of the minion.
     * @param deeds The evil deeds the minion has done, default: 0.
     * @param height The height of the minion.
     */
    public Minion(String name, int deeds, double height){
        this.name = name;
        this.deeds = deeds;
        this.height = height;
    }

    /**
     * Method to retrieve the minion's name.
     * @return The name (String) of the minion.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method to retrieve the minion's evil deed count.
     * @return The number of evil deeds (Integer) done by the minion.
     */
    public int getEvilDeedCount(){
        return this.deeds;
    }

    /**
     * Method to retrieve the minion's height.
     * @return The height (Double) of the minion.
     */
    public double getHeightInM(){
        return this.height;
    }

    /**
     * Method to increment the minion's evil deeds count.
     */
    public void incrementEvilDeeds(){
        this.deeds ++;
    }

    /**
     * Method to override the default toString() to display minion information for debugging and logging purpose.
     * @return A string displaying the Minion's class, name, deeds and height.
     */
    //overriding default toString() method inherited from the Object class that gives class name @ hash code
    @Override
    public String toString(){
        return getClass().getName() +
                "[Name:" + this.name +
                ", Evil Deeds:" + this.deeds +
                ", Height:" + this.height + "]";
    }

}
