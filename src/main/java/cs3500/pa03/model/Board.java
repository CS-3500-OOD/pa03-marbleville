package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Board {
  private Cell[][] board;

  private ArrayList<Ship> ships = new ArrayList<>();

  private Random rand;

  /**
   * Constructs a board with the given number of rows and columns.
   *
   * @param rows the number of rows in this board
   * @param cols the number of columns in this board
   */
  public Board(int rows, int cols) {
    this.board = new Cell[rows][cols];
    this.rand = new Random();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        this.board[row][col] = new Cell(row, col);
      }
    }
  }

  public Board(int rows, int cols, int seed) {
    this(rows, cols);
    this.rand = new Random(seed);
  }

  /**
   * Sets up this board with the given specifications.
   *
   * @param specifications a map of ship type to the number of occurrences each ship should
   * @return the placements of each ship on the board
   */
  public ArrayList<Ship> setup(Map<ShipType, Integer> specifications) {
    //TODO
    // Make ship based on type
    // call placeShip on each ship
    // push each ship to the ships arraylist
    return ships;
  }

  /**
   * Places a given ship on the board in a random, valid position.
   *
   * @param ship the ship to place
   */
  public void placeShip(Ship ship) {
    // GEts cells that are empty
    ArrayList<Cell> unpopulated = getUnpopulated();
    // While loop control
    boolean shipPlaced = false;
    while (!shipPlaced) {
      if (unpopulated.isEmpty()) {
        throw new IllegalArgumentException("No more unpopulated cells");
      }
      // Get random cell and generate possible ship locations from it
      Cell randomCell = unpopulated.get(rand.nextInt(unpopulated.size()));
      ArrayList<Cell> consecutiveVertical = getVerticalConsecutive(randomCell);
      ArrayList<Cell> consecutiveHorizontal = getHorizontalConsecutive(randomCell);

      // Remove these cells from possible cells to search
      for (Cell c : consecutiveVertical) {
        unpopulated.remove(c);
      }
      for (Cell c : consecutiveHorizontal) {
        unpopulated.remove(c);
      }

      // If horizontal or vertical are long enough, randomly place the ship within, else, try again
      int shipCellIdx = 0;
      if (consecutiveVertical.size() >= ship.getLength()) {
        int index = rand.nextInt(consecutiveVertical.size() - ship.getLength() + 1);
        for (int i = index; i < index + ship.getLength(); i++) {
          consecutiveVertical.get(i).setShip(ship);
          // Sets ship cells
          ship.setCell(shipCellIdx, consecutiveVertical.get(i));
          shipCellIdx++;
        }
        shipPlaced = true;
      } else if (consecutiveHorizontal.size() >= ship.getLength()) {
        int index = rand.nextInt(consecutiveHorizontal.size() - ship.getLength() + 1);
        for (int i = index; i < index + ship.getLength(); i++) {
          consecutiveHorizontal.get(i).setShip(ship);
          ship.setCell(shipCellIdx, consecutiveHorizontal.get(i));
          shipCellIdx++;
        }
        shipPlaced = true;
      }
    }
  }

  /**
   * Returns and ArrayList of cells that are horizontally consecutive to the given cell.
   *
   * @param cell the cell to check
   * @return an ArrayList of cells that are horizontally consecutive to the given cell
   */
  private ArrayList<Cell> getHorizontalConsecutive(Cell cell) {
    ArrayList<Cell> consecutive = new ArrayList<>();
    int row = cell.getCoord().getRow();
    int col = cell.getCoord().getCol() - 1;
    while (col >= 0 && board[row][col].getShip() instanceof Empty) {
      consecutive.add(board[row][col]);
      col--;
    }
    col = cell.getCoord().getCol();
    while (col < board[0].length && board[row][col].getShip() instanceof Empty) {
      consecutive.add(board[row][col]);
      col++;
    }
    return consecutive;
  }

  /**
   * Returns and ArrayList of cells that are horizontally consecutive to the given cell.
   *
   * @param cell the cell to check
   * @return an ArrayList of cells that are horizontally consecutive to the given cell
   */
  private ArrayList<Cell> getVerticalConsecutive(Cell cell) {
    ArrayList<Cell> consecutive = new ArrayList<>();
    int row = cell.getCoord().getRow() - 1;
    int col = cell.getCoord().getCol();
    while (row >= 0 && board[row][col].getShip() instanceof Empty) {
      consecutive.add(board[row][col]);
      row--;
    }
    row = cell.getCoord().getRow();
    while (row < board.length && board[row][col].getShip() instanceof Empty) {
      consecutive.add(board[row][col]);
      row++;
    }
    return consecutive;
  }

  /**
   * Returns the unpopulated cells on this board.
   *
   * @return the unpopulated cells on this board
   */
  private ArrayList<Cell> getUnpopulated() {
    ArrayList<Cell> unpopulated = new ArrayList<>();
    for (Cell[] row : board) {
      for (Cell cell : row) {
        if (cell.getShip() instanceof Empty) {
          unpopulated.add(cell);
        }
      }
    }
    return unpopulated;
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
