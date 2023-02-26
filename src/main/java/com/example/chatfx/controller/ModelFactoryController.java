package com.example.chatfx.controller;

import com.example.chatfx.service.Chat;
import com.example.chatfx.service.ModelFactoryService;

public class ModelFactoryController implements ModelFactoryService {




        private Chat arcade;
        private static class SingletonHolder {
            private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
        }
        // Método para obtener la instancia de nuestra clase
        public static ModelFactoryController getInstance() {
            return SingletonHolder.eINSTANCE;
        }

        public Chat getArcade() {
            return arcade;
        }

        public void setArcade(Chat arcade) {
            this.arcade = arcade;
        }

        public ModelFactoryController() {
            arcade = new Chat();
        }
}
