package dev.Sasha.client;

import dev.Sasha.client.contoller.Controller;
import dev.Sasha.client.model.GameModel;
import dev.Sasha.client.view.GameView;

public class Main {
    public synchronized static void main(String[] args) {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView(gameModel);
        Controller controller = new Controller(gameView.getGamePanelView());
    }
}

// java serverUDP.java 8000
// java -jar .\dev.Sasha-0.1.0.jar localhost 8000
