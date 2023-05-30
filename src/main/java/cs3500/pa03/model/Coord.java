package cs3500.pa03.model;

public class Coord {
  private int row;
  private int col;

  /**
   * Constructs a coordinate with the given row and column.
   *
   * @param row the row of this coordinate
   * @param col the column of this coordinate
   */
  public Coord(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Gets the row of this coordinate.
   *
   * @return the row of this coordinate
   */
  public int getRow() {
    return row;
  }

  /**
   * Gets the column of this coordinate.
   *
   * @return the column of this coordinate
   */
  public int getCol() {
    return col;
  }

  /**
   * Compares this Coord for equality with the given Coord.
   *
   * @param o the Coord to compare to
   * @return true if the given Coord is equal to this Coord, false otherwise
   */
  public boolean equals(Coord o) {
    return o.row == this.row && o.col == this.col;
  }
}
