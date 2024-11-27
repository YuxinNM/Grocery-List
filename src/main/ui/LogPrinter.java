package ui;

import model.EventLog;
import model.exception.LogException;

// reference: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
// Defines behaviours that event log printers must support
public interface LogPrinter {
    // EFFECTS: prints the log given, throws LogException when printing fails 
    void printLog(EventLog el) throws LogException;
}
