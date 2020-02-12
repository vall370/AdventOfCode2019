package se.valjoh.aoc2019;

import se.valjoh.aoc2019.geom2d.Direction;
import se.valjoh.aoc2019.geom2d.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class TestPuzzle15 extends BasePuzzleTest {
  @Test
  public void testPart1Example1() {
    // Isomorphic to the example given in part 1
    var droid = new MockDroidState(from(Direction.SOUTH, Direction.WEST),
        Set.of(from(), from(Direction.EAST), from(Direction.EAST, Direction.EAST), from(Direction.SOUTH), from(Direction.SOUTH, Direction.WEST)));
    var ship = new Puzzle15.ShipState(droid);
    Assert.assertEquals(ship.distanceToOxygen(), 2);
  }

  @Test
  public void testSolvePart1() throws Exception {
    var puzzle = new Puzzle15(getStoredInput(15));
    Assert.assertEquals(puzzle.solvePart1(), "280");
  }

  @Test
  public void testPart2Example1() {
    // Isomorphic to the example given in part 2
    var droid = new MockDroidState(
        from(Direction.WEST, Direction.SOUTH, Direction.SOUTH, Direction.EAST),
        Set.of(
            from(),
            from(Direction.WEST),
            from(Direction.WEST, Direction.SOUTH),
            from(Direction.WEST, Direction.SOUTH, Direction.SOUTH),
            from(Direction.WEST, Direction.SOUTH, Direction.SOUTH, Direction.EAST),
            from(Direction.WEST, Direction.SOUTH, Direction.SOUTH, Direction.EAST, Direction.EAST),
            from(Direction.WEST, Direction.SOUTH, Direction.SOUTH, Direction.EAST, Direction.EAST, Direction.NORTH),
            from(Direction.WEST, Direction.SOUTH, Direction.SOUTH, Direction.EAST, Direction.EAST, Direction.NORTH, Direction.EAST)));
    var ship = new Puzzle15.ShipState(droid);
    Assert.assertEquals(ship.longestPathFromOxygen(), 4);
  }

  @Test
  public void testSolvePart2() throws Exception {
    var puzzle = new Puzzle15(getStoredInput(15));
    Assert.assertEquals(puzzle.solvePart2(), "400");
  }

  private static Point from(Direction... directions) {
    var point = Puzzle15.DroidState.STARTING_POSITION;
    for (var direction : directions) {
      point = direction.move(point);
    }
    return point;
  }

  private static class MockDroidState implements Puzzle15.DroidState {
    private Set<Point> _reachable;
    private Point _oxygen;
    private Point _location = Puzzle15.DroidState.STARTING_POSITION;

    public MockDroidState(Point oxygen, Set<Point> reachable) {
      _oxygen = oxygen;
      _reachable = reachable;
    }

    @Override
    public Puzzle15.State move(Direction direction) {
      var p = direction.move(_location);
      if (p.equals(_oxygen)) {
        _location = p;
        return Puzzle15.State.OXYGEN_SYSTEM;
      }
      if (_reachable.contains(p)) {
        _location = p;
        return Puzzle15.State.EMPTY;
      }
      return Puzzle15.State.WALL;
    }

    @Override
    public Point getLocation() {
      return _location;
    }

    @Override
    public void close() {
    }
  }
}
