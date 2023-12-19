package dev.Sasha.client.view;

import dev.Sasha.client.model.BallModel;
import dev.Sasha.client.model.RacketModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GamePanelView extends JPanel {
    GameView gameView;
    private BufferedImage backgroundImg;
    private Color color = new Color(150, 20, 90);

    public GamePanelView(GameView gameView) {
        this.gameView = gameView;
//        mouseInputs = new MouseInputs(this);
//        keyboardInputs = new KeyboardInputs(this);
//
//        addKeyListener(keyboardInputs);
//        addMouseListener(mouseInputs);
//        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            drawField(g);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RacketModel racketLeft = gameView.getGameModel().getTennisCourt().getRacketLeft();
        RacketModel racketRight = gameView.getGameModel().getTennisCourt().getRacketRight();

        for (BallModel ball : gameView.getGameModel().getTennisCourt().getBalls()) {
            gameView.getTennisCourtView().drawBall(g, ball.getColor(), ball.getX(), ball.getY(), ball.getW(), ball.getH());
        }

        gameView.getTennisCourtView().drawRacket(g, racketLeft.getX(), racketLeft.getY(), racketLeft.getW(), racketLeft.getH());

        gameView.getTennisCourtView().drawRacket(g, racketRight.getX(), racketRight.getY(), racketRight.getW(), racketRight.getH());



        drawScore(g);

        g.setColor(color);
    }

    public void drawField(Graphics g) throws IOException {
        backgroundImg = ImageIO.read(new File("C:\\Users\\darkq\\Desktop\\ahaha\\tennisSocket\\ClientTennis\\res\\courtBG.png"));
        g.drawImage(backgroundImg,0,0,1920,1080,null);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void drawScore(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 70));
        g.drawString(" " + gameView.getGameModel().getTennisCourt().getScoreLeft(), 740, 1030);
        g.drawString(" " + gameView.getGameModel().getTennisCourt().getScoreRight(), 1100, 1030);
    }

    public GameView getGameView() {
        return gameView;
    }
}
