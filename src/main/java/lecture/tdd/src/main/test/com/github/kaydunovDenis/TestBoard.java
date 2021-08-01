package com.github.kaydunovDenis;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(value = Parameterized.class)
public class TestBoard {

    private static final int ALIVE = 1;
    private static final int X = 1;
    private static final int Y = 1;

    @Test
    public void givenCellX1Y1returnsAlive() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Board board = new Board(matrix);
        Assertions.assertEquals(ALIVE, board.checkCell(X, Y));
    }

    @Test
    public void givenUnderpopulatedCellX1Y1NextStateDead() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Board board = new Board(matrix);
        board.step();
        Assertions.assertEquals(ALIVE, board.checkCell(X, Y));
    }

    @Test
    public void givenUnderpopulatedCellX1Y1NextStateDead(int[][] matrix) {
        Board board = new Board(matrix);
        board.step();
        Assertions.assertEquals(ALIVE, board.checkCell(X, Y));
    }

    //Parameters for ParameterizedTest
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1}, {2}, {3}, {4}};
        return Arrays.asList(data);
    }
}
