package com.example.chatfx.service;

import com.example.chatfx.controller.ClientController;

public class Chat {
    private final ClientController clientController;

    public Chat() {
        this.clientController = new ClientController();
    }

    public ClientController getClientController() {
        return clientController;
    }
}
