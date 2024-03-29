package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleController{
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private AnchorPane MenuBar;
    
    @FXML
    private Text companyLogo;

    @FXML
    private ChoiceBox<String> categoryBox;
    
    private String[] categories = {"Figures", "Animals", "Puzzles", "Board Games"};
    
    public void initItems() {
        categoryBox.getItems().addAll(categories);
    }
    

	/**
	 * This class will show the scene selected
	 * @param e
	 * @param fileName
	 */
	public void showScene(ActionEvent e, String fileName) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fileName));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			// Adding the CSS
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}catch (IOException err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * Home Screen
	 * @param e
	 */
	public void switchToHomeScene(ActionEvent e) {
		showScene(e, "HomeScene.fxml");
	}
	
	/**
	 * Add Toys Screen
	 * @param e
	 */
	public void switchToAddToys(ActionEvent e) {
		showScene(e, "AddToyScene.fxml");
	}

    

}
