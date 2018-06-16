package pl.sda.ttt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicTacToeMainTest {

    @Test
    void testWinCondition1() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[0][0] = Field.X;
        main.board[0][1] = Field.X;
        main.board[0][2] = Field.X;

        Assertions.assertTrue(main.checkWin());
    }


    @Test
    void testWinCondition2() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[1][0] = Field.X;
        main.board[2][0] = Field.X;
        main.board[0][0] = Field.X;

        Assertions.assertTrue(main.checkWin());
    }


    @Test
    void testWinCondition3() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[0][2] = Field.X;
        main.board[1][2] = Field.X;
        main.board[2][2] = Field.X;

        Assertions.assertTrue(main.checkWin());
    }

    @Test
    void testWinCondition4() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[1][0] = Field.X;
        main.board[1][1] = Field.X;
        main.board[1][2] = Field.X;

        Assertions.assertTrue(main.checkWin());
    }


    @Test
    void testWinCondition5() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[1][0] = Field.X;
        main.board[2][0] = Field.O;
        main.board[0][0] = Field.X;

        Assertions.assertFalse(main.checkWin());
    }


    @Test
    void testWinCondition6() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[0][0] = Field.X;
        main.board[1][1] = Field.X;
        main.board[2][2] = Field.X;

        Assertions.assertTrue(main.checkWin());
    }


    @Test
    void testWinCondition7() {
        TicTacToeMain main = new TicTacToeMain();
        main.board[0][2] = Field.X;
        main.board[1][1] = Field.X;
        main.board[2][0] = Field.X;

        Assertions.assertTrue(main.checkWin());
    }

}