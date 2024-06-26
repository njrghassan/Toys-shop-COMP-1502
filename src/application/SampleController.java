package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.AppManager;
import exceptions.AddingToyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Toys;
import view.AppMenu;
import application.Main;

public class SampleController implements Initializable{
    
    @FXML
    private Tab addTab;
    
    @FXML
    private Tab homeTab;

    @FXML
    private Tab removeTab;

    @FXML
    private TextField toyPrice;
    
    @FXML
    private Text companyLogo;
    
    @FXML
    private TextField boardDesign;

    @FXML
    private TextField boardMax;
    
    @FXML
    private Button RemoveButton;
    
    @FXML
    private TextField boardMin;
    
    @FXML
    private TextField puzType;
    
    @FXML
    private ToggleGroup inventorySearch;
    
    @FXML
    private TextField toysAvailable;
    
    @FXML
    private RadioButton snRadioButton;
    
    @FXML
    private RadioButton nameRadioButton;
    
    @FXML
    private RadioButton typeRadioButton;
    
    @FXML
    private TextField serialNumSeFeild;
    
    @FXML
    private TextField nameNumSeFeild;

    @FXML
    private TextField typeNumSeFeild;
    
    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private VBox vBoxScroll;
    
    @FXML
    private Text numR;
    
    @FXML
    private Text nameR;
    
    @FXML
    private Text priceR;
    
    @FXML
    private Text avR;
    
    @FXML
    private ListView<String> listViewMenu;
    
    @FXML
    private Button buyButton;
    
    @FXML
    private Label errLabel;
    
    @FXML
    private TextField serialNum;

    @FXML
    private TextField toyAge;

    @FXML
    private TextField toyBrand;

    @FXML
    private TextField toyName;
    
    @FXML
    private Button SaveButton;
    
    @FXML
    private TextField figClass;
    
    @FXML
    private TextField aniMat;

    @FXML
    private TextField aniSize;
    
    @FXML
    private TextField toyType;
    
    @FXML
    private TextField serialNumRemove;
    
    @FXML
    private ComboBox<String> categoryBox;
    private String[] categories = {"Figures", "Animals", "Puzzles", "Board Games"}; // Categories
    
    @FXML
    private ListView<String> listViewMenuForRemoving;
    
    @FXML
    private Label errLabelAdd;
    
    @FXML
    private Label errLabelRemove;
    
    // Creating the AppManager and AppMenu objects
    AppManager manager = new AppManager();
    AppMenu menu = new AppMenu();

	/**
	 * Initializes the controller class to set the default values of the application.
	 * @param location
	 * @param resources
	 */
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		// Loading all files
		try {
			manager.run();
		}
		catch (Exception e) {
			e.printStackTrace();
    		Main.LOGR.log(Level.SEVERE, "Error 00445", e.getMessage());

		}
		
		// Text fields disabled
		serialNumSeFeild.setDisable(true);
		nameNumSeFeild.setDisable(true);
		typeNumSeFeild.setDisable(true);
				
		// ComboBox items init
        categoryBox.getItems().addAll(categories);
        categoryBox.setOnAction(this::getSelectedItem);
        
        
        
