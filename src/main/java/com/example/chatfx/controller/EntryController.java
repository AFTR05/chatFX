package com.example.chatfx.controller;

import com.example.chatfx.enums.Rutes;
import com.example.chatfx.utilities.ChangerFXML;
import com.example.chatfx.utilities.ServerConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class EntryController {

    @FXML
    private Button btnAccept;

    @FXML
    private TextField txtClientName;

    @FXML
    private TextField txtHost;

    @FXML
    private TextField txtPort;


    @FXML
    void accept(ActionEvent event) {
        ClientController.client=txtClientName.getText();
        ClientController.host=txtHost.getText();
        ClientController.port=Integer.parseInt(txtPort.getText());
        try {
            ClientController.socket=new Socket(txtHost.getText(),Integer.parseInt(txtPort.getText()));
            ChangerFXML.sceneChange(event, Rutes.CLIENT.getRute());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
