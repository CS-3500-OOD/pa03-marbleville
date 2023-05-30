package cs3500.pa03.model;

public class Battleship extends ShipType {
  /**
   * Constructor for Battleship.
   *
   * @param cells the cells that the ship occupies
   */
  public Battleship(Cell[] cells) {
    super(cells, "Battleship", "B");
  }
}
