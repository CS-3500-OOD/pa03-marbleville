package cs3500.pa03.model;

public class Board {
  private Cell[][] board;

  /**
   * Constructs a board with the given number of rows and columns.
   *
   * @param rows the number of rows in this board
   * @param cols the number of columns in this board
   */
  public Board(int rows, int cols) {
    this.board = new Cell[rows][cols];

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        this.board[row][col] = new Cell(row, col);
      }
    }
  }

  /**
   * Places a given ship on the board at a random, valid coordinate.
   *
   * @param ship the ship to place
   */
  public void placeShip(Ship ship) {
    //TODO
  }

  /**
   * Returns this board
   *
   * @return this board
   */
  public Cell[][] getBoard() {
    return board;
  }
}
