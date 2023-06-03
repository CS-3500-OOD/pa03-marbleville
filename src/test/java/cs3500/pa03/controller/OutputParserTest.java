package cs3500.pa03.controller;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.model.ShipType;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class OutputParserTest {
  /**
   * Tests the showBoards method
   */
  @Test
  void testShowBoards() {
    ManualPlayer player = new ManualPlayer("player");
    HashMap<ShipType, Integer> specs = new HashMap<>();
    specs.put(ShipType.BATTLESHIP, 1);
    specs.put(ShipType.DESTROYER, 1);
    specs.put(ShipType.SUBMARINE, 1);
    specs.put(ShipType.CARRIER, 1);
    player.setup(10, 10, specs);

    StringBuilder sb = new StringBuilder();
    OutputParser.showBoards(player, sb);
    assertEquals("Opponent's Board:\n" +
        "0 0 0 0 0 0 0 0 0 ", sb.substring(0, 36));
  }

  /**
   * Tests the show method
   */
  @Test
  void testShow() {
    StringBuilder sb = new StringBuilder();
    OutputParser.show("Hello", sb);
    assertEquals("Hello", sb.toString());
  }
}