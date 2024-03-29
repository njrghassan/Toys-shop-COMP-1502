package model;

public class Animals extends Toys{

    private String material;
    private char size;

    public Animals(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate, String material, char size){
        super(SN, name, brand, price, avaiableCount, ageAppropriate);
        this.material = material;
        this.size = size;
    }

    /**
     * This is the getter for the size attribute
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * This is the setter for the size attribute
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * This is the getter for the size attribute
     * @return size
     */
    public char getSize() {
        return size;
    }

    /**
     * This is the setter for the size attribute
     * @param size
     */
    public void setSize(char size) {
        this.size = size;

    }
    
    
}