        figClass.setDisable(true);
        aniMat.setDisable(true);
		aniSize.setDisable(true);
		puzType.setDisable(true);
		boardMax.setDisable(true);
		boardMin.setDisable(true);
		boardDesign.setDisable(true);

    }
	
	/**
	 * Controls the radio buttons to enable the text fields, depending on the selected radio button.
	 */
	public void getSelectedRadio() {
		if (snRadioButton.isSelected()) {
			serialNumSeFeild.setDisable(false);
			nameNumSeFeild.setDisable(true);
			typeNumSeFeild.setDisable(true);
		}
		else if (nameRadioButton.isSelected()) {
			serialNumSeFeild.setDisable(true);
			nameNumSeFeild.setDisable(false);
			typeNumSeFeild.setDisable(true);
		}
		else if (typeRadioButton.isSelected()) {
			serialNumSeFeild.setDisable(true);
			nameNumSeFeild.setDisable(true);
			typeNumSeFeild.setDisable(false);
		}
		else
			System.out.println("Feild doesn't exits!");
		
	}
	
	/**
	 * Search button action to search the item in the inventory.
     * @param e
	 */
	public void searchButtonAction(ActionEvent e) {
		// Search by serial number
		if (snRadioButton.isSelected()) {
            String sn = serialNumSeFeild.getText();
            String index = "";
            listViewMenu.getItems().clear();
            int i = 1;
			for (Toys listText : manager.searchBySerialNumber(sn)) {
				if (i < 10) {
					index = String.valueOf(i) + " ";
				}
				else {
					index = String.valueOf(i);
				}
				
				listViewMenu.getItems().addAll(index+
						" " + listText.getName() + 
						"\t" + listText.getBrand()+ 
						"\t$" + listText.getPrice()+ 
						" \tAV:" + listText.getAvaiableCount()+
						" \tAge:" + listText.getAgeAppropriate()+
						"\t" + listText.getClass().getSimpleName()+
						"\t" + listText.getSN());
						
				
				// Reset index
				i++;
				index = String.valueOf(i);
				
            }
   
        }
		// Search by name
		else if (nameRadioButton.isSelected()) {
            String name = nameNumSeFeild.getText().toLowerCase();
            String index = "";
            listViewMenu.getItems().clear();
            int i = 1;
			for (Toys listText : manager.searchByToyName(name)) {
				if (i < 10) {
					index = String.valueOf(i) + " ";
				}
				else {
					index = String.valueOf(i);
				}
				
				listViewMenu.getItems().addAll(index+
						" " + listText.getName() + 
						"\t" + listText.getBrand()+ 
						"\t$" + listText.getPrice()+ 
						" \tAV:" + listText.getAvaiableCount()+
						" \tAge:" + listText.getAgeAppropriate()+
						"\t" + listText.getClass().getSimpleName()+
						"\t" + listText.getSN());
				
				// Reset index
				i++;
				index = String.valueOf(i);
				
            }
        }
		// Search by type
        else if (typeRadioButton.isSelected()) {
            String type = typeNumSeFeild.getText().toLowerCase();
            String index = "";
            listViewMenu.getItems().clear();
            int i = 1;
			for (Toys listText : manager.searchByToyType(type)) {
				if (i < 10) {
					index = String.valueOf(i) + " ";
				}
				else {
					index = String.valueOf(i);
				}
				
				listViewMenu.getItems().addAll(index+
						" " + listText.getName() + 
						"\t" + listText.getBrand()+ 
						"\t$" + listText.getPrice()+ 
						" \tAV:" + listText.getAvaiableCount()+
						" \tAge:" + listText.getAgeAppropriate()+
						"\t" + listText.getClass().getSimpleName()+
						"\t" + listText.getSN());
				
				// Reset index
				i++;
				index = String.valueOf(i);
            }
        } 
    }
	
	/*
	 * Buy button action to buy the item from the inventory.
	 * @param e
	 */
	public void buyButtonAction(ActionEvent e) {	
		try {
			String selectedItem = listViewMenu.getSelectionModel().getSelectedItem();
			String[] parts = selectedItem.split("\t");
			String sn = parts[parts.length-1];
			
			if (manager.buyToy(sn)) {
				listViewMenu.getItems().clear();
				errLabel.setText("Item bought successfully!");
			} else {
				errLabel.setText("Item not available!");
			}
		}
		catch (NullPointerException ex) {
			errLabel.setText("Please select an item!");
    		Main.LOGR.log(Level.SEVERE, "Error buying item", ex.getMessage());
		}
		catch (Exception ex) {
			errLabel.setText(ex.getMessage());
    		Main.LOGR.log(Level.SEVERE, "Error buying item", ex.getMessage());
		}
	}	

	/**
	 * Controls the category box to get the selected item.
	 * @param e
	 */
	public void getSelectedItem(ActionEvent e) {
		String classSelected = categoryBox.getValue();
		System.out.println(classSelected);
		try {
		if (classSelected == "Figures") {
			figClass.setDisable(false);
			aniMat.setDisable(true);
			aniSize.setDisable(true);
			puzType.setDisable(true);
			boardMax.setDisable(true);
			boardMin.setDisable(true);
			boardDesign.setDisable(true);


					}
		else if (classSelected == "Animals") {
			figClass.setDisable(true);
			aniMat.setDisable(false);
			aniSize.setDisable(false);
			puzType.setDisable(true);
			boardMax.setDisable(true);
			boardMin.setDisable(true);
			boardDesign.setDisable(true);
					}
		else if (classSelected == "Puzzles") {
			figClass.setDisable(true);
			aniMat.setDisable(true);
			aniSize.setDisable(true);
			puzType.setDisable(false);
			boardMax.setDisable(true);
			boardMin.setDisable(true);
			boardDesign.setDisable(true);
			
		}
		else if (classSelected == "Board Games") {
			figClass.setDisable(true);
			aniMat.setDisable(true);
			aniSize.setDisable(true);
			puzType.setDisable(true);
			boardMax.setDisable(false);
			boardMin.setDisable(false);
			boardDesign.setDisable(false);
						
			
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
    		Main.LOGR.log(Level.SEVERE, "Error Selecting item", ex.getMessage());
		}
	}
	/**
	 * Clear button action to clear the text fields.
	 * @param e
	 */
	@FXML
	public void clearButtonAction(ActionEvent e) {
		serialNumSeFeild.clear();
		nameNumSeFeild.clear();
		typeNumSeFeild.clear();
		listViewMenu.getItems().clear();
		errLabel.setText("");	
	}
	/**
	 * Submit button action to take all inputs and convert to data.
	 * @param event
	 * @var addSn, addName, addBrand, addAge, availableCount, addPrice
	 * classification, material, size, designer, minimum, maximum.
	 */
	@FXML
    public void submit(ActionEvent event){
		// Get all the input values
    	String addSn = null,
    		   addName = null,
    		   addBrand = null,
    		   addAge = null,
    		   availableCount = null,
    		   addPrice = null;
        
    	// Class inputs values
        String classification = null,
        		material = null,
        		size = null,
        		puzzleType = null,
        		designer = null,
        		minimum = null,
        		maximum = null;
        try {
        	// Get the selected category
        	String classSelected = categoryBox.getValue();
        	
        	if (classSelected == "Figures") {
        		classification = figClass.getText();
        	
        		if (classification == null || classification.isEmpty()) {
        			throw new AddingToyException("Please enter the required feilds for Figures!");
        		}
				else if (!(classification.equals("A") || classification.equals("D")|| classification.equals("H") ||
						classification.equals("a") || classification.equals("d") || classification.equals("h"))) {
					throw new AddingToyException("Classification must be A, D or H!");
				}
        	}
        	else if (classSelected == "Animals") {
        		material = aniMat.getText();
        		size = aniSize.getText();
			
        		if (material == null || material.isEmpty() || size == null || size.isEmpty()) {
					throw new AddingToyException("Please enter the required feilds for Animals!");
				}
        		else if (!(size.equals("S") || size.equals("M") || size.equals("L") ||
        		           size.equals("s") || size.equals("m") || size.equals("l"))) {
        		  throw new AddingToyException("Size must be S, M or L!");
        		}
				else if (size.length() > 1) {
					throw new AddingToyException("Size must be one letter long!");
				}
        	}
        	else if (classSelected == "Puzzles") {
        		puzzleType = puzType.getText();
			
        		if (puzzleType == null || puzzleType.isEmpty()) {
        			throw new AddingToyException("Please enter the required feilds for Puzzles!");
        		}
        		else if (!(puzzleType.equals("M") || puzzleType.equals("C") || puzzleType.equals("L") ||
        		           puzzleType.equals("T") || puzzleType.equals("R") ||
        		           puzzleType.equals("m") || puzzleType.equals("c") || puzzleType.equals("l") ||
        		           puzzleType.equals("t") || puzzleType.equals("r"))) {
        		  throw new AddingToyException("Puzzle type must be M, C, L, T or R!");
        		}

        	}
        	else if (classSelected == "Board Games") {
        		maximum = boardMax.getText();
        		minimum = boardMin.getText();
        		designer = boardDesign.getText(); 
			
        		if (maximum == null || maximum.isEmpty() || minimum == null || minimum.isEmpty() || 
        				designer == null || designer.isEmpty()) {
        			throw new AddingToyException("Please enter the required feilds for Board Games!");
        		}
				else if (Integer.parseInt(minimum) > Integer.parseInt(maximum)) {
					throw new AddingToyException("Minimum players must be less than maximum players!");
				}
        	}
			else {
				throw new AddingToyException("Please select a category!");
			}
        	
        	// Add the toy to the inventory
    		addSn = serialNum.getText();
        	addName = toyName.getText();
        	addBrand = toyBrand.getText();
        	addPrice = toyPrice.getText();
    		availableCount = toysAvailable.getText();
        	addAge = toyAge.getText();
        	
        	if (addSn == null || addSn.isEmpty() || addName == null || 
        			addName.isEmpty() || addBrand == null || addBrand.isEmpty() || 
        			addPrice == null || addPrice.isEmpty() || availableCount == null || 
        			availableCount.isEmpty() || addAge == null || addAge.isEmpty()) {
				throw new AddingToyException("Please enter the required feilds!");
			}
			else if (addSn.length() < 10) {
				throw new AddingToyException("Serial number must be at least 10 numbers long!");
			}
        	
        	// Check if the serial number is a number
        	for (int i = 0; i < addSn.length(); i++) {
        		if (!Character.isDigit(addSn.charAt(i))) {
        			throw new AddingToyException("serial number must be a number!");
        		}       			
        	}
	
        	String[] userInput = {classSelected, addSn, addName, addBrand, addPrice, availableCount, addAge, classification, puzzleType, material, size, minimum, maximum, designer };
        	System.out.println(userInput);
        	manager.addNewToy(userInput);
        	errLabelAdd.setText("Item added successfully!");
    	}
    	catch (AddingToyException e) {
    		errLabelAdd.setText(e.getMessage());
    		Main.LOGR.log(Level.SEVERE, "Error adding toy", e.getMessage());
		} 
    	
		
    }
	/**
	 * Search button action in remove to search the item in the inventory.
	 * @param event The action event.
	 */
	@FXML
	public void searchRemove(ActionEvent event) {
		String sn;
		sn = serialNumRemove.getText();

		if (sn != ""){
            String index = "";
            listViewMenuForRemoving.getItems().clear();           
            int i = 1;
			for (Toys listText : manager.searchBySerialNumber(sn)) {
				if (i < 10) {
					index = String.valueOf(i) + " ";
				}
				else {
					index = String.valueOf(i);
				}
				
				listViewMenuForRemoving.getItems().addAll(index+
						" " + listText.getName() + 
						"\t" + listText.getBrand()+ 
						"\t$" + listText.getPrice()+ 
						" \tAV:" + listText.getAvaiableCount()+
						" \tAge:" + listText.getAgeAppropriate()+
						"\t" + listText.getClass().getSimpleName()+
						"\t" + listText.getSN());
						
				
				// Reset index
				i++;
				index = String.valueOf(i);
				
            }
		}
	}
	
	/**
	 * Remove action to remove the item in the inventory.
	 * @param event The action event
	 * @var selectedItem, parts, removeSN
	 */
	@FXML
    public void remove(ActionEvent event) {
		try {
			String selectedItem = listViewMenuForRemoving.getSelectionModel().getSelectedItem();
			String[] parts = selectedItem.split("\t");
			String removeSN = parts[parts.length-1];
			
			if (manager.removeToy(removeSN)) {
				listViewMenuForRemoving.getItems().clear();
				errLabelRemove.setText("Item removed successfully!");
			} else {
				errLabelRemove.setText("Item not available!");
			}

		}
		catch (NullPointerException ex) {
			errLabelRemove.setText("Please select an item!");
    		Main.LOGR.log(Level.SEVERE, "Error selecting an item", ex.getMessage());

		}
		catch (Exception ex) {
			errLabelRemove.setText(ex.getMessage());
    		Main.LOGR.log(Level.SEVERE, "Error removing toy", ex.getMessage());
		}
	}
}