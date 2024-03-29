package model;

public class Figures extends Toys{

    private String classification;

    public Figures(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate, String classification) {
        super(SN, name, brand, price, avaiableCount, ageAppropriate);
        this.classification = classification;
    }

    /**
     * This is the getter for the classification attribute
     * @return classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * This is the setter for the classification attribute
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

}
