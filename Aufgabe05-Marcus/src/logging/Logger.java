package logging;

import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  /* gehohrt in Formatter Klasse */
import java.time.LocalDateTime;             /* gehohrt in Formatter Klasse */

/**
 * Logger 
 * Created on June, 15, 2021
 * @author Robin Goerlach <robin.goerlach@sasd.de>
 *
 */
public class Logger {

	/**
	 * Value indicating whether Flush() should be called on the Listener after every write.
	 */
	private boolean autoFlush;
	
	/**
	 * The indent level. The default is 0
	 */
	private int logIndentLevel;
	
	/**
	 * The number of spaces in an indent. The default is four.
	 */
	private int logIndentSize;
	
	/**
	 * current logging level
	 */
	private Level logLevel;	

	/**
	 * current logging to target
	 */
	private Destination logDestination;	
	
	/**
	 * Active logger class
	 * (which class is currently logging)
	 */
	private static String logger;

	
	/**
	 * Supported Logger Destination where to log to
	 */
	public static enum Destination {
	    FILE,   /* log to File (default) */
	    SYSOUT, /* log to System Console */
	    SYSERR, /* log to System Error */
	    DB,     /* log to Database */
	    SERVER, /* log to protocol server */
	}
	
	/**
	 * Supported Logging Level
	 */	
	public static enum Level {
		FATALE,   /* HIGHEST LEVEL */
	    SEVERE,    
	    ERROR,    
	    WARNING,  /* default */
	    INFO,
	    DEBUG,
	    FINE,
	    FINER,
	    FINEST, CONFIG, /* LOWEST LEVEL */
		OFF
	}
		
	/** 
	 * default Constructor
	 * setting logging level to WARNING
	 * setting logging destination to SYSOUT	
	 */
	public Logger() {
		logLevel = Level.WARNING;
		logDestination = Destination.SYSOUT;
		setLogIndentLevel(0);
		setLogIndentSize(4);
	}
		
	/** 
	 * Setting a level causes a Logger to ignore messages below that level. 
	 */
	public void setLevel(Level value) {
		logLevel = value;
	}
	
	/**
	 * Get current Log level
	 * @param LogLevel
	 * @return
	 */
	public Level getLevel(Level value) {
		return logLevel;
	}
	
	/**
	 * Get current Log level
	 * @param LogLevel
	 * @return
	 */
	public Destination getDestination(Destination value) {
		return logDestination;
	}
	
	/** 
	 * Setting a level causes a Logger to ignore messages below that level. 
	 */
	public void setDestination(Destination value) {
		logDestination = value;
	}
	

	public int getLogIndentLevel() {
		return logIndentLevel;
	}

	public void setLogIndentLevel(int logIndentLevel) {
		this.logIndentLevel = logIndentLevel;
	}

	public int getLogIndentSize() {
		return logIndentSize;
	}

	public void setLogIndentSize(int logIndentSize) {
		this.logIndentSize = logIndentSize;
	}
		
	/**
	 * 
	 * @return
	 */
	public static String getLogger() {
		return logger;
	}

	/**
	 * 
	 * @param logger
	 */
	public static void setLogger(String logger) {
		Logger.logger = logger;
	}

	/**
	 * true if Flush() is called on the Listeners after every write; otherwise, false
	 * @return
	 */
	public boolean isAutoFlush() {
		return autoFlush;
	}

	/**
	 * sets a value indicating whether Flush() should be called on the Listener after every write.
	 * @param autoFlush
	 */
	public void setAutoFlush(boolean autoFlush) {
		this.autoFlush = autoFlush;
	}

	/**
	 * 
	 * @param logger
	 * @return
	 */
	public static Logger getLogger(String value) {
		logger = value;
		return new Logger();
	}

