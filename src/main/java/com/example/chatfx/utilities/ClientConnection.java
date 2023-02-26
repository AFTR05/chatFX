package com.example.chatfx.utilities;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;


import java.util.Observable;
import java.util.Observer;

public class ClientConnection extends Thread implements Observer {
    private Logger log= Logger.getLogger(String.valueOf(ClientConnection.class));
    private Socket socket;
    private ChatMessage messages;
    private DataInputStream inputData;
    private DataOutputStream outputData;


    public ClientConnection(Socket socket, ChatMessage messages) {
        this.socket = socket;
        this.messages = messages;
        try{
            inputData=new DataInputStream(socket.getInputStream());
            outputData=new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){
            System.out.println("error al crear los streams");
        }
    }

    @Override
    public void run() {
        String receivedMessage;
        Boolean connected = true;
        messages.addObserver(this);
        while (connected) {
            try {
                receivedMessage = inputData.readUTF();
                messages.setMessage(receivedMessage);
            } catch (IOException e) {
                log.info("Error al leer el mensaje");
                connected = false;
                try {
                    inputData.close();
                    outputData.close();
                }catch (IOException e1){
                    System.out.println("Error al cerrar los sockets");
                }
            }


        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try{
            outputData.writeUTF(arg.toString());
        }catch (IOException e){
            System.out.println("Error al enviar el mensaje al cliente");
        }
    }
}
