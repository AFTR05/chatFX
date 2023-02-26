package com.example.chatfx;

import com.example.chatfx.controller.ClientController;
import com.example.chatfx.utilities.ChangerFXML;
import com.example.chatfx.utilities.ClientConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class ClientChat extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientChat.class.getResource("view/entryModal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Entry");
        stage.setScene(scene);
        stage.show();
    }


}
