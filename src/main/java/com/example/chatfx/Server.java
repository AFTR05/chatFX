package com.example.chatfx;

import com.example.chatfx.utilities.ChatMessage;
import com.example.chatfx.utilities.ClientConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.application.Application;

public class Server {
    public static void main(String[] args) {

        // Carga el archivo de configuracion de log4J
        // PropertyConfigurator.configure("log4j.properties");
        Logger log = Logger.getLogger(String.valueOf(Server.class));

        int puerto = 5050;
        int maximoConexiones = 10; // Maximo de conexiones simultaneas
        ServerSocket servidor = null;
        Socket socket = null;
        ChatMessage mensajes = new ChatMessage();

        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);

            // Bucle infinito para esperar conexiones
            while (true) {
                log.info("Servidor a la espera de conexiones.");
                socket = servidor.accept();
                log.info("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");

                ClientConnection cc = new ClientConnection(socket, mensajes);
                cc.start();

            }
        } catch (IOException ex) {
            // log.error("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (IOException ex) {
                // log.error("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
}
