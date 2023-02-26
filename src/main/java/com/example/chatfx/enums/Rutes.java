package com.example.chatfx.enums;

public enum Rutes {
    CLIENT("view/clientView.fxml"),SERVER("view/serverView.fxml"),ENTRY("view/entryModal.fxml");
    private String rute;

    Rutes(String rute) {
        this.rute = rute;
    }

    public String getRute() {
        return rute;
    }
}
