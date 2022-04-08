package com.kreitek.editor;

public class EditorFactory {


    public Editor getEditor(String tipoEditor) {
        if(tipoEditor == null){
            return null;
        }
        else if(tipoEditor.equalsIgnoreCase("JSON")){
            return new ConsoleJson();
        }
        else if(tipoEditor.equalsIgnoreCase("TEXT")){
            return new ConsoleEditor();
        }
        return null;
    }
}

