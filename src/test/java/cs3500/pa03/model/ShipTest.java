package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
  Ship s;

  @BeforeEach
  void setUp() {
    s = new Submarine(new Cell[1]);
    for (int i = 0; i < s.getCells().length; i++) {
      s.getCells()[i] = new Cell(0, 0);
    }
  }

  /**
   * Tests the setCell method
   */
  @Test
  void setCell() {
    Cell c = new Cell(0, 0);
    s.setCell(0, c);
    assertEquals(c, s.getCells()[0]);
  }

  /**
   * Tests the toString method
   */
  @Test
  void testToString() {
    assertEquals("S", s.toString());
  }

  /**
   * Tests the isSunk method
   */
  @Test
  void isSunk() {
    assertFalse(s.isSunk());
    for (Cell c : s.getCells()) {
      c.hit();
    }
    assertTrue(s.isSunk());
  }
}