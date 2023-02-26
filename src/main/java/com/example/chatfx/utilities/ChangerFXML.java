package com.example.chatfx.utilities;


import com.example.chatfx.ClientChat;
import com.example.chatfx.controller.ClientController;
import com.example.chatfx.controller.ModelFactoryController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChangerFXML {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public void closeModalWindow(Button button){
        Stage stage=(Stage) button.getScene().getWindow();
        stage.close();
    }
    public static void modalChange(String rute) throws IOException {
        root= FXMLLoader.load(ClientChat.class.getResource(rute));
        stage=new Stage();
        scene=new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void doSomething(){
        ClientController c=new ClientController();
        Executor executor = Executors.newFixedThreadPool(2);

    }

    public static void sceneChange(ActionEvent event,String rute) throws IOException {
        root= FXMLLoader.load(ClientChat.class.getResource(rute));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
