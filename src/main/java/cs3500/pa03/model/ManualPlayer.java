package cs3500.pa03.model;

import cs3500.pa03.controller.InputParser;
import cs3500.pa03.controller.OutputParser;
import cs3500.pa03.view.Printer;
import java.util.List;
import java.util.Map;

public class ManualPlayer implements Player {
  private String name;

  private Board board;

  private Board opponentBoard;

  /**
   * Constructs a manual player with the given name.
   *
   * @param name the name of the player
   */
  public ManualPlayer(String name) {
    this.name = name;
  }


  /**
   * Returns this player's board
   *
   * @return the board
   */
  public Board getBoard() {
    return this.board;
  }

  /**
   * Returns this player's opponent's board
   *
   * @return the opponent's board
   */
  public Board getOpponentBoard() {
    return this.opponentBoard;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.opponentBoard = new Board(height, width);
    this.board = new Board(height, width);
    return this.board.setup(specifications);
  }

  @Override
  public List<Coord> takeShots() {
    for (Coord c : InputParser.getListOfShots(this)) {
      if (c.getRow() >= this.opponentBoard.getNumRows() ||
          c.getCol() >= this.opponentBoard.getNumCols()) {
        OutputParser.show("Invalid coordinate: " + c);
        return takeShots();
      }
    }
    return InputParser.getListOfShots(this);
  }

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return board.reportDamage(opponentShotsOnBoard);
  }

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    this.opponentBoard.successfulHits(shotsThatHitOpponentShips);
  }

  @Override
  public void endGame(GameResult result, String reason) {
    Printer.show(this.name + " " + result + " because " + reason);
  }
}