	/**
	 * 
	 * @param message
	 */
	private String format(String message) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		String line = logger + " [" + dtf.format(now) +"]" + message;		
		return line;
	}
		
	public void publish(String message) {
		
		switch (logDestination) {
		case FILE:
			break;
		case SYSOUT:
			System.out.print(format(message));
			break;
		case SYSERR:
			System.err.print(format(message));
			break;
		case DB:	
			break;
		case SERVER:	
			break;	
		default:
			;
		}		
	}
	
	/**
	 * Checks for a condition; if the condition is false, displays a message box that shows the call stack.
	 * @param condition
	 */
	public void Assert(Boolean condition) {
		if (!condition) { 
			JOptionPane.showMessageDialog(null, 
                "ALERT MESSAGE", 
                "TITLE", 
                JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Checks for a condition; if the condition is false, outputs a specified message and displays a message box that shows the call stack.
	 * @param condition
	 * @param message
	 */
	public void Assert(Boolean condition, String message) {
		if (!condition) { 
			JOptionPane.showMessageDialog(null, 
				message,
                "Assert Message",  
                JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Checks for a condition; if the condition is false, outputs two specified messages and displays a message box that shows the call stack.
	 * @param condition
	 * @param title
	 * @param message
	 */
	public void Assert(Boolean condition, String title, String message) {
		if (!condition) { 
			JOptionPane.showMessageDialog(null, 
				message,
				title,  
                JOptionPane.WARNING_MESSAGE);
		}		
	}

	/** 
	 * Checks for a condition; if the condition is false, outputs two messages (simple and formatted) and displays a message box that shows the call stack.
	 * @param condition
	 * @param message
	 * @param formatted
	 * @param objects
	 */
	public void Assert(Boolean condition, String message, String formatted, Object[] objects) {
		
	}
	
	/**
	 * Flushes the output buffer and then calls the Close method of the Listener
	 */
	public void close() {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	/**
	 * Emits the specified error message.
	 * @param message
	 */
	public void fail (String message) {
		publish(message);
	}
	
	/**
	 * Emits an error message and a detailed error message.
	 * @param message
	 * @param details
	 */
	public void fail (String message, String details) {
		publish(message + " Details: " + details);
	}
	
	/**
	 * Flushes the output buffer and causes buffered data to write to the Listener
	 */
	public void flush() {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}	

	/**
	 * increases the current IndentLevel by one.
	 */
	public void indent() {
		++logIndentLevel;
	}
		
	/**
	 * ....
	 * Writes a message  to the listener
	 * @param message to log
	 */
	public void print(String message) {
		publish(message);
	}
	
	/**
	 * Write message to listener followed by a line terminator
	 * @param message to log
	 */
	public void println(String message) {
		publish(message + "\n");
	}

	/**
	 * Decreases the current IndentLevel by one.
	 */
	public void unindent() {
		logIndentLevel = 1 < logIndentLevel ? logIndentLevel-- : 0;
	}
	
	/** 
	 * Writes a category name and message to the listener
	 * @param category
	 * @param message
	 */
	public void write(String category, String message) {
		publish("  (" + category  +") " + message);
	}	
	
	/**
	 * Writes a category name and the value of the object's ToString() method to the listener
	 * @param object
	 * @param category
	 */
	public void write(Object object, String category) {
		publish(" [" + object.toString()  +"] (" + category  +") ");
	}
	
	/**
	 * Writes the value of the object's ToString() method to the listener
	 * @param object
	 */
	public void write(Object object) {
		publish(" [" + object.toString()  +"]");
	}
		
	/**
	 * Writes a message to the listener
	 * @param message to log
	 */
	public void write(String message) {
		publish(message);
	}
	
	/**
	 * Writes a category name and the value of the object's ToString() method to the listener if a condition is true.
	 * @param condition
	 * @param object
	 */
	public void writeIf(boolean condition, Object object) {
		if (condition) {
			publish(" [" + object.toString()  +"]");
		}		
	}		
	
	/**
	 * Writes a message to the trace listener if a condition is true.
	 * @param condition
	 * @param message
	 */
	public void writeIf(boolean condition, String message) {
		if (condition) {
			publish( message);
		}		
	}	
	
	/**
	 * Writes a category name and the value of the object's ToString() method to the listener if a condition is true.
	 * @param condition
	 * @param object
	 * @param message
	 */
	public void writeIf(boolean condition, Object object, String category) {
		if (condition) {
			publish(" [" + object.toString()  +"]  (" + category  +") ");
		}		
	}	
	
	/**
	 * Writes a category name and message to the listener if a condition is true.
	 * @param condition
	 * @param category
	 * @param message
	 */
	public void writeIf(boolean condition, String category, String message) {
		if (condition) {
			publish(" (" + category  +") " + message);
		}		
	}
	
	/** 
	 * Writes the value of the object's ToString() method followed by a line terminator to the listener.
	 * @param object
	 */
	public void writeLine(Object object) {
		publish(object.toString() + "\n");
	}

	/**
	 * Writes a message followed by a line terminator to the listener
	 * @param message to log
	 */
	public void writeLine(String message) {
		publish(message + "\n");
	}

	/**
	 * Writes a category name and the value of the object's ToString() method to the listener
	 * @param object
	 * @param category
	 */
	public void writeLine(Object object, String category) {
		publish(" (" + category  +") " + object.toString() + "\n");
	}

	/**
	 * Writes a formatted message followed by a line terminator to the trace listeners 
	 * @param category
	 * @param object
	 */
	public void writeLine(String category, Object object) {
		publish(" (" + category  +") " + object.toString() + "\n");
	}
	
	/**
	 * Writes a category name and message to the listener.
	 * @param category
	 * @param message
	 */
	public void writeLine(String category, String message) {
		publish(" (" + category  +") " + message + "\n");
	}
	
	/**
	 * Writes a category name and message to the listener if a condition is true.
	 * @param condition if condition is true
	 * @param category
	 * @param message
	 */
	public void writeLineIf(boolean condition, String category, String message) {
		if (condition) {
			publish( " ("  + category + ") " + message + "\n");
		}			
	}
	
	/**
	 * Writes a message to the trace listener if a condition is true.
	 * @param condition if condition is true
	 * @param message
	 */
	public void writeLineIf(boolean condition, String message) {
		if (condition) {
			publish(message + "\n");
		}			
	}
	
	/**
	 * Writes the value of the object's ToString() method to the listeners if a condition is true.
	 * @param condition if condition is true
	 * @param object
	 */
	public void writeLineIf(boolean condition, Object object) {
		if (condition) {
			publish( " ["  + object.toString() + "] " + "\n");
		}			
	}
	
	/**
	 * Writes a category name and the value of the object's ToString() method to the listener if a condition is true.
	 * @param condition if condition is true
	 * @param object
	 * @param message
	 */
	public void writeLineIf(boolean condition, Object object, String message) {
		if (condition) {
			publish( " ["  + object.toString() + "] " + message + "\n");
		}			
	}
	
	/**
	 * Writes a Fatal Message to the listener if Level is Fatal or about 
	 * @param message
	 */
	public void Fatal(String message) {
		switch (logLevel) {
		case FATALE:
				publish("-FATAL\t" + message + "\n");
		case SEVERE:
		case ERROR:
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Severe Message to the listener if Level is Severe or about 
	 * @param message
	 */
	public void Severe(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
				publish("-SEVERE\t" + message + "\n");
		case ERROR:
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Error Message to the listener if Level is Error or about 
	 * @param message
	 * @param exception
	 */
	public void Error(String message, Exception exception) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
				publish("-ERROR\t" + message +  " " + exception.hashCode() + " " + exception.getMessage() + "\n");
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Error Message to the listener if Level is Error or about 
	 * @param message
	 */
	public void Error(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
				publish("-ERROR\t" + message + "\n");
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Warning Message to the listener if Level is Warning or about 
	 * @param message
	 */
	public void Warning(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
		case WARNING:
				publish("-WARNING\t" + message + "\n");
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Info Message to the listener if Level is Info or about 
	 * @param message
	 */
	public void Info(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
		case WARNING:
		case INFO:
				publish("-INFO\t" + message + "\n");
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Debug Message to the listener if Level is Debug or about 
	 * @param message
	 */
	public void Debug(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
		case WARNING:
		case INFO:
		case DEBUG:
				publish("-DEBUG\t" + message + "\n");
		case FINE:
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}
	
	/**
	 * Writes a Fine Message to the listener if Level is Fine or about 
	 * @param message
	 */
	public void Fine(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
				publish("-FINE\t" + message + "\n");
		case FINER: 
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Finer Message to the listener if Level is Finer or about 
	 * @param message
	 */
	public void Finer(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
				publish("-FINER\t" + message + "\n");
		case FINEST:
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Finest Message to the listener if Level is Finest or about 
	 * @param message
	 */
	public void Finest(String message) {
		switch (logLevel) {
		case FATALE:
		case SEVERE:
		case ERROR:
		case WARNING:
		case INFO:
		case DEBUG:
		case FINE:
		case FINER: 
		case FINEST:
				publish("-FINEST\t " + message + "\n");
		case CONFIG:
		case OFF:
		default: ;		
		}	
	}

	/**
	 * Writes a Config Message to the listener if Level is config
	 * @param message
	 */
	public void Config(String message) {
		switch (logLevel) {
		case CONFIG:
				publish("-CONFIG\t" + message + "\n");
		case OFF:
		default: ;		
		}	
	}

	
}
