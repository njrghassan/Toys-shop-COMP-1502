package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppLog {
	
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	
	public static void main(String[] args) throws SecurityException, IOException {
		
		FileHandler fh = new FileHandler("ToyLog.txt");
		fh.setLevel(Level.ALL);
		LOGR.addHandler(fh);
		
		System.out.println("Please log in");
		LOGR.info("user logged");
		
		
	}
}
