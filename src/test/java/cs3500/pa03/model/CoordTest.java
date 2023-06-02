package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordTest {

  @Test
  void testGetRow() {
    Coord c = new Coord(1, 2);
    assertEquals(1, c.getRow());
  }

  @Test
  void testGetCol() {
    Coord c = new Coord(1, 2);
    assertEquals(2, c.getCol());
  }

  @Test
  void testEquals() {
    Coord c1 = new Coord(1, 2);
    Coord c2 = new Coord(1, 2);
    Coord c3 = new Coord(2, 1);
    assertTrue(c1.equals(c2));
    assertFalse(c1.equals(c3));
  }
}