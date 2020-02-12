package se.valjoh.aoc2019;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class TestPuzzle22 extends BasePuzzleTest {
  @Test
  public void testDealIntoNewStack() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    Assert.assertEquals(Puzzle22.reverse(deck), List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
  }

  @Test
  public void testCutWithPositiveNumber() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    Assert.assertEquals(Puzzle22.cut(deck, 3), List.of(3, 4, 5, 6, 7, 8, 9, 0, 1, 2));
  }

  @Test
  public void testCutWithNegativeNumber() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    Assert.assertEquals(Puzzle22.cut(deck, -4), List.of(6, 7, 8, 9, 0, 1, 2, 3, 4, 5));
  }

  @Test
  public void testDealWithIncrement() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    Assert.assertEquals(Puzzle22.increment(deck, 3), List.of(0, 7, 4, 1, 8, 5, 2, 9, 6, 3));
  }

  @Test
  public void testPart1Example1() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 7");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal into new stack");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal into new stack");
    Assert.assertEquals(deck, List.of(0, 3, 6, 9, 2, 5, 8, 1, 4, 7));
  }

  @Test
  public void testPart1Example2() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    deck = Puzzle22.applyShuffleInstruction(deck, "cut 6");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 7");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal into new stack");
    Assert.assertEquals(deck, List.of(3, 0, 7, 4, 1, 8, 5, 2, 9, 6));
  }

  @Test
  public void testPart1Example3() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 7");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 9");
    deck = Puzzle22.applyShuffleInstruction(deck, "cut -2");
    Assert.assertEquals(deck, List.of(6, 3, 0, 7, 4, 1, 8, 5, 2, 9));
  }

  @Test
  public void testPart1Example4() {
    List<Integer> deck = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    deck = Puzzle22.applyShuffleInstruction(deck, "deal into new stack");
    deck = Puzzle22.applyShuffleInstruction(deck, "cut -2");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 7");
    deck = Puzzle22.applyShuffleInstruction(deck, "cut 8");
    deck = Puzzle22.applyShuffleInstruction(deck, "cut -4");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 7");
    deck = Puzzle22.applyShuffleInstruction(deck, "cut 3");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 9");
    deck = Puzzle22.applyShuffleInstruction(deck, "deal with increment 3");
    deck = Puzzle22.applyShuffleInstruction(deck, "cut -1");
    Assert.assertEquals(deck, List.of(9, 2, 5, 8, 1, 4, 7, 0, 3, 6));
  }

  @Test
  public void testSolvePart1() throws Exception {
    var puzzle = new Puzzle22(getStoredInput(22));
    Assert.assertEquals(puzzle.solvePart1(), "1510");
  }

  @Test
  public void testSolvePart2() throws Exception {
    var puzzle = new Puzzle22(getStoredInput(22));
    Assert.assertEquals(puzzle.solvePart2(), "10307144922975");
  }
}
