package cs3500.pa03.model;

public class Carrier extends ShipType {
  /**
   * Constructor for Carrier.
   *
   * @param cells the cells that the ship occupies
   */
  public Carrier(Cell[] cells) {
    super(cells, "Carrier", "C");
  }
}
