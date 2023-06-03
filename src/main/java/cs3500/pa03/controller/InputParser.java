package cs3500.pa03.controller;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.model.Player;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.view.InputGatherer;
import cs3500.pa03.view.Printer;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InputParser {
  /**
   * Pareses and validates inputs gathered from the view into a list of coordinates.
   *
   * @return a list of coordinates
   */
  public static ArrayList<Coord> getListOfShots(ManualPlayer player, Readable in) {
    ArrayList<String> input =
        InputGatherer.getShots(player.getBoard().getShips().size(), in);
    ArrayList<Coord> coords = new ArrayList<>();
    if (input.size() != player.getBoard().getShips().size()) {
      Printer.show("Incorrect number of shots.", System.out);
      return InputParser.getListOfShots(player, in);
    } else {
      for (String s : input) {
        try {
          coords.add(new Coord(s));
        } catch (IllegalArgumentException e) {
          Printer.show("Invalid coordinate.", System.out);
          return InputParser.getListOfShots(player, in);
        }
      }
      return coords;
    }
  }

  /**
   * Parses and validates inputs gathered from the view a height and with to set up the game.
   *
   * @return an array of integers representing the height and width
   */
  public static ArrayList<Integer> getDimensions(Readable in) {
    String input = InputGatherer.getLine(in);
    ArrayList<Integer> dimensions = new ArrayList<>();
    if (input.split(" ").length != 2) {
      Printer.show("Incorrect number of dimensions.", System.out);
      return InputParser.getDimensions(in);
    } else {
      for (String s : input.split(" ")) {
        try {
          dimensions.add(Integer.parseInt(s));
        } catch (NumberFormatException e) {
          Printer.show("Invalid dimension.", System.out);
          return InputParser.getDimensions(in);
        }
      }
      return dimensions;
    }
  }

  /**
   * Parses and validates inputs gathered from the view into a map of ship specifications
   *
   * @return a map of ship specifications
   */
  public static HashMap<ShipType, Integer> getSpecifications(Readable in) {
    String input = InputGatherer.getLine(in);
    HashMap<ShipType, Integer> specifications = new HashMap<ShipType, Integer>();
    if (input.split(" ").length != 4) {
      Printer.show("Incorrect number of specifications.", System.out);
      return InputParser.getSpecifications(in);
    } else {
      int idx = 0;
      for (String s : input.split(" ")) {
        try {
          specifications.put(ShipType.getTypeFromNumber(idx), Integer.parseInt(s));
          idx++;
        } catch (NumberFormatException e) {
          Printer.show("Invalid specification.", System.out);
          return InputParser.getSpecifications(in);
        }
      }
      return specifications;
    }
  }
}
