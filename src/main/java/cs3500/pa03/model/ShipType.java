package cs3500.pa03.model;

public enum ShipType {
  CARRIER,
  BATTLESHIP,
  DESTROYER,
  SUBMARINE;

  /**
   * Returns a new ship of the specified type.
   *
   * @return a new ship of the specified type
   */
  public Ship getShip() {
    switch (this) {
      case CARRIER:
        return new Carrier(new Cell[6]);
      case BATTLESHIP:
        return new Battleship(new Cell[5]);
      case DESTROYER:
        return new Destroyer(new Cell[4]);
      case SUBMARINE:
        return new Submarine(new Cell[3]);
      default:
        throw new IllegalArgumentException("Invalid ship type");
    }
  }
}
