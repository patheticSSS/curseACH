package dev.Sasha.client.model;

import dev.Sasha.client.Constants;

import java.awt.*;

public class BallModel {
    private TennisCourtModel tennisCourtModel;
    private int x, y, w, h;
    private int xDir = 4, yDir = 2;
    private Color color;

    private boolean collider = false;

    public BallModel(TennisCourtModel tennisCourtModel, int x, int y) {
        this.tennisCourtModel = tennisCourtModel;
        this.x = x;
        this.y = y;
        w = 60;
        h = w;
        color = Color.BLACK;
    }

    public void updateBall() {
        this.x += xDir;
        this.y += yDir;


        if ((x+w) < tennisCourtModel.getRacketLeft().getX() + w)
            if ((y + h) <= (tennisCourtModel.getRacketLeft().getY() + tennisCourtModel.getRacketLeft().getH() + 15))
                if ((y + h) > (tennisCourtModel.getRacketLeft().getY()))
                    if (xDir < 0)
                        if ((x+w) - tennisCourtModel.getRacketLeft().getX() >= xDir){
                            xDir *= -1;
                        }

        if ((x+w) > tennisCourtModel.getRacketRight().getX())
            if ((y + h) <= (tennisCourtModel.getRacketRight().getY() + tennisCourtModel.getRacketRight().getH() + 15))
                if ((y + h) > (tennisCourtModel.getRacketRight().getY()))
                    if (xDir > 0)
                        if ((x+w) - tennisCourtModel.getRacketRight().getX() <= xDir){
                            xDir *= -1;
                        }

        if ((x + w) > Constants.WindowWidth - 15 || x < 0) {
            xDir *= -1;
            if (x < 0){
                tennisCourtModel.plusScoreRight();
            } else {
                tennisCourtModel.plusScoreLeft();
            }
        }
        if ((y + h) > Constants.WindowHeight - 45 || y < 0) {
            yDir *= -1;
        }

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public Color getColor(){
        return color;
    }

}