package model;


public class Puzzles extends Toys{

	private char type;
	
	public Puzzles(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate, char type) {
		super(SN, name, brand, price, avaiableCount, ageAppropriate);
		this.type = type;
	}

	/**
	 * This is the getter for the type attribute
	 * @return type
	 */
	public char getType() {
		return type;
	}

	/**
	 * This is the setter for the type attribute
	 * @param type
	 */
	public void setType(char type) {
		this.type = type;
	}


	
}
