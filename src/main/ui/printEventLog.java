package ui;

import model.Event;

import model.EventLog;
import model.exception.LogException;

// Prints out the events logged
public class printEventLog implements LogPrinter {

    // EFFECT: prints all the events in the eventlog to the console
    @Override
    public void printLog(EventLog el) throws LogException {
        for (Event next : el) {
            System.out.println(next.toString());
        }
    }
}
