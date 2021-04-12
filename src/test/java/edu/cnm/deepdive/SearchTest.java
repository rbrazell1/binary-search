package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchTest {

  @ParameterizedTest
  @MethodSource({"needlePresent", "needleNotPresent"})
  void binarySearch(int needle, int[] hayStack, int expectedBegin, int expectedEnd) {
    int actual = Search.binarySearch(needle, hayStack);
    assertTrue(actual >= expectedBegin && actual < expectedEnd);
  }

  static Stream<Arguments> needlePresent() {
    return Stream.of(
        Arguments.of(1, new int[]{0, 1, 2}, 1, 2),
        Arguments.of(3, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, 3, 6),
        Arguments.of(1, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, 0, 2),
        Arguments.of(5, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, 7, 8)
    );
  }

  void binarySearch_notPresent(int needle, int[] hayStack, int expectedBegin, int expectedEnd) {
    int actual = Search.binarySearch(needle, hayStack);
    assertTrue(actual >= expectedBegin && actual < expectedEnd);
  }

  static Stream<Arguments> needleNotPresent() {
    return Stream.of(
        Arguments.of(-1, new int[]{0, 1, 2}, -1, 0),
        Arguments.of(4, new int[]{1, 1, 2, 3, 3, 3, 5}, -7, -6),
        Arguments.of(2, new int[]{1, 1, 3, 3, 3, 4, 5}, -3, -2),
        Arguments.of(-1, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, -1, 0),
        Arguments.of(10, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, -9, -8)
    );
  }


}