module com.example.chatfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;
    requires java.desktop;


    exports com.example.chatfx.controller;
    opens com.example.chatfx.controller to javafx.fxml;


    exports com.example.chatfx.utilities;
    opens com.example.chatfx.utilities to javafx.fxml;


    exports com.example.chatfx;
    opens com.example.chatfx to javafx.fxml;


}