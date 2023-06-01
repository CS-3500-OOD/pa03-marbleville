package cs3500.pa03.model;

import cs3500.pa03.controller.InputParser;
import cs3500.pa03.controller.OutputParser;
import cs3500.pa03.view.BoardDisplayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents and initializes a game of BattleSalvo.
 */
public class BattleSalvoGame {
  private ManualPlayer manualPlayer;
  private ComputerPlayer computerPlayer;

  private GameResult result = GameResult.IN_PROGRESS;

  /**
   * Constructs a BattleSalvoGame.
   */
  public BattleSalvoGame() {
    this.manualPlayer = new ManualPlayer("Player");
    this.computerPlayer = new ComputerPlayer();
  }

  /**
   * Starts the game.
   */
  public void start() {
    setup();
    playGame();
  }

  /**
   * Initializes the game boards for each player
   */
  public void setup() {
    OutputParser.show("Welcome to BattleSalvo!\nPlease enter a valid height and width:\n");
    ArrayList<Integer> dimensions = InputParser.getDimensions();
    OutputParser.show("Please enter the number of each type of ship in order of [Carrier, "
        + "Battleship, Destroyer, Submarine]:\n");
    HashMap<ShipType, Integer> specifications = InputParser.getSpecifications();
    this.manualPlayer.setup(dimensions.get(0), dimensions.get(1), specifications);
    this.computerPlayer.setup(dimensions.get(0), dimensions.get(1), specifications);
  }

  public void playGame() {
    while (this.result == GameResult.IN_PROGRESS) {
      OutputParser.showBoards(manualPlayer);
      if (this.manualPlayer.getBoard().getShips().size() == 0) {
        this.result = GameResult.LOSE;
        manualPlayer.endGame(this.result, "Your ships sunk!");
        break;
      }
      if (this.computerPlayer.getBoard().getShips().size() == 0) {
        this.result = GameResult.LOSE;
        manualPlayer.endGame(this.result, "You sunk all their ships!");
        break;
      }
      OutputParser.show("Please enter a valid coordinate to fire at:\n");
      List<Coord> playerShots = manualPlayer.takeShots();
      List<Coord> computerShots = computerPlayer.takeShots();
      manualPlayer.successfulHits(computerPlayer.reportDamage(playerShots));
      computerPlayer.successfulHits(manualPlayer.reportDamage(computerShots));
    }
  }
}
