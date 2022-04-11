package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.ConsoleEditorCareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;
    private ConsoleEditorCareTaker consoleEditorCareTaker;


    public UpdateCommand(String text, int lineNumber, ConsoleEditorCareTaker consoleEditorCareTaker) {
        this.text = text;
        this.lineNumber = lineNumber;
        this.consoleEditorCareTaker = consoleEditorCareTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (documentLines.size() > lineNumber) {
            documentLines.set(lineNumber, text);
        } else {
            documentLines.add(text);
        }
        consoleEditorCareTaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        return new Memento(documentLines);
    }
}
