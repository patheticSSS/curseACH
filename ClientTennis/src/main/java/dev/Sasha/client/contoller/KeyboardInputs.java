package dev.Sasha.client.contoller;

import dev.Sasha.client.view.GamePanelView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanelView gamePanel;

    public KeyboardInputs(GamePanelView gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (gamePanel.getGameView().getGameModel().getTennisCourt().getRacketLeft().getY() > 40)
                    gamePanel.getGameView().getGameModel().getTennisCourt().setRacketPosLeft(gamePanel.getGameView().getGameModel().getTennisCourt().getRacketLeft().getY()-20);

                break;
            case KeyEvent.VK_S:
                if (gamePanel.getGameView().getGameModel().getTennisCourt().getRacketLeft().getY() < 900)
                    gamePanel.getGameView().getGameModel().getTennisCourt().setRacketPosLeft(gamePanel.getGameView().getGameModel().getTennisCourt().getRacketLeft().getY()+110);
                break;
            case KeyEvent.VK_NUMPAD8:
                if (gamePanel.getGameView().getGameModel().getTennisCourt().getRacketRight().getY() > 40)
                    gamePanel.getGameView().getGameModel().getTennisCourt().setRacketPosRight(gamePanel.getGameView().getGameModel().getTennisCourt().getRacketRight().getY()-20);
                break;
            case KeyEvent.VK_NUMPAD5:
                if (gamePanel.getGameView().getGameModel().getTennisCourt().getRacketRight().getY() < 900)
                    gamePanel.getGameView().getGameModel().getTennisCourt().setRacketPosRight(gamePanel.getGameView().getGameModel().getTennisCourt().getRacketRight().getY()+110);
                break;
        }

    }

}