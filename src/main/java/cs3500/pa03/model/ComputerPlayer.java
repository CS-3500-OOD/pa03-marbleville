package cs3500.pa03.model;

import java.util.List;
import java.util.Map;

public class ComputerPlayer implements Player {
  @Override
  public String name() {
    return "AI";
  }

  @Override
  public List<Ship> setup(int height, int width, Map<Ship, Integer> specifications) {
    return null;
  }

  @Override
  public List<Coord> takeShots() {
    return null;
  }

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return null;
  }

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {

  }

  @Override
  public void endGame(GameResult result, String reason) {

  }
}
