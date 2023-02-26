package com.example.chatfx.utilities;

import java.util.Observable;
public class ChatMessage extends Observable {
    private String message;

    public ChatMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.setChanged();
        this.notifyObservers(this.getMessage());

    }
}
