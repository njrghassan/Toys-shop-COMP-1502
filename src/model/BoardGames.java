package model;

public class BoardGames extends Toys{

	private int minPlayers, maxPlayers;
	private String[] designers;
	
	public BoardGames(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate, int minPlayers, int maxPlayers, String[] designers) {
		super(SN, name, brand, price, avaiableCount, ageAppropriate);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
	}

	/**
	 * This is the getter for the minPlayers attribute
	 * @return minPlayers
	 */
	public int getMinPlayers() {
		return minPlayers;
	}

	/**
	 * This is the setter for the minPlayers attribute
	 * @param minPlayers
	 */
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	/**
	 * This is the getter for the maxPlayers attribute
	 * @return maxPlayers
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * This is the setter for the maxPlayers attribute
	 * @param maxPlayers
	 */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	/**
	 * This is the getter for the designers attribute
	 * @return designers
	 */
	public String[] getDesigners() {
		return designers;
	}

	/**
	 * This is the setter for the designers attribute
	 * @param designers
	 */
	public void setDesigners(String[] designers) {
		this.designers = designers;
	}

	
}
