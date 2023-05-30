package cs3500.pa03.model;

import java.util.List;
import java.util.Map;

public class ComputerPlayer implements Player {
  private Board board;

  @Override
  public String name() {
    return "AI";
  }

  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.board = new Board(height, width);
    return this.board.setup(specifications);
  }

  @Override
  public List<Coord> takeShots() {
    // AI goes here in some way
    return null;
  }

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return null;
  }

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    // change AI strategy here based on hits
  }

  @Override
  public void endGame(GameResult result, String reason) {
    // Do anything?
  }
}
