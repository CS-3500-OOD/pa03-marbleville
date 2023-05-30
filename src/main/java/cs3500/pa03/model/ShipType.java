package cs3500.pa03.model;

public abstract class ShipType {

  private Cell[] cells;

  private static String name;

  private static String symbol;

  /**
   * Constructs a ship with the given cells.
   *
   * @param cells the cells that this ship occupies
   */
  public ShipType(Cell[] cells, String name, String symbol) {
    this.cells = cells;
    this.name = name;
    this.symbol = symbol;
  }

  /**
   * Gets the length of this ship.
   *
   * @return the length of this ship
   */
  public int getLength() {
    return this.cells.length;
  }

  /**
   * Gets the cells that this ship occupies.
   *
   * @return the cells that this ship occupies
   */
  public Cell[] getCells() {
    return this.cells;
  }

  /**
   * Gets the name of this ship.
   *
   * @return the name of this ship
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the symbol representing this ship.
   *
   * @return the symbol representing this ship
   */
  public String getSymbol() {
    return this.symbol;
  }
}


