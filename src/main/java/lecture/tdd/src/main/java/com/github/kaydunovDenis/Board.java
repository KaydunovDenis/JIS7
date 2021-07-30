package com.github.kaydunovDenis;

import java.util.Arrays;

public class Board {
    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int X = 1;
    private static final int Y = 1;
    private final int[][] matrix;

    public Board(int[][] matrix) {

        this.matrix = matrix;
    }

    public int checkCell(int x, int y) {
        return matrix[x][y];
    }

    public void step() {
        var aliveNeighbors = Arrays.stream(matrix).count();
        if (aliveNeighbors == 3) {
            matrix[X][Y] = ALIVE;
        } else matrix[X][Y] = DEAD;
    }
}
