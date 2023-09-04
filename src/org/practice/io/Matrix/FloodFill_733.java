package org.practice.io.Matrix;

import org.junit.Test;

public class FloodFill_733 {


  public int[][] floodFill(int[][] image, int sr, int sc, int color) {

    boolean[][] visited = new boolean[image.length][image[0].length];

    floodFillHelper(image, sr, sc, color, visited, image[sr][sc]);

    return image;

  }

  private void floodFillHelper(int[][] image, int sr, int sc, int color, boolean[][] visited,
      int startingPixelColor) {
    //Base condition for matrix
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || visited[sr][sc]) {
      return;
    }
    visited[sr][sc] = true;
    if (image[sr][sc] == startingPixelColor) {
      image[sr][sc] = color;
      int[][] adjacentLocations = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
      for (int[] adjacent : adjacentLocations) {
        floodFillHelper(image, sr + adjacent[0], sc + adjacent[1], color, visited,
            startingPixelColor);
      }
    }
  }


  @Test
  public void test() {
    //floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    floodFill(new int[][]{{0,0,0}, {0,0,0}}, 0, 0, 0);
  }

}
