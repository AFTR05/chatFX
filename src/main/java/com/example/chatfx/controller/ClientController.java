package com.example.chatfx.controller;
import com.example.chatfx.utilities.ServerConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ClientController implements Initializable {

    @FXML
    private TextArea chatLook;

    public TextArea getChatLook() {
        return chatLook;
    }

    public void setChatLook(String chatLook) {
        this.chatLook.setText(chatLook);
    }

    public Button getBtnSendClient() {
        return btnSendClient;
    }

    public void setBtnSendClient(Button btnSendClient) {
        this.btnSendClient = btnSendClient;
    }

    public TextField getTxtInputClient() {
        return txtInputClient;
    }

    public void setTxtInputClient(TextField txtInputClient) {
        this.txtInputClient = txtInputClient;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    @FXML
    private Button btnSendClient;

    @FXML
    private TextField txtInputClient;

    public static Socket socket;
    private Logger log=Logger.getLogger(String.valueOf(ClientController.class));

    public static String host="Localhost";
    public static Integer port=5050;
    public static String client="";
    public static String message="";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            chatLook.setText("");
            log.info("Quieres conectarte a " + host + " en el puerto " +port + " con el nombre de ususario: " + client + ".");
            socket=new Socket(ClientController.host,ClientController.port);
            Executor executor = Executors.newFixedThreadPool(2);
            executor.execute(()->recibirMensajesServidor());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void sendServer(ActionEvent event){
        ServerConnection s=new ServerConnection(ClientController.socket,txtInputClient,client);
        s.actionPerformed();

    }

    public void recibirMensajesServidor(){

        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(ClientController.socket.getInputStream());
        } catch (IOException ex) {
            // log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            // log.error("El socket no se creo correctamente. ");
        }
        int activeThreadCount = Thread.activeCount();
        System.out.println("Número de hilos activos en el programa: " + activeThreadCount);
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                System.out.println(mensaje);
                ClientController.message+="\n"+mensaje;
                chatLook.setText(ClientController.message);
            } catch (IOException ex) {
                //  log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                // log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }


}
