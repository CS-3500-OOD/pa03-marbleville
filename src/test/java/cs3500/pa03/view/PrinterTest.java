package cs3500.pa03.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class PrinterTest {
  /**
   * Tests the showHelper method
   */
  @Test
  void testShowHelper() {
    StringBuilder out = new StringBuilder();
    Printer.show("Hello World!", out);
    assertEquals("Hello World!", out.toString());
  }

}