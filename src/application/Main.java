package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * The main class for the Store applicaiton
 * @author Ghassan Alnajjar
 * @version 1.0
 */
public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			// Main scene
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
			Scene scene = new Scene(root);
			
			// CSS file imported
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Staging
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
