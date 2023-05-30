package cs3500.pa03.model;

import java.util.List;
import java.util.Map;

public class ManualPlayer implements Player {
  private String name;

  private Board board;

  /**
   * Constructs a manual player with the given name.
   *
   * @param name the name of the player
   */
  public ManualPlayer(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.board = new Board(height, width);
    return this.board.setup(specifications);
  }

  @Override
  public List<Coord> takeShots() {
    // calls controller class which calls view to get input
    return null;
  }

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return null;
  }

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    // call view to display hits
  }

  @Override
  public void endGame(GameResult result, String reason) {
    // call view to display end game
  }
}
