package cs3500.pa03.view;

public class BoardDisplayer {
  public static void displayBoard(String[][] myBoard, String[][] opponentBoard) {
    Printer.show("Opponent's Board:");
    for (String[] row : opponentBoard) {
      for (String cell : row) {
        System.out.print(cell);
      }
      System.out.println();
    }

    Printer.show("Your Board:");
    for (String[] row : myBoard) {
      for (String cell : row) {
        System.out.print(cell);
      }
      System.out.println();
    }
  }
}
