package dev.Sasha.client.model;

import java.util.ArrayList;
import java.util.Random;

public class TennisCourtModel {
    private ArrayList<BallModel> balls = new ArrayList<>();
    private GameModel gameModel;
    private RacketModel racketLeft;
    private RacketModel racketRight;
    private int scoreLeft = 0;
    private int scoreRight = 0;
    private int winSide = 0;
    Random random = new Random();

    public TennisCourtModel(GameModel gameModel){
        this.gameModel = gameModel;
        spawnBall(940, 500);
//        spawnBall(250, 80);

        racketLeft = new RacketModel(50, 500);
        racketRight = new RacketModel(1854, 500);
    }

    public void setRacketPosLeft(int y) {
        this.racketLeft.setRacketPos(y);
    }
    public void setRacketPosRight(int y) {
        this.racketRight.setRacketPos(y);
    }

    public void update(){
        if (scoreLeft >= 10){
            gameOver(1);
        }
        if (scoreRight >= 10){
            gameOver(2);
        }
    }

    public void gameOver(int winSide){
        // 1 - left
        // 2 - right
        scoreRight = 0;
        scoreLeft = 0;
        this.winSide = winSide;
        if (gameModel.isPlaying()){
            gameModel.changePlaying(false);
        }
    }


    public void spawnBall(int x, int y) {
        balls.add(new BallModel(this, x, y));
    }

    public ArrayList<BallModel> getBalls(){
        return balls;
    }

    public RacketModel getRacketLeft(){
        return racketLeft;
    }

    public RacketModel getRacketRight(){
        return racketRight;
    }
    public GameModel getGameModel() {return gameModel;}

    public void plusScoreLeft(){
        respawnBalls();
        scoreLeft++;
        gameModel.stopT();
    }

    public void plusScoreRight(){
        respawnBalls();
        scoreRight++;
        gameModel.stopT();
    }

    public void respawnBalls(){
        for (BallModel ball : balls){
            ball.setX(940);
            ball.setY(500);
        }
    }

    public int getScoreLeft(){
        return scoreLeft;
    }

    public int getScoreRight(){
        return scoreRight;
    }
}
