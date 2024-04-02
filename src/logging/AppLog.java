package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppLog {
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/**
	 * Creates logging into the log file.
	 * 
	 * @param args
	 * @throws SecurityException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SecurityException, IOException {
		
		FileHandler fh = new FileHandler("doc/ToyLog.txt");
		fh.setLevel(Level.ALL);
		LOGR.addHandler(fh);
		
		LOGR.info("user logged in");
		
		
	}
}
