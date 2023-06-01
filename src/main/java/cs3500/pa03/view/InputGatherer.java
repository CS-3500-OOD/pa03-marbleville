package cs3500.pa03.view;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InputGatherer {

  /**
   * Helper for getShots
   *
   * @param numShots the number of shots to get
   * @param in       the input stream to read from
   * @return list of shots given by the player
   */
  public static ArrayList<String> getShotsHelper(int numShots, Readable in) {
    Scanner input = new Scanner(in);
    Printer.show("Please enter " + numShots + " shots.");
    ArrayList<String> shots = new ArrayList<>();
    for (int i = 0; i < numShots; i++) {
      shots.add(input.nextLine());
    }
    return shots;
  }

  /**
   * Gets the shots a player wants to make from the console.
   *
   * @param numShots the number of shots to get
   * @return list of shots given by the player
   */
  public static ArrayList<String> getShots(int numShots) {
    return getShotsHelper(numShots, new InputStreamReader(System.in));
  }

  /**
   * Helper for getDimensions
   *
   * @return list of dimensions given by the player
   */
  public static String getLineHelper(Readable in) {
    Scanner input = new Scanner(in);
    return input.nextLine();
  }

  /**
   * Gets the board dimensions from the console.
   *
   * @return list of dimensions given by the player
   */
  public static String getLine() {
    return getLineHelper(new InputStreamReader(System.in));
  }
}
