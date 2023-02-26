package com.example.chatfx.utilities;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GeneratorFX {
    public TextField createText(String text) {
        TextField txt=new TextField(text);
        return txt;
    }

    public HBox createHBox() {
        HBox hbox=new HBox();
        return hbox;
    }


}
