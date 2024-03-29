package model;

public abstract class Toys {

    private String SN;
    private String name;
    private String brand;
    private double price;
    private int avaiableCount;
    private int ageAppropriate;


	/**
	 * This is the constructor of the Toys class
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param avaiableCount
	 * @param ageAppropriate
	 */
    public Toys(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate) {
        this.SN = SN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.avaiableCount = avaiableCount;
		this.ageAppropriate = ageAppropriate;
    }


	/**
	 * This is the getter for the SN attribute
	 * @return SN
	*/
	public String getSN() {
		return SN;
	}


	/**
	 * This is the setter for the SN attribute
	 * @param SN
	*/
	public void setSN(String SN) {
		this.SN = SN;
	}

	/**
	 * This is the getter for the name attribute
	 * @return name
	*/
	public String getName() {
		return name;
	}

	/**
	 * This is the setter for the name attribute
	 * @param name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is the getter for the brand attribute
	 * @return brand
	*/
	public String getBrand() {
		return brand;
	}

	/**
	 * This is the setter for the brand attribute
	 * @param brand
	*/
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * This is the getter for the price attribute
	 * @return price
	*/
	public double getPrice() {
		return price;
	}

	/**
	 * This is the setter for the price attribute
	 * @param price
	*/
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This is the getter for the avaiableCount attribute
	 * @return avaiableCount
	*/
	public int getAvaiableCount() {
		return avaiableCount;
	}

	/**
	 * This is the setter for the avaiableCount attribute
	 * @param avaiableCount
	*/
	public void setAvaiableCount(int avaiableCount) {
		this.avaiableCount = avaiableCount;
	}

	/**
	 * This is the getter for the ageAppropriate attribute
	 * @return ageAppropriate
	*/
	public int getAgeAppropriate() {
		return ageAppropriate;
	}

	/**
	 * This is the setter for the ageAppropriate attribute
	 * @param ageAppropriate
	*/
	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}
    
    
}
