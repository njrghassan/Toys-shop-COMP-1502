package application;
	
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


/**
 * The main class for the Store applicaiton
 * @author Ghassan Alnajjar, Akram Altabba
 * @version 1.0
 */
public class Main extends Application{
	
    public static final Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public void start(Stage primaryStage) throws Exception{
		logging();
		
		try {
			// Main scene
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			
			// CSS file imported
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Staging
			primaryStage.setScene(scene);
			primaryStage.show();
			LOGR.log(Level.INFO, "Application launched successfully.");
		}
		catch (IOException e) {
			LOGR.log(Level.SEVERE, "Error loading FXML", e.getMessage());
		}
	}
	
	private void logging() throws SecurityException, IOException {
        try {
            // Setting up file handler for logging
            FileHandler fh = new FileHandler("doc/ToyLog.txt", true);
            fh.setLevel(Level.ALL);
            LOGR.addHandler(fh);
        } catch (IOException e) {
            // If unable to create file handler, log it to console
        	LOGR.log(Level.SEVERE, "Error setting up logging", e);
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
