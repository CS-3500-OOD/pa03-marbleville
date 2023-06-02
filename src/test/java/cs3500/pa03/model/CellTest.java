package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
  Cell c;

  @BeforeEach
  public void setup() {
    c = new Cell(0, 0);
  }

  /**
   * Tests the hit and isHit methods
   */
  @Test
  public void testHit() {
    assertFalse(c.isHit());
    c.hit();
    assertTrue(c.isHit());
  }

  /**
   * Tests the firedUpon and isFiredUpon methods
   */
  @Test
  public void testFiredUpon() {
    assertFalse(c.isFiredUpon());
    c.firedUpon();
    assertTrue(c.isFiredUpon());
  }

  /**
   * Tests the setShip and getShip methods
   */
  @Test
  public void testSetShip() {
    Ship s = new Submarine(new Cell[] {c});
    c.setShip(s);
    assertEquals(s, c.getShip());
  }

  /**
   * Tests the get coord method
   */
  @Test
  public void testGetCoord() {
    assertEquals(0, c.getCoord().getRow());
    assertEquals(0, c.getCoord().getCol());
  }

  /**
   * Tests the toString method
   */
  @Test
  public void testToString() {
    c.setShip(new Submarine(new Cell[3]));
    assertEquals("S", c.toString());
    c.firedUpon();
    assertEquals("M", c.toString());
    c.hit();
    assertEquals("X", c.toString());
  }
}