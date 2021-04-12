package edu.cnm.deepdive;

public class Search {

  public static int binarySearchRecursive(int needle, int[] hayStack) {
    return binarySearch(needle, hayStack, 0, hayStack.length);
  }

  public static int binarySearch(int needle, int[] hayStack) {
    int position = -1;
    int beginIndex = 0;
    int endIndex = hayStack.length;
    while (beginIndex < endIndex) {
      int midPoint = (beginIndex + endIndex) / 2;
      int midPointValue = hayStack[midPoint];
      if (needle == midPointValue) {
        position = midPoint;
        break;
      } else if (needle < midPointValue) {
        endIndex = midPoint;
      } else {
        beginIndex = midPoint + 1;
      }
    }
    return (position >= 0)
        ? position
        : ~beginIndex;
  }

  public static int binarySearch(int needle, int[] hayStack, int beginIndex, int endIndex) {
    int position;
    if (endIndex <= beginIndex) {
      position = ~beginIndex;
    } else {
      int midPoint = (beginIndex + endIndex) / 2;
      int midPointValue = hayStack[midPoint];
      if (needle == midPointValue) {
        position = midPoint;
      } else if (needle < midPointValue) {
        position = binarySearch(needle, hayStack, beginIndex, midPoint);
      } else {
        position = binarySearch(needle, hayStack, midPoint + 1, endIndex);
      }
    }
    return position;
  }
}
