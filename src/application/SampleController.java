package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.AppManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
    private Text searchResult;
    
    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private VBox vBoxScroll;

    @FXML
    private AnchorPane searchTypeContainer;
    @FXML
    private Button SaveButton;


    @FXML
    private Label animalTitle;

    @FXML
    private Label bgTitle;
   
    @FXML
    private Label figTitle;

    @FXML
    private Tab homeTab1;

    @FXML
    private Label puzzleTitle;

    @FXML
    private Button searchButton;

    @FXML
    private Button searchButton1;


    @FXML
    private Text searchResult1;


    @FXML
    private AnchorPane searchTypeContainer1;


    @FXML
    private TextField serialNumSeFeild1;
    
    @FXML
    private TextField serialNum;

    @FXML
    private TextField toyAge;

    @FXML
    private TextField toyBrand;

    @FXML
    private TextField toyName;

    @FXML
    private TextField toyType;

    int addSn;
    String addName;
    String addBrand;
    int addAge;
    String addType;
    


    @FXML
    void getSelectedRadio(ActionEvent event) {
    	

    }

    @FXML
    public void submit(ActionEvent event) {
    	addSn = Integer.parseInt(serialNum.getText());
    	addName = toyName.getText();
    	addBrand = toyBrand.getText();
    	addAge = Integer.parseInt(toyAge.getText());
    	addType = toyType.getText();
    }


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
            searchResult.setText(manager.searchBySerialNumber(sn));
        } else if (nameRadioButton.isSelected()) {
            String name = nameNumSeFeild.getText();
            searchResult.setText(manager.searchByToyName(name));
        } else if (typeRadioButton.isSelected()) {
            String type = typeNumSeFeild.getText();
            searchResult.setText(manager.searchByToyType(type));
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
