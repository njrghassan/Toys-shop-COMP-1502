package model;

public class Figures extends Toys{

    private char classification;

    public Figures(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate, char classification) {
        super(SN, name, brand, price, avaiableCount, ageAppropriate);
        this.classification = classification;
    }

    /**
     * This is the getter for the classification attribute
     * @return classification
     */
    public char getClassification() {
        return classification;
    }

    /**
     * This is the setter for the classification attribute
     * @param classification
     */
    public void setClassification(char classification) {
        this.classification = classification;
    }

}
