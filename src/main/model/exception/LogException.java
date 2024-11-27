package model.exception;

// reference:https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
/**
 * Represents the exception that can occur when
 * printing the event log.
 */
public class LogException extends Exception {

    // EFFECTS: constructs the logException
    public LogException() {
		super("Error printing log");
	}
	
    // EFFECTS: constructs the logException with message
	public LogException(String msg) {
		super(msg);
	}
}
