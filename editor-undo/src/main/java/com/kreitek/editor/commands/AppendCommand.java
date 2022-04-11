package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.ConsoleEditorCareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private ConsoleEditorCareTaker consoleEditorCareTaker;

    public AppendCommand(String text, ConsoleEditorCareTaker consoleEditorCareTaker) {
        this.text = text;
        this.consoleEditorCareTaker = consoleEditorCareTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
        consoleEditorCareTaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        ArrayList<String> copyDocumentLines = (ArrayList<String>) documentLines.clone();
        return new Memento(copyDocumentLines);
    }
}
