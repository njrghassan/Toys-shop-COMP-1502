package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.AppManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Toys;
import view.AppMenu;

public class SampleController implements Initializable{
    
    @FXML
    private Tab addTab;
    
    @FXML
    private Tab homeTab;

    @FXML
    private Tab removeTab;

    @FXML
    private Text companyLogo;
    
    @FXML
    private ToggleGroup inventorySearch;

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
    private AnchorPane searchTypeContainer;

    @FXML
    private ComboBox<String> categoryBox;
    private String[] categories = {"Figures", "Animals", "Puzzles", "Board Games"};
    
    AppManager manager = new AppManager();
    AppMenu menu = new AppMenu();

	@Override
    public void initialize(URL location, ResourceBundle resources) {
		// Loading all files
		try {
			manager.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		// Text feilds disabled
		serialNumSeFeild.setDisable(true);
		nameNumSeFeild.setDisable(true);
		typeNumSeFeild.setDisable(true);
				
		// ComboBox items init
        categoryBox.getItems().addAll(categories);
        categoryBox.setOnAction(this::getSelectedItem);
        


    }
	
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
	
	public void searchButtonAction(ActionEvent e) {
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
						" " + listText.getBrand()+ 
						" " + listText.getPrice()+ 
						" " + listText.getAvaiableCount());
				
				// Reset index
				i++;
				index = String.valueOf(i);
				
            }

            
            
        } 
		else if (nameRadioButton.isSelected()) {
            String name = nameNumSeFeild.getText();
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
						" " + listText.getBrand()+ 
						" " + listText.getPrice()+ 
						" " + listText.getAvaiableCount());
				
				// Reset index
				i++;
				index = String.valueOf(i);
				
            }
        } 
        else if (typeRadioButton.isSelected()) {
            String type = typeNumSeFeild.getText();
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
						" " + listText.getBrand()+ 
						" " + listText.getPrice()+ 
						" " + listText.getAvaiableCount());
				
				// Reset index
				i++;
				index = String.valueOf(i);
				
            }

        }
        
    }
	
	
//	private void addTextToContainer(String text) {
//        Text newText = new Text(text);
//        textContainer.getChildren().add(newText);
//    }

	public void getSelectedItem(ActionEvent e) {
		String classSelected = categoryBox.getValue();
		System.out.println(classSelected);
		
		if (classSelected == "Figures") {
			System.out.println("yeay");
		}
	}
	
    

}
