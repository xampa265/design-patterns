package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.ConsoleEditorCareTaker;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private ConsoleEditorCareTaker consoleEditorCareTaker;

    public UndoCommand(ConsoleEditorCareTaker consoleEditorCareTaker) {
        this.consoleEditorCareTaker = consoleEditorCareTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {

        ArrayList<String> documentLinesTemporal = consoleEditorCareTaker.pop().getState();
        if (documentLinesTemporal != null) {
            documentLines.clear();
            documentLines.addAll(documentLinesTemporal);
        }else{
            documentLines.clear();
        }
    }



}
