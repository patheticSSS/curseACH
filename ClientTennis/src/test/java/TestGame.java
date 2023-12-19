

import dev.Sasha.client.model.BallModel;
import dev.Sasha.client.model.GameModel;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class TestGame {
    @Test
    public void ScoreTest() throws InterruptedException {
        GameModel gameModel = new GameModel();
        gameModel.changePlaying(true);
        for (BallModel ball : gameModel.getTennisCourt().getBalls()) {
            ball.setX(-1000);
        }
        Thread.sleep(5);
        int result = gameModel.getTennisCourt().getScoreRight();
        Thread.sleep(5);
        assertEquals(result, 1);
    }



}