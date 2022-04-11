package com.kreitek.editor.commands;

import com.kreitek.editor.BadCommandException;
import com.kreitek.editor.Command;
import com.kreitek.editor.ExitException;
import com.kreitek.editor.memento.ConsoleEditorCareTaker;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    ConsoleEditorCareTaker consoleEditorCareTaker = new ConsoleEditorCareTaker();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1],consoleEditorCareTaker);
            case "u" -> createUpdateCommand(args[1], args[2], consoleEditorCareTaker);
            case "d" -> createDeleteCommand(args[1], consoleEditorCareTaker);
            case "undo" -> createUndoCommand(consoleEditorCareTaker);
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand(ConsoleEditorCareTaker consoleEditorCareTaker) {
        return new UndoCommand(consoleEditorCareTaker);
    }

    private Command createDeleteCommand(String lineNumber, ConsoleEditorCareTaker consoleEditorCareTaker) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number, consoleEditorCareTaker);
    }

    private Command createUpdateCommand(String lineNumber, String text, ConsoleEditorCareTaker consoleEditorCareTaker) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number, consoleEditorCareTaker);
    }

    private Command createAppendCommand(String text, ConsoleEditorCareTaker consoleEditorCareTaker) {
        return new AppendCommand(text, consoleEditorCareTaker);
    }


}
