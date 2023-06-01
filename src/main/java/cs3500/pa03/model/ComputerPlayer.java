package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComputerPlayer implements Player {
  private Board board;

  private Board opponentBoard;

  private ArrayList<Coord> shotsMade = new ArrayList<>();

  @Override
  public String name() {
    return "AI";
  }

  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.opponentBoard = new Board(height, width);
    this.board = new Board(height, width);
    return this.board.setup(specifications);
  }

  @Override
  public List<Coord> takeShots() {
    ArrayList<Coord> shots = new ArrayList<>();
    int numChecked = 0;
    while (shots.size() < this.board.getShips().size() ||
        numChecked >= board.getNumRows() * board.getNumCols()) {
      for (Cell[] cell : this.opponentBoard.getBoard()) {
        for (Cell c : cell) {
          numChecked++;
          if (c.isHit()) {
            // gets this cell neighbors and fires at them
            for (Cell cell1 : this.opponentBoard.getNeighborCells(c)) {
              if (!cell1.isHit() && !shotsMade.contains(cell1.getCoord())) {
                shots.add(cell1.getCoord());
                shotsMade.add(cell1.getCoord());
              }
            }
          }
        }
      }
    }
    // it not enough made shots to use above loop, shoot randomly
    if (shots.size() < this.board.getShips().size()) {
      while (shots.size() < this.board.getShips().size()) {
        Coord c = new Coord((int) (Math.random() * this.opponentBoard.getNumRows()),
            (int) (Math.random() * this.opponentBoard.getNumCols()));
        if (!shotsMade.contains(c)) {
          shots.add(c);
          shotsMade.add(c);
        }
      }
    }
    return shots;
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
    // Do anything?
  }

  /**
   * Returns this players board
   *
   * @return this players board
   */
  public Board getBoard() {
    return this.board;
  }
}
