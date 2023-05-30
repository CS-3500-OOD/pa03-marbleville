package cs3500.pa03.model;

public class Submarine extends ShipType {
  /**
   * Constructor for Submarine.
   *
   * @param cells the cells that the ship occupies
   */
  public Submarine(Cell[] cells) {
    super(cells, "Submarine", "S");
  }
}
