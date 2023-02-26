package com.example.chatfx.utilities;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerConnection{
    private Logger log = Logger.getLogger(String.valueOf(ServerConnection.class));
    private Socket socket;
    private TextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;

    public ServerConnection(Socket socket, TextField message, String usuario) {
        this.socket = socket;
        this.tfMensaje = message;
        this.usuario = usuario;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());

        } catch (IOException ex) {

        } catch (NullPointerException ex) {

        }
    }

    public void actionPerformed() {
        try {
            salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText());
            System.out.println(usuario+": "+tfMensaje.getText());
            tfMensaje.setText("");

        } catch (IOException ex) {

        }
    }


}
