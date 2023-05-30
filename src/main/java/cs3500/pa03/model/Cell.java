package cs3500.pa03.model;

public class Cell {
  private Ship ship;

  private Coord coord;

  /**
   * Constructs a cell with no ship.
   */
  public Cell(int row, int col) {
    Coord coord = new Coord(row, col);
    this.coord = coord;
    Cell[] c = new Cell[1];
    c[0] = this;
    this.ship = new Empty(c);
  }

  /**
   * Gets the ship that is on this cell.
   */
  public Ship getShip() {
    return ship;
  }

  /**
   * Sets the ship that is on this cell.
   *
   * @param ship the ship to set
   */
  public void setShip(Ship ship) {
    this.ship = ship;
  }
}
