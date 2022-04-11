package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.ConsoleEditorCareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    private ConsoleEditorCareTaker consoleEditorCareTaker;

    public DeleteCommand(int lineNumber, ConsoleEditorCareTaker consoleEditorCareTaker) {
        this.lineNumber = lineNumber;
        this.consoleEditorCareTaker = consoleEditorCareTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);
        consoleEditorCareTaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        return new Memento(documentLines);
    }


}
